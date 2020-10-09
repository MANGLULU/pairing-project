package com.dfl.pairing.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author DengFaLian
 * @Date 2020/10/2 10:48
 * @Version 1.0
 */
public class FileFunction {
    /**
     *
     * @param path
     * @param context
     * @throws IOException
     */
    public void saveFile(String path, StringBuilder context) throws IOException {
        File file = new File(path);
        if(!file.exists()) {
            file.createNewFile();
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"utf-8")));
        out.write(String.valueOf(context));
        out.flush();
        out.close();
    }


    /**
     * 读取文件
     * @param path 读取文件的路径
     * @return
     */
    public Map<Integer, String> readFile(String path) {
        File file = new File(path);
//        StringBuilder context = new StringBuilder();
        Map<Integer, String> map = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            String temp = null;
            while ((temp = reader.readLine()) != null) {
//                context.append(temp + System.lineSeparator());
                map.put(Integer.valueOf(temp.split(". ")[0]), temp.split(". ")[1]);
            }
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return map;
    }
}

