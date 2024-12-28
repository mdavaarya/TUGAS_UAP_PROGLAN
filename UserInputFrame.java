import javax.swing.*;
import java.awt.*;

class UserInputFrame extends JFrame {
    public UserInputFrame() {
        setTitle("User Details");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(245, 245, 245)); // Light gray background

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setFont(new Font("San Francisco", Font.PLAIN, 16)); // iPhone-like font
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(ageLabel, gbc);

        JTextField ageField = new JTextField(15);
        ageField.setFont(new Font("San Francisco", Font.PLAIN, 16));
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(ageField, gbc);

        JLabel weightLabel = new JLabel("Weight (kg):");
        weightLabel.setFont(new Font("San Francisco", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(weightLabel, gbc);

        JTextField weightField = new JTextField(15);
        weightField.setFont(new Font("San Francisco", Font.PLAIN, 16));
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(weightField, gbc);

        JLabel heightLabel = new JLabel("Height (cm):");
        heightLabel.setFont(new Font("San Francisco", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(heightLabel, gbc);

        JTextField heightField = new JTextField(15);
        heightField.setFont(new Font("San Francisco", Font.PLAIN, 16));
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(heightField, gbc);

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("San Francisco", Font.BOLD, 16));
        submitButton.setBackground(new Color(0, 122, 255)); // iOS blue button
        submitButton.setForeground(Color.WHITE);
        submitButton.setPreferredSize(new Dimension(120, 40));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(submitButton, gbc);

        submitButton.addActionListener(e -> {
            try {
                // Parse and validate age
                int age = Integer.parseInt(ageField.getText());
                if (age <= 0 || age > 120) {
                    throw new IllegalArgumentException("Age must be between 1 and 120.");
                }

                // Parse and validate weight
                double weight = Double.parseDouble(weightField.getText());
                if (weight <= 0 || weight > 300) {
                    throw new IllegalArgumentException("Weight must be between 1 and 300 kg.");
                }

                // Parse and validate height
                double height = Double.parseDouble(heightField.getText());
                if (height <= 0 || height > 250) {
                    throw new IllegalArgumentException("Height must be between 1 and 250 cm.");
                }

                // Calculate BMR
                double bmr = 10 * weight + 6.25 * height - 5 * age + 5; // BMR formula for men (Harris-Benedict)

                // Open the dashboard frame
                new DashboardFrame(bmr).setVisible(true);
                dispose();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numerical values.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Validation Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(panel);
    }
}
