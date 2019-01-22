package com.samelody.modapter;

/**
 * The abstract implementation of the {@link AdapterItem} interface.
 *
 * @author Belin Wu
 */
public abstract class AbstractItem implements AdapterItem {

    /**
     * The type of item.
     */
    private int type;

    /**
     * {@inheritDoc}
     */
    @Override
    public void setType(int type) {
        this.type = type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getType() {
        return type;
    }
}
