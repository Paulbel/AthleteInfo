package Model;

import Model.SportModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sinelnikov on 27.03.2017.
 */
public class SportList {
    private List <SportModel> sports;
    public SportList(){
        sports = new ArrayList<SportModel>(0);
    }
    public void addSportType(String name, String [] positions){
        SportModel sport = new SportModel(name, positions);
        sports.add(sport);
    }
    public Object [] getSportArray(){
        return sports.toArray();
    }
    public List<SportModel> getSportList(){
        return sports;
    }
    public String [] getPositionsArray(int index){
        return sports.get(index).getPositions();
    }
    public  String [] getSportNames(){
        String [] sportNames = new String[sports.size()];
        for(int index = 0; index < sports.size(); index++){
            sportNames[index] = sports.get(index).getName();
        }
        return sportNames;
    }

    public String [] getPositionsOfSportByName(String nameOfSport){
        return sports.get(sports.indexOf(nameOfSport)).getPositions();
    }

    public String [] getRanksArray(int sportNumber){
        return sports.get(sportNumber).getRanks();
    }

}
