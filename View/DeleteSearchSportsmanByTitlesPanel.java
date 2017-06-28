package View;

import Controller.SportsmanInfo;
import Model.Sportsman;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by Sinelnikov on 01.04.2017.
 */
public class DeleteSearchSportsmanByTitlesPanel {
    private JTextField lowerBorderTextField;
    private JTextField upperBorderTextField;
    private SportsmanInfo controller;
    private JPanel deleteSearchPanel;

    public DeleteSearchSportsmanByTitlesPanel(SportsmanInfo controller) {
        this.controller = controller;
        deleteSearchPanel = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        deleteSearchPanel.setLayout(gridBagLayout);

        JLabel addLowerBorderLabel = new JLabel("От:");
        lowerBorderTextField = new JTextField(4);

        JLabel addUpperBorderLabel = new JLabel("До:");
        upperBorderTextField = new JTextField(4);
        JLabel userInfoLabel = new JLabel("Напишите кол- вот титулов:");

        gridBagConstraints.insets = new Insets(0, 0, 8, 0);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        deleteSearchPanel.add(userInfoLabel, gridBagConstraints);

        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 100;
        deleteSearchPanel.add(addLowerBorderLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        deleteSearchPanel.add(addUpperBorderLabel, gridBagConstraints);

        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 40;
        deleteSearchPanel.add(lowerBorderTextField, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        deleteSearchPanel.add(upperBorderTextField, gridBagConstraints);
        deleteSearchPanel.setVisible(true);
    }

    public void deleteSportsman() {
        int lower = Integer.valueOf(lowerBorderTextField.getText());
        int upper = Integer.valueOf(upperBorderTextField.getText());
        controller.deleteTitle(lower, upper);
    }


    public List<Sportsman> searchSportsman() {
        int lower = Integer.valueOf(lowerBorderTextField.getText());
        int upper = Integer.valueOf(upperBorderTextField.getText());
        return controller.searchSportsmanTitles(lower, upper);
    }

    public JPanel getDeleteSearchPanel() {
        return deleteSearchPanel;
    }
}
