package com.shimh.service;


import com.shimh.entity.Follow;

import java.util.List;

public interface FollowService {
    boolean follow(Long userId, Long followerId);

    boolean unfollow(Long userId, Long followerId);

    boolean isFollowing(Long userId, Long followerId);

    List<Follow> getMyFollowing(Long userId);

    List<Follow> getMyFans(Long followerId);

    Long saveFollow(Follow follow);

    Follow getFollowById(Long id);

    void deleteFollowById(Long id);
}

