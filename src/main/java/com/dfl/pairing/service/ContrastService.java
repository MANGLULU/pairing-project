package com.dfl.pairing.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author DengFaLian
 * @Date 2020/10/8 22:56
 * @Version 1.0
 */
public interface ContrastService {

    /**
     * 求对比后答案后的对/错的题目
     * @param map1 题目的答案
     * @param map2 答题者的答案
     * @return
     */
    List<List<Integer>> getTitle(Map<Integer, String> map1, Map<Integer, String> map2);

    /**
     * 将结果写入Grade.txt文件
     * @param answerFilePath 答案的文件
     * @param actualFilePath 答题的文件
     * @throws IOException
     */
    void writeResult(String answerFilePath, String actualFilePath) throws IOException;
}
