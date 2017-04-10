package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sinelnikov on 31.03.2017.
 */
public class  SportsmanInfoData {
    private List<Sport> sportList;
    private List<Sportsman> sportsmanList;
    public SportsmanInfoData(){
        sportList = new ArrayList<>();
        sportsmanList = new ArrayList<>();
    }


    public void addSportsman(Sportsman sportsman){
        sportsmanList.add(sportsman);
        sportsmanList.sort(new SportsmanComporatorBySecondName());
    }


    public void addSport(Sport sport){
        sportList.add(sport);
      //  sportList.sort(new SportComporatorByName());
    }


    public List<Sport> getSportList() {
        return sportList;
    }

    public List<Sportsman> getSportsmanList() {
        return sportsmanList;
    }

    public List<Sportsman> searhSportsmanByFIOSportName(String firstname, String secondname, String thirdname, Sport sport){
        Sportsman sportsman;
        List<Sportsman> foundSportsmanList = new ArrayList<>();
        for (int index = 0; index < sportsmanList.size(); index++){
            sportsman = sportsmanList.get(index);
            if(sportsman.getSport().equals(sport)
                    &&sportsman.getFirstName().equals(firstname)
                    &&sportsman.getThirdName().equals(thirdname)){
                foundSportsmanList.add(sportsman);
            }
        }
        return foundSportsmanList;
    }

    public List<Sportsman> searhSportsmanByFIORank(String firstname, String secondname, String thirdname, String rank){
        Sportsman sportsman;
        List<Sportsman> foundSportsmanList = new ArrayList<>();
        for (int index = 0; index < sportsmanList.size(); index++){
            sportsman = sportsmanList.get(index);
            if(sportsman.getRank().equals(rank)
                    &&sportsman.getFirstName().equals(firstname)
                    &&sportsman.getThirdName().equals(thirdname)){
                foundSportsmanList.add(sportsman);
            }
        }
        return foundSportsmanList;
    }



    public void deleteSportsman(String firstname, String secondname, String thirdname, Sport sport){
        List<Sportsman> toDeleteList= searhSportsmanByFIOSportName(firstname,secondname,thirdname,sport);
        for (int index = 0; index < toDeleteList.size(); index++){
            sportsmanList.remove(toDeleteList.get(index));
        }

    }

    public void deleteSportsman(String firstname, String secondname, String thirdname, String rank){
        List<Sportsman> toDeleteList= searhSportsmanByFIORank(firstname,secondname,thirdname,rank);
        for (int index = 0; index < toDeleteList.size(); index++){
            sportsmanList.remove(toDeleteList.get(index));
        }

    }


    public List<Sportsman> searchSportsmanByTitles(int from, int to){
        List<Sportsman> foundSportsmanList = new ArrayList<>();

        for (int index = 0; index < sportsmanList.size(); index++){
            if(from<=sportsmanList.get(index).getTitleNumber()&&sportsmanList.get(index).getTitleNumber()<=to){
                foundSportsmanList.add(sportsmanList.get(index));
            }

        }
        return foundSportsmanList;
    }


    public void deleteSportsman(int from, int to){
        List<Sportsman> toDeleteList = searchSportsmanByTitles(from, to);
        for (int index = 0; index < toDeleteList.size(); index++){
            sportsmanList.remove(toDeleteList.get(index));
        }
    }


    public String [] getSportNames(){
        List<String> namesList= new ArrayList<>();
        String [] namesArray = new String[sportList.size()];
        for(int number = 0; number < sportList.size(); number++){
            namesArray[number] = sportList.get(number).getName();
        }
        return namesArray;
    }
}
