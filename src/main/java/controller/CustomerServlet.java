package controller;

import dao.CategoryDao;
import dao.CustomerDao;
import model.Category;
import model.Customer;
import service.CustomerService;
import service.ICustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {
    ICustomerService customerService = new CustomerService();
    CategoryDao categoryDao = new CategoryDao();

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
                createJSP(request, response);
                break;
            }
            case "edit": {
                editJSP(request, response);
                break;
            }
            case "delete": {
                deleteJSP(request, response);
                break;
            }
            case "login": {
                loginDoGet(request, response);
                break;
            }
            case "create2":{
                createDG(request,response);
                break;
            }
            default: {
                getAll(request, response);
                break;
            }
        }

    }

    private void createDG(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/login.jsp");
        dispatcher.forward(request,response);
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
            case "create": {
                createDB(request, response);
                break;
            }
            case "edit": {
                editPOT(request, response);
                break;
            }
            case "login": {
                loginDoPot(request, response);
                break;
            }
            case "createUser":
                createDP(request,response);
                break;
        }
    }

    private void createDP(HttpServletRequest request, HttpServletResponse response) {
        Customer customer = getCustomerInformation(request);
        boolean isCreated = true;
        List<Customer> customers = customerService.selectAll();
        for (Customer c : customers) {
            if (c.getEmail().equals(customer.getEmail())) {
                isCreated = false;
                request.setAttribute("messages", "email da ton tai");
                break;
            }
        }

        if (isCreated) {
            customerService.save(customer);
            try {
                Customer customer1 = customerService.findByEmail(customer.getEmail()).get(0);
                int newCustomerId = customer1.getId();
                customerService.setRole(newCustomerId);
                response.sendRedirect("/user?action=login");
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/user?action=login");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void loginDoGet(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categoryList = categoryDao.getAll();
        request.setAttribute("categoryList",categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/login.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void deleteJSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.delete(id);
        try {
            getAll(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editJSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void createJSP(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("q");
        if (email == null) {
            List<Customer> customerList = customerService.selectAll();
            request.setAttribute("customer", customerList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/list.jsp");
            dispatcher.forward(request, response);
        } else {
            try {
                List<Customer> customers = customerService.findByEmail(email);
                request.setAttribute("customer", customers);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/list.jsp");
                dispatcher.forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    private void loginDoPot(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Customer customer=null;
        boolean isLoggedIn = false;
        List<Customer> customerList = customerService.selectAll();
        for (Customer customer1 : customerList) {
            if (email.equals(customer1.getEmail()) && password.equals(customer1.getPassword())) {
                customer = customer1;
                isLoggedIn = true;
                break;
            }
        }

        if (isLoggedIn){
            if(customer.getRole() == 1 ){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/customers");
                try {
                    dispatcher.forward(request,response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                UserServlet.setCustomer(customer);
                try {
                    response.sendRedirect("/user");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else {
            try {
                response.sendRedirect("/user/login.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    private void editPOT(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String status = request.getParameter("status");
        boolean update;
        if (name.equals("") || birthday.equals("") || address.equals("") || phone.equals("") || email.equals("") || password.equals("") || status.equals("")) {
            update = false;
        } else {
            update = customerService.update(id, new Customer(id, name, birthday, address, phone, email, password, status));
        }
        if (update) {
            try {
                response.sendRedirect("/customers");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("message", "edit false");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/edit.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Customer getCustomerInformation(HttpServletRequest request){
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String status = "1";
        return new Customer(name, birthday, address, phone, email, password, status);
    }

    private void createDB(HttpServletRequest request, HttpServletResponse response) {
        Customer customer = getCustomerInformation(request);
        boolean isCreate = true;
        List<Customer> customers = customerService.selectAll();
        for (Customer c : customers) {
            if (c.getEmail().equals(customer.getEmail())) {
                isCreate = false;
                request.setAttribute("messageemail", "email da ton tai");
            }
        }

        if (isCreate) {
            customerService.save(customer);
            try {
                Customer customer1 = customerService.findByEmail(customer.getEmail()).get(0);
                int newCustomerId = customer1.getId();
                customerService.setRole(newCustomerId);
                response.sendRedirect("/customers");
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
