/*
 * This file is generated by jOOQ.
 */
package com.dg.heptensecretsanta.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class NicknameUserMapping implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;
    private Integer roomId;
    private String nickname;

    public NicknameUserMapping() {}

    public NicknameUserMapping(NicknameUserMapping value) {
        this.userId = value.userId;
        this.roomId = value.roomId;
        this.nickname = value.nickname;
    }

    public NicknameUserMapping(
        Integer userId,
        Integer roomId,
        String nickname
    ) {
        this.userId = userId;
        this.roomId = roomId;
        this.nickname = nickname;
    }

    /**
     * Getter for <code>public.nickname_user_mapping.user_id</code>.
     */
    public Integer getUserId() {
        return this.userId;
    }

    /**
     * Setter for <code>public.nickname_user_mapping.user_id</code>.
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * Getter for <code>public.nickname_user_mapping.room_id</code>.
     */
    public Integer getRoomId() {
        return this.roomId;
    }

    /**
     * Setter for <code>public.nickname_user_mapping.room_id</code>.
     */
    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    /**
     * Getter for <code>public.nickname_user_mapping.nickname</code>.
     */
    public String getNickname() {
        return this.nickname;
    }

    /**
     * Setter for <code>public.nickname_user_mapping.nickname</code>.
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final NicknameUserMapping other = (NicknameUserMapping) obj;
        if (this.userId == null) {
            if (other.userId != null)
                return false;
        }
        else if (!this.userId.equals(other.userId))
            return false;
        if (this.roomId == null) {
            if (other.roomId != null)
                return false;
        }
        else if (!this.roomId.equals(other.roomId))
            return false;
        if (this.nickname == null) {
            if (other.nickname != null)
                return false;
        }
        else if (!this.nickname.equals(other.nickname))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.userId == null) ? 0 : this.userId.hashCode());
        result = prime * result + ((this.roomId == null) ? 0 : this.roomId.hashCode());
        result = prime * result + ((this.nickname == null) ? 0 : this.nickname.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("NicknameUserMapping (");

        sb.append(userId);
        sb.append(", ").append(roomId);
        sb.append(", ").append(nickname);

        sb.append(")");
        return sb.toString();
    }
}