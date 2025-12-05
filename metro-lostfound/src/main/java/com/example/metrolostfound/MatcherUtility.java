package com.example.metrolostfound;

public class MatcherUtility {

    public static boolean isMatch(LostItem lost, FoundItem found) {

        boolean nameMatch = lost.getDescription().equalsIgnoreCase(found.getDescription());
        boolean colorMatch = lost.getColor().equalsIgnoreCase(found.getColor());
        boolean locationMatch = lost.getStation().equalsIgnoreCase(found.getLocationFound());

        return nameMatch && colorMatch && locationMatch;
    }

    public static String matchStatus(LostItem lost, FoundItem found) {
        return isMatch(lost, found) ? "MATCHED" : "NOT MATCHED";
    }
}
