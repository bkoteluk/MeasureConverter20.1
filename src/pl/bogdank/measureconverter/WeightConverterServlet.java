package pl.bogdank.measureconverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import static pl.bogdank.measureconverter.lib.ConverterTool.*;

@WebServlet("/weight")
public class WeightConverterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String kilogram = request.getParameter("kilogram");
        String gram = request.getParameter("gram");
        String milligram = request.getParameter("milligram");
        System.out.println(kilogram + " " + gram + " " + milligram);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        BigDecimal[] array = new BigDecimal[3];

        if (!isFilledOnlyOne(kilogram, gram, milligram) || !isFilledOneOf(kilogram, gram, milligram))
            pw.println( ANSWER_PAGE_TEMPLATE + "<body><h1>Należy wypełnić tylko/przynajmniej jedno pole</h1><br/></h1><br/>");
        else {
            try {
                if (!kilogram.equals(""))
                    array = weightConvert("kg", new BigDecimal(kilogram));
                if (!gram.equals(""))
                    array = weightConvert("g", new BigDecimal(gram));
                if (!milligram.equals(""))
                    array = weightConvert("mg", new BigDecimal(milligram));
            } catch (NumberFormatException ex) {
                pw.println(ex.getMessage());
            }
        }
        pw.println(ANSWER_PAGE_TEMPLATE + "<body><h1>Podana wartość w przeliczeniu na: </h1><br/><p>" +
                "kilogramy: "+ array[0].toString() + "<br/>gramy: " + array[1].toString() + "<br/> miligramy: " + array[2].toString() + "</p></h1><br/>");
        pw.close();
    }
}
