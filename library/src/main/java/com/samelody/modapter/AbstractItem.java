package com.samelody.modapter;

/**
 * The abstract implementation of the {@link AdapterItem} interface.
 *
 * @author Belin Wu
 */
public abstract class AbstractItem implements AdapterItem {

    /**
     * The resource id of item layout.
     */
    private int layoutId;

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getLayoutId() {
        return layoutId;
    }
}
