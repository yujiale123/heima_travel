package com.yjl.travel.dao;

import com.yjl.travel.domain.Seller;

/**
 * @author yjl
 * @create 2020-06-18-15:44
 **/
public interface SellerDao {
    /**
     * 根据sid查询
     * @param sid
     * @return
     */
    Seller findBySid(int sid);
}
