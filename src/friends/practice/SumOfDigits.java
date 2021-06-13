package friends.practice;

public class SumOfDigits {
    public static void main(String[] args) {
        SumOfDigits sumOfDigits = new SumOfDigits();
//        System.out.println(sumOfDigits.computeSum(45634));
//        System.out.println(sumOfDigits.computeSum(0));
        System.out.println(Integer.MAX_VALUE);
//        System.out.println(sumOfDigits.computeSum(Integer.MAX_VALUE));
        System.out.println(sumOfDigits.computeSumRecursion(1999999999));
//        System.out.println(sumOfDigits.computeSum(Integer.MIN_VALUE));

    }
    /*
45634

    last digit = 4
    num = 4563
    sum = 4

    lastdigit = 3
    num = 456
    sum = 7

    lastdigit = 6
    num = 45
    sum = 13

    last = 5
    num = 4
    sum = 18

    last = 4
    num = 0
    sum = 22

    2
    2
    2

    2
    0
    4



    */

    int computeSum(int num) {

        int sum = 0;
        int divisor = 10;
        int lastDigit = 0;

        do {
            lastDigit = num % divisor;
            num /= divisor;
            sum += lastDigit;
            System.out.println("call");
        } while (num > 0);
        // compute sum
        // if sum is greater than 10 the return compute sum(sum)
        // else return sum
        System.out.println("sum: " + sum);
        return sum >= 10 ? computeSum(sum) : sum;

    }


    int computeSumRecursion(int num) {
        int sum = num == 0 ? 0 : computeSumRecursion(num / 10) + num % 10;
        return sum > 9 ? computeSumRecursion(sum) : sum;
    }
}
