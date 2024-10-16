package com.MyWepOne.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.core.io.Resource;

@Controller
public class FileDownload {
    @GetMapping("/download")
    public ResponseEntity<Resource> downloadFile() {
        try {
            // ClassPath에서 파일을 가져옴
            Resource resource = new ClassPathResource("META-INF/downloadFile/Hello.txt");

            // 파일이 존재하는지 확인
            if (!resource.exists()) {
                return ResponseEntity.notFound().build();
            }

            // 파일 다운로드를 위한 HTTP 헤더 설정
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)  // 파일 타입 설정 (일반 파일의 경우)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);

        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
