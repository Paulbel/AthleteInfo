package MyFileChooser.Controller;

import Model.OpenFileListener;
import MyFileChooser.Model.Directory;
import MyFileChooser.View.ChooserDialog;
import MyFileChooser.View.OpenFolderListener;

import javax.swing.*;
import java.io.File;

/**
 * Created by Sinelnikov on 03.06.2017.
 */
public class MyFileChooser {
    private OpenFileListener openFileListener;
    private ChooserDialog chooserDialog;
    private File selectedFile;
    private int option;

    public MyFileChooser() {
        selectedFile = null;
        option = 0;
    }


    public void changeFolder(Directory directory) {
        chooserDialog.setDirectory(directory);
        chooserDialog.revalidate();
    }


    public void showDialog() {
        //chooserDialog.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        chooserDialog = new ChooserDialog(this);
        chooserDialog.setVisible(true);
        chooserDialog.setLocationRelativeTo(null);
        chooserDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //hideDialog();
    }


    public void setOption(int option) {
        this.option = option;
    }


    public void hideDialog() {
        chooserDialog.dispose();
        chooserDialog = null;
    }

    public void setSelectedFile(File selectedFile) {
        this.selectedFile = selectedFile;
        if (selectedFile != null) {
            chooserDialog.getFileNameTextField().setText(selectedFile.getName());
        } else {
            chooserDialog.getFileNameTextField().setText("");
        }
    }

    public void setListener(OpenFileListener openFileListener){
        this.openFileListener = openFileListener;
    }
    public OpenFileListener getOpenFileListener(){
        return openFileListener;
    }

    public File getSelectedFile() {
        return selectedFile;
    }

    public int getOption() {
        return option;
    }


}
