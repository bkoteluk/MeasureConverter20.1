package pl.bogdank.measureconverter.lib;

import java.math.BigDecimal;

public class ConverterTool {

    public static String ANSWER_PAGE_TEMPLATE = "<html>\n" +
            "<head>\n" +
            "    <title>Przelicznik metryczny</title>\n" +
            "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\n" +
            "          integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n" +
            "    <style>\n" +
            "        body {\n" +
            "            margin-left: 200px;\n" +
            "            margin-right: 200px;\n" +
            "        }\n" +
            "    </style>\n" +
            "</head>\n" +
            "<body>";

    public static BigDecimal[] distanceConvert(String isoUnit, BigDecimal value) {
        BigDecimal[] array = new BigDecimal[3];
        switch (isoUnit) {
            case "m" :
                array[0] = value;
                array[1] = value.multiply(new BigDecimal("100"));
                array[2] = value.multiply(new BigDecimal("1000"));
                break;
            case "cm" :
                array[0] = value.divide(new BigDecimal(100));
                array[1] = value;
                array[2] = value.multiply(new BigDecimal("10"));
                break;
            case "mm"  :
                array[0] = value.divide(new BigDecimal("1000"));
                array[1] = value.divide(new BigDecimal("10"));
                array[2] = value;
                break;
        }
        return array;
    }

    public static BigDecimal[] weightConvert(String isoUnit, BigDecimal value) {
        BigDecimal[] array = new BigDecimal[3];
        switch (isoUnit) {
            case "kg" :
                array[0] = value;
                array[1] = value.multiply(new BigDecimal("1000"));
                array[2] = value.multiply(new BigDecimal("1000000"));
                break;
            case "g" :
                array[0] = value.divide(new BigDecimal("1000"));
                array[1] = value;
                array[2] = value.multiply(new BigDecimal("1000"));;
                break;
            case "mg"  :
                array[0] = value.divide(new BigDecimal("1000000"));
                array[1] = value.divide(new BigDecimal("1000"));
                array[2] = value;
                break;
        }
        return array;
    }

    public static boolean isFilledOneOf(String parameter1, String parameter2, String parameter3) {
        return !(parameter1.equals("") && parameter2.equals("") && parameter3.equals(""));
    }

    public static boolean isFilledOnlyOne(String parameter1, String parameter2, String parameter3) {
        return !((!parameter1.equals("") && !parameter2.equals("")) || (!parameter1.equals("") && !parameter3.equals("")) || (!parameter2.equals("") && !parameter3.equals("")));
    }
}
