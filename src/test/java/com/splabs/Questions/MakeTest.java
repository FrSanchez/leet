package com.splabs.Questions;

import com.splabs.lib.Combinations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class MakeTest {

    Make make;
    @BeforeEach
    public void init() {
        make = new Make();
    }

    @Test
    public void testParse() {
        make.parseInput(getFile("file1"));
        make.debug();
    }

    private String[] getFile(String file) {
        if (file.equals("file2")) {
            return getFile2();
        }
        return getFile1();
    }

    private String[] getFile1() {
        return new String[]{
                "red:",
                "    echo \"Compile RED\" > red",
                "blue:",
                "    echo \"Compile BLUE\" > blue",
                "",
                "purple: blue red",
                "    echo \"Compiling purple\" > purple",
                "    cat red blue >> purple"
        };
    }

    public String[] getFile2() {
        return new String[]{
                "one:",
                "    echo \"Compile ONE\" > one",
                "two: one",
                "    echo \"Compile TWO\" > two",
                "",
                "three: one",
                "    echo \"Compiling three\" > three",
                "    cat red blue >> three",
                "four: two three",
                "    echo \"Compiling four\" > four",
        };
    }

    @ParameterizedTest
    @MethodSource("removeKProvider")
    public void testBuild(String target, String file) throws Exception {
        make.parseInput(getFile(file));
        make.debug();
        make.build(target);
    }

    static Stream<Arguments> removeKProvider() {
        return Stream.of(
                Arguments.of("four", "file2"),
                Arguments.of("red", "file1"),
                Arguments.of("blue", "file1"),
                Arguments.of("purple", "file1"),
                Arguments.of("foo", "file1")
        );
    }
}