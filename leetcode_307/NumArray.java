class NumArray {
    private interface Merger<E> {

        E merger(E a ,E b);
    }


    private class SegmentTree<E> {



        // 线段树基于数组实现
        private E[] data;
        private E[] tree;
        private Merger<E> merger;

        public SegmentTree(E[] arr, Merger<E> merger){

            this.merger = merger;

            data = (E[])new Object[arr.length];
            for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
            }

            // 利用数组去实现线段树是需要开4倍的空间的
            tree =(E[])new Object[arr.length * 4];

            // 创建线段树的时候需要传入三个参数 : 要创建的线段树的根节点的索引;
            //                                  对于treeIndex所代表的线段的左右端点的索引
            buildSegmentTree( 0 , 0 , data.length-1);
        }

        public int getSize(){
            return data.length;
        }

        public E get(int index){
            if(index < 0 || index >=data.length ){
                throw new IllegalArgumentException("Index is illegal.");
            }
            return data[index];
        }

        private int leftChild(int index){
            return  index *2 + 1;
        }

        private int rightChild(int index){
            return index*2+2;
        }

        // 在treeIndex的位置创建表示区间[l ... r]的线段树
        private void buildSegmentTree(int treeIndex , int l ,int r){
            if( l == r){
                tree[treeIndex] = data[l];
                return;
            }

            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);

            int mid = l +(r-l) /2;
            buildSegmentTree(leftTreeIndex ,l,mid);
            buildSegmentTree(rightTreeIndex , mid+1 ,r);

            // 这个要根据业务需求,可以通过重写merger接口实现
            tree[treeIndex] = merger.merger(tree[leftTreeIndex], tree[rightTreeIndex]);
        }

        /**
        *  返回区间[queryL,queryR]的值
        */
        public E query(int queryL ,int queryR){
            if(queryL<0 || queryL > queryR || queryR > data.length || queryR < 0 || queryL >data.length){
                throw  new IllegalArgumentException("Index is illegal.");
            }

            return query(0 , 0 ,data.length -1 , queryL , queryR);
        }

        // 在treeID为根的线段中[l,r]的范围里, 搜索区间[queryL,queryR]的值
        private E query(int treeIndex ,int l ,int r ,int queryL ,int queryR){
            if( l == queryL && r == queryR){
                return tree[treeIndex];
            }
            int mid = l+(r - l) /2;
            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);
            if(queryL >= mid +1 ){
                return query(rightTreeIndex,mid +1 , r ,queryL,queryR);
            }
            else if(queryR <= mid){
                return query(leftTreeIndex , l ,mid ,queryL ,queryR);
            }
            else {
                E leftResult = query(leftTreeIndex , l ,mid ,queryL ,mid);
                E rightResult = query(rightTreeIndex,mid +1 , r ,mid+1 ,queryR);
                // 业务代码
                return merger.merger(leftResult,rightResult);
            }
        }

        // 将index位置的值更新为e
        public void set(int index ,E e){
            if(index < 0 || index >= data.length){
                throw new IllegalArgumentException("Index is Illegal.");
            }
            data[index] = e;
            set(0 ,0,data.length -1 ,index ,e );
        }

        // 在treeIndex为根节点的线段树更新index的值为e
        private void set(int treeIndex , int l,int r ,int index ,E e){
            if( l == r){
                tree[treeIndex] = e ;
                return;
            }
            int mid = l + (r-l)/2;
            // 找index的节点
            int leftTreeIndex =  leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);
            if(index >= mid +1 ){
                set(rightTreeIndex,mid +1 , r ,index, e);
            }
            else{
                set(leftTreeIndex , l ,mid ,index  ,e);
            }

            tree[treeIndex] = merger.merger(tree[leftTreeIndex],tree[rightTreeIndex]);
        }

        @Override
        public String toString(){
            StringBuilder res = new StringBuilder();
            res.append('[');
            for (int i = 0; i < tree.length ; i++) {
                if(tree[i] != null){
                    res.append(tree[i]);
                }
                else{
                    res.append("NULL");
                }
                if(i != tree.length -1){
                    res.append(',');
                }
            }

            return res.toString();
        }



    }


    /**************************/
    private SegmentTree<Integer> segment;

    public NumArray(int[] nums) {
        if(nums.length > 0){
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }

            segment = new SegmentTree<Integer>(data, (a,b)->a+b );
        }
    }

    public void update(int i ,int val){
        if(segment == null){
            throw  new IllegalArgumentException("Error");
        }
        segment.set(i ,val);
    }
    public int sumRange(int i, int j) {
        if(segment == null){
            throw  new IllegalArgumentException("Error");
        }
        return segment.query(i,j);
    }
}