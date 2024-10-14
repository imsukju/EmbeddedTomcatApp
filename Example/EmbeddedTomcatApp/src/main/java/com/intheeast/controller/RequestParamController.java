package com.intheeast.controller;


 // MediaType 클래스 임포트

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.MediaType;

@RestController
public class RequestParamController {

    // 단일 파라미터 처리
    @GetMapping("/requestparam")
    public String handleRequestParam(@RequestParam(value = "name", required = true) String name) {
        return "Hello, " + name + "!";
    }

    // 배열 파라미터 처리
    @GetMapping("/search")
    public List<String> searchPets(@RequestParam("type") String[] types) {
        return Arrays.asList(types);
    }

    // 폼 데이터를 처리하는 메서드
    @PostMapping(path = "/process", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Map<String, String> processForm(@RequestParam MultiValueMap<String, String> params) {
        Map<String, String> response = new HashMap<>();

        for (String key : params.keySet()) {
            response.put(key, String.join(", ", params.get(key)));
        }

        return response;
    }
}