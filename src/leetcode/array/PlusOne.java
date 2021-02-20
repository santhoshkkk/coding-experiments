package leetcode.array;

public class PlusOne {
    public static void main(String[] args) {
        plusOne(new int[]{9});
    }
    public static int[] plusOne(int[] digits) {
        int reminder = 1;
        int original = 0;
        for(int i = digits.length-1; i>=0; i--){
            if(reminder !=0){
                original = digits[i];
                digits[i] = (original+reminder)%10;
                reminder = (original+reminder)/10;
            }
        }
        if(reminder != 0){
            int[] result = new int[digits.length+1];
            result[0]=1;
            for(int i=1;i<result.length;i++){
                result[i]=digits[i-1];
            }
            return result;
        }
        return digits;
    }
}
