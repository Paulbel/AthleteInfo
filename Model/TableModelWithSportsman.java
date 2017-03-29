package Model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sinelnikov on 28.03.2017.
 */
public class TableModelWithSportsman extends AbstractTableModel{
    ArrayList<SportsmanModel> studentList;
    private int numberOfStudentsOnPage;
    private int pageNumber;
    public TableModelWithSportsman(){
        super();
        pageNumber = 1;
        studentList = new ArrayList<SportsmanModel>();
    }
    public List <SportsmanModel> getNextPage(){
        if(pageNumber+1<=this.getNumberOfPages()){
            pageNumber= pageNumber+1;
            return this.getPage();
        }
        else return new ArrayList<SportsmanModel>();
    }

    public void setPageNumber(int pageNumber){
        this.pageNumber = pageNumber;
    }

    public void addStudent(SportsmanModel student){
        studentList.add(student);
        fireTableDataChanged();
    }

    public List <SportsmanModel> getPage(){
        int elementsNumber = pageNumber*numberOfStudentsOnPage;
        int willBeOnPage = numberOfStudentsOnPage - (elementsNumber-studentList.size());
        return studentList.subList(numberOfStudentsOnPage*(pageNumber-1), numberOfStudentsOnPage*(pageNumber)+willBeOnPage);
    }

    public List <SportsmanModel> getPrevPage(){
        if(pageNumber-1>=this.getNumberOfPages()){
            pageNumber = pageNumber-1;
            return this.getPage();
        }
        else return new ArrayList<SportsmanModel>();
    }
    public List<SportsmanModel> getStudentList() {
        return studentList;
    }
    public void setNumberOfStudentsOnPage(int numberOfStudentsOnPage){
        this.numberOfStudentsOnPage = numberOfStudentsOnPage;
    }
    public int getNumberOfPages(){
        int numberOfPages;
        if(studentList.size()%numberOfStudentsOnPage!=0){
        numberOfPages = studentList.size()/numberOfStudentsOnPage+1;
        }
        else{
            numberOfPages = studentList.size()/numberOfStudentsOnPage;
        }
        return numberOfPages;
    }

    @Override
    public int getRowCount() {
        return numberOfStudentsOnPage;
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object result = null;
        switch (columnIndex){
            case 0:
                result = studentList.get(rowIndex).getFirstName();
                break;
            case 1:
                result = studentList.get(rowIndex).getSecondName();
                break;
            case 2:
                result = studentList.get(rowIndex).getThirdName();
                break;
            case 3:
                result = studentList.get(rowIndex).getLineup();
                break;
            case 4:
                result = studentList.get(rowIndex).getTitleNumber();
                break;
            case 5:
                result =  studentList.get(rowIndex).getFirstName();
                break;
            case 6:
                result = studentList.get(rowIndex).getSport();
                break;
            case 7:
                result = studentList.get(rowIndex).getRank();
                break;
        }
        return result;
    }

}
