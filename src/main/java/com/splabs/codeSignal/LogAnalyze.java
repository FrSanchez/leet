package com.splabs.codeSignal;

import java.util.*;
/*
You are provided with log data from a library's digital system, stored in string format. The log represents books' borrowing activities, including the book ID and the time a book is borrowed and returned. The structure of a log entry is as follows: <book_id> borrow <time>, <book_id> return <time>.

The time is given in the HH:MM 24-hour format, and the book ID is a positive integer between 1 and 500. The logs are separated by a comma, followed by a space (", ").

Your task is to create a Java function named solution(). This function will take as input a string of logs and output a list of strings representing the books with the longest borrowed duration. Each string contains the book ID and the book's borrowed duration, concatenated by a space. By 'borrowed duration,' we mean the period from when the book is borrowed until it is returned. If a book has been borrowed and returned multiple times, the borrowed duration is the total cumulative sum of those durations. If multiple books share the same longest borrowed duration, the function should return all such books in ascending order of their IDs.

For example, if we have a log string as follows: "1 borrow 09:00, 2 borrow 10:00, 1 return 12:00, 3 borrow 13:00, 2 return 15:00, 3 return 16:00",
the function should return the list ["2 05:00"].

Note: You can safely assume that all borrowing actions for a given book will have a corresponding return action in the log, and vice versa. Also, the logs are sorted by the time of the action.
 */
public class LogAnalyze {
    public List<String> solution(String logs) {
        List<String> logList = Arrays.asList(logs.split(", "));
        var timeMap = new HashMap<Integer, Integer>();
        var borrowedMap = new HashMap<Integer, Integer>();
        var answerMap = new HashMap<Integer, HashSet<Integer>>();
        int maxTime = 0;
        for(var logEntry : logList) {
            var parts = logEntry.split(" ");
            int id = Integer.parseInt(parts[0]);
            boolean borrow = parts[1].equalsIgnoreCase("borrow");
            var timeParts = parts[2].split(":");
            var time = Integer.parseInt(timeParts[0]) * 60 + Integer.parseInt(timeParts[1]);
            if (borrow) {
                timeMap.put(id, time);
            } else {
                if (timeMap.containsKey(id)) {
                    int borrowedAt = timeMap.get(id);
                    int totalTime = time - borrowedAt;
                    int tally = borrowedMap.getOrDefault(id, 0) + totalTime;
                    if (tally >= maxTime) {
                        maxTime = tally;
                        var count = answerMap.getOrDefault(maxTime, new HashSet<>());
                        count.add(id);
                        answerMap.put(maxTime, count);
                    }
                    borrowedMap.put(id, tally);
                    timeMap.remove(id);
                }
            }
        }
        var answer = new ArrayList<String>();
        List<Integer> group = new ArrayList<>(answerMap.get(maxTime));
        group.sort(Comparator.comparingInt(Integer::intValue));
        int hour = maxTime / 60;
        int minute = maxTime % 60;
        for(var id : group) {
            answer.add(String.format("%d %02d:%02d", id, hour, minute));
        }
        return answer;
    }
}
