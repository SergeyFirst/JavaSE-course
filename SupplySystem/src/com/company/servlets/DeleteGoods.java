package com.company.servlets;

import com.company.entitys.GoodsManager;
import com.company.exceptions.BusinessException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Scanner;

public class DeleteGoods extends HttpServlet {

    protected void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String strID = request.getParameter("id");
        int id = 0;

        if (strID != null && !strID.isEmpty()) {
            id = new Scanner(strID).nextInt();
        }

        if (id != 0) {
            GoodsManager goodsManager = new GoodsManager();
            try {
                goodsManager.delete(id);
            } catch (BusinessException e) {
                e.printStackTrace();
            }
        }

        response.sendRedirect(request.getContextPath() + "/app/goods");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        requestProcess(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        requestProcess(request, response);
    }
}
