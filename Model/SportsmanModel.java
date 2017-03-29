package Model;

import java.util.GregorianCalendar;

/**
 * Created by Sinelnikov on 25.03.2017.
 */
public class SportsmanModel {
    private String firstName;
    private String secondName;
    private String thirdName;
    private int titleNumber;
    private String position;
    private String sport;
    private String rank;
    private String lineup;

    public SportsmanModel() {

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSport(String sport){
        this.sport = sport;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }


    public void setLineup(String lineup){
        this.lineup = lineup;
    }

    public int getTitleNumber() {
        return titleNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLineup() {
        return lineup;
    }

    public String getPosition() {
        return position;
    }

    public String getRank() {
        return rank;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getSport() {
        return sport;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setTitleNumber(int titleNumber) {
        this.titleNumber = titleNumber;
    }
}
