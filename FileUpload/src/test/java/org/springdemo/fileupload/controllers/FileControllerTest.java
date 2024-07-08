package org.springdemo.fileupload.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FileControllerTest {

    @Autowired
    RestTemplate restTemplate;

    @Test
    void fileUploadTest() {
        //1 . Set Headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String,Object> body = new LinkedMultiValueMap<>();
        body.add("file", new ClassPathResource("/wallpaper.png"));

        HttpEntity<MultiValueMap<String,Object>> request = new HttpEntity<>(body, headers);

        ResponseEntity<Boolean> response = restTemplate.postForEntity("http://localhost:8080/upload-file", request, Boolean.class);

        assertEquals(Boolean.TRUE, response.getBody());

    }

    @Test
    void fileDownloadTest() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_OCTET_STREAM));

        HttpEntity<byte[]> request = new HttpEntity<>(headers);

        String fileName = "wallpaper.png";

        ResponseEntity<byte[]> response = restTemplate.exchange("http://localhost:8080/download/"  + fileName, HttpMethod.GET,request, byte[].class);

        Files.write(Paths.get("/home/raj/Documents/" + fileName),response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}