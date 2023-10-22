package Routes;

import Controller.Client;
import GUI.*;

import javax.swing.*;
import java.awt.*;

public class Router {
    private Client client;
    private JFrame frame;

    // Define components for each page
    private LoginPanel loginPanel;
    private SignupPanel signupPanel;
    private HomePanel homePanel;
    private CartPanel cartPanel;
    private ProfilePanel profilePanel;
    private HistoryPanel historyPanel;

    public Router(Client client) {
        this.client = client;

        // Initialize the GUI components for each page
        loginPanel = new LoginPanel(client);
        signupPanel = new SignupPanel(client);
        homePanel = new HomePanel(client);
        cartPanel = new CartPanel(client);
        profilePanel = new ProfilePanel(client);
        historyPanel = new HistoryPanel(client);

        frame = new JFrame("Food Ordering App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 700);

        frame.getContentPane().setLayout(new CardLayout());

        frame.getContentPane().add(loginPanel, "login");
        frame.getContentPane().add(signupPanel, "signup");
        frame.getContentPane().add(homePanel, "home");
        frame.getContentPane().add(cartPanel, "cart");
        frame.getContentPane().add(profilePanel, "profile");
        frame.getContentPane().add(historyPanel, "history");

        showLoginPage();
        System.out.println("Router initialized");

        frame.setVisible(true);
    }

    // Methods to show each page
    public void showLoginPage() {
        CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
        cardLayout.show(frame.getContentPane(), "login");
    }

    public void showSignupPage() {
        CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
        cardLayout.show(frame.getContentPane(), "signup");
    }

    public void showHomePage() {
        CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
        cardLayout.show(frame.getContentPane(), "home");
    }

    public void showCartPage() {
        CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
        cardLayout.show(frame.getContentPane(), "cart");
        cartPanel.updateCartItems();
    }

    public void showHistoryPage() {
        CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
        cardLayout.show(frame.getContentPane(), "history");
        historyPanel.updateUI();
    }

    public void showProfilePage() {
        CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
        cardLayout.show(frame.getContentPane(), "profile");
    }

    // Methods to display messages
    public void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void displayInfoMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    // Getters for each page
    public HomePanel getHomePanel() {
        return homePanel;
    }
    public CartPanel getCartPanel() {
        return cartPanel;
    }
    public ProfilePanel getProfilePanel() {
        return profilePanel;
    }
    public HistoryPanel getHistoryPanel() {
        return historyPanel;
    }
}
