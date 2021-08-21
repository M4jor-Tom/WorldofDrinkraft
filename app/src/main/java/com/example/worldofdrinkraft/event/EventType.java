package com.example.worldofdrinkraft.event;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum EventType
{
    DID_OR_DIDNT_TYPE,
    TRUTH_OR_DARE_TYPE;

    private static final List<EventType> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static EventType randomEventType()
    {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}