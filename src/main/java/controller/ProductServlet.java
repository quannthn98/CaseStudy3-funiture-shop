package controller;

import dao.ProductDAO;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                showFormCrateProduct(request, response);
                break;
            }
            case "edit": {
                showFormEditProduct(request, response);
                break;
            }
            case "delete":{
                showFormDeleteProduct(request,response);
                break;
            }
            default:
                FormListProduct(request, response);
        }
    }

    private void showFormDeleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        productDAO.delete(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/delete.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void FormListProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = new ArrayList<>();
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEditProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        request.setAttribute("product", product);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCrateProduct(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        try {
            dispatcher.forward(request,response);
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
        switch (action) {
            case "edit": {
                editProduct(request, response);
                break;
            }
            case "create":{
                addProduct(request,response);
                break;
            }
        }
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String subImage = request.getParameter("subimage");
        float price = Float.parseFloat(request.getParameter("price"));
        int priceSell = Integer.parseInt(request.getParameter("prince_sell"));
        String subDescription = request.getParameter("subdescription");
        String description = request.getParameter("description");
        String createdDate = request.getParameter("createdDate");
        int status = Integer.parseInt(request.getParameter("status"));
        productDAO.save(new Product(name,image,subImage,price,priceSell,subDescription,description,createdDate,status));
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String image = request.getParameter("name");
        String subImage = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("name"));
        int priceSell = Integer.parseInt(request.getParameter("name"));
        String subDescription = request.getParameter("name");
        String description = request.getParameter("name");
        String createdDate = request.getParameter("name");
        int status = Integer.parseInt(request.getParameter("name"));
        Product product = new Product(name, image, subImage, price, priceSell, subDescription, description, createdDate, status);
        productDAO.update(id,product);
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
