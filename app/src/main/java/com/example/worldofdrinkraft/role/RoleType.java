package com.example.worldofdrinkraft.role;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum RoleType
{
    COWBOY_TYPE,
    FREEZER_TYPE;

    private static final List<RoleType> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static RoleType randomRoleType()
    {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}