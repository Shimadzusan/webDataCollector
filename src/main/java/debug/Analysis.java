package debug;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import util.DataOperation;

public class Analysis {

	public static void main(String[] args) throws IOException {
		long t = System.currentTimeMillis();
		
		DataOperation dataOper = new DataOperation();
		String s = "";
		String result = "";
		try {
			s = dataOper.readDataFromFile("C:\\Users\\user\\Desktop\\eclipse-workspace\\webDataCollector\\02052023.json");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(s.length());
		JSONObject jobj = new JSONObject(s);
		JSONArray vArray = new JSONArray(jobj.getJSONArray("javaVac").toString());
		
		System.out.println(vArray.length());
		for (int i = 0; i < vArray.length(); i++) {
			
			JSONObject jobj2 = new JSONObject(vArray.get(i).toString());
			JSONObject jobj3 = new JSONObject(jobj2.getJSONObject("vacancySearchResult").toString());
	
			JSONArray vArray2 = new JSONArray(jobj3.getJSONArray("vacancies").toString());
			
			for (int j = 0; j < vArray2.length(); j++) {
				result = result + vArray2.get(j).toString() + ";";
				System.out.println(vArray2.get(j).toString());
				System.out.println("result size: " + result.length());
			}

			System.out.println(vArray2.length());
		}
		
		dataOper.writeDataToFile("C:\\Users\\user\\Desktop\\eclipse-workspace\\webDataCollector\\resultJavaDirect2.csv", result);

		long t2 = (System.currentTimeMillis() - t) / 1000;
		System.out.println("time: " + t2 + " sec.");
	}

}
