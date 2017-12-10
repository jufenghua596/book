package com.java7book.chapter3.multicast;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.StandardProtocolFamily;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.MembershipKey;

public class TimeClient {
    
    public void start() throws IOException {
        NetworkInterface ni = NetworkInterface.getByName("eth1");
        int port = 5000;
        try (DatagramChannel dc = DatagramChannel.open(StandardProtocolFamily.INET)
                .setOption(StandardSocketOptions.SO_REUSEADDR, true)
                .bind(new InetSocketAddress(port))
                .setOption(StandardSocketOptions.IP_MULTICAST_IF, ni)) {
        
            InetAddress group = InetAddress.getByName("224.0.0.2");
            MembershipKey key = dc.join(group, ni);
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            dc.receive(buffer);
            buffer.flip();
            byte[] data = new byte[buffer.limit()];
            buffer.get(data);
            String str = new String(data);
            System.out.println(str);
            key.drop();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        TimeClient client = new TimeClient();
        try {
            client.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
