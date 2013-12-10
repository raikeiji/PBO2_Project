/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyekpbo2;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Echo
 */
public class TabelModel extends AbstractTableModel{

    public List<Data> list = new ArrayList<>();
    
    public void setData(List<Data> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }

    public void clear() {
        list.clear();
        fireTableDataChanged();
    }

    public void addData(Data data) {
        list.add(data);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
    }

    public void updateData(int row, Data data) {
        list.set(row, data);
        fireTableDataChanged();
    }

    public void removeData(int index) {
        list.remove(index);
        fireTableRowsDeleted(index, index);
    }

    public void setData(int index, Data data) {
        list.set(index, data);
        fireTableRowsUpdated(index, index);
    }

    public Data getData(int index) {
        return list.get(index);
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 12;
    }
    
//    @Override
//    public void setValueAt(Object value, int rowIndex, int columnIndex) {
//        switch (columnIndex) {
//            case 0:
//                list.set(rowIndex, (Data) value);
//            case 1:
//                list.set(rowIndex, (Data) value);
//            case 2:
//                list.set(rowIndex, (Data) value);
//            case 3:
//                list.set(rowIndex, (Data) value);
//            case 4:
//                list.set(rowIndex, (Data) value);
//            case 5:
//                list.set(rowIndex, (Data) value);
//            case 6:
//                list.set(rowIndex, (Data) value);
//            case 7:
//                list.set(rowIndex, (Data) value);
//            case 8:
//                list.set(rowIndex, (Data) value);
//            case 9:
//                list.set(rowIndex, (Data) value);
//            case 10:
//                list.set(rowIndex, (Data) value);
////            default:
////                 "";
//        }
//        fireTableCellUpdated(rowIndex, columnIndex);
//    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getNoId();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getjKel();
            case 3:
                return list.get(rowIndex).getTempatLahir();
            case 4:
                return list.get(rowIndex).getTanggalLahir();
            case 5:
                return list.get(rowIndex).getAlamat();
            case 6:
                return list.get(rowIndex).getNoTlp();
            case 7:
                return list.get(rowIndex).getEmail();
            case 8:
                return list.get(rowIndex).getPekerjaan();
            case 9:
                return list.get(rowIndex).getNamaPers();
            case 10:
                return list.get(rowIndex).getKeterangan();
            case 11:
                return list.get(rowIndex).getUmur();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No Identitas";
            case 1:
                return "Nama";
            case 2:
                return "Jenis Kelamin";
            case 3:
                return "Tempat Lahir";
            case 4:
                return "Tanggal Lahir";
            case 5:
                return "Alamat";
            case 6:
                return "Nomor Telepon";
            case 7:
                return "Email";
            case 8:
                return "Pekerjaan";
            case 9:
                return "Nama Perusahaan";
            case 10:
                return "Keterangan";
            case 11:
                return "Umur";
            default:
                return null;
        }
    }
}
