package org.tbcarus.service;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
public class RandomService {
    @Getter
    private static RandomService randomService = new RandomService();
    private ThreadLocalRandom random = ThreadLocalRandom.current();

}
