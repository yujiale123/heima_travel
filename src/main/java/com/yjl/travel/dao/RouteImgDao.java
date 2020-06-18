package com.yjl.travel.dao;

import com.yjl.travel.domain.RouteImg;

import java.util.List;

/**
 * @author yjl
 * @create 2020-06-18-15:46
 **/
public interface RouteImgDao {
    /**
     * 根据route的id查询图片
     * @param rid
     * @return
     */
    List<RouteImg> findByRid(int rid);
}
