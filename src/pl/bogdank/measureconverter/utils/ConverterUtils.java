package pl.bogdank.measureconverter.utils;

import pl.bogdank.measureconverter.model.Distance;
import pl.bogdank.measureconverter.model.UnitNumber;
import pl.bogdank.measureconverter.model.Weight;

import java.math.BigDecimal;

public class ConverterUtils {

    public void distanceConvert(Distance distance) {

        if (distance.getMetre() != null) {
            BigDecimal metre = distance.getMetre().getNumber();
            UnitNumber centimetre = new UnitNumber(metre.multiply(new BigDecimal("100")), "cm");
            UnitNumber millimetre = new UnitNumber(metre.multiply(new BigDecimal("1000")), "mm");
            distance.setCentimetre(centimetre);
            distance.setMillimetre(millimetre);
        } else if (distance.getCentimetre() != null) {
            BigDecimal centimetre = distance.getCentimetre().getNumber();
            UnitNumber metre = new UnitNumber(centimetre.divide(new BigDecimal("100")), "m");
            UnitNumber millimetre = new UnitNumber(centimetre.multiply(new BigDecimal("10")), "mm");
            distance.setMetre(metre);
            distance.setMillimetre(millimetre);
        } else if (distance.getMillimetre() != null) {
            BigDecimal millimetre = distance.getMillimetre().getNumber();
            UnitNumber metre = new UnitNumber(millimetre.divide(new BigDecimal("1000")), "m");
            UnitNumber centimetre = new UnitNumber(millimetre.divide(new BigDecimal("10")), "cm");
            distance.setMetre(metre);
            distance.setCentimetre(centimetre);
        }
    }

    public void weightConvert(Weight weight) {

        if (weight.getKilogram() != null) {
            BigDecimal kilogram = weight.getKilogram().getNumber();
            UnitNumber gram = new UnitNumber(kilogram.multiply(new BigDecimal("1000")), "g");
            UnitNumber milligram = new UnitNumber(kilogram.multiply(new BigDecimal("1000000")), "mg");
            weight.setGram(gram);
            weight.setMilligram(milligram);
        } else if (weight.getGram() != null) {
            BigDecimal gram = weight.getGram().getNumber();
            UnitNumber kilogram = new UnitNumber(gram.divide(new BigDecimal("1000")), "kg");
            UnitNumber milligram = new UnitNumber(gram.multiply(new BigDecimal("1000")), "mg");
            weight.setKilogram(kilogram);
            weight.setMilligram(milligram);
        } else if (weight.getMilligram() != null) {
            BigDecimal milligram = weight.getMilligram().getNumber();
            UnitNumber kilogram = new UnitNumber(milligram.divide(new BigDecimal("1000000")), "kg");
            UnitNumber gram = new UnitNumber(milligram.divide(new BigDecimal("1000")), "g");
            weight.setKilogram(kilogram);
            weight.setGram(gram);
        }
    }
}
