package com.shimh.entity;

import com.shimh.common.entity.BaseEntity;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "me_avatar")
public class Avatar extends BaseEntity<Integer> {

    private static final long serialVersionUID = -9823790173091782L;

    @NotBlank
    private String username;

    @NotBlank
    private String avatar;

    public String getusername() {
        return username;
    }

    public void setTagname(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
