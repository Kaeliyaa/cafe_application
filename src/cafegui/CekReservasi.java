/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cafegui;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author User
 */

public class CekReservasi extends javax.swing.JFrame {
        String user = "root";
        String pswd = "";
        String host = "localhost";
        String db = "cafe";
        String url = "";
        String StrSQL;
        private Connection Lconnection = null;
        
    public CekReservasi() {
        initComponents();
        tampilTabelReservasiInfo();
        btnSelesaiRsv.setEnabled(false);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            url="jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pswd;
            Lconnection = DriverManager.getConnection(url);
        }
        catch (ClassNotFoundException e){
            System.out.println("jdbc.Driver tidak ditemukan");
        }
        catch (SQLException e){
            System.out.println("Koneksi gagal" + e.toString());
        }
        
        
    }

    private Object[][] getReservasiInfo(){
        Object[][] dataReservasiInfo = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            url="jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pswd;
            Connection conn = DriverManager.getConnection(url);
            
            Statement st = conn.createStatement();
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM cek_reservasi", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = pst.executeQuery();
            rs.last();
            int rowCount = rs.getRow();
            rs.beforeFirst();
            
            dataReservasiInfo = new Object[rowCount][6];
            int no = -1;
            
            while(rs.next()){
                no = no + 1;
                dataReservasiInfo[no][0] = rs.getString("ID_Reservasi");
                dataReservasiInfo[no][1] = rs.getString("Nama_Cust");
                dataReservasiInfo[no][2] = rs.getString("No_Telp");
                dataReservasiInfo[no][3] = rs.getString("Jenis_Meja");
                dataReservasiInfo[no][4] = rs.getString("No_Meja");
                dataReservasiInfo[no][5] = rs.getString("Catatan");
                
            }
            st.close();
            conn.close();
        }
        catch (SQLException e){
            System.out.println("Koneksi gagal" + e.toString());
        }
        catch (ClassNotFoundException e){
        System.out.println("jdbc.Driver tidak ditemukan");
        }
        
        return dataReservasiInfo;
    }
    
    private void tampilTabelReservasiInfo(){
        String[] columnNames =
            {"ID Reservasi", "Nama Customer", "No. Telepon", "Jenis Meja", "No. Meja", "Catatan"};
            JTable table = new JTable(getReservasiInfo(), columnNames);
            jScrollPane1.setViewportView(table);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnKeluar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        areaCatatan = new javax.swing.JTextArea();
        btnCekIDRsv = new javax.swing.JButton();
        btnCekNamaRsv = new javax.swing.JButton();
        btnSelesaiRsv = new javax.swing.JButton();
        lblTelpRsv = new javax.swing.JLabel();
        lblJenisRsv = new javax.swing.JLabel();
        lblNoMejaRsv = new javax.swing.JLabel();
        txtIDRsv = new javax.swing.JTextField();
        txtNamaRsv = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(10, 88, 168));

        btnKeluar.setText("Kembali");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnKeluar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(btnKeluar)
                .addGap(16, 16, 16))
        );

        jPanel2.setBackground(new java.awt.Color(248, 251, 255));

        jPanel5.setBackground(new java.awt.Color(248, 251, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel21.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel21.setText("ID Reservasi");

        jLabel22.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel22.setText("Nama Customer");

        jLabel28.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel28.setText("No. Telp");

        jLabel29.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel29.setText("Jenis Meja");

        jLabel30.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel30.setText("No. Meja");

        jLabel31.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel31.setText("Catatan");

        jLabel32.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel32.setText(":");

        jLabel33.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel33.setText(":");

        jLabel34.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel34.setText(":");

        jLabel35.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel35.setText(":");

        jLabel36.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel36.setText(":");

        jLabel37.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel37.setText(":");

        areaCatatan.setEditable(false);
        areaCatatan.setBackground(new java.awt.Color(255, 255, 255));
        areaCatatan.setColumns(20);
        areaCatatan.setRows(5);
        jScrollPane3.setViewportView(areaCatatan);

        btnCekIDRsv.setText("Cek ID");
        btnCekIDRsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekIDRsvActionPerformed(evt);
            }
        });

        btnCekNamaRsv.setText("Cek Nama");
        btnCekNamaRsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekNamaRsvActionPerformed(evt);
            }
        });

        btnSelesaiRsv.setText("Selesaikan");
        btnSelesaiRsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelesaiRsvActionPerformed(evt);
            }
        });

        lblTelpRsv.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        lblTelpRsv.setText("-");

        lblJenisRsv.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        lblJenisRsv.setText("-");

        lblNoMejaRsv.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        lblNoMejaRsv.setText("-");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel30)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblJenisRsv, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNoMejaRsv, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel34)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblTelpRsv, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(73, 73, 73)
                            .addComponent(btnSelesaiRsv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel32)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtIDRsv, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(54, 54, 54)
                            .addComponent(btnCekIDRsv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel33)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtNamaRsv, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(54, 54, 54)
                            .addComponent(btnCekNamaRsv))))
                .addContainerGap(236, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel32)
                    .addComponent(btnCekIDRsv)
                    .addComponent(txtIDRsv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel33)
                    .addComponent(btnCekNamaRsv)
                    .addComponent(txtNamaRsv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel34)
                    .addComponent(btnSelesaiRsv)
                    .addComponent(lblTelpRsv))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel35)
                    .addComponent(lblJenisRsv))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel30)
                    .addComponent(lblNoMejaRsv))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31)
                        .addComponent(jLabel37))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCekIDRsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekIDRsvActionPerformed
            try {
            StrSQL = "SELECT * FROM cek_reservasi WHERE ID_Reservasi ='" + txtIDRsv.getText() + "'";
            Statement st = Lconnection.createStatement();
            ResultSet rs = st.executeQuery(StrSQL);

            if (rs.next()) {
                txtNamaRsv.setText(rs.getString("Nama_Cust"));
                lblTelpRsv.setText(rs.getString("No_Telp"));
                lblJenisRsv.setText(rs.getString("Jenis_Meja"));
                lblNoMejaRsv.setText(rs.getString("No_Meja"));
                areaCatatan.setText(rs.getString("No_Meja"));
                txtIDRsv.setText(rs.getString("ID_Reservasi"));

                btnSelesaiRsv.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this,
                    "Data Tidak Ada", "Informasi",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch (SQLException e) {
            System.out.println("Koneksi gagal" + e.toString());
        }
        

    }//GEN-LAST:event_btnCekIDRsvActionPerformed

    private void btnCekNamaRsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekNamaRsvActionPerformed
        try {
            StrSQL = "SELECT * FROM cek_reservasi WHERE Nama_Cust LIKE '%" + txtNamaRsv.getText() + "%'";
            Statement st = Lconnection.createStatement();
            ResultSet rs = st.executeQuery(StrSQL);

            if (rs.next()) {
                lblTelpRsv.setText(rs.getString("No_Telp"));
                lblJenisRsv.setText(rs.getString("Jenis_Meja"));
                lblNoMejaRsv.setText(rs.getString("No_Meja"));
                areaCatatan.setText(rs.getString("No_Meja"));
                txtIDRsv.setText(rs.getString("ID_Reservasi"));
                txtNamaRsv.setText(rs.getString("Nama_Cust"));
                
                btnSelesaiRsv.setEnabled(true);
                
            } else {
                JOptionPane.showMessageDialog(this,
                        "Data Tidak Ada", "Informasi",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println("Koneksi gagal" + e.toString());
        }
    }//GEN-LAST:event_btnCekNamaRsvActionPerformed

    private void btnSelesaiRsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelesaiRsvActionPerformed
        try{
            StrSQL = "DELETE FROM cek_reservasi WHERE ID_Reservasi = ?";
            PreparedStatement pStatement = Lconnection.prepareStatement(StrSQL);

            pStatement.setString(1, txtIDRsv.getText());

            if (pStatement.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(this, "Delete sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Delete gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }

            pStatement.close();

            txtNamaRsv.setText("");
            lblTelpRsv.setText("");
            lblJenisRsv.setText("");
            lblNoMejaRsv.setText("");
            areaCatatan.setText("");
            txtIDRsv.setText("");

        }
        catch (SQLException e) {
            System.out.println("koneksi gagal " + e.toString());
        }

    }//GEN-LAST:event_btnSelesaiRsvActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        this.dispose();
        new ReserveOrder().setVisible(true);
    }//GEN-LAST:event_btnKeluarActionPerformed

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
            java.util.logging.Logger.getLogger(CekReservasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CekReservasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CekReservasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CekReservasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CekReservasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaCatatan;
    private javax.swing.JButton btnCekIDRsv;
    private javax.swing.JButton btnCekNamaRsv;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnSelesaiRsv;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblJenisRsv;
    private javax.swing.JLabel lblNoMejaRsv;
    private javax.swing.JLabel lblTelpRsv;
    private javax.swing.JTextField txtIDRsv;
    private javax.swing.JTextField txtNamaRsv;
    // End of variables declaration//GEN-END:variables
}
