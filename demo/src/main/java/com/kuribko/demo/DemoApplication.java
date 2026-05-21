package com.kuribko.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

  public static final void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
    new BrokenClass().doSomething(); // intentionally not handling exception to catch it during code review
  }

}
