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

public class EditUser extends HttpServlet {

    protected void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strID = request.getParameter("id");
        int id = 0;

        if (strID != null && !strID.isEmpty()) {
            id = new Scanner(strID).nextInt();
        }

        if (id !=0) {
            UserManager userManager = new UserManager();
            User user = null;
            try {
                user = userManager.get(id);
            } catch (BusinessException e) {
                e.printStackTrace();
            }
            request.setAttribute("id", id);
            request.setAttribute("firstName", user.getFirstName());
            request.setAttribute("lastName", user.getLastName());
            request.setAttribute("login", user.getLogin());
            request.setAttribute("password", user.getPassword());
        }
        getServletContext().getRequestDispatcher("/EditUser.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        requestProcess(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        requestProcess(request,response);
    }
}
