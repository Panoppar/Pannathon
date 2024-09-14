package Model;

public class BrownCow extends Cow {
    private String motherId;

    public BrownCow(String id, int farmId, String motherId) {
        super(id, farmId);
        this.motherId = motherId;
    }

    public boolean validateMotherId() {
        return motherId.matches("[1-9]\\d{7}");
    }

    public String getMotherId() {
        return motherId;
    }

}
