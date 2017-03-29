package Model;

/**
 * Created by Sinelnikov on 27.03.2017.
 */
public class SportModel {
    private String name;
    private String[] positions;
    String[] rank = {"1 разряд", "2 разряд", "3 разряд", "КМС", "МС"};

    public SportModel(String name, String[] position) {
        this.name = name;
        this.positions = position;
    }

    public String[] getPositions() {
        return positions;
    }

    public String getName() {
        return name;
    }

    public String[] getRanks() {
        return rank;
    }
}
