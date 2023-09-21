package org.example;

import java.util.*;
import java.util.stream.Stream;

public class StreamManipulation {

    private static int index = 0;
    public <T> Stream<T> createStream(List<T> list) {
        Stream<T> createdStream = list
                .stream();
        return createdStream;
    }

    private static int count(int i) {
        if(i % 2 == 0) {
            return i + index;
        } else {
            return i + index++;
        }
    }
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        T[] firstArray = (T[]) first.toArray();
        T[] secondArray = (T[]) second.toArray();
        int limit = 0;
        int length = 0;
        if(firstArray.length < secondArray.length) {
            limit = 2 * firstArray.length - 1;
            length = firstArray.length;
        } else {
            limit = 2 * secondArray.length;
            length = secondArray.length;
        }
        List<T> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(firstArray[i]);
            list.add(secondArray[i]);
        }
        Stream<T> out = list.stream();

        return out;
    }
}
