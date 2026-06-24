package com.datazuka.qrcode_generator.port;

public interface StoragePort {
    String uploadFile(byte[] file, String fileName, String contentType);
}
