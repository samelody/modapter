package com.samelody.modapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.ViewHolder;

import java.util.List;

/**
 * A item manager implements register, unregister and other managing operations.
 *
 * @author Belin Wu
 */
public interface ItemManager {

    /**
     * Sets the list of items.
     *
     * @param list The list of items.
     * @return this item manager.
     */
    @NonNull
    ItemManager setList(List<? extends AdapterItem> list);

    /**
     * Registers the item metadata.
     *
     * @param layoutId The resource id of item layout.
     * @param holderClass The class of view holder.
     * @param <T> The type of view holder.
     * @return this item manager.
     */
    @NonNull
    <T extends ViewHolder> ItemManager register(@LayoutRes int layoutId, Class<T> holderClass);

    /**
     * Registers the item metadata.
     *
     * @param metadata The item metadata.
     * @return this item manager.
     */
    @NonNull
    ItemManager register(ItemMetadata metadata);

    /**
     * Unregisters the item metadata.
     *
     * @param layoutId The resource id of item layout.
     * @return this item manager.
     */
    @NonNull
    ItemManager unregister(@LayoutRes int layoutId);

    /**
     * Gets the item at the given position.
     *
     * @param position The position of item.
     * @param <T> The type of item.
     * @return The item at the given position.
     */
    @Nullable
    <T extends AdapterItem> T getItem(int position);
}
