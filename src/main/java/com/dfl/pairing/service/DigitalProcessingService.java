package com.dfl.pairing.service;

import com.dfl.pairing.entity.Fraction;

import java.util.List;

/**
 * @Author DengFaLian
 * @Date 2020/10/3 14:59
 * @Version 1.0
 */
public interface DigitalProcessingService {


    /**
     * 求最大公约数
     * @param element 分子
     * @param denominator 分母
     * @return
     */
    int getCommonMeasure(int element, int denominator);


    /**
     * 规范格式
     * @param fraction
     * @return
     */
    String getProperFraction(Fraction fraction);


    /**
     * 获取随机数
     * @return
     */
    Fraction getNumber(int number);

    /**
     * 获得符号
     * @return
     */
    char getSymbol();
}
