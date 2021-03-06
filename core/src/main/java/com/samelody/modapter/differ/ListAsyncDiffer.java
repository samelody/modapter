package com.samelody.modapter.differ;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.recyclerview.extensions.AsyncDifferConfig;
import android.support.v7.recyclerview.extensions.AsyncListDiffer;
import android.support.v7.util.DiffUtil.ItemCallback;
import android.support.v7.util.ListUpdateCallback;
import android.support.v7.widget.RecyclerView.Adapter;

import java.util.List;

/**
 * The {@link AsyncListDiffer} implementation of {@link AsyncDiffer<E>}.
 *
 * @param <E> The type of elements in the list.
 * @author Belin Wu
 */
public class ListAsyncDiffer<E> implements AsyncDiffer<E> {

    /**
     * The real async differ.
     */
    private final AsyncListDiffer<E> differ;

    public ListAsyncDiffer(@NonNull Adapter adapter,
                           @NonNull ItemCallback<E> callback) {
        differ = new AsyncListDiffer<>(adapter, callback);
    }

    public ListAsyncDiffer(@NonNull ListUpdateCallback callback,
                           @NonNull AsyncDifferConfig<E> config) {
        differ = new AsyncListDiffer<>(callback, config);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void submitList(@Nullable List<? extends E> list) {
        differ.submitList((List<E>) list);
    }

    @Override
    public E getItem(int position) {
        return NonAsyncDiffer.getItem(this, position);
    }

    @Override
    public int getItemCount() {
        return getCurrentList().size();
    }

    @Override
    public List<E> getCurrentList() {
        return differ.getCurrentList();
    }
}
