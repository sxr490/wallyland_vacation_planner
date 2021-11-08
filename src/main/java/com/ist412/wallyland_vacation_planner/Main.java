package com.ist412.wallyland_vacation_planner;

import javax.swing.SwingUtilities;

/**
 * Main class that serves as entry point for RootView.
 * 
 * @author Jason C. Nucciarone
 * @version 1.0
 * @since 2021-11-7
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                launchGUI();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    
    public static void launchGUI() {
        new RootView();
    }
}
