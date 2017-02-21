package integration.sms;

public class SmsRequest {

	private Authentication authentication;
	private String messageHeader;
	private Boolean tr;
	private MessageData messageData;
	private String refNo;
	
	public SmsRequest(Authentication authentication,String messageHeader,Boolean tr,MessageData messageData,String refNo){
		this.authentication = authentication;
		this.messageHeader = messageHeader;
		this.tr = tr;
		this.messageData =messageData;
		this.refNo = refNo;
		
	}
	
	public Authentication getAuthentication() {
		return authentication;
	}
	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}
	public Boolean getTr() {
		return tr;
	}
	public void setTr(Boolean tr) {
		this.tr = tr;
	}
	public MessageData getMessageData() {
		return messageData;
	}
	public void setMessageData(MessageData messageData) {
		this.messageData = messageData;
	}
	public String getMessageHeader() {
		return messageHeader;
	}
	public void setMessageHeader(String messageHeader) {
		this.messageHeader = messageHeader;
	}
	
	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public static class SmsRequestBuilder {
		Authentication authentication;
		 String messageHeader;
		 Boolean tr;
		 MessageData messageData;
		String refNo;
		public SmsRequestBuilder addAuthentication(Authentication authentication) {
			this.authentication = authentication;
			return this;
		}
		
		public SmsRequestBuilder addMessageHeader(String messageHeader) {
			this.messageHeader =messageHeader;
			return this;
		}
		
		public SmsRequestBuilder addMessageData(MessageData messageData) {
			this.messageData =messageData;
			return this;
		}
		
		
		public SmsRequestBuilder isTurkish(Boolean tr) {
			this.tr =tr;
			return this;
		}
		
		public SmsRequestBuilder addRefNo(String refNo) {
			this.refNo =refNo;
			return this;
		}
		
		public SmsRequest build() {
			return new SmsRequest(authentication,messageHeader, tr,messageData,refNo);
		}


	}
	
	
	
}
