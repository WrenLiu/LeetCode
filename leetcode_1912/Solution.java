
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        int[][] entriy = {{0, 1, 5}, {0, 2, 6}, {0, 3, 7}, {1, 1, 4}, {1, 2, 7}, {2, 1, 5}};
        MovieRentingSystem_mine movieRentingSystem = new MovieRentingSystem_mine(3, entriy);


        // 返回 [1, 0, 2] ，商店 1，0 和 2 有未借出的 ID 为 1 的电影。商店 1 最便宜，商店 0 和 2 价格相同，所以按商店编号排序。
        List<Integer> list = movieRentingSystem.search(1);


        movieRentingSystem.rent(0, 1); // 从商店 0 借出电影 1 。现在商店 0 未借出电影编号为 [2,3] 。
        movieRentingSystem.rent(1, 2); // 从商店 1 借出电影 2 。现在商店 1 未借出的电影编号为 [1] 。



        List<List<Integer>> reportList = movieRentingSystem.report();   // 返回 [[0, 1], [1, 2]] 。商店 0 借出的电影 1 最便宜，然后是商店 1 借出的电影 2 。

        movieRentingSystem.drop(1, 2); // 在商店 1 返还电影 2 。现在商店 1 未借出的电影编号为 [1,2] 。


        list = movieRentingSystem.search(2);  // 返回 [0, 1] 。商店 0 和 1 有未借出的 ID 为 2 的电影。商店 0 最便宜，然后是商店 1 。

        for (Integer integer : list) {
            System.out.print(integer+" ");
        }


    }

    // 最后超时了
    static class MovieRentingSystem_mine {

        int n ;

        HashMap<Integer , LinkedList<Integer>> shops ;
        HashMap<String , Integer> movies ;
        HashMap<String , Integer> rentedMovies ;


//        public void show(){
//
//            System.out.println("----------------------");
//            System.out.println("SHOW:");
//
//            // 看商店
//            for (Integer integer : shops.keySet()) {
//
//                System.out.println("shop"+integer);
//                List<Integer> list = shops.get(integer);
//                for (Integer integer1 : list) {
//                    System.out.println(integer1);
//                }
//
//            }
//
//            // 看已经被借了的电影
////            for (String string : rentedMovies.keySet()) {
////                System.out.println(string+" "+rentedMovies.get(string));
////            }
//
//
//            System.out.println("----------------------");
//
//        }

        public MovieRentingSystem_mine(int _n, int[][] _entries) {

            n = _n;

            shops = new HashMap<>();
            movies = new HashMap<>();

            rentedMovies = new HashMap<>();


            for (int i = 0; i < _entries.length; i++) {

                int[] tmp = _entries[i];

                if(shops.containsKey(tmp[0])){
                    shops.get(tmp[0]).add(tmp[1]);
                    String str = tmp[0]+"_" + tmp[1];
                    movies.put(str , tmp[2]);
                }else{
                    LinkedList<Integer> tmpArrayList = new LinkedList<>();
                    tmpArrayList.add(tmp[1]);
                    shops.put(tmp[0] , tmpArrayList);
                    String str = tmp[0]+"_" + tmp[1];
                    movies.put(str , tmp[2]);
                }

            }


        }

        public List<Integer> search(int movie) {

            List<int[]> tmpList = new ArrayList<>();
            List<Integer> res = new ArrayList<>();

            String str = "";

            for (Integer integer : shops.keySet()) {
                if(shops.get(integer).contains(movie)){
                    str = integer+"_" + movie ;
                    int[] add = new int[3];
                    add[0] = integer;
                    add[1] = movie;
                    add[2] = movies.get(str);
                    tmpList.add(add);
                }
            }

            Collections.sort(tmpList, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {

                    if(o1[2] != o2[2]){
                        return o1[2] - o2[2];
                    }else{
                        return o1[0] - o2[0];
                    }

                }
            });

            for (int i = 0; i < tmpList.size() && i <5; i++) {
                res.add(tmpList.get(i)[0]);
            }

            return res;

        }

        public void rent(int shop, int movie) {

            shops.get(shop).remove(shops.get(shop).indexOf(movie));

            String str = shop+"_"+movie;

            rentedMovies.put(str , movies.get(str));
            movies.remove(str);



        }

        public void drop(int shop, int movie) {

            shops.get(shop).add(movie);
            String str = shop+"_"+movie;
            movies.put(str , rentedMovies.get(str));
            rentedMovies.remove(str);


        }

        public List<List<Integer>> report() {

            List<List<Integer>> res = new ArrayList<>();

//            Report：返回 最便宜的 5 部已借出电影 （可能有重复的电影 ID），
//            将结果用二维列表 res 返回，其中 res[j] = [shopj, moviej] 表示第 j 便宜的已借出电影是从商店 shopj 借出的电影 moviej 。
//            res 中的电影需要按 价格 升序排序；如果价格相同，则 shopj 较小 的排在前面；如果仍然相同，则 moviej 较小 的排在前面。
//            如果当前借出的电影小于 5 部，则将它们全部返回。如果当前没有借出电影，则返回一个空的列表。


            List<int[]> list = new ArrayList<>();

            for (String string : rentedMovies.keySet()) {
                String[] strs = string.split("_");

                int[] tmp = new int[3];
                tmp[0] = Integer.parseInt(strs[0]);
                tmp[1] = Integer.parseInt(strs[1]);
                tmp[2] = rentedMovies.get(string);
                list.add(tmp);

            }

            Collections.sort(list, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {

                    if(o1[2] != o2[2]){
                        return o1[2] - o2[2];
                    }else if(o1[0] != o2[0]){
                        return o1[0] - o2[0];
                    }else{
                        return o1[1] - o2[1];
                    }

                }
            });

            for (int i = 0; i < 5 && i < list.size(); i++) {

                List<Integer> tmpList = new ArrayList<>();
                tmpList.add(list.get(i)[0]);
                tmpList.add(list.get(i)[1]);
                res.add(tmpList);
            }



            return res;




        }
    }

    class MovieRentingSystem {
        public class RentRecord implements Comparable<RentRecord> {
            int shop;
            int movie;
            int price;

            RentRecord(int v1, int v2, int v3) {
                shop = v1;
                movie = v2;
                price = v3;
            }

            @Override
            public int hashCode() {
                return (shop + 7) * (movie + 7) * (price + 7);
            }

            @Override
            public boolean equals(Object o) {
                if(o instanceof RentRecord) {
                    RentRecord r = (RentRecord) o;
                    return r.shop == shop && r.movie == movie && r.price == price;
                } else {
                    return false;
                }
            }

            public int compareTo(RentRecord r) {
                if(r.price > price) {
                    return -1;
                } else if(r.price < price) {
                    return 1;
                } else {
                    if(r.shop > shop) {
                        return -1;
                    } else if(r.shop < shop) {
                        return 1;
                    } else {
                        if(r.movie > movie) {
                            return -1;
                        } else {
                            return 1;
                        }
                    }
                }
            }

        }

        public class Movie {
            public class Shop implements Comparable<Shop> {
                int id;
                int price;

                Shop(int v1, int v2) {
                    id = v1;
                    price = v2;
                }

                @Override
                public int compareTo(Shop s) {
                    if(price < s.price) {
                        return -1;
                    } else if(price > s.price) {
                        return 1;
                    } else {
                        if(id < s.id) {
                            return -1;
                        } else {
                            return 1;
                        }
                    }
                }
            }
            public ArrayList<Shop> shopList = new ArrayList<>();
            public Shop[] shops;
            public HashMap<Integer, Integer> priceMap = new HashMap<>();
            public HashSet<Integer> rented = new HashSet<>();
            public int id;

            Movie(int i) {
                id = i;
            }

            public void addShop(int shopId, int price) {
                shopList.add(new Shop(shopId, price));
                priceMap.put(shopId, price);
            }

            public void sort() {
                shops = shopList.toArray(new Shop[shopList.size()]);
                Arrays.sort(shops);
                // for(Shop s : shops) {
                //     System.out.println(s.id + " " + s.price);
                // }
            }

            public List<Integer> search() {
                ArrayList<Integer> list = new ArrayList<>();
                for(int i = 0; i < shops.length; i ++) {
                    if(rented.contains(shops[i].id)) {
                        continue;
                    } else {
                        list.add(shops[i].id);
                    }
                    if(list.size() == 5) {
                        return list;
                    }
                }
                return list;
            }

            public int rent(int shop) {
                rented.add(shop);
                return priceMap.get(shop);
            }

            public int drop(int shop) {
                rented.remove(shop);
                return priceMap.get(shop);
            }
        }

        Movie[] movies = new Movie[10000];
        HashSet<RentRecord> record = new HashSet<>();

        public MovieRentingSystem(int n, int[][] entries) {
            Movie m;
            for(int[] entry : entries) {
                //System.out.println(entry[0] + " " + entry[1] + " " + entry[2]);
                if(movies[entry[1]] == null) {
                    movies[entry[1]] = new Movie(entry[1]);
                }
                m = movies[entry[1]];
                m.addShop(entry[0], entry[2]);
            }
            for(int i = 0; i < movies.length; i ++) {
                if(movies[i] != null) {
                    movies[i].sort();
                }
            }
        }

        public List<Integer> search(int movie) {
            if(movies[movie] == null) {
                return new ArrayList<>();
            }
            return movies[movie].search();
        }

        public void rent(int shop, int movie) {
            int price = movies[movie].rent(shop);
            record.add(new RentRecord(shop, movie, price));
        }

        public void drop(int shop, int movie) {
            int price = movies[movie].drop(shop);
            RentRecord r = new RentRecord(shop, movie, price);
            record.remove(r);
        }

        public List<List<Integer>> report() {
            RentRecord[] recordList = record.toArray(new RentRecord[record.size()]);
            Arrays.sort(recordList);
            List<List<Integer>> ans = new ArrayList<>();
            for(int i = 0; i < recordList.length; i ++) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(recordList[i].shop);
                list.add(recordList[i].movie);
                ans.add(list);
                if(ans.size() == 5) {
                    return ans;
                }
            }
            return ans;
        }
    }

}
