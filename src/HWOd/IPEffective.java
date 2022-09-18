package HWOd;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/practice/de538edd6f7e4bc3a5689723a7435682?tpId=37&tqId=21241&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
 * 描述
 * 请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。
 * <p>
 * 所有的IP地址划分为 A,B,C,D,E五类
 * <p>
 * A类地址从1.0.0.0到126.255.255.255;
 * <p>
 * B类地址从128.0.0.0到191.255.255.255;
 * <p>
 * C类地址从192.0.0.0到223.255.255.255;
 * <p>
 * D类地址从224.0.0.0到239.255.255.255；
 * <p>
 * E类地址从240.0.0.0到255.255.255.255
 * <p>
 * <p>
 * 私网IP范围是：
 * <p>
 * 从10.0.0.0到10.255.255.255
 * <p>
 * 从172.16.0.0到172.31.255.255
 * <p>
 * 从192.168.0.0到192.168.255.255
 * <p>
 * <p>
 * 子网掩码为二进制下前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
 * （注意二进制下全是1或者全是0均为非法子网掩码）
 * <p>
 * 注意：
 * 1. 类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时请忽略
 * 2. 私有IP地址和A,B,C,D,E类地址是不冲突的
 * <p>
 * 输入描述：
 * 多行字符串。每行一个IP地址和掩码，用~隔开。
 * <p>
 * 请参考帖子https://www.nowcoder.com/discuss/276处理循环输入的问题。
 * 输出描述：
 * 统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。
 * <p>
 * 示例1
 * 输入：
 * 10.70.44.68~255.254.255.0
 * 1.0.0.1~255.0.0.0
 * 192.168.0.2~255.255.255.0
 * 19..0.~255.255.255.0
 * 复制
 * 输出：
 * 1 0 1 0 0 2 1
 * 复制
 * 说明：
 * 10.70.44.68~255.254.255.0的子网掩码非法，19..0.~255.255.255.0的IP地址非法，所以错误IP地址或错误掩码的计数为2；
 * 1.0.0.1~255.0.0.0是无误的A类地址；
 * 192.168.0.2~255.255.255.0是无误的C类地址且是私有IP；
 * 所以最终的结果为1 0 1 0 0 2 1
 * 示例2
 * 输入：
 * 0.201.56.50~255.255.111.255
 * 127.201.56.50~255.255.111.255
 * 复制
 * 输出：
 * 0 0 0 0 0 0 0
 * 复制
 * 225.240.129.203~255.110.255.255
 * 183.181.49.4~255.0.0.0
 * 172.177.113.45~255.0.0.0
 * 176.134.46.246~255.0.0.0
 * 153.63.21.56~255.255.58.255
 * 23.135.167.228~255.0.0.0
 * 204.58.47.149~255.0.0.0
 * 113.33.181.46~255.255.255.0
 * 73.245.52.119~255.255.154.0
 * 23.214.47.71~255.0.0.0
 * 139.124.188.91~255.255.255.100
 * 142.94.192.197~255.0.0.0
 * 53.173.252.202~255.0.0.0
 * 127.201.56.50~255.255.111.255
 * 118.251.84.111~255.0.0.0
 * 130.27.73.170~255.0.0.0
 * 253.237.54.56~255.86.0.0
 * 64.189.222.111~255.255.255.139
 * 148.77.44.147~255.0.0.0
 * 59.213.5.253~255.255.0.0
 * 3.52.119.131~255.255.0.0
 * 213.208.164.145~255.255.0.0
 * 24.22.21.206~255.255.90.255
 * 89.43.34.31~255.0.0.0
 * 9.64.214.75~255.0.0.0
 * 110.156.20.173~255.153.0.0
 * 71.183.242.53~255.255.0.0
 * 119.152.129.100~255.0.0.0
 * 38.187.119.201~255.0.0.0
 * 73.81.221.180~255.255.255.255
 * 73.198.13.199~255.0.15.0
 * 99.42.142.145~255.255.255.0
 * 196.121.115.160~255.0.0.0
 * 226.30.29.206~255.0.0.0
 * 244.248.31.171~255.255.255.255
 * 59.116.159.246~255.0.0.0
 * 121.124.37.157~255.0.0.226
 * 103.42.94.71~255.255.0.0
 * 125.88.217.249~255.255.74.255
 * 73.44.250.101~255.255.255.0
 * 输出
 * 16 6 3 1 0 13 0
 * 说明：
 * 类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时请忽略
 */
public class IPEffective {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String result = "";
        List<String> params = new LinkedList<>();
        int i = 0;
        while (sc.hasNext()) {
            params.add(sc.nextLine());
            i++;
            if (i >= 40) {
                break;
            }
        }
        sc.close();
        result = run(params);
        System.out.println(params.size());
        System.out.println(result);
    }

    public static String run(List<String> params) {
        int a = 0, b = 0, c = 0, d = 0, e = 0, fail = 0, self = 0;
        for (String param : params) {
            String[] split = param.split("~");
            String ip = split[0];
            String sunCode = split[1];
            String[] ipSplits = ip.split("\\.");
            String[] sunCodeSplits = sunCode.split("\\.");
            if (ipSplits[0].equals("0") || ipSplits[0].equals("127")) {
                continue;
            }
            boolean isfail = false;
            if (ipSplits.length != 4 || sunCodeSplits.length != 4) {
                fail += 1;
                isfail = true;
                continue;
            }
            if (!isfail) {
                if (!isfail) {
                    String s = "";
                    for (String sunCodeSplit : sunCodeSplits) {
//                        s += Integer.toBinaryString(Integer.parseInt(sunCodeSplit));
                        s += Integer.toString(Integer.valueOf(sunCodeSplit), 2);
                        s += binaryString(Integer.valueOf(sunCodeSplit));
                    }
//                    if(!sunCode.equals("255.255.255.255")){
                    if (!s.contains("1") || !s.contains("0")) {
                        isfail = true;
                        fail += 1;
                        continue;
                    }
                    int firstIndexOf0 = s.indexOf("0");
                    int lastIndexOf1 = s.lastIndexOf("1");
                    if (firstIndexOf0 < lastIndexOf1) {
                        isfail = true;
                        fail += 1;
                        continue;
                    }
//                    }
                    if (!isfail) {
                        if (judgeIn(ipSplits[0], 1, 126) && judge0255(ipSplits[1]) && judge0255(ipSplits[2]) && judge0255(ipSplits[3])) {
                            a += 1;
                            if (judgeIn(ipSplits[0], 10, 10) && judge0255(ipSplits[1]) && judge0255(ipSplits[2]) && judge0255(ipSplits[3])) {
                                self += 1;
                            }
                        } else if (judgeIn(ipSplits[0], 128, 191) && judge0255(ipSplits[1]) && judge0255(ipSplits[2]) && judge0255(ipSplits[3])) {
                            b += 1;
                            if (judgeIn(ipSplits[0], 172, 172) && judgeIn(ipSplits[1], 16, 31) && judge0255(ipSplits[2]) && judge0255(ipSplits[3])) {
                                self += 1;
                            }
                        } else if (judgeIn(ipSplits[0], 192, 223) && judge0255(ipSplits[1]) && judge0255(ipSplits[2]) && judge0255(ipSplits[3])) {
                            c += 1;
                            if (judgeIn(ipSplits[0], 192, 192) && judgeIn(ipSplits[1], 168, 168) && judge0255(ipSplits[2]) && judge0255(ipSplits[3])) {
                                self += 1;
                            }
                        } else if (judgeIn(ipSplits[0], 224, 239) && judge0255(ipSplits[1]) && judge0255(ipSplits[2]) && judge0255(ipSplits[3])) {
                            d += 1;
                        } else if (judgeIn(ipSplits[0], 240, 255) && judge0255(ipSplits[1]) && judge0255(ipSplits[2]) && judge0255(ipSplits[3])) {
                            e += 1;
                        } else {
                            isfail = true;
                            fail += 1;
                            continue;
                        }
                    }
                }
            }
        }
        String result = "";
        result = a + " " + b + " " + c + " " + d + " " + e + " " + fail + " " + self;
        return result;
    }

    /**
     * 将整数转成对应的八位二进制字符串
     *
     * @param num
     * @return
     */
    private static String binaryString(int num) {
        StringBuilder result = new StringBuilder();
        int flag = 1 << 7;
        for (int i = 0; i < 8; i++) {
            int val = (flag & num) == 0 ? 0 : 1;
            result.append(val);
            num <<= 1;
        }
        return result.toString();
    }

    public static boolean judgeIn(String str, int a, int b) {
        int number = Integer.parseInt(str);
        if (a <= number && number <= b) {
            return true;
        }
        return false;
    }

    public static boolean judge0255(String str) {
        int number = Integer.parseInt(str);
        if (0 <= number && number <= 255) {
            return true;
        }
        return false;
    }
}
