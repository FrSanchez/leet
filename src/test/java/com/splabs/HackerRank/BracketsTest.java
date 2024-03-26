package com.splabs.HackerRank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BracketsTest {

    @ParameterizedTest
    @MethodSource("test1Provider")
    public void tes1(String test, String exp)
    {
        String actual = Brackets.isBalanced(test);
        Assertions.assertEquals(exp, actual);
    }

    static Stream<Arguments> test1Provider() {
        String [] input = {
                "[()][{}()][](){}([{}(())([[{}]])][])[]([][])(){}{{}{[](){}}}()[]({})[{}{{}([{}][])}]", 
                "[()][{}[{}[{}]]][]{}[]{}[]{{}({}(){({{}{}[([[]][[]])()]})({}{{}})})}",
                "(])[{{{][)[)])(]){(}))[{(})][[{)(}){[(]})[[{}(])}({)(}[[()}{}}]{}{}}()}{({}](]{{[}}(([{]",
                "){[]()})}}]{}[}}})}{]{](]](()][{))])(}]}))(}[}{{)}{[[}[]",
                "}(]}){",
                "((]()(]([({]}({[)){}}[}({[{])(]{()[]}}{)}}]]{({)[}{(",
                "{}{({{}})}[][{{}}]{}{}(){{}[]}{}([[][{}]]())",
                "(){}[()[][]]{}(())()[[([])][()]{}{}(({}[]()))()[()[{()}]][]]",
                "()([]({}[]){}){}{()}[]{}[]()(()([[]]()))()()()[]()(){{}}()({[{}][]}[[{{}({({({})})})}]])",
                "[]([{][][)(])}()([}[}(})}])}))]](}{}})[]({{}}))[])(}}[[{]{}]()[(][])}({]{}[[))[[}[}{(]})()){{(]]){][",
                "{()({}[[{}]]()(){[{{}{[[{}]{}((({[]}{}()[])))]((()()))}(()[[[]]])((()[[](({([])()}))[]]))}]})}",
                "()(){{}}[()()]{}{}",
                "{}()([[]])({}){({[][[][[()]]{{}[[]()]}]})}[](())((())[{{}}])",
                "{}(((){}){[]{{()()}}()})[]{{()}{(){()(){}}}}{()}({()(()({}{}()((()((([])){[][{()}{}]})))))})",
                "][[{)())))}[)}}}}[{){}()]([][]){{{{{[)}]]{([{)()][({}[){]({{",
                "{{}(",
                "{[{((({}{({({()})()})[]({()[[][][]]}){}}))){}}]}{}{({((){{}[][]{}[][]{}}[{}])(())}[][])}",
                "()[[][()[]][]()](([[[(){()[[]](([]))}]]]))",
                "()[]({}{})(()){{{}}()()}({[]()}())[](){}(({()}[{}[{({{}}){({}){({})((({()})))}}}]]))",
                "}[{){({}({)})]([}{[}}{[(([])[(}){[]])([]]}(]]]]{][",
                "[{]{[{(){[}{}(([(]}])(){[[}(]){(})))}}{{)}}{}][({(}))]}({)",
                ")})[(]{][[())]{[]{{}}[)[)}[]){}](}({](}}}[}{({()]]",
                "[[[({[]}({[][[[[][[{(()[][])}()[][]][]{}]]]]}))][(()){}]]]()[{}([]{}){}{{}}]",
                "({[]({[]})}())[][{}[{{(({{{([{}])}}}))}}]]",
                "([((()))()])[][][]{}()(([]))[]()[]((){}[]){}(){{}[]}[[{[]}]]",
                "[[(((({}{[]{}()}){}{{}}){({[]{[{}]{(){}(((){()}))}()}}[[]]()()[()])[[{}{}]()]}))]]{}[]{}({({{}})})",
                "(]{()}((",
                "[][(())[({{{()[]}}{[[][[][[[]{{{[()]{{{{}{[]}[][]}}}}}}]]]]}})]]",
                "}[})})}[)]{}{)",
                "({(}{})))}(}[)[}{)}}[)[{][{(}{{}]({}{[(})[{[({{[}{(]]})}",
                "]}})[]))]{][])[}(])]({[]}[]([)",
                "[{{}{[{{[}[[}([]",
                "[([]){}][({})({[(([])[][])][[{}{([{{}{(()){{{({}{{}}())}}[]}}()[()[{{{([](()){[[[]]]})}}}]]}])}]]})]",
                "]{}{(}))}](})[{]]()(]([}]([}][}{]{[])}{{{]([][()){{})[{({{{[}{}](]}}",
                "{[{}}){(}[][)(}[}][)({[[{]}[(()[}}){}{)([)]}(()))]{)(}}}][",
                "(]{}{(}}}[)[",
                "[]{}{[[]]}([{}]{}[]){{(())}}",
                "[)([{(][(){)[)}{)]]}}([((][[}}(]{}]]}]][(({{{))[[){}{]][))[]{]][)[{{}{()]){)])))){{{[(]}[}}{}]",
                "{({(){[[[][]{}[[([]{})]{}]][[]()()]]}})}[{}{{}}]",
                ")}][(})){))[{}[}",
                "{[]{({]}[}}[{([([)([){{}{(}}[]}}[[{[}[[()(])[}[]",
                "()()()[]",
                "((){}])][]][}{]{)]]}][{]}[)(])[}[({(",
                ")[((])(]]]]((]){{{{())]}]}(}{([}(({}]])[[{){[}]{{}})[){(",
                "}][[{[((}{[]){}}[[[)({[)}]]}(]]{[)[]}{}(){}}][{()]))})]][(((}}",
                "([]){}{{}{}}()([([{}{[[]()([(([]()))()[[]]])]}])])",
                "[()[[]{{[]}()([])}[]][][]][]()[]{}{}[][]{}{}[()(){}]",
                "{[{){]({(((({](]{([])([{{([])[}(){(]](]{[{[]}}())[){})}))[{})))[",
                "{}[()[]][]{}{}[[{{[[({})]()[[()]]]}}]]",
                "{[{}[][]]}[((()))][]({})[]{}{()}",
                "(){[{({})}]}",
                "([]])][{)]({)[]))}]())[}]))][}{(}}})){]}]{[)}(][})[[",
                "((({{}(([{}(())]))[()]{[[[]()]]}})))",
                "}()))}(}]]{{})}][{](]][{]{[[]]]}]]}([)({([))[[(]}])}[}(([{)[)]]([[](]}]}{]{{})[]){]}{])(",
                "{}{}{}{[[()]][]}",
                ")]}]({{})[[[{]{{{}}][))]{{",
                "))){({}])}])}}]{)()(}(]}([",
                "([[]][])[[]()][]()(([[]]{[()[]{[][{}]}[()]]{}{[]}}{{}()}(()[([][]{})[[{}][]]{}[]])))",
                "(]{[({}[){)))}]{[{}][({[({[]))}[}]}{()(([]{]()}})}[]{[)](((]]])([]}}]){)(([]]}[[}[",
                "([[]])({}(([(){{}[{}]}]){[{}]}))[][{}{}](){}",
                "[][][][][][([])][]{({()}[[()()]{([(){[]{}}{(())}{[](){}()({}())}[({}[[]()])][]])}])}",
                "}[{{(}})}}(((())()({]{([]((][(({)[({[]]}[])}]{][{{}]{)][}(])}}}))}}}",
                "[]({})()[]{}{}[]({}{})[]{([])()[()][{()({})[{}{[[()]{}[]][]}(({{[]{()()()}{}[]()}[]}){{}{}})]}]}",
                "{{(([{)]{}({][{](){({([[[][)}[)})(",
                "[{}]{[()({[{}]})]}",
                "[[{}]]",
                "]{{({[{]}[[)]]}{}))}{){({]]}{]([)({{[]){)]{}){){}()})(]]{{])(])[]}][[()()}",
                "{[([}[[{{(]]][}()())]{){(){)]]){})}]{][][(}[]())[}[)})})[][{[)[})()][]))}[[}",
                "]()])}[}}}{]]{)[}(}]]])])}{(}{([{]({)]}])(})[{}[)]])]}[]{{)){}{()}]}((}}{({])[}])[]}",
                "(]}[{}{{][}))){{{([)([[])([]{[",
                "{(()[]){}}(){[]}({{}(()())})([]){}{}(())()[()]{}()",
                "{{}[{}[{}[]]]}{}({{[]}})[[(){}][]]{}(([]{[][]()()}{{{()()}{[]}({}[]{()})}{()}[[]][()]}))",
                "{[][]}[{}[](){}]{{}{[][{}]}}",
                "()(){}(){((){}[])([[]]())}",
                "{}[[{[((}[(}[[]{{]([(}]][[",
                "{}[([{[{{}()}]{}}([[{}[]]({}{{()}[][][]})])])]",
                "{[](}([)(])[]]})()]){[({]}{{{)({}(][{{[}}(]{",
                "[][]{{}[](())}{}({[()]}())[][[][({}([{}]))]]",
                "((()))[]{[(()({[()({[]}{})]}))]}{[]}{{({}{})[{}{}]{()([()])[{()}()[[]{}()]{}{}[]()]}[[]{[]}([])]}}"};
        String [] yesNo = {"YES",
                "YES",
                "NO",
                "NO",
                "NO",
                "NO",
                "YES",
                "YES",
                "YES",
                "NO",
                "YES",
                "YES",
                "YES",
                "YES",
                "NO",
                "NO",
                "YES",
                "YES",
                "YES",
                "NO",
                "NO",
                "NO",
                "YES",
                "YES",
                "YES",
                "YES",
                "NO",
                "YES",
                "NO",
                "NO",
                "NO",
                "NO",
                "YES",
                "NO",
                "NO",
                "NO",
                "YES",
                "NO",
                "YES",
                "NO",
                "NO",
                "YES",
                "NO",
                "NO",
                "NO",
                "YES",
                "YES",
                "NO",
                "YES",
                "YES",
                "YES",
                "NO",
                "YES",
                "NO",
                "YES",
                "NO",
                "NO",
                "YES",
                "NO",
                "YES",
                "YES",
                "NO",
                "YES",
                "NO",
                "YES",
                "YES",
                "NO",
                "NO",
                "NO",
                "NO",
                "YES",
                "YES",
                "YES",
                "YES",
                "NO",
                "YES",
                "NO",
                "YES",
                "YES"};

        Arguments [] args = new Arguments[yesNo.length];
        for(int i = 0; i < yesNo.length; i++) {
            args[i] = Arguments.of(input[i], yesNo[i]);
        }

        return Stream.of(args);
    }
}