package org.example;

import java.util.*;
import java.util.stream.Stream;

public class LinearCongruentialGenerator {

    Long seed;

    public Stream<Long> lcm(Long a, Long c, Long m, int limit) {
        Stream<Long> outputStream;
        List<Long> output;
        outputStream = Stream.iterate(new Long[]{0L, (long) seed}, x -> new Long[]{x[1],(a * x[0] + c) % m})
                .limit(limit)
                .map(x -> x[0]);
        return outputStream;
    }

    public Long getSeed() {
        return seed;
    }

    public void setSeed(Long seed) {
        this.seed = seed;
    }
}

