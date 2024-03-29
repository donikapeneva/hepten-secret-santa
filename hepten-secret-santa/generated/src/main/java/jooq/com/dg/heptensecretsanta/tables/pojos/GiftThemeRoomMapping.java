/*
 * This file is generated by jOOQ.
 */
package com.dg.heptensecretsanta.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class GiftThemeRoomMapping implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer giftThemeId;
    private Integer roomId;

    public GiftThemeRoomMapping() {}

    public GiftThemeRoomMapping(GiftThemeRoomMapping value) {
        this.giftThemeId = value.giftThemeId;
        this.roomId = value.roomId;
    }

    public GiftThemeRoomMapping(
        Integer giftThemeId,
        Integer roomId
    ) {
        this.giftThemeId = giftThemeId;
        this.roomId = roomId;
    }

    /**
     * Getter for <code>public.gift_theme_room_mapping.gift_theme_id</code>.
     */
    public Integer getGiftThemeId() {
        return this.giftThemeId;
    }

    /**
     * Setter for <code>public.gift_theme_room_mapping.gift_theme_id</code>.
     */
    public void setGiftThemeId(Integer giftThemeId) {
        this.giftThemeId = giftThemeId;
    }

    /**
     * Getter for <code>public.gift_theme_room_mapping.room_id</code>.
     */
    public Integer getRoomId() {
        return this.roomId;
    }

    /**
     * Setter for <code>public.gift_theme_room_mapping.room_id</code>.
     */
    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final GiftThemeRoomMapping other = (GiftThemeRoomMapping) obj;
        if (this.giftThemeId == null) {
            if (other.giftThemeId != null)
                return false;
        }
        else if (!this.giftThemeId.equals(other.giftThemeId))
            return false;
        if (this.roomId == null) {
            if (other.roomId != null)
                return false;
        }
        else if (!this.roomId.equals(other.roomId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.giftThemeId == null) ? 0 : this.giftThemeId.hashCode());
        result = prime * result + ((this.roomId == null) ? 0 : this.roomId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GiftThemeRoomMapping (");

        sb.append(giftThemeId);
        sb.append(", ").append(roomId);

        sb.append(")");
        return sb.toString();
    }
}
