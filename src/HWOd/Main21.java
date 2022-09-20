package HWOd;

import java.util.*;

public class Main21 {

    public int minCount(List<Integer> list) {
        list.sort((Integer in1, Integer in2) -> {
            return in1 < in2 ? -1 : 1;
        });
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> blist = new ArrayList();
        blist.add(list.get(0));
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < blist.size(); j++) {
                if (list.get(i) % list.get(j) != 0) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                blist.add(list.get(i));
            }
        }
        /*for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j <= i; j++) {
                if (list.get(i) % list.get(j) == 0) {
                    List<Integer> numList = map.getOrDefault(list.get(j), new ArrayList<>());
                    numList.add(list.get(i));
                    map.put(list.get(j), numList);
                    break;
                }
            }
        }
        return map.keySet().size();*/
        return blist.size();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = 0;
        in.nextLine();
        String s = s = in.nextLine();
        List<Integer> list = new ArrayList<>();
        String[] arr = s.split(" ");
        for (String a : arr) {
            int inta = Integer.valueOf(a);
            list.add(inta);
        }
        System.out.println(new Main21().minCount(list));
    }
}
