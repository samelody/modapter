package com.samelody.samples.modapter;

import com.samelody.modapter.AbstractItem;

/**
 * The image item in a gallery.
 *
 * @author Belin Wu
 */
public class ImageItem extends AbstractItem {

    private String imageUrl;

    private String title;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
