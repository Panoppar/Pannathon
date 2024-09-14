package Model;

import java.util.ArrayList;
import java.util.List;

public class Farm {
    private int farmId;
    private String colorRestriction;
    private List<Cow> cows;

    public Farm(int farmId) {
        this.farmId = farmId;
        this.cows = new ArrayList<>();
    }

    public boolean addCow(Cow cow, String color) {
        if (colorRestriction == null || colorRestriction.equals(color)) {
            colorRestriction = color;
            cows.add(cow);
            return true;
        } else {
            return false; // Color mismatch
        }
    }

    public int getNumberOfCows() {
        return cows.size();
    }

    public String getColorRestriction() {
        return colorRestriction;
    }
}
