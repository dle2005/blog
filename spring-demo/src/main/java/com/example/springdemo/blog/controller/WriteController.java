package com.example.springdemo.blog.controller;

import com.example.springdemo.blog.dto.WriteDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/post")
public class WriteController {

    @RequestMapping(method = RequestMethod.POST, value = "/write")
    public void post(@RequestBody WriteDto.Req req) {
        final String path = "https://tistory.com/apis/post/write";

        URI uri = UriComponentsBuilder
                .fromUriString(path)
                .encode()
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        Object response = restTemplate.postForEntity(uri, req, Object.class);

        System.out.println(response);
    }
}
