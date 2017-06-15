package Model;

import Controller.MyFileChooser;
import Controller.SportsmanInfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sinelnikov on 12.04.2017.
 */

public class OpenFileListener implements ActionListener {
    private SportsmanInfo controller;
    private MyFileChooser myFileChooser;

    public OpenFileListener(SportsmanInfo controller, MyFileChooser fileChooser) {
        this.controller = controller;
        this.myFileChooser = fileChooser;
    }

    public void actionPerformed(ActionEvent e) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                if (myFileChooser.showDialog() == ChooserConsts.OKOPTION) {
                    new XMLFile(myFileChooser.getSelectedFile().getPath(), controller).readFile();
                    myFileChooser.setOption(ChooserConsts.WAITOPTION);
                }
            }
        });
        t1.start();


    }

}