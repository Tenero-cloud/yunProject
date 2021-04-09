package Exercise;

import java.util.HashSet;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        HashSet<String> m = new HashSet<>();
        while (scanner.hasNext()) {
            m.add(scanner.next());
        }
        int num = m.size();
        System.out.println(num);
    }
}
