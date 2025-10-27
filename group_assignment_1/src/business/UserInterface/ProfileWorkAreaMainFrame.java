package business.UserInterface;

import business.Business;
import business.UserInterface.ConfigureABusiness;
import business.Profiles.EmployeeProfile;
import business.Profiles.StudentProfile;
import business.UserAccounts.UserAccount;
import business.UserAccounts.UserAccountDirectory;
import UserInterface.WorkAreas.AdminRole.AdminRoleWorkAreaJPanel;
import UserInterface.WorkAreas.FacultyRole.FacultyWorkAreaJPanel;
import UserInterface.WorkAreas.StudentRole.StudentWorkAreaJPanel;

import javax.swing.*;
import java.awt.*;

/**
*
*author@krishi
*/
public class ProfileWorkAreaMainFrame extends javax.swing.JFrame {

    private Business business;
    private JSplitPane splitPane;
    private JPanel loginPanel, rightPanel;
    private JLabel userLabel, passLabel, welcomeLabel, titleLabel;
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;

    public ProfileWorkAreaMainFrame() {
        initComponents();
        business = ConfigureABusiness.initialize();
        setTitle("Digital University Portal");
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
        splitPane = new JSplitPane();
        loginPanel = new JPanel();
        rightPanel = new JPanel();
        userLabel = new JLabel("Username:");
        passLabel = new JLabel("Password:");
        userField = new JTextField(14);
        passField = new JPasswordField(14);
        loginButton = new JButton("Login");
        welcomeLabel = new JLabel("Welcome to Digital University", SwingConstants.CENTER);
        titleLabel = new JLabel("Digital University", SwingConstants.CENTER);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1100, 650);
        setLayout(new BorderLayout());

        // === Theme Colors ===
        Color darkTeal = new Color(0, 77, 77);
        Color mediumTeal = new Color(0, 128, 128);
        Color accentTeal = new Color(0, 153, 153);
        Color lightPanel = new Color(245, 250, 250);
        Color textLight = Color.WHITE;

        Font labelFont = new Font("Segoe UI", Font.PLAIN, 15);
        Font buttonFont = new Font("Segoe UI Semibold", Font.BOLD, 16);
        Font headerFont = new Font("Segoe UI", Font.BOLD, 22);
        Font titleFont = new Font("Segoe UI Semibold", Font.BOLD, 26);

        // === Left Panel (Login Side) ===
        loginPanel.setLayout(new GridBagLayout());
        loginPanel.setBackground(darkTeal);
        loginPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));

        // Title Label
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        // Labels
        userLabel.setFont(labelFont);
        userLabel.setForeground(textLight);
        passLabel.setFont(labelFont);
        passLabel.setForeground(textLight);

        // Input Fields
        userField.setFont(labelFont);
        userField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(accentTeal, 1),
                BorderFactory.createEmptyBorder(8, 8, 8, 8)
        ));
        passField.setFont(labelFont);
        passField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(accentTeal, 1),
                BorderFactory.createEmptyBorder(8, 8, 8, 8)
        ));

        // Login Button
        loginButton.setFont(buttonFont);
        loginButton.setBackground(mediumTeal);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        loginButton.setPreferredSize(new Dimension(180, 40));
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginButton.setBackground(accentTeal);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginButton.setBackground(mediumTeal);
            }
        });

        // Layout Constraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 10, 12, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;

        gbc.gridy = 0;
        loginPanel.add(titleLabel, gbc);
        gbc.gridy++;
        loginPanel.add(userLabel, gbc);
        gbc.gridy++;
        loginPanel.add(userField, gbc);
        gbc.gridy++;
        loginPanel.add(passLabel, gbc);
        gbc.gridy++;
        loginPanel.add(passField, gbc);
        gbc.gridy++;
        loginPanel.add(loginButton, gbc);

        // === Right Panel (Welcome Side) ===
        rightPanel.setLayout(new BorderLayout());
        rightPanel.setBackground(lightPanel);

        welcomeLabel.setFont(headerFont);
        welcomeLabel.setForeground(mediumTeal);
        rightPanel.add(welcomeLabel, BorderLayout.CENTER);

        // === SplitPane Setup ===
        splitPane.setDividerLocation(350);
        splitPane.setDividerSize(3);
        splitPane.setLeftComponent(loginPanel);
        splitPane.setRightComponent(rightPanel);
        add(splitPane, BorderLayout.CENTER);

        // === Button Action ===
        loginButton.addActionListener(e -> handleLogin());
    }

    private void handleLogin() {
        String username = userField.getText().trim();
        String password = new String(passField.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both username and password.");
            return;
        }

        UserAccountDirectory uad = business.getUserAccountDirectory();
        UserAccount ua = uad.authenticateUser(username, password);
        if (ua == null) {
            JOptionPane.showMessageDialog(this, "Invalid credentials. Try again!");
            return;
        }

        // Switch to appropriate Work Area Panel
        rightPanel.removeAll();
        JPanel nextPanel;

        if (ua.getAssociatedPersonProfile() instanceof EmployeeProfile) {
            nextPanel = new AdminRoleWorkAreaJPanel(business, rightPanel);
        } else if (ua.getAssociatedPersonProfile() instanceof StudentProfile) {
            nextPanel = new StudentWorkAreaJPanel(
                    business,
                    (StudentProfile) ua.getAssociatedPersonProfile(),
                    rightPanel
            );
        } else {
            nextPanel = new FacultyWorkAreaJPanel(business, rightPanel);
        }

        rightPanel.add(nextPanel, BorderLayout.CENTER);
        rightPanel.revalidate();
        rightPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProfileWorkAreaMainFrame frame = new ProfileWorkAreaMainFrame();
            frame.setVisible(true);
        });
    }
}
