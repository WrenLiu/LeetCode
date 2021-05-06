
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {

    // 5731
    public static void main(String[] args) {

        SeatManager seatManager = new SeatManager(5); // 初始化 SeatManager ，有 5 个座位。
        System.out.println(seatManager.reserve());    // 所有座位都可以预约，所以返回最小编号的座位，也就是 1 。
        System.out.println(seatManager.reserve());     // 可以预约的座位为 [2,3,4,5] ，返回最小编号的座位，也就是 2 。
        seatManager.unreserve(2); // 将座位 2 变为可以预约，现在可预约的座位为 [2,3,4,5] 。
        System.out.println(seatManager.reserve());   // 可以预约的座位为 [2,3,4,5] ，返回最小编号的座位，也就是 2 。
        System.out.println(seatManager.reserve());    // 可以预约的座位为 [3,4,5] ，返回最小编号的座位，也就是 3 。
        System.out.println(seatManager.reserve());   // 可以预约的座位为 [4,5] ，返回最小编号的座位，也就是 4 。
        System.out.println(seatManager.reserve());  // 唯一可以预约的是座位 5 ，所以返回 5 。
        seatManager.unreserve(5); // 将座位 5 变为可以预约，现在可预约的座位为 [5] 。


    }

    static class SeatManager {

        TreeSet<Integer> unReserved;
        TreeSet<Integer> isReserved;
        public SeatManager(int n) {

            unReserved = new TreeSet<>();
            for (int i = 1; i <= n; i++) {
                unReserved.add(i);
            }

            isReserved = new TreeSet<>();

        }

        public int reserve() {

            if(unReserved.size() == 0){
                return 0;
            }
            isReserved.add(unReserved.first());
            return unReserved.pollFirst();

        }

        public void unreserve(int seatNumber) {

            isReserved.remove(seatNumber);
            unReserved.add(seatNumber);

        }
    }


}
