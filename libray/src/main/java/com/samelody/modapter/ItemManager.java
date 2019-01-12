package com.samelody.modapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.ViewHolder;

import java.util.List;

/**
 * The item manager.
 *
 * @author Belin Wu
 */
public interface ItemManager {

    /**
     * Sets the data list.
     *
     * @param list The data list.
     * @return this item manager.
     */
    @NonNull
    ItemManager setList(List<? extends Item> list);

    @NonNull
    <T extends ViewHolder> ItemManager register(int type, Class<T> holderClass);

    @NonNull
    <T extends ViewHolder> ItemManager register(int type, @LayoutRes int layoutId, Class<T> holderClass);

    @NonNull
    ItemManager register(ItemConfig config);

    @NonNull
    ItemManager unregister(int type);

    /**
     * Gets the item at the given position.
     *
     * @param position The position of item.
     * @param <T> The type of item.
     * @return The item at the given position.
     */
    @Nullable
    <T extends Item> T getItem(int position);
}
