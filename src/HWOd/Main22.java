package HWOd;

import java.util.*;

public class Main22 {

    public Set<String> correctServer(List<String> list, List<String> errorList) {
        Set<String> severSet = new HashSet<>();
        Map<String, Set<String>> dependMap = new HashMap<>();
        for (String str : list) {
            String[] strs = str.split("-");
            severSet.add(strs[0]);
            severSet.add(strs[1]);
            Set<String> set = dependMap.getOrDefault(strs[1], new HashSet<String>());
            set.add(strs[0]);
            dependMap.put(strs[1], set);
        }
        for (String str : errorList) {
            String temp = str;
            Set<String> removeSet = new HashSet<>();
            removeSet.add(str);
            while (removeSet.size() > 0) {
                severSet.removeAll(removeSet);
                Set<String> tempSet = new HashSet<>(removeSet);
                for (String removeStr : removeSet) {
                    if (dependMap.get(removeStr) != null) {
                        removeSet.addAll(dependMap.get(removeStr));
                    }
                }
                removeSet.removeAll(tempSet);
            }
        }
        return severSet;
    }


}
