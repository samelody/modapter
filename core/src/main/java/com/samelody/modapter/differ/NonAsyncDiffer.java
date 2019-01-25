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

    @Override
    public void submitList(@Nullable List<? extends E> list) {
        this.list = list == null ? Collections.<E>emptyList() : (List<E>) list;
    }

    @Override
    public E getItem(int position) {
        if (position < 0 || position >= list.size()) {
            return null;
        }
        return list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public List<E> getCurrentList() {
        return unmodifiableList(list);
    }
}
