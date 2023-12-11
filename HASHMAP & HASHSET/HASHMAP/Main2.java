import java.util.HashMap;

public class Main2 {
    public static void main(String[] args) {
        HashMap<String,Integer> lovers = new HashMap<>();
        lovers.put("Akshay", 25);
        lovers.put("Naruto", 30);
        lovers.put("Obito", 35);
        lovers.put("Romeo", 40);
        lovers.put("Rocky", 45);
        System.out.println(lovers);

        System.out.println(lovers.get("Akshay"));

        lovers.values().forEach(System.out::println);

        System.out.println(lovers);

    }
}
