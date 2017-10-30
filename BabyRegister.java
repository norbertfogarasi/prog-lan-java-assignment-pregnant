public class BabyRegister {
	
	public static void main(String[] args) {
		Baby baby1 = new Baby("02/07/1997 22:00", "Norbert", 'M');
		System.out.println(baby1.toString());
		System.out.println(baby1.getBirthday());
		Baby baby2 = new Baby("02/07/1998 22:00", "Norbert", 'M');
		System.out.println(baby1.isOlder(baby2));
		System.out.println(baby1.howOld());
	}
}