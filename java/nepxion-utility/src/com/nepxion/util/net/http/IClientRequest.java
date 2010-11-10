package com.nepxion.util.net.http;

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

public interface IClientRequest
	extends HttpConstants
{					
	public HttpConfig getHttpConfig();
	
	public void setHttpConfig(HttpConfig httpConfig);
	
	public URI getURI();
	
	public void setURI(URI uri);
	
	public String getURLParameter();
	
	public void abort();
}