package controller;

import model.Banner;
import model.News;
import service.New.INewService;
import service.New.NewService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NewsServlet", value = "/New")
public class NewsServlet extends HttpServlet {
    private INewService newService = new NewService();
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
                ShowNewsDetail(request,response);
                break;
            }
            case "create":{
                ShowNewsCreate(request,response);
                break;
            }
            case "delete": {
                ShowNewsDelete(request, response);
                break;
            }
            default: {
                ShowNewsList(request, response);
                break;
            }
        }
    }

    private void ShowNewsDetail(HttpServletRequest request, HttpServletResponse response) {
        int id  = Integer.parseInt(request.getParameter("id"));
        News oldbNews = newService.findById(id);
        RequestDispatcher dispatcher;
        if (oldbNews == null){
            dispatcher = request.getRequestDispatcher("New/list.jsp");
            request.setAttribute("messege","Show Error");
        }else {
            request.setAttribute("messege","Show Successfull");
            dispatcher = request.getRequestDispatcher("New/detail.jsp");
            request.setAttribute("news",oldbNews);
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ShowNewsCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("New/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ShowNewsDelete(HttpServletRequest request, HttpServletResponse response) {
        int id  = Integer.parseInt(request.getParameter("id"));
        News oldnews = newService.findById(id);
        RequestDispatcher dispatcher;
        if (oldnews == null){
            dispatcher = request.getRequestDispatcher("New/list.jsp");
            request.setAttribute("messege","Show Error");
        }else {
            request.setAttribute("messege","Show Successfull");
            dispatcher = request.getRequestDispatcher("New/delete.jsp");
            request.setAttribute("news",oldnews);
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ShowNewsList(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        List<News> newss;
        if (search == null || search.equals("")) {
            newss = newService.getAll();
        } else {
            newss = newService.findByName(search);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("New/list.jsp");
        request.setAttribute("newss", newss);
        try {
            dispatcher.forward(request, response);
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
                DeleteNews(request, response);
                break;
            }
            case "detail": {
                UpdateNews(request, response);
                break;
            }
            case "create": {
                createNews(request, response);
                break;
            }
        }
    }

    private void createNews(HttpServletRequest request, HttpServletResponse response) {
        String title = request.getParameter("title");
        String subtitle = request.getParameter("subtitle");
        String description = request.getParameter("description");
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        int id_Customer = Integer.parseInt(request.getParameter("id_Customer"));
        News news = new News(title,subtitle,description,status,id_Customer);
        boolean isCreated = newService.add(news);
        String message = "";
        if (isCreated) {
            message = "Create success!";
        } else {
            message = "create fail!";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("New/create.jsp");
        request.setAttribute("message", message);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void UpdateNews(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int id_Customer = Integer.parseInt(request.getParameter("id_Customer"));
        String title = request.getParameter("title");
        String subtitle = request.getParameter("subtitle");
        String description = request.getParameter("description");
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        News news = new News(title,subtitle,description,status,id_Customer);
        newService.update(id,news);
        response.sendRedirect("/New");
    }

    private void DeleteNews(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        newService.delete(id);
        response.sendRedirect("/New");
    }
}
