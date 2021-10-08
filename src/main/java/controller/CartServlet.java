package controller;

import dao.IOrderDao;
import dao.IProductDao;
import dao.ProductDao;
import model.Cart;
import model.Order;
import model.OrderDetail;
import model.Product;
import service.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "CartServlet", value = "/cart")
public class CartServlet extends HttpServlet {
    ICartService cartService = new CartService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "update":
                update(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        cartService.delete(id);
        try {
            response.sendRedirect("/user?action=cart");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        String direction = request.getParameter("direction");
        int cartId = Integer.parseInt(request.getParameter("id"));
        Cart cart = cartService.findById(cartId);
        int currentQuantity = cart.getQuantity();
        int newQuantity = 0;
        if (direction.equals("up")){
            newQuantity = currentQuantity + 1;
        } else if (direction.equals("down")){
            newQuantity = currentQuantity - 1;
        }
        if (newQuantity == 0){
            cartService.delete(cartId);
        } else {
            cart.setQuantity(newQuantity);
            cartService.update(cartId, cart);
        }
        try {
            response.sendRedirect("/user?action=cart");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
