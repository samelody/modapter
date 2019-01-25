package com.samelody.modapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

/**
 * A holder with bound data item for item view.
 *
 * @param <T> The type of data item.
 * @author Belin Wu
 */
public abstract class ItemViewHolder<T extends AdapterItem> extends ViewHolder {

    /**
     * The data item bound with this view holder.
     */
    @Nullable
    protected T item;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    void setItem(@Nullable T item) {
        this.item = item;
    }

    /**
     * Called when item view has been bound.
     *
     * @param item The data item bound within this view holder.
     */
    protected void onViewBound(T item) {
        // empty
    }

    /**
     * Called when item view has been recycled.
     */
    protected void onViewRecycled() {
        // empty
    }

    /**
     * Called when item view has been attached to a window.
     */
    protected void onViewAttachedToWindow() {
        // empty
    }

    /**
     * Called when item view has been detached from its window.
     */
    protected void onViewDetachedFromWindow() {
        // empty
    }
}
