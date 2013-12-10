package proyekpbo2;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;


public class SearchingMenu1 extends JFrame {
    
    private JPanel contentPane;
    private JTextField tNama;
    private JLabel lbltitik1;
    private JLabel lbltitik2;
    private JTextField tAge;
    private JTextField tMonth;
    private JTextField tYear;
    private JTextField tDay;
//        private JTable jt;
    TabelModel tm = new TabelModel();
    FormTabel ft = new FormTabel();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    SearchingMenu1 frame = new SearchingMenu1();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public SearchingMenu1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 363, 308);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNama = new JLabel("Nama");
        lblNama.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNama.setBounds(38, 35, 77, 32);
        contentPane.add(lblNama);
        
        JLabel labelTgl = new JLabel("Tanggal");
        labelTgl.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelTgl.setBounds(38, 95, 77, 32);
        contentPane.add(labelTgl);
        
        JLabel labelUmur = new JLabel("Umur");
        labelUmur.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelUmur.setBounds(38, 150, 77, 32);
        contentPane.add(labelUmur);
        
        tNama = new JTextField();
        tNama.setBounds(121, 37, 189, 32);
        contentPane.add(tNama);
        tNama.setColumns(10);
        
        JButton btnSearch = new JButton("Search!");
        btnSearch.setBounds(209, 152, 101, 32);
        contentPane.add(btnSearch);
        
        lbltitik1 = new JLabel(":");
        lbltitik1.setBounds(110, 46, 46, 14);
        contentPane.add(lbltitik1);
        
        lbltitik2 = new JLabel(":");
        lbltitik2.setBounds(110, 106, 46, 14);
        contentPane.add(lbltitik2);
        
        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(209, 202, 101, 32);
        contentPane.add(btnCancel);
        
        JLabel lbltitik3 = new JLabel(":");
        lbltitik3.setBounds(110, 161, 46, 14);
        contentPane.add(lbltitik3);
        
        tAge = new JTextField();
        tAge.setColumns(10);
        tAge.setBounds(121, 152, 46, 32);
        contentPane.add(tAge);
        
        tMonth = new JTextField();
        tMonth.setColumns(10);
        tMonth.setBounds(192, 95, 46, 32);
        contentPane.add(tMonth);
        
        tYear = new JTextField();
        tYear.setColumns(10);
        tYear.setBounds(264, 95, 46, 32);
        contentPane.add(tYear);
        
        tDay = new JTextField();
        tDay.setColumns(10);
        tDay.setBounds(121, 95, 46, 32);
        contentPane.add(tDay);
        
        ft.tabel.setColumnSelectionAllowed(true);
        ft.tabel.setRowSelectionAllowed(true);
        
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
//        btnSearch.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                String value = tNama.getText(); 
//                String value = "echo";
//                for (int row = 0; row <= ft.tabel.getRowCount() - 1; row++) {
//                    for (int col = 0; col <= ft.tabel.getColumnCount() - 1; col++) {
//                        if (value.equals(ft.tabel.getValueAt(row, col))) {
//
//                            // this will automatically set the view of the scroll in the location of the value
//                            ft.tabel.scrollRectToVisible(ft.tabel.getCellRect(row, 0, true));
//
//                            // this will automatically set the focus of the searched/selected row/value
//                            ft.tabel.setRowSelectionInterval(row, row);
//                            
//                             
//                            for (int i = 0; i <= ft.tabel.getColumnCount() - 1; i++) {
//                                System.out.println("row :"+row);
//                                ft.tabel.getColumnModel().getColumn(i).setCellRenderer(new HighlightRenderer());
//                            }
//                        }
//                    }
//                }
//            }
//        });
//    }
    
//    private class HighlightRenderer extends DefaultTableCellRenderer {
//        
//        @Override
//        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//            // everything as usual
//            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//            // added behavior
//            if (row == table.getSelectedRow()) {
//                // this will customize that kind of border that will be use to highlight a row
//                setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.BLACK));
//            }
//            return this;
//        }
    }
}
