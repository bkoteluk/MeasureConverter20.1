package pl.bogdank.measureconverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Arrays;

import static pl.bogdank.measureconverter.lib.ConverterTool.*;

@WebServlet("/distance")
public class DistanceConvertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String metre = request.getParameter("metre");
        String centimetre = request.getParameter("centimetre");
        String millimetre = request.getParameter("millimetre");
        System.out.println(metre + " " + centimetre + " " + millimetre);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        BigDecimal[] array = new BigDecimal[3];

        if (!isFilledOnlyOne(metre, centimetre, millimetre) || !isFilledOneOf(metre, centimetre, millimetre))
            pw.println(ANSWER_PAGE_TEMPLATE + "<body><h1>Należy wypełnić tylko/przynajmniej jedno pole</h1><br/></body></html>");
        else {
            try {
                if (!metre.equals(""))
                    array = distanceConvert("m", new BigDecimal(metre));
                if (!centimetre.equals(""))
                    array = distanceConvert("cm", new BigDecimal(centimetre));
                if (!millimetre.equals(""))
                    array = distanceConvert("mm", new BigDecimal(millimetre));
            } catch (NumberFormatException ex) {
                pw.println(ex.getMessage());
            }

        }
        pw.println(ANSWER_PAGE_TEMPLATE + "<body><h1>Podana wartość w przeliczeniu na: </h1><br/><p>" +
                "metry: "+ array[0].toString() + "<br/>centymerty: " + array[1].toString() + "<br/> milimetry: " + array[2].toString() + "</p></body></html>");
        pw.close();
    }
}
