package com.shimh.service;

import com.shimh.entity.Tag;
import com.shimh.vo.TagVO;

import java.util.List;

public interface TagService {

    List<Tag> findAll();

    Tag getTagById(Integer id);

    Integer saveTag(Tag tag);

    Integer updateTag(Tag tag);

    void deleteTagById(Integer id);

    List<Tag> listHotTags(int limit);

    List<TagVO> findAllDetail();

    TagVO getTagDetail(Integer tagId);
}
