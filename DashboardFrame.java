package org.example.uap;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {
    private final double bmr;
    private double consumedCalories = 0;
    private final JProgressBar calorieProgressBar;
    private final JLabel consumedLabel;
    private final FoodDatabase foodDatabase;

    public DashboardFrame(double bmr) {
        this.bmr = bmr;
        this.foodDatabase = new FoodDatabase();

        setTitle("Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Panel Kiri
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setPreferredSize(new Dimension(200, 600));

        JButton addFoodButton = new JButton("Add Food");
        JButton addDrinkButton = new JButton("Add Drink");
        JButton viewHistoryButton = new JButton("View History");
        JButton calculateCaloriesButton = new JButton("Calculate Calories");

        Dimension buttonSize = new Dimension(150, 40);
        addFoodButton.setMaximumSize(buttonSize);
        addDrinkButton.setMaximumSize(buttonSize);
        viewHistoryButton.setMaximumSize(buttonSize);
        calculateCaloriesButton.setMaximumSize(buttonSize);

        addFoodButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addDrinkButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewHistoryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        calculateCaloriesButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        addFoodButton.addActionListener(e -> addFood());
        addDrinkButton.addActionListener(e -> addDrink());
        viewHistoryButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Feature coming soon!"));
        calculateCaloriesButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Total Calories Consumed: " + (int) consumedCalories + " / " + (int) bmr,
                    "Calorie Details", JOptionPane.INFORMATION_MESSAGE);
        });

        leftPanel.add(Box.createVerticalGlue());
        leftPanel.add(addFoodButton);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        leftPanel.add(addDrinkButton);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        leftPanel.add(viewHistoryButton);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        leftPanel.add(calculateCaloriesButton);
        leftPanel.add(Box.createVerticalGlue());

        // Panel Tengah
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        calorieProgressBar = new JProgressBar(0, (int) bmr);
        calorieProgressBar.setValue((int) consumedCalories);
        calorieProgressBar.setStringPainted(true);

        consumedLabel = new JLabel("Calories Consumed: " + (int) consumedCalories + " / " + (int) bmr);
        consumedLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        consumedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel bmrLabel = new JLabel("Your BMR: " + bmr + " calories/day", SwingConstants.CENTER);
        bmrLabel.setFont(new Font("Arial", Font.BOLD, 20));

        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(calorieProgressBar);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        centerPanel.add(consumedLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(bmrLabel);
        centerPanel.add(Box.createVerticalGlue());

        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        add(mainPanel);
    }

    private void addFood() {
        String[] foodOptions = foodDatabase.getFoodOptions();
        String selectedFood = (String) JOptionPane.showInputDialog(this, "Choose food:",
                "Add Food", JOptionPane.PLAIN_MESSAGE, null, foodOptions, foodOptions[0]);

        if (selectedFood != null) {
            Double calories = foodDatabase.getCalories(selectedFood);
            if (calories != null) {
                consumedCalories += calories;
                JOptionPane.showMessageDialog(this, selectedFood + " added! (" + calories + " calories)",
                        "Food Added", JOptionPane.INFORMATION_MESSAGE);
                updateCalorieDisplay();
            }
        }
    }

    private void addDrink() {
        String[] drinkOptions = foodDatabase.getDrinkOptions();
        String selectedDrink = (String) JOptionPane.showInputDialog(this, "Choose drink:",
                "Add Drink", JOptionPane.PLAIN_MESSAGE, null, drinkOptions, drinkOptions[0]);

        if (selectedDrink != null) {
            Double calories = foodDatabase.getCalories(selectedDrink);
            if (calories != null) {
                consumedCalories += calories;
                JOptionPane.showMessageDialog(this, selectedDrink + " added! (" + calories + " calories)",
                        "Drink Added", JOptionPane.INFORMATION_MESSAGE);
                updateCalorieDisplay();
            }
        }
    }

    private void updateCalorieDisplay() {
        calorieProgressBar.setValue((int) consumedCalories);
        calorieProgressBar.setString((int) consumedCalories + " / " + (int) bmr);
        consumedLabel.setText("Calories Consumed: " + (int) consumedCalories + " / " + (int) bmr);
    }
}
