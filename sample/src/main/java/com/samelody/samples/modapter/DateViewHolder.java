package com.samelody.samples.modapter;

import android.support.annotation.NonNull;
import android.view.View;

import com.samelody.modapter.ItemViewHolder;

public class DateViewHolder extends ItemViewHolder<DateItem> {

    public DateViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    protected void onViewBound(DateItem item) {
        super.onViewBound(item);

    }
}
