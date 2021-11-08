package com.ist412.wallyland_vacation_planner;

import com.ist412.wallyland_vacation_planner.control.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Main View for WallyLand Vacation Planner
 * 
 * @author Jason C. Nucciarone, Madison Schmitt
 * @version 1.0
 * @since 2021-11-7
 */
public class RootView extends JFrame {
    private final String START_PAGE = "START PAGE";
    private final String LOGIN_PAGE = "LOGIN PAGE";
    private final String CREATE_ACCOUNT_PAGE = "CREATE ACCOUNT PAGE";
    private final CardLayout cLayout;
    private final JPanel mainPane;
    
    public RootView() {
        this.setTitle("WallyLand Vacation Planner");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(600, 800);
        mainPane = new JPanel();
        cLayout = new CardLayout();
        mainPane.setLayout(cLayout);
        
        // Load in active users
        StartEndController.getInstance().loadAccounts();
        
        // Add start page components
        JPanel startPage = new JPanel();
        startPage.setLayout(new BorderLayout());
        JPanel startTitlePanel = new JPanel();
        startTitlePanel.add(new JLabel("Welcome to WallyLand Vacation Planner!"));
        startPage.add(startTitlePanel, BorderLayout.NORTH);
        JPanel startButtonPanel = new JPanel();
        JButton startLoginButton = new JButton("Log In");
        JButton startSignUpButton = new JButton("Sign Up");
        
        //// Define button action listeners
        startLoginButton.addActionListener((ActionEvent e) -> {
            RootController.getInstance().swapPage(cLayout, mainPane, LOGIN_PAGE);
        });
        startSignUpButton.addActionListener((ActionEvent e) -> {
            RootController.getInstance().swapPage(cLayout, mainPane, CREATE_ACCOUNT_PAGE);
        });
        
        startButtonPanel.add(startLoginButton);
        startButtonPanel.add(startSignUpButton);
        startPage.add(startButtonPanel, BorderLayout.CENTER);
        mainPane.add(START_PAGE, startPage);
        
        // Add login page components
        JPanel loginPage = new JPanel();
        loginPage.setLayout(new BorderLayout());
        JPanel loginTitlePanel = new JPanel();
        loginTitlePanel.add(new JLabel("Log into your account"));
        loginPage.add(loginTitlePanel, BorderLayout.NORTH);
        
        JPanel loginInputPanel = new JPanel();
        GridLayout loginInputGrid = new GridLayout(3, 1, 10, 10);
        loginInputPanel.setLayout(loginInputGrid);
        JPanel loginEmail = new JPanel();
        loginEmail.add(new JLabel("Enter your email: "));
        JTextField loginEmailText = new JTextField(50);
        loginEmail.add(loginEmailText);
        JPanel loginPassword = new JPanel();
        loginPassword.add(new JLabel("Enter your password: "));
        JTextField loginPasswordText = new JTextField(50);
        loginPassword.add(loginPasswordText);
        JPanel loginStatus = new JPanel();
        JLabel loginStatusLabel = new JLabel();
        loginStatusLabel.setVisible(false);
        loginStatus.add(loginStatusLabel);
        loginInputPanel.add(loginEmail);
        loginInputPanel.add(loginPassword);
        loginInputPanel.add(loginStatus);
        loginPage.add(loginInputPanel, BorderLayout.CENTER);
        
        JPanel loginButtonPanel = new JPanel();
        JButton loginButton = new JButton("Log In");
        
        //// Add login action listener
        loginButton.addActionListener((ActionEvent e) -> {
            LoginController.getInstance().login(
                    loginEmailText.getText(), 
                    loginPasswordText.getText(), 
                    loginStatusLabel);
        });
        
        loginButtonPanel.add(loginButton);
        loginPage.add(loginButtonPanel, BorderLayout.SOUTH);
        mainPane.add(LOGIN_PAGE, loginPage);
        
        // Add create account page components
        JPanel createAccountPage = new JPanel();
        BoxLayout createAccountBoxLayout = new BoxLayout(createAccountPage, BoxLayout.Y_AXIS);
        createAccountPage.setLayout(createAccountBoxLayout);
        JPanel createAccountTitle = new JPanel();
        createAccountTitle.add(new JLabel("Create a new account."));
        JPanel enterFirstName = new JPanel();
        enterFirstName.add(new JLabel("Enter your first name: "));
        JTextField firstName = new JTextField(30);
        enterFirstName.add(firstName);
        
        JPanel enterLastName = new JPanel();
        enterLastName.add(new JLabel("Enter your last name: "));
        JTextField lastName = new JTextField(30);
        enterLastName.add(lastName);
        
        JPanel enterEmail = new JPanel();
        enterEmail.add(new JLabel("Enter your email: "));
        JTextField email = new JTextField(30);
        enterEmail.add(email);
        
        JPanel enterUserName = new JPanel();
        enterUserName.add(new JLabel("Create a user name: "));
        JTextField userName = new JTextField(30);
        enterUserName.add(userName);
        
        JPanel selectAccountType = new JPanel();
        selectAccountType.add(new JLabel("Select account type: "));
        DefaultComboBoxModel accountTypes = new DefaultComboBoxModel();
        accountTypes.addElement("personal");
        accountTypes.addElement("family");
        accountTypes.addElement("corporate");
        JComboBox accountSelect = new JComboBox(accountTypes);
        accountSelect.setSelectedIndex(0);
        selectAccountType.add(accountSelect);
        
        JPanel createPasswordPanel = new JPanel();
        createPasswordPanel.add(new JLabel("Account Password: "));
        JTextField createPasswordText = new JTextField(30);
        createPasswordPanel.add(createPasswordText);
        
        JPanel submitButtonPanel = new JPanel();
        JButton submitButton = new JButton("Create Account");
        submitButton.addActionListener((ActionEvent e) -> {
            SignUpController.getInstance().createAccount(
                firstName.getText(), 
                lastName.getText(),
                email.getText(),
                userName.getText(),
                createPasswordText.getText(),
                (String) accountSelect.getSelectedItem());
            RootController.getInstance().swapPage(cLayout, mainPane, START_PAGE);
        });
        submitButtonPanel.add(submitButton);
        
        createAccountPage.add(createAccountTitle);
        createAccountPage.add(enterFirstName);
        createAccountPage.add(enterLastName);
        createAccountPage.add(enterEmail);
        createAccountPage.add(enterUserName);
        createAccountPage.add(selectAccountType);
        createAccountPage.add(createPasswordPanel);
        createAccountPage.add(submitButtonPanel);
        mainPane.add(CREATE_ACCOUNT_PAGE, createAccountPage);
        
        // Add plan trip components
        
        // Window close operation
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                StartEndController.getInstance().saveAccounts();
                System.exit(0);
            }
        });
        
        this.add(mainPane, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
