package com.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rollno = request.getParameter("rollno");
        String name = request.getParameter("name");

        int sub1 = Integer.parseInt(request.getParameter("sub1"));
        int sub2 = Integer.parseInt(request.getParameter("sub2"));
        int sub3 = Integer.parseInt(request.getParameter("sub3"));
        int sub4 = Integer.parseInt(request.getParameter("sub4"));
        int sub5 = Integer.parseInt(request.getParameter("sub5"));

        // Server-side validation
        if(sub1<0 || sub1>100 || sub2<0 || sub2>100 || sub3<0 || sub3>100 ||
           sub4<0 || sub4>100 || sub5<0 || sub5>100) {
            
            response.getWriter().println("Invalid marks entered!");
            return;
        }

        // Calculate total & average
        int total = sub1 + sub2 + sub3 + sub4 + sub5;
        double avg = total / 5.0;

        // Result logic
        String result;
        if(sub1>=40 && sub2>=40 && sub3>=40 && sub4>=40 && sub5>=40)
            result = "PASS";
        else
            result = "FAIL";

        // Send data to JSP
        request.setAttribute("rollno", rollno);
        request.setAttribute("name", name);
        request.setAttribute("sub1", sub1);
        request.setAttribute("sub2", sub2);
        request.setAttribute("sub3", sub3);
        request.setAttribute("sub4", sub4);
        request.setAttribute("sub5", sub5);
        request.setAttribute("average", avg);
        request.setAttribute("result", result);

        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}