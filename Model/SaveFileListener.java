package Model;

import Controller.MyFileChooser;
import Controller.SportsmanInfo;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by Sinelnikov on 12.04.2017.
 */

public class SaveFileListener implements ActionListener {
    private SportsmanInfo controller;
    private MyFileChooser myFileChooser;

    public SaveFileListener(SportsmanInfo controller, MyFileChooser fileChooser) {
        this.controller = controller;
        this.myFileChooser = fileChooser;
    }

    public void actionPerformed(ActionEvent e) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                if (myFileChooser.showDialog() == ChooserConsts.OKOPTION) {
                    System.out.println("Check");
                    try {
                        File file = myFileChooser.getSelectedFile();
                        file.createNewFile();
                        System.out.println(myFileChooser.getSelectedFile().getPath());
                        new XMLFile(myFileChooser.getSelectedFile().getPath(), controller).writeFile();
                        myFileChooser.setOption(ChooserConsts.WAITOPTION);

                    } catch (IOException exception) {
                        exception.printStackTrace();
                    } catch (TransformerException exception) {
                        exception.printStackTrace();
                    } catch (ParserConfigurationException exception) {
                        exception.printStackTrace();
                    }
                }
            }

        });
        t1.start();

    }
}