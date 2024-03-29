/*
 * This file is generated by jOOQ.
 */
package com.dg.heptensecretsanta.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RoomUserMapping implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer roomId;
    private Integer userId;
    private Integer giveTo;

    public RoomUserMapping() {}

    public RoomUserMapping(RoomUserMapping value) {
        this.roomId = value.roomId;
        this.userId = value.userId;
        this.giveTo = value.giveTo;
    }

    public RoomUserMapping(
        Integer roomId,
        Integer userId,
        Integer giveTo
    ) {
        this.roomId = roomId;
        this.userId = userId;
        this.giveTo = giveTo;
    }

    /**
     * Getter for <code>public.room_user_mapping.room_id</code>.
     */
    public Integer getRoomId() {
        return this.roomId;
    }

    /**
     * Setter for <code>public.room_user_mapping.room_id</code>.
     */
    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    /**
     * Getter for <code>public.room_user_mapping.user_id</code>.
     */
    public Integer getUserId() {
        return this.userId;
    }

    /**
     * Setter for <code>public.room_user_mapping.user_id</code>.
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * Getter for <code>public.room_user_mapping.give_to</code>.
     */
    public Integer getGiveTo() {
        return this.giveTo;
    }

    /**
     * Setter for <code>public.room_user_mapping.give_to</code>.
     */
    public void setGiveTo(Integer giveTo) {
        this.giveTo = giveTo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final RoomUserMapping other = (RoomUserMapping) obj;
        if (this.roomId == null) {
            if (other.roomId != null)
                return false;
        }
        else if (!this.roomId.equals(other.roomId))
            return false;
        if (this.userId == null) {
            if (other.userId != null)
                return false;
        }
        else if (!this.userId.equals(other.userId))
            return false;
        if (this.giveTo == null) {
            if (other.giveTo != null)
                return false;
        }
        else if (!this.giveTo.equals(other.giveTo))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.roomId == null) ? 0 : this.roomId.hashCode());
        result = prime * result + ((this.userId == null) ? 0 : this.userId.hashCode());
        result = prime * result + ((this.giveTo == null) ? 0 : this.giveTo.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("RoomUserMapping (");

        sb.append(roomId);
        sb.append(", ").append(userId);
        sb.append(", ").append(giveTo);

        sb.append(")");
        return sb.toString();
    }
}
