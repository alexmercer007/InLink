
package com.red.InLink.Service;

import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author AlejandroRC
 */

@Service
public class FileStorageService {
    
  
    private final Path uploadDir = Paths.get("uploads");

    public String saveFile(MultipartFile archivo, Long userId, Long albumId) throws IOException {
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }

        String extension = FilenameUtils.getExtension(archivo.getOriginalFilename()); 
        String filename = "user" + userId + "_album" + albumId + "_" + UUID.randomUUID() + "." + extension;

        Path destino = uploadDir.resolve(filename);
        Files.copy(archivo.getInputStream(), destino, StandardCopyOption.REPLACE_EXISTING);

        return "/uploads/" + filename; // esta es la que se guarda en mediaUrl
    }  
    
}
