package com.splabs.Questions;

import java.util.*;
import java.util.stream.Collectors;

public class CashRegister {
    private Map<Double, String> map = null;

    public void initMap() {
        if (map == null) {
            map = new HashMap<>();

            map.put(100.0d, "ONE HUNDRED");
            map.put(50.0d, "FIFTY");
            map.put(20.0d, "TWENTY");
            map.put(10.0d, "TEN");
            map.put(5.0d, "FIVE");
            map.put(2.0d, "TWO");
            map.put(1.0d, "ONE");
            map.put(0.50d, "HALF DOLLAR");
            map.put(0.25d, "QUARTER");
            map.put(0.10d, "DIME");
            map.put(0.05d, "NICKEL");
            map.put(0.01d, "PENNY");
        }
    }

    public String calculateChange(float price, float cash) {
        Double[] thresholds = {100.0d, 50.0d, 20.0d, 10.0d, 5.0d, 2.0d, 1.0d, 0.50d, 025d, 0.10d, 0.05d, 0.01d};
        if (cash < price) {
            return "ERROR";
        }
        if (cash == price) {
            return "ZERO";
        }
        double cashBack = cash - price;
        List<String> change = new ArrayList<>();

        initMap();
        while (cashBack > 0.01d) {
            for (double t : thresholds) {
                if (cashBack >= t) {
                    change.add(map.get(t));
                    cashBack -= t;
                    break;
                }
            }
        }

        return change.stream().sorted().collect(Collectors.joining(","));
//
//        Collections.sort(change);
//        StringBuilder sb = new StringBuilder();
//        boolean first = true;
//        for (String c : change) {
//            if (!first) {
//                sb.append(',');
//            }
//            sb.append(c);
//            first = false;
//        }
//        return sb.toString();

    }

}