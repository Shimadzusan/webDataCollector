package debug;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="configuration")
//@XmlRootElement(name="cases")
public class ConfigurationObject {
	String fileConfig;
	int thread;
	String mode;
	Cases cases;
	
	@XmlElement(name="cases")
	public synchronized Cases getCases() {
		return cases;
	}
	public synchronized void setCases(Cases cases) {
		this.cases = cases;
	}
	public synchronized String getFileConfig() {
		return fileConfig;
	}
	public synchronized void setFileConfig(String fileConfig) {
		this.fileConfig = fileConfig;
	}
	public synchronized int getThread() {
		return thread;
	}
	public synchronized void setThread(int thread) {
		this.thread = thread;
	}
	public synchronized String getMode() {
		return mode;
	}
	public synchronized void setMode(String mode) {
		this.mode = mode;
	}

}
