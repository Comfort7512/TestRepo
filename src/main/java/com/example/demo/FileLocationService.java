package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FileLocationService {
    @Autowired
    private ImageRepo imageRepo;

    @Autowired
    private FileRepository fileRepository;

    public Long saveImage(byte[] content,String imageName) throws IOException {

        String path = fileRepository.saveImage(content,imageName);

        return imageRepo.save(new Image(
            imageRepo,
            path
        )).id;

    }
}
