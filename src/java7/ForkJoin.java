package java7;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoin {

  public static void main(String[] args) {
    List<BigInteger> nums = new ArrayList<>();
    for (int i = 0; i < 10000; i++) {
      nums.add(new BigInteger(i + ""));
    }
    // System.out.println(FactorialTask.fact(new BigInteger("4")));
    System.out.println(ForkJoinPool.getCommonPoolParallelism());
    BigInteger invoke = ForkJoinPool.commonPool().invoke(new FactorialTask(nums, "main"));
    System.out.println(invoke);
  }

}

class FactorialTask extends RecursiveTask<BigInteger> {
  private String num;
  private static final long serialVersionUID = 1L;
  private static final byte SERIAL_THRESHOLD = 50;
  private List<BigInteger> integers;

  public FactorialTask(List<BigInteger> ints, String num) {
    this.integers = ints;
    this.num = num;
  }

  @Override
  protected BigInteger compute() {

    System.out
        .println(Thread.currentThread().getName() + " computing " + num + " " + integers.size());
    int size = integers.size();
    if (size <= SERIAL_THRESHOLD) {
      return sumFactorials();
    }
    int quarter = size / 4;
    List<BigInteger> subList1 = integers.subList(quarter, 2 * quarter);
    FactorialTask subTask1 = new FactorialTask(subList1, num + "_sub1");
    subTask1.fork();

    List<BigInteger> subList2 = integers.subList(2 * quarter, 3 * quarter);
    FactorialTask subTask2 = new FactorialTask(subList2, num + "_sub2");
    subTask2.fork();

    List<BigInteger> subList3 = integers.subList(3 * quarter, size);
    FactorialTask subTask3 = new FactorialTask(subList3, num + "_sub3");
    subTask3.fork();

    integers = integers.subList(0, quarter);
    BigInteger thisSum = this.compute();

    BigInteger subTaskSum1 = subTask1.join();
    BigInteger subTaskSum2 = subTask2.join();
    BigInteger subTaskSum3 = subTask3.join();
    return thisSum.add(subTaskSum1).add(subTaskSum2).add(subTaskSum3);
  }

  private BigInteger sumFactorials() {
    BigInteger sum = new BigInteger("0");
    for (BigInteger num : integers) {
      sum = sum.add(fact(num));
    }
    return sum;
  }

  public static BigInteger fact(BigInteger num) {
    BigInteger zero = new BigInteger("0");
    BigInteger one = new BigInteger("1");
    if (num.compareTo(zero) == 0) {
      return one;
    }
    return num.multiply(fact(num.subtract(one)));
  }

}
