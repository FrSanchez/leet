package com.splabs.leet;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class AuctionSystem {

    static class Item {
        public int itemId;
        public int bid;
        public int userId;

        public Item(int i, int b, int u) {
            itemId = i; bid = b; userId= u;
        }

        @Override
        public String toString() {
            return String.format("ItemId: %d, Bid: %d, UserId: %d", itemId, bid, userId);
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Item) {
                Item i = (Item) o;
                return itemId == i.itemId && userId == i.userId;
            }
            return false;
        }
    }

    static class ItemComparator implements Comparator<Item> {
        @Override
        public int compare(Item o1, Item o2) {
            if(o1.bid == o2.bid) {
                return o2.userId - o1.userId;
            }
            return o2.bid - o1.bid;
        }
    }
    private HashMap<Integer, PriorityQueue<Item>> map;

    public AuctionSystem() {
        map = new HashMap<>();
    }

    public void addBid(int userId, int itemId, int bidAmount) {
        if (!map.containsKey(itemId)) {
            map.put(itemId, new PriorityQueue<>(new ItemComparator()));
        }
        var pq = map.get(itemId);
        var item = new Item(itemId, bidAmount, userId);
        if (pq.contains(item)) {
            pq.remove(item);
        }
        pq.add(item);
    }

    public void updateBid(int userId, int itemId, int newAmount) {
        addBid(userId, itemId, newAmount);
    }

    public void removeBid(int userId, int itemId) {
        if (map.containsKey(itemId)) {
            var pq = map.get(itemId);
            var item = new Item(itemId, 0, userId);
            if (pq.contains(item)) {
                pq.remove(item);
            }
        }
    }

    public int getHighestBidder(int itemId) {
        if (map.containsKey(itemId)) {
            var pq = map.get(itemId);
            if (!pq.isEmpty()) {
                return pq.peek().userId;
            }
        }
        return -1;
    }
}

/**
 * Your AuctionSystem object will be instantiated and called as such:
 * AuctionSystem obj = new AuctionSystem();
 * obj.addBid(userId,itemId,bidAmount);
 * obj.updateBid(userId,itemId,newAmount);
 * obj.removeBid(userId,itemId);
 * int param_4 = obj.getHighestBidder(itemId);
 */