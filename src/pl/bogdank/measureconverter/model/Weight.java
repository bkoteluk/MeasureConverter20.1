package pl.bogdank.measureconverter.model;

import pl.bogdank.measureconverter.exceptions.InvalidFormDataException;

import java.math.BigDecimal;

public class Weight {
    private UnitNumber kilogram;
    private UnitNumber gram;
    private UnitNumber milligram;

    public Weight(String kilogram, String gram, String milligram) throws NumberFormatException, InvalidFormDataException {
            validate(kilogram, gram, milligram);
            if (kilogram.equals(""))
                this.kilogram = null;
            else
                this.kilogram = new UnitNumber(new BigDecimal(kilogram), "kg");
            if (gram.equals(""))
                this.gram = null;
            else
                this.gram = new UnitNumber(new BigDecimal(gram), "g");
            if (milligram.equals(""))
                this.milligram = null;
            else
                this.milligram = new UnitNumber(new BigDecimal(milligram), "mm");
    }

    public UnitNumber getKilogram() {
        return kilogram;
    }

    public void setKilogram(UnitNumber kilogram) {
        this.kilogram = kilogram;
    }

    public UnitNumber getGram() {
        return gram;
    }

    public void setGram(UnitNumber gram) {
        this.gram = gram;
    }

    public UnitNumber getMilligram() {
        return milligram;
    }

    public void setMilligram(UnitNumber milligram) {
        this.milligram = milligram;
    }

    private void validate(String kilogram, String gram, String milligram) throws InvalidFormDataException {
        if(areUnfilled(kilogram, gram, milligram)) {
            throw new InvalidFormDataException("Nieprawidłowo wypełełniony fomularz: (brak wypełnionych pól)");
        }
        if (!isOneCompleted(kilogram, gram, milligram)) {
            throw new InvalidFormDataException("Nieprawidłowo wypełełniony fomularz: (wypełniono więcej niż jedno pole)");
        }
    }

    private boolean areUnfilled(String meter, String centimeter, String millimeter) {
        return (meter.equals("") && centimeter.equals("") && millimeter.equals(""));
    }

    private boolean isOneCompleted(String kilogram, String gram, String milligram) {
        return !((!kilogram.equals("") && !gram.equals("")) || (!kilogram.equals("") && !milligram.equals("")) || (!gram.equals("") && !milligram.equals("")));
    }

    @Override
    public String toString() {
        return "kilogramy: " + kilogram + "<br/> " + "gramy: " + gram + "<br/>" + "miligramy: " + milligram + "<br/>" ;
    }
}
