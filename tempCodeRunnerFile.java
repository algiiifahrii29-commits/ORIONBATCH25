import javax.swing.*;
import java.awt.event.*;

// Superclass
class Kalkulator {

    // Method Overloading
    int hitung(int a, int b) {
        return a + b;
    }

    int hitung(int a, int b, int c) {
        return a + b + c;
    }

    public String tampil() {
        return "Ini adalah Kalkulator Dasar";
    }
}

// Subclass (Method Overriding)
class KalkulatorLanjut extends Kalkulator {

    @Override
    public String tampil() {
        return "Ini adalah Kalkulator Lanjutan (Override)";
    }
}

// GUI
public class FormKalkulator extends JFrame {

    JTextField txtAngka1 = new JTextField();
    JTextField txtAngka2 = new JTextField();
    JTextField txtAngka3 = new JTextField();
    JButton btnHitung2 = new JButton("Hitung 2 Angka");
    JButton btnHitung3 = new JButton("Hitung 3 Angka");
    JLabel lblHasil = new JLabel("Hasil : ");

    Kalkulator kalkulator = new Kalkulator();
    KalkulatorLanjut lanjut = new KalkulatorLanjut();

    public FormKalkulator() {

        setTitle("Aplikasi Polymorphism Java");
        setSize(300,250);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        txtAngka1.setBounds(50,20,200,25);
        txtAngka2.setBounds(50,50,200,25);
        txtAngka3.setBounds(50,80,200,25);

        btnHitung2.setBounds(50,120,200,25);
        btnHitung3.setBounds(50,150,200,25);

        lblHasil.setBounds(50,180,200,25);

        add(txtAngka1);
        add(txtAngka2);
        add(txtAngka3);
        add(btnHitung2);
        add(btnHitung3);
        add(lblHasil);

        // Event Hitung 2 angka
        btnHitung2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int a = Integer.parseInt(txtAngka1.getText());
                int b = Integer.parseInt(txtAngka2.getText());

                int hasil = kalkulator.hitung(a,b);

                lblHasil.setText("Hasil : " + hasil);
            }
        });

        // Event Hitung 3 angka
        btnHitung3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int a = Integer.parseInt(txtAngka1.getText());
                int b = Integer.parseInt(txtAngka2.getText());
                int c = Integer.parseInt(txtAngka3.getText());

                int hasil = kalkulator.hitung(a,b,c);

                lblHasil.setText("Hasil : " + hasil);
            }
        });

        // Contoh overriding
        System.out.println(lanjut.tampil());
    }

    public static void main(String[] args) {
        new FormKalkulator().setVisible(true);
    }
}