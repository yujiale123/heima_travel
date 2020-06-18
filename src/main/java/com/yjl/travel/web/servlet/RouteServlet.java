package com.yjl.travel.web.servlet;

import com.yjl.travel.domain.PageBean;
import com.yjl.travel.domain.Route;
import com.yjl.travel.domain.User;
import com.yjl.travel.service.FavoriteService;
import com.yjl.travel.service.Impl.FavoriteServiceImpl;
import com.yjl.travel.service.Impl.RouteServiceImpl;
import com.yjl.travel.service.RouteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yjl
 * @create 2020-06-18-16:34
 **/
@WebServlet(name = "RouteServlet", urlPatterns = "/route/*")
public class RouteServlet extends BaseServlet {

    private RouteService routeService = new RouteServiceImpl();
    private FavoriteService favoriteService = new FavoriteServiceImpl();

    /**
     * 分页查询
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");

        //接受rname 线路名称
        String rname = request.getParameter("rname");
        rname = new String(rname.getBytes("iso-8859-1"), "utf-8");

//类别id
        int cid = 0;
        //2.处理参数
        if (cidStr != null && cidStr.length() > 0 && !"null".equals(cidStr)) {
            cid = Integer.parseInt(cidStr);
        }
        //当前页码，如果不传递，则默认为第一页
        int currentPage = 0;
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }
         //每页显示条数，如果不传递，默认每页显示5条记录
        int pageSize = 0;
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.parseInt(pageSizeStr);
        } else {
            pageSize = 5;
        }

        //3. 调用service查询PageBean对象
        PageBean<Route> routePageBean = routeService.pageQuery(cid, currentPage, pageSize, rname);

        //4. 将pageBean对象序列化为json，返回
        writeValue(response, routePageBean);
    }

    /**
     * 根据id查询一个旅游线路的详细信息
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.接收id
        String rid = request.getParameter("rid");
        //2.调用service查询route对象
        Route route = routeService.findOne(rid);
        //3.转为json写回客户端
        writeValue(response, route);
    }

    /**
     * 判断当前登录用户是否收藏过该线路
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取线路id
        String rid = request.getParameter("rid");

        //2. 获取当前登录的用户 user
        User user = (User) request.getSession().getAttribute("user");
        int uid;//用户id
        if (user == null) {
            //用户尚未登录
            uid = 0;
        } else {
            //用户已经登录
            uid = user.getUid();
        }

        //3. 调用FavoriteService查询是否收藏
        boolean flag = favoriteService.isFavorite(rid, uid);

        //4. 写回客户端
        writeValue(response, flag);
    }

    /**
     * 添加收藏
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取线路rid
        String rid = request.getParameter("rid");
        //2. 获取当前登录的用户
        User user = (User) request.getSession().getAttribute("user");
        int uid;//用户id
        if (user == null) {
            //用户尚未登录
            return;
        } else {
            //用户已经登录
            uid = user.getUid();
        }
        //3. 调用service添加
        favoriteService.add(rid, uid);

    }
}