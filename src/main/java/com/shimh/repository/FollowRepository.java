package com.shimh.repository;

import com.shimh.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    List<Follow> findAllByUserId(Long userId);

    List<Follow> findAllByFollowerId(Long followerId);

    Follow findByUserIdAndFollowerId(Long userId, Long followerId);

    void deleteAllByUserIdAndFollowerId(Long userId, Long followerId);
}
