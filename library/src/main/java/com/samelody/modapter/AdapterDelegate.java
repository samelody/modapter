package com.samelody.modapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


/**
 * The delegated implementation of modular adapter.
 *
 * @author Belin Wu
 */
public final class AdapterDelegate implements ItemManager {

    /**
     * The item registry.
     */
    private SparseArray<ItemConfig> registry = new SparseArray<>();

    /**
     * The data list.
     */
    private List<? extends Item> list = new ArrayList<>();

    /**
     * Gets item count.
     *
     * @return The item count.
     */
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    /**
     * {@inheritDoc}
     */
    @Nullable
    @SuppressWarnings("unchecked")
    @Override
    public <T extends Item> T getItem(int position) {
        if (list == null) {
            return null;
        }
        if (position < 0 || position >= list.size()) {
            return null;
        }
        return (T) list.get(position);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemManager setList(List<? extends Item> list) {
        this.list = list;
        return this;
    }

    @NonNull
    @Override
    public <T extends ViewHolder> ItemManager register(int type, Class<T> holderClass) {
        register(type, type, holderClass);
        return this;
    }

    @NonNull
    @Override
    public <T extends ViewHolder> ItemManager register(int type, int layoutId, Class<T> holderClass) {
        ItemConfig config = new ItemConfig();
        config.setType(type);
        config.setLayoutId(layoutId);
        config.setHolderClass(holderClass);
        register(config);
        return this;
    }

    @NonNull
    @Override
    public ItemManager register(ItemConfig config) {
        if (config != null) {
            registry.put(config.getType(), config);
        }
        return this;
    }

    @NonNull
    @Override
    public ItemManager unregister(int type) {
        registry.delete(type);
        return this;
    }

    public int getItemViewType(int position) {
        Item item = getItem(position);
        ItemConfig adapter = null;
        if (item != null) {
            adapter = registry.get(item.getType());
        }
        if (adapter == null) {
            // TODO
            return 0;
        }
        return adapter.getType();
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemConfig adapter = registry.get(viewType);
        if (adapter == null) {
            return null;
        }

        int layoutId = adapter.getLayoutId();
        layoutId = layoutId == 0 ? adapter.getType() : layoutId;
        if (layoutId > 0) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(layoutId, parent, false);
            return createViewHolder(itemView, adapter.getHolderClass());
        }

        return null;
    }

    private <T extends ViewHolder> T createViewHolder(View itemView, Class<T> holderClass) {
        if (itemView == null || holderClass == null) {
            return null;
        }

        try {
            return holderClass.getConstructor(View.class).newInstance(itemView);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Cannot create an instance of " + holderClass, e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Cannot create an instance of " + holderClass, e);
        } catch (InstantiationException e) {
            throw new RuntimeException("Cannot create an instance of " + holderClass, e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException("Cannot create an instance of " + holderClass, e);
        }
    }

    @SuppressWarnings("unchecked")
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = getItem(position);
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder viewHolder = (ItemViewHolder) holder;
            viewHolder.setItem(item);
            viewHolder.onViewBound(item);
        }
    }

    @SuppressWarnings("unchecked")
    public void onViewRecycled(@NonNull ViewHolder holder) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder viewHolder = (ItemViewHolder) holder;
            viewHolder.onViewRecycled();
            viewHolder.setItem(null);
        }
    }

    public void onViewAttachedToWindow(@NonNull ViewHolder holder) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder viewHolder = (ItemViewHolder) holder;
            viewHolder.onViewAttachedToWindow();
        }
    }

    public void onViewDetachedFromWindow(@NonNull ViewHolder holder) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder viewHolder = (ItemViewHolder) holder;
            viewHolder.onViewDetachedFromWindow();
        }
    }
}
