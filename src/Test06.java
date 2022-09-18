/*
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.io.File;
import java.util.*;

public class Test06 {

    public static void main(String[] args) {
        System.out.println("8TBT_a000002.prt".matches(".*_[A-Za-z][0-9]{6}.*")); //8TBT_a000002.prt
        System.out.println("8TBT_a000002_A.prt".matches(".*_[A-Za-z][.].*"));
        String oldCadName = "8TBT_a000002_A.prt";
        System.out.println(oldCadName.substring(0, oldCadName.lastIndexOf(".") - 2) + oldCadName.substring(oldCadName.lastIndexOf(".")));

        String child = "5TBEA-384-XXXXX-1-SKEL0001.PRT";
        String parent = "5tbea-384-2564-1_22.asm";
        String suffix = child.substring(child.toUpperCase().indexOf("SKEL"));
        String prefix = parent.substring(0, parent.lastIndexOf("."));
        String childNumber = prefix + "_" + suffix;
        System.out.println(childNumber);

        String number = "5tbea-457-xxxxx-1_skel0001.prt";
        String suffix2 = number.substring(number.toUpperCase().indexOf("SKEL"));
        System.out.println(suffix2);

        System.out.println("--getFeatureNum---" + getFeatureNum("1TBC.710.A12345"));

        String fName = " G:\\Java_Source\\navigation_tigra_menu\\demo1\\img\\lev1_arrow.gif ";
        System.out.println(new File(fName).getName());

        Object s = false;
        if (!(boolean) s) {
            System.out.println("执行正常");
        }

        System.out.println("wcadmin加密：" + encode("adp@2022"));

        String containerName = (String) null;
        System.out.println("------:" + containerName);

        List list = new ArrayList();
        list.add("8TBT.180.AT0001.1");
        list.add("5TBT.059.AT0501.2");
        String epmNumbers = "{\"epmNumbers\":[\"8TBT.180.AT0001.1\",\"5TBT.059.AT0501.2\"]}";
        List<String> epmNumberList = JSON.parseObject(JSON.toJSONString(JSON.parseObject(epmNumbers).get("epmNumbers")),ArrayList.class);
        System.out.println(JSON.toJSONString(list));
        System.out.println(Arrays.asList(epmNumberList));

        String dsdf = "[\"1TT.760.61469T\",\"1TT.760.61550N\",\"1TT.760.61512W\",\"1TT.760.61550Q\",\"1TT.760.61471P\",\"1TT.760.61658F\"," +
                "\"10026685\",\"1TT.760.61471A\",\"1TT.760.61651E\",\"1TT.760.61469P\",\"1TT.760.61650K\",\"10026682\",\"10026680\",\"1TT.760" +
                ".61550H\"]";
        System.out.println(JSON.toJSONString(dsdf));
        Set<String> partnumbers = JSON.parseObject(dsdf, Set.class);
        System.out.println(partnumbers);
    }

    public static String encode(CharSequence charSequence) {
        return DigestUtils.md5DigestAsHex(charSequence.toString().getBytes());
    }

    public static String getFeatureNum(String number) {
        int index = StringUtils.indexOf(number, ".", number.indexOf(".") + 1);
        String featureNum = StringUtils.substring(number, 0, index);
        return featureNum;
    }
}
*/
