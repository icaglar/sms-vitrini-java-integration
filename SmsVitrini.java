package integration.sms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class SmsVitrini  implements SmsProvider
{


	private static final Logger LOGGER = Logger.getLogger(SmsHttpAdapter.class);
	protected static final String SMS_PASSWORD = "SMS_PASSWORD";
	protected static final String SMS_USER_NAME = "SMS_USER_NAME";
	protected static final String SMS_TITLE = "SMS_TITLE";
	private static final String SEND_SMS_POST_URL = "http://api.mesajpaneli.com/json_api/";
	private static final String SMS_REFUND_URL = "http://api.mesajpaneli.com/json_api/report";

	@Override
	public SmsResult sendSms(SmsModel smsModel)
	{

		try
		{

			String smsUserName = //Set smsUsername;
			String smsPassword = //set smsPassword ;
			String smsTitle = //set sms title;
			

			List<String> numbers = new ArrayList<>();
			for (String number : smsModel.getNumbers())
			{
				numbers.add(number);
			}

			SmsRequest smsRequest = new SmsRequest.SmsRequestBuilder()
					.addAuthentication(new Authentication(smsUserName, smsPassword))
					.addMessageHeader(smsTitle)
					.addMessageData(new MessageData(smsModel.getBody(), numbers))
					.build();

			SmsResult smsResult = sendSmsWithProvider(smsRequest);


			return smsResult;
			
		} catch (Exception exception)
		{
			throw new CustomException(exception.getMessage());
		}

	}
  
  private SmsResult sendSmsWithProvider(SmsRequest smsRequest)
	{

		SmsResult result = new SmsResult();

		JSONObject main = createJsonObjectFromSmsRequest(smsRequest);

		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build())
		{

			HttpPost p = new HttpPost(SEND_SMS_POST_URL);

			// Decode json
			StringWriter out = new StringWriter();
			main.writeJSONString(out);
			String jsonText = out.toString();

			// Encode json string
			String encodeBase64 = Base64.encodeBase64String(jsonText.getBytes());

			// Add form data to request
			HttpEntity entity = MultipartEntityBuilder.create().addTextBody("data", encodeBase64).build();
			p.setEntity(entity);

			// Execute post request
			HttpResponse r = httpClient.execute(p);

			BufferedReader rd = new BufferedReader(new InputStreamReader(r.getEntity().getContent()));
			String line = "";

			// Parse our JSON response
			while ((line = rd.readLine()) != null)
			{

				JSONParser j = new JSONParser();
				byte[] decodeBase64 = Base64.decodeBase64(line.getBytes());
				JSONObject o;
				try
				{

					o = (JSONObject) j.parse(new String(decodeBase64));
					result.setStatus(Boolean.parseBoolean(o.get("status").toString()));

					if (result.getStatus())
					{

						result.setRefNumber(o.get("ref").toString());
						result.setCredits(o.get("credits").toString());
						result.setStatus(Boolean.parseBoolean(o.get("status").toString()));
						result.setType(o.get("type").toString());
					} else
					{
						result.setError(o.get("error").toString());
					}

				} catch (org.json.simple.parser.ParseException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} catch (ParseException e)
		{
			System.out.println(e);
		} catch (IOException e)
		{
			System.out.println(e);
		}
		return result;
	}

  
  }
