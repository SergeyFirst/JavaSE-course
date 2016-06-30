package com.company.servlets;

import com.company.entitys.GoodsManager;
import com.company.exceptions.BusinessException;
import com.company.filters.GoodsFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoodsList extends HttpServlet {

    protected void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodsManager goodsManager = new GoodsManager();
        try {
            request.setAttribute("goodsList", goodsManager.find(new GoodsFilter()));
        } catch (BusinessException e) {
            e.showErrorInformation(request,response);
        }
        getServletContext().getRequestDispatcher("/GoodsList.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        requestProcess(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        requestProcess(request, response);
    }
}
