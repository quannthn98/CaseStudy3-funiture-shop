package controller;

import com.sun.org.apache.xpath.internal.operations.Or;
import dao.IOrderDao;
import model.Order;
import model.OrderDetail;
import service.IGeneralService;
import service.IOrderService;
import service.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderServlet", value = "/OrderServlet")
public class OrderServlet extends HttpServlet {
    IOrderService orderService = new OrderService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            default:
                showAll(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orderList = orderService.selectAll();
        List<OrderDetail> orderDetailList = orderService.getDetails();
        request.setAttribute("orderList", orderList);
        request.setAttribute("orderDetailList", orderDetailList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/order/list.jsp");
        dispatcher.forward(request, response);
    }

    public void showAll(HttpServletRequest request, HttpServletResponse response){

    }
}
