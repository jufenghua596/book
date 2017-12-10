package com.java7book.chapter13.access;

import java.io.FilePermission;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

public class WriteFile {
    public void writeFile(Path path, byte[] content) throws IOException {
        FilePermission permission = new FilePermission(path.toString(), "write");
        AccessController.checkPermission(permission);

        Files.write(path, content);
    }
    
    public void writeFile2(Path path, byte[] content) throws IOException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkWrite(path.toString());
        }
        Files.write(path, content);
    }
    
    public void writeFileWithPrivilege(final Path path, final byte[] content) throws IOException {
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<String>() {
                public String run() throws IOException {
                    Files.write(path, content);
                    return path.toString();
                }
            });
        } catch (PrivilegedActionException e) {
            throw (IOException) e.getCause();
        }
    }
}
