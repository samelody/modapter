package com.samelody.modapter.differ;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;

/**
 * The non implementation of {@link AsyncDiffer<E>}.
 *
 * @param <E> The type of elements in the list.
 * @author Belin Wu
 */
public class NonAsyncDiffer<E> implements AsyncDiffer<E> {

    /**
     * The list of items.
     */
    @NonNull
    private List<E> list = emptyList();

    @SuppressWarnings("unchecked")
    @Override
    public void submitList(@Nullable List<? extends E> list) {
        this.list = list == null ? Collections.<E>emptyList() : (List<E>) list;
    }

    @Override
    public E getItem(int position) {
        return getItem(this, position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public List<E> getCurrentList() {
        return unmodifiableList(list);
    }

    /**
     * Gets the item with given position from given differ.
     *
     * @param differ The async differ.
     * @param position The position of item.
     * @param <E> The type of item.
     * @return The item at given position.
     */
    @Nullable
    public static <E> E getItem(AsyncDiffer<E> differ, int position) {
        if (differ == null) {
            return null;
        }

        List<E> list = differ.getCurrentList();
        if (list == null || position < 0 || position >= list.size()) {
            return null;
        }

        return list.get(position);
    }
}
