import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TeacherForm{
    ManagerCursuri cursuri;
    public TeacherForm(ManagerCursuri cursuri) {
        btnNotare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( e.getSource() == btnNotare){
                    System.out.println("Am apasat butonul de notare");
                    String numele_cursului = txtCurs.getText();
                    String numele_studentului = txtNumeStudent.getText();
                    String prenumele_studentului = txtPrenume.getText();
                    Integer nota_studentului = Integer.parseInt(txtNotareNoua.getText());
                    try {
                        cursuri.ModificaNota(numele_cursului, numele_studentului, prenumele_studentului, nota_studentului);
                        JOptionPane.showMessageDialog(null, "Nota studentului a fost modificata cu succes!");
                    }catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        });
        btnAfisare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( e.getSource() == btnAfisare) {
                    System.out.println("Am apasat butonul de afisare al cursurilor");
                    try {
                       // JOptionPane.showMessageDialog(null, "Se afiseaza cursurile:\n");
                        txtCursuriStudenti.setText(cursuri.reportAllStudentsGrades());
                    }catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        });
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( e.getSource() == btnReset) {
                    try {
                        txtCursuriStudenti.setText("");
                    }catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

    private JPanel panel1;
    private JButton btnAfisare;
    private JButton btnNotare;
    private JTextField txtNumeStudent;
    private JLabel lblNume;
    private JTextField txtNotareNoua;
    private JLabel lblNotaNoua;
    private JTextArea txtCursuriStudenti;
    private JTextField txtPrenume;
    private JLabel lblPrenume;
    private JTextField txtCurs;
    private JLabel lblCurs;
    private JButton btnReset;
}
