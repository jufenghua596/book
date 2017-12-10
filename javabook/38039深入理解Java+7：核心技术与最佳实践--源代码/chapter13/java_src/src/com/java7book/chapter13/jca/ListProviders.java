package com.java7book.chapter13.jca;

import java.security.Provider;
import java.security.Security;
import java.util.Set;

public class ListProviders {
    public static void main(String[] args) {
        Provider[] providers = Security.getProviders();
        for (Provider provider : providers) {
            System.out.println(provider.getName());
            Set<Provider.Service> services = provider.getServices();
            for (Provider.Service service : services) {
                System.out.println(service.getAlgorithm() + " <==> " + service.getClassName());
            }
            System.out.println(" ==== ");
        }
    }
}
