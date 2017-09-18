package java7;

public class BinaryPrefixAndDigitSeparator {

  public static void main(String[] args) {
    testBinaryDigits();
    testDigitSeparatorUnderscore();
  }

  private static void testDigitSeparatorUnderscore() {
    int l = 0xa_b;
    int m = 01_2;
    int n = 1_2;
    System.out.println(l);
    System.out.println(m);
    System.out.println(n);
  }

  private static void testBinaryDigits() {

    int i = 0b1001;
    int j = 0b1_0_0_1;
    int k = 0b10_01;
    System.out.println(i);
    System.out.println(j);
    System.out.println(k);

    byte b = (byte) 0b1001_10001_1011; // considers only trailing
                                       // digits.Overflow avoided
    System.out.println("byte:" + b);

  }

}
