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

    void submitList(@Nullable List<? extends E> list);

    E getItem(int position);

    int getItemCount();

    List<E> getCurrentList();
}
