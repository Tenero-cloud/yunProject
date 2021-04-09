package java42_0201;

import java.util.List;

//public class ThreeConsecutiveOdds {
//    public boolean threeConsecutiveOdds(int[] arr) {
//        for (int i = 0; i < arr.length-2; i++) {
//           if (arr[i] % 2 != 0 && arr[i+1] % 2 != 0 && arr[i+2] % 2 != 0) {
//               return true;
//           }
//        }
//        return false;
//    }
//}


//
public class ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(List<Integer> arr) {
        for (int i = 0; i < arr.size() - 2; i++) {
            if (arr.get(i) % 2 != 0 && arr.get(i + 1) % 2 != 0 && arr.get(i + 2) % 2 != 0) {
                return true;
            }
        }
        return false;
    }
}