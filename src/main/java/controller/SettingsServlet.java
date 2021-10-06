package controller;

import dao.Settings.ISettingsDao;
import model.Company;
import model.Settings;
import service.Company.CompanyService;
import service.Company.ICompanyService;
import service.Settings.ISettingsService;
import service.Settings.SettingsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SettingsServlet", value = "/Settings")
public class SettingsServlet extends HttpServlet {
    private ISettingsService settingsService = new SettingsService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "detail": {
                ShowSettingsDetail(request, response);
                break;
            }
            case "create": {
                ShowSettingsCreate(request, response);
                break;
            }
            case "delete": {
                ShowSettingsDelete(request, response);
                break;
            }
            default: {
                ShowSettingsList(request, response);
                break;
            }
        }
    }

    private void ShowSettingsDetail(HttpServletRequest request, HttpServletResponse response) {
        int id  = Integer.parseInt(request.getParameter("id"));
        Settings oldsettings = settingsService.findById(id);
        RequestDispatcher dispatcher;
        if (oldsettings == null){
            dispatcher = request.getRequestDispatcher("Settings/list.jsp");
            request.setAttribute("messege","Show Error");
        }else {
            dispatcher = request.getRequestDispatcher("Settings/detail.jsp");
            request.setAttribute("messege","Show Successfull");
            request.setAttribute("Settings",oldsettings);
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ShowSettingsCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Settings/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ShowSettingsDelete(HttpServletRequest request, HttpServletResponse response) {
        int id  = Integer.parseInt(request.getParameter("id"));
        Settings odlsettings= settingsService.findById(id);
        RequestDispatcher dispatcher;
        if (odlsettings == null){
            dispatcher = request.getRequestDispatcher("Settings/list.jsp");
            request.setAttribute("messege","Show Error");
        }else {
            request.setAttribute("messege","Show Successfull");
            dispatcher = request.getRequestDispatcher("Settings/delete.jsp");
            request.setAttribute("Settings",odlsettings);
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ShowSettingsList(HttpServletRequest request, HttpServletResponse response) {
        List<Settings> settingss = settingsService.getAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("Settings/list.jsp");
        request.setAttribute("settingss", settingss);
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
                DeleteSettings(request, response);
                break;
            }
            case "detail": {
                UpdateSettings(request, response);
                break;
            }
            case "create": {
                createSettings(request, response);
                break;
            }
        }
    }

    private void createSettings(HttpServletRequest request, HttpServletResponse response) {
        String title = request.getParameter("title");
        String logo = request.getParameter("logo");
        String hotline =  request.getParameter("hotline");
        String address =  request.getParameter("address");
        String linkMap =  request.getParameter("linkMap");
        String email =  request.getParameter("email");
        String pageFacebook =  request.getParameter("pageFacebook");
        String logo_payment =  request.getParameter("logo_payment");
        String note =  request.getParameter("note");
        Settings settings = new Settings(title,logo,hotline,address,linkMap,email,pageFacebook,logo_payment,note);
        boolean isCreated = settingsService.add(settings);
        String message = "";
        if (isCreated) {
            message = "Create success!";
        } else {
            message = "create fail!";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("Settings/create.jsp");
        request.setAttribute("message", message);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void DeleteSettings(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        settingsService.delete(id);
        response.sendRedirect("/Settings");
    }

    private void UpdateSettings(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String logo = request.getParameter("logo");
        String hotline =  request.getParameter("hotline");
        String address =  request.getParameter("address");
        String linkMap =  request.getParameter("linkMap");
        String email =  request.getParameter("email");
        String pageFacebook =  request.getParameter("pageFacebook");
        String logo_payment =  request.getParameter("logo_payment");
        String note =  request.getParameter("note");
        Settings settings = new Settings(id,title,logo,hotline,address,linkMap,email,pageFacebook,logo_payment,note);
        settingsService.update(id,settings);
        response.sendRedirect("/Settings");
    }
}
