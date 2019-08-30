package com.shimh.service.impl;

import com.shimh.entity.Like;
import com.shimh.repository.LikeRepository;
import com.shimh.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author bryantma
 * @version 1.0
 * @since 8/28/2019
 **/
@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Override
    public boolean hasLiked(Long userId, Long articleId) {
        Like found = likeRepository.findByUserIdAndArticleId(userId, articleId);
        return found != null;
    }

    @Override
    public List<Like> getMyLikes(Long userId) {
        return likeRepository.findAllByUserId(userId);
    }

    @Override
    public List<Like> getArticleLikes(Long articleId) {
        return likeRepository.findAllByArticleId(articleId);
    }


    @Override
    @Transactional
    public boolean like(Long userId, Long articleId) {
        if (!hasLiked(userId, articleId)) {
            likeRepository.save(new Like(userId, articleId));
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean unlike(Long userId, Long articleId) {
        if (hasLiked(userId, articleId)) {
            likeRepository.deleteAllByUserIdAndArticleId(userId, articleId);
            return true;
        }
        return false;
    }

    /**
    @Override
    @Transactional
    public Long saveFollow(Follow follow) {
        return followRepository.save(follow).getId();
    }

    @Override
    public void deleteFollowById(Long id) {
        followRepository.delete(id);
    }

    @Override
    public Follow getFollowById(Long id) {
        return followRepository.getOne(id);
    }
    */
}
