package com.impassive.alg.nowcoder;

/** @author impassivey */
import java.util.Scanner;

/**
 * https://www.nowcoder.com/test/question/9d26441a396242a9a0f7d2106fc130c7?pid=16519291&tid=40495092
 */
public class Nowcoder1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextInt()) {
      int target = scanner.nextInt();
      new Nowcoder1().solve(target);
    }
  }

  private void solve(int target) {
    System.out.println(backup(target, new StringBuilder(), 0));
  }

  private String backup(int target, StringBuilder sb, int all) {
    if (target <= all) {
      if (target == all) {
        return sb.toString();
      }
      return null;
    }
    for (int i = 1; i < 3; i++) {
      sb.append((i + 1));
      String backup = backup(target, sb, 2 * all + i);
      if (backup != null) {
        return backup;
      }
      sb.delete(sb.length() - 1, sb.length());
    }
    return null;
  }
}
