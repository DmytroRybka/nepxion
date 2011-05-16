package com.nepxion.swing.exception;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

public class ExceptionTracerContext
{
	private static boolean debug = false;
	
	public static void registerDebug(boolean debug)
	{
		ExceptionTracerContext.debug = debug;
	}
	
	public static boolean isDebug()
	{
		return debug;
	}
}