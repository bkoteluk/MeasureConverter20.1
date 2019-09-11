package pl.bogdank.measureconverter.servlet;

import pl.bogdank.measureconverter.exceptions.InvalidFormDataException;
import pl.bogdank.measureconverter.model.Distance;
import pl.bogdank.measureconverter.utils.ConverterUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/distance")
public class DistanceConvertServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        try {
            Distance distance = new Distance(request.getParameter("metre"), request.getParameter("centimetre"), request.getParameter("millimetre"));
            ConverterUtils converter = new ConverterUtils();
            converter.distanceConvert(distance);
            pw.println("<html><head></head><body><h1>Podana wartość w przeliczeniu na: </h1><br/><p>" + distance + "</p></body><html>");
        } catch (InvalidFormDataException ex) {
            pw.println(ex.getMessage());
        } catch (NumberFormatException ex) {
            pw.println(ex.getMessage());
        } finally {
            pw.close();
        }
    }
}
