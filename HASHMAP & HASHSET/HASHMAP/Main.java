import java.util.HashMap;
@SuppressWarnings("ALL")

public class Main {
    public static void main(String[] args) {
        HashMap<String,String> lovers = new HashMap<>();
        lovers.put("Akshay", "Suppu");
        lovers.put("Naruto", "Hinata");
        lovers.put("Obito", "Rin");
        lovers.put("SalmanKhan","Aishwarya" );
        System.out.println(lovers);

        System.out.println(lovers.get("Akshay"));

//        lovers.remove("Naruto");
//        System.out.println(lovers);

//        lovers.clear();
//        System.out.println(lovers);

//        System.out.println(lovers.size());

//        for (String i : lovers.keySet()){
//            System.out.println(i);
//        }
//        for (String i : lovers.values()){
//            System.out.println(i);
//        }

        lovers.put("SalmanKhan","katrina");
        System.out.println(lovers);

        if (lovers.containsKey("Naruto")){
            System.out.println("key is present");
        }else{
            System.out.println("key is not present");
        }


    }
}