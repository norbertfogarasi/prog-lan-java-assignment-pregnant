import java.util.Date;
import java.text.SimpleDateFormat;

public class Gift {
	
	private String whoGave;
	private String description;
	private Date whenWasGiven;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	public Gift() {
		whoGave = "Unknown";
		description = "N/A";
		whenWasGiven = new Date();
	}
	
	public Gift(String whoGave, String description, Date whenWasGiven) {
		this.whoGave = whoGave;
		this.description = description;
		this.whenWasGiven = whenWasGiven;
	}
	
	public void setWhoGave(String whoGave) {
		this.whoGave = whoGave;
	}
	
	public String getWhoGave() {
		return whoGave;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setWhenWasGiven(Date whenWasGiven) {
		this.whenWasGiven = whenWasGiven;
	}
	
	public Date getWhenWasGiven() {
		return whenWasGiven;
	}
	
	@Override
	public String toString() {
		return whoGave + " " + description + " " + dateFormat.format(whenWasGiven); 
	}
}