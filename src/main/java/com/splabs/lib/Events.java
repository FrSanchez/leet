package com.splabs.lib;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

// Write an event de-duplication system. The system receives event with an id . The system has a time window.
// any event with the same id within the same time window should be de-duplicated. The system should return the list of unique events for each time window.
public class Events {
    private final int timeWindow;
    private final HashMap<Integer, Integer> buffer;

    public Events(int timeWindow) {
        this.timeWindow = timeWindow;
        this.buffer = new HashMap<Integer, Integer>();
    }

    public int getTimeWindow() {
        return timeWindow;
    }

    public boolean addEvent(int id, int timestamp) {
        if (!buffer.containsKey(id) || timestamp - buffer.get(id) >= timeWindow) {
            buffer.put(id, timestamp);
            return true;
        }
        return false;
    }

    public Collection<Integer> getEvents(int timestamp) {
        var answer = new HashSet<Integer>();
        for (var key : buffer.keySet()) {
            if (timestamp - buffer.get(key) < timeWindow) {
                answer.add(key);
            }
        }
        return answer;
    }
}
