package integration.sms;
public interface SmsProvider {
	
	SmsResult sendSms(SmsModel smsModel);
	
	void queryQuota(SmsModel smsModel);
	
	SmsResult refundSms(SmsModel smModel);
	
	

}
