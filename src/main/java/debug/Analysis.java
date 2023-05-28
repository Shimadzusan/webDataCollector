package debug;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

import database.MySQLDatabase;
import database.MySQLDatabase2;
import database.MySQLExe;
import util.DataOperation;

public class Analysis {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
//		readFromDB();
//		sendCompanyDataToDatabase();
		sendVacanciesDataToDatabase();
		
//		try {
//			MySQLDatabase2.conn();
//			MySQLDatabase2.createDB();
//			//String name, int vacancyId,  int publicationTime, int lastChangeTime, int responsesCount, int totalResponsesCount, String company, String requirements, String skill, String location
//			MySQLDatabase2.writeDB2("Java", 45454, 111, 45454, 55, 66, "Java", "888", "6565", "6669");
//			MySQLDatabase2.closeDB();
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public static void readFromDB() throws IOException {
		new MySQLExe();
	}
	
	public static void sendCompanyDataToDatabase() throws IOException {
		long t = System.currentTimeMillis();
		
		DataOperation dataOper = new DataOperation();
		String s = "";
		String result = "";
		//String[] arr = {"02052023.001","02052023.002","02052023.003","02052023.004","02052023.005","02052023.006","02052023.007","02052023.008","02052023.009","02052023.010","02052023.011","02052023.012","02052023.013","02052023.014","02052023.015"};

		String[] arr = {"30042023.001","30042023.002","30042023.003","30042023.004","30042023.005","30042023.006","30042023.007","30042023.008","30042023.009","30042023.010","30042023.011","30042023.012","30042023.013","30042023.014","30042023.015","30042023.016","30042023.017","30042023.018","30042023.019","30042023.020","30042023.021","30042023.022","30042023.023","30042023.024","30042023.025","30042023.026","30042023.027","30042023.028","30042023.029","30042023.030","30042023.031","30042023.032","30042023.033","30042023.034","30042023.035","30042023.036","30042023.037","30042023.038","30042023.039","30042023.040","30042023.041","30042023.042","30042023.043","30042023.044","30042023.045","30042023.046","30042023.047","30042023.048","30042023.049","30042023.050","30042023.051","30042023.052","30042023.053","30042023.054","30042023.055","30042023.056","30042023.057","30042023.058","30042023.059","30042023.060","30042023.061","30042023.062","30042023.063","30042023.064","30042023.065","30042023.066","30042023.067","30042023.068","30042023.069","30042023.070","30042023.071","30042023.072","30042023.073","30042023.074","30042023.075","30042023.076","30042023.077","30042023.078","30042023.079","30042023.080","30042023.081"};
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i);
			//s = s + dataOper.readDataFromFile("C:\\Users\\user\\Desktop\\eclipse-workspace\\" + arr[i]);
			s = s + dataOper.readDataFromFile("C:\\Users\\user\\Desktop\\eclipse-workspace\\webDataCollector\\30042023\\" + arr[i]);
		}
		
//		try {
////			s = dataOper.readDataFromFile("C:\\Users\\user\\Desktop\\eclipse-workspace\\02052023.002");
//			//s = new MySQLExe().readDataFromDataBase();
//		}
//		catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		System.out.println(s.length());
		JSONObject jobj = new JSONObject(s.replaceAll("\n", ""));
		JSONArray vArray = new JSONArray(jobj.getJSONArray("javaVac").toString());
		
		System.out.println(vArray.length());
		
		for (int i = 0; i < vArray.length(); i++) {
			
			JSONObject jobj2 = new JSONObject(vArray.get(i).toString());
			JSONObject jobj3 = new JSONObject(jobj2.getJSONObject("vacancySearchResult").toString());
	
			JSONArray vArray2 = new JSONArray(jobj3.getJSONArray("vacancies").toString());
			
			
			for (int j = 0; j < vArray2.length(); j++) {
				try {
				result = result + vArray2.get(j).toString() + ";";
				JSONObject jobj4 = new JSONObject(vArray2.get(j).toString());
				JSONObject jobj5 = new JSONObject(jobj4.getJSONObject("company").toString());
				JSONObject jobj6 = new JSONObject(jobj4.getJSONObject("area").toString());
				
				try {
					MySQLDatabase2.conn();
					MySQLDatabase2.createDB();
					MySQLDatabase2.writeDB(jobj5.getString("name"), jobj5.getInt("id"), jobj5.getString("companySiteUrl"), jobj6.getString("name"), "");
					MySQLDatabase2.closeDB();
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(jobj5.getString("name"));
				System.out.println(jobj5.getString("companySiteUrl"));
				System.out.println(jobj5.getInt("id"));
				
				System.out.println(jobj6.getString("name"));
				System.out.println();
				
				} catch(org.json.JSONException e) {
					System.out.println("JSONObject not found");
					
				}
			}

			System.out.println(vArray2.length());
		}
		
//		try {
//			MySQLDatabase2.conn();
//			MySQLDatabase2.createDB();
//			MySQLDatabase2.writeDB();
//			MySQLDatabase2.closeDB();
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//dataOper.writeDataToFile("C:\\Users\\user\\Desktop\\eclipse-workspace\\webDataCollector\\resultJavaDirect2.csv", result);

		long t2 = (System.currentTimeMillis() - t) / 1000;
		System.out.println("time: " + t2 + " sec.");
	}
	
	public static void sendVacanciesDataToDatabase() throws IOException {
		long t = System.currentTimeMillis();
		
		int vacancyId,timestamp,timestamp1 = 0,responsesCount,totalResponsesCount;
		String req = "", skill = "";
		
		DataOperation dataOper = new DataOperation();
		String s = "";
		String result = "";
		//String[] arr = {"02052023.001","02052023.002","02052023.003","02052023.004","02052023.005","02052023.006","02052023.007","02052023.008","02052023.009","02052023.010","02052023.011","02052023.012","02052023.013","02052023.014","02052023.015"};

//		String[] arr = {"30042023.001","30042023.002","30042023.003","30042023.004","30042023.005","30042023.006","30042023.007","30042023.008","30042023.009","30042023.010","30042023.011","30042023.012","30042023.013","30042023.014","30042023.015","30042023.016","30042023.017","30042023.018","30042023.019","30042023.020","30042023.021","30042023.022","30042023.023","30042023.024","30042023.025","30042023.026","30042023.027","30042023.028","30042023.029","30042023.030","30042023.031","30042023.032","30042023.033","30042023.034","30042023.035","30042023.036","30042023.037","30042023.038","30042023.039","30042023.040","30042023.041","30042023.042","30042023.043","30042023.044","30042023.045","30042023.046","30042023.047","30042023.048","30042023.049","30042023.050","30042023.051","30042023.052","30042023.053","30042023.054","30042023.055","30042023.056","30042023.057","30042023.058","30042023.059","30042023.060","30042023.061","30042023.062","30042023.063","30042023.064","30042023.065","30042023.066","30042023.067","30042023.068","30042023.069","30042023.070","30042023.071","30042023.072","30042023.073","30042023.074","30042023.075","30042023.076","30042023.077","30042023.078","30042023.079","30042023.080","30042023.081"};
//		String[] arr = {"14052023.001","14052023.002","14052023.003","14052023.004","14052023.005","14052023.006","14052023.007","14052023.008","14052023.009","14052023.010","14052023.011","14052023.012","14052023.013","14052023.014","14052023.015","14052023.016","14052023.017","14052023.018","14052023.019","14052023.020","14052023.021","14052023.022","14052023.023","14052023.024","14052023.025","14052023.026","14052023.027","14052023.028","14052023.029","14052023.030","14052023.031","14052023.032","14052023.033","14052023.034","14052023.035","14052023.036","14052023.037","14052023.038","14052023.039","14052023.040","14052023.041","14052023.042","14052023.043","14052023.044","14052023.045","14052023.046","14052023.047","14052023.048","14052023.049","14052023.050","14052023.051","14052023.052","14052023.053","14052023.054","14052023.055","14052023.056","14052023.057","14052023.058","14052023.059","14052023.060","14052023.061","14052023.062","14052023.063","14052023.064","14052023.065","14052023.066","14052023.067","14052023.068","14052023.069","14052023.070","14052023.071","14052023.072","14052023.073","14052023.074","14052023.075","14052023.076","14052023.077","14052023.078","14052023.079","14052023.080"};
//		String[] arr = {"15052023.001","15052023.002","15052023.003","15052023.004","15052023.005","15052023.006","15052023.007","15052023.008","15052023.009","15052023.010","15052023.011","15052023.012","15052023.013","15052023.014","15052023.015","15052023.016","15052023.017","15052023.018","15052023.019","15052023.020","15052023.021","15052023.022","15052023.023","15052023.024","15052023.025","15052023.026","15052023.027","15052023.028","15052023.029","15052023.030","15052023.031","15052023.032","15052023.033","15052023.034","15052023.035","15052023.036","15052023.037","15052023.038","15052023.039","15052023.040","15052023.041","15052023.042","15052023.043","15052023.044","15052023.045","15052023.046","15052023.047","15052023.048","15052023.049","15052023.050","15052023.051","15052023.052","15052023.053","15052023.054","15052023.055","15052023.056","15052023.057","15052023.058","15052023.059","15052023.060","15052023.061","15052023.062","15052023.063","15052023.064","15052023.065","15052023.066","15052023.067","15052023.068","15052023.069","15052023.070","15052023.071","15052023.072","15052023.073","15052023.074","15052023.075","15052023.076","15052023.077","15052023.078","15052023.079","15052023.080"};
//		String[] arr = {"16052023.001","16052023.002","16052023.003","16052023.004","16052023.005","16052023.006","16052023.007","16052023.008","16052023.009","16052023.010","16052023.011","16052023.012","16052023.013","16052023.014","16052023.015","16052023.016","16052023.017","16052023.018","16052023.019","16052023.020","16052023.021","16052023.022","16052023.023","16052023.024","16052023.025","16052023.026","16052023.027","16052023.028","16052023.029","16052023.030","16052023.031","16052023.032","16052023.033","16052023.034","16052023.035","16052023.036","16052023.037","16052023.038","16052023.039","16052023.040","16052023.041","16052023.042","16052023.043","16052023.044","16052023.045","16052023.046","16052023.047","16052023.048","16052023.049","16052023.050","16052023.051","16052023.052","16052023.053","16052023.054","16052023.055","16052023.056","16052023.057","16052023.058","16052023.059","16052023.060","16052023.061","16052023.062","16052023.063","16052023.064","16052023.065","16052023.066","16052023.067","16052023.068","16052023.069","16052023.070","16052023.071","16052023.072","16052023.073","16052023.074","16052023.075","16052023.076","16052023.077","16052023.078","16052023.079","16052023.080"};
		String[] arr = {"24052023.001","24052023.002","24052023.003","24052023.004","24052023.005","24052023.006","24052023.007","24052023.008","24052023.009","24052023.010","24052023.011","24052023.012","24052023.013","24052023.014","24052023.015","24052023.016","24052023.017","24052023.018","24052023.019","24052023.020","24052023.021","24052023.022","24052023.023","24052023.024","24052023.025","24052023.026","24052023.027","24052023.028","24052023.029","24052023.030","24052023.031","24052023.032","24052023.033","24052023.034","24052023.035","24052023.036","24052023.037","24052023.038","24052023.039","24052023.040","24052023.041","24052023.042","24052023.043","24052023.044","24052023.045","24052023.046","24052023.047","24052023.048","24052023.049","24052023.050","24052023.051","24052023.052","24052023.053","24052023.054","24052023.055","24052023.056","24052023.057","24052023.058","24052023.059","24052023.060","24052023.061","24052023.062","24052023.063","24052023.064","24052023.065","24052023.066","24052023.067","24052023.068","24052023.069","24052023.070","24052023.071","24052023.072","24052023.073","24052023.074","24052023.075","24052023.076","24052023.077","24052023.078","24052023.079","24052023.080","24052023.081","24052023.082","24052023.083"};
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i);
			//s = s + dataOper.readDataFromFile("C:\\Users\\user\\Desktop\\eclipse-workspace\\" + arr[i]);
			s = s + dataOper.readDataFromFile("C:\\Users\\user\\Desktop\\eclipse-workspace\\webDataCollector\\24052023\\" + arr[i]);
		}
		
		System.out.println(s.length());
		JSONObject jobj = new JSONObject(s.replaceAll("\n", ""));
		JSONArray vArray = new JSONArray(jobj.getJSONArray("javaVac").toString());
		
		System.out.println(vArray.length());
		
		for (int i = 0; i < vArray.length(); i++) {
			
			JSONObject jobj2 = new JSONObject(vArray.get(i).toString());
			JSONObject jobj3 = new JSONObject(jobj2.getJSONObject("vacancySearchResult").toString());
	
			JSONArray vArray2 = new JSONArray(jobj3.getJSONArray("vacancies").toString());
			
			
			for (int j = 0; j < vArray2.length(); j++) {
				try {
				result = result + vArray2.get(j).toString() + ";";
				JSONObject jobj4 = new JSONObject(vArray2.get(j).toString());
				JSONObject jobj5 = new JSONObject(jobj4.getJSONObject("company").toString());
				JSONObject jobj6 = new JSONObject(jobj4.getJSONObject("area").toString());
				
				//JSONObject jobj10 = new JSONObject(jobj4.getJSONObject("company").toString());
				System.out.println("vacName: " + jobj4.getString("name"));
				System.out.println(jobj4.getInt("responsesCount"));
				System.out.println(jobj4.getInt("totalResponsesCount"));
				System.out.println(jobj4.getInt("vacancyId"));
				
				JSONObject jobj10 = new JSONObject(jobj4.getJSONObject("snippet").toString());
				
				try {
					skill = jobj10.getString("skill");
					req = jobj10.getString("req");
				System.out.println(jobj10.getString("skill"));
				System.out.println(jobj10.getString("req"));
				}
				catch(org.json.JSONException e) {
					System.out.println("JSONObject not found");
					
				}
				
				
				JSONObject jobj11 = new JSONObject(jobj4.getJSONObject("publicationTime").toString());
				System.out.println(jobj11.getInt("@timestamp"));
				
				
				try {
				JSONObject jobj12 = new JSONObject(jobj4.getJSONObject("lastChangeTime").toString());
				System.out.println(jobj12.getInt("@timestamp"));
				timestamp1 = jobj12.getInt("@timestamp");
				}
				catch(org.json.JSONException e) {
					System.out.println("JSONObject not found");
					
				}
				
				
				System.out.println("company: " + jobj5.getString("name"));
				System.out.println("area: " + jobj6.getString("name"));
				
				
				try {
					MySQLDatabase2.conn();
					MySQLDatabase2.createDB();
					//String name, int vacancyId,  int publicationTime, int lastChangeTime, int responsesCount, int totalResponsesCount, String company, String requirements, String skill, String location
					MySQLDatabase2.writeDB2(jobj4.getString("name"), jobj4.getInt("vacancyId"), jobj11.getInt("@timestamp"), timestamp1, jobj4.getInt("responsesCount"), jobj4.getInt("totalResponsesCount"), jobj5.getString("name"), req, skill, jobj6.getString("name"));
					MySQLDatabase2.closeDB();
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println();
				
				} catch(org.json.JSONException e) {
					System.out.println("JSONObject not found");
					
				}
			}

			System.out.println(vArray2.length());
		}
		
		//dataOper.writeDataToFile("C:\\Users\\user\\Desktop\\eclipse-workspace\\webDataCollector\\resultJavaDirect2.csv", result);

		long t2 = (System.currentTimeMillis() - t) / 1000;
		System.out.println("time: " + t2 + " sec.");
	}

}
