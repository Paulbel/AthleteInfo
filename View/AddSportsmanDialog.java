package View;

import Controller.SportsmanInfo;
import Model.Sport;
import Model.Sportsman;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sinelnikov on 27.03.2017.
 */
public class AddSportsmanDialog {
    JComboBox addPositionCombobox;
    private List<Sport> sportList;
    private List<String> positionsToAdd;

    public AddSportsmanDialog(SportsmanInfo controller) {
        positionsToAdd = new ArrayList<>();
        sportList = controller.getSportsmanInfoData().getSportList();
        JPanel addStudentPanel = new JPanel();
        addStudentPanel.setLayout(new GridLayout(9, 2));

        JPanel addSportPanel = new JPanel();
        addSportPanel.setLayout(new GridLayout(5, 2));

        Border borderAddingStudent = BorderFactory.createTitledBorder("Добавление студента");
        addStudentPanel.setBorder(borderAddingStudent);

        Border borderAddingSport = BorderFactory.createTitledBorder("Добавление вида спорта");
        addSportPanel.setBorder(borderAddingSport);

        JDialog addStudentDialog = new JDialog();
        addStudentDialog.setSize(810, 300);
        addStudentDialog.setLayout(new FlowLayout());

        JLabel addNameLabel = new JLabel("Напишите имя студента:");
        JTextField addNameTextField = new JTextField(10);

        JLabel addSecondNameLabel = new JLabel("Напишите фамилию студента:");
        JTextField addSecondNameTextField = new JTextField(10);

        JLabel addThirdNameLabel = new JLabel("Напишите отчество студента:");
        JTextField addThirdNameTextField = new JTextField(10);

        JLabel setPositionLabel = new JLabel("Выберите позицию:");
        addPositionCombobox = new JComboBox(sportList.get(0).getPositions());
        addPositionCombobox.setEditable(false);


        JLabel addSportLabel = new JLabel("Выберите вид спорта:");
        JComboBox addSportComboBox = new JComboBox(controller.getSportsmanInfoData().getSportNames());
        addSportComboBox.setEditable(false);


        JLabel addTitlesLabel = new JLabel("Введите количество титулов:");
        JTextField addTitleTextField = new JTextField(4);

        JLabel addRankLabel = new JLabel("Выберите разряд:");
        JComboBox addRankComboBox = new JComboBox(sportList.get(0).getRanks());

        JLabel addLineupLabel = new JLabel("Выберите состав:");
        String[] lineup = {"Основной", "Запасной"};
        JComboBox addLineupComboBox = new JComboBox(lineup);


        JButton addStudentButton = new JButton("Добавить студента");


        JLabel addSportNameLabel = new JLabel("Напишите название вида спорта:");
        JTextField addSportNameTextField = new JTextField(10);


        JLabel positionLabel = new JLabel("Cписок добавленных позиций:");
        JComboBox positionsInSportComboBox = new JComboBox();


        JLabel addPositionLabel = new JLabel("Напишите позицию:");
        JTextField addPositionTextField = new JTextField(10);
        JButton addPositionButton = new JButton("Добавить позицию");
        JButton deletePositionButton = new JButton("Удалить позиции");
        JButton addSportButton = new JButton("Добавить вид спорта");


        addStudentPanel.add(addNameLabel);
        addStudentPanel.add(addNameTextField);

        addStudentPanel.add(addSecondNameLabel);
        addStudentPanel.add(addSecondNameTextField);

        addStudentPanel.add(addThirdNameLabel);
        addStudentPanel.add(addThirdNameTextField);

        addStudentPanel.add(addSportLabel);
        addStudentPanel.add(addSportComboBox);

        addStudentPanel.add(setPositionLabel);
        addStudentPanel.add(addPositionCombobox);

        addStudentPanel.add(addLineupLabel);
        addStudentPanel.add(addLineupComboBox);

        addStudentPanel.add(addTitlesLabel);
        addStudentPanel.add(addTitleTextField);


        addStudentPanel.add(addRankLabel);
        addStudentPanel.add(addRankComboBox);


        addStudentPanel.add(addStudentButton);


        addSportPanel.add(addSportNameLabel);
        addSportPanel.add(addSportNameTextField);
        addSportPanel.add(addPositionLabel);
        addSportPanel.add(addPositionTextField);
        addSportPanel.add(positionLabel);
        addSportPanel.add(positionsInSportComboBox);
        addSportPanel.add(addPositionButton);
        addSportPanel.add(deletePositionButton);
        addSportPanel.add(addSportButton);

        addStudentDialog.add(addStudentPanel);
        addStudentDialog.add(addSportPanel);
        addStudentDialog.setVisible(true);

        addSportComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sport selectedSport = sportList.get(addSportComboBox.getSelectedIndex());
                addPositionCombobox.removeAllItems();

                for (int number = 0; number < selectedSport.getPositions().length; number++) {
                    addPositionCombobox.addItem(selectedSport.getPositions()[number]);
                }
            }
        });
        addPositionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!addPositionTextField.getText().equals("")) {
                    String typedString = addPositionTextField.getText();
                    addPositionTextField.setText("");
                    positionsInSportComboBox.addItem(typedString);
                    positionsInSportComboBox.setSelectedItem(typedString);
                    positionsToAdd.add(typedString);
                }

            }
        });

        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!addNameTextField.getText().equals("") && !addSecondNameTextField.getText().equals("") && !addThirdNameTextField.getText().equals("") && !addTitleTextField.getText().equals("")) {
                    Sportsman sportsman = new Sportsman();
                    Sport chosenSport = sportList.get(addSportComboBox.getSelectedIndex());
                    sportsman.setFirstName(addNameTextField.getText());
                    sportsman.setSecondName(addSecondNameTextField.getText());
                    sportsman.setThirdName(addThirdNameTextField.getText());
                    sportsman.setSport(chosenSport);
                    sportsman.setTitleNumber(Integer.parseInt(addTitleTextField.getText()));
                    sportsman.setRank(addRankComboBox.getSelectedIndex());
                    sportsman.setLineup(addLineupComboBox.getSelectedIndex());
                    sportsman.setPosition(addPositionCombobox.getSelectedIndex());
                    controller.addSportsman(sportsman);
                    //System.out.println(controller.getSportsmanInfoData().getSportsmanList().size());
                    controller.refreshMainFrame();
                    //System.out.println(controller.getSportsmanInfoData().getSportList().size());
                }

            }
        });

        deletePositionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                positionsInSportComboBox.removeAllItems();
                positionsToAdd.clear();
            }
        });

        addSportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sportName = addSportNameTextField.getText();
                String[] positionsInSportsArray = new String[positionsInSportComboBox.getItemCount()];
                for (int index = 0; index < positionsToAdd.size(); index++) {
                    positionsInSportsArray[index] = positionsToAdd.get(index);
                }
                addSportNameTextField.setText("");
                addPositionTextField.setText("");
                positionsInSportComboBox.removeAllItems();
                controller.addSport(sportName, positionsInSportsArray);
                addSportComboBox.addItem(sportName);
            }
        });


    }
}