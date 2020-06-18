package com.yjl.travel.dao.Impl;

import com.yjl.travel.dao.RouteImgDao;
import com.yjl.travel.domain.RouteImg;
import com.yjl.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author yjl
 * @create 2020-06-18-15:47
 **/
public class RouteImgDaoImpl implements RouteImgDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<RouteImg> findByRid(int rid) {
        String sql = "select * from tab_route_img where rid = ?";

        return template.query(sql,
                new BeanPropertyRowMapper<RouteImg>(RouteImg.class), rid);
    }
}
