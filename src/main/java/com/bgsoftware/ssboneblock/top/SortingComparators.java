package com.bgsoftware.ssboneblock.top;

import com.bgsoftware.ssboneblock.OneBlockModule;
import com.bgsoftware.ssboneblock.handler.PhasesHandler;
import com.bgsoftware.ssboneblock.phases.IslandPhaseData;
import com.bgsoftware.superiorskyblock.api.island.Island;

import java.util.Comparator;

public class SortingComparators {

    private final static PhasesHandler phasesHandler = OneBlockModule.getModule().getPhasesHandler();

    private final static Comparator<Island> ISLAND_NAMES_COMPARATOR = (island1, island2) -> {
        String firstName = island1.getRawName().isEmpty() ? island1.getOwner().getName() : island1.getRawName();
        String secondName = island2.getRawName().isEmpty() ? island2.getOwner().getName() : island2.getRawName();
        return firstName.compareTo(secondName);
    };
    public final static Comparator<Island> ONEBLOCK_BLOCKS_COMPARATOR = (island1, island2) -> {
        int compare = Integer.compare(getTotalBlocks(island1), getTotalBlocks(island2));
        return compare == 0 ? ISLAND_NAMES_COMPARATOR.compare(island1, island2) : compare;
    };
    public final static Comparator<Island> ONEBLOCK_LEVEL_COMPARATOR = (island1, island2) -> {
        int compare = Integer.compare(getPhaseLevel(island1), getPhaseLevel(island2));
        return compare == 0 ? ISLAND_NAMES_COMPARATOR.compare(island1, island2) : compare;
    };

    private SortingComparators() {

    }

    private static int getPhaseLevel(Island island) {
        IslandPhaseData islandPhaseData = phasesHandler.getDataStore().getPhaseData(island, false);

        if (islandPhaseData == null) {
            return 0;
        }

        return islandPhaseData.getPhaseLevel();
    }

    private static int getTotalBlocks(Island island) {
        IslandPhaseData islandPhaseData = phasesHandler.getDataStore().getPhaseData(island, false);

        if (islandPhaseData == null) {
            return 0;
        }

        return phasesHandler.getTotalBlocks(islandPhaseData);
    }

}
