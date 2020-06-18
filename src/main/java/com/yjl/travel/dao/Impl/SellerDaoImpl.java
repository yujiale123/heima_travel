package com.yjl.travel.dao.Impl;

import com.yjl.travel.dao.SellerDao;
import com.yjl.travel.domain.Seller;
import com.yjl.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author yjl
 * @create 2020-06-18-15:45
 **/
public class SellerDaoImpl implements SellerDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Seller findBySid(int sid) {
        String sql = "select * from tab_seller where sid = ?";

        return template.queryForObject(sql,
                new BeanPropertyRowMapper<Seller>(Seller.class), sid);
    }
}
