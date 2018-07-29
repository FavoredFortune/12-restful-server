package models;

import java.util.HashMap;
import java.util.Map;

public class BirdsStorage {
    public static Map<Integer, BirdSeen> birds;

    static{
        birds = new HashMap<>();
        BirdSeen americanRobin = new BirdSeen("American Red Robin", "Woodland Park Zoo", "2013-05-11");
        BirdSeen downyWoodpecker = new BirdSeen("Down Wood Pecker", "Woodland Park Zoo", "2013-05-11");
        BirdSeen goldfinch = new BirdSeen("American Goldfinch", "Woodland Park Zoo", "2013-05-11");
        BirdSeen mallard = new BirdSeen("Mallard Duck", "Woodland Park Zoo", "2013-05-11");
        BirdSeen spectacledOwl = new BirdSeen("Spectacled Owl", "Woodland Park Zoo", "2013-05-11");

        birds.put(americanRobin.id, americanRobin);
        birds.put(downyWoodpecker.id, downyWoodpecker);
        birds.put(goldfinch.id, goldfinch);
        birds.put(mallard.id, mallard);
        birds.put(spectacledOwl.id, spectacledOwl);
    }
}
