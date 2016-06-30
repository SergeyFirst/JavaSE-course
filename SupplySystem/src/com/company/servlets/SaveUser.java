package com.company.servlets;

import com.company.entitys.User;
import com.company.entitys.UserManager;
import com.company.exceptions.BusinessException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Scanner;

public class SaveUser extends HttpServlet {

    protected void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String strID = request.getParameter("id");
        int id = 0;
        if (strID != null && !strID.isEmpty()) {
            id = new Scanner(strID).nextInt();
        }

        UserManager userManager = new UserManager();
        User user = null;

        if (id == 0) {
            user = new User();
        } else {
            try {
                user = userManager.get(id);
            } catch (BusinessException e) {
                e.printStackTrace();
            }
        }

        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));

        try {
            if (id == 0) {
                userManager.add(user);
            } else {
                userManager.update(user);
            }
        } catch (BusinessException e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/app/users");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        requestProcess(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        requestProcess(request, response);
    }
}
