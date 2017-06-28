package View;

import Model.Sportsman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Sinelnikov on 11.04.2017.
 */
public class TableScrollViewPanel extends JPanel {
    private JTable table;
    private JScrollPane scrollPane;
    private int pageNumber;
    private int numberOfSportsmanOnPage;
    private List<Sportsman> sportsmanList;
    private JLabel numberOfPageLabel;
    private JLabel numberOfSportsmanInListLabel;
    private JTextField pageNumberTextField;
    private JComboBox numberOnPageComboBox;

    public TableScrollViewPanel(List<Sportsman> list) {
        super();
        this.sportsmanList = list;
        pageNumber = 1;
        numberOfSportsmanOnPage = sportsmanList.size();

        TableModelWithSportsman tableModelWithSportsman = new TableModelWithSportsman(getPage());
        table = new JTable(tableModelWithSportsman);
        scrollPane = new JScrollPane(table);


        ImageIcon prevPageImage = new ImageIcon("image\\ToggleButtons\\prevPage.png");
        ImageIcon nextPageImage = new ImageIcon("image\\ToggleButtons\\nextPage.png");

        JToolBar southToolBar = new JToolBar("Work with pages", JToolBar.HORIZONTAL);
        JButton nextPageButton = new JButton(nextPageImage);
        JButton prevPageButton = new JButton(prevPageImage);


        numberOnPageComboBox = new JComboBox();
        for (int index = 1; index <= sportsmanList.size(); index++) {
            numberOnPageComboBox.addItem(String.valueOf(index));
        }


        numberOnPageComboBox.setSelectedIndex(sportsmanList.size() - 1);
        numberOfPageLabel = new JLabel("из " + getNumberOfPages());

        JLabel numberOfSportsmanOnPageLabel = new JLabel("На странице:");
        numberOfSportsmanInListLabel = new JLabel("Всего в списке: " + sportsmanList.size());
        pageNumberTextField = new JTextField(2);
        pageNumberTextField.setText(String.valueOf(pageNumber));
        southToolBar.add(numberOfSportsmanOnPageLabel);
        southToolBar.add(numberOnPageComboBox);
        southToolBar.add(prevPageButton);
        southToolBar.add(pageNumberTextField);
        southToolBar.add(numberOfPageLabel);
        southToolBar.add(nextPageButton);
        southToolBar.add(numberOfSportsmanInListLabel);

        southToolBar.setFloatable(false);
        southToolBar.setLayout(new FlowLayout());


        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(southToolBar, BorderLayout.SOUTH);

        scrollPane.setVisible(true);

        nextPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextPage();
            }
        });

        prevPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prevPage();
            }
        });

        numberOnPageComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numberOnPageComboBox.getItemCount() != 0) {
                    numberOfSportsmanOnPage = numberOnPageComboBox.getSelectedIndex() + 1;
                    pageNumber = 1;
                    refreshTable();
                }
            }
        });

        pageNumberTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int wantedPageNumber = Integer.valueOf(pageNumberTextField.getText());
                if (wantedPageNumber <= getNumberOfPages()) {
                    pageNumber = Integer.valueOf(pageNumberTextField.getText());
                    refreshTable();
                }
            }
        });
    }

    public void refreshTable() {
        this.remove(scrollPane);
        TableModelWithSportsman tableModelWithSportsman = new TableModelWithSportsman(getPage());
        table = new JTable(tableModelWithSportsman);
        scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);
        numberOfPageLabel.setText("из " + getNumberOfPages());
        numberOfSportsmanInListLabel.setText("Всего в списке: " + sportsmanList.size());
        pageNumberTextField.setText(String.valueOf(pageNumber));
        // refreshComboBoxNumberOnPage();
        this.revalidate();
        this.repaint();
    }

    public void refreshComboBoxNumberOnPage() {
        numberOnPageComboBox.removeAllItems();
        for (int index = 1; index <= sportsmanList.size(); index++) {
            numberOnPageComboBox.addItem(String.valueOf(index));
        }
        numberOnPageComboBox.setSelectedIndex(sportsmanList.size() - 1);
    }

    public void nextPage() {
        if (pageNumber + 1 <= this.getNumberOfPages()) {
            pageNumber = pageNumber + 1;
        }
        refreshTable();
    }

    public void changeList(List<Sportsman> list) {
        sportsmanList = list;
        if (list.size() < numberOfSportsmanOnPage) {
            numberOfSportsmanOnPage = list.size();
            numberOnPageComboBox.setSelectedIndex(list.size() - 1);
        }
        refreshComboBoxNumberOnPage();
        pageNumber = 1;
        refreshTable();
    }

    public List<Sportsman> getPage() {
        int elementsNumber = pageNumber * numberOfSportsmanOnPage;
        int willBeOnPage;
        if (elementsNumber > sportsmanList.size()) {
            willBeOnPage = numberOfSportsmanOnPage - (elementsNumber - sportsmanList.size());
        } else {
            willBeOnPage = numberOfSportsmanOnPage;
        }
        return sportsmanList.subList(numberOfSportsmanOnPage * (pageNumber - 1), numberOfSportsmanOnPage * (pageNumber - 1) + willBeOnPage);
    }

    public void prevPage() {
        if (pageNumber - 1 > 0) {
            pageNumber = pageNumber - 1;
        }
        refreshTable();
    }

    public int getNumberOfPages() {
        int numberOfPages;
        java.util.List<Sportsman> list = sportsmanList;
        if (numberOfSportsmanOnPage != 0) {
            if (list.size() % numberOfSportsmanOnPage != 0) {
                numberOfPages = list.size() / numberOfSportsmanOnPage + 1;
            } else {
                numberOfPages = list.size() / numberOfSportsmanOnPage;
            }
            return numberOfPages;

        }
        return 0;
    }


}
