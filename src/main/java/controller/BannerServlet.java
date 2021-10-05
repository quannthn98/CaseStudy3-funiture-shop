package controller;


import model.Banner;
import service.Banner.BannerService;
import service.Banner.IBannerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BannerServlet", value = "/Banner")
public class BannerServlet extends HttpServlet {
    private IBannerService bannerService = new BannerService();

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
                ShowBannerDetail(request,response);
            }
            case "create":{
                ShowBannerCreate(request,response);
            }
            case "delete": {
                ShowBannerDelete(request, response);
                break;
            }
            default: {
                ShowBannerList(request, response);
                break;
            }
        }
    }

    private void ShowBannerCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Banner/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ShowBannerDetail(HttpServletRequest request, HttpServletResponse response) {
        int id  = Integer.parseInt(request.getParameter("id"));
        Banner oldbanner = bannerService.finById(id);
        RequestDispatcher dispatcher;
        if (oldbanner == null){
            dispatcher = request.getRequestDispatcher("Banner/list.jsp");
            request.setAttribute("messege","Show Error");
        }else {
            request.setAttribute("messege","Show Successfull");
            dispatcher = request.getRequestDispatcher("Banner/detail.jsp");
            request.setAttribute("banner",oldbanner);
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ShowBannerDelete(HttpServletRequest request, HttpServletResponse response) {
        int id  = Integer.parseInt(request.getParameter("id"));
        Banner oldbanner = bannerService.finById(id);
        RequestDispatcher dispatcher;
        if (oldbanner == null){
            dispatcher = request.getRequestDispatcher("Banner/list.jsp");
            request.setAttribute("messege","Show Error");
        }else {
            request.setAttribute("messege","Show Successfull");
            dispatcher = request.getRequestDispatcher("Banner/delete.jsp");
            request.setAttribute("banner",oldbanner);
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void ShowBannerList(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        List<Banner> banners;
        if (search == null || search.equals("")) {
            banners = bannerService.getAll();
        } else {
            banners = bannerService.findByName(search);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("Banner/list.jsp");
        request.setAttribute("banners", banners);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*============================================================================================================================*/

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
                DeleteBanner(request, response);
                break;
            }
            case "detail": {
                UpdateBanner(request, response);
                break;
            }
            case "create": {
                createBanner(request, response);
                break;
            }
        }
    }

    private void createBanner(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        int location = Integer.parseInt(request.getParameter("location"));
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        Banner banner = new Banner(name,image,location,status);
        boolean isCreated = bannerService.add(banner);
        String message = "";
        if (isCreated) {
            message = "Create success!";
        } else {
            message = "create fail!";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("Banner/create.jsp");
        request.setAttribute("message", message);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    private void UpdateBanner(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        int location = Integer.parseInt(request.getParameter("location"));
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        Banner banner = new Banner(id,name,image,location,status);
        bannerService.update(id,banner);
        response.sendRedirect("/Banner");

    }

    private void DeleteBanner(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        bannerService.delete(id);
        response.sendRedirect("/Banner");
    }
}
