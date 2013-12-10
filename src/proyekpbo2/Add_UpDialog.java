/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyekpbo2;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Echo
 */
public class Add_UpDialog extends JDialog implements ActionListener {

    //<editor-fold defaultstate="collapsed" desc="variable declaration">
    JLabel labelNama, labelTl, labelTlp, labelEmail, labelID,
            labelJKel, labelTL, labelAlmt, labelJob, labelP, labelKet,
            Ket, eId, eNama, eKel, eTl, eTLd, eTLm, eTLy, eTlp, eJob, ePers, eEmail;
    JTextField nama, tl, tlp, email, id, tLd, tLm, tLy, job, pers;
    JTextArea almt, ket;
    JComboBox kel;
    JButton save, reset, cancel, up;
    private int kesalahan;
    public static int rowTabel = 0;
    //</editor-fold>
    //Constructor
    //<editor-fold defaultstate="collapsed" desc="add_updialog constructor">

    Add_UpDialog() {
        setTitle("Data");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setDesign();
        addComponents(getContentPane());
        setVisible(true);
        setResizable(false);
        pack();
    }
    //</editor-fold>
    //Add Components to Pane
    //<editor-fold defaultstate="collapsed" desc="contentpane">

    public final void addComponents(Container pane) {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();

        labelID = new JLabel("Nomor Identitas*");
        cons.gridx = 0;
        cons.gridy = 0;
        cons.anchor = GridBagConstraints.WEST;
        cons.insets = new Insets(10, 10, 0, 10);
        pane.add(labelID, cons);

        id = new JTextField("Masukkan Nomor Identitas", 2);
        id.setPreferredSize(id.getPreferredSize());
        id.setMaximumSize(id.getPreferredSize());
        id.setForeground(Color.LIGHT_GRAY);
        id.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (id.getText().equals("Masukkan Nomor Identitas")) {
                    id.setText("");
                    id.setForeground(Color.BLACK);
                    repaint();
                    revalidate();
                }
            }
        });

        cons.gridx = 1;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        pane.add(id, cons);

        eId = new JLabel(" ");
        eId.setForeground(Color.RED);
        cons.gridy = 1;
        cons.insets = new Insets(0, 10, 0, 10);
        pane.add(eId, cons);

        labelNama = new JLabel("Nama*");
        cons.gridx = 0;
        cons.gridy = 2;
        cons.gridwidth = 1;
        pane.add(labelNama, cons);

        nama = new JTextField("Masukkan Nama", 2);
        nama.setPreferredSize(nama.getPreferredSize());
        nama.setMaximumSize(nama.getPreferredSize());
        nama.setForeground(Color.LIGHT_GRAY);
        nama.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (nama.getText().equals("Masukkan Nama")) {
                    nama.setText("");
                    nama.setForeground(Color.BLACK);
                    repaint();
                    revalidate();
                }
            }
        });
        cons.gridx = 1;
        cons.gridwidth = 3;
        pane.add(nama, cons);

        eNama = new JLabel(" ");
        eNama.setForeground(Color.RED);
        cons.gridy = 3;
        pane.add(eNama, cons);

        labelJKel = new JLabel("Jenis Kelamin*");
        cons.gridx = 0;
        cons.gridy = 4;
        cons.gridwidth = 1;
        pane.add(labelJKel, cons);

        String[] items = {"Pria", "Wanita"};
        kel = new JComboBox(items);
        kel.setSelectedItem(null);
        Add_UpDialog.MyItemListener actionListener = new Add_UpDialog.MyItemListener();
        kel.addItemListener(actionListener);
        cons.gridx = 1;
        cons.gridwidth = 3;
        pane.add(kel, cons);

        eKel = new JLabel(" ");
        eKel.setForeground(Color.RED);
        cons.gridy = 5;
        pane.add(eKel, cons);

        labelTl = new JLabel("Tempat Lahir*");
        cons.gridx = 0;
        cons.gridy = 6;
        cons.gridwidth = 1;
        pane.add(labelTl, cons);

        tl = new JTextField("Masukkan Tempat Lahir", 2);
        tl.setPreferredSize(tl.getPreferredSize());
        tl.setMaximumSize(tl.getPreferredSize());
        tl.setForeground(Color.LIGHT_GRAY);
        tl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tl.getText().equals("Masukkan Tempat Lahir")) {
                    tl.setText("");
                    tl.setForeground(Color.BLACK);
                    repaint();
                    revalidate();
                }
            }
        });
        cons.gridx = 1;
        cons.gridwidth = 3;
        pane.add(tl, cons);

        eTl = new JLabel(" ");
        eTl.setForeground(Color.RED);
        cons.gridy = 7;
        pane.add(eTl, cons);

        labelTL = new JLabel("Tanggal Lahir*");
        cons.gridx = 0;
        cons.gridy = 8;
        cons.gridwidth = 1;
        pane.add(labelTL, cons);

        tLd = new JTextField(7);
        tLd.setDocument(new LengthRestrictedDocument(2));
        tLd.setText("HH");
        tLd.setPreferredSize(tLd.getPreferredSize());
        tLd.setMaximumSize(tLd.getPreferredSize());
        tLd.setForeground(Color.LIGHT_GRAY);
        tLd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tLd.getText().equals("HH")) {
                    tLd.setText("");
                    tLd.setForeground(Color.BLACK);
                    repaint();
                    revalidate();
                }
            }
        });
        cons.gridx = 1;
        cons.gridwidth = 1;
        pane.add(tLd, cons);

        tLm = new JTextField(7);
        tLm.setDocument(new LengthRestrictedDocument(2));
        tLm.setText("BB");
        tLm.setPreferredSize(tLd.getPreferredSize());
        tLm.setMaximumSize(tLd.getPreferredSize());
        tLm.setForeground(Color.LIGHT_GRAY);
        tLm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tLm.getText().equals("BB")) {
                    tLm.setText("");
                    tLm.setForeground(Color.BLACK);
                    repaint();
                    revalidate();
                }
            }
        });
        cons.gridx = 2;
        pane.add(tLm, cons);

        tLy = new JTextField("TTTT", 5);
        tLy.setDocument(new LengthRestrictedDocument(4));
        tLy.setText("TTTT");
        tLy.setPreferredSize(tLy.getPreferredSize());
        tLy.setMaximumSize(tLy.getPreferredSize());
        tLy.setForeground(Color.LIGHT_GRAY);
        tLy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tLy.getText().equals("TTTT")) {
                    tLy.setText("");
                    tLy.setForeground(Color.BLACK);
                    repaint();
                    revalidate();
                }
            }
        });
        cons.gridx = 3;
        pane.add(tLy, cons);

        eTLd = new JLabel(" ");
        eTLd.setForeground(Color.RED);
        cons.gridx = 1;
        cons.gridy = 9;
        pane.add(eTLd, cons);

        eTLm = new JLabel(" ");
        eTLm.setForeground(Color.RED);
        cons.gridx = 2;
        pane.add(eTLm, cons);

        eTLy = new JLabel(" ");
        eTLy.setForeground(Color.RED);
        cons.gridx = 3;
        pane.add(eTLy, cons);

        labelAlmt = new JLabel("Alamat*");
        cons.gridx = 0;
        cons.gridy = 10;
        cons.ipady = 0;
        cons.gridwidth = 1;
        pane.add(labelAlmt, cons);

        almt = new JTextArea("Masukkan Alamat", 3, 0);
        almt.setLineWrap(true);
        almt.setPreferredSize(almt.getPreferredSize());
        almt.setMaximumSize(almt.getPreferredSize());
        almt.setForeground(Color.LIGHT_GRAY);
        almt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (almt.getText().equals("Masukkan Alamat")) {
                    almt.setText("");
                    almt.setForeground(Color.BLACK);
                    repaint();
                    revalidate();
                }
            }
        });
        cons.gridx = 1;
        cons.gridwidth = 3;
        pane.add(almt, cons);

        labelTlp = new JLabel("Nomor Telepon*");
        cons.gridx = 0;
        cons.gridy = 11;
        cons.gridwidth = 1;
        pane.add(labelTlp, cons);

        tlp = new JTextField("ex : (0266)240xxx", 2);
        tlp.setPreferredSize(tlp.getPreferredSize());
        tlp.setMaximumSize(tlp.getPreferredSize());
        tlp.setForeground(Color.LIGHT_GRAY);
        tlp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tlp.getText().equals("ex : (0266)240xxx")) {
                    tlp.setText("");
                    tlp.setForeground(Color.BLACK);
                    repaint();
                    revalidate();
                }
            }
        });
        cons.gridx = 1;
        cons.gridwidth = 3;
        pane.add(tlp, cons);

        eTlp = new JLabel(" ");
        eTlp.setForeground(Color.RED);
        cons.gridy = 12;
        pane.add(eTlp, cons);

        labelEmail = new JLabel("Email*");
        cons.gridx = 0;
        cons.gridy = 13;
        cons.gridwidth = 1;
        pane.add(labelEmail, cons);

        email = new JTextField("ex : abc123@gmail.com", 2);
        email.setPreferredSize(email.getPreferredSize());
        email.setMaximumSize(email.getPreferredSize());
        email.setForeground(Color.LIGHT_GRAY);
        email.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (email.getText().equals("ex : abc123@gmail.com")) {
                    email.setText("");
                    email.setForeground(Color.BLACK);
                    repaint();
                    revalidate();
                }
            }
        });
        cons.gridx = 1;
        cons.gridwidth = 3;
        pane.add(email, cons);

        eEmail = new JLabel(" ");
        eEmail.setForeground(Color.RED);
        cons.gridy = 14;
        pane.add(eEmail, cons);

        labelJob = new JLabel("Pekerjaan*");
        cons.gridx = 0;
        cons.gridy = 15;
        cons.gridwidth = 1;
        pane.add(labelJob, cons);

        job = new JTextField("Masukkan Pekerjaan", 2);
        job.setPreferredSize(job.getPreferredSize());
        job.setMaximumSize(job.getPreferredSize());
        job.setForeground(Color.LIGHT_GRAY);
        job.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (job.getText().equals("Masukkan Pekerjaan")) {
                    job.setText("");
                    job.setForeground(Color.BLACK);
                    repaint();
                    revalidate();
                }
            }
        });
        cons.gridx = 1;
        cons.gridwidth = 3;
        pane.add(job, cons);

        eJob = new JLabel(" ");
        eJob.setForeground(Color.RED);
        cons.gridy = 16;
        pane.add(eJob, cons);

        labelP = new JLabel("Nama Perusahaan*");
        cons.gridx = 0;
        cons.gridy = 17;
        cons.gridwidth = 1;
        pane.add(labelP, cons);

        pers = new JTextField("Masukkan Nama Perusahaan", 2);
        pers.setPreferredSize(pers.getPreferredSize());
        pers.setMaximumSize(pers.getPreferredSize());
        pers.setForeground(Color.LIGHT_GRAY);
        pers.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (pers.getText().equals("Masukkan Nama Perusahaan")) {
                    pers.setText("");
                    pers.setForeground(Color.BLACK);
                    repaint();
                    revalidate();
                }
            }
        });
        cons.gridx = 1;
        cons.gridwidth = 3;
        pane.add(pers, cons);

        ePers = new JLabel(" ");
        ePers.setForeground(Color.RED);
        cons.gridy = 18;
        pane.add(ePers, cons);

        labelKet = new JLabel("Keterangan");
        cons.gridx = 0;
        cons.gridy = 19;
        cons.gridwidth = 1;
        pane.add(labelKet, cons);

        ket = new JTextArea("Masukkan Keterangan (Opsional)", 3, 0);
        ket.setLineWrap(true);
        ket.setPreferredSize(ket.getPreferredSize());
        ket.setMaximumSize(ket.getPreferredSize());
        ket.setForeground(Color.LIGHT_GRAY);
        ket.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (ket.getText().equals("Masukkan Keterangan (Opsional)")) {
                    ket.setText("");
                    ket.setForeground(Color.BLACK);
                    repaint();
                    revalidate();
                }
            }
        });
        cons.gridx = 1;
        cons.gridwidth = 3;
        pane.add(ket, cons);

        up = new JButton("Update");
        up.setEnabled(false);
        up.addActionListener(this);
        cons.gridx = 0;
        cons.gridy = 20;
        cons.gridwidth = 1;
        cons.anchor = GridBagConstraints.CENTER;
        pane.add(up, cons);

        save = new JButton("Save");
        save.addActionListener(this);
        cons.gridx = 1;
        pane.add(save, cons);

        reset = new JButton("Reset");
        reset.addActionListener(this);
        cons.gridx = 2;
        pane.add(reset, cons);

        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        cons.gridx = 3;
        pane.add(cancel, cons);

        Ket = new JLabel("Ket : * Wajib di isi");
        Ket.setHorizontalAlignment(JLabel.RIGHT);
        cons.gridx = 2;
        cons.gridy = 21;
        cons.gridwidth = 2;
        cons.insets = new Insets(10, 0, 10, 10);
        pane.add(Ket, cons);
    }
    //</editor-fold>
    //UI Design
    //<editor-fold defaultstate="collapsed" desc="setdesign method">

    public final void setDesign() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
    }
    //</editor-fold>
    //Action List
    //<editor-fold defaultstate="collapsed" desc="action performed save, reset and cancel button">

    @Override
    public void actionPerformed(ActionEvent ae) {
        String clickedButton = ae.getActionCommand();
        Data vd = new Data();
        switch (clickedButton) {
            case "Update":
                kesalahan = 11;
                if (kesalahan != 0) {
                    kesalahanNama();
                    kesalahanID();
                    kesalahanEmail();
                    kesalahanJK();
                    kesalahanTeL();
                    kesalahanTanggal();
                    kesalahanNOTlp();
                    kesalahanJOB();
                    kesalahanNPers();
                    AgeCalculation();
                    if (kesalahan == 0) {
                        vd.setNoId(id.getText());
                        vd.setNama(nama.getText());
                        vd.setjKel(kel.getSelectedItem());
                        vd.setTempatLahir(tl.getText());
                        vd.setTanggalLahir(tLd.getText(), tLm.getText(), tLy.getText());
                        vd.setAlamat(almt.getText());
                        vd.setNoTlp(tlp.getText());
                        vd.setEmail(email.getText());
                        vd.setPekerjaan(job.getText());
                        vd.setNamaPers(pers.getText());
                        vd.setKeterangan(ket.getText());
                        vd.setUmur(getAge());
                        FormTabel.tabelModel.updateData(rowTabel, vd);
                        dispose();
                        JOptionPane.showMessageDialog(null, "Data Sudah Terupdate", "INFO", JOptionPane.INFORMATION_MESSAGE);
                        setVisible(false);
                    }
                }
                break;
            case "Save":
                kesalahan = 11;
                if (kesalahan != 0) {
                    kesalahanNama();
                    kesalahanID();
                    kesalahanEmail();
                    kesalahanJK();
                    kesalahanTeL();
                    kesalahanTanggal();
                    kesalahanNOTlp();
                    kesalahanJOB();
                    kesalahanNPers();
                    AgeCalculation();
                    if (ket.getText().equalsIgnoreCase("") || ket.getText().equalsIgnoreCase("Masukkan Keterangan (Opsional)")) {
                        ket.setText("-");
                    }
                    if (kesalahan == 0) {
                        vd.setNoId(id.getText());
                        vd.setNama(nama.getText());
                        vd.setjKel(kel.getSelectedItem());
                        vd.setTempatLahir(tl.getText());
                        vd.setTanggalLahir(tLd.getText(), tLm.getText(), tLy.getText());
                        vd.setAlamat(almt.getText());
                        vd.setNoTlp(tlp.getText());
                        vd.setEmail(email.getText());
                        vd.setPekerjaan(job.getText());
                        vd.setNamaPers(pers.getText());
                        vd.setKeterangan(ket.getText());
                        vd.setUmur(getAge());
                        FormTabel.tabelModel.addData(vd);
                        FormTabel.update.setEnabled(false);
                        FormTabel.delete.setEnabled(false);
                        dispose();
                        JOptionPane.showMessageDialog(null, "Data Sudah Ditambahkan", "INFO", JOptionPane.INFORMATION_MESSAGE);
                        setVisible(false);
                    }
                }
                break;
            case "Reset":
                id.setForeground(Color.LIGHT_GRAY);
                id.setText("Masukkan Nomor Identitas");
                eId.setText(" ");
                nama.setForeground(Color.LIGHT_GRAY);
                nama.setText("Masukkan Nama");
                eNama.setText(" ");
                kel.setSelectedItem(null);
                eKel.setText(" ");
                tl.setForeground(Color.LIGHT_GRAY);
                tl.setText("Masukkan Tempat Lahir");
                eTl.setText(" ");
                tLd.setForeground(Color.LIGHT_GRAY);
                tLd.setText("HH");
                tLm.setForeground(Color.LIGHT_GRAY);
                tLm.setText("BB");
                tLy.setForeground(Color.LIGHT_GRAY);
                tLy.setText("TTTT");
                eTLd.setText(" ");
                eTLm.setText(" ");
                eTLy.setText(" ");
                almt.setForeground(Color.LIGHT_GRAY);
                almt.setText("Masukkan Alamat");
                tlp.setForeground(Color.LIGHT_GRAY);
                tlp.setText("ex : (0266)240xxx");
                eTlp.setText(" ");
                email.setForeground(Color.LIGHT_GRAY);
                email.setText("ex : abc123@gmail.com");
                eEmail.setText(" ");
                job.setForeground(Color.LIGHT_GRAY);
                job.setText("Masukkan Pekerjaan");
                eJob.setText(" ");
                pers.setForeground(Color.LIGHT_GRAY);
                pers.setText("Masukkan Nama Perusahaan");
                ePers.setText(" ");
                ket.setForeground(Color.LIGHT_GRAY);
                ket.setText("Masukkan Keterangan (Opsional)");
                break;
            case "Cancel":
                setVisible(false);
                break;
        }
    }
    //</editor-fold>
    //Try - Catch Method
    //<editor-fold defaultstate="collapsed" desc="try and catch method">

    public void kesalahanNama() {
        try {
            setNama(nama.getText());
        } catch (NamaException nx) {
            nama.setForeground(Color.LIGHT_GRAY);
            nama.setText("Masukkan Nama");
            eNama.setText(nx.getMessage());
            return;
        }
        nama.setText(getNama());
        eNama.setText(" ");
        kesalahan--;
    }

    public void kesalahanEmail() {
        try {
            setEmail(email.getText());
        } catch (EmailException ex) {
            email.setForeground(Color.LIGHT_GRAY);
            email.setText("ex : abc123@gmail.com");
            eEmail.setText(ex.getMessage());
            return;
        }
        email.setText(getEmail());
        eEmail.setText(" ");
        kesalahan--;
    }

    public void kesalahanID() {
        try {
            setID(id.getText());
        } catch (IDException ix) {
            id.setForeground(Color.LIGHT_GRAY);
            id.setText("Masukkan Nomor Identitas");
            eId.setText(ix.getMessage());
            return;
        }
        id.setText(getID());
        eId.setText(" ");
        kesalahan--;
    }

    public void kesalahanJK() {
        try {
            setKel(kel.getSelectedItem());
        } catch (JenisKelaminException jkx) {
            kel.setSelectedItem(null);
            eKel.setText(jkx.getMessage());
            return;
        }
        kel.setSelectedItem(getJK());
        eKel.setText(" ");
        kesalahan--;
    }

    public void kesalahanTeL() {
        try {
            setTeLahir(tl.getText());
        } catch (TempatLahirException tx) {
            tl.setForeground(Color.LIGHT_GRAY);
            tl.setText("Masukkan Tempat Lahir");
            eTl.setText(tx.getMessage());
            return;
        }
        tl.setText(getTeL());
        eTl.setText(" ");
        kesalahan--;
    }

    public void kesalahanNOTlp() {
        try {
            setNOTlp(tlp.getText());
        } catch (NOTlpException nox) {
            tlp.setForeground(Color.LIGHT_GRAY);
            tlp.setText("ex : (0266)240xxx");
            eTlp.setText(nox.getMessage());
            return;
        }
        tlp.setText(getTlp());
        eTlp.setText(" ");
        kesalahan--;
    }

    public void kesalahanJOB() {
        try {
            setJob(job.getText());
        } catch (JobException jx) {
            job.setForeground(Color.LIGHT_GRAY);
            job.setText("Masukkan Pekerjaan");
            eJob.setText(jx.getMessage());
            return;
        }
        job.setText(getJob());
        eJob.setText(" ");
        kesalahan--;
    }

    public void kesalahanNPers() {
        try {
            setNPers(pers.getText());
        } catch (NPersException npx) {
            pers.setForeground(Color.LIGHT_GRAY);
            pers.setText("Masukkan Nama Perusahaan");
            ePers.setText(npx.getMessage());
            return;
        }
        pers.setText(getNPers());
        ePers.setText(" ");
        kesalahan--;
    }

    public void kesalahanTanggal() {
        setTanggal(tLy.getText(), tLm.getText(), tLd.getText());
    }
    //</editor-fold>
    //Custom Exception Class
    //<editor-fold defaultstate="collapsed" desc="custom class Exception">
    private String eml, nam, noID, teL, noTLP, jo, npers;
    private Object jk;

    public String getEmail() {
        return eml;
    }

    public String getNama() {
        return nam;
    }

    public String getID() {
        return noID;
    }

    public Object getJK() {
        return jk;
    }

    public String getTeL() {
        return teL;
    }

    public String getTlp() {
        return noTLP;
    }

    public String getJob() {
        return jo;
    }

    public String getNPers() {
        return npers;
    }

    public void setEmail(String eml) throws Add_UpDialog.EmailException {
        String pola = "[a-zA-Z0-9\\._]*@[A-Za-z]*\\.[A-Za-z]*";
        if (eml.matches(pola)) {
            this.eml = eml;
        } else if (eml.equalsIgnoreCase("") || eml.equalsIgnoreCase("ex : abc123@gmail.com")) {
            throw new Add_UpDialog.EmailException("harus di isi");
        } else {
            throw new Add_UpDialog.EmailException("harus ada @ dan .");
        }
    }

    public void setNama(String nama) throws Add_UpDialog.NamaException {
        String pola = "[a-zA-Z ]*";
        if (nama.matches(pola)) {
            this.nam = nama;
        } else if (nama.equalsIgnoreCase("") || nama.equalsIgnoreCase("Masukkan Nama")) {
            throw new Add_UpDialog.NamaException("harus di isi");
        } else {
            throw new Add_UpDialog.NamaException("tidak boleh ada angka");
        }
    }

    public void setID(String id) throws Add_UpDialog.IDException {
        String pola = "[0-9]*";
        if (id.matches(pola)) {
            this.noID = id;
        } else if (id.equalsIgnoreCase("") || id.equalsIgnoreCase("Masukkan Nomor Identitas")) {
            throw new Add_UpDialog.IDException("harus di isi");
        } else {
            throw new Add_UpDialog.IDException("hanya angka");
        }
    }

    public void setKel(Object jk) throws Add_UpDialog.JenisKelaminException {
        if (jk != null) {
            this.jk = jk;
        } else {
            throw new Add_UpDialog.JenisKelaminException("jenis kelamin?");
        }
    }

    public void setTeLahir(String teL) throws Add_UpDialog.TempatLahirException {
        if (teL.equalsIgnoreCase("") || teL.equalsIgnoreCase("Masukkan Tempat Lahir")) {
            throw new Add_UpDialog.TempatLahirException("harus di isi");
        } else {
            this.teL = teL;
        }
    }

    public void setNOTlp(String no) throws Add_UpDialog.NOTlpException {
        String pola = "[+()0-9]*";
        if (no.matches(pola)) {
            this.noTLP = no;
        } else if (no.equalsIgnoreCase("") || no.equalsIgnoreCase("ex : (0266)240xxx")) {
            throw new Add_UpDialog.NOTlpException("harus diisi");
        } else {
            throw new Add_UpDialog.NOTlpException("hanya angka");
        }
    }

    public void setJob(String jo) throws Add_UpDialog.JobException {
        if (jo.equalsIgnoreCase("") || jo.equalsIgnoreCase("Masukkan Pekerjaan")) {
            throw new Add_UpDialog.JobException("harus di isi");
        } else {
            this.jo = jo;
        }
    }

    public void setNPers(String npers) throws Add_UpDialog.NPersException {
        if (npers.equalsIgnoreCase("") || npers.equalsIgnoreCase("Masukkan Nama Perusahaan")) {
            throw new Add_UpDialog.NPersException("harus di isi");
        } else {
            this.npers = npers;
        }
    }
    Calendar cd = Calendar.getInstance();
    private int day, month, year, ageYears, ageMonths, ageDays;

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setTanggal(String tahun, String bulan, String hari) {
        try {
            int y = Integer.parseInt(tahun);
            if (y > cd.get(Calendar.YEAR)) {
                eTLy.setText("salah tahun");
                this.year = y;
            } else {
                this.year = y;
                kesalahan--;
                eTLy.setText(" ");
            }

            int m = Integer.parseInt(bulan);
            if (m < 1 || m > 12) {
                eTLm.setText("bulan 1-12.");
                this.month = m;
            } else {
                m--;
                if (getYear() == cd.get(Calendar.YEAR)) {
                    if (m > cd.get(Calendar.MONTH)) {
                        eTLm.setText("salah bulan");
                        this.month = m;
                    }
                } else {
                    this.month = m;
                    kesalahan--;
                    eTLm.setText(" ");
                }
            }
            int d = Integer.parseInt(hari);
            if (getMonth() == 0 || getMonth() == 2 || getMonth() == 4 || getMonth() == 6 || getMonth() == 7
                    || getMonth() == 9 || getMonth() == 11) {
                if (d > 31 || d < 1) {
                    eTLd.setText("hari 1-31");
                    this.day = d;
                } else {
                    this.day = d;
                    kesalahan--;
                    eTLd.setText(" ");
                }
            } else if (getMonth() == 3 || getMonth() == 5 || getMonth() == 8 || getMonth() == 10) {
                if (d > 30 || d < 1) {
                    eTLd.setText("hari 1-30");
                    this.day = d;
                } else {
                    this.day = d;
                    kesalahan--;
                    eTLd.setText(" ");
                }
            } else {
                if (new GregorianCalendar().isLeapYear(getYear())) {
                    if (d < 1 || d > 29) {
                        eTLd.setText("hari 1-29");
                        this.day = d;
                    } else {
                        this.day = d;
                        kesalahan--;
                        eTLd.setText(" ");
                    }
                } else if (d < 1 || d > 28) {
                    eTLd.setText("hari 1-28");
                    this.day = d;
                } else {
                    this.day = d;
                    kesalahan--;
                    eTLd.setText(" ");
                }
            }
            if (getYear() == cd.get(Calendar.YEAR)) {
                if (getMonth() == cd.get(Calendar.MONTH)) {
                    if (getDay() > cd.get(Calendar.DAY_OF_MONTH)) {
                        eTLd.setText("salah tanggal");
                    }
                }
            }
        } catch (NumberFormatException ne) {
            JOptionPane.showMessageDialog(null, "Tanggal Hanya Boleh Angka", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    class NamaException extends Exception {

        NamaException() {
        }

        NamaException(String message) {
            super(message);
        }
    }

    class EmailException extends Exception {

        EmailException() {
        }

        EmailException(String message) {
            super(message);
        }
    }

    class IDException extends Exception {

        IDException() {
        }

        IDException(String message) {
            super(message);
        }
    }

    class JenisKelaminException extends Exception {

        JenisKelaminException() {
        }

        JenisKelaminException(String message) {
            super(message);
        }
    }

    class TempatLahirException extends Exception {

        TempatLahirException() {
        }

        TempatLahirException(String message) {
            super(message);
        }
    }

    class NOTlpException extends Exception {

        NOTlpException() {
        }

        NOTlpException(String message) {
            super(message);
        }
    }

    class JobException extends Exception {

        JobException() {
        }

        JobException(String message) {
            super(message);
        }
    }

    class NPersException extends Exception {

        NPersException() {
        }

        NPersException(String message) {
            super(message);
        }
    }

    //</editor-fold>
    //Custom Item Listener
    //<editor-fold defaultstate="collapsed" desc="myitemlistener">
    private class MyItemListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent evt) {
            JComboBox cb = (JComboBox) evt.getSource();
            Object item = evt.getItem();
            if (evt.getStateChange() == ItemEvent.SELECTED) {
            } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            }
        }
    }
    //</editor-fold>
    //JTextFieldLimiter
    //<editor-fold defaultstate="collapsed" desc="jtextfieldlimit class">

    class LengthRestrictedDocument extends PlainDocument {

        private final int limit;

        public LengthRestrictedDocument(int limit) {
            this.limit = limit;
        }

        @Override
        public void insertString(int offs, String str, AttributeSet a)
                throws BadLocationException {
            if (str == null) {
                return;
            }

            if ((getLength() + str.length()) <= limit) {
                super.insertString(offs, str, a);
            }
        }
    }
    //</editor-fold>
    //Age Calculation
    //<editor-fold defaultstate="collapsed" desc="Age Calculation">
//    int day, month, year, ageYears, ageMonths, ageDays;

    public String getAge(){
        return Integer.toString(ageYears);
    }
    public void AgeCalculation() {
        Calendar bd = new GregorianCalendar(getYear(), getMonth(), getDay());
        this.ageYears = cd.get(Calendar.YEAR) - bd.get(Calendar.YEAR);
//        if (cd.before(new GregorianCalendar(cd.get(Calendar.YEAR), month, day))) {
//            ageYears--;
//            ageMonths = (12 - (bd.get(Calendar.MONTH) + 1)) + (bd.get(Calendar.MONTH));
//            if (day > cd.get(Calendar.DAY_OF_MONTH)) {
//                ageDays = day - cd.get(Calendar.DAY_OF_MONTH);
//            } else if (day < cd.get(Calendar.DAY_OF_MONTH)) {
//                ageDays = cd.get(Calendar.DAY_OF_MONTH) - day;
//            } else {
//                ageDays = 0;
//            }
//        } else if (cd.after(new GregorianCalendar(cd.get(Calendar.YEAR), month, day))) {
//            ageMonths = (cd.get(Calendar.MONTH) - (bd.get(Calendar.MONTH)));
//            if (day > cd.get(Calendar.DAY_OF_MONTH)) {
//                ageDays = day - cd.get(Calendar.DAY_OF_MONTH) - day;
//            } else if (day < cd.get(Calendar.DAY_OF_MONTH)) {
//                ageDays = cd.get(Calendar.DAY_OF_MONTH) - day;
//            } else {
//                ageDays = 0;
//            }
//        } else {
//            ageYears = cd.get(Calendar.YEAR) - bd.get(Calendar.YEAR);
//            ageMonths = 0;
//            ageDays = 0;
//        }
    }
    //</editor-fold>
    //Main class
    //<editor-fold defaultstate="collapsed" desc="main program">
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Add_UpDialog aud = new Add_UpDialog();
            }
        });
    }
    //</editor-fold>
}
