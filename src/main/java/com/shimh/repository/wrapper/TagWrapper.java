package com.shimh.repository.wrapper;

import com.shimh.vo.TagVO;

import java.util.List;


public interface TagWrapper {

    List<TagVO> findAllDetail();

    TagVO getTagDetail(Integer tagId);
}
