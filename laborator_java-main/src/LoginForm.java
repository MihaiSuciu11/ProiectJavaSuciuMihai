import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm {
    ManagerCursuri cursuri;
    public LoginForm(JFrame owner, ManagerCursuri cursuri) {
        this.owner = owner;

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( e.getSource() == btnLogin) {
                    System.out.println("Am apasat butonul de login");
                    try {
                        Application.getInstance().login(new User(txtUsername.getText(), new String(txtPassword.getPassword())));
                        JOptionPane.showMessageDialog(null, "Login successfully!");
                        mainPanel.setVisible(false);
                        owner.setContentPane(new TeacherForm(cursuri).getPanel1());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        });

        btnLoginStud.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( e.getSource() == btnLoginStud) {
                    System.out.println("Am apasat butonul de login pentru studenti");
                    try {
                        Application.getInstance().login(new User(txtUsername.getText(), new String(txtPassword.getPassword())));
                        JOptionPane.showMessageDialog(null, "Login successfully!");
                        mainPanel.setVisible(false);
                        owner.setContentPane(new StudForm(cursuri).getPanel2());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private JPanel mainPanel;
    private JLabel lblUsername;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnLoginStud;
    private JFrame owner;
}
