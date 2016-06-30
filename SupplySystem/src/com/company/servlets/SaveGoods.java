package com.company.servlets;

import com.company.entitys.Goods;
import com.company.entitys.GoodsManager;
import com.company.exceptions.BusinessException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveGoods extends HttpServlet {

    protected void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String strID = request.getParameter("id");
        int id = 0;

        if (strID != null && !strID.isEmpty()) {
            id = Integer.parseInt(strID);
        }
        GoodsManager goodsManager = new GoodsManager();
        Goods goods = null;

        if (id == 0) {
            goods = new Goods();
        } else {
            try {
                goods = goodsManager.get(id);
            } catch (BusinessException e) {
                e.printStackTrace();
            }
        }

        goods.setName(request.getParameter("name"));
        goods.setHeight(getFloat(request.getParameter("height")));
        goods.setWidth(getFloat(request.getParameter("width")));
        goods.setDepth(getFloat(request.getParameter("depth")));
        goods.setWeight(getFloat(request.getParameter("weight")));

        try {
            if (id == 0) {
                goodsManager.add(goods);
            } else {
                goodsManager.update(goods);
            }
        } catch (BusinessException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/app/goods");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        requestProcess(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        requestProcess(request, response);
    }

    //
    public Float getFloat(String s) {
        if ((s.isEmpty()) || (s == null)) {
            return 0f;
        } else {
            String correctS = s.replace(',','.');
            return Float.valueOf(correctS).floatValue();
        }
    }
}
