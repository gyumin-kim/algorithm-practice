package programmers.recruitment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Gyumin Kim
 * @since 2019-03-13
 */
public class Q3_2 {

  class Customer implements Comparable<Customer> {
    private int id;
    private boolean isBooked;

    public Customer(int id, boolean isBooked) {
      this.id = id;
      this.isBooked = isBooked;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Customer customer = (Customer) o;

      return id == customer.id;
    }

    @Override
    public int compareTo(Customer o) {
      return this.id - o.id;
    }
  }

  public int[] solution(int[][] customer, int K) {
    List<Customer> bookedCustomers = new ArrayList<>();
    LinkedList<Customer> waitingCustomers = new LinkedList<>();

    for (int[] request : customer) {
      if (request[1] == 1) { //요청이 예약신청인 경우
        if (bookedCustomers.size() < K) { //빈방이 있는 경우
          bookedCustomers.add(new Customer(request[0], true));
        } else { //빈방이 없는 경우
          waitingCustomers.add(new Customer(request[0], false));
        }
      } else { //요청이 예약취소인 경우
        for (Customer bookedCustomer : bookedCustomers) {
          if (bookedCustomer.id == request[0]) {
            bookedCustomers.remove(bookedCustomer);
            break;
          }
        }

        for (Customer waitingCustomer : waitingCustomers) {
          if (waitingCustomer.id == request[0]) {
            waitingCustomers.remove(waitingCustomer);
            break;
          }
        }

        if (bookedCustomers.size() < K && !waitingCustomers.isEmpty()) {
          Customer poll = waitingCustomers.poll();
          poll.isBooked = true;
          bookedCustomers.add(poll);
        }
      }
    }

    Collections.sort(bookedCustomers);

    int[] answer = new int[bookedCustomers.size()];
    for (int i = 0; i < bookedCustomers.size(); i++) {
      answer[i] = bookedCustomers.get(i).id;
    }

    return answer;
  }
}
