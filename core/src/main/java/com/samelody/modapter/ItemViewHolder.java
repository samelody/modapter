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
public abstract class ItemViewHolder<T extends AdapterItem>
        extends ViewHolder
        implements View.OnClickListener, View.OnLongClickListener {

    /**
     * The data item bound with this view holder.
     */
    @Nullable
    private T item;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    /**
     * Sets the data item bound with this view holder.
     *
     * @param item The data item.
     */
    void setItem(@Nullable T item) {
        this.item = item;
    }

    /**
     * Gets the data item bound with this view holder.
     *
     * @return The data item.
     */
    @Nullable
    public T getItem() {
        return item;
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

    /**
     * Called when the item view is clicked.
     *
     * @param itemView The item view.
     */
    @Override
    public void onClick(View itemView) {
        // empty
    }

    /**
     * Called when the item view has been clicked and held.
     *
     * @param itemView The item view.
     *
     * @return true if the callback consumed the long click, false otherwise.
     */
    @Override
    public boolean onLongClick(View itemView) {
        return false;
    }
}
