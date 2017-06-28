package Model;

import Controller.SportsmanInfo;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SportsmanFromFileHandler extends DefaultHandler {
    private List<Sportsman> sportsmanList;
    private Sportsman sportsman;
    private SportsmanInfo controller;

    SportsmanFromFileHandler(SportsmanInfo controller) {
        sportsmanList = new ArrayList<Sportsman>();
        sportsman = null;
        this.controller = controller;
    }

    List<Sportsman> getSportsmanList() {
        return sportsmanList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase(XMLConst.SPORTSMAN)) {
            String secondName = attributes.getValue(XMLConst.SECONDNAME);
            String firstName = attributes.getValue(XMLConst.NAME);
            String thirdName = attributes.getValue(XMLConst.THIRDNAME);
            String rank = attributes.getValue(XMLConst.RANK);
            String lineup = attributes.getValue(XMLConst.LINEUP);
            int titleNumber = Integer.valueOf(attributes.getValue(XMLConst.TITLES));
            String sportName = attributes.getValue(XMLConst.SPORT);
            String position = attributes.getValue(XMLConst.POSITION);
            sportsman = new Sportsman();
            if (controller.getSportsmanInfoData().findSportInList(sportName) == null) {
                String positions[] = new String[1];
                positions[0] = position;
                Sport sport = new Sport(sportName, positions);
                controller.addSport(sportName, positions);
                sportsman.setSport(sport);
            } else {
                sportsman.setSport(controller.getSportsmanInfoData().findSportInList(sportName));
            }
            sportsman.setFirstName(firstName);
            sportsman.setSecondName(secondName);
            sportsman.setThirdName(thirdName);
            sportsman.setLineup(lineup);
            sportsman.setPosition(position);
            sportsman.setRank(rank);
            sportsman.setTitleNumber(titleNumber);
            sportsmanList.add(sportsman);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

    }
}