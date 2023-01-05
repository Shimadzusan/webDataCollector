package core;

public class InstanceData {
	String url,marker,regex,tableData;

	public synchronized String getUrl() {
		return url;
	}

	public synchronized void setUrl(String url) {
		this.url = url;
	}

	public synchronized String getMarker() {
		return marker;
	}

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
