import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

public class ContactFrame extends JFrame implements ActionListener {

    private JPanel mainPanel, interPanel, buttonPanel;

    private static JTextArea contactTextArea;

    private Connection connection;

    public ContactFrame(String title, Connection connection) {
        super(title);
        this.connection = connection;
        initializeComponents();
        interPanel.setSize(350, 150);
        createButtonAdd();
        configureMainPanel();
        configureFrame();

        loadUsers(connection);
    }

    private void initializeComponents() {
        mainPanel = new JPanel(new BorderLayout());
        interPanel = new JPanel();
        contactTextArea = new JTextArea();
        buttonPanel = new JPanel();

        Font font = new Font("Arial", Font.PLAIN , 16);
        contactTextArea.setFont(font);
        contactTextArea.setSize(350,150);

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

    public static void loadUsers(Connection connection) {

        try {
            contactTextArea.setText("");
            ArrayList<User> users = UserData.getAllUsers(connection);

            users.forEach(u -> {
                StringBuilder stringUser = new StringBuilder();

                stringUser.append(u.getId()).append(" ").append(u.getFirstname()).append(" ").append(u.getLastname()).append(" ").append(u.getPhone()).append("\n");
                contactTextArea.append(stringUser.toString());
            });

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AddContactFrame addContactFrame = new AddContactFrame("Ajouter un contact", connection);

    }

}
