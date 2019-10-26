package org.quickstart.arquillian;

import java.io.PrintStream;

/**
 * @author youngzil@163.com
 * @description TODO
 * @createTime 2019/10/26 21:52
 */
public class Greeter {
  public void greet(PrintStream to, String name) {
    to.println(createGreeting(name));
  }

  public String createGreeting(String name) {
    return "Hello, " + name + "!";
  }
}
