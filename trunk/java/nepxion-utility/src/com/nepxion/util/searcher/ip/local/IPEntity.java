package com.nepxion.util.searcher.ip.local;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.io.Serializable;

public class IPEntity
	implements Serializable
{
	private static final long serialVersionUID = 5429316904963543813L;

	private String ip;
	private String startIP;
	private String endIP;
	private String country;
	private String region;
	
	public IPEntity()
	{
		ip = "";
		startIP = "";
		endIP = "";
		country = "";
		region = "";
	}
	
	public String getIP()
	{
		return ip;
	}
	
	public void setIP(String ip)
	{
		this.ip = ip;
	}	
	
	public String getStartIP()
	{
		return startIP;
	}
	
	public void setStartIP(String startIP)
	{
		this.startIP = startIP;
	}
	
	public String getEndIP()
	{
		return endIP;
	}
	
	public void setEndIP(String endIP)
	{
		this.endIP = endIP;
	}
	
	public String getCountry()
	{
		return country.trim().equals("CZ88.NET") ?  "" : country.trim();
	}
	
	public void setCountry(String country)
	{
		this.country = country;
	}
	
	public String getRegion()
	{
		return region.trim().equals("CZ88.NET") ?  "" : region.trim();
	}
	
	public void setRegion(String region)
	{
		this.region = region;
	}
	
	public String getLocation()
	{
		return getCountry() + getRegion();
	}
	
	public IPEntity clone()
	{
		IPEntity ipEntity = new IPEntity();
		ipEntity.startIP = startIP;
		ipEntity.endIP = endIP;
		ipEntity.country = country;
		ipEntity.region = region;
		
		return ipEntity;
	}
}