package com.nepxion.util.net.http.apache;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import com.nepxion.util.log.Logger;

public class ServerInvokerLogger
{
	public static void requestLog(String method, String charset, String dataType, Object dataInfo)
	{
		Logger.info(ServerInvokerLogger.class, "--------- Http Server Invoker Start ---------");
		Logger.info(ServerInvokerLogger.class, "Request Method     : " + method);
		Logger.info(ServerInvokerLogger.class, "Request Charset    : " + charset);
		Logger.info(ServerInvokerLogger.class, "Request Data Type  : " + dataType);
		Logger.info(ServerInvokerLogger.class, "Request Data Info  :\n" + dataInfo);
	}
	
	public static void requestLog(String method, String dataType, Object dataInfo)
	{
		Logger.info(ServerInvokerLogger.class, "--------- Http Server Invoker Start ---------");
		Logger.info(ServerInvokerLogger.class, "Request Method     : " + method);
		Logger.info(ServerInvokerLogger.class, "Request Data Type  : " + dataType);
		Logger.info(ServerInvokerLogger.class, "Request Data Info  :\n" + dataInfo);
	}
	
	public static void responseLog(String charset, String dataType, Object dataInfo)
	{
		Logger.info(ServerInvokerLogger.class, "---------------------------------------------");
		Logger.info(ServerInvokerLogger.class, "Response Charset   : " + charset);
		Logger.info(ServerInvokerLogger.class, "Response Data Type : " + dataType);
		Logger.info(ServerInvokerLogger.class, "Response Data Info :\n" + dataInfo);
		Logger.info(ServerInvokerLogger.class, "---------- Http Server Invoker End ----------");
	}
	
	public static void responseLog(String dataType, Object dataInfo)
	{
		Logger.info(ServerInvokerLogger.class, "---------------------------------------------");
		Logger.info(ServerInvokerLogger.class, "Response Data Type : " + dataType);
		Logger.info(ServerInvokerLogger.class, "Response Data Info :\n" + dataInfo);
		Logger.info(ServerInvokerLogger.class, "---------- Http Server Invoker End ----------");
	}
}