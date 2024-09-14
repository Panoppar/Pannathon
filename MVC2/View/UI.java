package View;

import javax.swing.*;

public class UI {
    public String chooseCowColor() {
        // Ask user to select cow color
        String[] colors = { "White", "Brown", "Pink" };
        return (String) JOptionPane.showInputDialog(null, 
                "Select Cow Color:", 
                "Cow Registration", 
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                colors, 
                colors[0]);
    }

    public String getCowId() {
        return JOptionPane.showInputDialog("Enter 8-digit Cow ID:");
    }

    public int getFarmId() {
        return Integer.parseInt(JOptionPane.showInputDialog("Enter Farm ID (1-9):"));
    }

    public int getCowAgeYears() {
        return Integer.parseInt(JOptionPane.showInputDialog("Enter Cow Age (Years):"));
    }

    public int getCowAgeMonths() {
        return Integer.parseInt(JOptionPane.showInputDialog("Enter Cow Age (Months):"));
    }

    public String getMotherId() {
        return JOptionPane.showInputDialog("Enter Mother Cow ID:");
    }

    public String getOwnerFirstName() {
        return JOptionPane.showInputDialog("Enter Owner First Name:");
    }

    public String getOwnerLastName() {
        return JOptionPane.showInputDialog("Enter Owner Last Name:");
    }

    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}

