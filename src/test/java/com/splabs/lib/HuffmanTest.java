package com.splabs.lib;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class HuffmanTest {

    private void encodeAndDecode(String input, String fileName) {
        Huffman huff = new Huffman();
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            huff.encode(input, out);
        }catch (IOException e) {
            e.printStackTrace();
            Assertions.fail();
        }

        String decoded = "";
        try(FileInputStream inp = new FileInputStream(fileName)) {
            decoded = huff.decodeFile(inp);
            System.out.println(decoded);
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail();
        }

        Assertions.assertEquals(input, decoded);
    }
    @Test
    public void testShortString() throws IOException {
        String input = "A_DEAD_DAD_CEDED_A_BAD_BABE_A_BEADED_ABACA_BED";
        System.out.println(input + " len:" + input.length());
        encodeAndDecode(input, "short.huff");
    }

    @Test
    public void testLongString() throws IOException {
        String input = Files.readString(Path.of("dna1.test.txt"));
        System.out.println(input + " len:" + input.length());
        encodeAndDecode(input, "test.huff");
    }
}
