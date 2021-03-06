package com.dfl.pairing.test;

import com.dfl.pairing.io.FileFunction;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

/**
 * @Author FangZeKai
 * @Date 2020/10/2 22:18
 * @Version 1.0
 */
public class FileFunctionFileTest {

    @Test
    public void test1() throws IOException {
        StringBuilder context = new StringBuilder();
        context.append("你好");
        new FileFunction().saveFile("Hello.txt", context);
    }

    @Test
    public void test2() {
        Map<Integer, String> context = new FileFunction().readFile("Answer.txt");
        System.out.println(context);
    }
}
