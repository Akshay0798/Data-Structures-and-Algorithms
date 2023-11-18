public class AllPathMazeBT {
    public static void main(String[] args) {
        boolean[][] path= { {true,true,true},
                            {true,true,true},
                            {true,true,true},
                            {true,true,true}};
        AllPath("", path,0,0);//starting from 0
    }

    static void AllPath(String process, boolean[][] path, int r, int c) { //r=row;c=column
        if (r == path.length - 1 && c == path[0].length - 1) {
            System.out.println(process);
            return;
        }
        if (path[r][c] == false) {
            return;
        }
        //but if is not false
        //i m considering this block in my path
        path[r][c]=false;

        if (r < path.length - 1) {
            AllPath(process + 'D', path, r + 1, c);
        }

        if (c < path[0].length - 1) {
            AllPath(process + 'R', path, r, c + 1);
        }

        if (r > 0) {
            AllPath(process + 'U', path, r - 1, c);
        }

        if (c > 0) {
            AllPath(process + 'L', path, r, c - 1);
        }
        path[r][c]=true;
        //this line is where the function will be over
        //so before the function gets remove also remove the change that were made by that function
    }
}


//marking false == i have that cell in my current path, so when that path over
//e.g.u r in another recursion call those r cells should not be false
//then what we do: while you are moving back, we restore the maze as it was
//when we go back: when function is return
//when u come out of the recursive function or going back we remark the cell is True
//you are making some changes whlle going in the below recurtion call,so when u go outside those recursion call the changes is made by those recurtion call should also not be available