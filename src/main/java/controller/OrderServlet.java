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
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "OrderServlet", value = "/orders")
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
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String style = request.getParameter("view");
        if (style == null){
            style = "";
        }
        List<Order> orderList = orderService.selectAll();
        List<OrderDetail> orderDetailList = orderService.getDetails();
        HashMap<Integer, Double> totalPaymentByOrderId = orderService.getPaymentByOrder();
        RequestDispatcher dispatcher;
        if (style.equals("") || style.equals("modal")){
             dispatcher = request.getRequestDispatcher("order/modalList.jsp");
        } else {
             dispatcher = request.getRequestDispatcher("order/list.jsp");
        }
            request.setAttribute("orderList", orderList);
            request.setAttribute("orderDetailList", orderDetailList);
            request.setAttribute("totalPayment", totalPaymentByOrderId);
            dispatcher.forward(request, response);
    }
}
