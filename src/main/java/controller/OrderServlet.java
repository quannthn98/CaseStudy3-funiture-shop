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
    private final int DEFAULT_LIMIT = 5;
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
                showByPage(request, response);
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
        List<Order> orderList = orderService.selectAll();
        List<OrderDetail> orderDetailList = orderService.getDetails();
        HashMap<Integer, Double> totalPaymentByOrderId = orderService.getPaymentByOrder();

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("order/list.jsp");

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
//        String customerName = request.getParameter("name");
//        String phone = request.getParameter("phone");
//        String address = request.getParameter("address");
        String note = request.getParameter("note");
//        int saleOff = Integer.parseInt(request.getParameter("saleOff"));
        int status = Integer.parseInt(request.getParameter("status"));

//        order.setConsignee(customerName);
//        order.setPhone(phone);
//        order.setAddressOrder(address);
        order.setNote(note);
        if (status == 0) {
            order.setStatus(false);
        } else {
            order.setStatus(true);
        }
//        orderService.updateSaleOff(saleOff, orderId);
        orderService.update(orderId, order);
        response.sendRedirect("/orders");
    }

    private int pagination(HttpServletRequest request, HttpServletResponse response){
        int offset = 0;
        String next = "";
        String pre = "";
        int selectedPage;
        int countRecord = orderService.countRecord();
        int totalPage = countRecord/DEFAULT_LIMIT + 1;
        String page = request.getParameter("page");
        if (page == null){
            selectedPage = 1;
        } else {
            selectedPage = Integer.parseInt(page);
        }
        if (selectedPage == 1){
            pre = "disabled";
        } else if (selectedPage == totalPage){
            next = "disabled";
        }
        request.setAttribute("selectedPage", selectedPage);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("pre", pre);
        request.setAttribute("next", next);
        offset = (selectedPage-1)*DEFAULT_LIMIT;
        return offset;
    }

    private void showByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int offset = pagination(request, response);
        List<Order> orderList = orderService.getOrderByOffset(offset);
        List<OrderDetail> orderDetailList = orderService.getDetails();
        HashMap<Integer, Double> totalPaymentByOrderId = orderService.getPaymentByOrder();

        request.setAttribute("orderList", orderList);
        request.setAttribute("orderDetailList", orderDetailList);
        request.setAttribute("totalPayment", totalPaymentByOrderId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/order/list.jsp");
        dispatcher.forward(request,response);
    }


}
