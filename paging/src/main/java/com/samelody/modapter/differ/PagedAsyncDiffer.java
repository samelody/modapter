package com.samelody.modapter.differ;

import android.arch.paging.AsyncPagedListDiffer;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.recyclerview.extensions.AsyncDifferConfig;
import android.support.v7.util.DiffUtil.ItemCallback;
import android.support.v7.util.ListUpdateCallback;
import android.support.v7.widget.RecyclerView.Adapter;

import java.util.List;

/**
 * The {@link AsyncPagedListDiffer} implementation of {@link AsyncDiffer<E>}.
 *
 * @param <E> The type of elements in the list.
 * @author Belin Wu
 */
public class PagedAsyncDiffer<E> implements AsyncDiffer<E> {

    /**
     * The real async differ.
     */
    private final AsyncPagedListDiffer<E> differ;

    public PagedAsyncDiffer(@NonNull Adapter adapter,
                            @NonNull ItemCallback<E> callback) {
        differ = new AsyncPagedListDiffer<>(adapter, callback);
    }

    public PagedAsyncDiffer(@NonNull ListUpdateCallback callback,
                            @NonNull AsyncDifferConfig<E> config) {
        differ = new AsyncPagedListDiffer<>(callback, config);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void submitList(@Nullable List<? extends E> list) {
        if (list instanceof PagedList) {
            differ.submitList((PagedList<E>) list);
            return;
        }
        throw new IllegalArgumentException("list is not a PagedList");
    }

    @Override
    public E getItem(int position) {
        return NonAsyncDiffer.getItem(this, position);
    }

    @Override
    public int getItemCount() {
        return differ.getItemCount();
    }

    @Override
    public List<E> getCurrentList() {
        return differ.getCurrentList();
    }
}
