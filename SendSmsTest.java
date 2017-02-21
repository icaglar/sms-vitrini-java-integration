

	SmsProvider smsProvider;

	SmsModel smsModel = new SmsModelBuilder().addActionType(SmsActionEnum.SEND_SMS_STANDOLONE_OR_GROUP).addBody(prefix + "send text").addNumbers("String array numbers").build();
  SmsResult smsResult = smsProvider.sendSms(smsModel);
