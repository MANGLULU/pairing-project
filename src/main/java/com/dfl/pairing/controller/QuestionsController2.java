package com.dfl.pairing.controller;

import com.dfl.pairing.entity.Fraction;
import com.dfl.pairing.io.FileFunction;
import com.dfl.pairing.service.Calculate;
import com.dfl.pairing.service.DigitalProcessingService;
import com.dfl.pairing.service.impl.CalculateImpl;
import com.dfl.pairing.service.impl.DigitalProcessingServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author DengFaLian
 * @Date 2020/10/5 10:36
 * @Version 1.0
 */
public class QuestionsController2 {

    public void getQuestions(int count, int number) throws IOException {
        DigitalProcessingService digitalProcessing = new DigitalProcessingServiceImpl();
        Calculate calculate = new CalculateImpl();
        FileFunction file = new FileFunction();
        int temp = 1;
        Fraction answer = null;
        StringBuilder context = new StringBuilder();
        StringBuilder result = new StringBuilder();
        while(temp <= count) {
            /*随机生成运算符的个数*/
            int symbols = (int) (Math.random() * 3 + 1);
            List<Fraction> list = new ArrayList<>();
            String question = "";
            int flag = 0;
            int flag1 = 0;
            for(int i = 1; i <= symbols*2+1; i++) {
                Fraction operation = new Fraction();
                Fraction symbolOperation = new Fraction();
                if(i % 2 == 0) {
                    String symbol = digitalProcessing.getSymbol();
                    operation.setSymbol(symbol);
                    question = question + " " + symbol;
                } else {

                    if (i < symbols*2-2 && flag == 0) {
                        int flag2 = (int) (Math.random() * 2);
                        if(flag2 == 0) {
                            String symbol = "(";
                            symbolOperation.setSymbol(symbol);
                            question = question + " " + symbol;
                            flag = 1;
                            flag1 = i;
                            list.add(symbolOperation);
                        }
                        list.add(operation);
                    }
                    operation = digitalProcessing.getNumber(number);
                    question = question + " " + digitalProcessing.getProperFraction(operation);
                }
                list.add(operation);
                if (i == flag1+2 && flag == 1) {
                    String symbol = ")";
                    symbolOperation.setSymbol(symbol);
                    question = question + " " + symbol;
                    flag =2;
                    list.add(symbolOperation);
                }
            }
            try {
                answer = calculate.getResult(list);
            } catch (Exception e) {
                continue;
            }
            question = temp + "." + question + " =";
            context.append(question + System.lineSeparator());
            result.append(temp + ". " + digitalProcessing.getProperFraction(answer) + System.lineSeparator());
            temp++;
        }
        file.saveFile("Exercises.txt", context);
        file.saveFile("Answer.txt", result);
    }
}
