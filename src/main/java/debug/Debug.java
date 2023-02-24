package debug;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import network.HttpRequest;
import util.DataOperation;

public class Debug {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		String text = "в РоссииНа карте 753 вакансии «C#» Найдено 753 вакансии По соответствию За всё время Подработка Подработка Временная работаНеполный деньОт 4 часов в деньРазовое заданиеПо вечерамПо выходным Исключить слова Исключить слова Уровень дохода руб. Не имеет значения от 5 000 руб. 185 от 95 000 руб. 170 от 180 000 руб. 125 от 270 000 руб. 48 от 360 000 руб. 19 от 450 000 руб. 9 Своя зарплата Указан доход 185 Уровень";
//		String text1 = "Компании в РоссииНа карте 2 753 вакансии «C#» Найдено 2 753 вакансии По соответствию За всё время Подработка Подработка Временная работаНеполный деньОт 4 часов в деньРазовое заданиеПо вечерамПо выходным Исключить слова Исключить слова Уровень дохода руб. Не имеет значения от 5 000 руб. 185 от 95 000 руб. 170 от 180 000 руб. 125 от 270 000 руб. 48 от 360 000 руб. 19 от 450 000 руб. 9 Своя зарплата Указан доход 185 Уровень";
//		/* extracting marker from total text */
////        Pattern patternOne = Pattern.compile("[\\w]\\s[0-9]+ ваканси");
////		 Pattern patternOne = Pattern.compile("[\\w] [0-9]+ вакансии По");
//		 Pattern patternOne = Pattern.compile("Найдено.*По соответствию");
//        Matcher matcherOne = patternOne.matcher(text);
//        matcherOne.find();
//        System.out.println("marker: " + matcherOne.group());
//        String found = matcherOne.group();
//        System.out.println("found: " + found);
//        
//		System.out.println(found.replaceAll(" ", ""));
		
//		String url = "https://hh.ru/search/resume?text=C%23&clusters=true&exp_period=all_time&logic=normal&pos=full_text&clusters=true&area=1&specialization=1.221&order_by=publication_time&no_magic=false&from=suggest_post";
//		String text = new HttpRequest().getWebText(url);
//		System.out.println(text);
		
		System.out.println(buildRequest());
	
	}
	
	public static String buildRequest() throws ClassNotFoundException, SQLException {
		String columns = "";
		String values = "";
		DataOperation var1 = new DataOperation();//.. generate date for sql
		
		
		String s = "insert itSector(date," + columns + ") values(" + var1.getDate("YYYYMMdd") + "," + values + ")";	
		System.out.println("buildRequest ...complete");
		return s;
	}
}