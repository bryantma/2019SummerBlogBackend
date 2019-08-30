package com.shimh.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.shimh.common.entity.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;

/**
 * @author MDC
 * @version 1.0
 * @since 8/28/2019
 **/

@Entity
@Table(name = "sys_follow")
public class Follow extends BaseEntity<Long> {

    private static final long serialVersionUID = -48271398732891778L;

    @NotNull
    @Column(name = "user_id", length = 20)
    private Long userId;

    @NotNull
    @Column(name = "follower_id", length = 20)
    private Long followerId;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "time_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Follow() {}

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Follow(Long userId, Long followerId) {
        this.userId = userId;
        this.followerId = followerId;
    }

    public Long getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Long followerId) {
        this.followerId = followerId;
    }

    @Override
    public String toString() {
        return "Follow [user_id=" + userId + ", follower_id=" + followerId + ", date_created=" + dateCreated + "]";
    }
}
