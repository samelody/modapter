package com.samelody.modapter;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView.ViewHolder;

/**
 * This class represents item configuration in registry.
 *
 * @author Belin Wu
 */
public final class ItemConfig {

    /**
     * The type of item.
     */
    private int type;

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
     * Sets type of item.
     *
     * @param type The type of item.
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * Gets type of item.
     *
     * @return The type of item.
     */
    public int getType() {
        return this.type;
    }

    /**
     * Gets class object of view holder.
     *
     * @return The class object of view holder.
     */
    Class<? extends ViewHolder> getHolderClass() {
        return holderClass;
    }

    /**
     * Sets class object of view holder.
     *
     * @param holderClass The class object of view holder.
     */
    void setHolderClass(Class<? extends ViewHolder> holderClass) {
        this.holderClass = holderClass;
    }
}
