package com.java7book.chapter13.ssl;

import java.io.IOException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.io.IOUtils;

public class ReadAllHttpsClient {
    public byte[] read(String urlString) throws IOException, GeneralSecurityException {
        URL url = new URL(urlString);
        SSLContext context = SSLContext.getInstance("TLS");
        context.init(new KeyManager[] {}, new TrustManager[] { new MyTrustManager() }, new SecureRandom());
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setSSLSocketFactory(context.getSocketFactory());
        connection.setHostnameVerifier(new MyHostnameVerifier());
        return IOUtils.toByteArray(connection.getInputStream());
    }

    private static class MyTrustManager implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    private static class MyHostnameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }
}
