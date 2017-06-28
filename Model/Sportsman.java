package Model;

/**
 * Created by Sinelnikov on 25.03.2017.
 */
public class Sportsman {
    private String firstName;
    private String secondName;
    private String thirdName;
    private int titleNumber;
    private String position;
    private String rank;
    private String lineup;
    private Sport sport;

    public Sportsman() {

    }

    public void setSport(Sport sport) {
        this.sport = sport;
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

    public void setLineup(int number) {
        lineup = sport.getLineup(number);
    }

    public void setLineup(String lineup) {
        this.lineup = lineup;
    }

    public void setPosition(int indexInPositionArrayNumber) {
        position = sport.getPositions()[indexInPositionArrayNumber];
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setTitleNumber(int titleNumber) {
        this.titleNumber = titleNumber;
    }

    public void setRank(int number) {
        rank = sport.getRanks()[number];
    }

    public void setRank(String rank) {
        this.rank = rank;
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

    public String getSportName() {
        return sport.getName();
    }

    public Sport getSport() {
        return sport;
    }

    public String getThirdName() {
        return thirdName;
    }


}
