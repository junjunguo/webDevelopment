package com.junjunguo.tsag.model;

import javax.persistence.*;

/**
 * Created by GuoJunjun <junjunguo.com> on 16/10/15.
 */
@Entity
@Table(name = "USER_TAG", uniqueConstraints = {@UniqueConstraint(columnNames = {"USER_ID", "TAG_ID"})})
public class UserTag {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;
    @Column(name = "USER_ID", nullable = false)
    private int userId;
    @Column(name = "TAG_ID", nullable = false)
    private int tagId;

    public UserTag(int userId, int tagId) {
        this.userId = userId;
        this.tagId = tagId;
    }

    public int getId() {
        return id;
    }


    public int getUserId() {
        return userId;
    }

    void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTagId() {
        return tagId;
    }

    void setTagId(int tagId) {
        this.tagId = tagId;
    }
}
