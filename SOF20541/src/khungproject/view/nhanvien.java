/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package khungproject.view;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import khungpoject.service.Ihoadon;
import khungpoject.service.Inhanvien;
import khungpoject.service.IsanPham;
import khungproject.model.NSX;
import khungproject.model.chitietSP;
import khungproject.model.chucvu;
import khungproject.model.dongSP;
import khungproject.model.sanPham;
import khungproject.repository.sanphamRepo;
import khungproject.service.impl.SPservice;
import khungproject.service.impl.hoadonservice;
import khungproject.model.hoadon;
import khungproject.model.hoadonHT;
import khungproject.model.mausac;
import khungproject.model.nhanvienmodel;
import khungproject.service.impl.nhanvienservice;
import viewmodel.sanphamViewmodel;

/**
 *
 * @author Hp
 */
public class nhanvien extends javax.swing.JFrame {

    public nhanvien() {
        initComponents();
        loadTable(ql.getALL());
        jlbMA.setVisible(false);
        jlbHo.setVisible(false);
        jlbTEN.setVisible(false);
        jlbTENDEM.setVisible(false);
        jlbdiachi.setVisible(false);
        jlbngaysinh.setVisible(false);
        jlbsdt.setVisible(false);
        jlbemail.setVisible(false);
        jlbmatkhau.setVisible(false);

        setLocationRelativeTo(null);
        setTitle("NHAN VIEN");
        loadCBBNSX();
        loadDONGSP();
        loadMAU();
    }
    IsanPham ql = new SPservice();
    Ihoadon hd = new hoadonservice();
    Inhanvien nv = new nhanvienservice();

    private void loadTable(ArrayList<sanphamViewmodel> list) {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID", "Mã SP", "Tên SP", "Năm BH",
            "Mô tả", "SL Còn", "Giá nhập", "Giá bán", "Ten NSX", "MAU", "DONG SP"});

        for (sanphamViewmodel sp : list) {
            model.addRow(new Object[]{sp.getIdSp(), sp.getMaSP(), sp.getTenSP(),
                sp.getNamBH(),
                sp.getMoTa(), sp.getSoLuongTon(),
                sp.getGiaNHap(), sp.getGiaBan(), sp.getTenNSX(), sp.getMausac(), sp.getTenDONGSP()});
        }
        tblbang.setModel(model);
    }

    private void loadTableHD(ArrayList<hoadon> list) {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"STT", "Mã HD", "Ngày Tạo", "Tên nv", "Tình trạng"});
        int index = tblbanghoadon.getSelectedRow() + 2;
        for (hoadon hd : list) {
            model.addRow(new Object[]{index++, hd.getMa(), hd.getNgayTao(), hd.getNv().getTen(), hd.tinhtrang()});
        }
        tblbanghoadon.setModel(model);
    }

    public boolean check() {
        try {
            if (Double.valueOf(txtgiaban.getText()) <= 0) {
                JOptionPane.showMessageDialog(this, "gia ban phai >0");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "gia ban phai la so ? Vui long nhap lai");
            return false;
        }

        try {
            if (Double.valueOf(txtgianhap.getText()) <= 0) {
                JOptionPane.showMessageDialog(this, "gia nhap phai >0");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "gia nhap phai la so? Vui long nhap lai");
            return false;
        }

        try {
            if (Integer.valueOf(txtnambh.getText()) < 0) {
                JOptionPane.showMessageDialog(this, " nam bao hanh  >=0");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "nam bao hanh phai la so? Vui long nhap lai");
            return false;
        }

        try {
            if (Integer.valueOf(txtsoluongton.getText()) < 0) {
                JOptionPane.showMessageDialog(this, "gia nhap phai >=0");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "so luong phai la so? Vui long nhap lai");
            return false;
        }

        return true;
    }

    private void loadtefiel(int i) {
        if (tblbang.getRowCount() > 0) {
            txtID.setText(tblbang.getValueAt(i, 0).toString());
            txtmasp.setText(tblbang.getValueAt(i, 1).toString());
            txttensp.setText(tblbang.getValueAt(i, 2).toString());
            txtnambh.setText(tblbang.getValueAt(i, 3).toString());
            txtmota.setText(tblbang.getValueAt(i, 4).toString());
            txtsoluongton.setText(tblbang.getValueAt(i, 5).toString());
            txtgianhap.setText(tblbang.getValueAt(i, 6).toString());
            txtgiaban.setText(tblbang.getValueAt(i, 7).toString());
            cbbNSX.setSelectedItem(tblbang.getValueAt(i, 8).toString());
            cbbMAU.setSelectedItem(tblbang.getValueAt(i, 9).toString());
            cbbDONGSP.setSelectedItem(tblbang.getValueAt(i, 10).toString());
        }
    }
    int index = 0;

    public String ht() {
        return (index + 1) + "/" + ql.getALL().size();
    }

    private void loadCBBNSX() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (String nsx : ql.listNSX()) {
            cbbNSX.addItem(nsx);
        }
    }

    private void loadDONGSP() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (String dsp : ql.listDONGSP()) {
            cbbDONGSP.addItem(dsp);
        }
    }

    private void loadMAU() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (String mau : ql.listMAU()) {
            cbbMAU.addItem(mau);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblbang = new javax.swing.JTable();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtmasp = new javax.swing.JTextField();
        txttensp = new javax.swing.JTextField();
        txtnambh = new javax.swing.JTextField();
        txtmota = new javax.swing.JTextField();
        txtsoluongton = new javax.swing.JTextField();
        txtgianhap = new javax.swing.JTextField();
        txtgiaban = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbbNSX = new javax.swing.JComboBox<>();
        cbbMAU = new javax.swing.JComboBox<>();
        cbbDONGSP = new javax.swing.JComboBox<>();
        txttimkiem = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btntruoc = new javax.swing.JButton();
        btnnext = new javax.swing.JButton();
        jlbht = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbanghoadon = new javax.swing.JTable();
        rdCho = new javax.swing.JRadioButton();
        rdALL = new javax.swing.JRadioButton();
        rdHUy = new javax.swing.JRadioButton();
        rdDATHANHTOAN = new javax.swing.JRadioButton();
        jButton5 = new javax.swing.JButton();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jlbMA = new javax.swing.JLabel();
        jlbTEN = new javax.swing.JLabel();
        jlbTENDEM = new javax.swing.JLabel();
        jlbHo = new javax.swing.JLabel();
        jlbngaysinh = new javax.swing.JLabel();
        jlbsdt = new javax.swing.JLabel();
        jlbdiachi = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txttendem = new javax.swing.JTextField();
        txtmatkhau = new javax.swing.JTextField();
        txtho = new javax.swing.JTextField();
        jlbmatkhau = new javax.swing.JLabel();
        txtngaysinh = new javax.swing.JTextField();
        jlbemail = new javax.swing.JLabel();
        txtsdt = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtdiachi = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtma = new javax.swing.JTextField();
        txtten = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        rdnam = new javax.swing.JRadioButton();
        rdnu = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane2.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane2.setName(""); // NOI18N

        tblbang.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblbang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblbang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblbang);

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel2.setText("Ma sp");

        jLabel3.setText("Ten SP");

        jLabel4.setText("Nam BH");

        jLabel5.setText("Mo Ta");

        jLabel6.setText("SL Con");

        jLabel7.setText("Gia nhap");

        jLabel8.setText("Gia ban");

        txttensp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttenspActionPerformed(evt);
            }
        });

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("ID");

        jLabel9.setText("Ten NSX");

        jLabel10.setText("Dong Sp");

        jLabel11.setText("Mau");

        cbbDONGSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbDONGSPActionPerformed(evt);
            }
        });

        txttimkiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txttimkiemMouseEntered(evt);
            }
        });

        jLabel12.setText("Tim kiếm");

        jLayeredPane2.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtmasp, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txttensp, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtnambh, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtmota, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtsoluongton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtgianhap, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtgiaban, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtID, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(cbbNSX, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(cbbMAU, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(cbbDONGSP, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txttimkiem, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txttensp))
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                                    .addComponent(txtmasp))))
                        .addGap(24, 24, 24))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                        .addComponent(cbbNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPane2Layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)))
                                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtgianhap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                            .addComponent(txtsoluongton, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtmota, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtgiaban)
                                            .addComponent(txtnambh, javax.swing.GroupLayout.Alignment.LEADING)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPane2Layout.createSequentialGroup()
                                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbbDONGSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbbMAU, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(21, 21, 21)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(12, 12, 12)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmasp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txttensp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnambh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsoluongton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(12, 12, 12)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtgianhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtgiaban))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbbMAU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbDONGSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        btntruoc.setText("Prev");
        btntruoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntruocActionPerformed(evt);
            }
        });

        btnnext.setText("Next");
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });

        jlbht.setText("    0/0");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logout.png"))); // NOI18N
        jButton4.setText("Log Out");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLayeredPane2, javax.swing.JLayeredPane.MODAL_LAYER);
        jLayeredPane1.setLayer(btntruoc, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnnext, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jlbht, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 253, Short.MAX_VALUE)
                .addComponent(btntruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jlbht, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnnext, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(475, 475, 475)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLayeredPane2)
                    .addComponent(jScrollPane2))
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btntruoc)
                            .addComponent(btnnext)
                            .addComponent(jlbht))
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jLayeredPane2.getAccessibleContext().setAccessibleParent(this);

        jTabbedPane2.addTab("Danh sách sản phẩm", jLayeredPane1);

        tblbanghoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblbanghoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbanghoadonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblbanghoadon);

        buttonGroup2.add(rdCho);
        rdCho.setText("Chờ thanh toán");
        rdCho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdChoMouseClicked(evt);
            }
        });

        buttonGroup2.add(rdALL);
        rdALL.setText("Tất cả");
        rdALL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdALLMouseClicked(evt);
            }
        });

        buttonGroup2.add(rdHUy);
        rdHUy.setText("Đã hủy");
        rdHUy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdHUyMouseClicked(evt);
            }
        });

        buttonGroup2.add(rdDATHANHTOAN);
        rdDATHANHTOAN.setText("Đã thanh toán");
        rdDATHANHTOAN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdDATHANHTOANMouseClicked(evt);
            }
        });

        jButton5.setText("Tạo hóa đơn");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLayeredPane3.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(rdCho, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(rdALL, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(rdHUy, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(rdDATHANHTOAN, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(rdCho)
                        .addGap(48, 48, 48)
                        .addComponent(rdALL, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(rdHUy, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdDATHANHTOAN))
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGap(387, 387, 387)
                        .addComponent(jButton5)))
                .addContainerGap(338, Short.MAX_VALUE))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdCho)
                    .addComponent(rdALL)
                    .addComponent(rdHUy)
                    .addComponent(rdDATHANHTOAN))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(38, 38, 38))
        );

        jTabbedPane2.addTab("Danh sách hóa đơn", jLayeredPane3);

        jlbMA.setForeground(new java.awt.Color(204, 0, 0));
        jlbMA.setText("jLabel10");

        jlbTEN.setForeground(new java.awt.Color(204, 0, 0));
        jlbTEN.setText("jLabel11");

        jlbTENDEM.setForeground(new java.awt.Color(204, 0, 0));
        jlbTENDEM.setText("jLabel12");

        jlbHo.setForeground(new java.awt.Color(204, 0, 0));
        jlbHo.setText("jLabel13");

        jlbngaysinh.setForeground(new java.awt.Color(204, 0, 0));
        jlbngaysinh.setText("jLabel14");

        jlbsdt.setForeground(new java.awt.Color(204, 0, 0));
        jlbsdt.setText("jLabel15");

        jlbdiachi.setForeground(new java.awt.Color(204, 0, 0));
        jlbdiachi.setText("jLabel16");

        jLabel13.setText("Email");

        jLabel14.setText("Mat Khau");

        txtho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthoActionPerformed(evt);
            }
        });

        jlbmatkhau.setForeground(new java.awt.Color(204, 0, 0));
        jlbmatkhau.setText("jLabel12");

        jlbemail.setForeground(new java.awt.Color(204, 0, 0));
        jlbemail.setText("jLabel13");

        jButton6.setText("Thêm nhân viên");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel15.setText("Dia Chi");

        jLabel17.setText("Ma");

        jLabel18.setText("Ten");

        jLabel19.setText("Ten Dem");

        jLabel20.setText("Ho");

        jLabel21.setText("Ngay Sinh");

        jLabel22.setText("SDT");

        jButton8.setText("Xóa");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("sửa");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdnam);
        rdnam.setText("Nam");

        buttonGroup1.add(rdnu);
        rdnu.setText("Nữ");

        jLabel16.setText("Giới Tính");

        jLayeredPane4.setLayer(jlbMA, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jlbTEN, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jlbTENDEM, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jlbHo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jlbngaysinh, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jlbsdt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jlbdiachi, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(txtemail, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(txttendem, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(txtmatkhau, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(txtho, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jlbmatkhau, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(txtngaysinh, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jlbemail, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(txtsdt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jButton6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(txtdiachi, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel17, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel18, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel19, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel20, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel21, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel22, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(txtma, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(txtten, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jButton8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jButton9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(rdnam, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(rdnu, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel16, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane4Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttendem, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtho, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbTENDEM, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbHo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbTEN, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbMA, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(rdnam)
                        .addGap(31, 31, 31)
                        .addComponent(rdnu)))
                .addGap(260, 260, 260))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(273, 273, 273)
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jlbdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jlbsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtemail)
                            .addComponent(jlbemail, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(213, 213, 213))
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jlbMA)
                                .addGap(13, 13, 13)
                                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18)))
                            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jlbsdt)
                                .addGap(18, 18, 18)
                                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlbTEN))
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jlbdiachi)))
                .addGap(1, 1, 1)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttendem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jlbTENDEM))
                            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlbHo))
                            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jlbemail)))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbngaysinh))
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdnam)
                            .addComponent(rdnu)
                            .addComponent(jLabel16))))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addComponent(jlbmatkhau)
                .addGap(60, 60, 60)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Quản lí nhân viên", jLayeredPane4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPane2.getAccessibleContext().setAccessibleName("");
        jTabbedPane2.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblbangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbangMouseClicked
        index = tblbang.getSelectedRow();
        loadtefiel(index);
        tblbang.setColumnSelectionInterval(index, index);
        jlbht.setText(ht());
    }//GEN-LAST:event_tblbangMouseClicked

    private void btntruocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntruocActionPerformed
        index--;
        if (index < 0) {
            index = ql.getlist().size() - 1;

            tblbang.setRowSelectionInterval(index, index);
            jlbht.setText(ht());
        } else {
            loadtefiel(index);
            jlbht.setText(ht());
            tblbang.setRowSelectionInterval(index, index);
        }
    }//GEN-LAST:event_btntruocActionPerformed

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
        index++;

        if (index == ql.getlist().size()) {

            index = 0;

            tblbang.setRowSelectionInterval(index, index);
            jlbht.setText(ht());

        } else {
            loadtefiel(index);
            jlbht.setText(ht());
            tblbang.setRowSelectionInterval(index, index);
        }
    }//GEN-LAST:event_btnnextActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dangnhap dn = new dangnhap();
        dn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void rdChoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdChoMouseClicked
        ArrayList<hoadon> list = hd.getlistHDCTT();
        loadTableHD(list);
    }//GEN-LAST:event_rdChoMouseClicked

    private void rdALLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdALLMouseClicked
        loadTableHD(hd.getlist());
    }//GEN-LAST:event_rdALLMouseClicked

    private void rdHUyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdHUyMouseClicked
        ArrayList<hoadon> list = hd.getlistHDDH();
        loadTableHD(list);
    }//GEN-LAST:event_rdHUyMouseClicked

    private void rdDATHANHTOANMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdDATHANHTOANMouseClicked
        ArrayList<hoadon> list = hd.getlistHDDTT();
        loadTableHD(list);
    }//GEN-LAST:event_rdDATHANHTOANMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        HOADONCREATE hd = new HOADONCREATE();
        hd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tblbanghoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbanghoadonMouseClicked
        hoadonHT ht = new hoadonHT();
        int i = tblbanghoadon.getSelectedRow();
        String mahd = tblbanghoadon.getValueAt(i, 1).toString();
        String tenv = tblbanghoadon.getValueAt(i, 3).toString();
        String ngay = tblbanghoadon.getValueAt(i, 2).toString();

        ht.setMahd(tblbanghoadon.getValueAt(i, 1).toString());
        ht.setNgay(tblbanghoadon.getValueAt(i, 2).toString());
        ht.setTenv(tblbanghoadon.getValueAt(i, 3).toString());
        khachhang kh = new khachhang();
        kh.setVisible(true);
        this.dispose();


    }//GEN-LAST:event_tblbanghoadonMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String idsp = txtID.getText();
        if (idsp.isEmpty()) {
            JOptionPane.showMessageDialog(this, "vui long chon san pham muon xoa ?");
            return;
        }
        if (ql.xoa(idsp)) { // xoa chi tiet san pham
            JOptionPane.showMessageDialog(this, "xoa thanh cong");
            loadTable(ql.getALL());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (check()) {
            String tenNSX = cbbNSX.getSelectedItem().toString();
            String MAu = cbbMAU.getSelectedItem().toString();
            String dongSp = cbbDONGSP.getSelectedItem().toString();
            sanPham sp = new sanPham();
            String id = txtID.getText();
            sp.setMa(txtmasp.getText());
            sp.setTen(txttensp.getText());
            if (ql.updateSP(sp, id)) {

            }
            chitietSP ctsp = new chitietSP();
            String ma = txtmasp.getText();
            ctsp.setNamBH(Integer.parseInt(txtnambh.getText()));
            ctsp.setSoLuongTon(Integer.parseInt(txtsoluongton.getText()));
            ctsp.setGiaBan(Double.parseDouble(txtgiaban.getText()));
            ctsp.setGiaNHap(Double.parseDouble(txtgianhap.getText()));
            ctsp.setMoTa(txtmota.getText());

            if (ql.updateCTSP(ctsp, id, tenNSX, MAu, dongSp)) {
                JOptionPane.showMessageDialog(this, "cap nhat thanh cong");
                loadTable(ql.getALL());
                return;
            } else {
                JOptionPane.showMessageDialog(this, "cap nhat khong thanh cong");
                return;
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public boolean checkDKNV() {
        if (txtma.getText().isEmpty()
                || txtten.getText().isEmpty()
                || txtdiachi.getText().isEmpty()
                || txtho.getText().isEmpty()
                || txtsdt.getText().isEmpty()
                || txttendem.getText().isEmpty()
                || txtngaysinh.getText().isEmpty()
                || txtemail.getText().isEmpty()
                || txtmatkhau.getText().isEmpty()) {
            jlbMA.setVisible(true);

            jlbHo.setVisible(true);
            jlbTEN.setVisible(true);
            jlbTENDEM.setVisible(true);
            jlbdiachi.setVisible(true);
            jlbngaysinh.setVisible(true);
            jlbsdt.setVisible(true);
            jlbemail.setVisible(true);
            jlbmatkhau.setVisible(true);
            jlbMA.setText("khong duoc de trong ma");
            jlbTEN.setText("khong duoc de trong ten");
            jlbHo.setText("khong duoc de trong ho");
            jlbTENDEM.setText("khong duoc de trong ten dem");
            jlbdiachi.setText("khong duoc de trong dai chi");
            jlbngaysinh.setText("khong duoc de trong ngay sinh");
            jlbsdt.setText("khong duoc de trong sdt");
            jlbemail.setText("khong duoc de trong email");
            jlbmatkhau.setText("khong duoc de trong mat khau");

            return false;
        }

        String regix3 = "(0[1-9]|1[0-9]|2[0-9]|3[0-1]|[1-9])/(0[1-9]|1[0-2]|[1-9])/([0-9]{4})";
        Pattern patter = Pattern.compile(regix3);
        Matcher matcher = patter.matcher(regix3);

        if (!txtngaysinh.getText().matches(regix3)) {
            JOptionPane.showMessageDialog(this, "khong dung dinh dang ngay");
            return false;
        }

        return true;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ArrayList<viewmodel.sanphamViewmodel> listSP = ql.getALL();
        if (check()) {
            String tenNSX = cbbNSX.getSelectedItem().toString();
            String MAu = cbbMAU.getSelectedItem().toString();
            String dongSp = cbbDONGSP.getSelectedItem().toString();
            sanPham sp = new sanPham();
            sp.setMa(txtmasp.getText());
            sp.setTen(txttensp.getText());
            for (sanphamViewmodel viewmodel : listSP) {
                if (viewmodel.getMaSP().equals(txtmasp.getText())) {
                    JOptionPane.showMessageDialog(this, "san pham da ton tai");
                    return;
                }
            }
            if (ql.themCT(sp)) {

            }

            chitietSP ct = new chitietSP();
            String ma = txtmasp.getText();
            ct.setNamBH(Integer.parseInt(txtnambh.getText()));
            ct.setSoLuongTon(Integer.parseInt(txtsoluongton.getText()));
            ct.setGiaBan(Double.parseDouble(txtgiaban.getText()));
            ct.setGiaNHap(Double.parseDouble(txtgianhap.getText()));
            ct.setMoTa(txtmota.getText());

            if (ql.them(ct, ma, tenNSX, MAu, dongSp)) {
                JOptionPane.showMessageDialog(this, "them thanh cong");
                loadTable(ql.getALL());
                return;
            } else {
                JOptionPane.showMessageDialog(this, "them khong thanh cong");
                return;
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txttenspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttenspActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttenspActionPerformed

    private void cbbDONGSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbDONGSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbDONGSPActionPerformed

    private void txttimkiemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txttimkiemMouseEntered
        String ten = txttimkiem.getText();
        if (ten.isEmpty()) {
            return;
        } else {
            ArrayList<sanphamViewmodel> list = ql.getListFind(ten);
            loadTable(list);
        }
    }//GEN-LAST:event_txttimkiemMouseEntered

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (checkDKNV()) {
            nhanvienmodel kh = new nhanvienmodel();
            String ma = txtma.getText();
            String sdt = txtsdt.getText();
            String tendem = txttendem.getText();
            String diachi = txtdiachi.getText();

            String ngaysinh = txtngaysinh.getText();
            kh.setNgaySinh(ngaysinh);

            String ho = txtho.getText();
            String email = txtemail.getText();
            String matkhau = txtmatkhau.getText();
            String ten = txtten.getText();
            String gt = "nu";
            if (rdnam.isSelected()) {
                gt = "nam";
            }
            kh.setGioiTinh(gt);
            kh.setDiaChi(diachi);
            kh.setEmail(email);
            kh.setSdt(sdt);

            kh.setTenDem(tendem);
            kh.setMatKhau(matkhau);
            kh.setHo(ho);
            kh.setMa(ma);

            kh.setTen(ten);
            chucvu cv = new chucvu();
            cv.setMa(ma);
            cv.setTen(ten);
            if (nv.them(cv)) {

            }

            if (nv.them(kh, ma)) {
                JOptionPane.showMessageDialog(this, "them nhan vien thanh cong");
                clear();
                return;
            } else {
                JOptionPane.showMessageDialog(this, "dang ki that bai");
                return;
            }

        }
    }//GEN-LAST:event_jButton6ActionPerformed
    private void clear() {
        txtdiachi.setText(" ");
        txtemail.setText(" ");
        txtho.setText(" ");
        txtma.setText(" ");
        txtmatkhau.setText(" ");
        txtngaysinh.setText(" ");
        txtten.setText(" ");
        txttendem.setText(" ");

    }
    private void txthoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthoActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String ma = txtma.getText();
        if (ma.isEmpty()) {
            return;
        }
        if (nv.xoa(ma)) {
            JOptionPane.showMessageDialog(this, "xoa thany cong");

        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        String ma = txtma.getText();
        if (checkDKNV()) {
            nhanvienmodel kh = new nhanvienmodel();

            String sdt = txtsdt.getText();
            String tendem = txttendem.getText();
            String diachi = txtdiachi.getText();

            String ngaysinh = txtngaysinh.getText();
            kh.setNgaySinh(ngaysinh);

            String ho = txtho.getText();
            String email = txtemail.getText();
            String matkhau = txtmatkhau.getText();
            String ten = txtten.getText();
            String gt = "nu";
            if (rdnam.isSelected()) {
                gt = "nam";
            }
            kh.setGioiTinh(gt);
            kh.setDiaChi(diachi);
            kh.setEmail(email);
            kh.setSdt(sdt);

            kh.setTenDem(tendem);
            kh.setMatKhau(matkhau);
            kh.setHo(ho);
            kh.setMa(ma);

            kh.setTen(ten);

            if (nv.update(kh, ma)) {
                JOptionPane.showMessageDialog(this, "sua nhan vien thanh cong");
                clear();
                return;
            } else {
                JOptionPane.showMessageDialog(this, "sua ki that bai");
                return;
            }

        }
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(nhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nhanvien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnnext;
    private javax.swing.JButton btntruoc;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JComboBox<String> cbbDONGSP;
    private javax.swing.JComboBox<String> cbbMAU;
    private javax.swing.JComboBox<String> cbbNSX;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel jlbHo;
    private javax.swing.JLabel jlbMA;
    private javax.swing.JLabel jlbTEN;
    private javax.swing.JLabel jlbTENDEM;
    private javax.swing.JLabel jlbdiachi;
    private javax.swing.JLabel jlbemail;
    private javax.swing.JLabel jlbht;
    private javax.swing.JLabel jlbmatkhau;
    private javax.swing.JLabel jlbngaysinh;
    private javax.swing.JLabel jlbsdt;
    private javax.swing.JRadioButton rdALL;
    private javax.swing.JRadioButton rdCho;
    private javax.swing.JRadioButton rdDATHANHTOAN;
    private javax.swing.JRadioButton rdHUy;
    private javax.swing.JRadioButton rdnam;
    private javax.swing.JRadioButton rdnu;
    private javax.swing.JTable tblbang;
    private javax.swing.JTable tblbanghoadon;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtgiaban;
    private javax.swing.JTextField txtgianhap;
    private javax.swing.JTextField txtho;
    private javax.swing.JTextField txtma;
    private javax.swing.JTextField txtmasp;
    private javax.swing.JTextField txtmatkhau;
    private javax.swing.JTextField txtmota;
    private javax.swing.JTextField txtnambh;
    private javax.swing.JTextField txtngaysinh;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txtsoluongton;
    private javax.swing.JTextField txtten;
    private javax.swing.JTextField txttendem;
    private javax.swing.JTextField txttensp;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables
}
