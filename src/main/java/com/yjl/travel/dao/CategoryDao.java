package com.yjl.travel.dao;

import com.yjl.travel.domain.Category;

import java.util.List;

/**
 * @author yjl
 * @create 2020-06-18-15:46
 **/
public interface CategoryDao {
    /**
     * 查询所有
     * @return
     */
    public List<Category> findAll();
}
