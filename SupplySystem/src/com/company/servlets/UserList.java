package com.company.servlets;

import com.company.entitys.UserManager;
import com.company.exceptions.BusinessException;
import com.company.filters.UserFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserList extends HttpServlet {

    protected void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserManager userManager = new UserManager();
        try {
            request.setAttribute("userList",userManager.find(new UserFilter()));
        } catch (BusinessException e) {
            e.showErrorInformation(request,response);
        }
        getServletContext().getRequestDispatcher("/UserList.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        requestProcess(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        requestProcess(request, response);
    }
}
