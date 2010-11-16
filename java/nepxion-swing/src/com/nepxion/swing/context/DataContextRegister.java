package com.nepxion.swing.context;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.net.URL;
import java.util.Properties;

import com.nepxion.swing.activex.ActiveXConstants;
import com.nepxion.swing.activex.ActiveXContext;
import com.nepxion.util.database.pool.proxool.ProxoolContext;
import com.nepxion.util.encoder.EncoderConstants;
import com.nepxion.util.encoder.EncoderContext;
import com.nepxion.util.locale.LocaleContext;
import com.nepxion.util.log.LoggerContext;
import com.nepxion.util.net.http.HttpContext;
import com.nepxion.util.scheduler.quartz.QuartzContext;
import com.nepxion.util.searcher.ip.local.IPContext;
import com.nepxion.util.searcher.zone.local.ZoneContext;

public class DataContextRegister
	extends AbstractContextRegister implements DataContextConstants
{		
	private Properties properties;
	private URL codeBase;
	
	public void initializeContext(Properties properties)
	{
		initializeContext(properties, null);
	}
	
	public void initializeContext(Properties properties, URL codeBase)
	{
		this.properties = properties;
		this.codeBase = codeBase;
		
		initEncoder();
		initLocale();
		initActiveX();
		initLogger();
		initHttp();
		initProxool();
		initQuartz();
		initIp();
		initZone();
	}
	
	private void initEncoder()
	{		
		String ioCharset = properties.getProperty("ioCharset");
		if (!isValid(ioCharset))
		{
			ioCharset = EncoderConstants.DEFAULT_CHARSET;
		}
		
		String httpCharset = properties.getProperty("httpCharset");
		if (!isValid(httpCharset))
		{
			httpCharset = EncoderConstants.DEFAULT_CHARSET;
		}
		
		EncoderContext.registerIOCharset(ioCharset);
		EncoderContext.registerHttpCharset(httpCharset);
	}
	
	private void initLocale()
	{
		String locale = properties.getProperty("locale");
		if (isValid(locale))
		{
			LocaleContext.registerLocale(locale);
		}
	}
	
	private void initActiveX()
	{
		String activeXEnabled = properties.getProperty("activeX-3rd-enabled");
		
		boolean isActiveXEnabled = false;
		
		if (isValid(activeXEnabled))
		{
			isActiveXEnabled = activeXEnabled.equals("true");
		}
		
		if (isActiveXEnabled)
		{	
			if (codeBase == null)
			{
				ActiveXContext.registerStrategy(ActiveXConstants.STRATEGY_APPLICATION);	
			}	
			else
			{
				ActiveXContext.registerStrategy(ActiveXConstants.STRATEGY_APPLET);
			}
		}
	}
	
	private void initLogger()
	{
		String loggerEnabled = properties.getProperty("logger-3rd-enabled");
		
		boolean isLoggerEnabled = false;
		
		if (isValid(loggerEnabled))
		{
			isLoggerEnabled = loggerEnabled.equals("true");
		}
		
		if (isLoggerEnabled)
		{	
			try
			{
				if (codeBase == null)
				{
					LoggerContext.register();	
				}	
				else
				{
					LoggerContext.register(codeBase);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private void initHttp()
	{
		String httpEnabled = properties.getProperty("http-3rd-enabled");
		
		boolean isHttpEnabled = false;
		
		if (isValid(httpEnabled))
		{
			isHttpEnabled = httpEnabled.equals("true");
		}
		
		if (isHttpEnabled)
		{	
			try
			{
				if (codeBase == null)
				{
					HttpContext.register();
				}	
				else
				{
					HttpContext.register(codeBase);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private void initProxool()
	{
		String proxoolEnabled = properties.getProperty("proxool-3rd-enabled");
		
		boolean isProxoolEnabled = false;
		
		if (isValid(proxoolEnabled))
		{
			isProxoolEnabled = proxoolEnabled.equals("true");
		}
		
		if (isProxoolEnabled)
		{	
			try
			{
				if (codeBase == null)
				{
					ProxoolContext.register();
				}	
				else
				{
					ProxoolContext.register(codeBase);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private void initQuartz()
	{
		String quartzEnabled = properties.getProperty("quartz-3rd-enabled");
		
		boolean isQuartzEnabled = false;
		
		if (isValid(quartzEnabled))
		{
			isQuartzEnabled = quartzEnabled.equals("true");
		}
		
		if (isQuartzEnabled)
		{	
			try
			{
				if (codeBase == null)
				{
					QuartzContext.register();
				}	
				else
				{
					QuartzContext.register(codeBase);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}	
	
	private void initIp()
	{
		String ipEnabled = properties.getProperty("ip-3rd-enabled");
		
		boolean isIpEnabled = false;
		
		if (isValid(ipEnabled))
		{
			isIpEnabled = ipEnabled.equals("true");
		}
		
		if (isIpEnabled)
		{	
			try
			{
				if (codeBase == null)
				{
					IPContext.register();
				}	
				else
				{
					IPContext.register(codeBase);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}	
	
	private void initZone()
	{
		String zoneEnabled = properties.getProperty("zone-3rd-enabled");
		
		boolean isZoneEnabled = false;
		
		if (isValid(zoneEnabled))
		{
			isZoneEnabled = zoneEnabled.equals("true");
		}
		
		if (isZoneEnabled)
		{	
			try
			{
				if (codeBase == null)
				{
					ZoneContext.register();
				}	
				else
				{
					ZoneContext.register(codeBase);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}		
	
	public boolean isValid(String content)
	{
		return content != null && !content.trim().equals("");
	}	
}