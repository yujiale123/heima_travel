package com.yjl.travel.service;

import com.yjl.travel.domain.PageBean;
import com.yjl.travel.domain.Route;

/**
 * @author yjl
 * @create 2020-06-18-15:51
 **/
public interface RouteService {
    /**
     * 根据类别进行分页查询
     * @param cid
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname);

    /**
     * 根据id查询
     * @param rid
     * @return
     */
    Route findOne(String rid);
}
