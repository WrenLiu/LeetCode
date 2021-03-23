
import java.util.*;

public class Solution {

    public static void main(String[] args) {}

    public static class NestedIterator implements Iterator<Integer> {

        private List<Integer> arrayList;

        private int index ;


        public NestedIterator(List<NestedInteger> nestedList) {

            arrayList = new ArrayList<>();
            index = 0;
            init(nestedList);

        }

        private void init(List<NestedInteger> nestedList){

            for (NestedInteger nestedInteger : nestedList) {
                if(nestedInteger.isInteger()){
                    arrayList.add(nestedInteger.getInteger());
                }else{
                    init(nestedInteger.getList());

                }
            }
        }


        @Override
        public Integer next() {
            return arrayList.get(index++);
        }

        @Override
        public boolean hasNext() {
            return index < arrayList.size();
        }
    }


    public static class NestedIterator_Leetcode implements Iterator<Integer> {

        private Deque<NestedInteger> deque;

        public NestedIterator(List<NestedInteger> nestedList) {

            deque = new ArrayDeque<>();
            for (int i = 0; i < nestedList.size(); i++) {
                deque.addLast(nestedList.get(i));
            }

        }

        @Override
        public Integer next() {

            NestedInteger cur = deque.removeFirst();
            return cur.getInteger();

        }

        @Override
        public boolean hasNext() {

            while(!deque.isEmpty()){

                NestedInteger top = deque.peek();

                if(top.isInteger()){
                    return true;
                }

                deque.removeFirst();

                for (int i =  top.getList().size() -1; i >= 0; i--) {
                    deque.addFirst(top.getList().get(i));

                }
                
                

            }
            
            return false;


        }
    }

}
