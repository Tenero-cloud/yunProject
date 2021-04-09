package Java42_0325;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        //1.使用 put 方法插入键值对
        //  map 内部对于与元素的顺序是有自己的一套规则的
        //  和插入顺序没啥关系
        //  如果 put 的 key 已经存在，后来的 value 会覆盖原来的 key
        //  不存在直接插入。存在就修改 value
        map.put("及时雨","宋江");
        map.put("黑旋风","李逵");
        map.put("行者","武松");
        map.put("小李广","花荣");
        System.out.println(map);


        //2.使用 map 最大的目的是要根据 key 来找 value
        //  使用 get 方法完成这个事情
        //  只是在所有的 key 中查找队对应的元素，和 value 无关
        //  当 key 不存在的时候，此时 get 就会返回null
        //  存在就获取到值，不存在就是 null / 默认值
//        String value = map.get("李逵");
//
//        value = map.getOrDefault("小李广", "花荣");
//        System.out.println(value);

        //3.使用 size() 获取包含多少个“键值对”
//        System.out.println(map.size());

        //4. 使用 isEmpty 判定是否没有键值对（size 为 0）
//        System.out.println(map.isEmpty());

        //5. 使用 clear 清空所有的键值对
//        map.clear();
//        System.out.println(map.isEmpty());
//        System.out.println(map.size());

        //6. 遍历 map(稍微复杂一点)
        //   map 别设计出来的初衷，不是用于遍历
        // a) 直接使用 for 循环（for-each）
        //    此处的 Entry 理解成 “条目” 也就是一个键值对
        //    Entry 是 Map 的内部类
        //    map。entrySet 其实是把所有的键值对都取出来放到一个 Set 里
        for (Map.Entry<String,String>entry :map.entrySet() ) {
            System.out.println(entry.getKey() + "：" + entry.getValue());
        }

        //    把所有的 key 取出来放到一个 set 里面，然后再遍历
        for (String key:map.keySet()) {
            System.out.println(key);
        }

        //    把所有的 value 取出来放到一个 List里面，然后遍历
        for (String value : map.values()) {
            System.out.println(value);
        }
        //上面的 entrySet ,keySet, value 方法都是比较低效的方法
        //尽量还是少用
    }
}
