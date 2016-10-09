package test.string;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xuchangyue
 *
 */
public class StringTest {

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
//        System.out.println(new String("ä¸æµ·".getBytes("ISO-8859-1"), "UTF-8"));
//        String str = "2015-1-26";
//        System.out.println(str + " 59:59:59");
//        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String, Object>();
//        List<Object> objs = null;
//        for (Object o : objs) {
//            System.out.println(o);
//        }
//        Long productId = Long.parseLong("");
//        System.out.println(productId);
//        String s = null;
//        if (s.equalsIgnoreCase("asdf")) {
//            System.out.println("asdfasdfasdf");
//        }
//        s.contains("");
//        if (!"asdf".equalsIgnoreCase(s)) {
//            System.out.println("asdfasdf");
//        }
//        String url = "http://www.lvmama.com/youlun/brand-wwwrrtt-tttttt/";
//        System.out.println(url.split("-")[0]);
//        System.out.println(url.split("-")[1]);
//        System.out.println(url.split("-")[2]);
//        Calendar ca = new GregorianCalendar(2015, 10, 11);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(ca.getTime());
//        Long l1 = 1000L;
//        Long l2 = 2000L;
//        Long l3 = 2000L;
//        System.out.println(l1.equals(l2));
//        System.out.println(l1 == l2);
//        System.out.println(l3 == l2);
//        System.out.println(l2.equals(l3));
//        long l = 100L;
//        System.out.println(l/500);
//        for(long i = 0L; i < l/500 + 1; i++) {
//            System.out.println("asdf");
//        }
//        String sss = "asdfasdfasdfasdhsthyertherthjtrhetghqerg6d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F34146d823b7af158a0908c3e6870653F3414qergqaergqaergergafgasfdgasdfasdfasdfasdfasdfsdfa";
//        System.out.println(System.currentTimeMillis());
//        StringTest s = new StringTest();
//        A a1 = s.new A();
//        A a2 = s.new A();
//        a1.setString(sss);
//        a2.setString(sss);
//        
//        for (int j = 0; j < 10000; j++) {
//            MessageDigest md = MessageDigest.getInstance("MD5");
//            byte[] bs = md.digest(a1.toString().getBytes("UTF-8"));
//            String result = "";
//            for (int i = 0; i < bs.length; i++) {
//                // 将整数转换成十六进制形式的字符串 这里与0xff进行与运算的原因是保证转换结果为32位
//                String str = Integer.toHexString(bs[i] & 0xFF);
//                if (str.length() == 1) {
//                    str += "F";
//                }
//                result += str;
//            }
//            
//            
//            bs = md.digest(a2.toString().getBytes("UTF-8"));
//            String result1 = "";
//            for (int i = 0; i < bs.length; i++) {
//                // 将整数转换成十六进制形式的字符串 这里与0xff进行与运算的原因是保证转换结果为32位
//                String str = Integer.toHexString(bs[i] & 0xFF);
//                if (str.length() == 1) {
//                    str += "F";
//                }
//                result1 += str;
//            }
//        }
//
//        System.out.println(System.currentTimeMillis());
        
//        StringBuffer result = new StringBuffer();
//        System.out.println(result.toString());
//        StringTest s = new StringTest();
//        A a1 = s.new A();
//        a1.setString(null);
//        System.out.println(JSONObject.fromObject(a1).toString());
//        String original = "图为<a id= 'xmy'  href='dujia.lvmama.com/tour/shanghai79'>中央音乐学院</a><a id= 'xmy'  href='http://dujia.lvmama.com/tour/shanghai79'>中央音乐学院</a>中央音乐学院图为";
//        String s1 = original.replaceAll(regxpForHtml, "");
////        String str = filterHtml();
//        System.out.println(s1);
        
        
//        Calendar ca = Calendar.getInstance();
//        System.out.println(ca.getTime());
//        ca.set(Calendar.DAY_OF_MONTH, -120);
//        System.out.println(ca.getTime());

//        StringBuffer sb = new StringBuffer();
//        String str1 = "str1str1str1str1str1";
//        String str2 = "str2str2str2str2str2";
//        Long start = System.currentTimeMillis();
//        for (int i = 0; i < 100000; i++) {
//            sb.append(str1 + str2);
//        }
//        System.out.println(System.currentTimeMillis() - start);
//        sb = new StringBuffer();
//        start = System.currentTimeMillis();
//        for (int i = 0; i < 100000; i++) {
//            sb.append(str1);
//            sb.append(str2);
//        }
//        System.out.println(System.currentTimeMillis() - start);;
        
//        String str = new String("【点评有奖第8季】".getBytes(), "UTF-8");
//        byte[] bytes = str.getBytes();
//        System.out.println(bytes.length);
        
        System.out.println(-2>>1);
    }

    private final static String regxpForHtml = "<([^>]*)>"; 
    public static String filterHtml(String str) { 
        Pattern pattern = Pattern.compile(regxpForHtml); 
        Matcher matcher = pattern.matcher(str); 
        StringBuffer sb = new StringBuffer(); 
        boolean result1 = matcher.find(); 
        while (result1) { 
         matcher.appendReplacement(sb, ""); 
         result1 = matcher.find(); 
        } 
        matcher.appendTail(sb); 
        return sb.toString(); 
      }

    class A {
        private String s = "";
        public void setString(String s) {
            this.s = s;
        }
        public String getString() {
            return s;
        }
        @Override
        public String toString() {
            return "A [s=" + s + "]";
        }
        
    }

    private static void m1(String s) {
        System.out.println("String");
    }

    private static void m1(Integer s) {
        System.out.println("Integer");
    }
}
