package Model;

import java.util.Comparator;

/**
 * Created by Sinelnikov on 31.03.2017.
 */
public class SportComporatorByName implements Comparator<Sport> {
    @Override
    public int compare(Sport sport1, Sport sport2) {
        return sport1.getName().compareTo(sport2.getName());
    }
}