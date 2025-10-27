package business.UserInterface.WorkAreas.AdminRole;

import business.Business;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * 
 * author@krishi
 */
public class AdminRoleWorkAreaJPanel extends JPanel {

    private Business business;
    private JPanel rightPanel;

    private JButton btnMyProfile, btnAdminUsers, btnManageFaculty, btnManageStudents, btnRegisterPersons;
    private JLabel titleLabel;

    public AdminRoleWorkAreaJPanel(Business business, JPanel rightPanel) {
        this.business = business;
        this.rightPanel = rightPanel;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // --- Header ---
        titleLabel = new JLabel("Admin Control Center", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
        titleLabel.setForeground(new Color(0, 70, 140));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(25, 0, 25, 0));
        add(titleLabel, BorderLayout.NORTH);

        // --- Center content ---
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 15, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // --- Buttons (teal theme) ---
        btnMyProfile = createStyledButton("My Profile", e -> handleClick("profile"));
        btnAdminUsers = createStyledButton("Manage User Accounts", e -> handleClick("users"));
        btnManageFaculty = createStyledButton("Manage Faculty", e -> handleClick("faculty"));
        btnManageStudents = createStyledButton("Manage Students", e -> handleClick("students"));
        btnRegisterPersons = createStyledButton("Register Persons (HR)", e -> handleClick("register"));

        gbc.gridx = 0;
        gbc.gridy = 0; centerPanel.add(btnMyProfile, gbc);
        gbc.gridy++; centerPanel.add(btnAdminUsers, gbc);
        gbc.gridy++; centerPanel.add(btnManageFaculty, gbc);
        gbc.gridy++; centerPanel.add(btnManageStudents, gbc);
        gbc.gridy++; centerPanel.add(btnRegisterPersons, gbc);

        add(centerPanel, BorderLayout.CENTER);
    }

    private JButton createStyledButton(String text, ActionListener action) {
        Color teal = new Color(0, 102, 102);
        Color tealHover = new Color(0, 130, 130);

        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 15));
        button.setForeground(Color.WHITE);
        button.setBackground(teal);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(260, 45));
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 90, 90), 2),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(tealHover);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(teal);
            }
        });

        button.addActionListener(action);
        return button;
    }

    private void handleClick(String section) {
        JOptionPane.showMessageDialog(this,
                "Opening " + section.toUpperCase() + " section (coming soon)",
                "Navigation", JOptionPane.INFORMATION_MESSAGE);
    }
}
