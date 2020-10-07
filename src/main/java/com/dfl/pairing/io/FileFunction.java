package com.dfl.pairing.io;

import java.io.*;

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
}
