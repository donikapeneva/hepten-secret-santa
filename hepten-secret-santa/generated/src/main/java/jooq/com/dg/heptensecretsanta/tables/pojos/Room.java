/*
 * This file is generated by jOOQ.
 */
package com.dg.heptensecretsanta.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String roomName;
    private String passCode;
    private Integer userId;
    private String budget;
    private Integer nicknameThemeId;
    private String status;
    private Boolean reveal;

    public Room() {}

    public Room(Room value) {
        this.id = value.id;
        this.roomName = value.roomName;
        this.passCode = value.passCode;
        this.userId = value.userId;
        this.budget = value.budget;
        this.nicknameThemeId = value.nicknameThemeId;
        this.status = value.status;
        this.reveal = value.reveal;
    }

    public Room(
        Integer id,
        String roomName,
        String passCode,
        Integer userId,
        String budget,
        Integer nicknameThemeId,
        String status,
        Boolean reveal
    ) {
        this.id = id;
        this.roomName = roomName;
        this.passCode = passCode;
        this.userId = userId;
        this.budget = budget;
        this.nicknameThemeId = nicknameThemeId;
        this.status = status;
        this.reveal = reveal;
    }

    /**
     * Getter for <code>public.room.id</code>.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.room.id</code>.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for <code>public.room.room_name</code>.
     */
    public String getRoomName() {
        return this.roomName;
    }

    /**
     * Setter for <code>public.room.room_name</code>.
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    /**
     * Getter for <code>public.room.pass_code</code>.
     */
    public String getPassCode() {
        return this.passCode;
    }

    /**
     * Setter for <code>public.room.pass_code</code>.
     */
    public void setPassCode(String passCode) {
        this.passCode = passCode;
    }

    /**
     * Getter for <code>public.room.user_id</code>.
     */
    public Integer getUserId() {
        return this.userId;
    }

    /**
     * Setter for <code>public.room.user_id</code>.
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * Getter for <code>public.room.budget</code>.
     */
    public String getBudget() {
        return this.budget;
    }

    /**
     * Setter for <code>public.room.budget</code>.
     */
    public void setBudget(String budget) {
        this.budget = budget;
    }

    /**
     * Getter for <code>public.room.nickname_theme_id</code>.
     */
    public Integer getNicknameThemeId() {
        return this.nicknameThemeId;
    }

    /**
     * Setter for <code>public.room.nickname_theme_id</code>.
     */
    public void setNicknameThemeId(Integer nicknameThemeId) {
        this.nicknameThemeId = nicknameThemeId;
    }

    /**
     * Getter for <code>public.room.status</code>.
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * Setter for <code>public.room.status</code>.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Getter for <code>public.room.reveal</code>.
     */
    public Boolean getReveal() {
        return this.reveal;
    }

    /**
     * Setter for <code>public.room.reveal</code>.
     */
    public void setReveal(Boolean reveal) {
        this.reveal = reveal;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Room other = (Room) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.roomName == null) {
            if (other.roomName != null)
                return false;
        }
        else if (!this.roomName.equals(other.roomName))
            return false;
        if (this.passCode == null) {
            if (other.passCode != null)
                return false;
        }
        else if (!this.passCode.equals(other.passCode))
            return false;
        if (this.userId == null) {
            if (other.userId != null)
                return false;
        }
        else if (!this.userId.equals(other.userId))
            return false;
        if (this.budget == null) {
            if (other.budget != null)
                return false;
        }
        else if (!this.budget.equals(other.budget))
            return false;
        if (this.nicknameThemeId == null) {
            if (other.nicknameThemeId != null)
                return false;
        }
        else if (!this.nicknameThemeId.equals(other.nicknameThemeId))
            return false;
        if (this.status == null) {
            if (other.status != null)
                return false;
        }
        else if (!this.status.equals(other.status))
            return false;
        if (this.reveal == null) {
            if (other.reveal != null)
                return false;
        }
        else if (!this.reveal.equals(other.reveal))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.roomName == null) ? 0 : this.roomName.hashCode());
        result = prime * result + ((this.passCode == null) ? 0 : this.passCode.hashCode());
        result = prime * result + ((this.userId == null) ? 0 : this.userId.hashCode());
        result = prime * result + ((this.budget == null) ? 0 : this.budget.hashCode());
        result = prime * result + ((this.nicknameThemeId == null) ? 0 : this.nicknameThemeId.hashCode());
        result = prime * result + ((this.status == null) ? 0 : this.status.hashCode());
        result = prime * result + ((this.reveal == null) ? 0 : this.reveal.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Room (");

        sb.append(id);
        sb.append(", ").append(roomName);
        sb.append(", ").append(passCode);
        sb.append(", ").append(userId);
        sb.append(", ").append(budget);
        sb.append(", ").append(nicknameThemeId);
        sb.append(", ").append(status);
        sb.append(", ").append(reveal);

        sb.append(")");
        return sb.toString();
    }
}
