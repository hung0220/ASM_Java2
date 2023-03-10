/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class frmDangKi extends javax.swing.JFrame {

    /**
     * Creates new form frmDangKi
     */
    public frmDangKi() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgGioiTinh = new javax.swing.ButtonGroup();
        idTP = new javax.swing.JPanel();
        lblTenNguoiDung = new javax.swing.JLabel();
        lblTenDangNhap = new javax.swing.JLabel();
        lblMatKhau = new javax.swing.JLabel();
        lblGioiYinh = new javax.swing.JLabel();
        radNam = new javax.swing.JRadioButton();
        radNu = new javax.swing.JRadioButton();
        radKhac = new javax.swing.JRadioButton();
        txtTenNguoiDung = new javax.swing.JTextField();
        txtTenDangNhap = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JPasswordField();
        lblNgaySinh = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        chkDongY = new javax.swing.JCheckBox();
        txtNgaySinh = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        fontdangj = new javax.swing.JPanel();
        btnDangKi = new javax.swing.JButton();
        btnDangNhap = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ĐĂNG KÍ");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        idTP.setBackground(java.awt.SystemColor.activeCaption);

        lblTenNguoiDung.setText("Tên Người Dùng:");

        lblTenDangNhap.setText("Tên Đăng Nhập:");

        lblMatKhau.setText("Mật Khẩu:");

        lblGioiYinh.setText("Giới Tính:");

        radNam.setBackground(new java.awt.Color(204, 255, 204));
        btgGioiTinh.add(radNam);
        radNam.setText("Nam");
        radNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radNamActionPerformed(evt);
            }
        });

        radNu.setBackground(new java.awt.Color(204, 255, 204));
        btgGioiTinh.add(radNu);
        radNu.setText("Nữ");

        radKhac.setBackground(new java.awt.Color(204, 255, 204));
        btgGioiTinh.add(radKhac);
        radKhac.setSelected(true);
        radKhac.setText("Khác");
        radKhac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radKhacActionPerformed(evt);
            }
        });

        lblNgaySinh.setText("Ngày Sinh:");

        lblDiaChi.setText("Địa Chỉ:");

        chkDongY.setBackground(new java.awt.Color(255, 153, 153));
        chkDongY.setText("Tôi Đồng Ý Với Điều Khoản");
        chkDongY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDongYActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout idTPLayout = new javax.swing.GroupLayout(idTP);
        idTP.setLayout(idTPLayout);
        idTPLayout.setHorizontalGroup(
            idTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(idTPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(idTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(idTPLayout.createSequentialGroup()
                        .addComponent(lblTenNguoiDung)
                        .addGap(15, 15, 15)
                        .addComponent(txtTenNguoiDung))
                    .addGroup(idTPLayout.createSequentialGroup()
                        .addGroup(idTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTenDangNhap)
                            .addComponent(lblMatKhau)
                            .addComponent(lblGioiYinh)
                            .addComponent(lblNgaySinh)
                            .addComponent(lblDiaChi))
                        .addGap(18, 18, 18)
                        .addGroup(idTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenDangNhap)
                            .addComponent(txtMatKhau)
                            .addComponent(txtNgaySinh)
                            .addComponent(txtDiaChi)
                            .addGroup(idTPLayout.createSequentialGroup()
                                .addComponent(chkDongY)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(idTPLayout.createSequentialGroup()
                                .addComponent(radNam, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(radNu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(radKhac)
                                .addGap(8, 8, 8)))))
                .addContainerGap())
        );
        idTPLayout.setVerticalGroup(
            idTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(idTPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(idTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenNguoiDung)
                    .addComponent(txtTenNguoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(idTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenDangNhap)
                    .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(idTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMatKhau)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(idTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGioiYinh)
                    .addComponent(radNam)
                    .addComponent(radNu)
                    .addComponent(radKhac))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(idTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNgaySinh)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(idTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiaChi)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(chkDongY))
        );

        fontdangj.setBackground(java.awt.SystemColor.activeCaption);

        btnDangKi.setBackground(new java.awt.Color(255, 255, 153));
        btnDangKi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDangKi.setText("Đăng Kí Ngay");
        btnDangKi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKiActionPerformed(evt);
            }
        });

        btnDangNhap.setBackground(new java.awt.Color(255, 255, 153));
        btnDangNhap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDangNhap.setText("Đăng Nhập Ngay");
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fontdangjLayout = new javax.swing.GroupLayout(fontdangj);
        fontdangj.setLayout(fontdangjLayout);
        fontdangjLayout.setHorizontalGroup(
            fontdangjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fontdangjLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(btnDangKi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(btnDangNhap)
                .addGap(54, 54, 54))
        );
        fontdangjLayout.setVerticalGroup(
            fontdangjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fontdangjLayout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addGroup(fontdangjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.setBackground(java.awt.SystemColor.activeCaption);
        jPanel1.setForeground(new java.awt.Color(255, 255, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/HinhAnh/logo2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(idTP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(fontdangj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(idTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fontdangj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void radNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radNamActionPerformed

    private void radKhacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radKhacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radKhacActionPerformed

    private void chkDongYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDongYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkDongYActionPerformed

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        frmDangNhap frmDN = new frmDangNhap();
  frmDN.setVisible(true);
  this.setVisible(false);
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void btnDangKiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKiActionPerformed
         System.out.println("Click nút đăng nhập");
        
        //Tạo biến tenDangNhap để lưu tên nhập từ ô Tên đăng nhập
        String tenDangNhap = txtTenDangNhap.getText();        
        String matKhau = String.valueOf(txtMatKhau.getPassword());
        String tenNguoiDung = txtTenNguoiDung.getText();
        String ngaySinh = txtNgaySinh.getText();
        String diaChi = txtDiaChi.getText();
        
        if(tenDangNhap.equals("")|| matKhau.equals("")|| tenNguoiDung.equals("") || ngaySinh.equals("") 
                || diaChi.equals("") || chkDongY.isSelected() ==false ){
            JOptionPane.showMessageDialog(new JFrame(), 
                "Bạn chưa nhập đủ thông tin Hoặc chưa đồng ý và điều khoản");
        }else if( tenNguoiDung.length()<2 ){
        JOptionPane.showMessageDialog(new JFrame(), 
                "Tên Người dùng phải lớn hơn 2 kí tự");
        }else if(tenDangNhap.length() < 2 || tenDangNhap.length() >50){
        JOptionPane.showMessageDialog(new JFrame(), 
                "Tên Đăng Nhập phải lớn hơn 2 kí tự và nhỏ hơn 50 kí tự");
        }else if( matKhau.length() < 2 ){
        JOptionPane.showMessageDialog(new JFrame(), 
                "Mật Khẩu phải lớn hơn 2 kí tự");
        }else if( ngaySinh.length() <7){
        JOptionPane.showMessageDialog(new JFrame(), 
                "Ngày sinh phải dd/nn/mmmm");
        }else if( diaChi.length() < 2 ){
        JOptionPane.showMessageDialog(new JFrame(), 
                "Địa Chỉ phải lớn hơn 2 kí tự");
        }
        else{
        JOptionPane.showMessageDialog(new JFrame(), 
                "Đăng kí thành công");
        }
        
        
//        
//        if(chkDongY.isSelected() ==false){
//        JOptionPane.showMessageDialog(new JFrame(), 
//                "Bạn Chưa Đồng Ý Với Các Điều Khoản");
//        }
        
        
    }//GEN-LAST:event_btnDangKiActionPerformed

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
            java.util.logging.Logger.getLogger(frmDangKi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDangKi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDangKi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDangKi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDangKi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgGioiTinh;
    private javax.swing.JButton btnDangKi;
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JCheckBox chkDongY;
    private javax.swing.JPanel fontdangj;
    private javax.swing.JPanel idTP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblGioiYinh;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JLabel lblTenDangNhap;
    private javax.swing.JLabel lblTenNguoiDung;
    private javax.swing.JRadioButton radKhac;
    private javax.swing.JRadioButton radNam;
    private javax.swing.JRadioButton radNu;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtTenDangNhap;
    private javax.swing.JTextField txtTenNguoiDung;
    // End of variables declaration//GEN-END:variables
}
