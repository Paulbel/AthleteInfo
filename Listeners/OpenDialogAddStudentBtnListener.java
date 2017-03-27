package Listeners;

import Model.TableModel;
import View.AddStudentDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sinelnikov on 26.03.2017.
 */
public class OpenDialogAddStudentBtnListener implements ActionListener{
    private TableModel tableModel;
    public OpenDialogAddStudentBtnListener(TableModel tableModel){
        this.tableModel = tableModel;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        AddStudentDialog dialog = new AddStudentDialog(tableModel);
    }
}
