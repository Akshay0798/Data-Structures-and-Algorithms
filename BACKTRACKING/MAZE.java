import java.util.ArrayList;
import java.util.Collection;

public class MAZE {
    public static void main(String[] args) {
        System.out.println(count(3, 3));
        path("", 3, 3);
        System.out.println(pathRet("",3,3));
        System.out.println(pathDiagonally("",3,3));
    }

    static int count(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }
        int left = count(r - 1, c);
        int right = count(r, c - 1);
        return left + right;
    }

    //----------------------------------------------------------------
    static void path(String process, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(process);
            return;
        }
        if (r > 1) {
            path(process + 'D', r - 1, c);

        }
        if (c > 1) {
            path(process + 'R', r, c - 1);
        }
    }

    //-------------------------------------------------------------------
    static ArrayList<String> pathRet(String process, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(process);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        if (r > 1) {
            list.addAll(pathRet(process + 'D', r - 1, c));

        }
        if (c > 1) {
            list.addAll(pathRet(process + 'R', r, c - 1));
        }
        return list;
    }
    //----------------------------------------------------------------------

    static ArrayList<String> pathDiagonally(String process, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(process);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        if (r > 1 && c >1) {
            list.addAll(pathDiagonally(process + 'D', r - 1, c-1)); //Diagonally
        }
        if (r > 1) {
            list.addAll(pathDiagonally(process + 'V', r - 1, c)); //vertical/Downside
        }
        if (c > 1) {
            list.addAll(pathDiagonally(process + 'H', r, c - 1)); //Horizontal/Rightside
        }
        return list;
    }
}