package com.yjl.travel.service.Impl;

import com.yjl.travel.dao.FavoriteDao;
import com.yjl.travel.dao.Impl.FavoriteDaoImpl;
import com.yjl.travel.domain.Favorite;
import com.yjl.travel.service.FavoriteService;

/**
 * @author yjl
 * @create 2020-06-18-15:52
 **/
public class FavoriteServiceImpl implements FavoriteService {
    private FavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    public boolean isFavorite(String rid, int uid) {
        Favorite favorite = favoriteDao.findByRidAndUid(Integer.parseInt(rid), uid);
        //如果对象有值，则为true，反之，则为false
        return favorite != null;
    }

    @Override
    public void add(String rid, int uid) {
        favoriteDao.add(Integer.parseInt(rid), uid);
    }
}
