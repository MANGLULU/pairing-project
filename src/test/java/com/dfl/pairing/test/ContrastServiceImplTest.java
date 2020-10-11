package com.dfl.pairing.test;

import com.dfl.pairing.io.FileFunction;
import com.dfl.pairing.service.ContrastService;
import com.dfl.pairing.service.impl.ContrastServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author FangZeKai
 * @Date 2020/10/9 16:34
 * @Version 1.0
 */
public class ContrastServiceImplTest {
    ContrastService contrastService = new ContrastServiceImpl();

    @Test
    public void test1() {
        FileFunction function = new FileFunction();
        Map<Integer, String> map1 = function.readFile("Answer.txt");
        Map<Integer, String> map2 = function.readFile("Answer.txt");
        List<List<Integer>> result = contrastService.getTitle(map1, map2);
        Assert.assertEquals(true, result.get(1).isEmpty());
    }


    @Test
    public void test2() throws IOException {
        contrastService.writeResult("exercisefile.txt", "Answer.txt");
    }
}
