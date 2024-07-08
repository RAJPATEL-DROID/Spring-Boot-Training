package org.springdemo.fileupload.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.attribute.standard.Media;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
public class FileController {

    @Value("${uploadDir}")
    private String UPLOAD_DIR;

    @RequestMapping(value = "/upload-file", method = RequestMethod.POST)
    public Boolean upload(@RequestParam("file") MultipartFile file) throws IOException {

        file.transferTo(new File(UPLOAD_DIR + file.getOriginalFilename()));
        return true;
    };

    @GetMapping(value = "/download/{fileName}")
    public ResponseEntity<byte[]> download(@PathVariable("fileName") String fileName) throws IOException {
        byte[] fileData =Files.readAllBytes(new File(UPLOAD_DIR + fileName).toPath());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setContentLength(fileData.length);
        return new ResponseEntity<byte[]>(fileData,headers, HttpStatus.OK);

    }
}
