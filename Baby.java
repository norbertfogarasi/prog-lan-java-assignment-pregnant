import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.ArrayList;

public class Baby {

	private Date birthday;
	private String name;
	private char gender;
	
	//List of gifts
	private ArrayList<Gift> gifts = new ArrayList<>();
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	//Constructors
	public Baby() {
		birthday = new Date();
		this.name = "Unknown";
		this.gender = 'M';
	}
	
	public Baby(String birthday, String name, char gender) {
		setBirthday(birthday);
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
		return (int) ((System.currentTimeMillis() - birthday.getTime()) / (1000*60*60*24));
	}
	
	//Getters and setters
	public void setBirthday(String birthday) {
		try {
			this.birthday = dateFormat.parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
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
	
	//Overridden methods
	@Override
	public String toString() {
		return name + " " + dateFormat.format(birthday) + " " + gender; 
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		if(this == o) {
			return true;
		}
		if(!(o instanceof Baby)) {
			return false;
		}
		Baby baby = (Baby) o;
		return (name.equals(baby.getName()) && birthday.equals(baby.getBirthday()) && gender == baby.getGender());
	}
	
	//Manage gifts
	public void addGift(Gift gift) {
		gifts.add(gift);
	}
	
	public void listGifts() {
		if(gifts.isEmpty()) {
			System.out.println(name + " doesn't have any gifts!");
		}
		else {
			System.out.println(name + "'s gifts: ");
			for(Gift gift : gifts) {
				System.out.println(gift);
			}
		}
		System.out.println("");
	}
}