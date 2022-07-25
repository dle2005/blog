package com.example.springdemo.blog.util;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class FileReaderUtilTest {

    @Test
    public void fileReaderTest() throws IOException {
        final String path = "/Users/dlee/Desktop/blog/post/algorithm/leetcode/Add_Two_Numbers.md";

        System.out.println(FileReaderUtil.fileReader(path));
    }
}