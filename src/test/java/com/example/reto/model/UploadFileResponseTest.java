package com.example.reto.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UploadFileResponseTest {

    private final UploadFileResponse uploadFileResponse
            = new UploadFileResponse("fileName", "fileDownloadUri", "fileType", 10000);

    @Test
    void getFileName() {
        assertEquals(uploadFileResponse.getFileName(), "fileName");
    }

    @Test
    void getFileDownloadUri() {
        assertEquals(uploadFileResponse.getFileDownloadUri(), "fileDownloadUri");
    }

    @Test
    void getFileType() {
        assertEquals(uploadFileResponse.getFileType(), "fileType");
    }

    @Test
    void getSize() {
        assertEquals(uploadFileResponse.getSize(), 10000);
    }
}