package GenericActions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.WebElement;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

public class GenericDataActions {
	public final String STANDARD_DATETIME_FORMAT = "MM/dd/YY HH:mm:ss";
	
	public GenericDataActions() {
		
	}
	
	public ArrayList<String> getAvailableTimeZoneIDs() {
		return new ArrayList<String>(DateTimeZone.getAvailableIDs());
	}
	
	/**
	 * Gets today's date in the Manila, Philippines
	 * @param format https://www.joda.org/joda-time/apidocs/org/joda/time/format/DateTimeFormat.html
	 * @return
	 */
	public String getDateTodayPH(String format) {
		DateTimeFormatter dtf = DateTimeFormat.forPattern(format);
		DateTimeZone timeZone = DateTimeZone.forID("Asia/Manila");
		DateTime currentDate = DateTime.now(timeZone);
		
		return dtf.print(currentDate);  
	}
	
	/**
	 * Gets today's date in Melbourne, Australia
	 * @param format https://www.joda.org/joda-time/apidocs/org/joda/time/format/DateTimeFormat.html
	 * @return
	 */
	public String getDateTodayAUS(String format) {
		DateTimeFormatter dtf = DateTimeFormat.forPattern(format);
		DateTimeZone timeZone = DateTimeZone.forID("Australia/Melbourne");
		DateTime currentDate = DateTime.now(timeZone);
		
		return dtf.print(currentDate);  
	}
	
	/**
	 * Gets today's date in Kolkata, India
	 * @param format https://www.joda.org/joda-time/apidocs/org/joda/time/format/DateTimeFormat.html
	 * @return
	 */
	public String getDateTodayIND(String format) {
		DateTimeFormatter dtf = DateTimeFormat.forPattern(format);
		DateTimeZone timeZone = DateTimeZone.forID("Asia/Kolkata");
		DateTime currentDate = DateTime.now(timeZone);
		
		return dtf.print(currentDate);  
	}
	
	public String generateWords(int range1, int range2) {
        Lorem lorem = (Lorem)LoremIpsum.getInstance();
        return lorem.getWords(range1, range2);
    }
    
    public int generateRandomInt(int range) {
        return new Random().nextInt(range);
    }
    
    public String generateParagraph() {
        Lorem lorem = (Lorem)LoremIpsum.getInstance();
        return lorem.getParagraphs(1, 1);
    }
    
    public String generateTitle() {
        Lorem lorem = (Lorem)LoremIpsum.getInstance();
        return lorem.getTitle(1).toUpperCase();
    }
    
    public String generateRandomEmail() {
        Lorem lorem = (Lorem)LoremIpsum.getInstance();
        return lorem.getEmail();
    }
    
    public String generateRandomName() {
        Lorem lorem = (Lorem)LoremIpsum.getInstance();
        return lorem.getFirstName();
    }
    
    public String generateRandomLastName() {
        return LoremIpsum.getInstance().getLastName();
    }
    
    public String generateRandomAddress() {
        return String.valueOf(LoremIpsum.getInstance().getStateAbbr()) + LoremIpsum.getInstance().getCity() + LoremIpsum.getInstance().getWords(1);
    }
    
    public String generateRandomCity() {
        return LoremIpsum.getInstance().getCity();
    }
    
    public String generateRandomCountry() {
        return LoremIpsum.getInstance().getCountry();
    }
    
    public String generateRandomStateProvince() {
        return LoremIpsum.getInstance().getStateFull();
    }
    
    public String generateRandomPostalZip() {
        return LoremIpsum.getInstance().getZipCode();
    }
    
    public String randomize(int max, int min) {
        Random rand = new Random();
        int x = rand.nextInt(max) + min;
        return Integer.toString(x);
    }
    
    public Date parseStringToDate(String dateFormat, String date) throws ParseException {
        return new SimpleDateFormat(dateFormat).parse(date);
    }
    
    public String formatDate(String dateFormat, Date date) {
        DateFormat newDateFormat = new SimpleDateFormat(dateFormat);
        return newDateFormat.format(date);
    }
    
    public String convertRGBtoHex(WebElement elem, String cssValue) {
        try {
            String element = elem.getCssValue(cssValue);
            element = element.replaceAll("[A-Za-z]", "");
            String[] color = element.replaceAll("[!\\()]", "").split(",");
            String hexValue = String.format("#%02x%02x%02x", Integer.parseInt(color[0].trim()), Integer.parseInt(color[1].trim()), Integer.parseInt(color[2].trim()));
            return hexValue;
        }
        catch (Exception e) {
            throw e;
        }
    }
    
    public String generateRandomString(int length) {
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        return generatedString;
    }
}
