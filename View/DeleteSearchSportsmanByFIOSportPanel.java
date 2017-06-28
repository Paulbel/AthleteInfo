package View;

import Controller.SportsmanInfo;
import Model.Sport;
import Model.Sportsman;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sinelnikov on 31.03.2017.
 */
public class DeleteSearchSportsmanByFIOSportPanel {

    private JTextField addNameTextField;
    private JTextField addSecondnameTextField;
    private JTextField addThirdnameTextField;
    private JComboBox sportComboBox;
    private SportsmanInfo sportsmanInfo;
    private JPanel deleteSearchPanel;

    public DeleteSearchSportsmanByFIOSportPanel(SportsmanInfo controller) {
        this.sportsmanInfo = controller;
        deleteSearchPanel = new JPanel();
        deleteSearchPanel.setLayout(new GridLayout(4, 2));
        JLabel addNameLabel = new JLabel("Имя");
        addNameTextField = new JTextField(10);

        JLabel addSecondnameLabel = new JLabel("Фамилия");
        addSecondnameTextField = new JTextField(10);
        JLabel addThirdnameLabel = new JLabel("Отчество");
        addThirdnameTextField = new JTextField(10);
        JLabel addSportJLabel = new JLabel("Спорт:");
        sportComboBox = new JComboBox(controller.getSportsmanInfoData().getSportNames());

        deleteSearchPanel.add(addNameLabel);
        deleteSearchPanel.add(addNameTextField);
        deleteSearchPanel.add(addSecondnameLabel);
        deleteSearchPanel.add(addSecondnameTextField);
        deleteSearchPanel.add(addThirdnameLabel);
        deleteSearchPanel.add(addThirdnameTextField);
        deleteSearchPanel.add(addSportJLabel);
        deleteSearchPanel.add(sportComboBox);
        deleteSearchPanel.setVisible(true);
    }


    public void deleteSportsman() {
        String name = addNameTextField.getText();
        String secondname = addSecondnameTextField.getText();
        String thirdname = addThirdnameTextField.getText();
        Sport sport = sportsmanInfo.getSportsmanInfoData().getSportList().get(sportComboBox.getSelectedIndex());
        sportsmanInfo.deleteFIOSport(name, secondname, thirdname, sport);
    }


    public java.util.List<Sportsman> searchSportsman() {
        String name = addNameTextField.getText();
        String secondname = addSecondnameTextField.getText();
        String thirdname = addThirdnameTextField.getText();
        Sport sport = sportsmanInfo.getSportsmanInfoData().getSportList().get(sportComboBox.getSelectedIndex());
        return sportsmanInfo.searchSportsmanFIOSport(name, secondname, thirdname, sport);
    }

    public JPanel getDeleteSearchPanel() {
        return deleteSearchPanel;
    }
}
