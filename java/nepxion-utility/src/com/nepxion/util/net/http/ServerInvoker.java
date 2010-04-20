package com.nepxion.util.net.http;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune �κƾ�
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServerInvoker
    extends HttpServlet
{
    /**
     * ʵ�ַ������ͻ��˵������ݵĹ��ܣ�ͨ��Http���ķ�ʽ
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        InvokerHandle invokerHandle = null;
        try
        {
            ObjectInputStream ois = new ObjectInputStream(request.getInputStream());
            invokerHandle = (InvokerHandle) ois.readObject();
            ois.close();

            Object returnObject = invoke(invokerHandle);
            ObjectOutputStream oos = new ObjectOutputStream(response.getOutputStream());
            oos.writeObject(returnObject);
            oos.flush();
            oos.close();
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }

    public Object invoke(InvokerHandle invokerHandle)
    {
        Class actionClass = invokerHandle.getActionClass();
        InvokerAction invokerAction = null;
        try
        {
            invokerAction = (InvokerAction) actionClass.newInstance();
        }
        catch (IllegalAccessException ex)
        {
            ex.printStackTrace();
        }
        catch (InstantiationException ex)
        {
            ex.printStackTrace();
        }
        invokerAction.setInvokerHandle(invokerHandle);
        return invokerAction.execute();
    }
}