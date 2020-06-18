package com.yjl.travel.dao.Impl;

import com.yjl.travel.dao.CategoryDao;
import com.yjl.travel.domain.Category;
import com.yjl.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author yjl
 * @create 2020-06-18-15:48
 **/
public class CategoryDaoImpl implements CategoryDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Category> findAll() {
        String sql = "select * from tab_category";

        return template.query(sql,
                new BeanPropertyRowMapper<Category>(Category.class));
    }
}
