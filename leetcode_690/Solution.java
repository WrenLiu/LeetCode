import java.util.*;

public class Solution {


    static class Employee690 {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    public static void main(String[] args) {

//        [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1

        List<Employee690> employees = new LinkedList<>();

        Employee690 head = new Employee690();
        head.id = 2;
        head.importance = 5;
        head.subordinates = new LinkedList<>();
//        head.subordinates.add(2);
//        head.subordinates.add(3);

        employees.add(head);

//        Employee690 one = new Employee690();
//        one.id = 2;
//        one.importance = 3;
//        one.subordinates = new LinkedList<>();
//        employees.add(one);
//
//        Employee690 two = new Employee690();
//        two.id = 3;
//        two.importance = 3;
//        two.subordinates = new LinkedList<>();
//        employees.add(two);


        System.out.println(getImportance(employees,2));


    }

    public static int getImportance(List<Employee690> employees, int id) {

        if(employees == null  ){
            return 0;
        }

        int res = 0;

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            hashMap.put(employees.get(i).id,i);
        }

        Employee690 master = employees.get(hashMap.get(id));


        List<Integer> upList = new LinkedList<>();
        List<Integer> downList = new LinkedList<>();
        upList.add(master.id);


        if(upList.size() == 0){

            return master.importance;
        }


        while(upList.size() != 0 ){


            for (Integer integer : upList) {
                res += employees.get(hashMap.get(integer)).importance;
                for (Integer integer1 : employees.get(hashMap.get(integer)).subordinates){
                    downList.add(integer1);
                }
            }

            upList.clear();
            upList = new LinkedList<>(downList);
            downList.clear();

        }

        return res;


    }

}
