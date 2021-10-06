package controller;

import model.Banner;
import model.Company;
import service.Company.CompanyService;
import service.Company.ICompanyService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CompanyServlet", value = "/Company")
public class CompanyServlet extends HttpServlet {
    private ICompanyService companyService = new CompanyService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "detail":{
                ShowCompanyDetail(request,response);
                break;
            }
            case "create":{
                ShowCompanyCreate(request,response);
                break;
            }
            case "delete": {
                ShowCompanyDelete(request, response);
                break;
            }
            default: {
                ShowCompanyList(request, response);
                break;
            }
        }
    }

    private void ShowCompanyDelete(HttpServletRequest request, HttpServletResponse response) {
        int id  = Integer.parseInt(request.getParameter("id"));
        Company odlcompany = companyService.findById(id);
        RequestDispatcher dispatcher;
        if (odlcompany == null){
            dispatcher = request.getRequestDispatcher("Company/list.jsp");
            request.setAttribute("messege","Show Error");
        }else {
            request.setAttribute("messege","Show Successfull");
            dispatcher = request.getRequestDispatcher("Company/delete.jsp");
            request.setAttribute("Company",odlcompany);
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ShowCompanyList(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        List<Company> companies;
        if (search == null || search.equals("")) {
            companies = companyService.getAll();
        } else {
            companies = companyService.findByName(search);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("Company/list.jsp");
        request.setAttribute("companies", companies);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ShowCompanyCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Company/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ShowCompanyDetail(HttpServletRequest request, HttpServletResponse response) {
        int id  = Integer.parseInt(request.getParameter("id"));
        Company oldCompany = companyService.findById(id);
        RequestDispatcher dispatcher;
        if (oldCompany == null){
            dispatcher = request.getRequestDispatcher("Company/list.jsp");
            request.setAttribute("messege","Show Error");
        }else {
            request.setAttribute("messege","Show Successfull");
            dispatcher = request.getRequestDispatcher("Company/detail.jsp");
            request.setAttribute("Company",oldCompany);
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
            case "delete": {
                DeleteCompany(request, response);
                break;
            }
            case "detail": {
                UpdateCompany(request, response);
                break;
            }
            case "create": {
                createCompany(request, response);
                break;
            }
        }
    }

    private void DeleteCompany(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        companyService.delete(id);
        response.sendRedirect("/Company");
    }

    private void createCompany(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String hotline = request.getParameter("hotline");
        String note = request.getParameter("note");
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        Company company = new Company(name,address,hotline,note,status);
        boolean isCreated = companyService.add(company);
        String message = "";
        if (isCreated) {
            message = "Create success!";
        } else {
            message = "create fail!";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("Company/create.jsp");
        request.setAttribute("message", message);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void UpdateCompany(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String hotline =  request.getParameter("hotline");
        String note =  request.getParameter("note");
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        Company company = new Company(id,name,address,hotline,note,status);
        companyService.update(id,company);
        response.sendRedirect("/Company");
    }
}
