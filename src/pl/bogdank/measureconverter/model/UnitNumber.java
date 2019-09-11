package pl.bogdank.measureconverter.model;

import java.math.BigDecimal;

public class UnitNumber {
    private BigDecimal number;
    private String isoSymbol;

    public UnitNumber(BigDecimal number, String isoSymbol) {
        this.number = number;
        this.isoSymbol = isoSymbol;
    }

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public String getIsoSymbol() {
        return isoSymbol;
    }

    public void setIsoSymbol(String isoSymbol) {
        this.isoSymbol = isoSymbol;
    }

    @Override
    public String toString() {
        return number.toString() + " " + isoSymbol;
    }
}
