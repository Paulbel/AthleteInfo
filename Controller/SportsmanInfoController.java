package Controller;

import Model.TableModelWithSportsman;
import View.AddStudentDialog;
import View.MainFrame;
import View.TableViewSportsman;

import javax.swing.*;

/**
 * Created by Sinelnikov on 29.03.2017.
 */
public class SportsmanInfoController {
    public void run() {
        MainFrame mainFrame = new MainFrame(this);

    }

    public void exit(JFrame frame){
        int response = JOptionPane.showConfirmDialog(frame,"Вы действительно хотите выйти?","", JOptionPane.YES_NO_OPTION);
        if (response==0){
            System.exit(0);
        }
    }

    public void openDialogAddingSportsman(){
        AddStudentDialog addDialog = new AddStudentDialog(this);
    }


}
