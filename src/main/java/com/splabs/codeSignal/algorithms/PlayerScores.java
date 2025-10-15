package com.splabs.codeSignal.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlayerScores {
    public List<Integer> solution(List<Integer> player_ids, List<Integer> player_scores, List<Integer> queries) {
        var map = new HashMap<Integer, Integer>();
        for(int i = 0; i < player_ids.size(); i++) {
            map.put(player_ids.get(i), player_scores.get(i));
        }
        var answer = new ArrayList<Integer>(queries.size());
        for(var query : queries) {
            if(map.containsKey(query)) {
                answer.add(map.get(query));
            }
        }
        return answer;
    }
}
