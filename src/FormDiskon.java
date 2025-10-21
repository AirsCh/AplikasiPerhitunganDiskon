import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FormDiskon extends javax.swing.JFrame {

    public FormDiskon() {
        initComponents();

        // Inisialisasi pilihan diskon
        cmbDiskon.removeAllItems();
        cmbDiskon.addItem("5%");
        cmbDiskon.addItem("10%");
        cmbDiskon.addItem("15%");
        cmbDiskon.addItem("20%");
        cmbDiskon.addItem("25%");

        // Pengaturan slider
        sldDiskon.setMinimum(0);
        sldDiskon.setMaximum(50);
        sldDiskon.setMajorTickSpacing(10);
        sldDiskon.setMinorTickSpacing(5);
        sldDiskon.setPaintLabels(true);
        sldDiskon.setPaintTicks(true);

        // Nonaktifkan edit manual hasil
        txtHasil.setEditable(false);
        txtHemat.setEditable(false);

        // Tambahkan event
        tambahEvent();
    }

    private void tambahEvent() {

        // Tombol Hitung
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hitungDiskon();
            }
        });

        // Tombol Hapus
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtHarga.setText("");
                txtKupon.setText("");
                txtHasil.setText("");
                txtHemat.setText("");
            }
        });

        // Sinkronisasi Slider -> ComboBox
        sldDiskon.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = sldDiskon.getValue();
                cmbDiskon.setSelectedItem(value + "%");
            }
        });

        // Sinkronisasi ComboBox -> Slider
        cmbDiskon.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selected = e.getItem().toString().replace("%", "");
                    try {
                        sldDiskon.setValue(Integer.parseInt(selected));
                    } catch (NumberFormatException ex) {
                        // abaikan jika error format
                    }
                }
            }
        });
    }

    private void hitungDiskon() {
        try {
            double hargaAsli = Double.parseDouble(txtHarga.getText());
            int diskonPersen = Integer.parseInt(cmbDiskon.getSelectedItem().toString().replace("%", ""));
            double tambahan = 0;

            // Cek kode kupon tambahan
            String kode = txtKupon.getText().trim();
            if (kode.equalsIgnoreCase("HEMAT10")) {
                tambahan = 10;
            } else if (kode.equalsIgnoreCase("DISKON5")) {
                tambahan = 5;
            }

            int totalDiskon = diskonPersen + (int) tambahan;
            if (totalDiskon > 50) totalDiskon = 50; // batas maksimal diskon 50%

            double jumlahDiskon = hargaAsli * totalDiskon / 100;
            double hargaAkhir = hargaAsli - jumlahDiskon;

            txtHasil.setText(String.format("Rp %.2f", hargaAkhir));
            txtHemat.setText(String.format("Rp %.2f", jumlahDiskon));

            // Tambahkan ke riwayat
            txtRiwayat.append("Harga: Rp " + hargaAsli +
                              " | Diskon: " + totalDiskon + "%" +
                              " | Akhir: Rp " + hargaAkhir + "\n");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Masukkan angka yang valid untuk harga!", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUtama = new javax.swing.JPanel();
        lblJudul = new javax.swing.JLabel();
        lblHarga = new javax.swing.JLabel();
        lblDiskon = new javax.swing.JLabel();
        lblKupon = new javax.swing.JLabel();
        lblHasil = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        txtKupon = new javax.swing.JTextField();
        txtHasil = new javax.swing.JTextField();
        txtHemat = new javax.swing.JTextField();
        cmbDiskon = new javax.swing.JComboBox<>();
        scrollRiwayat = new javax.swing.JScrollPane();
        txtRiwayat = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        sldDiskon = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelUtama.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblJudul.setText("APLIKASI PERHITUNGAN DISKON");

        lblHarga.setText("Harga Asli");

        lblDiskon.setText("Diskon (%)");

        lblKupon.setText("Kode Kupon");

        lblHasil.setText("Harga Akhir");

        jLabel6.setText("Total Penghematan");

        cmbDiskon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtRiwayat.setColumns(20);
        txtRiwayat.setRows(5);
        scrollRiwayat.setViewportView(txtRiwayat);

        jButton1.setText("Hitung");

        jButton2.setText("Hapus");

        javax.swing.GroupLayout panelUtamaLayout = new javax.swing.GroupLayout(panelUtama);
        panelUtama.setLayout(panelUtamaLayout);
        panelUtamaLayout.setHorizontalGroup(
            panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUtamaLayout.createSequentialGroup()
                .addComponent(lblJudul)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelUtamaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollRiwayat)
                    .addGroup(panelUtamaLayout.createSequentialGroup()
                        .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelUtamaLayout.createSequentialGroup()
                                .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblHasil)
                                    .addComponent(lblKupon)
                                    .addComponent(lblHarga)
                                    .addComponent(lblDiskon))
                                .addGap(50, 50, 50)
                                .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelUtamaLayout.createSequentialGroup()
                                        .addComponent(cmbDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(sldDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtHarga)
                                    .addComponent(txtKupon)
                                    .addComponent(txtHasil)))
                            .addGroup(panelUtamaLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(txtHemat))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUtamaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(128, 128, 128))
        );
        panelUtamaLayout.setVerticalGroup(
            panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUtamaLayout.createSequentialGroup()
                .addComponent(lblJudul)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHarga)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiskon)
                    .addComponent(cmbDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sldDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKupon)
                    .addComponent(txtKupon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHasil)
                    .addComponent(txtHasil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtHemat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollRiwayat, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormDiskon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDiskon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDiskon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDiskon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDiskon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbDiskon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblDiskon;
    private javax.swing.JLabel lblHarga;
    private javax.swing.JLabel lblHasil;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblKupon;
    private javax.swing.JPanel panelUtama;
    private javax.swing.JScrollPane scrollRiwayat;
    private javax.swing.JSlider sldDiskon;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtHasil;
    private javax.swing.JTextField txtHemat;
    private javax.swing.JTextField txtKupon;
    private javax.swing.JTextArea txtRiwayat;
    // End of variables declaration//GEN-END:variables
}
