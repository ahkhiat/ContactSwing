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
            String firstname = tfFirstname.getText();
            String lastname = tfLastname.getText();
            String phone = tfPhone.getText();

            if (!firstname.isEmpty() && !lastname.isEmpty() && !phone.isEmpty()) {
                if (phone.matches("^[+]?[0-9]*$")) {

                    User user = new User();
                    user.setFirstname(firstname);
                    user.setLastname(lastname);
                    user.setPhone(phone);

                    UserData.addUser(connection, user);

                    ContactFrame.loadUsers(connection);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Veuillez rentrer un numéro valide");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }


}
