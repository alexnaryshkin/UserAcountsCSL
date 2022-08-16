package com.example.demo.s3.controller;

import com.example.demo.s3.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class StorageController {

    @Autowired
    private StorageService service;

    @PostMapping("/upload/{user}")
    public ResponseEntity<String> uploadFile(@PathVariable String user, @RequestParam(value = "file") MultipartFile file) {
        return new ResponseEntity<>(service.uploadFile(user, file), HttpStatus.OK);
    }

    @GetMapping("/download/{user}/{fileName}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String user, @PathVariable String fileName) {
        byte[] data = service.downloadFile(user, fileName);
        ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }

    @DeleteMapping("/delete/{user}/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String user, @PathVariable String fileName) {
        return new ResponseEntity<>(service.deleteFile(user, fileName), HttpStatus.OK);
    }
}