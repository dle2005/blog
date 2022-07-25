package com.example.springdemo.blog.dto;

import lombok.*;

public class WriteDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Req {
        private String access_token;
        private String output;
        private String blogName;
        private String title;
        private String content;
        private String visibility;
        private String category;
        private String published;
        private String slogan;
        private String tag;
        private String acceptComment;
        private String password;
    }
}
