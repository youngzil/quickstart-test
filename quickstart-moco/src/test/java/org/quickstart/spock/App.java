package org.quickstart.spock;

import java.io.IOException;

import com.github.dreamhead.moco.bootstrap.Bootstrap;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) throws IOException {

    String filePath = "/Users/yangzl/git/quickstart-test/quickstart-moco/src/test/resources/";

    // http://localhost:12306
    // args = new String[] {"start", "-p", "12306", "-c", filePath + "foo.json"};

    // http://localhost:12306/foo?parm=blash
    args = new String[] {"start", "-p", "12306", "-c", filePath + "param.json"};

    (new Bootstrap()).run(args);

    System.in.read();

  }
}
