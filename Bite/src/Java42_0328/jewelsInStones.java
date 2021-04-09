package Java42_0328;

import java.util.HashSet;
import java.util.Set;

public class jewelsInStones {
    public int nemJewelsInStones(String jewels,String stones) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }
        //遍历 stones 判定当前字符是否存在
        int count= 0;
        for (int j = 0; j < stones.length(); j++) {
            if (set.contains(stones.charAt(j))) {
                count++;
            }
        }
        return count;
    }

}
