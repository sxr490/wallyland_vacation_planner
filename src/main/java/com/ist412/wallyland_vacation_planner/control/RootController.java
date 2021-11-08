package com.ist412.wallyland_vacation_planner.control;

import java.awt.*;
import javax.swing.*;

/**
 * Root Controller for the RootView
 * 
 * @author Jason C. Nucciarone
 * @version 1.0
 * @since 2021-11-7
 */
public class RootController {
    private static RootController controllerInstance = null;
    
    private RootController() {}
    
    public static RootController getInstance() {
        if (controllerInstance == null) {
            controllerInstance = new RootController();
        }
        
        return controllerInstance;
    }
    
    public void swapPage(CardLayout layout, JPanel main, String pageName) {
        layout.show(main, pageName);
    }
}
