package View;

import Controller.SportsmanInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sinelnikov on 31.03.2017.
 */
public class SearchSportsmanDialog {
    private SportsmanInfo controller;
    private JDialog searchSportsmanDialog;
    private JPanel searchPanel;
    DeleteSearchSportsmanByFIORankPanel searchByFIORankPanel;
    DeleteSearchSportsmanByTitlesPanel searchByTitlesPanel;
    DeleteSearchSportsmanByFIOSportPanel searchByFIOSportPanel;


    public SearchSportsmanDialog(SportsmanInfo controller) {
        this.controller = controller;
        searchSportsmanDialog = new JDialog();
        searchSportsmanDialog.setSize(1000, 700);
        searchSportsmanDialog.setLayout(new BorderLayout());

        searchByFIORankPanel = new DeleteSearchSportsmanByFIORankPanel(controller);
        searchByTitlesPanel = new DeleteSearchSportsmanByTitlesPanel(controller);
        searchByFIOSportPanel = new DeleteSearchSportsmanByFIOSportPanel(controller);


        String[] types = {"По ФИО и Виду спорта", "По количеству титулов", "По ФИО и разряду"};
        JComboBox selectSearchType = new JComboBox(types);
        JButton deleteButton = new JButton("Найти");


        JPanel panel = searchByFIOSportPanel.getDeleteSearchPanel();
        searchSportsmanDialog.add(selectSearchType, BorderLayout.NORTH);
        searchPanel = new JPanel();
        searchPanel.add(panel);


        searchSportsmanDialog.add(searchPanel, BorderLayout.WEST);
        searchSportsmanDialog.add(deleteButton, BorderLayout.SOUTH);


        TableScrollViewPanel tableScrollViewPanel = new TableScrollViewPanel(controller.getSportsmanInfoData().getSportsmanList());
        tableScrollViewPanel.setVisible(true);
        searchSportsmanDialog.add(tableScrollViewPanel, BorderLayout.CENTER);
        searchSportsmanDialog.setVisible(true);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (selectSearchType.getSelectedIndex()) {
                    case 0:
                        tableScrollViewPanel.changeList(searchByFIOSportPanel.searchSportsman());
                        break;
                    case 1:
                        tableScrollViewPanel.changeList(searchByTitlesPanel.searchSportsman());
                        break;
                    case 2:
                        tableScrollViewPanel.changeList(searchByFIORankPanel.searchSportsman());
                        break;
                }
            }
        });

        selectSearchType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selected = selectSearchType.getSelectedIndex();
                searchSportsmanDialog.remove(searchPanel);
                searchPanel.removeAll();
                switch (selected) {
                    case 0:
                        searchPanel.add(searchByFIOSportPanel.getDeleteSearchPanel());
                        break;
                    case 1:
                        searchPanel.add(searchByTitlesPanel.getDeleteSearchPanel());
                        break;
                    case 2:
                        searchPanel.add(searchByFIORankPanel.getDeleteSearchPanel());
                        break;
                }
                searchSportsmanDialog.add(searchPanel, BorderLayout.WEST);
                searchSportsmanDialog.revalidate();
                searchPanel.repaint();
            }
        });


    }

}
