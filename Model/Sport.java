package Model;

/**
 * Created by Sinelnikov on 27.03.2017.
 */
//java.util
public class Sport {
    private String name;
    private String[] positions;
    private String[] lineup = {"Основной", "Запасной"};
    private String[] rank = {"1 разряд", "2 разряд", "3 разряд", "КМС", "МС"};

    public Sport(String name, String[] position) {
        this.name = name;
        this.positions = position;
    }

    public String getLineup(int number) {
        return lineup[number];
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

    public String getRankByIndex(int index) {
        return rank[index];
    }
}
