import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

class LoginFrame extends JFrame {
    public LoginFrame() {
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel utama dengan gambar latar belakang
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("C:\\Users\\davaa\\Downloads\\images (3).jpg");
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label "Username"
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        usernameLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(usernameLabel, gbc);

        // TextField untuk "Username"
        JTextField usernameField = new JTextField(15);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 14));
        usernameField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                new EmptyBorder(5, 5, 5, 5)
        ));
        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(usernameField, gbc);

        // Label "Password"
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        passwordLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(passwordLabel, gbc);

        // PasswordField untuk "Password"
        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                new EmptyBorder(5, 5, 5, 5)
        ));
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(passwordField, gbc);

        // Tombol "Login"
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setBackground(new Color(34, 139, 34)); // Hijau
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setPreferredSize(new Dimension(100, 30));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(loginButton, gbc);

        // Event Listener untuk Login
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            char[] password = passwordField.getPassword();
            if (username.equals("admin") && new String(password).equals("admin")) {
                JOptionPane.showMessageDialog(this, "Login berhasil!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                new UserInputFrame().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid login credentials.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(mainPanel);
    }

    // UserInputFrame.java
    class UserInputFrame extends JFrame {
        public UserInputFrame() {
            setTitle("User Details");
            setSize(400, 250);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            panel.setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.fill = GridBagConstraints.HORIZONTAL;

            JLabel ageLabel = new JLabel("Age:");
            gbc.gridx = 0;
            gbc.gridy = 0;
            panel.add(ageLabel, gbc);

            JTextField ageField = new JTextField(15);
            gbc.gridx = 1;
            gbc.gridy = 0;
            panel.add(ageField, gbc);

            JLabel weightLabel = new JLabel("Weight (kg):");
            gbc.gridx = 0;
            gbc.gridy = 1;
            panel.add(weightLabel, gbc);

            JTextField weightField = new JTextField(15);
            gbc.gridx = 1;
            gbc.gridy = 1;
            panel.add(weightField, gbc);

            JLabel heightLabel = new JLabel("Height (cm):");
            gbc.gridx = 0;
            gbc.gridy = 2;
            panel.add(heightLabel, gbc);

            JTextField heightField = new JTextField(15);
            gbc.gridx = 1;
            gbc.gridy = 2;
            panel.add(heightField, gbc);

            JButton submitButton = new JButton("Submit");
            submitButton.setPreferredSize(new Dimension(100, 25));
            gbc.gridx = 1;
            gbc.gridy = 3;
            gbc.anchor = GridBagConstraints.EAST;
            panel.add(submitButton, gbc);

            submitButton.addActionListener(e -> {
                try {
                    int age = Integer.parseInt(ageField.getText());
                    double weight = Double.parseDouble(weightField.getText());
                    double height = Double.parseDouble(heightField.getText());

                    double bmr = 10 * weight + 6.25 * height - 5 * age + 5; // BMR formula for men (Harris-Benedict)
                    new DashboardFrame(bmr).setVisible(true);
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });

            add(panel);
        }
    }

    // DashboardFrame.java
    class DashboardFrame extends JFrame {
        private final double bmr;
        private double consumedCalories = 0; // Initial consumed calories

        private JProgressBar calorieProgressBar; // Instance variable untuk ProgressBar
        private JLabel consumedLabel; // Instance variable untuk label kalori

        public DashboardFrame(double bmr) {
            this.bmr = bmr;
            setTitle("Dashboard");
            setSize(800, 600);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            JPanel mainPanel = new JPanel(new BorderLayout());

            // Left Panel
            JPanel leftPanel = new JPanel();
            leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
            leftPanel.setPreferredSize(new Dimension(200, 600));

            JButton addFoodButton = new JButton("Add Food");
            JButton viewHistoryButton = new JButton("View History");
            JButton calculateCaloriesButton = new JButton("Calculate Calories");

            Dimension buttonSize = new Dimension(150, 40);
            addFoodButton.setMaximumSize(buttonSize);
            viewHistoryButton.setMaximumSize(buttonSize);
            calculateCaloriesButton.setMaximumSize(buttonSize);

            addFoodButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            viewHistoryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            calculateCaloriesButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            addFoodButton.setPreferredSize(buttonSize);
            viewHistoryButton.setPreferredSize(buttonSize);
            calculateCaloriesButton.setPreferredSize(buttonSize);

            addFoodButton.addActionListener(e -> {
                String input = JOptionPane.showInputDialog(this, "Enter calories consumed:", "Add Food", JOptionPane.PLAIN_MESSAGE);
                if (input != null) {
                    try {
                        double calories = Double.parseDouble(input);
                        consumedCalories += calories;
                        JOptionPane.showMessageDialog(this, "Calories added successfully!");
                        updateCalorieDisplay();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            viewHistoryButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "View History feature coming soon!"));
            calculateCaloriesButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Calculate Calories feature coming soon!"));

            leftPanel.add(Box.createVerticalGlue());
            leftPanel.add(addFoodButton);
            leftPanel.add(Box.createRigidArea(new Dimension(0, 20)));
            leftPanel.add(viewHistoryButton);
            leftPanel.add(Box.createRigidArea(new Dimension(0, 20)));
            leftPanel.add(calculateCaloriesButton);
            leftPanel.add(Box.createVerticalGlue());

            // Center Panel
            JPanel centerPanel = new JPanel();
            centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

            JLabel bmrLabel = new JLabel("Your BMR: " + bmr + " calories/day", SwingConstants.CENTER);
            bmrLabel.setFont(new Font("Arial", Font.BOLD, 20));

            calorieProgressBar = new JProgressBar(0, (int) bmr); // Inisialisasi ProgressBar
            calorieProgressBar.setValue((int) consumedCalories);
            calorieProgressBar.setStringPainted(true);

            consumedLabel = new JLabel("Calories Consumed: " + (int) consumedCalories + " / " + (int) bmr); // Inisialisasi Label
            consumedLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            consumedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

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

        private void updateCalorieDisplay() {
            // Update nilai ProgressBar dan Label
            calorieProgressBar.setValue((int) consumedCalories);
            calorieProgressBar.setString((int) consumedCalories + " / " + (int) bmr);
            consumedLabel.setText("Calories Consumed: " + (int) consumedCalories + " / " + (int) bmr);
        }
    }
}