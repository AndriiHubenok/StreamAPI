package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextManipulation {
    private File file;
    private StringBuilder text;
    private String strings;

    public void writeFile(String text, String name) {
        file = new File(name);
        try (FileWriter writer = new FileWriter(file))
        {
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void readFile() {
        try (FileReader reader = new FileReader(file)) {
            int c;
            text = new StringBuilder();
            while ((c = reader.read()) != -1) {
                text.append((char) c);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void findNames() {
        List<String> listOfWords;
        listOfWords = Arrays.asList(text.toString().split("\n"));
        Stream<String> words = listOfWords
                        .stream()
                        .map(word -> (listOfWords.indexOf(word) + 1) + ". " + word);
        List<String> numAndNames = words.collect(Collectors.toList());
        List<String> filteredNames = new ArrayList<String>();
        for (String name: numAndNames) {
            if(numAndNames.indexOf(name) % 2 == 0) {
                filteredNames.add(name);
            }
        }
        strings = filteredNames.toString();
    }

    public void sortStrings() {
        List<String> listOfStrings;
        listOfStrings = Arrays.asList(text.toString().split("\n"));
        Stream<String> words = listOfStrings
                .stream()
                .map(string -> string.toUpperCase())
                .sorted(Comparator.reverseOrder());
        List<String> sortedStrings = words.collect(Collectors.toList());
        strings = sortedStrings.toString();
    }

    public String getStrings() {
        return strings;
    }
}
