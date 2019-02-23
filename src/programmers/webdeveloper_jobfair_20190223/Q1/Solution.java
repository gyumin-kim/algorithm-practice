package programmers.webdeveloper_jobfair_20190223.Q1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gyumin Kim
 * @since 2019-02-23
 */
public class Solution {

  private List<Integer> primes = new ArrayList<>();

  public int solution(int n) {
    int answer = 0;
    findPrimes(n);

    int size = primes.size();
    for (int i = 0; i < size; i++) {
      int num1 = primes.get(i);
      for (int j = i+1; j < size; j++) {
        int num2 = primes.get(j);
        for (int k = j+1; k < size; k++) {
          int num3 = primes.get(k);
          if (num1 + num2 + num3 == n)
            answer++;
        }
      }
    }

    return answer;
  }

  private void findPrimes(int n) {
    for (int i = 2; i <= n; i++) {
      i++;
      while (!isPrime(i)) {
        i++;
      }
      primes.add(i);
    }
  }

  public boolean isPrime(int n) {
    for (int i = 2; i < n; i++) {
      if (n % i == 0) return false;
    }
    return true;
  }
}
