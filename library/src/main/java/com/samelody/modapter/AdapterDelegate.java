package com.samelody.modapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;


/**
 * The delegated implementation of modular adapter.
 *
 * @author Belin Wu
 */
public final class AdapterDelegate implements ItemManager {

    /**
     * The item metadata registry.
     */
    private SparseArray<ItemMetadata> registry = new SparseArray<>();

    /**
     * The list of items.
     */
    @NonNull
    private List<? extends AdapterItem> list = emptyList();

    /**
     * Gets item count.
     *
     * @return The item count.
     */
    public int getItemCount() {
        return list.size();
    }

    /**
     * {@inheritDoc}
     */
    @Nullable
    @SuppressWarnings("unchecked")
    @Override
    public <T extends AdapterItem> T getItem(int position) {
        if (position < 0 || position >= list.size()) {
            return null;
        }
        return (T) list.get(position);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemManager setList(List<? extends AdapterItem> list) {
        this.list = list == null ? Collections.<AdapterItem>emptyList() : list;
        return this;
    }

    @NonNull
    @Override
    public <T extends ViewHolder> ItemManager register(int layoutId, Class<T> holderClass) {
        ItemMetadata metadata = new ItemMetadata();
        metadata.setLayoutId(layoutId);
        metadata.setHolderClass(holderClass);
        register(metadata);
        return this;
    }

    @NonNull
    @Override
    public ItemManager register(ItemMetadata metadata) {
        if (metadata != null) {
            registry.put(metadata.getLayoutId(), metadata);
        }
        return this;
    }

    @NonNull
    @Override
    public ItemManager unregister(int layoutId) {
        registry.delete(layoutId);
        return this;
    }

    public int getItemViewType(int position) {
        AdapterItem item = getItem(position);
        ItemMetadata metadata = null;
        if (item != null) {
            metadata = registry.get(item.getLayoutId());
        }
        if (metadata == null) {
            // TODO
            return 0;
        }
        return metadata.getLayoutId();
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemMetadata metadata = registry.get(viewType);
        if (metadata == null) {
            return null;
        }

        int layoutId = metadata.getLayoutId();
        if (layoutId > 0) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(layoutId, parent, false);
            return createViewHolder(itemView, metadata.getHolderClass());
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
        AdapterItem item = getItem(position);
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
