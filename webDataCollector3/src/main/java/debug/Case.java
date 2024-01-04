package debug;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="case")
public class Case {
	String fileConfig;
	
	public synchronized String getFileConfig() {
		return fileConfig;
	}
	public synchronized void setFileConfig(String fileConfig) {
		this.fileConfig = fileConfig;
	}
	
}