package Controller;

import Model.SportsmanModel;
import Model.TableModelWithSportsman;
import View.AddStudentDialog;
import View.MainFrame;

import javax.swing.*;

/**
 * Created by Sinelnikov on 29.03.2017.
 */
public class SportsmanInfoController {
    private TableModelWithSportsman tableModelWithSportsman;
    private MainFrame mainFrame;
    public void run() {
        tableModelWithSportsman = new TableModelWithSportsman();
        mainFrame = new MainFrame(this);
        mainFrame.refreshTable();
    }

    public void exit(JFrame frame){
        int response = JOptionPane.showConfirmDialog(frame,"Вы действительно хотите выйти?","", JOptionPane.YES_NO_OPTION);
        if (response==0){
            System.exit(0);
        }
    }
    public void addSportsman(SportsmanModel sportsman){
        tableModelWithSportsman = mainFrame.getTableModelWithSportsman();
        tableModelWithSportsman.addSportsman(sportsman);
        mainFrame.refreshTable();

    }
    public void openDialogAddingSportsman(){
        AddStudentDialog addDialog = new AddStudentDialog(this);
    }


}
