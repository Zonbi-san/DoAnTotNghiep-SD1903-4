/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import Model.HoaDon;
import controller.BHDAO1;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileNotFoundException;

import java.io.FileOutputStream;

/**
 *
 * @author Admin
 */
public final class BHpanel extends javax.swing.JPanel {

    public BHDAO1 BHdao = new BHDAO1();
    DefaultTableModel modelhd = new DefaultTableModel();
    DefaultTableModel modelcthd = new DefaultTableModel();
    DefaultTableModel modelsp = new DefaultTableModel();
    int currentRowHD = -1;
    int currentRowSP = -1;
    int currentRowCTHD = -1;
    ArrayList<HoaDon> hdList = new ArrayList<>();
    
    /**
     * Creates new form BHpanel
     */
    public BHpanel() {
        initComponents();
        modelhd = (DefaultTableModel) tblhd.getModel();
        modelcthd = (DefaultTableModel) tblcthd.getModel();
        modelsp = (DefaultTableModel) tblsp.getModel();
        displayHD();
        displaySP();
    }

    public void displayHD() {
        modelhd.setRowCount(0);
        hdList.removeAll(hdList);
        try {
            ResultSet rs = BHdao.getHD();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getString(1), rs.getTimestamp(2), rs.getString(3), rs.getString(4), rs.getBigDecimal(5), rs.getBigDecimal(6), rs.getBigDecimal(7));
                modelhd.addRow(new Object[]{
                    rs.getString(1),
                    rs.getTimestamp(2),
                    rs.getString(3),
                    rs.getString(4)
                });
                hdList.add(hd);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Có lỗi trong lúc tải", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void displaySP() {
        modelsp.setRowCount(0);
        try {
            ResultSet rs = BHdao.getSP();
            while (rs.next()) {
                modelsp.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getDouble(3)
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Có lỗi trong lúc tải", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void displayCTHD(String ID) {
        modelcthd.setRowCount(0);
        int tongtien = 0;
        try {
            ResultSet rs = BHdao.getCTHD(ID);
            while (rs.next()) {
                modelcthd.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getDouble(3),
                    rs.getDouble(4),
                    rs.getDouble(5)
                });
                tongtien += (rs.getDouble(3) * rs.getDouble(4));
            }
            txtTongtien.setText(String.valueOf(tongtien));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Có lỗi trong lúc tải", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
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

        txttgian = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblcthd = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtidhd = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btntaoHD = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnthaydoiHD = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblhd = new javax.swing.JTable();
        btnxoaHD = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtmgg = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtTongtien = new javax.swing.JTextField();
        btnthanhtoan = new javax.swing.JButton();
        btnadd = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtidcthd = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtsl = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtidnv = new javax.swing.JTextField();
        btnupdate = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblsp = new javax.swing.JTable();
        txtidkh = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        tblcthd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Sản Phẩm", "Số Lượng", "Đơn Giá", "Thành Tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblcthd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblcthdMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblcthd);

        jScrollPane4.setViewportView(jScrollPane2);

        jLabel10.setText("Thời Gian");

        jLabel11.setText("ID Chi Tiết Hóa Đơn");

        txtidhd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidhdActionPerformed(evt);
            }
        });

        jLabel1.setText("Hóa Đơn");

        btntaoHD.setBackground(new java.awt.Color(41, 62, 80));
        btntaoHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btntaoHD.setForeground(new java.awt.Color(255, 255, 255));
        btntaoHD.setText("Tạo Hóa Đơn");
        btntaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntaoHDActionPerformed(evt);
            }
        });

        jLabel2.setText("Chi tiết hóa đơn");

        btnthaydoiHD.setBackground(new java.awt.Color(41, 62, 80));
        btnthaydoiHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnthaydoiHD.setForeground(new java.awt.Color(255, 255, 255));
        btnthaydoiHD.setText("Sửa Hóa Đơn");
        btnthaydoiHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthaydoiHDActionPerformed(evt);
            }
        });

        tblhd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Thời Gian", "Khách Hàng", "Người Dùng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblhd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblhdMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblhd);

        jScrollPane5.setViewportView(jScrollPane1);

        btnxoaHD.setBackground(new java.awt.Color(41, 62, 80));
        btnxoaHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnxoaHD.setForeground(new java.awt.Color(255, 255, 255));
        btnxoaHD.setText("Xóa Hóa Đơn");
        btnxoaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaHDActionPerformed(evt);
            }
        });

        jLabel9.setText("Chi tiết hóa đơn");

        jLabel12.setText("Hóa Đơn");

        jLabel3.setText("Sản Phẩm");

        jLabel4.setText("Tổng Tiền");

        jLabel13.setText("Mã Giảm Giá");

        btnthanhtoan.setBackground(new java.awt.Color(41, 62, 80));
        btnthanhtoan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnthanhtoan.setForeground(new java.awt.Color(255, 255, 255));
        btnthanhtoan.setText("Thanh Toán");
        btnthanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthanhtoanActionPerformed(evt);
            }
        });

        btnadd.setBackground(new java.awt.Color(41, 62, 80));
        btnadd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnadd.setForeground(new java.awt.Color(255, 255, 255));
        btnadd.setText("Thêm Vào Hóa Đơn");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btndelete.setBackground(new java.awt.Color(41, 62, 80));
        btndelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btndelete.setForeground(new java.awt.Color(255, 255, 255));
        btndelete.setText("Xóa Khỏi Hóa Đơn");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        jLabel5.setText("ID Hóa Đơn");

        jLabel6.setText("Số Lượng");

        jLabel7.setText("ID Nhân Viên");

        btnupdate.setBackground(new java.awt.Color(41, 62, 80));
        btnupdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnupdate.setForeground(new java.awt.Color(255, 255, 255));
        btnupdate.setText("Thay Đổi Hóa Đơn");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        jLabel8.setText("ID Khách Hàng");

        tblsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Tên", "Giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tblsp);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnadd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnupdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btndelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnthanhtoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel11)
                                            .addComponent(txtidcthd, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtsl, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel4)
                                            .addComponent(txtTongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttgian, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel5)
                                    .addComponent(txtidhd, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(txtidnv, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(txtidkh))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtmgg)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnthaydoiHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnxoaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btntaoHD, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTongtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(txtidhd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(38, 38, 38)
                                        .addComponent(txttgian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtidcthd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtsl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtidkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(16, 16, 16)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel13))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtidnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtmgg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(2, 2, 2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(28, 28, 28))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnthanhtoan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnadd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnupdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btndelete))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btntaoHD)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnthaydoiHD)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnxoaHD)))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblcthdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblcthdMouseClicked
        currentRowCTHD = tblcthd.getSelectedRow();
        String idct = String.valueOf(tblcthd.getValueAt(currentRowCTHD, 0));
        double sl = Double.parseDouble(String.valueOf(tblcthd.getValueAt(currentRowCTHD, 2)));
        String idsp = String.valueOf(tblcthd.getValueAt(currentRowCTHD, 1));
        txtidcthd.setText(idct);
        txtsl.setText(String.valueOf(sl));
        for (int i = 0; i < tblsp.getRowCount(); i++) {
            if (String.valueOf(tblsp.getValueAt(i, 0)).equals(idsp)) {
                tblsp.setRowSelectionInterval(i, i);
            }
        }
    }//GEN-LAST:event_tblcthdMouseClicked

    private void txtidhdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidhdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidhdActionPerformed

    private void btntaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntaoHDActionPerformed
        try{
            String ID = txtidhd.getText();
            String tgian = txttgian.getText();
            String IDKH = txtidkh.getText();
            String IDND = txtidnv.getText();
            double tongTien = 0;
            double magiamgia = Double.parseDouble(txtmgg.getText());
            double Tongtiensaugiamgia = 0;
            if(ID.isEmpty() || tgian.isEmpty() || IDKH.isEmpty() || IDND.isEmpty()){
                JOptionPane.showMessageDialog(this, "Có lỗi trg lúc thêm");
            }
            else{
                boolean rs = BHdao.addHD(ID, tgian, IDKH, IDND, tongTien, magiamgia, Tongtiensaugiamgia);
                if(rs){
                    displayHD();
                    modelcthd.setRowCount(0);
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                }
            }
        }
        catch(HeadlessException | NumberFormatException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btntaoHDActionPerformed

    private void btnthaydoiHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthaydoiHDActionPerformed
        currentRowHD = tblhd.getSelectedRow();
        try{
            String ID = txtidhd.getText();
            String tgian = txttgian.getText();
            String IDKH = txtidkh.getText();
            String IDND = txtidnv.getText();
            double tongTien = 0;
            double magiamgia = Double.parseDouble(txtmgg.getText());
            double Tongtiensaugiamgia = 0;
            String IDcheck = String.valueOf(tblhd.getValueAt(currentRowHD, 0));
            if(ID.isEmpty() || tgian.isEmpty() || IDKH.isEmpty() || IDND.isEmpty() || IDcheck.isEmpty()){
                JOptionPane.showMessageDialog(this, "Có lỗi trg lúc thay");
            }
            else{
                boolean rs = BHdao.updateHD(ID, tgian, IDKH, IDND, tongTien, magiamgia, Tongtiensaugiamgia, IDcheck);
                System.out.println(rs);
                if(rs){
                    displayHD();
                    modelcthd.setRowCount(0);
                    JOptionPane.showMessageDialog(this, "Thay thành công");
                }
            }
        }
        catch(HeadlessException | NumberFormatException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btnthaydoiHDActionPerformed

    private void tblhdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblhdMouseClicked
        currentRowHD = tblhd.getSelectedRow();
        String ID = String.valueOf(tblhd.getValueAt(currentRowHD, 0));
        String tgian = String.valueOf(tblhd.getValueAt(currentRowHD, 1));
        String IDKH = String.valueOf(tblhd.getValueAt(currentRowHD, 2));
        String IDND = String.valueOf(tblhd.getValueAt(currentRowHD, 3));
        String magiamgia = String.valueOf(hdList.get(currentRowHD).getMucGiamGia());
        txtidhd.setText(ID);
        txttgian.setText(tgian);
        txtidkh.setText(IDKH);
        txtidnv.setText(IDND);
        txtmgg.setText(magiamgia);
        displayCTHD(ID);
    }//GEN-LAST:event_tblhdMouseClicked

    private void btnxoaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaHDActionPerformed
        try{
            String ID = txtidhd.getText();
            if(ID.isEmpty()){
                JOptionPane.showMessageDialog(this, "Có lỗi trg lúc xóa");
            }
            else{
                boolean rs = BHdao.deleteHD(ID);
                if(rs){
                    displayHD();
                    modelcthd.setRowCount(0);
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                }
            }
        }
        catch(HeadlessException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_btnxoaHDActionPerformed

    private void btnthanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthanhtoanActionPerformed
        currentRowHD = tblhd.getSelectedRow();
        try{
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("HoaDon.pdf"));
            doc.open();

            doc.add(new Paragraph("Hóa Đơn Của : " + tblhd.getValueAt(currentRowHD, 2) + "\n"));
            doc.add(new Paragraph("Thời Gian : " + tblhd.getValueAt(currentRowHD, 1) + "\n"));

            PdfPTable table = new PdfPTable(4);
            table.addCell("Sản Phẩm");
            table.addCell("Số Lượng");
            table.addCell("Giá");
            table.addCell("Thành Tiền");

            for(int i = 0; i < tblcthd.getRowCount();i++){
                table.addCell(tblcthd.getValueAt(i, 1).toString());
                table.addCell(tblcthd.getValueAt(i, 2).toString());
                table.addCell(tblcthd.getValueAt(i, 3).toString());
                table.addCell(tblcthd.getValueAt(i, 4).toString());
            }

            doc.add(table);
            doc.close();
            JOptionPane.showMessageDialog(this, "Thanh Toán thành công");
        }
        catch(DocumentException | FileNotFoundException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Thanh Toán thất bại");
        }
    }//GEN-LAST:event_btnthanhtoanActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        currentRowSP = tblsp.getSelectedRow();
        currentRowHD = tblhd.getSelectedRow();
        if (currentRowHD != -1 && currentRowSP != -1) {
            try {
                String IDHD = String.valueOf(tblhd.getValueAt(currentRowHD, 0));
                String IDSP = String.valueOf(tblsp.getValueAt(currentRowSP, 0));
                System.out.println(IDSP);
                String IdCtHd = String.valueOf(txtidcthd.getText());
                int soluong = Integer.parseInt(txtsl.getText());
                double GiaBan = Double.parseDouble(String.valueOf(tblsp.getValueAt(currentRowSP, 2)));
                if (IdCtHd.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Ko có Id Hóa Đơn", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    boolean result = BHdao.addCTHD(IdCtHd, soluong, IDHD, IDSP, GiaBan);
                    if (result) {
                        displayCTHD(IDHD);
                        double thanhtien = 0;
                        for (int i = 0; i < tblcthd.getRowCount(); i++) {
                            thanhtien += Double.parseDouble((String.valueOf(tblcthd.getValueAt(i, 4))));
                        }
                        boolean result1 = BHdao.updateCTHD(thanhtien, IDHD);
                        if (result1) {
                            JOptionPane.showMessageDialog(this, "Thêm thành công");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm thất bại");
                    }
                }
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Lỗi khi tải về", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnaddActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        currentRowHD = tblhd.getSelectedRow();
        currentRowCTHD = tblcthd.getSelectedRow();
        try {
            if (currentRowCTHD != -1) {
                String IDHD = String.valueOf(tblhd.getValueAt(currentRowHD, 0));
                String ID = String.valueOf(tblcthd.getValueAt(currentRowCTHD, 1));
                boolean result = BHdao.deleteCTHD(IDHD, ID);
                if (result) {
                    displayCTHD(IDHD);
                    double thanhtien = 0;
                    for (int i = 0; i < tblcthd.getRowCount(); i++) {
                        thanhtien += Double.parseDouble((String.valueOf(tblcthd.getValueAt(i, 4))));
                    }
                    boolean result1 = BHdao.updateCTHD(thanhtien, IDHD);
                    if (result1) {
                        JOptionPane.showMessageDialog(this, "Xóa thành công");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thật bại");
                }
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Có lỗi trong lúc xóa");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        currentRowSP = tblsp.getSelectedRow();
        currentRowCTHD = tblcthd.getSelectedRow();
        currentRowHD = tblhd.getSelectedRow();
        try {
            if (currentRowCTHD != -1) {
                String ID = txtidcthd.getText();
                int sl = Integer.parseInt(txtsl.getText());
                String idsp = String.valueOf(tblsp.getValueAt(currentRowSP, 0));
                double gia = Double.parseDouble(String.valueOf(tblsp.getValueAt(currentRowSP, 2)));
                String IDCTHD = String.valueOf(tblcthd.getValueAt(currentRowCTHD, 0));
                String IDHD = String.valueOf((tblhd.getValueAt(currentRowHD, 0)));
                boolean result = BHdao.updateCTHD1(ID, sl, idsp, gia, IDCTHD);
                if (result) {
                    displayCTHD(IDHD);
                    double thanhtien = 0;
                    for (int i = 0; i < tblcthd.getRowCount(); i++) {
                        thanhtien += Double.parseDouble((String.valueOf(tblcthd.getValueAt(i, 4))));
                    }
                    boolean result1 = BHdao.updateCTHD(thanhtien, IDHD);
                    if (result1) {
                        JOptionPane.showMessageDialog(this, "Thêm thành công");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại");
                }
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btnupdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btntaoHD;
    private javax.swing.JButton btnthanhtoan;
    private javax.swing.JButton btnthaydoiHD;
    private javax.swing.JButton btnupdate;
    private javax.swing.JButton btnxoaHD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable tblcthd;
    private javax.swing.JTable tblhd;
    private javax.swing.JTable tblsp;
    private javax.swing.JTextField txtTongtien;
    private javax.swing.JTextField txtidcthd;
    private javax.swing.JTextField txtidhd;
    private javax.swing.JTextField txtidkh;
    private javax.swing.JTextField txtidnv;
    private javax.swing.JTextField txtmgg;
    private javax.swing.JTextField txtsl;
    private javax.swing.JTextField txttgian;
    // End of variables declaration//GEN-END:variables
}
