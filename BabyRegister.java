import java.util.*;

public class BabyRegister {
	
	ArrayList<Baby> babies = new ArrayList<>();
	
	public static void main(String[] args) {
	
		BabyRegister register = new BabyRegister();
		
		//Babies
		Baby baby1 = new Baby("02/07/1997 22:00", "Norbert", 'M');
		Date date1 = new Date(System.currentTimeMillis() - 555_000_000);
		Baby baby2 = new Baby(date1, "Robert", 'M');	
		Baby baby3 = new Baby();
		Baby baby4 = new Baby("01/01/2001 23:12", "Jessica", 'F');
		Date date5 = new Date(System.currentTimeMillis() - 999_000_000);
		Baby baby5 = new Baby(date5, "George", 'M');
		
		//Gifts
		Gift gift1 = new Gift("John", "Clothes", new Date());
		Gift gift2 = new Gift("John", "Shoes", new Date());
		Gift gift3 = new Gift("Michael", "Toys", new Date());
			
		//Register babies
		register.addBaby(baby1);
		register.addBaby(baby2);
		register.addBaby(baby3);
		register.addBaby(baby4);
		register.addBaby(baby5);
		
		//Adding gifts
		baby1.addGift(gift1);
		baby1.addGift(gift2);
		baby2.addGift(gift3);
		
		//Listing babies
		register.listBabiesByName();
		register.listBabiesByAge();
		
		//Listing gifts
		baby1.listGifts();
		baby2.listGifts();
		baby3.listGifts();
		baby4.listGifts();
		baby5.listGifts();
	}
	
	public void addBaby(Baby baby) {
		babies.add(baby);
	}
	
	private void listBabies() {
		for(Baby baby : babies) {
			System.out.println(baby);
		}
		System.out.println("");
	}
	
	public void listBabiesByName() {
		Collections.sort(babies, new Comparator<Baby>() {
			@Override
			public int compare(Baby b1, Baby b2) {
				return b1.getName().compareTo(b2.getName());
			}
		});
		listBabies();
	}
	
	public void listBabiesByAge() {
		Collections.sort(babies, new Comparator<Baby>() {
			@Override
			public int compare(Baby b1, Baby b2) {
				return b1.getBirthday().compareTo(b2.getBirthday());
			}
		});
		listBabies();
	}
}