package common;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;

public class EqualsAndHashcode {

    private int num;
    private String data;

    public EqualsAndHashcode(int num, String data) {
        this.num = num;
        this.data = data;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;

        if ((obj == null) || (obj.getClass() != this.getClass())) return false;

        EqualsAndHashcode test = (EqualsAndHashcode) obj;
        return num == test.num && (data == test.data || (data != null && data.equals(test.data)));
    }

  /*  public int hashCode() {
        int hash = 7;
        hash = 31 * hash + num;
        hash = 31 * hash + (data == null ? 0 : data.hashCode());
        return hash;

    }*/

    public static void main(String[] args) {

        Map<EqualsAndHashcode, Integer> map = new HashMap<>();
        EqualsAndHashcode t1 = new EqualsAndHashcode(21, "ouym");
        System.out.println(t1.hashCode());
        map.put(t1, 1);
        t1.setNum(20);
        System.out.println(t1.hashCode());
        System.out.println(map.get(t1));

        Function function = (str) -> {
            return str;
        };
        System.out.println(function.apply("12"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nowTime = sdf.format(new Date());
//        String nowTime = new Date().toString();
        System.out.println("时间：" + nowTime);

        String rangeRegex= "^(\\[|\\(){1}(-|\\+)?\\d+(\\.\\d+)?\\,{1}(-|\\+)?\\d+(\\.\\d+)?(\\]|\\)){1}$";
        Pattern rangePattern = Pattern.compile(rangeRegex);
        System.out.println(rangePattern.matcher("[-5.5,5)").matches());    //5.5,5]
        String rangeRegex1= "^(-|\\+)?\\d+(\\.\\d+)?$";
        Pattern rangePattern1 = Pattern.compile(rangeRegex1);
        System.out.println(rangePattern1.matcher("5.5").matches());    //5.5,5]

        System.out.println(Optional.ofNullable("").isPresent());
        System.out.println(Optional.ofNullable(null).isPresent());
    }

}
