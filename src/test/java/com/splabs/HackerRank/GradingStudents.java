package com.splabs.HackerRank;

import java.util.ArrayList;
import java.util.List;

public class GradingStudents {
    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        List<Integer> answer = new ArrayList<>();
        for(int grade : grades) {
            if (grade >= 38) {
                int next = ((grade+5) / 5) * 5;
                if ((next - grade) < 3) {
                    grade = next;
                }
            }
            answer.add(grade);
        }
        return answer;
    }
}
