package com.splabs.HackerRank;

import java.util.*;

class Editor {

    StringBuilder sb;
    Stack<String> stack;
    public Editor() {
        sb = new StringBuilder();
        stack = new Stack<>();

    }
    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public String editor(String operation) {
        // Write your code here
        String[] op = operation.split(" ");
        int n = Integer.parseInt(op[0]);
        int q = 0;
        System.out.println("Op: " + operation + "[" + sb);
        switch(n) {
            case 1:
                stack.push(sb.toString());
                sb.append(op[1]);
                break;
            case 2:
                stack.push(sb.toString());
                q = Integer.parseInt(op[1]);
                sb.delete(sb.length() - q, sb.length());
                break;
            case 3:
                q = Integer.parseInt(op[1]) - 1;
                return String.format("%c", sb.charAt(q));
            case 4:
                System.out.println("Undo:");
                if (!stack.empty()) {
                    String state = stack.pop();
                    sb = new StringBuilder(state);
                }
                break;
            default:
                System.out.println("Unknown operation");
        }
        return "";
    }
}

