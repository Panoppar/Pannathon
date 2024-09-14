package Model;

public class PinkCow extends Cow {
    private String ownerFirstName;
    private String ownerLastName;

    public PinkCow(String id, int farmId, String firstName, String lastName) {
        super(id, farmId);
        this.ownerFirstName = firstName;
        this.ownerLastName = lastName;
    }

    public boolean validateOwnerName() {
        return ownerFirstName.matches("[a-z]{1,8}") && ownerLastName.matches("[a-z]{1,8}");
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }
}
    