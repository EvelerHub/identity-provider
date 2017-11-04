package com.evedev.identityprovider.components;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Alexander Eveler, alexander.eveler@gmail.com
 * @since 04.11.17
 */
@Component
public class OnRunComponent implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("ReconTool#run ==> started");
    }
}
