package com.samelody.modapter;

/**
 * The interface represents the item in a adapter.
 *
 * @author Belin Wu
 */
public interface AdapterItem {

    /**
     * Sets type of item.
     *
     * @param type The type of item.
     */
    void setType(int type);

    /**
     * Gets type of item.
     *
     * @return The type of item.
     */
    int getType();
}
