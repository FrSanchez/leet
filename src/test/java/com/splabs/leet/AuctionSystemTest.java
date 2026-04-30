package com.splabs.leet;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AuctionSystemTest {
    String[] ops = new String[] {"AuctionSystem","addBid","removeBid","addBid","removeBid","getHighestBidder","addBid","addBid","addBid","addBid","removeBid","addBid","addBid","getHighestBidder","getHighestBidder","updateBid","addBid","addBid","removeBid","getHighestBidder","addBid","updateBid","getHighestBidder","getHighestBidder","removeBid","updateBid","addBid","addBid","addBid","addBid","addBid","updateBid","updateBid","getHighestBidder","getHighestBidder","updateBid","removeBid","getHighestBidder","getHighestBidder","getHighestBidder","addBid","addBid","removeBid","addBid","addBid","getHighestBidder","getHighestBidder","getHighestBidder","getHighestBidder","addBid","addBid","removeBid","getHighestBidder","addBid","getHighestBidder","updateBid","addBid","addBid","getHighestBidder","getHighestBidder","addBid","updateBid","getHighestBidder","addBid","getHighestBidder","addBid","addBid","getHighestBidder","getHighestBidder","getHighestBidder","addBid","addBid","addBid","removeBid","updateBid","addBid","getHighestBid..."};
    int[][] params = new int[][] {{},{29,15,5516},{29,15},{83,4,7581},{83,4},{37},{29,61,2695},{31,49,6264},{2,52,3789},{92,83,265},{31,49},{82,54,4535},{72,39,3756},{39},{83},{2,52,7191},{61,52,2333},{40,69,6630},{2,52},{69},{37,11,5389},{37,11,3611},{52},{83},{29,61},{37,11,2740},{3,80,3809},{4,56,7597},{77,84,5969},{54,42,7830},{84,20,3598},{61,52,320},{82,54,1772},{72},{56},{54,42,4206},{3,80},{56},{84},{37},{47,7,6608},{22,61,3160},{37,11},{37,87,5163},{83,54,5046},{42},{87},{56},{84},{83,27,6418},{22,86,3191},{92,83},{94},{58,51,4448},{20},{54,42,6914},{18,15,6297},{61,29,6673},{56},{92},{64,8,5500},{64,8,4463},{56},{16,62,1523},{29},{58,51,785},{29,49,4874},{87},{20},{22},{53,58,7452},{31,65,5816},{24,2,3341},{53,58},{22,86,1970},{93,86,5384},{52},{83,54},{7},{82,54},{4,56,4463},{39},{3,87,7285},{79},{38,3,2076},{7},{3,87},{8},{38,3,4623}};

    @Test
     public void test() {
         AuctionSystem auction = null;
         Integer[] output = new Integer[ops.length];
         int idx = 0;
        Integer out = null;
         for (int i = 0; i < ops.length; i++) {
             String op = ops[i];
             int[] param = params[i];
             out = null;
             switch (op) {
                 case "AuctionSystem":
                     auction = new AuctionSystem();
                     break;
                 case "addBid":
                     auction.addBid(param[0], param[1], param[2]);
                     break;
                 case "updateBid":
                     auction.updateBid(param[0], param[1], param[2]);
                     break;
                 case "removeBid":
                     auction.removeBid(param[0], param[1]);
                     break;
                 case "getHighestBidder":
                     out = auction.getHighestBidder(param[0]);
                     break;
             }
             output[idx++] = out;
         }
        System.out.println("Output: " + Arrays.toString(output));
     }

}
