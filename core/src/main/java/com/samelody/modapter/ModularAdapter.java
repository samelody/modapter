package com.samelody.modapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;

import com.samelody.modapter.differ.AsyncDiffer;

/**
 * A modular list adapter for presenting List data in a {@link RecyclerView}, including computing
 * diffs between Lists on a background thread by {@link AsyncDiffer<E>}.
 *
 * @param <E> The type of elements in the list.
 * @author Belin Wu
 */
public class ModularAdapter<E extends AdapterItem> extends Adapter<ViewHolder> {

    /**
     * The delegated implementation.
     */
    private AdapterDelegate<E> delegate = new AdapterDelegate<>();

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
    public ItemManager<E> getManager() {
        return delegate;
    }
}

