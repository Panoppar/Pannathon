package Controller;

import View.UI;
import Model.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CowRegister {
    private UI ui;
    private Map<Integer, Farm> farmMap;
    private static final String CSV_FILE_PATH = "DB/cows_100.csv"; // Path to the CSV file

    public CowRegister(UI ui) {
        this.ui = ui;
        this.farmMap = new HashMap<>(); // Stores farms by farmId
    }

    public void startRegistration() {
        while (true) {
            String color = ui.chooseCowColor();
            if (color == null) break; // User cancelled

            String cowId = ui.getCowId();
            int farmId = ui.getFarmId();

            if (!farmMap.containsKey(farmId)) {
                farmMap.put(farmId, new Farm(farmId)); // Create new farm if not exists
            }
            Farm farm = farmMap.get(farmId);

            Cow cow = null;
            switch (color) {
                case "White":
                    int ageYears = ui.getCowAgeYears();
                    int ageMonths = ui.getCowAgeMonths();
                    WhiteCow whiteCow = new WhiteCow(cowId, farmId, ageYears, ageMonths);
                    if (whiteCow.validateId() && whiteCow.validateFarmId() && whiteCow.validateAge()) {
                        cow = whiteCow;
                    }
                    break;
                case "Brown":
                    String motherId = ui.getMotherId();
                    BrownCow brownCow = new BrownCow(cowId, farmId, motherId);
                    if (brownCow.validateId() && brownCow.validateFarmId() && brownCow.validateMotherId()) {
                        cow = brownCow;
                    }
                    break;
                case "Pink":
                    String firstName = ui.getOwnerFirstName();
                    String lastName = ui.getOwnerLastName();
                    PinkCow pinkCow = new PinkCow(cowId, farmId, firstName, lastName);
                    if (pinkCow.validateId() && pinkCow.validateFarmId() && pinkCow.validateOwnerName()) {
                        cow = pinkCow;
                    }
                    break;
            }

            if (cow != null) {
                if (farm.addCow(cow, color)) {
                    ui.displayMessage("Cow registered successfully.");
                    // Write cow data to CSV file
                    writeCowToCSV(cow, farmId);
                } else {
                    ui.displayMessage("Farm already has cows of another color.");
                }
            } else {
                ui.displayMessage("Invalid cow data.");
            }

            // Display farm information
            String message = "Farm " + farmId + " has " + farm.getNumberOfCows() + " cows of color " + farm.getColorRestriction() + ".";
            ui.displayMessage(message);
        }
    }

    // Helper method to write cow data to the CSV file
    private void writeCowToCSV(Cow cow, int farmId) {
        // Use a try-with-resources statement to ensure the BufferedWriter is closed properly
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH, true))) {
            // Format the CSV line according to cow type
            String line = String.format("%s,%d,%d,%d,%s,%s,%s",
                cow.getId(),
                farmId,
                cow instanceof WhiteCow ? ((WhiteCow) cow).getAgeYears() : "",
                cow instanceof WhiteCow ? ((WhiteCow) cow).getAgeMonths() : "",
                cow instanceof BrownCow ? ((BrownCow) cow).getMotherId() : "",
                cow instanceof PinkCow ? ((PinkCow) cow).getOwnerFirstName() : "",
                cow instanceof PinkCow ? ((PinkCow) cow).getOwnerLastName() : ""
            );
            
            // Write the formatted line to the CSV file
            writer.write(line);
            writer.newLine();
            
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace to help with debugging
        }
    }
    
}
