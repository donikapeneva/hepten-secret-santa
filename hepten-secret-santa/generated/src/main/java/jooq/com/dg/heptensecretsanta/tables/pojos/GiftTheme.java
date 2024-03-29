/*
 * This file is generated by jOOQ.
 */
package com.dg.heptensecretsanta.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class GiftTheme implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String category;
    private String attributes;

    public GiftTheme() {}

    public GiftTheme(GiftTheme value) {
        this.id = value.id;
        this.category = value.category;
        this.attributes = value.attributes;
    }

    public GiftTheme(
        Integer id,
        String category,
        String attributes
    ) {
        this.id = id;
        this.category = category;
        this.attributes = attributes;
    }

    /**
     * Getter for <code>public.gift_theme.id</code>.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.gift_theme.id</code>.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for <code>public.gift_theme.category</code>.
     */
    public String getCategory() {
        return this.category;
    }

    /**
     * Setter for <code>public.gift_theme.category</code>.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Getter for <code>public.gift_theme.attributes</code>.
     */
    public String getAttributes() {
        return this.attributes;
    }

    /**
     * Setter for <code>public.gift_theme.attributes</code>.
     */
    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final GiftTheme other = (GiftTheme) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.category == null) {
            if (other.category != null)
                return false;
        }
        else if (!this.category.equals(other.category))
            return false;
        if (this.attributes == null) {
            if (other.attributes != null)
                return false;
        }
        else if (!this.attributes.equals(other.attributes))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.category == null) ? 0 : this.category.hashCode());
        result = prime * result + ((this.attributes == null) ? 0 : this.attributes.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GiftTheme (");

        sb.append(id);
        sb.append(", ").append(category);
        sb.append(", ").append(attributes);

        sb.append(")");
        return sb.toString();
    }
}
