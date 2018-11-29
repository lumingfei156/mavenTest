package com.maven.test1;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lulu
 * @since 2018/11/29
 */
public class Test24 {
    static final Pattern P = Pattern.compile("\\d+");
    static final Pattern M = Pattern.compile("(?!f)[a-z]\\d{4,14}[A-Z](?<!K)");
    public static void main(String[] args) {
        //返回正则的字符串
        System.out.println(P.pattern());

        //以正则表达式分割字符串
        String s = "我的QQ是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com";
        String[] str = P.split(s);
        for (String temp : str){
            System.out.println(temp);
        }

        //使用正则配对字符串，如果配对了，返回true，否则，返回false
        String s1 = "232232";
        String s2 = "232232aa";
        String s3 = "232bb232";
        System.out.println(Pattern.matches("\\d+",s1));
        System.out.println(Pattern.matches("\\d+",s2));
        System.out.println(Pattern.matches("\\d+",s3));
        //首字符为小写字母且不以f开头，后最多为14 位数字的字符串,最后为大写字母结尾但是不以k结尾的字符
        String qq = "z11234567M";
        System.out.println("字符验证："+Pattern.matches("^(?!f)[a-z]\\d{4,14}[A-Z](?<!K)$",qq));

        //matcher类
        Matcher m = M.matcher("l4585454154551245J z11234567M j121125541521N ");

        System.out.println("使用find查找：");
        System.out.println(m.find());
        System.out.println(m.groupCount());
//        System.out.println("使用lookingAt查找：");
//        System.out.println(m.lookingAt());
//        System.out.println(m.start());
//        System.out.println(m.end());

    }
}
