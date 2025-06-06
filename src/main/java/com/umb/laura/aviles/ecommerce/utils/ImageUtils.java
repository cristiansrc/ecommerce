package com.umb.laura.aviles.ecommerce.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

@Service
public class ImageUtils {

    @Value("${config.image.location}")
    private String filePath;

    private static final String POINT = "\\.";

    public String saveBase64Image(String base64String, String originalName) throws IOException {
        String[] parts = base64String.split(",");

        byte[] imageBytes = Base64.getDecoder().decode(parts.length > 1 ? parts[1] : parts[0]);
        String[] arrayName = originalName.split(POINT);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(UUID.randomUUID().toString());
        stringBuilder.append(".");
        stringBuilder.append(arrayName[1]);

        File file = new File(filePath + stringBuilder.toString());

        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(imageBytes);
            System.out.println("Imagen guardada en: " + file.getAbsolutePath());
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }

        return stringBuilder.toString();
    }
}
