package com.dfl.pairing.service;

import java.util.List;
import java.util.Map;

/**
 * @Author DengFaLian
 * @Date 2020/10/8 22:56
 * @Version 1.0
 */
public interface ContrastService {

    /**
     * 求对比后答案的对错题数和对应的题目
     * @param map1 题目的答案
     * @param map2 答题者的答案
     * @return
     */
    List<Integer>[] getResult(Map<Integer, String> map1, Map<Integer, String> map2);
}
