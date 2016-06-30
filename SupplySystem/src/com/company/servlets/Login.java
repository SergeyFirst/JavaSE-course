package com.company.servlets;

import com.company.entitys.User;
import com.company.entitys.UserManager;
import com.company.exceptions.BusinessException;
import com.company.filters.UserFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class Login extends HttpServlet {

    protected void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        session.setAttribute("ACCESSED",false);

        UserManager userManager = new UserManager();
        try {
            ArrayList<User> users = (ArrayList<User>) userManager.find(new UserFilter(null,null,login));
            for (User user : users) {
                if (user.getPassword().equals(password)) {
                    session.setAttribute("ACCESSED",true);
                    break;
                }
            }
        } catch (BusinessException e) {
            e.showErrorInformation(request,response);
        }

        response.sendRedirect(request.getContextPath()+"/app/desktop");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        requestProcess(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        requestProcess(request, response);
    }
}
