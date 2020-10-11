package com.dfl.pairing;

import com.dfl.pairing.controller.QuestionsController2;
import com.dfl.pairing.service.ContrastService;
import com.dfl.pairing.service.impl.ContrastServiceImpl;

import java.io.IOException;
import java.util.Scanner;

/**
 * @Author DengFaLian
 * @Date 2020/10/9 20:20
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) throws IOException {
        QuestionsController2 questionsController = new QuestionsController2();
        System.out.println("请根据如下格式输入！");
        System.out.println("-n 生成题目的个数 -r 题目数值的范围");
        Scanner scanner = new Scanner(System.in);
        String text1 = scanner.nextLine();
        String[] parameters1 = text1.split(" ");
        questionsController.getQuestions(Integer.parseInt(parameters1[1]), Integer.parseInt(parameters1[3]));
        System.out.println("请根据如下格式输入！");
        System.out.println("-e 需要批改文件 -a 答案文件");
        String text2 = scanner.nextLine();
        String[] parameters2 = text2.split(" ");
        ContrastService contrastService = new ContrastServiceImpl();
        contrastService.writeResult(parameters2[3], parameters2[1]);
    }
}
