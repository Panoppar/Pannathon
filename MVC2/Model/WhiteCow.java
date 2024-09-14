package Model;

public class WhiteCow extends Cow {
    private int ageYears;
    private int ageMonths;

    public WhiteCow(String id, int farmId, int ageYears, int ageMonths) {
        super(id, farmId);
        this.ageYears = ageYears;
        this.ageMonths = ageMonths;
    }

    public boolean validateAge() {
        return (ageYears >= 0 && ageYears <= 10 && ageMonths >= 0 && ageMonths <= 11);
    }

    public int getAgeYears() {
        return ageYears;
    }

    public int getAgeMonths() {
        return ageMonths;
    }
  
}