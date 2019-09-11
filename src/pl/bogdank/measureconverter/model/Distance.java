package pl.bogdank.measureconverter.model;


import pl.bogdank.measureconverter.exceptions.InvalidFormDataException;

import java.math.BigDecimal;

public class Distance {
    private UnitNumber metre;
    private UnitNumber centimetre;
    private UnitNumber millimetre;

    public Distance(String metre, String centimetre, String millimetre) throws NumberFormatException, InvalidFormDataException{
            validate(metre, centimetre, millimetre);
            if (metre.equals(""))
                this.metre = null;
            else
                this.metre = new UnitNumber(new BigDecimal(metre), "m");
            if (centimetre.equals(""))
                this.centimetre = null;
            else
                this.centimetre = new UnitNumber(new BigDecimal(centimetre), "cm");
            if (millimetre.equals(""))
                this.millimetre = null;
            else
                this.millimetre = new UnitNumber(new BigDecimal(millimetre), "mm");
    }

    public UnitNumber getMetre() {
        return metre;
    }

    public UnitNumber getCentimetre() {
        return centimetre;
    }

    public UnitNumber getMillimetre() {
        return millimetre;
    }

    public void setMetre(UnitNumber metre) {
        this.metre = metre;
    }

    public void setCentimetre(UnitNumber centimetre) {
        this.centimetre = centimetre;
    }

    public void setMillimetre(UnitNumber millimetre) {
        this.millimetre = millimetre;
    }

    private void validate(String meter, String centimeter, String millimeter) throws InvalidFormDataException {
        if(areUnfilled(meter, centimeter, millimeter)) {
            throw new InvalidFormDataException("Nieprawidłowo wypełełniony fomularz: (brak wypełnionych pól)");
        }
        if (!isOneCompleted(meter, centimeter, millimeter)) {
            throw new InvalidFormDataException("Nieprawidłowo wypełełniony fomularz: (wypełniono więcej niż jedno pole)");
        }
    }

    private boolean areUnfilled(String meter, String centimeter, String millimeter) {
        return (meter.equals("") && centimeter.equals("") && millimeter.equals(""));
    }

    private boolean isOneCompleted(String meter, String centimeter, String millimeter) {
        return !((!meter.equals("") && !centimeter.equals("")) || (!meter.equals("") && !millimeter.equals("")) || (!centimeter.equals("") && !millimeter.equals("")));
    }

    @Override
    public String toString() {
        return "metry: " + metre + "<br/> " + "centymetry: " + centimetre + "<br/>" + "milimetry: " + millimetre + "<br/>" ;
    }
}
