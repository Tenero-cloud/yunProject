package Java42_0310;

import java.util.Stack;

public class Test {

    // 1、括号匹配问题
    public boolean isValid(String s) {
        //首先需要创建一个栈（最好不要自己写）
        Stack<Character> stack = new Stack<>();
        //遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果遇到左括号，就需要入栈
            //‘（’ 和 “（” 一样不同，前者是字符 char 类型， 右边的是字符串 String 类型，只有一个左括号字符
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            //遇到右括号的情况了（题目中要求了字符串只包含括号，没有其他字符）
            //取栈顶元素和当前的括号进行匹配
            //标准库的 Stack ，在针对空栈进行 peek 会抛出异常
            if (stack.isEmpty()) {
                return false;
            }
            //此处使用 pop ，把栈顶元素出栈。一旦匹配，就直接 continue 进入下次循环就好了
            Character top = stack.pop();
            if (top == '(' && c == ')') {
                continue;
            }
            if (top == '[' && c == ']') {
                continue;
            }     if (top == '{' && c == '}') {
                continue;
            }
            //若未触发上面的三种情况，则认为此时为非法情况
            return false;
            }
        //循环结束之后，说明字符串遍历完了，
        //还需要判定一下，栈是否为空
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    //用队列实现栈



}
