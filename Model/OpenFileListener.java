package Model;

import Controller.SportsmanInfo;
import View.MainFrame;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Лёша on 23.03.2017.
 */
public class OpenFileListener implements ActionListener {
    private SportsmanInfo controller;
    private JFileChooser fileChooser;

    public OpenFileListener(SportsmanInfo controller){
        this.controller = controller;
        fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "XML Формат", "xml");
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("Загрузить файл");
    }
    public void actionPerformed(ActionEvent e) {
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                new XMLFile(fileChooser.getSelectedFile().getPath(), controller).readFile();
        }
    }
}