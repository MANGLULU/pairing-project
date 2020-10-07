package com.dfl.pairing.test;

import com.dfl.pairing.entity.Fraction;
import com.dfl.pairing.service.DigitalProcessingService;
import com.dfl.pairing.service.impl.DigitalProcessingServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author DengFaLian
 * @Date 2020/10/4 22:32
 * @Version 1.0
 */
public class DigitalProcessingServiceTest {

    private DigitalProcessingService digitalProcessingService = new DigitalProcessingServiceImpl();

    @Test
    public void test1() {
        Fraction number = digitalProcessingService.getNumber(10);
        System.out.println(number);
    }


    @Test
    public void test2() {
//        int commonMeasure = digitalProcessingService.getCommonMeasure(0, 7);
//        Assert.assertEquals(1,commonMeasure);
        int i = 0;
        while (i < 100) {
            Fraction number = digitalProcessingService.getNumber(10);
            int commonMeasure = digitalProcessingService.getCommonMeasure(number.getElement(), number.getDenominator());
            System.out.println(number.getElement() + " " + number.getDenominator() + " " + commonMeasure);
            i++;
        }
    }

    @Test
    public void test3() {
        Fraction fraction = new Fraction();
        fraction.setDenominator(4);
        fraction.setElement(9);
        String properFraction = digitalProcessingService.getProperFraction(fraction);
        Assert.assertEquals("2'1/4", properFraction);
    }

    @Test
    public void test4() {
        char symbol = digitalProcessingService.getSymbol();
        Map<Character, Integer> map = new HashMap<>();
        map.put('+', 0);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 3);
        Assert.assertEquals(true, map.containsKey(symbol));
    }
}
