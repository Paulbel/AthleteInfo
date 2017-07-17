package View;

import Controller.MyFileChooser;
import Controller.SportsmanInfo;
import Model.OpenFileListener;
import Model.SaveFileListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sinelnikov on 25.03.2017.
 */
public class MainFrame {
    private TableScrollViewPanel tableScrollViewPanel;
    private SportsmanInfo controller;
    private JFrame mainFrame;

    JComboBox onPageNumberComboBox;

    public MainFrame(SportsmanInfo controller) {
        this.controller = controller;
        mainFrame = new JFrame("Информация о спортсменах");
        mainFrame.setSize(1000, 800);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());
        JMenuBar workingOptionsMenuBar = new JMenuBar();

        JMenu studentMenu = new JMenu("Student");
        JMenu fileMenu = new JMenu("File");

        JMenuItem addSportsman = new JMenuItem("Add");
        JMenuItem deleteSportsman = new JMenuItem("Delete");
        JMenuItem searchSportsman = new JMenuItem("Search");

        JMenuItem openFileMenuItem = new JMenuItem("Open");
        JMenuItem saveFileMenuItem = new JMenuItem("Save");
        JMenuItem exitFileMenuItem = new JMenuItem("Exit");

        studentMenu.add(addSportsman);
        studentMenu.add(deleteSportsman);
        studentMenu.add(searchSportsman);

        fileMenu.add(openFileMenuItem);
        fileMenu.add(saveFileMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitFileMenuItem);

        workingOptionsMenuBar.add(fileMenu);
        workingOptionsMenuBar.add(studentMenu);

        ImageIcon userAddImage = new ImageIcon("image\\ToggleButtons\\userAdd.png");
        ImageIcon userDeleteImage = new ImageIcon("image\\ToggleButtons\\userDelete.png");
        ImageIcon userSearchImage = new ImageIcon("image\\ToggleButtons\\userSearch.png");
        ImageIcon saveImage = new ImageIcon("image\\ToggleButtons\\save.png");
        ImageIcon exitImage = new ImageIcon("image\\ToggleButtons\\exit.png");
        ImageIcon openFileImage = new ImageIcon("image\\ToggleButtons\\openFile.png");

        JButton addUserButton = new JButton(userAddImage);
        JButton deleteUserButton = new JButton(userDeleteImage);
        JButton searchUserButton = new JButton(userSearchImage);
        JButton openButton = new JButton(openFileImage);
        JButton saveButton = new JButton(saveImage);
        JButton exitButton = new JButton(exitImage);

        JToolBar leftToolBar = new JToolBar("Work with area", JToolBar.VERTICAL);

        leftToolBar.add(addUserButton);
        leftToolBar.add(deleteUserButton);
        leftToolBar.add(searchUserButton);
        leftToolBar.addSeparator();
        leftToolBar.add(openButton);
        leftToolBar.add(saveButton);
        leftToolBar.add(exitButton);
        leftToolBar.setFloatable(false);

        onPageNumberComboBox = new JComboBox();

        tableScrollViewPanel = new TableScrollViewPanel(controller.getSportsmanInfoData().getSportsmanList());
        tableScrollViewPanel.setVisible(true);

        mainFrame.add(tableScrollViewPanel, BorderLayout.CENTER);
        mainFrame.add(workingOptionsMenuBar, BorderLayout.NORTH);
        mainFrame.add(leftToolBar, BorderLayout.WEST);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(mainFrame, "Вы дейтвительно хотите выйти?");
                if (response == 0) {
                    System.exit(0);
                }
            }
        });

        searchSportsman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchSportsmanDialog searchSportsmanDialog = new SearchSportsmanDialog(controller);
            }
        });

        deleteSportsman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteSportsmanDialog deleteSportsmanDialog = new DeleteSportsmanDialog(controller);
            }
        });

        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddSportsmanDialog dialog = new AddSportsmanDialog(controller);
            }
        });

        addSportsman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddSportsmanDialog dialog = new AddSportsmanDialog(controller);
            }
        });

        deleteUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteSportsmanDialog deleteSportsmanDialog = new DeleteSportsmanDialog(controller);
            }
        });


        searchUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchSportsmanDialog searchSportsman = new SearchSportsmanDialog(controller);
            }
        });


        exitFileMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(mainFrame, "Вы дейтвительно хотите выйти?");
                if (response == 0) {
                    System.exit(0);
                }
            }
        });
        MyFileChooser fileChooser = new MyFileChooser();
        openButton.addActionListener(new OpenFileListener(controller, fileChooser));
        saveButton.addActionListener(new SaveFileListener(controller, fileChooser));
        openFileMenuItem.addActionListener(new OpenFileListener(controller, fileChooser));
        saveFileMenuItem.addActionListener(new SaveFileListener(controller, fileChooser));
    }

    public void refreshTable() {
        tableScrollViewPanel.changeList(controller.getSportsmanInfoData().getSportsmanList());
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }
}
