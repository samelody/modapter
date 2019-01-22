package com.samelody.modapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;

/**
 * A modular adapter for {@link RecyclerView}.
 *
 * @author Belin Wu
 */
public class ModularAdapter extends RecyclerView.Adapter<ViewHolder> {

    /**
     * The delegated implementation.
     */
    private AdapterDelegate delegate = new AdapterDelegate();

    @Override
    public int getItemViewType(int position) {
        return delegate.getItemViewType(position);
    }

    @Override
    public final int getItemCount() {
        return delegate.getItemCount();
    }

    @NonNull
    @Override
    public final ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return delegate.onCreateViewHolder(parent, viewType);
    }

    @Override
    public final void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        delegate.onBindViewHolder(holder, position);
    }

    @Override
    public final void onViewRecycled(@NonNull ViewHolder holder) {
        super.onViewRecycled(holder);
        delegate.onViewRecycled(holder);
    }

    @Override
    public final void onViewAttachedToWindow(@NonNull ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        delegate.onViewAttachedToWindow(holder);
    }

    @Override
    public final void onViewDetachedFromWindow(@NonNull ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        delegate.onViewDetachedFromWindow(holder);
    }

    /**
     * Gets item manager.
     *
     * @return The item manager.
     */
    public ItemManager getManager() {
        return delegate;
    }
}

