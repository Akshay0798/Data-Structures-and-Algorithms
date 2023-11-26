import java.util.AbstractList;
import java.util.ArrayList;

public class Operator {
    public static void main(String[] args) {
        System.out.println('a'+'b');
        System.out.println("a"+"b");
        System.out.println('a'+0);
        System.out.println('a'+3);
        System.out.println((char) ('k'-3));
        System.out.println("a"+1);//integer that converted to Integer that will call toString
        System.out.println("Akshay"+ new ArrayList<>());

        //This will not work becaue atleast need one string
        //System.out.println("Suppu" + new Integer(69));

        String ans=(new Integer(69) +" "+ new ArrayList<>());
        System.out.println(ans);

        String up="5";
        int digit=up.charAt(0) - '0';
        System.out.println(digit);
    }
}
