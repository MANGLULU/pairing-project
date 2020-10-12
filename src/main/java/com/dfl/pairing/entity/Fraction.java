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

    /*符号*/
    private String symbol;


    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Fraction() {}

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

    /**
     * 加法
     * @param number1
     * @param number2
     * @return
     */
    public Fraction ADD(Fraction number1, Fraction number2) {
        Fraction answer = new Fraction();
        answer.setElement(number1.getElement() * number2.getDenominator() + number1.getDenominator() * number2.getElement());
        answer.setDenominator(number1.getDenominator() * number2.getDenominator());
        return answer;
    }


    /**
     * 减法
     * @param number1
     * @param number2
     * @return
     */
    public Fraction Subtract(Fraction number1, Fraction number2) {
        Fraction answer = new Fraction();
        if ((number1.getElement() * number2.getDenominator() - number1.getDenominator() * number2.getElement()) < 0)
            throw  new RuntimeException("运算过程中不能有负数");
        answer.setElement(number1.getElement() * number2.getDenominator() - number1.getDenominator() * number2.getElement());
        answer.setDenominator(number1.getDenominator() * number2.getDenominator());
        return answer;
    }

    /**
     * 乘法
     * @param number1
     * @param number2
     * @return
     */
    public Fraction Multiply(Fraction number1, Fraction number2) {
        Fraction answer = new Fraction();
        answer.setElement(number1.getElement() * number2.getElement());
        answer.setDenominator(number1.getDenominator() * number2.getDenominator());
        return answer;
    }

    /**
     * 乘法
     * @param number1
     * @param number2
     * @return
     */
    public Fraction Division(Fraction number1, Fraction number2) {
        Fraction answer = new Fraction();
        if (number2.getElement() == 0) throw new RuntimeException("除数不能为0");
        answer.setElement(number1.getElement() * number2.getDenominator());
        answer.setDenominator(number1.getDenominator() * number2.getElement());
        return answer;
    }

    @Override
    public String toString() {
        if(symbol != null) {
            return symbol;
        } else if(element == 0) {
            return "0";
        } else if(element % denominator == 0) {
            return element / denominator + "";
        }else {
            return element + "/" + denominator;
        }
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Fraction)) return false;
//        Fraction number = (Fraction) o;
//        return getElement() == number.getElement() &&
//                getDenominator() == number.getDenominator();
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getElement(), getDenominator());
//    }
}
