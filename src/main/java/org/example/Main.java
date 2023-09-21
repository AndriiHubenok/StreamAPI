package org.example;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        TextManipulation namesFinder = new TextManipulation();
        namesFinder.writeFile("Ivan\nElizabeth\nPeter\nVladislav\nMichael\nRichard\nPablo\nRicardo\nAndy\nSandy\nCarl",
                "names.txt");
        namesFinder.readFile();
        namesFinder.findNames();
        System.out.println(namesFinder.getStrings());

        TextManipulation namesFilter = new TextManipulation();
        namesFilter.writeFile("Ivan\nElizabeth\nPeter\nVladislav\nMichael\nRichard\nPablo\nRicardo\nAndy\nSandy\nCarl",
                "listToFilter.txt");
        namesFilter.readFile();
        namesFilter.sortStrings();
        System.out.println(namesFilter.getStrings());

        String[] numsAndSymbols = {"1, 2, 0", "4, 5"};
        StringManipulation stringArrayWithNums = new StringManipulation();
        stringArrayWithNums.setLines(numsAndSymbols);
        System.out.println(stringArrayWithNums.getNumbers());

        LinearCongruentialGenerator lcg = new LinearCongruentialGenerator();
        Long seed = 1L;
        Long a = 25_214_903_917L;
        Long c = 11L;
        Long m = (long) Math.pow(2, 48);
        int limit = 20;
        lcg.setSeed(seed);
        System.out.println(lcg.lcm(a, c, m, limit).toList());

        StreamManipulation str = new StreamManipulation();
        Stream first = Stream.of(1, 3, 5);
        Stream second = Stream.of(2, 4, 6);
        System.out.println(str.zip(first, second).toList());
    }
}