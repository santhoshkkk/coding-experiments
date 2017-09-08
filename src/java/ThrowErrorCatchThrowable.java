package java;

public class ThrowErrorCatchThrowable {

  public static void main(String[] args) {

    try {
      throw new Error();
    } catch (Throwable e) {
      System.out.println("Unknown error");
    }
  }

}
