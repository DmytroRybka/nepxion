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

import java.net.*;
import java.io.*;

public class ClientInvoker
{
    public static URL codeBase;
    public static String module;

    /**
     * ע��Servlet��·��
     * @param newCodeBase URL   Applet CodeBase
     * @param newModule String  Web Module
     */
    public static void registerServletPath(URL newCodeBase, String newModule)
    {
        codeBase = newCodeBase;
        module = newModule;
    }

    /**
     * �������
     * @param invokerHandle InvokerHandle  InvokerAction�ľ����������뱻���л���
     * @return Object                      ���ض���
     */
    public static Object invoke(InvokerHandle invokerHandle)
        throws Exception
    {
        try
        {
            if (codeBase != null && module != null)
            {
                return ClientInvoker.invokeApplet(codeBase, module, invokerHandle);
            }
            else
            {
                return ClientInvoker.invokeAppliciton(invokerHandle);
            }
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

    /**
     * ʵ��Applet��Servlet�������ݵĹ��ܣ�ͨ��Http���ķ�ʽ
     * @param codeBase URL                 Applet CodeBase
     * @param module String                Web Module
     * @param InvokerHandle invokerHandle  InvokerAction�ľ����������뱻���л���
     * @return Object                      ���ص��ý��(ʵ������쳣��)
     * @throws Exception                   �쳣��Ϣ
     */
    public static Object invokeApplet(URL codeBase, String module, InvokerHandle invokerHandle)
        throws Exception
    {
        String servletAbsolutePath = "http://" + codeBase.getHost() + ":" + codeBase.getPort() + module + "/Servlet.ServerInvoker";
        Object returnObject = null;
        try
        {
            URL url = new URL(servletAbsolutePath);
            URLConnection connection = url.openConnection();
            connection.setDoInput(true); //��������������
            connection.setDoOutput(true); //�������������;
            connection.setUseCaches(true); //����������������
            connection.setDefaultUseCaches(true); //�´�������������
            connection.setRequestProperty("Content-Type", "application/octet-stream");

            ObjectOutputStream oos = new ObjectOutputStream(connection.getOutputStream());
            oos.writeObject(invokerHandle);
            oos.flush();
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(connection.getInputStream());
            returnObject = ois.readObject();
            ois.close();
        }
        catch (ClassNotFoundException ex)
        {
            Exception e = new Exception("�������ӷ��� " + servletAbsolutePath + " �쳣", ex);
            throw e;
        }
        catch (MalformedURLException ex)
        {
            Exception e = new Exception("�������ӷ��� " + servletAbsolutePath + " �쳣", ex);
            throw e;
        }
        catch (IOException ex)
        {
            Exception e = new Exception("�������ӷ��� " + servletAbsolutePath + " �쳣", ex);
            throw e;
        }
        if (returnObject instanceof Exception)
        {
            Exception e = (Exception) returnObject;
            throw e;
        }
        return returnObject;
    }

    /**
     * ʵ��Application��Servlet�������ݵĹ���
     * @param InvokerHandle invokerHandle  InvokerAction�ľ����������뱻���л���
     * @return Object                      ���ص��ý��(ʵ������쳣��)
     */
    public static Object invokeAppliciton(InvokerHandle invokerHandle)
        throws Exception
    {
        ServerInvoker serverInvoker = new ServerInvoker();
        Object returnObject = serverInvoker.invoke(invokerHandle);

        if (returnObject instanceof Exception)
        {
            Exception e = (Exception) returnObject;
            throw e;
        }
        return returnObject;
    }
}