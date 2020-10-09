package com.dfl.pairing.service.impl;

import com.dfl.pairing.io.FileFunction;
import com.dfl.pairing.service.ContrastService;

import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author DengFaLian
 * @Date 2020/10/8 23:11
 * @Version 1.0
 */
public class ContrastServiceImpl implements ContrastService {

    @Override
    public List<List<Integer>> getTitle(Map<Integer, String> map1, Map<Integer, String> map2) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList();
        List<Integer> list2 = new ArrayList();
        int i = 1;
        while(i <= map1.size()) {
            if(map1.get(i).equals(map2.get(i))) {
                list1.add(i);
            } else {
                list2.add(i);
            }
            i++;
        }
        list.add(list1);
        list.add(list2);
        return list;
    }

    @Override
    public void getResult(String answerFilePath, String actualFilePath) throws IOException {
        FileFunction fileHandler = new FileFunction();
        StringBuilder context = new StringBuilder();
        Map<Integer, String> answerFile = fileHandler.readFile(answerFilePath);
        Map<Integer, String> actualFile = fileHandler.readFile(actualFilePath);
        List<List<Integer>> lists = getTitle(answerFile, actualFile);
        String CorrectTitle = "Correct: " + lists.get(0).size() + " (" + StringUtils.strip(lists.get(0).toString(),"[]") + ")";
        String WrongTitle = "Wrong: " + lists.get(1).size() + " (" + StringUtils.strip(lists.get(1).toString(),"[]") + ")";
        context.append(CorrectTitle + System.lineSeparator());
        context.append(WrongTitle + System.lineSeparator());
        fileHandler.saveFile("Grade.txt", context);
    }
}
