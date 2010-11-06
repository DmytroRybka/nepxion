package com.nepxion.net.http.apache.server;

/**
 * <p>Title: Nepxion Server</p>
 * <p>Description: Nepxion Server Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nepxion.util.net.http.apache.ServerInvoker;

public class ParameterServerInvoker
	extends ServerInvoker
{
	public ParameterServerInvoker()
	{
		setRequestEntityType(REQUEST_ENTITY_TYPE_PARAMETER);
		setCharset("GBK");
	}
	
	/*
	 * 1. response.getWriter()��response.getOutputStream()����ֻ����ѡ����һ�����ã�����ͬʱ�����ã������״�;
	 * 2. invoke�������صĶ�����ͨ������ServerInvoker��outputStream��ʽ��д���ͻ��ˣ�������out�����ʽ������Ҫ�ѷ��ض�����Ϊnull��
	 * 3. out�����ʽ���ַ������ڿͻ�����Ҫͨ��clientInvoker.getResponseText��ã�����������룻
	 */
    public Object invoke(Object requestObject, HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		if (requestObject instanceof Map) // Parameter entity
		{
			request.setCharacterEncoding("GBK");
			response.setCharacterEncoding("GBK");
			response.setContentType("text/xml");
			
			Map requestMap = (Map) requestObject;
			
			String target = requestMap.get("target").toString();
			String entity = requestMap.get("entity").toString();
			
			PrintWriter out = response.getWriter();
			out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			out.println("<records>");
			out.println("<record index=\"" + 1 + "\" target=\"" + target + "��Ӧ" + "\" entity=\"" + entity + "��Ӧ" + "\"/>");
			out.println("</records>");
		}
		return null;
	}
}