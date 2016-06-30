package com.company.exceptions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BusinessException extends Throwable {
    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public void showErrorInformation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        printStackTrace();
        request.setAttribute("ErrorInformation", getMessage());

        request.getServletContext().getRequestDispatcher("/ErrorInformation.jsp").forward(request, response);

    }
}
