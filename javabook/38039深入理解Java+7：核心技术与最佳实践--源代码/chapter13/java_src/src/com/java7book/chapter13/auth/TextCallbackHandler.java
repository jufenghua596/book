package com.java7book.chapter13.auth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.TextInputCallback;
import javax.security.auth.callback.TextOutputCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

public class TextCallbackHandler implements CallbackHandler {

    public void handle(Callback[] callbacks) throws IOException,
            UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            if (callback instanceof TextInputCallback) {
                TextInputCallback textInputCallback = (TextInputCallback) callback;
                System.out.print(textInputCallback.getPrompt());
                textInputCallback.setText((new BufferedReader(new InputStreamReader(System.in))).readLine());
            }
            else if (callback instanceof TextOutputCallback) {
                TextOutputCallback textOutputCallback = (TextOutputCallback) callback;
                String messageType = "";
                switch (textOutputCallback.getMessageType()) {
                    case TextOutputCallback.INFORMATION:
                        messageType = "信息：";
                        break;
                    case TextOutputCallback.WARNING:
                        messageType = "警告：";
                        break;
                    case TextOutputCallback.ERROR:
                        messageType = "错误：";
                        break;
                }
                System.out.println(messageType + textOutputCallback.getMessage());
            }
            else {
                throw new UnsupportedCallbackException(callback);
            }
        }
    }
}
