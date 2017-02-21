
public class SmsVitriniTest {
  
 SmsProvider smsProvider; 
  
 public static void main(String[] args) {
		
   SmsModel smsModel = new SmsModelBuilder()
	   .addActionType(SmsActionEnum.SEND_SMS_STANDOLONE_OR_GROUP)
	   .addBody(prefix +"send text")
	   .addNumbers("numbers comma separated")
	   .build();
		
    SmsResult  smsResult = smsProvider.sendSms(smsModel);
   
   if (smsResult != null)
   {
	if (smsResult.getStatus())
	{
                    // do something if result is ok
        }
   	
    } 
  
}
