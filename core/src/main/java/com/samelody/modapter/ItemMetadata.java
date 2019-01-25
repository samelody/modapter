package com.samelody.modapter;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView.ViewHolder;

/**
 * A metadata describes the adapter item.
 *
 * @author Belin Wu
 */
public final class ItemMetadata {

    /**
     * The resource id of item layout.
     */
    @LayoutRes
    private int layoutId;

    /**
     * The class object of view holder.
     */
    private Class<? extends ViewHolder> holderClass;

    /**
     * Creates a new item metadata.
     */
    public ItemMetadata() {
    }

    /**
     * Creates a new item metadata.
     *
     * @param layoutId The resource id of item layout.
     * @param holderClass The class of view holder.
     */
    public ItemMetadata(int layoutId, Class<? extends ViewHolder> holderClass) {
        this.layoutId = layoutId;
        this.holderClass = holderClass;
    }

    /**
     * Gets resource id of item layout.
     *
     * @return The resource id of item layout.
     */
    @LayoutRes
    public int getLayoutId() {
        return layoutId;
    }

    /**
     * Sets resource id of item layout.
     *
     * @param layoutId The resource id of item layout.
     */
    public void setLayoutId(@LayoutRes int layoutId) {
        this.layoutId = layoutId;
    }

    /**
     * Gets class object of view holder.
     *
     * @return The class object of view holder.
     */
    public Class<? extends ViewHolder> getHolderClass() {
        return holderClass;
    }

    /**
     * Sets class object of view holder.
     *
     * @param holderClass The class object of view holder.
     */
    public void setHolderClass(Class<? extends ViewHolder> holderClass) {
        this.holderClass = holderClass;
    }
}
