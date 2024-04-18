package configuration;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="configuration")
public class ConfigurationObject {
	Cases cases;
	List<Case> listCase = new ArrayList<Case>();
	
	public synchronized List<Case> getListCase() {return listCase;}
	
	public synchronized void setListCase(List<Case> listCase) {this.listCase = listCase;}
	
	@XmlElement(name="cases")
	public synchronized Cases getCases() {return cases;}
	
	public synchronized void setCases(Cases cases) {this.cases = cases;}

}
