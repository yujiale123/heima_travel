package com.yjl.travel.service;

import com.yjl.travel.domain.Category;

import java.util.List;

/**
 * @author yjl
 * @create 2020-06-18-15:51
 **/
public interface CategoryService {
    /**
     * 查询所有类型
     * @return
     */
    List<Category> findAll();
}
