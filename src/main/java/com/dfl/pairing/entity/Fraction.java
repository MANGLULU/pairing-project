package com.dfl.pairing.entity;

import java.util.Objects;

/**
 * @Author DengFaLian
 * @Date 2020/10/2 22:33
 * @Version 1.0
 */
public class Fraction {

    /*分子*/
    private int element;

    /*分母*/
    private int denominator;

    public Fraction() {}

//    public Number(int element, int denominator) {
//        this.element = element;
//        this.denominator = denominator;
//    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        if(element == 0) {
            return "0";
        } else if(element % denominator == 0) {
            return element / denominator + "";
        }else {
            return element + "/" + denominator;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fraction)) return false;
        Fraction number = (Fraction) o;
        return getElement() == number.getElement() &&
                getDenominator() == number.getDenominator();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getElement(), getDenominator());
    }
}
