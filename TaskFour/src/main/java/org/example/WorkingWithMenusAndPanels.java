package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class WorkingWithMenusAndPanels {
    JMenuBar MenuBar;
    JFrame frame;
    JPanel mainPanel;
    CardLayout cardLayout;

    // Panels
    JPanel homePanel;
    JPanel dashboardPanel;
    JPanel settingsPanel;

    public WorkingWithMenusAndPanels() {
        CreateUI();
    }

    public JFrame CreateUI() {
        // Frame setup
        frame = new JFrame("Multi-Panel Menu Application");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // CardLayout for switching panels
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        //  CREATE PANELS FIRST
        homePanel = createHomePanel();
        dashboardPanel = createDashboardPanel();
        settingsPanel = createSettingsPanel();

        // THEN ADD THEM
        mainPanel.add(Objects.requireNonNull(homePanel), "Home");
        mainPanel.add(Objects.requireNonNull(dashboardPanel), "Dashboard");
        mainPanel.add(Objects.requireNonNull(settingsPanel), "Settings");

        // Create Menu
            MenuBar = new JMenuBar();
            JMenu menu = new JMenu("Navigate");

            JMenuItem homeItem = new JMenuItem("Home");
            JMenuItem dashboardItem = new JMenuItem("Dashboard");
            JMenuItem settingsItem = new JMenuItem("Settings");
            JMenuItem exitItem = new JMenuItem("Exit");


        // Add actions
        homeItem.addActionListener(e -> cardLayout.show(mainPanel, "Home"));
        dashboardItem.addActionListener(e -> cardLayout.show(mainPanel, "Dashboard"));
        settingsItem.addActionListener(e -> cardLayout.show(mainPanel, "Settings"));
        exitItem.addActionListener(e -> System.exit(0));

        // Add items to menu
        menu.add(homeItem);
        menu.add(dashboardItem);
        menu.add(settingsItem);
        menu.addSeparator();
        menu.add(exitItem);

        MenuBar.add(menu);

        // Set menu bar
        frame.setJMenuBar(MenuBar);

        // Add main panel to frame
        frame.add(mainPanel);

        frame.setVisible(true);
        return frame;
    }

    // Home Panel
    public JPanel createHomePanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Welcome to Home Panel", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));

        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    // Dashboard Panel
    public JPanel createDashboardPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.PINK);
        panel.setLayout(new GridLayout(2, 2, 10, 10));

        panel.add(new JButton("Report 1"));
        panel.add(new JButton("Report 2"));
        panel.add(new JButton("Report 3"));
        panel.add(new JButton("Report 4"));
        return panel;
    }

    // Settings Panel
    public JPanel createSettingsPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new FlowLayout());

        panel.add(new JLabel("Settings"));
        panel.add(new JCheckBox("Enable Notifications"));
        panel.add(new JCheckBox("Dark Mode"));
        panel.add(new JButton("Save"));
        return panel;
    }
}