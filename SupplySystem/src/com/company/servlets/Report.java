package com.company.servlets;

import com.company.exceptions.BusinessException;
import com.company.exceptions.DataSourceException;
import com.company.orders.DataSourceManager;
import com.company.orders.DataSourceRecord;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Report extends HttpServlet {
    protected void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataSourceManager sourceManager = null;
        ArrayList<DataSourceRecord> data = null;
        try {
            sourceManager = new DataSourceManager();
            data = sourceManager.getData(1,new Date(), new Date());
        } catch (DataSourceException | BusinessException e) {
            BusinessException e1 = new BusinessException(e.getMessage());
            e1.showErrorInformation(request,response);
        }
        request.setAttribute("report",data);
        getServletContext().getRequestDispatcher("/Report.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        requestProcess(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        requestProcess(request, response);
    }
}
