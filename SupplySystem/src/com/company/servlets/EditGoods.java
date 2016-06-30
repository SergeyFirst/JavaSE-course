package com.company.servlets;

import com.company.entitys.GoodsManager;
import com.company.entitys.Goods;
import com.company.exceptions.BusinessException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Scanner;

public class EditGoods extends HttpServlet {

    protected void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strID = request.getParameter("id");
        int id = 0;

        if (strID != null && !strID.isEmpty()) {
            id = new Scanner(strID).nextInt();
        }

        if (id != 0) {
            GoodsManager goodsManager = new GoodsManager();
            Goods goods = null;
            try {
                goods = goodsManager.get(id);
            } catch (BusinessException e) {
                e.printStackTrace();
            }
            request.setAttribute("id", id);
            request.setAttribute("name", goods.getName());
            request.setAttribute("height", goods.getHeight());
            request.setAttribute("width", goods.getWidth());
            request.setAttribute("depth", goods.getDepth());
            request.setAttribute("weight", goods.getWeight());
        }
        getServletContext().getRequestDispatcher("/EditGoods.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        requestProcess(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        requestProcess(request, response);
    }
}
