package com.samelody.modapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

/**
 *
 *
 * @param <T> The type of item.
 * @author Belin Wu
 */
public abstract class ItemViewHolder<T extends Item> extends ViewHolder {

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

    protected void onViewBound(T item) {
        // empty
    }

    protected void onViewRecycled() {
        // empty
    }

    protected void onViewAttachedToWindow() {
        // empty
    }

    protected void onViewDetachedFromWindow() {
        // empty
    }
}
