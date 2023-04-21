package destination;

public class DestinationAlpha implements Destination {

	@Override
	public String getDestination() {
		return "getDestination";
	}

	@Override
	public boolean sendData(int number) {
		return false;
	}

}
