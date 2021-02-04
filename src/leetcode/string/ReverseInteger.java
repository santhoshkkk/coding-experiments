package leetcode.string;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverseInt(-2147483648));
    }

    public static int reverseInt(int integer) {
        boolean negative = false;
        if(integer<=Integer.MIN_VALUE || integer>=Integer.MAX_VALUE){
            return 0;
        }
        if(integer<0){
            integer = integer*-1;
            negative = true;
        }
        int sum = 0;
        int remaining = integer;
        do {
            int val = remaining % 10;
            if(sum>Integer.MAX_VALUE/10){
                sum = 0;
                break;
            }
            sum = (sum * 10) + val;
            remaining = remaining / 10;



        } while (remaining > 0);
        return negative ? sum*-1:sum;
    }
}
