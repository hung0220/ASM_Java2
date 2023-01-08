/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class pnlQLKhachHang extends javax.swing.JPanel {

    /**
     * Creates new form pnlQLKhachHang
     */
    public pnlQLKhachHang() {
        initComponents();
          DoDuLieuVaoTable();
          
        DoLoaiSamPhamVaoCombobox();
        
        
        
       String lenhLayDuLieu = "select * from  KhachHang";
        ResultSet rs = ConnectSQL.ThucThiLenhReSultset(lenhLayDuLieu);
        
        try {
            while(rs.next()){
                System.out.println(rs.getString(1)); //lấy dữ liệu theo sô thứ tự tính từ 1 trở đi 
                System.out.println(rs.getString("tenKH")); //lấy theo tên cột trong SQL 
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi lấy dữ liệu ");
        }
    }
     public  void DoLoaiSamPhamVaoCombobox(){
        
    String DoLoaiSamPham = "select * from LoaiKhachHang";
    ResultSet rs = SQLHelper.executeQuery(DoLoaiSamPham);
    
    //Tạo defau 
        DefaultComboBoxModel cbbmodel = (DefaultComboBoxModel)cbbLoaiKhachHang.getModel();
        
        cbbmodel.removeAllElements(); //xóa trắng dữ liệu trong ccb
        try {
            // dọc ds đổ vào cbb
            
           while(rs.next()){
            int MaLoaiSP =  rs.getInt("MaLoaiKhachHang");
            String TenLoaiSP = rs.getString("TenLoai");
            
            Mycombobox myCbb = new Mycombobox(MaLoaiSP, TenLoaiSP);
            cbbmodel.addElement(myCbb);
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(pnlQuanLiKhoHang1.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
         public String LayTenLoaiSP(int MaLoaikh){
        String cauLenhLayTenLoai = "select * from LoaiKhachHang where MaLoaiKhachHang = ?";
        ResultSet rs = SQLHelper.executeQuery(cauLenhLayTenLoai, MaLoaikh);
        try {
            if(rs.next()){
                return rs.getString("TenLoai");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "Lỗi lấy tên loại sản phẩm");
        }
        return "";
    }
     private void  ChonLoaiTrongCbb(String TenLoai){
        // Tạo lệnh lấy loại SP
        String cauLenh = "select * from LoaiKhachHang where TenLoai = ?";
        ResultSet rs = SQLHelper.executeQuery(cauLenh, TenLoai);
        
        try {
            if(rs.next()){
                int MaLoaiSP = rs.getInt("MaLoaiKhachHang");
                Mycombobox mycbb = new Mycombobox(MaLoaiSP, TenLoai);
                
                // Tạo 1 DefaultModelCombobox
                DefaultComboBoxModel cbbModel = (DefaultComboBoxModel)cbbLoaiKhachHang.getModel();
                
             cbbModel.setSelectedItem(mycbb);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(),"Lỗi lấy loại sản phẩm dựa vào tên loại");
        }
    }     
    public void DoDuLieuVaoTable(){
        String CauLenhSQL = "select * from KhachHang";
       ResultSet rs = ConnectSQL.ThucThiLenhReSultset(CauLenhSQL);
        
        DefaultTableModel tblModel = (DefaultTableModel)tblBangKhachHang.getModel();
//        xáo dữ liệu đang có trong bảng table 
        tblModel.setRowCount(0);
        Object obj[] = new Object[11];
        SimpleDateFormat kiemTra = new SimpleDateFormat("dd-MM-yyyy");
        try {
            while(rs.next()){
                obj[0] = rs.getString("maKH");
                obj[1] = rs.getString("tenKH");
                obj[2] = rs.getString("diaChi");
                
                if (rs.getBoolean("gioiTinh") == true ) {
                     obj[3] = "Nam";                    
                }
                else if (rs.getBoolean("gioiTinh") == false ) {
                     obj[3] = "Nữ";                     
                }             
                else {
                      obj[3] = "Khác";    
                 }
                obj[5] = rs.getString("dienThoai");
                if(rs.getDate("ngaySinh") != null){
                    obj[4] = Chuyendoi.LayNgayString(rs.getDate("NgaySinh"));
//                   
                }else{
                    obj[4] = "";
                }
                obj[6] = LayTenLoaiSP(rs.getInt("loaiKH"));
                //obj[6] = rs.getString("loaiKH");
                obj[7] = rs.getString("trangThai");
              
                obj[8] = rs.getString("diemTichLuy"); 
                obj[9] = Chuyendoi.SoString(rs.getDouble("tongTien"));
                 obj[10] = rs.getString("ghiChu"); 
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Lỗi truy xuất dữ liệu");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btGIOITINH = new javax.swing.ButtonGroup();
        chkhd = new javax.swing.ButtonGroup();
        jpnTen = new javax.swing.JPanel();
        LBLqlkh = new javax.swing.JLabel();
        jpnPhon = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDiemTiichLuy = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        txtGhiChu = new javax.swing.JTextField();
        txtTenKhachHang = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        radBNam = new javax.swing.JRadioButton();
        radNu = new javax.swing.JRadioButton();
        txtSDT = new javax.swing.JTextField();
        chekHoatDong = new javax.swing.JCheckBox();
        chkKhongHoatDong = new javax.swing.JCheckBox();
        cbbLoaiKhachHang = new javax.swing.JComboBox();
        date = new com.toedter.calendar.JDateChooser();
        jpnitem = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        bntSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSet = new javax.swing.JButton();
        jpnbang = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBangKhachHang = new javax.swing.JTable();
        jpmTim = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtTimTen = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTimGia = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        cbbTimKien = new javax.swing.JComboBox();
        btnSapXep = new javax.swing.JButton();

        setBackground(java.awt.Color.orange);

        jpnTen.setBackground(java.awt.SystemColor.activeCaption);

        LBLqlkh.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        LBLqlkh.setText("QUẢN LÍ KHÁCH HÀNG");

        javax.swing.GroupLayout jpnTenLayout = new javax.swing.GroupLayout(jpnTen);
        jpnTen.setLayout(jpnTenLayout);
        jpnTenLayout.setHorizontalGroup(
            jpnTenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnTenLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LBLqlkh)
                .addGap(461, 461, 461))
        );
        jpnTenLayout.setVerticalGroup(
            jpnTenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnTenLayout.createSequentialGroup()
                .addGap(0, 17, Short.MAX_VALUE)
                .addComponent(LBLqlkh))
        );

        jpnPhon.setBackground(java.awt.SystemColor.activeCaption);
        jpnPhon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ThôngTin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18), new java.awt.Color(255, 0, 51))); // NOI18N

        jLabel1.setText("Tên Khách Hàng:");

        jLabel2.setText("Địa Chỉ:");

        jLabel3.setText("Giới Tính:");

        jLabel4.setText("Ngày Sinh:");

        jLabel5.setText("Số Điện Thoại:");

        jLabel6.setText("Loại Khách Hàng:");

        jLabel7.setText("Trạng Thái:");

        jLabel8.setText("Điểm Tích Lũy:");

        jLabel9.setText("Tổng Tiền:");

        jLabel10.setText("Ghi Chú:");

        txtGhiChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGhiChuActionPerformed(evt);
            }
        });

        btGIOITINH.add(radBNam);
        radBNam.setSelected(true);
        radBNam.setText("Nam");

        btGIOITINH.add(radNu);
        radNu.setText("Nữ");

        chkhd.add(chekHoatDong);
        chekHoatDong.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        chekHoatDong.setSelected(true);
        chekHoatDong.setText("Hoạt Động");

        chkhd.add(chkKhongHoatDong);
        chkKhongHoatDong.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        chkKhongHoatDong.setText("Không Hoạt Động");

        cbbLoaiKhachHang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        javax.swing.GroupLayout jpnPhonLayout = new javax.swing.GroupLayout(jpnPhon);
        jpnPhon.setLayout(jpnPhonLayout);
        jpnPhonLayout.setHorizontalGroup(
            jpnPhonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPhonLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jpnPhonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnPhonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnPhonLayout.createSequentialGroup()
                        .addGroup(jpnPhonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTenKhachHang, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiaChi))
                        .addGap(71, 71, 71)
                        .addGroup(jpnPhonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jpnPhonLayout.createSequentialGroup()
                        .addGroup(jpnPhonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpnPhonLayout.createSequentialGroup()
                                .addComponent(radBNam, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                                .addComponent(radNu, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(107, 107, 107)
                        .addGroup(jpnPhonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnPhonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpnPhonLayout.createSequentialGroup()
                        .addComponent(chekHoatDong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkKhongHoatDong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cbbLoaiKhachHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGhiChu)
                    .addComponent(txtTongTien)
                    .addComponent(txtDiemTiichLuy))
                .addGap(53, 53, 53))
        );
        jpnPhonLayout.setVerticalGroup(
            jpnPhonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPhonLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jpnPhonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLoaiKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnPhonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jpnPhonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chekHoatDong)
                        .addComponent(chkKhongHoatDong)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnPhonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnPhonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel8)
                        .addComponent(txtDiemTiichLuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(radNu)
                    .addComponent(radBNam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnPhonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnPhonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel9))
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnPhonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnitem.setBackground(java.awt.SystemColor.activeCaption);
        jpnitem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nút Bấm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18), new java.awt.Color(255, 0, 51))); // NOI18N

        btnThem.setBackground(new java.awt.Color(51, 255, 0));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/HinhAnh/add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        bntSua.setBackground(new java.awt.Color(255, 255, 0));
        bntSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/HinhAnh/updated.png"))); // NOI18N
        bntSua.setText("sửa");
        bntSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 255, 255));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/HinhAnh/remove.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSet.setBackground(new java.awt.Color(255, 51, 255));
        btnSet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/HinhAnh/refresh.png"))); // NOI18N
        btnSet.setText("Set");
        btnSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnitemLayout = new javax.swing.GroupLayout(jpnitem);
        jpnitem.setLayout(jpnitemLayout);
        jpnitemLayout.setHorizontalGroup(
            jpnitemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnitemLayout.createSequentialGroup()
                .addGap(392, 392, 392)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(bntSua, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnSet, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnitemLayout.setVerticalGroup(
            jpnitemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnitemLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jpnitemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSet, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnitemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bntSua, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jpnbang.setBackground(java.awt.SystemColor.activeCaption);
        jpnbang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bảng Thông Tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18), new java.awt.Color(255, 0, 51))); // NOI18N

        jScrollPane1.setBorder(null);

        tblBangKhachHang.setBackground(java.awt.SystemColor.activeCaption);
        tblBangKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Khách Hàng", "Tên Khách Hàng", "Địa Chỉ ", "Giới Tính", "Ngày Sinh", "Số ĐIện Thoại", "Loại Khách Hàn", "Trạng Thái", "Điểm Tích Lũ", "Tổng Tiền", "Ghi Chú"
            }
        ));
        tblBangKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBangKhachHang);
        if (tblBangKhachHang.getColumnModel().getColumnCount() > 0) {
            tblBangKhachHang.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout jpnbangLayout = new javax.swing.GroupLayout(jpnbang);
        jpnbang.setLayout(jpnbangLayout);
        jpnbangLayout.setHorizontalGroup(
            jpnbangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jpnbangLayout.setVerticalGroup(
            jpnbangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnbangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpmTim.setBackground(java.awt.SystemColor.activeCaption);
        jpmTim.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Công Cụ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18), new java.awt.Color(255, 0, 51))); // NOI18N

        jLabel11.setText("Tìm tên:");

        txtTimTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimTenActionPerformed(evt);
            }
        });
        txtTimTen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimTenKeyReleased(evt);
            }
        });

        jLabel12.setText("Tìm Giá:");

        txtTimGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimGiaKeyReleased(evt);
            }
        });

        btnTimKiem.setBackground(new java.awt.Color(153, 255, 255));
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/HinhAnh/loupe.png"))); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");

        cbbTimKien.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sắp Xếp Tổng Tiền Tăng Dần", "Sắp Xếp Tổng Tiền Giảm Dần", "Sắp Xếp Điểm Tích Lũy Tăng Dần", "Sắp Xếp Điểm Tích Lũy Giảm Dần" }));
        cbbTimKien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTimKienActionPerformed(evt);
            }
        });

        btnSapXep.setBackground(new java.awt.Color(255, 153, 255));
        btnSapXep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/HinhAnh/sort-down.png"))); // NOI18N
        btnSapXep.setText("Sắp Xếp");
        btnSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpmTimLayout = new javax.swing.GroupLayout(jpmTim);
        jpmTim.setLayout(jpmTimLayout);
        jpmTimLayout.setHorizontalGroup(
            jpmTimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jpmTimLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jpmTimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpmTimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpmTimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpmTimLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(txtTimGia, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpmTimLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txtTimTen))
                            .addComponent(cbbTimKien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpmTimLayout.createSequentialGroup()
                            .addComponent(btnTimKiem)
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpmTimLayout.createSequentialGroup()
                        .addComponent(btnSapXep)
                        .addContainerGap())))
        );
        jpmTimLayout.setVerticalGroup(
            jpmTimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpmTimLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jpmTimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTimTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpmTimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txtTimGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(btnTimKiem)
                .addGap(18, 18, 18)
                .addComponent(cbbTimKien, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSapXep)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnTen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jpnbang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnitem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jpnPhon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jpmTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpmTim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnPhon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnitem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnbang, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtGhiChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGhiChuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGhiChuActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        int MaLoaiSP;
        Mycombobox LoaiDuocChon = (Mycombobox)cbbLoaiKhachHang.getSelectedItem();
        MaLoaiSP =LoaiDuocChon.MaInt(); 
        String tenKH = txtTenKhachHang.getText();
        String diaChi = txtDiaChi.getText();
        String ngaySinh ;//= txtNgaySInh.getText();
        String ghiChu = txtGhiChu.getText();
       
        String SDT = txtSDT.getText();
        String tongTien = txtTongTien.getText();
        String diemtixhluy = txtDiemTiichLuy.getText();
         String gioiTinh = null;
        if (radBNam.isSelected() ){

            gioiTinh = "1";
        }
        else if (radNu.isSelected()) {

            gioiTinh = "0";
        }
       
        String TrangThai;
         if (chekHoatDong.isSelected() ){
            TrangThai = "1";
        }
     
        else {  
              TrangThai = "0";
        }
         Calendar cal = Calendar.getInstance();
        SimpleDateFormat kiemTra = new SimpleDateFormat("dd-MM-yyy");
        kiemTra.setLenient(false);
             try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            ngaySinh = sdf.format(date.getDate());

            System.out.println("Ngay sinh: " + ngaySinh);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Không được để trống ngày vào làm !", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
             try {
            SimpleDateFormat ns = new SimpleDateFormat("dd/MM/yyyy"); // chuyển về định dạng yyy/MM/dd
            String f = ns.format(date.getDate());// dữ liệu ngày sinh kiểu string

            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(f);//chuyển về kiểu date

            Date dateHienTai = new Date();//lấy ngày hiện tại

            if (date.after(dateHienTai)) {// kiểm tra có lớn hơn ngày hiện tại không
                JOptionPane.showMessageDialog(this, "Ngày sinh không được quá ngày hiện tại !", "Info", JOptionPane.INFORMATION_MESSAGE);
                return;//có thì return
            } else {

                ngaySinh = ns.format(date);//không thì format dữ liệu ngày sinh về lại String và gán vào biến ngày sinh => object[]
            }

            System.out.println("Ngay sinh: " + ngaySinh);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Không được để trống ngày sinh !", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

         if(tenKH.equals("") || diaChi.equals("") || ngaySinh.equals("") || ghiChu.equals("")  || SDT.equals("") || tongTien.equals("") || diemtixhluy.equals("") ){
             JOptionPane.showMessageDialog(new JFrame(),
                "Bạn chưa nhập đủ thông tin ");
              return;
         }else if(!SDT.matches("^[0-9]{10}$")){
          JOptionPane.showMessageDialog(new JFrame(), "Bạn nhập sai  SĐT");
            return;
         } else if(!tongTien.matches( "^[0-9]*$")||tongTien.equals("0")){
            JOptionPane.showMessageDialog(new JFrame(), "Tiền phải lớn hơn 0");
            return;
        }
         
         else{
         String cauLenhThem =  "INSERT INTO [dbo].[KhachHang] " +
"           ([Tenkh] " +
"           ,[diaChi] " +
"           ,[gioiTinh] " +
"           ,[ngaySinh] " +
"           ,[dienThoai] " +
"           ,[loaiKH] " +
"           ,[trangThai] " +
"           ,[diemTichLuy] " +
"           ,[tongTien] " +
"           ,[ghiChu]) " +
"     VALUES " +
"           (?,?,?,?,?,?,?,?,?,?)";
   SQLHelper.executeUpdate(cauLenhThem, tenKH,diaChi,gioiTinh,ngaySinh,SDT,MaLoaiSP,TrangThai,diemtixhluy,tongTien,ghiChu);
           DoDuLieuVaoTable();
         }
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblBangKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangKhachHangMouseClicked
        int viTriDuocChon = tblBangKhachHang.getSelectedRow();

   
    String tenKH = tblBangKhachHang.getValueAt(viTriDuocChon, 1).toString();
    txtTenKhachHang.setText(tenKH);
    
    String diaChi = tblBangKhachHang.getValueAt(viTriDuocChon, 2).toString();
    txtDiaChi.setText(diaChi);
    
   Object gioiTinh =tblBangKhachHang.getValueAt(viTriDuocChon, 3).toString();
        if (gioiTinh.equals("Nam")) {
             radBNam.setSelected(true);
        }else if(gioiTinh.equals("Nữ")) {
             radNu.setSelected(true);            
        }
//    String ngaySinh = tblBangKhachHang.getValueAt(viTriDuocChon, 4).toString();
////    txtNgaySInh.setText(ngaySinh);
//    try {
//            Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(ngaySinh);
//            date.setDate(date2);
//        } catch (ParseException ex) {
//            Logger.getLogger(pnlLoaiKhachHang.class.getName()).log(Level.SEVERE, null, ex);
//        }
    String SDT = tblBangKhachHang.getValueAt(viTriDuocChon, 5).toString();
    txtSDT.setText(SDT);
//        String loaiKH = tblBangKhachHang.getValueAt(viTriDuocChon, 6).toString();
//    txtLoaiKhakHang.setText(loaiKH);
    
    String TenLoaiSP = tblBangKhachHang.getValueAt(viTriDuocChon, 6).toString();
        ChonLoaiTrongCbb(TenLoaiSP);
    Object TrangThai = tblBangKhachHang.getValueAt(viTriDuocChon, 7).toString();
      if (TrangThai.equals("1")) {
             chekHoatDong.setSelected(true);
                    }
        else if (TrangThai.equals("0"))  {
        chkKhongHoatDong.setSelected(true);         
        }
      String diemtichluy = tblBangKhachHang.getValueAt(viTriDuocChon, 8).toString();
    txtDiemTiichLuy.setText(diemtichluy);
    String tongtien = tblBangKhachHang.getValueAt(viTriDuocChon, 9).toString();
    txtTongTien.setText(tongtien);
    String ghiChu = tblBangKhachHang.getValueAt(viTriDuocChon, 10).toString();
    txtGhiChu.setText(ghiChu);
    }//GEN-LAST:event_tblBangKhachHangMouseClicked

    private void bntSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSuaActionPerformed
int viTriDuocChon = tblBangKhachHang.getSelectedRow();

        if(viTriDuocChon == -1){
            JOptionPane.showMessageDialog(new JFrame(), "Bạn chưa chọn dòng để sửa");
            return; //thoat khoi ham
        }  
        int MaLoaiSP;
        Mycombobox LoaiDuocChon = (Mycombobox)cbbLoaiKhachHang.getSelectedItem();
        MaLoaiSP =LoaiDuocChon.MaInt();
        String tenKH = txtTenKhachHang.getText();
        String diaChi = txtDiaChi.getText();
        String ngaySinh; // = txtNgaySInh.getText();
        String ghiChu = txtGhiChu.getText();
      
        String SDT = txtSDT.getText();
        String tongTien = txtTongTien.getText();
        String diemtixhluy = txtDiemTiichLuy.getText();
         String gioiTinh = null;
        if (radBNam.isSelected() ){
            gioiTinh = "1";
        }
        else if (radNu.isSelected()) {
            gioiTinh = "0";
        }
        String trangThai = null;
        if (chekHoatDong.isSelected()) {
            trangThai ="1";
                    }
        else if (chkKhongHoatDong.isSelected())  {
        trangThai ="0";        
        }
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat kiemTra = new SimpleDateFormat("dd-MM-yyy");
        kiemTra.setLenient(false);
            
        
//        if(!ngaySinh.matches("^[0-9\\-]*$")){
//            JOptionPane.showMessageDialog(new JFrame(), "Ngày sinh sai định dạng (dd-MM-yyyy)");
//            return;
//        }    
//        try {
//            Date NgaySinh = kiemTra.parse(ngaySinh);
//      
//            // new dateHT = ngày hiện tại
//            Date dateHT = new Date();
//            if (NgaySinh.after(dateHT)) {
//                JOptionPane.showMessageDialog(new JFrame(), "Ngày sinh phải trước ngày hôm nay");
//                return;
//            }
//
//        } catch (ParseException ex) {
//            JOptionPane.showMessageDialog(null, "Ngày sinh sai định dạng (dd-MM-yyyy)");
//            Logger.getLogger(pnlQLKhachHang.class.getName()).log(Level.SEVERE, null, ex);
//            return;
//        }
      
             try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            ngaySinh = sdf.format(date.getDate());

            System.out.println("Ngay sinh: " + ngaySinh);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Không được để trống ngày vào làm !", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
             try {
            SimpleDateFormat ns = new SimpleDateFormat("dd/MM/yyyy"); // chuyển về định dạng yyy/MM/dd
            String f = ns.format(date.getDate());// dữ liệu ngày sinh kiểu string

            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(f);//chuyển về kiểu date

            Date dateHienTai = new Date();//lấy ngày hiện tại

            if (date.after(dateHienTai)) {// kiểm tra có lớn hơn ngày hiện tại không
                JOptionPane.showMessageDialog(this, "Ngày sinh không được quá ngày hiện tại !", "Info", JOptionPane.INFORMATION_MESSAGE);
                return;//có thì return
            } else {

                ngaySinh = ns.format(date);//không thì format dữ liệu ngày sinh về lại String và gán vào biến ngày sinh => object[]
            }

            System.out.println("Ngay sinh: " + ngaySinh);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Không được để trống ngày sinh !", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

         if(tenKH.equals("") || diaChi.equals("") || ngaySinh.equals("") || ghiChu.equals("") || SDT.equals("") || tongTien.equals("") || diemtixhluy.equals("") ){
             JOptionPane.showMessageDialog(new JFrame(),
                "Bạn chưa nhập đủ thông tin ");
              return;
         }else if(!SDT.matches("^[0-9]{10}$")){
          JOptionPane.showMessageDialog(new JFrame(), "Bạn nhập sai  SĐT");
            return;
         } else if(!tongTien.matches( "^[0-9]*$")||tongTien.equals("0")){
            JOptionPane.showMessageDialog(new JFrame(), "Tiền phải lớn hơn 0");
            return;
        }
         
         else{
         String MaKH = tblBangKhachHang.getValueAt(viTriDuocChon,0).toString();
          String CauLenhSua = "UPDATE [dbo].[KhachHang]   " +
"   SET [Tenkh] = N'"+tenKH+"'   " +
"      ,[diaChi] = N'"+diaChi+"' " +
"      ,[gioiTinh] =  " + gioiTinh+
"      ,[ngaySinh] = '"+ngaySinh+"'   " +
"      ,[dienThoai] = N'"+SDT+"'   " +
"      ,[loaiKH] = N'"+MaLoaiSP+"'   " +
"      ,[trangThai] =  " + trangThai +
"      ,[diemTichLuy] =    " + diemtixhluy+
"      ,[tongTien] = " + tongTien+
"      ,[ghiChu] = N'"+ghiChu+"'   " +
" WHERE maKH = " + MaKH ;
        ConnectSQL.ThucThi3Lenh(CauLenhSua);
        DoDuLieuVaoTable();
         }
    }//GEN-LAST:event_bntSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
int DSViTriXoa [] = tblBangKhachHang.getSelectedRows();
        
        for(int i = DSViTriXoa.length - 1; i >= 0; i-- ){
            String maNV = tblBangKhachHang.getValueAt(DSViTriXoa[i], 0).toString();
            String CauLenhSQL = "Delete from KhachHang where maKH = " + maNV;
            ConnectSQL.ThucThi3Lenh(CauLenhSQL);
            DoDuLieuVaoTable();
        }       
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtTimTenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimTenKeyReleased
         String timTen = "%" +txtTimTen.getText() +"%";
        
        String CauLenhTim = "select *from KhachHang where Tenkh like ?";
        ResultSet rs = SQLHelper.executeQuery(CauLenhTim, timTen);
        
        DefaultTableModel tblModel = (DefaultTableModel)tblBangKhachHang.getModel();
//        xáo dữ liệu đang có trong bảng table 
        tblModel.setRowCount(0);
        Object obj[] = new Object[11];
          SimpleDateFormat kiemTra = new SimpleDateFormat("dd-MM-yyyy");
        try {
            while(rs.next()){
                obj[0] = rs.getString("maKH");
                obj[1] = rs.getString("tenKH");
                obj[2] = rs.getString("diaChi");
                
                if (rs.getBoolean("gioiTinh") == true ) {
                     obj[3] = "Nam";                    
                }
                else if (rs.getBoolean("gioiTinh") == false ) {
                     obj[3] = "Nữ";                     
                }             
                else {
                      obj[3] = "Khác";    
                 }
                obj[5] = rs.getString("dienThoai");
                if(rs.getDate("ngaySinh") != null){
                    obj[4] = Chuyendoi.LayNgayString(rs.getDate("NgaySinh"));
//                    obj[4] = kiemTra.format(rs.getDate("ngaySinh"));
                }else{
                    obj[4] = "";
                }
                obj[6] = LayTenLoaiSP(rs.getInt("loaiKH"));
                obj[7] = rs.getString("trangThai");
               
                obj[8] = rs.getString("diemTichLuy"); 
                obj[9] = Chuyendoi.SoString(rs.getDouble("tongTien"));
                 obj[10] = rs.getString("ghiChu"); 
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Lỗi truy xuất dữ liệu");
        }
    }//GEN-LAST:event_txtTimTenKeyReleased

    private void txtTimGiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimGiaKeyReleased
       double timGiaBan;
        try{
        timGiaBan = Double.parseDouble(txtTimGia.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), "Gía cần tìm không hợp lệ");
            return;           
        }
         SimpleDateFormat kiemTra = new SimpleDateFormat("dd-MM-yyyy");
        
        String CauLenhTim = "select *from KhachHang where tongTien >=?";
        ResultSet rs = SQLHelper.executeQuery(CauLenhTim, timGiaBan);
        
        DefaultTableModel tblModel = (DefaultTableModel)tblBangKhachHang.getModel();
//        xáo dữ liệu đang có trong bảng table 
        tblModel.setRowCount(0);
        Object obj[] = new Object[11];
        
        try {
            while(rs.next()){
               obj[0] = rs.getString("maKH");
                obj[1] = rs.getString("tenKH");
                obj[2] = rs.getString("diaChi");
                
                if (rs.getBoolean("gioiTinh") == true ) {
                     obj[3] = "Nam";                    
                }
                else if (rs.getBoolean("gioiTinh") == false ) {
                     obj[3] = "Nữ";                     
                }             
                else {
                      obj[3] = "Khác";    
                 }
                obj[5] = rs.getString("dienThoai");
                if(rs.getDate("ngaySinh") != null){
                    obj[4] = Chuyendoi.LayNgayString(rs.getDate("NgaySinh"));
//                    obj[4] = kiemTra.format(rs.getDate("ngaySinh"));
                }else{
                    obj[4] = "";
                }
               obj[6] = LayTenLoaiSP(rs.getInt("loaiKH"));
                obj[7] = rs.getString("trangThai");
               
                obj[8] = rs.getString("diemTichLuy"); 
                obj[9] = Chuyendoi.SoString(rs.getDouble("tongTien"));
                 obj[10] = rs.getString("ghiChu"); 
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Lỗi truy xuất dữ liệu");
        }
    }//GEN-LAST:event_txtTimGiaKeyReleased

    private void btnSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetActionPerformed
        txtDiaChi.setText("");
        txtDiemTiichLuy.setText("");
        txtGhiChu.setText("");
        txtSDT.setText("");
        txtTenKhachHang.setText("");
        txtTimGia.setText("");
        txtTimTen.setText("");
        txtTongTien.setText("");
    }//GEN-LAST:event_btnSetActionPerformed

    private void cbbTimKienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTimKienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbTimKienActionPerformed

    private void btnSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXepActionPerformed
       String TimKiem= cbbTimKien.getSelectedItem().toString();
     System.out.println(TimKiem);
      if(TimKiem == "Sắp Xếp Tổng Tiền Tăng Dần"){
             String CauLenhTim = "Select * from KhachHang  order by tongTien  asc ";
        ResultSet rs = SQLHelper.executeQuery(CauLenhTim);
          SimpleDateFormat kiemTra = new SimpleDateFormat("dd-MM-yyyy");
        DefaultTableModel tblModel = (DefaultTableModel)tblBangKhachHang.getModel();
//        xáo dữ liệu đang có trong bảng table 
        tblModel.setRowCount(0);
        Object obj[] = new Object[11];
        
        try {
            while(rs.next()){
                   obj[0] = rs.getString("maKH");
                obj[1] = rs.getString("tenKH");
                obj[2] = rs.getString("diaChi");
                
                if (rs.getBoolean("gioiTinh") == true ) {
                     obj[3] = "Nam";                    
                }
                else if (rs.getBoolean("gioiTinh") == false ) {
                     obj[3] = "Nữ";                     
                }             
                else {
                      obj[3] = "Khác";    
                 }
                obj[5] = rs.getString("dienThoai");
                if(rs.getDate("ngaySinh") != null){
                    obj[4] = Chuyendoi.LayNgayString(rs.getDate("NgaySinh"));
//                    obj[4] = kiemTra.format(rs.getDate("ngaySinh"));
                }else{
                    obj[4] = "";
                }
               obj[6] = LayTenLoaiSP(rs.getInt("loaiKH"));
                obj[7] = rs.getString("trangThai");
               
                obj[8] = rs.getString("diemTichLuy"); 
                obj[9] = Chuyendoi.SoString(rs.getDouble("tongTien"));
                 obj[10] = rs.getString("ghiChu"); 
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Lỗi truy xuất dữ liệu");
        }
     }else if(TimKiem == "Sắp Xếp Tổng Tiền Giảm Dần"){
             String CauLenhTim = "Select * from KhachHang  order by tongTien  DESC ";
        ResultSet rs = SQLHelper.executeQuery(CauLenhTim);
          SimpleDateFormat kiemTra = new SimpleDateFormat("dd-MM-yyyy");
        DefaultTableModel tblModel = (DefaultTableModel)tblBangKhachHang.getModel();
//        xáo dữ liệu đang có trong bảng table 
        tblModel.setRowCount(0);
        Object obj[] = new Object[11];
        
        try {
            while(rs.next()){
                   obj[0] = rs.getString("maKH");
                obj[1] = rs.getString("tenKH");
                obj[2] = rs.getString("diaChi");
                
                if (rs.getBoolean("gioiTinh") == true ) {
                     obj[3] = "Nam";                    
                }
                else if (rs.getBoolean("gioiTinh") == false ) {
                     obj[3] = "Nữ";                     
                }             
                else {
                      obj[3] = "Khác";    
                 }
                obj[5] = rs.getString("dienThoai");
                if(rs.getDate("ngaySinh") != null){
                    obj[4] = Chuyendoi.LayNgayString(rs.getDate("NgaySinh"));
//                    obj[4] = kiemTra.format(rs.getDate("ngaySinh"));
                }else{
                    obj[4] = "";
                }
               obj[6] = LayTenLoaiSP(rs.getInt("loaiKH"));
                obj[7] = rs.getString("trangThai");
               
                obj[8] = rs.getString("diemTichLuy"); 
                obj[9] = Chuyendoi.SoString(rs.getDouble("tongTien"));
                 obj[10] = rs.getString("ghiChu"); 
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Lỗi truy xuất dữ liệu");
        }
     }else if(TimKiem == "Sắp Xếp Điểm Tích Lũy Tăng Dần"){
                String CauLenhTim = "Select * from KhachHang  order by diemTichLuy    asc ";
        ResultSet rs = SQLHelper.executeQuery(CauLenhTim);
          SimpleDateFormat kiemTra = new SimpleDateFormat("dd-MM-yyyy");
        DefaultTableModel tblModel = (DefaultTableModel)tblBangKhachHang.getModel();
//        xáo dữ liệu đang có trong bảng table 
        tblModel.setRowCount(0);
        Object obj[] = new Object[11];
        
        try {
            while(rs.next()){
                   obj[0] = rs.getString("maKH");
                obj[1] = rs.getString("tenKH");
                obj[2] = rs.getString("diaChi");
                
                if (rs.getBoolean("gioiTinh") == true ) {
                     obj[3] = "Nam";                    
                }
                else if (rs.getBoolean("gioiTinh") == false ) {
                     obj[3] = "Nữ";                     
                }             
                else {
                      obj[3] = "Khác";    
                 }
                obj[5] = rs.getString("dienThoai");
                if(rs.getDate("ngaySinh") != null){
                    obj[4] = Chuyendoi.LayNgayString(rs.getDate("NgaySinh"));
//                    obj[4] = kiemTra.format(rs.getDate("ngaySinh"));
                }else{
                    obj[4] = "";
                }
               obj[6] = LayTenLoaiSP(rs.getInt("loaiKH"));
                obj[7] = rs.getString("trangThai");
               
                obj[8] = rs.getString("diemTichLuy"); 
                obj[9] = Chuyendoi.SoString(rs.getDouble("tongTien"));
                 obj[10] = rs.getString("ghiChu"); 
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Lỗi truy xuất dữ liệu");
        }
     }else if(TimKiem == "Sắp Xếp Điểm Tích Lũy Giảm Dần"){
             String CauLenhTim = "Select * from KhachHang  order by diemTichLuy  DESC ";
        ResultSet rs = SQLHelper.executeQuery(CauLenhTim);
          SimpleDateFormat kiemTra = new SimpleDateFormat("dd-MM-yyyy");
        DefaultTableModel tblModel = (DefaultTableModel)tblBangKhachHang.getModel();
//        xáo dữ liệu đang có trong bảng table 
        tblModel.setRowCount(0);
        Object obj[] = new Object[11];
        
        try {
            while(rs.next()){
                   obj[0] = rs.getString("maKH");
                obj[1] = rs.getString("tenKH");
                obj[2] = rs.getString("diaChi");
                
                if (rs.getBoolean("gioiTinh") == true ) {
                     obj[3] = "Nam";                    
                }
                else if (rs.getBoolean("gioiTinh") == false ) {
                     obj[3] = "Nữ";                     
                }             
                else {
                      obj[3] = "Khác";    
                 }
                obj[5] = rs.getString("dienThoai");
                if(rs.getDate("ngaySinh") != null){
                    obj[4] = Chuyendoi.LayNgayString(rs.getDate("NgaySinh"));
//                    obj[4] = kiemTra.format(rs.getDate("ngaySinh"));
                }else{
                    obj[4] = "";
                }
               obj[6] = LayTenLoaiSP(rs.getInt("loaiKH"));
                obj[7] = rs.getString("trangThai");
               
                obj[8] = rs.getString("diemTichLuy"); 
                obj[9] = Chuyendoi.SoString(rs.getDouble("tongTien"));
                 obj[10] = rs.getString("ghiChu"); 
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Lỗi truy xuất dữ liệu");
        }
     }
    }//GEN-LAST:event_btnSapXepActionPerformed

    private void txtTimTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimTenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LBLqlkh;
    private javax.swing.JButton bntSua;
    private javax.swing.ButtonGroup btGIOITINH;
    private javax.swing.JButton btnSapXep;
    private javax.swing.JButton btnSet;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox cbbLoaiKhachHang;
    private javax.swing.JComboBox cbbTimKien;
    private javax.swing.JCheckBox chekHoatDong;
    private javax.swing.JCheckBox chkKhongHoatDong;
    private javax.swing.ButtonGroup chkhd;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpmTim;
    private javax.swing.JPanel jpnPhon;
    private javax.swing.JPanel jpnTen;
    private javax.swing.JPanel jpnbang;
    private javax.swing.JPanel jpnitem;
    private javax.swing.JRadioButton radBNam;
    private javax.swing.JRadioButton radNu;
    private javax.swing.JTable tblBangKhachHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDiemTiichLuy;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTimGia;
    private javax.swing.JTextField txtTimTen;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
