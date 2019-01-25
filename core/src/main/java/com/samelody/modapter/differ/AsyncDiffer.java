package com.samelody.modapter.differ;

import android.support.annotation.Nullable;

import java.util.List;

/**
 * The async differ.
 *
 * @param <E> The type of elements in the list.
 * @author Belin Wu
 */
public interface AsyncDiffer<E> {

    /**
     * Submits the new list to be displayed.
     *
     * @param list The new list to be displayed.
     */
    void submitList(@Nullable List<? extends E> list);

    /**
     * Get the item from the current list at the specified index.
     *
     * @param position The position of item.
     * @return The item at the given position.
     */
    E getItem(int position);

    /**
     * Gets item count of current list.
     *
     * @return The item count of current list.
     */
    int getItemCount();

    /**
     * Gets the list currently being displayed by the Adapter.
     *
     * @return The list currently being displayed.
     */
    List<E> getCurrentList();
}
