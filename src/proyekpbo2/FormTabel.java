package proyekpbo2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class FormTabel extends JInternalFrame {

    public static TabelModel tabelModel = new TabelModel();
    public static JButton update, delete, search;
    private JLabel dataTabel;
    private JScrollPane Scroller;
    private JButton tambah;
    private JTextField tNama, tTgl, tUmur;
    public JTable tabel;
    private Data vData;
    private int selected = 0;
    
    public FormTabel() {
        addComponents(getContentPane());
        actionTable();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void addComponents(Container pane) {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();

        dataTabel = new JLabel("Data Buku Alamat");
        dataTabel.setFont(new Font("Tahoma", 1, 24));
        cons.gridx = 0;
        cons.gridy = 0;
        cons.anchor = GridBagConstraints.CENTER;
        cons.gridwidth = 5;
        pane.add(dataTabel, cons);

        tabel = new JTable();
        tabel.setModel(tabelModel);
        Scroller = new JScrollPane(tabel);
        Scroller.setViewportView(tabel);
        cons.gridy = 1;
        cons.ipadx = 1200;
        cons.ipady = 450;
        cons.insets = new Insets(10, 0, 0, 0);
        pane.add(Scroller, cons);

        delete = new JButton("Delete");
        delete.setEnabled(false);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        cons.gridy = 2;
        cons.ipadx = 0;
        cons.ipady = 0;
        cons.gridwidth = 1;
        cons.anchor = GridBagConstraints.WEST;
        cons.insets = new Insets(10, 0, 10, 10);
        pane.add(delete, cons);

        update = new JButton("Update");
        update.setEnabled(false);
        update.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        cons.gridx = 1;
        pane.add(update, cons);

        tambah = new JButton("Tambah");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });
        cons.gridx = 2;
        pane.add(tambah, cons);

        search = new JButton("Search!");
        search.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                searchingActionPerfomed(evt);
            }
        });
        cons.gridx = 3;
        pane.add(search, cons);


        tNama = new JTextField();
        tNama.setBounds(121, 37, 189, 32);
        tNama.setForeground(Color.LIGHT_GRAY);
        tNama.setText("Search");
        tNama.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tNama.getText().equals("Search")) {
                    tNama.setText("");
                    tNama.setForeground(Color.BLACK);
                    repaint();
                    revalidate();
                }
            }
        });
        cons.gridx = 4;
        cons.ipadx = 100;
        pane.add(tNama, cons);

//        tTgl = new JTextField();
//        tTgl.setBounds(121, 37, 189, 32);
//        tTgl.setForeground(Color.LIGHT_GRAY);
//        tTgl.setText("Tanggal");
//        tTgl.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                if (tTgl.getText().equals("Tanggal")) {
//                    tTgl.setText("");
//                    tTgl.setForeground(Color.BLACK);
//                    repaint();
//                    revalidate();
//                }
//            }
//        });
//        cons.gridx = 5;
//        cons.ipadx = 100;
//        pane.add(tTgl, cons);
//
//        tUmur = new JTextField();
//        tUmur.setBounds(121, 37, 189, 32);
//        tUmur.setForeground(Color.LIGHT_GRAY);
//        tUmur.setText("Umur");
//        tUmur.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                if (tUmur.getText().equals("Umur")) {
//                    tUmur.setText("");
//                    tUmur.setForeground(Color.BLACK);
//                    repaint();
//                    revalidate();
//                }
//            }
//        });
//        cons.gridx = 6;
//        cons.ipadx = 100;
//        pane.add(tUmur, cons);
        pack();
    }

    private class HighlightRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            // everything as usual
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            // added behavior
            if (row == table.getSelectedRow()) {
                // this will customize that kind of border that will be use to highlight a row
                setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.BLACK));
            }
//            if (table.isCellSelected(row, column)) {
//                setForeground(Color.red);
//            } else if (table.isRowSelected(row)) {
//                setForeground(Color.green);
//            } else if (table.isColumnSelected(column)) {
//                setForeground(Color.blue);
//            } else {
//                setForeground(Color.black);
//            }
            return this;
        }
    }

    private void searchingActionPerfomed(java.awt.event.ActionEvent evt) {
        setOpaque(true);
        tabel.clearSelection();
        String valueN = tNama.getText();
//        String valueT = tTgl.getText();
//        String valueU = tUmur.getText();
        tabel.setCellSelectionEnabled(true);
        for (int row = 0; row <= tabel.getRowCount() - 1; row++) {
            for (int col = 0; col <= tabel.getColumnCount() - 1; col++) {
                if (valueN.equals(tabel.getValueAt(row, col))) {

                    // this will automatically set the view of the scroll in the location of the value
                    tabel.scrollRectToVisible(tabel.getCellRect(row, 0, true));

                    // this will automatically set the focus of the searched/selected row/value
                    tabel.setRowSelectionInterval(row, row);

                    for (int i = 0; i <= tabel.getColumnCount() - 1; i++) {
                        tabel.getColumnModel().getColumn(col).setCellRenderer(new HighlightRenderer());
                    }
                }
            }
        }
    }

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {
        Add_UpDialog p = new Add_UpDialog();
        p.setVisible(true);
    }

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {
        Add_UpDialog p = new Add_UpDialog();
        p.id.setForeground(Color.BLACK);
        p.nama.setForeground(Color.BLACK);
        p.kel.setForeground(Color.BLACK);
        p.tl.setForeground(Color.BLACK);
        p.tLd.setForeground(Color.BLACK);
        p.tLm.setForeground(Color.BLACK);
        p.tLy.setForeground(Color.BLACK);
        p.almt.setForeground(Color.BLACK);
        p.tlp.setForeground(Color.BLACK);
        p.email.setForeground(Color.BLACK);
        p.job.setForeground(Color.BLACK);
        p.pers.setForeground(Color.BLACK);
        p.ket.setForeground(Color.BLACK);
        p.id.setText(vData.getNoId());
        p.nama.setText(vData.getNama());
        p.kel.setSelectedItem(vData.getjKel());
        p.tl.setText(vData.getTempatLahir());
        p.tLd.setText(vData.getHariTanggalLahir());
        p.tLm.setText(vData.getBulanTanggalLahir());
        p.tLy.setText(vData.getTahunTanggalLahir());
        p.almt.setText(vData.getAlamat());
        p.tlp.setText(vData.getNoTlp());
        p.email.setText(vData.getEmail());
        p.job.setText(vData.getPekerjaan());
        p.pers.setText(vData.getNamaPers());
        p.ket.setText(vData.getKeterangan());
        p.up.setEnabled(true);
        p.save.setEnabled(false);
        Add_UpDialog.rowTabel = selected;
        p.setVisible(true);
    }

    private void deleteActionPerformed(ActionEvent evt) {
        tabelModel.removeData(selected);
    }

    private void actionTable() {
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }

            private void tableMouseClicked(MouseEvent evt) {
                update.setEnabled(true);
                delete.setEnabled(true);
                selectData();
            }
        });
    }

    void selectData() {
        selected = tabel.getSelectedRow();
        if (selected != -1) {
            vData = tabelModel.getData(selected);

        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormTabel().setVisible(true);
            }
        });
    }
}
