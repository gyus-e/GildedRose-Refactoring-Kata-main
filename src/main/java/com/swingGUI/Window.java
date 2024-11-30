package com.swingGUI;

import com.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class Window {
    private static JFrame mainFrame;
    private static JPanel mainPanel;
    private static JPanel inventoryPanel;
    private static JPanel buttonPanel;
    private static JScrollPane inventoryScrollPane;
    private static JList<String> inventoryDisplayList;

    public static void main(String[] args) {
        Controller.initializeInventory();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Window().createAndShowGui();
            }
        });
    }

    public void createAndShowGui() {
        mainFrame = new JFrame();
        mainFrame.setTitle("Gilded Rose");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 600);
        mainFrame.setLocationRelativeTo(null);

        mainPanel = new JPanel();
        inventoryPanel = getInventoryPanel();
        buttonPanel = getButtonPanel();

        mainPanel.setLayout(new GridLayout(2, 1));
        mainPanel.add(inventoryPanel);
        mainPanel.add(buttonPanel);

        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }

    private JPanel getInventoryPanel() {
        JPanel inventoryPanel = new JPanel();
        inventoryPanel.setLayout(new BoxLayout(inventoryPanel, BoxLayout.Y_AXIS));

        inventoryDisplayList = new JList<String>(Controller.getInventoryStringList().toArray(new String[0]));
        inventoryScrollPane = new JScrollPane(inventoryDisplayList);

        inventoryPanel.add(inventoryScrollPane);
        return inventoryPanel;
    }

    private JPanel getButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        buttonPanel.add(getUpdateButton());
        return buttonPanel;
    }

    private JButton getUpdateButton() {
        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(e -> {
            Controller.updateQuality();
            inventoryDisplayList.setListData(Controller.getInventoryStringList().toArray(new String[0]));
        });
        return updateButton;
    }
}
