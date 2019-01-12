package com.samelody.samples.modapter;

import android.support.annotation.NonNull;
import android.view.View;

import com.samelody.modapter.ItemViewHolder;


/**
 * @author Belin Wu
 */
public class ImageViewHolder extends ItemViewHolder<ImageItem> {

    public ImageViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    protected void onViewBound(ImageItem item) {
        super.onViewBound(item);


    }
}
