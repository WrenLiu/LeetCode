

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        List<List<String>> order = new ArrayList<>();

        List<String> list01 = new ArrayList<>();
        list01.add("David");list01.add("3");list01.add("Ceviche");
        List<String> list02 = new ArrayList<>();
        list02.add("Corina");list02.add("10");list02.add("Beef Burrito");
        List<String> list03 = new ArrayList<>();
        list03.add("David");list03.add("3");list03.add("Fried Chicken");
        List<String> list04 = new ArrayList<>();
        list04.add("Carla");list04.add("5");list04.add("Water");
        List<String> list05 = new ArrayList<>();
        list05.add("Carla");list05.add("5");list05.add("Ceviche");
        List<String> list06 = new ArrayList<>();
        list06.add("Rous");list06.add("3");list06.add("Ceviche");

        order.add(list01);order.add(list02);order.add(list03);
        order.add(list04);order.add(list05);order.add(list06);

        List<List<String>> res = displayTable(order);

        for (List<String> re : res) {

            for (String string : re) {
                System.out.print(string+" ");
            }
            System.out.println();

        }



    }

    public static List<List<String>> displayTable(List<List<String>> orders) {

        if(orders == null ){
            return null;
        }

        List<List<String>> res = new ArrayList<>();

        List<String> firstLine = new ArrayList<>();
        firstLine.add("Table");

        TreeSet<String> dishName = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        TreeMap<String , Integer> dishsToCount =new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        //      桌号              菜名      数量
        TreeMap<String , HashMap<String , Integer>> tableTodishToCount = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1) - Integer.parseInt(o2);
            }
        });



        System.out.println(orders.size());
        int dishIndex = 1;


        for (int i = 0; i < orders.size(); i++) {

            List<String> order = orders.get(i);

            // 名字 桌号 菜名

            String nameStr = order.get(0);
            String tableStr = order.get(1);
            String dishStr = order.get(2);

            if(!dishName.contains(dishStr)){
                dishName.add(dishStr);
//                dishsToCount.put(dishStr , dishIndex++);

            }

            if(tableTodishToCount.containsKey(tableStr)){
                HashMap<String,Integer> map01 = tableTodishToCount.get(tableStr);
                map01.put(dishStr , map01.getOrDefault(dishStr , 0)+1);

            }else{

                HashMap<String , Integer> mapWillAdd = new HashMap<>();
                mapWillAdd.put(dishStr , 1);
                tableTodishToCount.put(tableStr , mapWillAdd);

            }

        }

        int cols = dishName.size()+1;

        res.add(firstLine);


        for (String string : dishName) {
            dishsToCount.put(string , dishIndex++);
            firstLine.add(string);
        }


        for (String string : tableTodishToCount.keySet()) {

            HashMap<String , Integer> hashMap = tableTodishToCount.get(string);

            List<String> listWillAdd = new ArrayList<>();
            listWillAdd.add(string);

            for (int i = 1; i < cols; i++) {
                listWillAdd.add("0");
            }

            for (String s : hashMap.keySet()) {
                listWillAdd.set( dishsToCount.get(s) ,  hashMap.get(s) +"" );
            }

            res.add(listWillAdd);




//            System.out.println("Table " + string);
//            for (String s : hashMap.keySet()) {
//                System.out.println(s+" "+hashMap.get(s));
//            }
//            System.out.println("-------------------------");

        }





        return res;



    }


}
