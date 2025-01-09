import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class AddContactFrame extends JFrame implements ActionListener {

    private JPanel mainPanel, interPanel, buttonPanel;
    private JTextField tfFirstname, tfLastname, tfPhone;

    private Connection connection;

    public AddContactFrame(String title, Connection connection) {
        super(title);
        this.connection = connection;
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
        btnAdd.addActionListener(this);
        buttonPanel.add(btnAdd);
    }

    private void configureMainPanel() {
        mainPanel.add(interPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        setContentPane(mainPanel);
    }

    private void configureInterPanel() {
        tfFirstname = new JTextField();
        tfLastname = new JTextField();
        tfPhone = new JTextField();

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

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            User user = new User();
            user.setFirstname(tfFirstname.getText());
            user.setLastname(tfLastname.getText());
            user.setPhone(tfPhone.getText());
            User.addUser(connection, user);

            ContactFrame.loadUsers(connection);

            dispose();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }


}
