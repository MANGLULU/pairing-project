package com.dfl.pairing.test;

import com.dfl.pairing.controller.QuestionsController;
import org.junit.Test;

import java.io.IOException;

/**
 * @Author DengFaLian
 * @Date 2020/10/6 16:38
 * @Version 1.0
 */
public class QuestionControllerTest {

    @Test
    public void test1() throws IOException {
        QuestionsController controller = new QuestionsController();
        controller.getQuestions(10, 10000);
    }

}
