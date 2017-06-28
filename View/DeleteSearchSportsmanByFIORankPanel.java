package View;

import Controller.SportsmanInfo;
import Model.Sportsman;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by Sinelnikov on 31.03.2017.
 */
public class DeleteSearchSportsmanByFIORankPanel {

    private JTextField addNameTextField;
    private JTextField addSecondnameTextField;
    private JTextField addThirdnameTextField;
    private JComboBox ranksComboBox;
    private SportsmanInfo sportsmanInfo;
    private JPanel deleteSearchPanel;


    public DeleteSearchSportsmanByFIORankPanel(SportsmanInfo controller) {
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
        ranksComboBox = new JComboBox(controller.getSportsmanInfoData().getSportList().get(0).getRanks());

        deleteSearchPanel.add(addNameLabel);
        deleteSearchPanel.add(addNameTextField);

        deleteSearchPanel.add(addSecondnameLabel);
        deleteSearchPanel.add(addSecondnameTextField);
        deleteSearchPanel.add(addThirdnameLabel);
        deleteSearchPanel.add(addThirdnameTextField);
        deleteSearchPanel.add(addSportJLabel);
        deleteSearchPanel.add(ranksComboBox);
        deleteSearchPanel.setVisible(true);
    }

    public void deleteSportsman() {
        String name = addNameTextField.getText();
        String secondname = addSecondnameTextField.getText();
        String thirdname = addThirdnameTextField.getText();
        String rank = sportsmanInfo.getSportsmanInfoData().getSportList().get(0).getRankByIndex(ranksComboBox.getSelectedIndex());
        sportsmanInfo.deleteFIORank(name, secondname, thirdname, rank);
    }

    public List<Sportsman> searchSportsman() {
        String name = addNameTextField.getText();
        String secondname = addSecondnameTextField.getText();
        String thirdname = addThirdnameTextField.getText();
        String rank = sportsmanInfo.getSportsmanInfoData().getSportList().get(0).getRankByIndex(ranksComboBox.getSelectedIndex());
        return sportsmanInfo.searchSportsmanFIORank(name, secondname, thirdname, rank);
    }


    public JPanel getDeleteSearchPanel() {
        return deleteSearchPanel;
    }
}
