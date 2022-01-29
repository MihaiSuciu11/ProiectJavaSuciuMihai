import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudForm {
    ManagerCursuri cursuri;
    public StudForm(ManagerCursuri cursuri){
        btnCursuri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( e.getSource() == btnCursuri) {
                    System.out.println("Am apasat butonul de afisare al cursurilor");
                    String numele_studentului = txtNume.getText();
                    String prenume_student = txtPrenume.getText();
                    try {
                        System.out.println("Se afiseaza cursurile.");
                        txtCursuri.setText(cursuri.AfiseazaCursStudent(numele_studentului, prenume_student));
                    }catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        });
        btnMedie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numele_studentului = txtNume.getText();
                String prenume_student = txtPrenume.getText();
                try {
                    System.out.println("Se afiseaza media.");
                    txtMedia.setText(cursuri.MediaStudentuluiPeAn(numele_studentului, prenume_student));
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        btnRest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numele_studentului = txtNume.getText();
                String prenume_student = txtPrenume.getText();
                try {
                    System.out.println("Se afiseaza media.");
                    txtRest.setText(cursuri.AfisareRestanta(numele_studentului, prenume_student));
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }


    public JPanel getPanel2() {
        return panel2;
    }

    private JPanel panel2;
    private JButton btnCursuri;
    private JTextArea txtCursuri;
    private JButton btnMedie;
    private JTextField txtMedia;
    private JButton btnRest;
    private JTextField txtRest;
    private JLabel lblNume;
    private JLabel lblPre;
    private JTextField txtNume;
    private JTextField txtPrenume;
}
