package Java42_0129;

public class Add {
    public static int add(int N) {
        if(N<2) {
            return N;
        }
        return add(N-1) + N;
    }

    public static void main(String[] args) {

        int ret =add(10);
        System.out.println(ret);


    }
}
