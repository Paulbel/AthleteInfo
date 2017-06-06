package MyFileChooser.View;

import MyFileChooser.Controller.MyFileChooser;
import MyFileChooser.Model.ChooserConsts;
import MyFileChooser.Model.Directory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Created by Sinelnikov on 04.06.2017.
 */
public class ChooserDialog extends JDialog {
    JTextField fileNameTextField;
    DirectoryViewPanel panel;
    Map<String, DirectoryViewPanel> panels;
    JDialog dialog;
    MyFileChooser controller;
    Directory directory;

    public ChooserDialog(MyFileChooser controller) {
        dialog = this;
        directory = new Directory(ChooserConsts.NAME_TREE_ROOT);
        this.controller = controller;
        this.setLayout(new BorderLayout());
        Map<String, String> extensions = new HashMap<>();
        for (int index = 0; index < ChooserConsts.FILTRENAME.length && index < ChooserConsts.FILTREXCT.length; index++) {
            extensions.put(ChooserConsts.FILTRENAME[index], ChooserConsts.FILTREXCT[index]);
        }

        fileNameTextField = new JTextField(20);

        JComboBox extensionComboBox = new JComboBox(ChooserConsts.FILTRENAME);

        Vector<String> modes = new Vector<>();
        modes.add(ChooserConsts.DIRECTORYNAME);
        modes.add(ChooserConsts.LISTNAME);
        modes.add(ChooserConsts.TABLENAME);
        ImageIcon homeIcon = new ImageIcon("image/home.png");
        // ImageIcon nextIcon = new ImageIcon("image/nextPage.png");
        //ImageIcon prevIcon = new ImageIcon("image/prevPage.png");
        JButton homeButton = new JButton(homeIcon);
        // JButton prevButton = new JButton(prevIcon);
        //JButton nextButton = new JButton(nextIcon);

        JToolBar southToolBar = new JToolBar(JToolBar.HORIZONTAL);


        southToolBar.setFloatable(false);
        southToolBar.setLayout(new BorderLayout());
        JButton cancelButton = new JButton("Отмена");
        JButton okButton = new JButton("Ок");
        JPanel okCancelPanel = new JPanel();
        okCancelPanel.setLayout(new GridLayout(2, 1));
        okCancelPanel.add(cancelButton);
        okCancelPanel.add(okButton);
        okCancelPanel.setVisible(true);

        JPanel fileSelectionPanel = new JPanel();
        fileSelectionPanel.setLayout(new GridLayout(2, 1));

        fileSelectionPanel.add(fileNameTextField);
        fileSelectionPanel.add(extensionComboBox);
        southToolBar.add(okCancelPanel, BorderLayout.EAST);

        southToolBar.add(fileSelectionPanel, BorderLayout.CENTER);
        JToolBar northToolBar = new JToolBar(JToolBar.HORIZONTAL);


        northToolBar.setFloatable(false);
        northToolBar.setLayout(new BorderLayout());

        JComboBox modeComboBox = new JComboBox(modes);
        modeComboBox.setSelectedItem(ChooserConsts.TABLENAME);

        TreeModel treeModel = new TreeModel();

        JTree directoryTree = new JTree(treeModel);
        DirectoryTreePanel directoryTreePanel = new DirectoryTreePanel(controller, directoryTree);
        directoryTreePanel.setPreferredSize(new Dimension(200, this.getPreferredSize().height));
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(homeButton);
        // buttonPanel.add(prevButton);
        //buttonPanel.add(nextButton);
        buttonPanel.setVisible(true);
        northToolBar.add(buttonPanel, BorderLayout.WEST);
        northToolBar.add(modeComboBox, BorderLayout.EAST);
        this.add(directoryTreePanel, BorderLayout.WEST);
        this.add(southToolBar, BorderLayout.SOUTH);


        //panel = new View.TableDirectoryViewPanel(directory);
        //panel.setVisible(true);

        panels = new HashMap<>();
        panel = new DirectoryDisplayPanel(directory, ChooserConsts.FOLDERVIEWTYPE, controller);
        panels.put(ChooserConsts.DIRECTORYNAME, panel);
        panel = new DirectoryDisplayPanel(directory, ChooserConsts.LISTVIEWTYPE, controller);
        panels.put(ChooserConsts.LISTNAME, panel);
        panel = new TableDirectoryViewPanel(directory, controller);
        panels.put(ChooserConsts.TABLENAME, panel);

        panel.setVisible(true);
        panel.repaint();
        //this.add(directoryDisplayPanel, BorderLayout.CENTER);
        this.add(panel, BorderLayout.CENTER);
        this.add(northToolBar, BorderLayout.NORTH);
        this.pack();

        modeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.remove(panel);
                panel = panels.get(modeComboBox.getSelectedItem());
                dialog.add(panel, BorderLayout.CENTER);
                dialog.pack();
                dialog.repaint();
            }
        });

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFolder(new Directory(ChooserConsts.NAME_TREE_ROOT));
            }
        });

        extensionComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Map.Entry<String, DirectoryViewPanel> entry : panels.entrySet()) {
                    entry.getValue().setExtension(extensions.get(extensionComboBox.getSelectedItem()));
                }
                panel.repaint();
                revalidate();
            }
        });
/*        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(userWayIndex>=1){
                    controller.changeFolder(new Model.Directory(userWay.get(userWayIndex)));
                    userWayIndex = userWayIndex-1;
                }
                else prevButton.setEnabled(false);
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userWayIndex = userWayIndex+1;
            }
        });*/


        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setOption(ChooserConsts.APPROVEOPTION);
                controller.hideDialog();
                controller.getOpenFileListener().openFile();
                System.out.println("SetOption-> " + ChooserConsts.APPROVEOPTION);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setSelectedFile(null);
                controller.setOption(ChooserConsts.CANCELOPTION);
                controller.hideDialog();

            }
        });
    }

    public JTextField getFileNameTextField() {
        return fileNameTextField;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
        for (Map.Entry<String, DirectoryViewPanel> entry : panels.entrySet()) {
            entry.getValue().changeDirectory(directory);
        }
        panel.repaint();
        revalidate();
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 600);
    }


}
