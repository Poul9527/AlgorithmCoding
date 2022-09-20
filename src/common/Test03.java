package common;

public class Test03 {
    public static String changeFormatNumber(String number) {
        if (number == null || number.length() <= 0) {
            return "INPUTERROR";
        }
        char[] nc = number.toCharArray();
        if (nc[0] != '-' && !Character.isDigit(nc[0])) {
            return "INPUTERROR";
        }
        // 判断是否非法
        int i = 0, flag = 0;
        if (nc[0] == '-') {
            flag = 1;
            ++i;
        }
        for (; i < nc.length; ++i) {
            if (!Character.isDigit(nc[i])) {
                return "INPUTERROR";
            }
        }
        StringBuilder builder = new StringBuilder();
        try {
            Integer ans = Integer.parseInt(number);
            if(ans > 32767 || ans < -32767) {
                // 越界
                return "NODATA";
            }
            String binary = Integer.toBinaryString(ans);
            if (binary.length() > 16) {
                binary = binary.substring(binary.length() - 16);
            } else if (binary.length() < 16) {
                builder.append(flag);
                for (int j = 1; j < 16 - binary.length(); ++j) {
                    builder.append("0");
                }
            }
            builder.append(binary + ",");
            // 转16进制
            String hex = Integer.toHexString(ans).toUpperCase();
            if (hex.length() > 4) {
                hex = hex.substring(hex.length() - 4);
            } else if (hex.length() < 4) {
                for (int j = 0; j < 4 - hex.length(); ++j) {
                    builder.append("0");
                }
            }
            builder.append(hex);
        } catch (NumberFormatException e) {
            return "NODATA";
        }

        DataBean dataBean = new DataBean();
        dataBean.setH("150");
        return builder.toString();
    }

    public static void main(String[] args) {
        DataBean dataBean = new DataBean();
        dataBean.setH("150");
        changeFormatNumber("sdaf");
        System.out.println(Math.random());
    }


}
