package com.shimh.repository;

import com.shimh.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author bryantma
 * @version 1.0
 * @since 8/28/2019
 **/
public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findAllByUserId(Long userId);

    List<Like> findAllByArticleId(Long ArticleId);

    Like findByUserIdAndArticleId(Long userId, Long articleId);

    void deleteAllByUserIdAndArticleId(Long userId, Long articleId);

}
