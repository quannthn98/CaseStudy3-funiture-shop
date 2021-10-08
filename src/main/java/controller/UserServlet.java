package controller;

import com.sun.org.apache.xpath.internal.operations.Or;
import dao.CategoryDao;
import dao.IOrderDao;
import dao.IProductDao;
import dao.ProductDao;
import model.Category;
import model.Order;
import model.OrderDetail;
import model.Product;

import service.IOrderService;
import service.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    IOrderService orderService = new OrderService();
    IProductDao productDao = new ProductDao();
    CategoryDao categoryDao = new CategoryDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "detail":
                showProductDetail(request, response);
                break;
            case "category":
                showCategory(request ,response);
                break;
            default:
                showHome(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void showProductDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("id"));
        Product product = productDao.findById(productId);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/productDetail.jsp");
        dispatcher.forward(request, response);
//        response.sendRedirect("user/productDetailTemplate.jsp");
    }

    private void showHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/home.jsp");
        dispatcher.forward(request,response);
    }

    private void showCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String categoryId = request.getParameter("categoryId");
        int categoryId1;
        if (categoryId == null){
            categoryId = "1";
        }
        categoryId1 = Integer.parseInt(categoryId);
        List<Product> productList = productDao.findByCategory(categoryId1);
        List<Category> categoryList = categoryDao.getAll();
        request.setAttribute("productList",productList);
        request.setAttribute("categoryList",categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/category.jsp");
        dispatcher.forward(request,response);
    }



}
