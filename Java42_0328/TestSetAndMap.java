package Java42_0328;

import java.util.HashMap;
import java.util.Map;

public class TestSetAndMap {
    //1.找只出现一次的数字
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int x:nums) {
            Integer value = map.get(x);
            if (value ==null) {
                //说明当前的 x 是第一次出现
                map.put(x,1);
            } else {
                map.put(x, value + 1);
            }
        }
        //遍历 map 找出 value 为 1 的 key
        for (Map.Entry<Integer,Integer> entry :map.entrySet()) {
            if (entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }
        return 0;
    }




//    public int singleNumber1(int[] nums) {
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int x:nums) {
//            Integer value = map.get(x);
//            if (value == null) {
//                //当前的 x 第一次出现
//                map.put(x,1);
//
//            } else {
//                map.put(x,value + 1);
//            }
//        }
//        //遍历 map 找出 value 为 1 的 key
//        for (Map.Entry<Integer,Integer>entry:map.entrySet()) {
//            if (entry.getValue().equals(1)) {
//                return entry.getKey();
//            }
//        }
//        return 0;
//    }


    // 1.1 按位 ^(异或)的方式来实现
    //把所有数字往一起异或，最终异或结果就是只出现一次的值，没有其他小伙伴能抵消这个元素
//    public int singleNumber(int[] nums) {
//        int ret = 0;
//        for (int x :nums) {
//            ret ^= x;
//        }
//        return ret;
//
//    }
}
