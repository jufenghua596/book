package com.java7book.chapter3.demo;

import java.io.IOException;
import java.net.FileNameMap;
import java.net.InetSocketAddress;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.Channels;
import java.nio.channels.CompletionHandler;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StaticFileHttpServer {
    private static final Logger LOGGER = Logger.getLogger(StaticFileHttpServer.class.getName());
    private static final Pattern PATH_EXTRACTOR = Pattern.compile("GET (.*?) HTTP");
    private static final String INDEX_PAGE = "index.html";
    
    public void start(final Path root) throws IOException {
        AsynchronousChannelGroup group = AsynchronousChannelGroup.withFixedThreadPool(10, Executors.defaultThreadFactory());
        final AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open(group).bind(new InetSocketAddress(10080));
        serverChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
            public void completed(AsynchronousSocketChannel clientChannel, Void attachement) {
                serverChannel.accept(null, this);
                try {
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    clientChannel.read(buffer).get();
                    buffer.flip();
                    String request = new String(buffer.array());
                    String requestPath = extractPath(request);
                    Path filePath = getFilePath(root, requestPath);
                    if (!Files.exists(filePath)) {
                        String error404 = generateErrorResponse(404, "Not Found");
                        clientChannel.write(ByteBuffer.wrap(error404.getBytes()));
                        return;
                    }
                    LOGGER.log(Level.INFO, "处理请求：{0}", requestPath);
                    String header = generateFileContentResponseHeader(filePath);
                    clientChannel.write(ByteBuffer.wrap(header.getBytes())).get();
                    Files.copy(filePath, Channels.newOutputStream(clientChannel));
                } catch (Exception e) {
                    String error = generateErrorResponse(500, "Internal Server Error");
                    clientChannel.write(ByteBuffer.wrap(error.getBytes()));
                    LOGGER.log(Level.SEVERE, e.getMessage(), e);
                } finally {
                    try {
                        clientChannel.close();
                    } catch (IOException e) {
                        LOGGER.log(Level.WARNING, e.getMessage(), e);
                    }
                }
            }
            public void failed(Throwable throwable, Void attachement) {
                LOGGER.log(Level.SEVERE, throwable.getMessage(), throwable);
            }
        });
        LOGGER.log(Level.INFO, "服务器已经启动，文件根目录为：" + root);
    }
    
    private String extractPath(String request) {
        Matcher matcher = PATH_EXTRACTOR.matcher(request);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
    
    private Path getFilePath(Path root, String requestPath) {
        if (requestPath == null || "/".equals(requestPath)) {
            requestPath = INDEX_PAGE;
        }
        if (requestPath.startsWith("/")) {
            requestPath = requestPath.substring(1);
        }
        int pos = requestPath.indexOf("?");
        if (pos != -1) {
            requestPath = requestPath.substring(0, pos);
        }
        return root.resolve(requestPath);
    }
    
    private String getContentType(Path filePath) throws IOException {
        return Files.probeContentType(filePath);
        //FileNameMap fileNameMap = URLConnection.getFileNameMap();
        //String type = fileNameMap.getContentTypeFor(filePath.getFileName().toString());
        //return type;
    }
    
    private String generateFileContentResponseHeader(Path filePath) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append("HTTP/1.1 200 OK\r\n");
        builder.append("Content-Type: ");
        builder.append(getContentType(filePath));
        builder.append("\r\n");
        builder.append("Content-Length: " + Files.size(filePath) + "\r\n");
        builder.append("\r\n");
        return builder.toString();
    }
    
    private String generateErrorResponse(int statusCode, String message) {
        StringBuilder builder = new StringBuilder();
        builder.append("HTTP/1.1 " + statusCode + " " + message + "\r\n");
        builder.append("Content-Type: text/plain\r\n");
        builder.append("Content-Length: " + message.length() + "\r\n");
        builder.append("\r\n");
        builder.append(message);
        return builder.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        StaticFileHttpServer server = new StaticFileHttpServer();
        try {
            server.start(Paths.get("C:\\dojo-src-dev").toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
