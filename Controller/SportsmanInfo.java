package Controller;

import Model.Sportsman;
import View.TableModelWithSportsman;
import View.AddSportsmanDialog;
import View.MainFrame;
import View.SportsmanTable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sinelnikov on 29.03.2017.
 */
public class SportsmanInfo {
    private TableModelWithSportsman tableModelWithSportsman;
    private MainFrame mainFrame;
    private List<Sportsman> sportsmanList;
    public void run() {
        sportsmanList = new ArrayList<>();
        mainFrame = new MainFrame(this);


       // SportsmanTable sportsmanTable = new SportsmanTable(sportsmanList);

        Sportsman sportsman = new Sportsman();
        sportsman.setFirstName("Павел");
        sportsman.setSecondName("Синельников");
        sportsman.setThirdName("Михайлович");
        sportsman.setLineup("Основной");
        sportsman.setPosition("ФРВ");
        sportsman.setSport("Футбол");
        sportsman.setRank("КМС");
        sportsman.setTitleNumber(2);


        Sportsman sportsman1 = new Sportsman();
        sportsman1.setFirstName("Максим");
        sportsman1.setSecondName("Стельмаченок");
        sportsman1.setThirdName("Олегович");
        sportsman1.setLineup("Основний");
        sportsman1.setPosition("Нет");
        sportsman1.setSport("Бокс");
        sportsman1.setRank("МС");
        sportsman1.setTitleNumber(2);


        Sportsman sportsman2 = new Sportsman();
        sportsman2.setFirstName("Алексей");
        sportsman2.setSecondName("Шульга");
        sportsman2.setThirdName("Юрьевич");
        sportsman2.setLineup("Основний");
        sportsman2.setPosition("ФРВ");
        sportsman2.setSport("Футбол");
        sportsman2.setRank("КМС");
        sportsman2.setTitleNumber(5);


        Sportsman sportsman3 = new Sportsman();
        sportsman3.setFirstName("Jesse");
        sportsman3.setSecondName("Elis");
        sportsman3.setThirdName("Lingard");
        sportsman3.setLineup("Основний");
        sportsman3.setPosition("ЦАП");
        sportsman3.setSport("Футбол");
        sportsman3.setRank("МС");
        sportsman3.setTitleNumber(10);

        sportsmanList.add(sportsman);
        sportsmanList.add(sportsman1);
        sportsmanList.add(sportsman2);
        sportsmanList.add(sportsman3);


        JScrollPane scrollPane = new JScrollPane(new SportsmanTable(sportsmanList));
        scrollPane.setVisible(true);




        mainFrame.add(scrollPane, BorderLayout.CENTER);
        mainFrame.setVisible(true);
    }

    public void exit(JFrame frame) {

    }

    public void addSportsman(Sportsman sportsman) {
        tableModelWithSportsman = mainFrame.getTableModelWithSportsman();
       // tableModelWithSportsman.addSportsman(sportsman);
        mainFrame.refreshTable();

    }


      public void openDialogAddingSportsman() {
        AddSportsmanDialog addDialog = new AddSportsmanDialog(this);
    }


}
