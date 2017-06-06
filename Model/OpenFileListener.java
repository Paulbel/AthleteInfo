package Model;

import Controller.SportsmanInfo;
import MyFileChooser.Controller.MyFileChooser;
import MyFileChooser.Model.ChooserConsts;
import javafx.stage.FileChooser;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sinelnikov on 12.04.2017.
 */

public class OpenFileListener implements ActionListener {
    private SportsmanInfo controller;
    //private JFileChooser fileChooser;
    private MyFileChooser myFileChooser;
    public OpenFileListener(SportsmanInfo controller) {
        this.controller = controller;
        /*fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "XML Формат", "xml");
        fileChooser.setFileFilter(filter);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setDialogTitle("Загрузить файл");*/
    }

    public void actionPerformed(ActionEvent e) {
            myFileChooser = new MyFileChooser();
            myFileChooser.setListener(this);
            myFileChooser.showDialog();
            System.out.println(myFileChooser.getOption());

    }

    public void openFile(){
        if(myFileChooser.getOption() == ChooserConsts.APPROVEOPTION){
            System.out.println("APPROVE");
            new XMLFile(myFileChooser.getSelectedFile().getPath(), controller).readFile();
            myFileChooser.setOption(ChooserConsts.DONOTHINGOPTION);
        }
    }

}