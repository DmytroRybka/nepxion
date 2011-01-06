package com.nepxion.util.searcher.gis.google.loc;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.net.URI;

import org.json.JSONException;
import org.json.JSONObject;

import com.nepxion.util.locale.LocaleConstants;
import com.nepxion.util.net.http.apache.ClientInvoker;
import com.nepxion.util.net.http.apache.ClientRequestPost;

public class LocSearcher
	implements LocConstants, LocaleConstants
{	
	private String language = ZH_CN;
	private String charset = "UTF-8";
	private boolean requestAddress = true;
	
	private ClientInvoker clientInvoker;
	
	public LocSearcher()
	{
		this(true);
	}
	
	public LocSearcher(boolean requestAddress)
	{
		this(ZH_CN, requestAddress);
	}
	
	public LocSearcher(String language)
	{
		this(language, true);
	}
	
	public LocSearcher(String language, boolean requestAddress)
	{
		this(language, "UTF-8", requestAddress);
	}
	
	public LocSearcher(String language, String charset)
	{
		this(language, charset, true);
	}
	
	public LocSearcher(String language, String charset, boolean requestAddress)
	{
		this.language = language;
		this.charset = charset;
		this.requestAddress = requestAddress;
		
		this.clientInvoker = new ClientInvoker();
	}
	
	public LocEntity search(double latitude, double longitude)
		throws Exception
	{
		String requestJSON = createCoordinateJSON(latitude, longitude);
		String responseJSON = getJSON(requestJSON);
		return createEntity(responseJSON);
	}
	
	public LocEntity search(int cellID, int lac, int mcc, int mnc)
		throws Exception
	{
		String requestJSON = createCellJSON(cellID, lac, mcc, mnc);
		String responseJSON = getJSON(requestJSON);
		return createEntity(responseJSON);
	}
	
	/**
	 * @param latitude   γ��
	 * @param longitude  ����
	 */
	public String createCoordinateJSON(double latitude, double longitude)
	{
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("{\n");
		stringBuffer.append("  \"version\": \"1.1.0\",\n");
		stringBuffer.append("  \"host\": \"maps.google.com\",\n");
		
		stringBuffer.append("  \"request_address\": " + requestAddress + ",\n");
		stringBuffer.append("  \"address_language\": \"" + language + "\",\n");
		
		stringBuffer.append("  \"location\": \n");
		stringBuffer.append("  {\n");
		stringBuffer.append("    \"latitude\": " + latitude + ",\n");
		stringBuffer.append("    \"longitude\": " + longitude + "\n");
		stringBuffer.append("  }\n");
		stringBuffer.append("}");
		return stringBuffer.toString();
	}
	
	/**
	 * @param cellID  ȫ��Ψһ��С��ID
	 * @param lac     ȫ��Ψһ��λ����
	 * @param mcc     �ƶ����Һ��룬�й�Ϊ460
	 * @param mnc     �ƶ����ţ��й��ƶ�Ϊ00���й��й���ͨΪ01
	 */
	public String createCellJSON(int cellID, int lac, int mcc, int mnc)
	{
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("{\n");
		stringBuffer.append("  \"version\": \"1.1.0\",\n");
		stringBuffer.append("  \"host\": \"maps.google.com\",\n");
		
		stringBuffer.append("  \"request_address\": " + requestAddress + ",\n");
		stringBuffer.append("  \"address_language\": \"" + language + "\",\n");
		
		stringBuffer.append("  \"cell_towers\": \n");
		stringBuffer.append("  [\n");
		stringBuffer.append("    {\n");
		stringBuffer.append("      \"cell_id\": " + cellID + ",\n");
		stringBuffer.append("      \"location_area_code\": " + lac + ",\n");
		stringBuffer.append("      \"mobile_country_code\": " + mcc + ",\n");
		stringBuffer.append("      \"mobile_network_code\": " + mnc + "\n");
		stringBuffer.append("    }\n");
		stringBuffer.append("  ]\n");
		stringBuffer.append("}");
		return stringBuffer.toString();
	}
	
	private LocEntity createEntity(String requestJSON)
	{
		if (requestJSON == null || requestJSON.equals("") || requestJSON.equals("{}"))
		{
			return null;
		}
		
		LocEntity locEntity = new LocEntity();
		try
		{
			JSONObject jsonObject = new JSONObject(requestJSON);
			
			String accessToken = jsonObject.getString("access_token");
			locEntity.setAccessToken(accessToken);
			
			JSONObject locationJSONObject = (JSONObject) jsonObject.get("location");
			
			double latitude = locationJSONObject.getDouble("latitude");
			locEntity.setLatitude(latitude);
			
			double longitude = locationJSONObject.getDouble("longitude");
			locEntity.setLongitude(longitude);
			
			Object addressObject = locationJSONObject.get("address");
			if (addressObject != null)
			{
				JSONObject addressJSONObject = (JSONObject) addressObject;
				
				String country = addressJSONObject.getString("country");
				locEntity.setCountry(country);
				
				String countryCode = addressJSONObject.getString("country_code");
				locEntity.setCountryCode(countryCode);
				
				String region = addressJSONObject.getString("region");
				locEntity.setRegion(region);
				
				String city = addressJSONObject.getString("city");
				locEntity.setCity(city);
				
				String street = addressJSONObject.getString("street");
				locEntity.setStreet(street);
				
				String streetNumber = addressJSONObject.getString("street_number");
				locEntity.setStreetNumber(streetNumber);
				
				String postalCode = addressJSONObject.getString("postal_code");
				locEntity.setPostalCode(postalCode);
				
				double accuracy = addressJSONObject.getDouble("accuracy");
				locEntity.setAccuracy(accuracy);
			}
		}
		catch (JSONException e)
		{
			
		}
		return locEntity;
	}
	
	public String getJSON(String requestJSON)
		throws Exception
	{
		ClientRequestPost clientRequestPost = new ClientRequestPost();
		clientRequestPost.setURI(URI.create(URL));
		clientRequestPost.setStringEntity(requestJSON);
		
		String responseText = clientInvoker.getResponseText(clientRequestPost, charset);
		return responseText;
	}
}