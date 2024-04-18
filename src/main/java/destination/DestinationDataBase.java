package destination;

public class DestinationDataBase implements Destination {

    @Override
    public String getDestination() {
        return "getDestination";
    }

    @Override
    public boolean sendData(int number) {
        return false;
    }
}
