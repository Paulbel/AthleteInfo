package View;

import Model.Sportsman;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by Sinelnikov on 28.03.2017.
 */
public class TableModelWithSportsman extends AbstractTableModel {
    public static final int FIO_COLUMN = 0;
    public static final int LINE_COL = 1;
    private List<Sportsman> sportsmanList;
    private String[] names = {
            "ФИО",
            "Состав",
            "Позиция",
            "Титулы",
            "Вид спорта",
            "Разряд"
    };

    public TableModelWithSportsman(List sportsmanList) {
        this.sportsmanList = sportsmanList;
    }


    @Override
    public String getColumnName(int column) {

        return names[column];
    }


    @Override
    public int getRowCount() {
        return sportsmanList.size();
    }

    @Override
    public int getColumnCount() {
        return names.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object result = null;
        Sportsman sportsman = sportsmanList.get(rowIndex);
        switch (columnIndex) {
            case FIO_COLUMN:
                result = sportsman.getSecondName() + " "
                        + sportsman.getFirstName().substring(0, 1) + "."
                        + sportsman.getThirdName().substring(0, 1) + ".";
                break;
            case LINE_COL:
                result = sportsman.getLineup();
                break;
            case 2:
                result = sportsman.getPosition();
                break;
            case 3:
                result = sportsman.getTitleNumber();
                break;
            case 4:
                result = sportsman.getSportName();
                break;
            case 5:
                result = sportsman.getRank();
                break;
        }
        return result;
    }

    public List<Sportsman> getSportsmanList() {
        return sportsmanList;
    }
}
