import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

public class ContactFrame extends JFrame implements ActionListener {

    private JPanel mainPanel, interPanel, buttonPanel;

    private JTextArea contactTextArea;

    private Connection connection;

    public ContactFrame(String title, Connection connection) {
        super(title);

        this.connection = connection;

        initializeComponents();
        interPanel.setSize(350, 100);
        createButtonAdd();
        configureMainPanel();
        configureFrame();

        loadUsers();
    }

    private void initializeComponents() {
        mainPanel = new JPanel(new BorderLayout());
        interPanel = new JPanel();
        contactTextArea = new JTextArea();
        buttonPanel = new JPanel();

        Font font = new Font("Arial", Font.PLAIN , 48);
        contactTextArea.setFont(font);

        interPanel.add(contactTextArea);
    }

    private void createButtonAdd() {
        JButton btnAdd = new JButton("Ajouter");
        btnAdd.addActionListener(this);
        buttonPanel.add(btnAdd);
    }

    private void configureMainPanel() {
        mainPanel.add(interPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        setContentPane(mainPanel);
    }

    private void configureFrame() {
        setSize(350, 350);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void loadUsers() {

        try {
            ArrayList<User> users = User.getAllUsers(Connection connection);
        } catch () {

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new AddContactFrame("Ajouter un contact");
    }
}
