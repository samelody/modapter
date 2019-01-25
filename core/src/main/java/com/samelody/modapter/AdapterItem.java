package com.samelody.modapter;

import android.support.annotation.LayoutRes;

/**
 * The interface represents the item in a adapter.
 *
 * @author Belin Wu
 */
public interface AdapterItem {

    /**
     * Sets resource id of item layout.
     *
     * @param layoutId The resource id of item layout.
     */
    void setLayoutId(@LayoutRes int layoutId);

    /**
     * Gets resource id of item layout.
     *
     * @return The resource id of item layout.
     */
    @LayoutRes
    int getLayoutId();
}
