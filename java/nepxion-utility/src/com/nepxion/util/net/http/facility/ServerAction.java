package com.nepxion.util.net.http.facility;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

public abstract class ServerAction
{
    private ClientHandle clientHandle;

    public ClientHandle getClientHandle()
    {
        return clientHandle;
    }

    public void setClientHandle(ClientHandle clientHandle)
    {
        this.clientHandle = clientHandle;
    }

    public abstract Object execute();
}