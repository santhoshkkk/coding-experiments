package java;

public class ThrowError {

  public static void main(String[] args) {
    try {
      throw new Error();
    } catch (Exception e) {
      System.out.println("Unknown error");
    }
  }

}
