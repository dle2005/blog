package com.example.springdemo.blog.controller;

import com.example.springdemo.blog.dto.WriteDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WriteControllerTest {
    private final String accessToken = "9b38a6565266dbce4b8bf8d1fb693c4f_f6577739e47c7d28d094608852788a03";
    private final String blogName = "dlee0129";

    @Autowired
    private WriteController writeController;

    @Test
    public void writeTest() {
        WriteDto.Req req = WriteDto.Req.builder()
                .access_token(accessToken)
                .output("json")
                .blogName(blogName)
                .title("Test")
                .content("Test")
                .category("1051222")
                .build();

        writeController.post(req);
    }
}