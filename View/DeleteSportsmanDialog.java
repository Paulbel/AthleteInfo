package View;

import Controller.SportsmanInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sinelnikov on 31.03.2017.
 */
public class DeleteSportsmanDialog {
    private JPanel deletePanel;
    private JDialog deleteSportsmanDialog;
    DeleteSearchSportsmanByFIORankPanel deleteByFIORankPanel;
    DeleteSearchSportsmanByTitlesPanel deleteByTitlesPanel;
    DeleteSearchSportsmanByFIOSportPanel deleteByFIOSportPanel;


    public DeleteSportsmanDialog(SportsmanInfo controller) {
        deleteSportsmanDialog = new JDialog();
        deleteSportsmanDialog.setSize(300, 200);
        deleteSportsmanDialog.setLayout(new BorderLayout());

        deleteByFIORankPanel = new DeleteSearchSportsmanByFIORankPanel(controller);
        deleteByTitlesPanel = new DeleteSearchSportsmanByTitlesPanel(controller);
        deleteByFIOSportPanel = new DeleteSearchSportsmanByFIOSportPanel(controller);

        deletePanel = deleteByFIOSportPanel.getDeleteSearchPanel();

        String[] types = {"По ФИО и Виду спорта", "По количеству титулов", "По ФИО и разряду"};
        JComboBox selectDeleteType = new JComboBox(types);
        JButton deleteButton = new JButton("Удалить из списка");

        deleteSportsmanDialog.add(selectDeleteType, BorderLayout.NORTH);
        deleteSportsmanDialog.add(deletePanel, BorderLayout.CENTER);
        deleteSportsmanDialog.add(deleteButton, BorderLayout.SOUTH);


        deleteSportsmanDialog.setVisible(true);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (selectDeleteType.getSelectedIndex()) {
                    case 0:
                        deleteByFIOSportPanel.deleteSportsman();
                        break;
                    case 1:
                        deleteByTitlesPanel.deleteSportsman();
                        break;
                    case 2:
                        deleteByFIORankPanel.deleteSportsman();
                        break;
                }
            }
        });

        selectDeleteType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selected = selectDeleteType.getSelectedIndex();
                deleteSportsmanDialog.remove(deletePanel);
                switch (selected) {
                    case 0:
                        deletePanel = deleteByFIOSportPanel.getDeleteSearchPanel();
                        break;
                    case 1:
                        deletePanel = deleteByTitlesPanel.getDeleteSearchPanel();
                        break;
                    case 2:
                        deletePanel = deleteByFIORankPanel.getDeleteSearchPanel();
                        break;
                }
                deleteSportsmanDialog.add(deletePanel, BorderLayout.CENTER);
                deleteSportsmanDialog.revalidate();
                deletePanel.repaint();
            }
        });

    }


}
