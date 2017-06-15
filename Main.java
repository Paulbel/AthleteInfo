import Controller.MyFileChooser;
import Controller.SportsmanInfo;
import org.omg.PortableServer.THREAD_POLICY_ID;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sinelnikov on 29.03.2017.
 */
public class Main {
    public static void main(String[] args) {

                SportsmanInfo controller = new SportsmanInfo();
        //Thread.currentThread().setDaemon(true);
                controller.run();
                //MyFileChooser myFileChooser = new MyFileChooser();
        }
    }

