package integration.sms;
import java.util.List;

public class MessageData {

	private String message;
	private List<String> phoneList;
	
	public MessageData(String message,List<String> phoneList){
		this.message = message;
		this.phoneList = phoneList;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getPhoneList() {
		return phoneList;
	}
	public void setPhoneList(List<String> phoneList) {
		this.phoneList = phoneList;
	}
}
