package com.shimh.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.shimh.common.entity.BaseEntity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;

/**
 * @author bryantma
 * @version 1.0
 * @since 8/28/2019
 **/

@Entity
@Table(name = "sys_like")
public class Like extends BaseEntity<Long> {

    private static final long serialVersionUID = -491778913278912738L;

    @NotNull
    @Column(name = "user_id", length = 20)
    private Long userId;

    @NotNull
    @Column(name = "article_id", length = 11)
    private Long articleId;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "time_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Like() {}

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

    public Like(Long userId, Long articleId) {
        this.userId = userId;
        this.articleId = articleId;
    }

    public Long getArticleId() {
        return articleId;
    }

    //public void setFollowerId(Long followerId) {
    //    this.followerId = followerId;
    //}

    @Override
    public String toString() {
        return "Like [user_id=" + userId + ", article_id=" + articleId + ", date_created=" + dateCreated + "]";
    }
}
