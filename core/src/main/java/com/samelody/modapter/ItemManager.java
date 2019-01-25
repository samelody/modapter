package com.samelody.modapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.ViewHolder;

import com.samelody.modapter.differ.AsyncDiffer;

import java.util.List;

/**
 * A item manager implements register, unregister and other managing operations.
 *
 * @param <E> The type of elements in the list.
 * @author Belin Wu
 */
public interface ItemManager<E> {

    /**
     * Sets the async differ.
     *
     * @param differ The async differ.
     * @return this item manager.
     */
    ItemManager<E> setDiffer(AsyncDiffer<E> differ);

    /**
     * Submits the list of items.
     *
     * @param list The list of items.
     * @return this item manager.
     */
    @NonNull
    ItemManager<E> submitList(List<? extends E> list);

    /**
     * Gets the list currently being displayed.
     *
     * @return The list.
     */
    List<E> getCurrentList();

    /**
     * Gets the item at the given position.
     *
     * @param position The position of item.
     * @return The item at the given position.
     */
    @Nullable
    E getItem(int position);

    /**
     * Registers the item metadata.
     *
     * @param layoutId The resource id of item layout.
     * @param holderClass The class of view holder.
     * @return this item manager.
     */
    @NonNull
    ItemManager<E> register(@LayoutRes int layoutId, Class<? extends ViewHolder> holderClass);

    /**
     * Registers the item metadata.
     *
     * @param metadata The item metadata.
     * @return this item manager.
     */
    @NonNull
    ItemManager<E> register(ItemMetadata metadata);

    /**
     * Unregisters the item metadata.
     *
     * @param layoutId The resource id of item layout.
     * @return this item manager.
     */
    @NonNull
    ItemManager<E> unregister(@LayoutRes int layoutId);
}
