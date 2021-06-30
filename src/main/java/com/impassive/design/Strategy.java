package com.impassive.design;

/**
 * 策略模式
 *
 * @author impassivey
 */
public class Strategy {

  public static void main(String[] args) {
    Context context = new Context(10);
    System.out.println(context.calculate(1));
    System.out.println(context.calculate(2));
  }

  public static class Context {

    private Integer nums;

    public Context(Integer nums) {
      this.nums = nums;
    }

    public Double calculate(Integer strategy) {
      StrategyCalculate strategyCalculate = new StrategyCalculate(2);
      switch (strategy) {
        case 1:
          return strategyCalculate.normal(nums);
        case 2:
          return strategyCalculate.calculate(nums);
        default:
          return null;
      }
    }
  }

  public static class StrategyCalculate {

    private final Integer doubled;

    public StrategyCalculate(Integer doubled) {
      this.doubled = doubled;
    }

    public Double normal(Integer nums) {
      return Double.valueOf(nums);
    }

    public Double calculate(Integer nums) {
      return (double) (nums * doubled);
    }
  }
}
