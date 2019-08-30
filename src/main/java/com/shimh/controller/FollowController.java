package com.shimh.controller;

import com.shimh.common.annotation.LogAnnotation;
import com.shimh.common.constant.ResultCode;
import com.shimh.common.result.Result;
import com.shimh.entity.Follow;
import com.shimh.service.FollowService;
import com.shimh.service.UserService;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author bryantma
 * @version 1.0
 * @since 8/28/2019
 **/
@RestController
@RequestMapping(value = "/follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}/{followerId}")
    @RequiresAuthentication
    @LogAnnotation(module = "关注", operation = "关注用户")
    public Result followUser(@PathVariable("userId") Long userId, @PathVariable("followerId") Long followerId) {
        System.out.println("" + userId + " " + followerId);
        boolean state = followService.follow(userId, followerId);
        if (state) {
            return Result.success();
        } else {
            return Result.error(ResultCode.DATA_ALREADY_EXISTED, "Already followed or other inner error");
        }
    }

    @GetMapping("/followList/{userId}")
    @RequiresAuthentication
    @LogAnnotation(module = "关注", operation = "返回关注列表")
    public Result getFollowList(@PathVariable("userId") String userName) {
        Long userId = userService.getUserByAccount(userName).getId();
        List<Follow> followList = followService.getMyFollowing(userId);
        return Result.success(followList);
    }

    @GetMapping("/unfollow/{userId}/{unFollowerId}")
    @RequiresAuthentication
    @LogAnnotation(module = "取消关注", operation = "取关用户")
    public Result unfollowUser(@PathVariable("userId") Long userId, @PathVariable("unFollowerId") Long unFollowerId) {
        boolean state = followService.unfollow(userId, unFollowerId);
        if (state) {
            return Result.success();
        } else {
            return Result.error(ResultCode.DATA_ALREADY_EXISTED, "Already followed or other inner error");
        }
    }
}
