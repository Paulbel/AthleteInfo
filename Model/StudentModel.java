package Model;

import java.util.GregorianCalendar;

/**
 * Created by Sinelnikov on 25.03.2017.
 */
public class StudentModel {
    private String firstName;
    private String secondName;
    private String thirdName;
    private GregorianCalendar dateBirth;
    private String footballTeamName;
    private int titleNumber;
    private String position;
    private String sport;
    private String rank;

    public StudentModel(){
        dateBirth = new GregorianCalendar();
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setSecondName(String secondName){
        this.secondName = secondName;
    }

    public void setThirdName(String thirdName){
        this.thirdName = thirdName;
    }

    public void setDateBirth(GregorianCalendar dateBirth){
        this.dateBirth = dateBirth;
    }

    public void setFootballTeamName(String footballTeamName){
        this.footballTeamName = footballTeamName;
    }

    public void setSquad(){
        //TODO set squad with enum
    }

    public void setPosition(){
        //TODO set Position with enum
    }

    public void setTitleNumber(int titleNumber){
        this.titleNumber = titleNumber;
    }
}
