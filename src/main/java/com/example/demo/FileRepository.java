package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Component
public class FileRepository {
    @Value("${upload.path}")
    private String FILE_UPLOAD_PATH;


    public String saveImage(byte[] content,String imageName) throws IOException {
        Path path = Paths.get(FILE_UPLOAD_PATH +"/"+ new Date().getTime()+"-"+imageName);
        Files.createDirectories(path.getParent());
        Files.write(path,content);
        return path.toAbsolutePath().toString();

    }

    public FileSystemResource findImageByLocation(String location){
        try{
            return new FileSystemResource(Paths.get(location));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }




}
