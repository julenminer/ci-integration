package com.example.reto.service;

import com.example.reto.exception.CustomFileNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FileStorageServiceTest {

    @Autowired
    private LocalFileStorageService fileStorageService;

    @Test
    void fileDoesNotExist() {
        assertThrows(CustomFileNotFoundException.class, () -> {
            fileStorageService.loadFileAsResource("testfile.txt");
        });
    }

    private MockMultipartFile generateTestFile() {
        return new MockMultipartFile("data", "testfile.txt", "text/plain", "text for the generated test file".getBytes());
    }

    private void deleteGeneratedTestFile() {
		File currentFile = new File("./uploads/testfile.txt");
		currentFile.delete();
    }

    @Test
    void fileUploads() {
        String result = fileStorageService.storeFile(generateTestFile());
        assertEquals("testfile.txt", result);
        deleteGeneratedTestFile();
    }

    @Test
    void fileExists() {
		fileStorageService.storeFile(generateTestFile());
        assertDoesNotThrow(() -> {
            fileStorageService.loadFileAsResource("testfile.txt");
        });
        deleteGeneratedTestFile();
    }

}
