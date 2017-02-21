package integration.sms;

public class SmsModel {

	public SmsModel() {

	}

	public SmsModel(SmsAuthenticationToken token, String title, String[] numbers, SmsActionEnum actionEnum,String body,String refNo) {
		this.token = token;
		this.title = title;
		this.numbers = numbers;
		this.actionEnum = actionEnum;
		this.body = body;
		this.refNo = refNo;
	}

	private SmsAuthenticationToken token;

	private String message;

	private String[] numbers;

	private String title;
	
	private String body;

	private SmsActionEnum actionEnum;
	
	private String refNo;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String[] getNumbers() {
		return numbers;
	}

	public void setNumbers(String[] numbers) {
		this.numbers = numbers;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public SmsAuthenticationToken getToken() {
		return token;
	}

	public void setToken(SmsAuthenticationToken token) {
		this.token = token;
	}

	public SmsActionEnum getActionEnum() {
		return actionEnum;
	}

	public void setActionEnum(SmsActionEnum actionEnum) {
		this.actionEnum = actionEnum;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public static class SmsModelBuilder {
		SmsAuthenticationToken smsAuthenticationToken;
		String title;
		String body;
		String[] numbers;
		SmsActionEnum actionEnum;
		String refNo;
		public SmsModelBuilder addToken(SmsAuthenticationToken token) {
			this.smsAuthenticationToken = token;
			return this;
		}
		
		public SmsModelBuilder addBody(String body) {
			this.body =body;
			return this;
		}
		public SmsModelBuilder addNumbers(String[] numbers) {
			this.numbers =numbers;
			return this;
		}
		
		public SmsModelBuilder addActionType(SmsActionEnum actionEnum) {
			this.actionEnum =actionEnum;
			return this;
		}
		
		public SmsModelBuilder addRefNo(String refNo) {
			this.refNo =refNo;
			return this;
		}
		
		public SmsModel build() {
			return new SmsModel(smsAuthenticationToken, title, numbers, actionEnum,body,refNo);
		}


	}

}
