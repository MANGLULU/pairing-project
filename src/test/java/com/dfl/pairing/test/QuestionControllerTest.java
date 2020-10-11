package com.dfl.pairing.test;

import com.dfl.pairing.controller.QuestionsController2;
import org.junit.Test;

import java.io.IOException;

/**
 * @Author FangZeKai
 * @Date 2020/10/6 16:38
 * @Version 1.0
 */
public class QuestionControllerTest {

    @Test
    public void test1() throws IOException {
        QuestionsController2 controller = new QuestionsController2();
        controller.getQuestions(10, 10);
    }

}
