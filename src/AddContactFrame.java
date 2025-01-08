import javax.swing.*;
import java.awt.*;

public class AddContactFrame extends JFrame {

    private JPanel mainPanel, interPanel, buttonPanel;

    public AddContactFrame(String title) {
        super(title);
        initializeComponents();
        interPanel.setSize(350, 100);
        configureInterPanel();
        createButtonAdd();
        configureMainPanel();
        configureFrame();
    }

    private void initializeComponents() {
        mainPanel = new JPanel(new BorderLayout());
        interPanel = new JPanel(new GridLayout(4,2));
        buttonPanel = new JPanel();
    }

    private void createButtonAdd() {
        JButton btnAdd = new JButton("Valider");

        buttonPanel.add(btnAdd);
    }

    private void configureMainPanel() {
        mainPanel.add(interPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        setContentPane(mainPanel);
    }

    private void configureInterPanel() {
        JTextField tfFirstname = new JTextField();
        JTextField tfLastname = new JTextField();
        JTextField tfPhone = new JTextField();

        interPanel.add(new JLabel("Nom : "));
        interPanel.add(tfLastname);

        interPanel.add(new JLabel("Prénom : "));
        interPanel.add(tfFirstname);

        interPanel.add(new JLabel("Téléphone : "));
        interPanel.add(tfPhone);
    }

    public void configureFrame() {
        setSize(350, 350);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

}
