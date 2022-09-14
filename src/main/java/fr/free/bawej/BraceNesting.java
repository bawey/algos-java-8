package fr.free.bawej;

import java.util.ArrayList;
import java.util.List;

public class BraceNesting {

    public int solution(String input) {
        List<Character> stack = new ArrayList<Character>(input.length() / 2);

        for (char c : input.toCharArray()) {
            switch (c) {
                case '{':
                case '(':
                case '[':
                    stack.add(c);
                    break;
                case '}':
                case ']':
                case ')':
                    if (stack.size() == 0) {
                        return 0;
                    }
                    char popped = stack.remove(stack.size() - 1);
                    if (c == ')' && popped != '(' || c == '}' && popped != '{' || c == ']' && popped != '[') {
                        return 0;
                    }
                    break;
                default:
                    return 0;
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }


}
