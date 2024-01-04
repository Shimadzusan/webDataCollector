package configuration;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** subclass Cases in xml document conteins a lot of many 'case' talk yet about casse */
@XmlRootElement(name="cases")
public class Cases {
	Case[] casse;
	
	@XmlElement(name="case")
	public synchronized Case[] getCases() {
		return casse;
	}
	 
	public synchronized void setCases(Case[] cases) {
		this.casse = cases;
	}
	
}