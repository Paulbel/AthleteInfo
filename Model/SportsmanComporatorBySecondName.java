package Model;

import java.util.Comparator;

/**
 * Created by Sinelnikov on 31.03.2017.
 */
public class SportsmanComporatorBySecondName implements Comparator<Sportsman> {
    @Override
    public int compare(Sportsman sportsman1, Sportsman sportsman2) {
        return sportsman1.getSecondName().compareTo(sportsman2.getSecondName());
    }
}