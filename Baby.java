import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;

public class Baby {

	private Date birthday;
	private String name;
	private char gender;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	//Constructors
	public Baby() {

	}
	
	public Baby(String birthday, String name, char gender) {
		try {
			this.birthday = dateFormat.parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.name = name;
		this.gender = gender;
	}
	
	public Baby(Date birthday, String name, char gender) {
		this.birthday = birthday;
		this.name = name;
		this.gender = gender;
	}
	
	// If a given kid is older than the current one
	public boolean isOlder(Baby baby) {
		return birthday.before(baby.getBirthday());
	}

	// The actual age of the kid in days
	public int howOld() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(birthday);
		return cal.get(Calendar.DAY_OF_MONTH);
	}
	
	public void setBirthday(String birthday) {
	
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	} 
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public char getGender() {
		return gender;
	}
	
	@Override
	public String toString() {
		return name + " " + dateFormat.format(birthday) + " " + gender; 
	}
}