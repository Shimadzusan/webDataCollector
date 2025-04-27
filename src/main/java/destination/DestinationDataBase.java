package destination;

import configuration.Configuration;
import configuration.ConfigurationObject;
import database.PostgreSQL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import util.DataOperation;
import java.util.ArrayList;

public class DestinationDataBase implements Destination {

    public DestinationDataBase(Configuration configuration) {this.configurationObject = configuration.getConfiguration();}
    private final Logger LOG = (Logger) LogManager.getLogger(DestinationDataBase.class);
    ConfigurationObject configurationObject;
    String data = "";
    DataOperation dataOperation = new DataOperation();

    @Override
    public String getDestination() {
        return "getDestination";
    }

    @Override
    public boolean sendData(int number) {
        PostgreSQL psql = new PostgreSQL();
        if(configurationObject.getListCase().get(number).getMode().contains("crawler")) {
            System.out.println(configurationObject.getListCase().get(number).getListInstanceData().size());
            for (int i = 0; i < configurationObject.getListCase().get(number).getListInstanceData().size(); i++) {
                ArrayList<String[]> s = configurationObject.getListCase().get(number).getListInstanceData().get(i).getCrawlerData();
                for (int j = 0; j < s.size(); j++) {
                    System.out.println(s.get(j)[1]);
                    System.out.println(s.get(j)[2].length());
                    psql.sendData(s.get(j)[0], s.get(j)[1], s.get(j)[2]);
                }
                System.out.println("parse crawlerData from Source and write to dataBase");
            }
        }
        return false;
    }
}
