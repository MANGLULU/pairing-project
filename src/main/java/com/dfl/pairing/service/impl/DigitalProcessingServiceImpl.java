package com.dfl.pairing.service.impl;

import com.dfl.pairing.entity.Fraction;
import com.dfl.pairing.service.DigitalProcessingService;


/**
 * @Author DengFaLian
 * @Date 2020/10/3 15:18
 * @Version 1.0
 */
public class DigitalProcessingServiceImpl implements DigitalProcessingService {

    @Override
    public int getCommonMeasure(int element, int denominator) {
        if(element == 0) {
            return 1;
        }
        while(true) {
            if((element = element % denominator) == 0) {
                return denominator;
            } else if((denominator = denominator % element) == 0) {
                return element;
            }
        }
    }

    @Override
    public String getProperFraction(Fraction fraction) {
        if(fraction.getElement() == 0) return 0 + "";
        int commonMeasure = getCommonMeasure(fraction.getElement(), fraction.getDenominator());
        fraction.setElement(fraction.getElement() / commonMeasure);
        fraction.setDenominator(fraction.getDenominator() / commonMeasure);
        if(fraction.getElement() >= fraction.getDenominator()) {
            int quotient = fraction.getElement() / fraction.getDenominator();
            int remainder = fraction.getElement() % fraction.getDenominator();
            if(remainder == 0) {
                return quotient + "";
            }
            return quotient + "'" + remainder + "/" + fraction.getDenominator();
        }
        return fraction.getElement() + "/" + fraction.getDenominator();
    }

    @Override
    public Fraction getNumber(int number) {
        Fraction fraction = new Fraction();
        fraction.setElement((int) (0 + Math.random() * (number)));
        fraction.setDenominator((int) (1 + Math.random() * (number - 1)));
//        if(fraction.getElement() >= number || fraction.getDenominator() >= number) {
//            System.err.println("数值大于规定数值");
//        }
        return fraction;
    }

    @Override
    public char getSymbol() {
        char symbol = ' ';
        int symbolNumber = (int) (Math.random() * 4);
        switch (symbolNumber) {
            case 0 :
                symbol = '+';
                break;
            case 1 :
                symbol = '-';
                break;
            case 2 :
                symbol = '*';
                break;
            case 3 :
                symbol = '/';
                break;
            default:
                System.out.println("获取符号失败");
        }
        return symbol;
    }
}
