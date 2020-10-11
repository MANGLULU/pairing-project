package com.dfl.pairing.service;

import com.dfl.pairing.entity.Fraction;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

/**
 * @Author DengFaLian
 * @Date 2020/10/10 17:03
 * @Version 1.0
 */
public interface Calculate {

    /**
     * 求运算式转的后缀表达式
     * @param list
     * @return
     */
    List<Fraction> listSuffix(List<Fraction> list);

    /**
     * 获得运算符的优先级
     * @param symbol
     * @return
     */
    int letterPriority(Fraction symbol);

    /**
     * 计算算式的结果
     * @param list 表达式转的后缀表达式
     * @return 表达式的结果
     */
    Fraction calculate(List<Fraction> list);

    /**
     * 运算
     * @param num1 第一个数值
     * @param num2 第二个数值
     * @param letter 运算符
     * @return
     */
    Fraction calculateNum(Fraction num1, Fraction num2, String letter);

    /**
     * 获得最后结果
     * @param list
     * @return
     */
    Fraction getResult(List<Fraction> list);
}
