### 一、其他进制转十进制
#### 1.使用Integer.parseInt()方法
> // 2，8，16进制转换成10进制
```
// 使用Integer.parseInt()方法；转换成负数只需要在字符串前面加上负号-；
// 大于Integer.MAX_VALUE或小于Integer.MIN_VALUE的转换将会抛出错误。
int b = Integer.parseInt("1001", 2);    // 2进制转10进制
int o = Integer.parseInt("12", 8);    // 8进制转10进制
int h = Integer.parseInt("123ABC", 16);    // 16进制转10进制
```

#### 2.使用Integer.valueOf()方法
```
// 2，8，16进制转换成10进制
// 使用Integer.valueOf()方法；转换成负数只需要在字符串前加上负号-；
// 大于Integer.MAX_VALUE或小于Integer.MIN_VALUE的转换将会抛出错误。
Integer b = Integer.valueOf("1001", 2); // 2进制转10进制
Integer o = Integer.valueOf("12", 8);    // 8进制转10进制
Integer h = Integer.valueOf("123ABC", 16);    // 16进制转10进制
```

#### 二、十进制转换其他进制
1.使用Integer.toxxxString()方法
```
// 10进制转2，8，16进制，返回类型String
String tb = Integer.toBinaryString(9);    // 10进制转2进制
String to = Integer.toOctalString(10);    // 10进制转8进制
String th = Integer.toHexString(1194684);    // 10进制转16进制
```
2.使用Integer.toString() 方法
```
// 10进制转2，8，16进制，返回类型String
// 使用Integer.toString()方法；
String tb = Integer.toString(9, 2); // 10进制转2进制
String to = Integer.toString(10, 8);    // 10进制转8进制
String th = Integer.toString(1194684, 16);// 10进制转16进制
```
#### 三、大数的转换
大数的转换使用BigInteger
```
// 使用BigInteger对象的toString方法；10进制转2，8，16进制，返回类型String
BigInteger b = new BigInteger("1001", 2); // 2进制转10进制
BigInteger o = new BigInteger("12", 8);    // 8进制转10进制
BigInteger h = new BigInteger("123ABC", 16);// 16进制转10进制
String tb = b.toString(2);    // 10进制转2进制
String to = o.toString(8);    // 10进制转8进制
String th = h.toString(16);    // 10进制转16进制
```
