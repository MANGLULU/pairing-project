package com.dfl.pairing.controller;

import com.dfl.pairing.entity.Fraction;
import com.dfl.pairing.io.FileFunction;
import com.dfl.pairing.service.DigitalProcessingService;
import com.dfl.pairing.service.impl.DigitalProcessingServiceImpl;

import java.io.IOException;

/**
 * @Author DengFaLian
 * @Date 2020/10/5 10:36
 * @Version 1.0
 */
public class QuestionsController {

    DigitalProcessingService digitalProcessing = new DigitalProcessingServiceImpl();
    FileFunction file = new FileFunction();

    public void getQuestions(int number, int count) throws IOException {
        int temp = 1;
        Fraction answer = new Fraction();
        String question;
        StringBuilder context = new StringBuilder();
        StringBuilder result = new StringBuilder();
        while(temp <= count) {
            Fraction number1 = digitalProcessing.getNumber(number);
            Fraction number2 = digitalProcessing.getNumber(number);
            char symbol = digitalProcessing.getSymbol();
            switch (symbol) {
                case '+' :
                    answer.setElement(number1.getElement() * number2.getDenominator() + number1.getDenominator() * number2.getElement());
                    answer.setDenominator(number1.getDenominator() * number2.getDenominator());
                    question = temp  + ". "  + digitalProcessing.getProperFraction(number1)  + " " + symbol + " " + digitalProcessing.getProperFraction(number2) + " =";
                    //将question写入Exercises.txt
                    context.append(question + System.lineSeparator());
                    //将答案写入Answers.txt
                    result.append(temp + ". " + digitalProcessing.getProperFraction(answer) + System.lineSeparator());
                    temp++;
                    break;
                case '-' :
                    int tab = number1.getElement() * number2.getDenominator() - number1.getDenominator() * number2.getElement();
                    if(tab < 0) break;
                    answer.setElement(tab);
                    answer.setDenominator(number1.getDenominator() * number2.getDenominator());
                    question = temp  + ". "  + digitalProcessing.getProperFraction(number1)  + " " + symbol + " " + digitalProcessing.getProperFraction(number2) + " =";
                    //将question写入Exercises.txt
                    context.append(question + System.lineSeparator());
                    //将答案写入Answers.txt
                    result.append(temp + ". " + digitalProcessing.getProperFraction(answer) + System.lineSeparator());
                    temp++;
                    break;
                case '*' :
                    answer.setElement(number1.getElement() * number2.getElement());
                    answer.setDenominator(number1.getDenominator() * number2.getDenominator());
                    question = temp  + ". "  + digitalProcessing.getProperFraction(number1) + " × " + digitalProcessing.getProperFraction(number2) + " =";
                    //将question写入Exercises.txt
                    context.append(question + System.lineSeparator());
                    //将答案写入Answers.txt
                    result.append(temp + ". " + digitalProcessing.getProperFraction(answer) + System.lineSeparator());
                    temp++;
                    break;
                case '/' :
                    if (number2.getElement() == 0) break;
                    answer.setElement(number1.getElement() * number2.getDenominator());
                    answer.setDenominator(number1.getDenominator() * number2.getElement());
                    question = temp  + ". "  + digitalProcessing.getProperFraction(number1) + " ÷ " + digitalProcessing.getProperFraction(number2) + " =";
                    //将question写入Exercises.txt
                    context.append(question + System.lineSeparator());
                    //将答案写入Answers.txt
                    result.append(temp + ". " + digitalProcessing.getProperFraction(answer) + System.lineSeparator());
                    temp++;
                    break;
                default :
                    break;
            }
        }
        file.saveFile("Exercises.txt", context);
        file.saveFile("Answer.txt", result);
    }
}
