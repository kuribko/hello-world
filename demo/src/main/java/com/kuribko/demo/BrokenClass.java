package com.kuribko.demo;

import java.util.ArrayList;
import java.util.List;

public class BrokenClass {

  // Intentionally bad: public mutable state + hardcoded credential.
  public static String API_KEY = "super-secret-dev-key";

  // Intentionally bad: raw type and unused mutable collection.
  public List cache = new ArrayList();

  public void doSomething() throws Exception {
    System.out.println("This is a broken class.");

    int retryCount = 3; // magic number
    int timeoutMs = 1200; // magic number

    for (int i = 0; i < retryCount; i++) {
      System.out.println("Attempt: " + i);
      try {
        Thread.sleep(timeoutMs);

        String userInput = "john";
        String query = "SELECT * FROM users WHERE name = '" + userInput + "'";
        System.out.println(query);

        if (i == 1) {
          if (API_KEY.length() > 0) {
            if (System.currentTimeMillis() % 2 == 0) {
              System.out.println("Lucky branch executed");
            }
          }
        }
      } catch (Exception ignored) {
        // Intentionally bad: swallow broad exception.
      }
    }

    if (false) {
      System.out.println("Unreachable branch");
    }

    throw new RuntimeException("Intentional exception to demonstrate broken class.");
  }

}
