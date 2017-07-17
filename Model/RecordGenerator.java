package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by Sinelnikov on 17.07.2017.
 */
public class RecordGenerator {
    private Random random;
    private final String[] names;
    private final String[] surNames;
    private final String[] thirdName;
    private SportsmanInfoData data;
    public RecordGenerator(SportsmanInfoData sportsmanInfoData) {
        this.data = sportsmanInfoData;
        random = new Random();
        names = new String[]{
                "Андрей", "Артем", "Афанасий",
                "Дмитрий", "Евгений", "Павел",
                "Иван", "Александр", "Алексей",
                "Юрий", "Максим", "Михаил",
                "Генрих", "Федор", "Георгий"};
        surNames = new String[]{
                "Синельников", "Ковалев", "Иванов",
                "Сергеев", "Давыденко", "Иванов",
                "Рябцев", "Артемьев", "Гапеенко",
                "Савченко"
        };
        thirdName = new String[]{
                "Андреевич", "Афанасьевич",
                "Дмитриевич", "Евгеньевич", "Павлович",
                "Иванович", "Александрович", "Алексеевич",
                "Юрьевич", "Максимович", "Михайлович",
                "Федорович", "Георгиевич"
        };

    }

    public ArrayList<Sportsman> generateList(int number) {
        ArrayList<Sportsman> list = new ArrayList<>();
        Sportsman sportsman;
        for (int index = 0; index < number; index++){
            sportsman = new Sportsman();

            sportsman.setFirstName(names[random.nextInt(names.length)]);
            sportsman.setSecondName(surNames[random.nextInt(surNames.length)]);
            sportsman.setThirdName(thirdName[random.nextInt(thirdName.length)]);
            List<Sport> arrayList = data.getSportList();
            Sport sport = arrayList.get(random.nextInt(arrayList.size()));
            sportsman.setSport(sport);
            String [] positions = sport.getPositions();
            String [] lineups = sport.getLineup();
            String [] ranks = sport.getRank();
            sportsman.setPosition(positions[random.nextInt(positions.length)]);
            sportsman.setLineup(lineups[random.nextInt(lineups.length)]);
            sportsman.setRank(ranks[random.nextInt(ranks.length)]);
            sportsman.setTitleNumber(random.nextInt(100));
            list.add(sportsman);
        }
        return list;
    }
}
