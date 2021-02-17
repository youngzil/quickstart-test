package org.quickstart.junit.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {

        BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please Input Your Username：");
        String username = strin.readLine();
        System.out.println("Please Input Your Password：");
        String password = strin.readLine();
        System.out.println("Username：" + username);
        System.out.println("Password：" + password);

    }

}
