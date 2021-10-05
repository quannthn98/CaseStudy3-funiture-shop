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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                showEditForm(request, response);
                break;
            default:
                showAll(request, response);
                break;
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
            case "edit":
                save(request, response);
                break;
            default:
                showAll(request, response);
                break;
        }
    }

    public void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String style = request.getParameter("view");
        if (style == null) {
            style = "";
        }
        List<Order> orderList = orderService.selectAll();
        List<OrderDetail> orderDetailList = orderService.getDetails();
        HashMap<Integer, Double> totalPaymentByOrderId = orderService.getPaymentByOrder();
        RequestDispatcher dispatcher;
        if (style.equals("") || style.equals("modal")) {
            dispatcher = request.getRequestDispatcher("order/modalList.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("order/list.jsp");
        }
        request.setAttribute("orderList", orderList);
        request.setAttribute("orderDetailList", orderDetailList);
        request.setAttribute("totalPayment", totalPaymentByOrderId);
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("id"));
        Order order = orderService.findById(orderId);
        int saleOff = orderService.getSaleOffByOrder(orderId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/order/edit.jsp");
        request.setAttribute("order", order);
        request.setAttribute("saleOff", saleOff);
        dispatcher.forward(request, response);
    }

    private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int orderId = Integer.parseInt(request.getParameter("id"));
        Order order = orderService.findById(orderId);

        String customerName = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String note = request.getParameter("note");
        int saleOff = Integer.parseInt(request.getParameter("saleOff"));
        order.setConsignee(customerName);
        order.setPhone(phone);
        order.setAddressOrder(address);
        order.setNote(note);
        orderService.updateSaleOff(saleOff, orderId);
        orderService.update(orderId, order);
        response.sendRedirect("/orders");
    }

}
