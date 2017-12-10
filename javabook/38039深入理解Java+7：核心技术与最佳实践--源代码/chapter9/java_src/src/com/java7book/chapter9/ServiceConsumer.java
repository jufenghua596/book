package com.java7book.chapter9;

public class ServiceConsumer {
    
    public void consume() throws Exception {
        String serviceName = "com.java7book.chapter9.SampleService";
        Versionized v1 = ServiceFactory.getService(serviceName, "v1");
        Versionized v2 = ServiceFactory.getService(serviceName, "v2");
        System.out.println(v1.getVersion());
        System.out.println(v2.getVersion());
    }

    public static void main(String[] args) throws Exception {
        ServiceConsumer sc = new ServiceConsumer();
        sc.consume();
    }

}
