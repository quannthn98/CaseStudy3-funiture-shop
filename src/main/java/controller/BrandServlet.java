package controller;

import dao.BrandDao;
import dao.ProductDAO;
import model.Brand;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BrandServlet", value = "/brand")
public class BrandServlet extends HttpServlet {
    BrandDao brandDao = new BrandDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create-brand": {
                showFormCreateBrand(request, response);
                break;
            }
            case "edit-brand": {
                showFormEditBrand(request, response);
                break;
            }
            case "delete-brand": {
                showFormDeleteBrand(request, response);
                break;
            }
            default:
                showListBrand(request, response);
        }

    }

    private void showListBrand(HttpServletRequest request, HttpServletResponse response) {
        List<Brand> brandList = brandDao.getAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/brand/list.jsp");
        request.setAttribute("brandList", brandList);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormDeleteBrand(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        brandDao.delete(id);
        RequestDispatcher dispatcher= request.getRequestDispatcher("/brand/delete.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEditBrand(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Brand brand = brandDao.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/brand/edit.jsp");
        request.setAttribute("brand", brand);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreateBrand(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/brand/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

    }
}
