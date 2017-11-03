import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class BabyRegister {
	
	ArrayList<Baby> babies = new ArrayList<>();
	
	public static void main(String[] args) {
		BabyRegister register = new BabyRegister();
		
		//Babies
		Baby baby1 = new Baby("02/07/1997 22:00", "Norbert", 'M');
		Date date1 = new Date(System.currentTimeMillis() - 555_000_000);
		Baby baby2 = new Baby(date1, "Robert", 'M');	
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
		register.addBaby(baby4);
		register.addBaby(baby5);
		
		//Adding gifts
		baby1.addGift(gift1);
		baby1.addGift(gift2);
		baby2.addGift(gift3);
		
		while(true) {
			showMainMenu();
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			int option = sc.nextInt();
			switch(option) {
				case 1:
					//Adding a new Baby
					System.out.print("\nBirthday (dd/mm/yyyy hh:mm): ");
					sc.nextLine();	//Consumes the \n
					String date = sc.nextLine();
					Date birthday = null;
					try {
						birthday = dateFormat.parse(date);
						System.out.print("Name: ");
						String name = sc.nextLine();
						System.out.print("Gender(F/M): ");
						char gender = Character.toUpperCase(sc.next().charAt(0));
						if(gender != 'F' && gender != 'M') {
							System.out.println("Wrong gender!");
						}
						else {
							register.addBaby(new Baby(birthday, name, gender));
						}
					} catch (ParseException e) {
						System.err.println("\nThe date format is wrong!");
					}	
					break;
				case 2:
					//List babies by age
					register.listBabiesByAge();
					break;
				case 3:
					//List babies by name
					register.listBabiesByName();
					break;
				case 4:
					//Add a Gift to a Baby
					System.out.print("Name of the baby who gets the gift: ");
					sc.nextLine();
					String babyName = sc.nextLine();
					Baby giftedBaby = register.getBabyByName(babyName);
					if(giftedBaby != null) {
						System.out.print("Name of the donator: ");
						String whoGave = sc.nextLine();
						System.out.print("Description of the gift: ");
						String desc = sc.nextLine();
						System.out.print("Date when you give it (dd/mm/yyyy hh:mm): ");
						String giveDate = sc.nextLine();
						Date dateWhenGiven = new Date();
						try {
							dateWhenGiven = dateFormat.parse(giveDate);
						} catch (ParseException e) {
							System.out.println("\nThe date format is wrong!");
						}
						giftedBaby.addGift(new Gift(whoGave, desc, dateWhenGiven));
					}
					else {
						System.err.println("No Baby found with this name!");
					}
					break;
				case 5:
					//List gifts
					register.listGifts();
					break;
				case 6:
					System.exit(0);
			}
		}
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
	
	public void listGifts() {
		for(Baby b : babies) {
			b.listGifts();
		}
	}
	
	public static void showMainMenu() {
		//Shows the main menu
		System.out.println("\nMain menu:\n");
		System.out.println("1.) Add new Baby");
		System.out.println("2.) List Babies by age");
		System.out.println("3.) List Babies by name");
		System.out.println("4.) Add gift");
		System.out.println("5.) List gifts");
		System.out.println("6.) Exit");
		System.out.println("-------------------------");
		System.out.print("Your option: ");
	}
	
	private Baby getBabyByName(String name) {
		for(Baby b : babies) {
			if(b.getName().equals(name)) {
				return b;
			}
		}
		return null;
	}
}