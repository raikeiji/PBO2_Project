//program cobacoba menggunakan submenu dengan tambahan icon-icon, toolbar
//made by rai keiji
package proyekpbo2;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Rai Keiji
 */
//JMenuItem < JMenu < JMenuBar
//imageicon < JButton < JToolBar < Panel
public class Buku_Alamat extends JFrame {

    private JLabel statusbar;
    private JTextField data;
    private JPopupMenu menu;
    private Toolkit toolkit;
//    TabelModel tm = new TabelModel();
//    FormTabel ft = new FormTabel();

    public Buku_Alamat() {
        initUI();
    }

    private void initUI() {
        JToolBar toolbar1 = new JToolBar();
        setDesign();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        //show vertically

        JMenuBar menubar = new JMenuBar();
        //<editor-fold defaultstate="collapsed" desc="imageicon">
        ImageIcon iconNew = new ImageIcon("image/new.png");
        ImageIcon iconOpen = new ImageIcon("image/open.png");
        ImageIcon iconSave = new ImageIcon("image/save.png");
        ImageIcon iconExit = new ImageIcon("image/exit.png");
        ImageIcon iconaboutus = new ImageIcon("image/about.png");
        //</editor-fold>
        // ImageIcon iconimport=new ImageIcon("image/download.png");

        //<editor-fold defaultstate="collapsed" desc="JMenu">
        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        JMenu view = new JMenu("View");
        view.setMnemonic(KeyEvent.VK_V);
        JMenu helpmenu = new JMenu("Help");
        helpmenu.setMnemonic(KeyEvent.VK_H);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="JButton">
        JButton newb = new JButton(iconNew);
        newb.setToolTipText("Add a New Data");
        newb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Add_UpDialog a = new Add_UpDialog();
                a.setVisible(true);
            }
        });

        JButton openb = new JButton(iconOpen);
        openb.setToolTipText("Open File In Directory");

        JButton saveb = new JButton(iconSave);
        saveb.setToolTipText("Save File In Directory");
        saveb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    BufferedWriter bfw = new BufferedWriter(new FileWriter("ContactInfo.txt"));
                    for (int i = 0; i < FormTabel.tabelModel.getRowCount(); i++) {
                        for (int j = 0; j < FormTabel.tabelModel.getColumnCount(); j++) {
                            bfw.newLine();
                            bfw.write((String) (FormTabel.tabelModel.getValueAt(i, j)));
                            bfw.write("\t");
                        }
                    }
                    bfw.close();
                    JOptionPane.showMessageDialog(null, "Data Tersimpan", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton exitb = new JButton(iconExit);
        exitb.setToolTipText("Exit The Program");
        exitb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="implement toolbar">
        toolbar1.add(newb);

        toolbar1.add(openb);

        toolbar1.add(saveb);

        toolbar1.add(exitb);

        toolbar1.setAlignmentX(0); //The toolbar is left aligned.
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="JCheckBox">
        JCheckBoxMenuItem sbar = new JCheckBoxMenuItem("Show Statusbar");

        sbar.setState(true);
        sbar.setToolTipText("Check Button for Statusbar");
        sbar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (statusbar.isVisible()) {
                    statusbar.setVisible(false);
                } else {
                    statusbar.setVisible(true);
                }
            }
        });
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="JManuItem for file">
        JMenuItem filenew = new JMenuItem("Add", iconNew);
        filenew.setMnemonic(KeyEvent.VK_N);
        filenew.setToolTipText("Add a new data");
        filenew.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Add_UpDialog a = new Add_UpDialog();
                        a.setVisible(true);
                    }
                });

        JMenuItem fileopen = new JMenuItem("Open", iconOpen);
        fileopen.setMnemonic(KeyEvent.VK_O);
        fileopen.setToolTipText("Open a File in Directory");
        fileopen.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                load();
            }
        });

        JMenuItem filesave = new JMenuItem("Save", iconSave);
        filesave.setMnemonic(KeyEvent.VK_S);
        filesave.setToolTipText("Save a File");
        filesave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BufferedWriter bfw = new BufferedWriter(new FileWriter("ContactInfo.txt"));
                    for (int i = 0; i < FormTabel.tabelModel.getRowCount(); i++) {
                        for (int j = 0; j < FormTabel.tabelModel.getColumnCount(); j++) {
                            bfw.newLine();
                            bfw.write((String) (FormTabel.tabelModel.getValueAt(i, j)));
                            bfw.write("\t");
                        }
                    }
                    bfw.close();
                    JOptionPane.showMessageDialog(null, "Data Tersimpan", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JMenuItem fileexit = new JMenuItem("Exit", iconExit);
        fileexit.setMnemonic(KeyEvent.VK_E);
        fileexit.setToolTipText("Exit Apllication");
        fileexit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        fileexit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        JMenuItem aboutusitem = new JMenuItem("About Us", iconaboutus);
        aboutusitem.setMnemonic(KeyEvent.VK_A);
        aboutusitem.setToolTipText("Siapakah Pengembang dari Software ini?");
        aboutusitem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                AboutUS a = new AboutUS();
                a.setVisible(true);
            }
        });
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="implement file and view in menubar">
        file.add(filenew);
        file.add(fileopen);
        file.add(filesave);
        file.addSeparator();
        file.addSeparator();
        file.add(fileexit);
        view.add(sbar);
        helpmenu.add(aboutusitem);
        menubar.add(file);
        menubar.add(view);
        menubar.add(helpmenu);
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="PopupMenu (beep and close)">
        toolkit = this.getToolkit();
        menu = new JPopupMenu();

        JMenuItem newmenu = new JMenuItem("New");
        newmenu.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Add_UpDialog a = new Add_UpDialog();
                        a.setVisible(true);
                    }
                });

        JMenuItem menuopen = new JMenuItem("Open");
        menuopen.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            BufferedReader in = new BufferedReader(new FileReader("ContactInfo.txt"));
                            List record = new ArrayList();
                            String line;
                            while (((line = in.readLine()) != null)) {
                                line.split("\t");
                            }
                            System.out.println(record);
                        } catch (Exception ex) {
                        }
//                try {
//                    String data[] = new String[2];
//                    Data vd = new Data();
//                    BufferedReader bfw = new BufferedReader(new FileReader("ContactInfo.txt"));
//                    String line;
//                    while ((line = bfw.readLine()) != null) {
//                        data[2]= vd.setNoId(line.split("\t"));
//                    }
//                    bfw.close();
//                } catch (Exception ex) {
//                }
                    }
                });
        JMenuItem menusave = new JMenuItem("Save");

        menusave.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            BufferedWriter bfw = new BufferedWriter(new FileWriter("ContactInfo.txt"));
                            for (int i = 0; i < FormTabel.tabelModel.getRowCount(); i++) {
                                for (int j = 0; j < FormTabel.tabelModel.getColumnCount(); j++) {
                                    bfw.write((String)(FormTabel.tabelModel.getValueAt(i, j)));
                                    bfw.write("\t");
                                    bfw.newLine();
                                }
                            }
                            bfw.close();
                            JOptionPane.showMessageDialog(null, "Data Tersimpan", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });

        JMenuItem closetombol = new JMenuItem("Exit");

        closetombol.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
        menu.add(newmenu);

        menu.add(menuopen);

        menu.add(menusave);

        menu.add(closetombol);

        this.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            menu.show(e.getComponent(), e.getX(), e.getY());
                        }
                    }
                });
        //</editor-fold>
        panel.add(toolbar1);
        add(panel, BorderLayout.NORTH);
        setJMenuBar(menubar);
        statusbar = new JLabel("Program ini merupakan rancangan dari program Buku Alamat");
        statusbar.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        add(statusbar, BorderLayout.SOUTH);
        setTitle("Rancangan Program Buku Alamat");
        setSize(1280, 720);
        FormTabel formT = new FormTabel();
        formT.setVisible(true);
        add(formT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
//    String d[] = new String[12];
    String d = "";

    public void load() {
        try {
            BufferedReader bfr = new BufferedReader(new FileReader("ContactInfo.txt"));
            Data vd = new Data();

//            for (int i = 0; i < FormTabel.tabelModel.getRowCount(); i++) {
            for (int j = 0; j < FormTabel.tabelModel.getColumnCount(); j++) {
                d = ""+bfr.readLine().split("\t");
//                    while(d!=null){
                if (j == 0) {
                    vd.setNoId(d);
                }
                if (j == 1) {
                    vd.setNama(d);
                }
                if (j == 2) {
                    vd.setjKel(d);
                }
                if (j == 3) {
                    vd.setTempatLahir(d);
                }
//                if (j == 4) {
//                    vd.s(d[j]);
//                }
                
//                dispose();
//                            FormTabel.tabelModel.setData(j, vd);
//                            bfw.write((String) (FormTabel.tabelModel.getValueAt(i, j)));
//                    }
            }
//            }
            FormTabel.tabelModel.addData(vd);
            bfr.close();
            JOptionPane.showMessageDialog(null, "Data Sukses Dibuka", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
//<editor-fold defaultstate="collapsed" desc="UI Design">

    public final void setDesign() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="main program">
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                Buku_Alamat ex = new Buku_Alamat();
                ex.setVisible(true);
            }
        });
    }
    //</editor-fold>
}
