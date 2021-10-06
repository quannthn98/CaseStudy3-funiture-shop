package controller;

import dao.CategoryDao;
import model.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/category")
public class CategoryServlet extends HttpServlet {
    CategoryDao categoryDao = new CategoryDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        fontUTF_8(request, response);
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create-category": {
                showFormCreateCategory(request, response);
                break;
            }
            case "edit-category": {
                showFormEditCategory(request, response);
                break;
            }
            case "delete-category": {
                showFormDeleteCategory(request, response);
                break;
            }
            default:
                showListCategory(request, response);
        }

    }

    private void fontUTF_8(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
    }

    private void showListCategory(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categoryList = categoryDao.getAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/list.jsp");
        request.setAttribute("categoryList", categoryList);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormDeleteCategory(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        categoryDao.delete(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/delete.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEditCategory(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Category category = categoryDao.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/edit.jsp");
        request.setAttribute("category", category);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreateCategory(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        fontUTF_8(request, response);
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create-category": {
                createCategory(request, response);
                break;
            }
            case "edit-category": {
                editCategory(request, response);
                break;
            }
        }
    }

    private void createCategory(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int location = Integer.parseInt(request.getParameter("location"));
        int status = Integer.parseInt(request.getParameter("status"));
        categoryDao.save(new Category(name, location, status));
        try {
            response.sendRedirect("/category");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editCategory(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int location = Integer.parseInt(request.getParameter("location"));
        int status = Integer.parseInt(request.getParameter("status"));
        Category category = new Category(name, location, status);
        categoryDao.update(id, category);
        try {
            response.sendRedirect("/category");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
