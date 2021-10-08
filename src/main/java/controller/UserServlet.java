package controller;

import com.sun.org.apache.xpath.internal.operations.Or;
import dao.CategoryDao;
import dao.Company.ICompanyDao;
import dao.IOrderDao;
import dao.IProductDao;
import dao.ProductDao;
import model.Category;
import model.Order;
import model.OrderDetail;
import model.Product;

import model.*;
import service.Banner.BannerService;
import service.Banner.IBannerService;
import service.Company.CompanyService;
import service.Company.ICompanyService;
import service.IGeneralService;
import service.IOrderService;
import service.New.INewService;
import service.New.NewService;
import service.OrderService;
import service.Settings.ISettingsService;
import service.Settings.SettingsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    IOrderService orderService = new OrderService();
    IProductDao productDao = new ProductDao();
    CategoryDao categoryDao = new CategoryDao();
    private IBannerService bannerService = new BannerService();
    private ISettingsService settingsService = new SettingsService();
    private INewService newService = new NewService();
    private ICompanyService companyService = new CompanyService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "detail":
                showProductDetail(request, response);
                break;
            case "category":
                showCategory(request, response);
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
        List<Banner> banners;
        banners = bannerService.getAll();
        List<Company> companies;
        companies = companyService.getAll();
        List<Settings> settings;
        settings = settingsService.getAll();
        List<News> news;
        news = newService.getAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/home.jsp");
        request.setAttribute("banners", banners);
        request.setAttribute("companies", companies);
        request.setAttribute("settings", settings);
        request.setAttribute("news", news);
        dispatcher.forward(request, response);
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
