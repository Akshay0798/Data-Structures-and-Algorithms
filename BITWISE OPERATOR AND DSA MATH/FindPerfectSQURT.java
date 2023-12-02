public class FindPerfectSQURT {
    public static void main(String[] args) {
        int n=40;
        int p=3;//how much point we need(precision value)

        System.out.println(sqrt(n,p));
        System.out.printf("%.3f",sqrt(n,p));
    }
    static double sqrt(int n ,int p){
        int s=0;
        int e=n;

        double root=0.0;
        while(s<=e){
            int m=s+(e-s)/2;

            if(m * m ==n){
                root =m ;
                return m;
            }
            if(m*m>n){
                e=m-1;
            }else{
                s=m+1;
            }
        }
        //for precision value
        double increment=0.1; // (1/10,1/100)
        for (int i = 0; i < p; i++) {
            while(root * root <= n){
                root = root + increment;
            }
            root -= increment;
            increment /= 10;
        }
        return root;
    }

}
