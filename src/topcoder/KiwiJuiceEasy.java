package topcoder;

import java.util.Arrays;

public class KiwiJuiceEasy {

  public static int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
    int n = fromId.length;

    for (int i = 0; i < n; i++) {
      // bottles[fromId[i]]이 비어있지 않은 경우
      if (bottles[fromId[i]] > 0) {
        // 더한 양이 capacities[toId[i]]보다 큰 경우
        if (bottles[toId[i]] + bottles[fromId[i]] > capacities[toId[i]]) {
          int amount = capacities[toId[i]] - bottles[toId[i]];
          bottles[toId[i]] += amount;
          bottles[fromId[i]] -= amount;
        }
        // 더해도 capacities[toId[i]]보다 작거나 같은 경우
        else {
          bottles[toId[i]] += bottles[fromId[i]];
          bottles[fromId[i]] = 0;
        }
      }
    }

    return Arrays.copyOf(bottles, bottles.length);
  }

  public static void main(String[] args) {
    int[] capacities = {700000, 800000, 900000, 1000000};
    int[] bottles = {478478, 478478, 478478, 478478};
    int[] fromId = {2, 3, 2, 0, 1};
    int[] toId = {0, 1, 1, 3, 2};
    int[] answer = thePouring(capacities, bottles, fromId, toId);

    for (int i : answer)
      System.out.print(i + " ");
    System.out.println();
  }
}
