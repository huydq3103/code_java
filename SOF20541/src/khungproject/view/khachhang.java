/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package khungproject.view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import khungpoject.service.Igiohang;
import khungpoject.service.Ihoadon;
import khungpoject.service.IsanPham;
import khungproject.model.chitietSP;
import khungproject.model.giohang;
import khungproject.model.giohangCT;
import khungproject.model.hoadonHT;
import khungproject.model.hoadonchitiet;
import khungproject.model.sanPham;
import khungproject.repository.hoadonRepo;
import khungproject.service.impl.SPservice;
import khungproject.service.impl.giohangCTservice;
import khungproject.service.impl.hoadonservice;
import viewmodel.hoadonchitietVIEW;

/**
 *
 * @author Hp
 */
public class khachhang extends javax.swing.JFrame {

    public khachhang() {
        initComponents();
        setLocationRelativeTo(null);
        loadTable(ql.getlist());
        setTitle("KHACH HANG");

        hoadonHT ht = new hoadonHT();
        txtMAHD.setText(ht.getMahd());
        txtNGAYTAO.setText(ht.getNgay());
        txtTENNV.setText(ht.getTenv());

    }

    IsanPham ql = new SPservice();
    Ihoadon hd = new hoadonservice();
    Igiohang gh = new giohangCTservice();
    ArrayList<hoadonchitietVIEW> list = new ArrayList<>();

    private void loadTable(ArrayList<chitietSP> list) {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"STT", "Mã SP", "Tên SP", "Năm BH", "Mô tả", "SL Còn", "Giá nhập", "Giá bán"});
        int index = tblbang1.getSelectedRow() + 2;

        for (chitietSP sp : list) {
            model.addRow(new Object[]{index++, sp.getSp().getMa(),
                sp.getSp().getTen(), sp.getNamBH(),
                sp.getMoTa(), sp.getSoLuongTon(),
                sp.getGiaNHap(), sp.getGiaBan()});

        }
        tblbang1.setModel(model);
    }

    private void loadTable2(ArrayList<hoadonchitietVIEW> list) {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã SP", "Tên SP",
            "SL", "Đơn giá", "Thành tiền"});
        double tongtien = 0;
        for (hoadonchitietVIEW gh : list) {
            model.addRow(new Object[]{gh.getMasp(), gh.getTenSp(), gh.getSoLuong(),
                gh.getDonGia(), gh.tongtien()});

            tongtien += gh.tongtien();
        }
        txtTongtien.setText(String.valueOf(tongtien));

        tblbang2.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbang1 = new javax.swing.JTable();
        btnTHEm = new javax.swing.JButton();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        txtTongtien = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMAHD = new javax.swing.JTextField();
        txtNGAYTAO = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTENNV = new javax.swing.JTextField();
        txtTIENKHACHDUA = new javax.swing.JTextField();
        txtTIENFTHUA = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblbang2 = new javax.swing.JTable();
        btnthanhtoan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 137, Short.MAX_VALUE)
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
        );

        tblbang1.setModel(new javax.swing.table.DefaultTableModel(
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
        tblbang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbang1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblbang1);

        btnTHEm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/shopping-cart.png"))); // NOI18N
        btnTHEm.setText("Thêm vào giỏ hàng");
        btnTHEm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTHEmActionPerformed(evt);
            }
        });

        jLayeredPane2.setLayer(jLayeredPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(btnTHEm, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGap(403, 403, 403)
                        .addComponent(btnTHEm)
                        .addGap(365, 365, 365))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jLayeredPane3))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addGap(0, 69, Short.MAX_VALUE)
                .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTHEm)
                .addGap(37, 37, 37))
        );

        jTabbedPane1.addTab("Danh sách sản phẩm", jLayeredPane2);

        jLayeredPane5.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin hóa đơn"));

        jLabel1.setText("Tổng tiền");

        jLabel3.setText("Ngày tạo");

        jLabel4.setText("Tên NV");

        txtMAHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMAHDActionPerformed(evt);
            }
        });

        jLabel6.setText("Tiền khách đưa");

        txtTIENKHACHDUA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtTIENKHACHDUAMouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtTIENKHACHDUAMouseReleased(evt);
            }
        });

        txtTIENFTHUA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtTIENFTHUAMouseEntered(evt);
            }
        });

        jLabel7.setText("Tiền thừa");

        jLabel8.setText("MÃ HD");

        jLayeredPane5.setLayer(txtTongtien, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(txtMAHD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(txtNGAYTAO, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(txtTENNV, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(txtTIENKHACHDUA, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(txtTIENFTHUA, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane5Layout = new javax.swing.GroupLayout(jLayeredPane5);
        jLayeredPane5.setLayout(jLayeredPane5Layout);
        jLayeredPane5Layout.setHorizontalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane5Layout.createSequentialGroup()
                        .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTIENFTHUA, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTIENKHACHDUA, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTongtien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)))
                    .addGroup(jLayeredPane5Layout.createSequentialGroup()
                        .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTENNV, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMAHD, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNGAYTAO, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(23, 23, 23))
        );
        jLayeredPane5Layout.setVerticalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane5Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTENNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(35, 35, 35)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane5Layout.createSequentialGroup()
                        .addComponent(txtMAHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)))
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNGAYTAO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(36, 36, 36)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTongtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTIENKHACHDUA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTIENFTHUA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(63, 63, 63))
        );

        tblbang2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblbang2);

        btnthanhtoan.setText("THANH TOÁN");
        btnthanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthanhtoanActionPerformed(evt);
            }
        });

        jLayeredPane4.setLayer(jLayeredPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(btnthanhtoan, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLayeredPane5)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnthanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125))))
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addComponent(jLayeredPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnthanhtoan)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Giỏ hàng", jLayeredPane4);

        jLayeredPane1.setLayer(jTabbedPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addGap(50, 50, 50))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1)
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
int index = 0;
    private void btnTHEmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTHEmActionPerformed
        hoadonchitietVIEW hoadonchitietview = new hoadonchitietVIEW();
       
        if (tblbang1.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "vui long chon san pham");
            return;
        }

        try {
            int i = tblbang1.getSelectedRow();
            String ma = tblbang1.getValueAt(i, 1).toString();
            String tenSP = tblbang1.getValueAt(i, 2).toString();
            double dongia = Double.parseDouble(tblbang1.getValueAt(i, 7).toString());
            hoadonchitietview.setTenSp(tenSP);
            hoadonchitietview.setMasp(ma);
            hoadonchitietview.setDonGia(dongia);
            
            
            int sl1 = Integer.parseInt(JOptionPane.showInputDialog(this, "vui long nhap so luong"));
            if (sl1 <= 0) {
                return;
            } else {
                hoadonchitietview.setSoLuong(sl1);
            }
            for (hoadonchitietVIEW hdct : list) {// tao them nut cap nhap
                if (hdct.getMasp().equals(ma)) {
                    JOptionPane.showMessageDialog(this, "san pham da ton tai");
                    return;
                }
            }
            list.add(hoadonchitietview);
            chitietSP ctsp = new chitietSP();
            int soluongton = Integer.parseInt(tblbang1.getValueAt(i, 5).toString())
                    - sl1;
            if (soluongton < sl1 || soluongton < 0) {
                JOptionPane.showMessageDialog(this, "vui long nhap so luong <= so luong ton");
                return;
            } else {
                ctsp.setSoLuongTon(soluongton);
                ql.updateSLSP(ctsp, ma);
                loadTable(ql.getlist());
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "so luong phai la so", "loi", JOptionPane.ERROR_MESSAGE);
            return;
        }
       


        loadTable2(list);


    }//GEN-LAST:event_btnTHEmActionPerformed

    private void tblbang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbang1MouseClicked


    }//GEN-LAST:event_tblbang1MouseClicked


    private void txtTIENKHACHDUAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTIENKHACHDUAMouseEntered

    }//GEN-LAST:event_txtTIENKHACHDUAMouseEntered

    private void txtTIENKHACHDUAMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTIENKHACHDUAMouseReleased

    }//GEN-LAST:event_txtTIENKHACHDUAMouseReleased

    private void txtTIENFTHUAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTIENFTHUAMouseEntered
        try {
            double tienthua = 0;
            if (txtTIENKHACHDUA.getText().isEmpty()) {
                return;
            } else {

                tienthua = (Double.parseDouble(txtTongtien.getText())) - Double.parseDouble(txtTIENKHACHDUA.getText());
                txtTIENFTHUA.setText(String.valueOf(tienthua));
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "vui long nhap so");
        }
    }//GEN-LAST:event_txtTIENFTHUAMouseEntered

    private void btnthanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthanhtoanActionPerformed
        ArrayList<hoadonchitiet> listHdCT = new ArrayList<>();
        if (txtMAHD.getText().isEmpty() || txtNGAYTAO.getText().isEmpty() || txtTENNV.getText().isEmpty() || list.isEmpty()) {
            return;
        }
        for (hoadonchitietVIEW hoadonchitietview : list) {
            hoadonchitiet hoaDonChiTiet = new hoadonchitiet();
            hoaDonChiTiet.setSoLuong(hoadonchitietview.getSoLuong());
            hoaDonChiTiet.setDonGia(hoadonchitietview.getDonGia());
            hoaDonChiTiet.setIdHoaDon(txtMAHD.getText());
            hoaDonChiTiet.setIdSanPham(hoadonchitietview.getMasp());
            listHdCT.add(hoaDonChiTiet);
        }

        for (hoadonchitiet hoaDonChiTiet : listHdCT) {
            hd.saveHDCT(hoaDonChiTiet, txtMAHD.getText(), hoaDonChiTiet.getIdSanPham());

        }
        

        JOptionPane.showMessageDialog(this, "thanh toan thanh cong");
        hd.updateHD(txtMAHD.getText());

    }//GEN-LAST:event_btnthanhtoanActionPerformed

    private void txtMAHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMAHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMAHDActionPerformed

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
            java.util.logging.Logger.getLogger(khachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(khachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(khachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(khachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new khachhang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTHEm;
    private javax.swing.JButton btnthanhtoan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblbang1;
    private javax.swing.JTable tblbang2;
    private javax.swing.JTextField txtMAHD;
    private javax.swing.JTextField txtNGAYTAO;
    private javax.swing.JTextField txtTENNV;
    private javax.swing.JTextField txtTIENFTHUA;
    private javax.swing.JTextField txtTIENKHACHDUA;
    private javax.swing.JTextField txtTongtien;
    // End of variables declaration//GEN-END:variables
}
