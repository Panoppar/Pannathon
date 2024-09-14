package Model;

public class Cow {
    private String id;
    private int farmId;
    
    public Cow(String id, int farmId) {
        this.id = id;
        this.farmId = farmId;
    }

    public String getId() { return id; }
    public int getFarmId() { return farmId; }

    public boolean validateId() {
        // Validate that the ID is 8 digits and does not start with 0
        return id.matches("[1-9]\\d{7}");
    }

    public boolean validateFarmId() {
        // Validate that the farm ID is a single digit, not starting with 0
        return (farmId > 0 && farmId <= 9);
    }
}