package com.kuribko.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

  // Intentionally bad: public mutable state + hardcoded credential.
  public static String API_KEY = "super-secret-dev-key";

  // Intentionally bad: raw type and unused mutable collection.
  public List cache = new ArrayList();

  public static final void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

}
