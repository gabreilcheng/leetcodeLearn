package com.cheng.learn.study01;

import java.util.Stack;

public class 有效括号 {

        public boolean isValid(String s) {
            //用栈实现
            Stack<Character> stack = new Stack<>();
            char[] charArr =  s.toCharArray();
            for(int i = 0;i < charArr.length;i++) {
                if(charArr[i] == '(') {
                    stack.push(')');
                } else if(charArr[i] == '[') {
                    stack.push(']');
                } else if(charArr[i] == '{') {
                    stack.push('}');
                } else if(stack.isEmpty() || charArr[i] != stack.pop()){
                    return false;
                }
            }
            return stack.isEmpty();

        }
}
