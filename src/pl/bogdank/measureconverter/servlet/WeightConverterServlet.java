package pl.bogdank.measureconverter.servlet;

import pl.bogdank.measureconverter.exceptions.InvalidFormDataException;
import pl.bogdank.measureconverter.model.Weight;
import pl.bogdank.measureconverter.utils.ConverterUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/weight")
public class WeightConverterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        try {
            Weight weight = new Weight(request.getParameter("kilogram"), request.getParameter("gram"), request.getParameter("milligram"));
            ConverterUtils converter = new ConverterUtils();
            converter.weightConvert(weight);
            pw.println("<html><head></head><body><h1>Podana wartość w przeliczeniu na: </h1><br/><p>" + weight + "</p></body><html>");
        } catch (NumberFormatException | InvalidFormDataException ex) {
            pw.println(ex.getMessage());
        } finally {
            pw.close();
        }
    }
}
