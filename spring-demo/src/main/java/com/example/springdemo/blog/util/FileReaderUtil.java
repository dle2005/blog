package com.example.springdemo.blog.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderUtil {

    public static String fileReader(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));

        String str;
        StringBuilder result = new StringBuilder();
        while ((str = br.readLine()) != null) {
            result.append(str).append("\n");
        }

        return result.toString();
    }
}
