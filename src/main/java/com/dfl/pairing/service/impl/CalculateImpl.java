package com.dfl.pairing.service.impl;

import com.dfl.pairing.entity.Fraction;
import com.dfl.pairing.service.Calculate;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author DengFaLian
 * @Date 2020/10/10 17:08
 * @Version 1.0
 */
public class CalculateImpl implements Calculate{

    @Override
    public List<Fraction> listSuffix(List<Fraction> list) {
        Stack<Fraction> letterStack = new Stack<>();
        List<Fraction> result = new ArrayList<>();
        for (Fraction str:list){
            /*操作数*/
            if(str.getSymbol() == null){
                result.add(str);
                continue;
            }
            /*左括号*/
            else if(str.getSymbol().equals("(")){
                letterStack.push(str);
                continue;
            }
            /*右括号*/
            else if(str.getSymbol().equals(")")){
                while(!letterStack.peek().getSymbol().equals("(")){
                    result.add(letterStack.pop());
                }
                letterStack.pop();
                continue;
            }
            /*运算符*/
           else if(letterStack.isEmpty() || letterStack.peek().getSymbol().equals("(")){
                letterStack.push(str);
                continue;
            }
           else if(letterPriority(str) > letterPriority(letterStack.peek())){
                letterStack.push(str);
            }
           else{
                while(!letterStack.isEmpty() && !letterStack.peek().getSymbol().equals("(") && letterPriority(str)<=letterPriority(letterStack.peek())){
                    result.add(letterStack.pop());
                }
                letterStack.push(str);
            }

        }

        while (!letterStack.isEmpty()){
            result.add(letterStack.pop());
        }
        return result;

    }

    @Override
    public int letterPriority(Fraction symbol) {
        switch (symbol.getSymbol()){
            case "+":
            case "-":
                return 1;
            case "×":
            case "÷":
                return 2;
        }
        throw new RuntimeException(symbol +" is not a letter");
    }

    @Override
    public Fraction calculate(List<Fraction> list) {
        Stack<Fraction> calculateStack = new Stack<>();
        Fraction num1 = null;
        Fraction num2 = null;
        for (Fraction str:list){
            if(str.getSymbol() == null){
                calculateStack.push(str);
            }else{
                num1 = calculateStack.pop();
                num2 = calculateStack.pop();
                calculateStack.push(calculateNum(num2,num1,str.getSymbol()));
            }
        }
        return  calculateStack.pop();
    }

    @Override
    public Fraction calculateNum(Fraction num1, Fraction num2, String symbol) {
        switch (symbol){
            case "+":
                return new Fraction().ADD(num1, num2);
            case "-":
                return new Fraction().Subtract(num1, num2);
            case "×":
                return new Fraction().Multiply(num1, num2);
            case "÷":
                return new Fraction().Division(num1, num2);
        }
        throw new RuntimeException(symbol +"不是一个运算符号！！！");
    }

    @Override
    public Fraction getResult(List<Fraction> list) {
        List<Fraction> listSuffix = listSuffix(list);
        Fraction result = calculate(listSuffix);
        return result;
    }

}
