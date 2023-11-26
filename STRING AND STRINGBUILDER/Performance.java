public class Performance {
    public static void main(String[] args) {
//        String series="";
//        for (int i = 0; i < 26; i++) {
//            char ch=(char)('a'+i);
//            series=series+ch;
//        }
//        System.out.println(series );

        StringBuilder Alphabet=new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch=(char)('a'+i);
            Alphabet.append(ch);
        }
        System.out.println(Alphabet.toString());
        Alphabet.reverse();
        System.out.println(Alphabet);
    }
}
