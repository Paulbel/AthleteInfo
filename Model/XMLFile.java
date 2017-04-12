package Model;

import Controller.SportsmanInfo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * Created by Sinelnikov on 12.04.2017.
 */
public class XMLFile {
    private String fileName;
    private SportsmanInfo controller;
    private List<Sportsman> sportsmanList;

    public XMLFile(String fileName, SportsmanInfo controller){
        this.fileName = fileName;
        this.controller = controller;
        sportsmanList = controller.getSportsmanInfoData().getSportsmanList();
    }
    public void writeFile() throws IOException, TransformerException, ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element rootElement = document.createElement(XMLConst.SPORTSMEN);
        document.appendChild(rootElement);



        for (int index = 0; index < sportsmanList.size(); index++){
            Sportsman sportsman = sportsmanList.get(index);
            Element sportsmanElement = document.createElement(XMLConst.SPORTSMAN);
            rootElement.appendChild(sportsmanElement);

            String element = sportsmanList.get(index).getSecondName();
            sportsmanElement.setAttribute(XMLConst.SECONDNAME, element);
            element = sportsman.getFirstName();
            sportsmanElement.setAttribute(XMLConst.NAME, element);
            element = sportsman.getThirdName();
            sportsmanElement.setAttribute(XMLConst.THIRDNAME, element);
            element = sportsman.getSportName();
            sportsmanElement.setAttribute(XMLConst.SPORT, element);
            element = sportsman.getRank();
            sportsmanElement.setAttribute(XMLConst.RANK, element);
            element = String.valueOf(sportsman.getTitleNumber());
            sportsmanElement.setAttribute(XMLConst.TITLES, element);
            element = sportsman.getPosition();
            sportsmanElement.setAttribute(XMLConst.POSITION, element);
            element = sportsman.getLineup();
            sportsmanElement.setAttribute(XMLConst.LINEUP, element);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            Properties outFormat = new Properties();
            outFormat.setProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperties(outFormat);
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(fileName));
            transformer.transform(source, result);
        }
    }
    void readFile(){
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SportsmanFromFileHandler sportsmanFromFileHandler = new SportsmanFromFileHandler(controller);
            saxParser.parse(new File(fileName), sportsmanFromFileHandler);

            List<Sportsman> sportsmanList = sportsmanFromFileHandler.getSportsmanList();
            controller.changeData(sportsmanList);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}