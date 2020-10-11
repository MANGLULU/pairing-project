package com.dfl.pairing.test;

import com.dfl.pairing.entity.Fraction;
import com.dfl.pairing.service.Calculate;
import com.dfl.pairing.service.DigitalProcessingService;
import com.dfl.pairing.service.impl.CalculateImpl;
import com.dfl.pairing.service.impl.DigitalProcessingServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author FangZeKai
 * @Date 2020/10/10 21:28
 * @Version 1.0
 */
public class CalculateTest {

        @Test
        public void test() {
            Calculate calculate = new CalculateImpl();
            List<Fraction> list = new ArrayList<>();
            Fraction fraction1 = new Fraction();
            fraction1.setElement(30);
            fraction1.setDenominator(10);
            Fraction fraction3 = new Fraction();
            fraction3.setElement(10);
            fraction3.setDenominator(20);
            Fraction fraction2 = new Fraction();
            fraction2.setSymbol("÷");
            list.add(fraction1);
            list.add(fraction2);
            list.add(fraction3);
            Fraction result = calculate.getResult(list);
            String answer = new DigitalProcessingServiceImpl().getProperFraction(result);
            System.out.println("计算结果 " + answer);
    }
}
