package core;

import java.util.ArrayList;

public class InstanceData {
	String url,marker,regex,tableData,value,columnName,fileDestination,typeOfSourceExtractor,headers,algorithm;
	ArrayList<String[]> crawlerData;

	public synchronized ArrayList<String[]> getCrawlerData() {return crawlerData;}

	public synchronized void setCrawlerData(ArrayList<String[]> crawlerData) {this.crawlerData = crawlerData;}

	public synchronized String getTypeOfSourceExtractor() {return typeOfSourceExtractor;}

	public synchronized void setTypeOfSourceExtractor(String typeOfSourceExtractor) {this.typeOfSourceExtractor = typeOfSourceExtractor;}

	public synchronized String getAlgorithm() {return algorithm;}

	public synchronized void setAlgorithm(String algorithm) {this.algorithm = algorithm;}

	public synchronized String getHeaders() {return headers;}

	public synchronized void setHeaders(String headers) {this.headers = headers;}

	public synchronized String getFileDestination() {
		return fileDestination;
	}

	public synchronized void setFileDestination(String fileDestination) {
		this.fileDestination = fileDestination;
	}
	
	public synchronized String getColumnName() {
		return columnName;
	}

	public synchronized void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	
	public synchronized String getValue() {
		return value;
	}

	public synchronized void setValue(String value) {
		this.value = value;
	}
	
	public synchronized String getUrl() {
		return url;
	}

	public synchronized void setUrl(String url) {
		this.url = url;
	}

	public synchronized String getMarker() {return marker;}

	public synchronized void setMarker(String marker) {
		this.marker = marker;
	}

	public synchronized String getRegex() {
		return regex;
	}

	public synchronized void setRegex(String regex) {
		this.regex = regex;
	}

	public synchronized String getTableData() {
		return tableData;
	}

	public synchronized void setTableData(String tableData) {
		this.tableData = tableData;
	}

}