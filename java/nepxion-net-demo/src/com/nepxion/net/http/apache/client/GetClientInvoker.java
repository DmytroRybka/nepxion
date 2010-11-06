package com.nepxion.net.http.apache.client;

/**
 * <p>Title: Nepxion Server</p>
 * <p>Description: Nepxion Server Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import com.nepxion.util.encoder.EncoderContext;
import com.nepxion.util.net.http.HttpConfig;
import com.nepxion.util.net.http.HttpContext;
import com.nepxion.util.net.http.apache.ClientInvoker;
import com.nepxion.util.net.http.apache.ClientParameterList;
import com.nepxion.util.net.http.apache.ClientRequestGet;

public class GetClientInvoker
{
	private static ClientInvoker clientInvoker = new ClientInvoker();
	
	public static void invokeParameter()
	{
		ClientParameterList clientParameterList = new ClientParameterList();
		clientParameterList.put("target", "�������");
		clientParameterList.put("entity", "����");
		
		HttpConfig httpConfig = HttpContext.getHttpConfig("ParameterServerInvoker");
		
		ClientRequestGet clientRequestGet = new ClientRequestGet(httpConfig);
		clientRequestGet.setParameterEntity(clientParameterList);
		
		String responseText = null;
		try
		{
			responseText = clientInvoker.getResponseText(clientRequestGet);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		// System.out.println(responseText);
	}
	
	public static void main(String[] args)
	{
		try
		{
			HttpContext.register();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		EncoderContext.registerHttpCharset("GBK");
		
		GetClientInvoker.invokeParameter();
		
		clientInvoker.shutdown();
	}
}