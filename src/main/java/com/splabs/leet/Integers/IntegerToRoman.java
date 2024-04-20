package com.splabs.leet.Integers;

import javax.imageio.stream.IIOByteBuffer;

public class IntegerToRoman {

    private String digitsToRoman(int num, Character[] code) {
        StringBuilder sb = new StringBuilder();
        switch(num) {
            case 1: return code[0].toString();
            case 2: return (code[0].toString()).repeat(2);
            case 3: return (code[0].toString()).repeat(3);
//            case 4: return "IV";
            case 4: return new String(new char[]{code[0],code[1]});
            case 5: return code[1].toString();
            case 6: return sb.append(code[1]).append(code[0]).toString();
            case 7: return sb.append(code[1]).append(code[0]).append(code[0]).toString();
            case 8: return sb.append(code[1]).append(code[0]).append(code[0]).append(code[0]).toString();
            case 9: return sb.append(code[0]).append(code[2]).toString();
        }
        return "";
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(digitsToRoman(num % 10, new Character[]{'I','V','X'}));
        if (num >= 10) {
            sb.insert(0, digitsToRoman((num / 10) % 10, new Character[]{'X','L','C'}));
        }
        if (num >= 100) {
            sb.insert(0, digitsToRoman((num / 100) % 10, new Character[]{'C','D','M'}));
        }
        if (num >= 1000 && num < 4000) {
            sb.insert(0, digitsToRoman((num / 1000) % 10, new Character[]{'M', 'M', 'M'}));
        }
        if (num >= 4000) {
            return "ERROR";
        }
        return sb.toString();
    }
}
