package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringManipulation {
    String[] lines;

    public void setLines(String[] lines) {
        this.lines = lines;
    }

    public String getNumbers() {
        List<String> listOfStrings;
        listOfStrings = Arrays.stream(lines).toList();
        StringBuilder nums = new StringBuilder();
        Stream<String> words = listOfStrings
                .stream()
                .map(string -> string.replaceAll("\\D", " "));
        List<String> sortedStrings = words.collect(Collectors.toList());
        for (String string: sortedStrings) {
            nums.append(string);
            nums.append(" ");
        }

        List<String> listOfNums = Arrays.asList(nums.toString().split("\\s+"));
        Stream<String> streamOfNums = listOfNums
                .stream()
                .sorted();
        return streamOfNums.collect(Collectors.toList()).toString();
    }
}
