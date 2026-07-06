package com.bgsoftware.ssboneblock.top;

import com.bgsoftware.superiorskyblock.api.island.Island;
import com.bgsoftware.superiorskyblock.api.island.SortingType;

import java.util.Comparator;

public class SortingTypes {

    public static final SortingType BY_BLOCKS = register("ONEBLOCK-BLOCKS", SortingComparators.ONEBLOCK_BLOCKS_COMPARATOR, false);
    public static final SortingType BY_LEVEL = register("ONEBLOCK-LEVEL", SortingComparators.ONEBLOCK_LEVEL_COMPARATOR, false);

    private SortingTypes() {
    }

    public static void registerSortingTypes() {
        // Do nothing, only trigger all the register calls
    }

    private static SortingType register(String name, Comparator<Island> comparator, boolean handleEqualsIslands) {
        SortingType.register(name, comparator, handleEqualsIslands);
        return SortingType.getByName(name);
    }

}
