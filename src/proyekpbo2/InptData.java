package proyekpbo2;

import java.awt.Container;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JDialog;
import javax.swing.JTextArea;

public class InptData extends JDialog {

    Container konten;
    JTextArea data;
//!@%#!$)%$ 

    public InptData() throws FileNotFoundException, IOException {
        File input = new File("Data.txt");
        FileInputStream inputStream = new FileInputStream(input);
        String test = new String();
        int a;
        while ((a = inputStream.read()) != -1) {
            test += (char) a;
        }
        inputStream.close();
        setTitle("Data Warga");
        setSize(330, 300);
        setLocation(200, 200);
        setResizable(true);
        konten = getContentPane();
        konten.setLayout(new FlowLayout());

        data = new JTextArea(test);
        konten.add(data);
    }

    public static void main(String[] args) throws IOException {
        InptData mah = new InptData();
        mah.setVisible(true);
    }
}
