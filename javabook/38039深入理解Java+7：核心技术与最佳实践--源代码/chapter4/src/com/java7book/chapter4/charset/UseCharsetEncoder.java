/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter4.charset;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @author chengfu
 */
public class UseCharsetEncoder {

    public void simpleEncode() {
        Charset charset = StandardCharsets.UTF_8;
        CharsetEncoder encoder = charset.newEncoder();
        CharBuffer inputBuffer = CharBuffer.allocate(256);
        inputBuffer.put("你好").flip();
        ByteBuffer outputBuffer = ByteBuffer.allocate(256);
        encoder.encode(inputBuffer, outputBuffer, true);
        encoder.flush(outputBuffer);
        outputBytes(outputBuffer); //值为0xE4BDA0E5A5BD
    }

    public void encodeFile() throws IOException {
        Charset charset = Charset.forName("GB18030");
        CharsetEncoder encoder = charset.newEncoder();
        encoder.onMalformedInput(CodingErrorAction.IGNORE);
        encoder.onUnmappableCharacter(CodingErrorAction.IGNORE);
        ByteBuffer outputBuffer = ByteBuffer.allocate(128);
        List<String> lines = Files.readAllLines(Paths.get("test.htm"), StandardCharsets.UTF_8);
        try (FileChannel destChannel = FileChannel.open(Paths.get("result.htm"), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            for (String line : lines) {
                CharBuffer charBuffer = CharBuffer.wrap(line);
                while (true) {
                    CoderResult result = encoder.encode(charBuffer, outputBuffer, false);
                    if (result.isOverflow()) {
                        writeToChannel(destChannel, outputBuffer);
                    } else if (result.isUnderflow()) {
                        break;
                    }
                }
            }
            writeToChannel(destChannel, outputBuffer);
            encoder.encode(CharBuffer.allocate(0), outputBuffer, true);
            CoderResult result = encoder.flush(outputBuffer);
            if (result.isOverflow()) {
                 ByteBuffer newBuffer = ByteBuffer.allocate(1024);
                 encoder.flush(newBuffer);
                 writeToChannel(destChannel, newBuffer);
            }
            else {
                writeToChannel(destChannel, outputBuffer);
            }
        }
    }
    
    private void writeToChannel(WritableByteChannel channel, ByteBuffer buffer) throws IOException {
        buffer.flip();
        channel.write(buffer);
        buffer.compact();
    }

    private void outputBytes(ByteBuffer buffer) {
        buffer.flip();
        byte[] data = new byte[buffer.limit()];
        buffer.get(data);
        System.out.println(Hex.encodeHex(data));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        UseCharsetEncoder uce = new UseCharsetEncoder();
        //uce.simpleEncode();
        uce.encodeFile();
    }
}
