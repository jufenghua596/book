package com.java7book.chapter3.fs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.spi.FileSystemProvider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class UseZipFileSystem {
    
    public void addFileToZip(File zipFile, File fileToAdd) throws IOException {
        File tempFile = File.createTempFile(zipFile.getName(), null);
        tempFile.delete();
        zipFile.renameTo(tempFile);
        try (ZipInputStream input = new ZipInputStream(new FileInputStream(tempFile));
             ZipOutputStream output = new ZipOutputStream(new FileOutputStream(zipFile))) {
            ZipEntry entry = input.getNextEntry();
            byte[] buf = new byte[8192];
            while (entry != null) {
               String name = entry.getName();
               if (!name.equals(fileToAdd.getName())) {
                   output.putNextEntry(new ZipEntry(name));
                   int len = 0;
                   while ((len = input.read(buf)) > 0) {
                       output.write(buf, 0, len);
                   }
               }
               entry = input.getNextEntry();
            }
            try(InputStream newFileInput = new FileInputStream(fileToAdd)) {
                output.putNextEntry(new ZipEntry(fileToAdd.getName()));
                int len = 0;
                while ((len = newFileInput.read(buf)) > 0) {
                    output.write(buf, 0, len);
                }
                output.closeEntry();
            }
        }
        tempFile.delete();
    }
    
    public void addFileToZip2(File zipFile, File fileToAdd) throws IOException {
        Map<String, String> env = new HashMap<>();
        env.put("create", "true");
        try (FileSystem fs = FileSystems.newFileSystem(URI.create("jar:" + zipFile.toURI()), env)) {
            Path pathToAddFile = fileToAdd.toPath();
            Path pathInZipfile = fs.getPath("/" + fileToAdd.getName());
            Files.copy(pathToAddFile, pathInZipfile, StandardCopyOption.REPLACE_EXISTING);
        }
    }
    
    public void readZipFile() throws IOException {
        Path path = Paths.get("test.zip");
        Map<String, String> env = new HashMap<>(); 
        try (FileSystem fs = FileSystems.newFileSystem(path, null)) {
            Path pathFile = fs.getPath("/my.txt");
            Path pathInZipfile = fs.getPath("/new4/new.txt");
            //Files.copy(pathFile, pathInZipfile);
            //Files.createDirectory(pathInZipfile);
            Files.copy(pathFile, pathInZipfile, StandardCopyOption.REPLACE_EXISTING);
            Files.delete(pathFile);
        }
        List<FileSystemProvider> providers = FileSystemProvider.installedProviders();
        for (FileSystemProvider provider : providers) {
            System.out.println(provider.toString());
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        UseZipFileSystem fs = new UseZipFileSystem();
        try {
            Path zipFile = Paths.get("test.zip");
            Path fileToAdd = Paths.get("test.txt");
            fs.addFileToZip(zipFile.toFile(), fileToAdd.toFile());
            //fs.addFileToZip2(zipFile.toFile(), fileToAdd.toFile());
            //fs.readZipFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
