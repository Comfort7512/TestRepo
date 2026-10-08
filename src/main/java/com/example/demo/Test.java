package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Test {

    FileRepository repository;

    public Test(FileRepository repository){
        this.repository=repository;

    }

    @PostConstruct
    public void init() throws IOException {
        String path = repository.saveImage(
                "hello".getBytes(),
                "image.png"
        );
        System.out.println(path);
    }

}
