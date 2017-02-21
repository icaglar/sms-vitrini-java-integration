package integration.sms;

public class SmsResult {

	private Boolean status;
	private Integer amount;
	private String type;
	private String credits;
	private String refNumber;
	private String priv;
	private String error;
	private Boolean isDeliveryCompleted;
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCredits() {
		return credits;
	}
	public void setCredits(String credits) {
		this.credits = credits;
	}
	public String getRefNumber() {
		return refNumber;
	}
	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}
	public String getPriv() {
		return priv;
	}
	public void setPriv(String priv) {
		this.priv = priv;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Boolean getIsDeliveryCompleted() {
		return isDeliveryCompleted;
	}
	public void setIsDeliveryCompleted(Boolean isDeliveryCompleted) {
		this.isDeliveryCompleted = isDeliveryCompleted;
	}
	
	
