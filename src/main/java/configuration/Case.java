package configuration;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import core.InstanceData;

@XmlRootElement(name="case")
public class Case {
	String fileConfig;
	int thread;
	String mode;
	List<InstanceData> listInstanceData = new ArrayList<InstanceData>();
	
	public synchronized List<InstanceData> getListInstanceData() {
		return listInstanceData;
	}
	public synchronized void setListInstanceData(List<InstanceData> listInstanceData) {
		this.listInstanceData = listInstanceData;
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