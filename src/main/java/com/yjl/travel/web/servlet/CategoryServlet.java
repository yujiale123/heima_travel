package com.yjl.travel.web.servlet;

import com.yjl.travel.domain.Category;
import com.yjl.travel.service.CategoryService;
import com.yjl.travel.service.Impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author yjl
 * @create 2020-06-18-16:33
 **/
@WebServlet(name = "CategoryServlet", urlPatterns = "/category/*")
public class CategoryServlet extends BaseServlet {

    private CategoryService service = new CategoryServiceImpl();

    /**
     * 查询所有
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用service查询所有
        List<Category> cs = service.findAll();
        /**2.序列化json返回*/
        writeValue(response, cs);

    }

}