package Java42_0328;

import java.util.*;

public class preKWord {
    public List<String> topKFrequent(String[] words, int k) {
        // 1. 先统计每个单词出现的次数
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            Integer value = map.getOrDefault(word, 0);
            map.put(word, value + 1);
        }
        // 2. 此处直接使用排序实现. 使用优先队列也阔以, 但是代码稍微更麻烦一些
        List<String> wordList = new ArrayList<>(map.keySet());
        Collections.sort(wordList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 变量捕获~ 匿名内部类, 可以直接使用外部的变量~~
                // 本质上相当于编译器自动给该匿名内部类创建了一个同名同类型的属性
                // 并且在实例化的时候自动进行了传参~~
                int count1 = map.get(o1);
                int count2 = map.get(o2);
                if (count1 == count2) {
                    // 如果出现次数相同, 就按照 String 的默认比较规则排序
                    return o1.compareTo(o2);
                }
                return count2 - count1;
            }
        });
        return wordList.subList(0, k);
    }
}
