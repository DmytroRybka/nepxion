package com.nepxion.util.io;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

import com.nepxion.util.encoding.EncodingContext;

public class ZipUtil
{	
	/**
	 * Get zip file list
	 * @param filePath     the file path
	 * @param classLoader  the flag whether the inputStream is generated by classLoader
	 * @return             the instance of List
	 */	
	public static List getZipFileList(String filePath, boolean classLoader)
	{
		return getZipFileList(filePath, EncodingContext.getIOCharset(), classLoader);
	}
	
	/**
	 * Get zip file list
	 * @param filePath     the file path
	 * @param charset      the charset text, example "ISO-8859-1", "UTF-8", "GBK", "GB2312"
	 * @param classLoader  the flag whether the inputStream is generated by classLoader
	 * @return             the instance of List
	 */
	public static List getZipFileList(String filePath, String charset, boolean classLoader)
	{
		try
		{
			BufferedReader bufferedReader = getZipReader(filePath, charset, classLoader);
			if (bufferedReader == null)
			{
				return null;
			}
			
			List list = new ArrayList();
			while (true)
			{
				String line = bufferedReader.readLine();
				if (line == null || line.length() == 0)
				{
					break;
				}
				list.add(line);
			}
			return list;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Get zip reader
	 * @param filePath     the file path
	 * @param classLoader  the flag whether the inputStream is generated by classLoader
	 * @return             the instance of BufferedReader
	 */	
	public static BufferedReader getZipReader(String filePath, boolean classLoader)
	{
		return getZipReader(filePath, EncodingContext.getIOCharset(), classLoader);
	}
	
	/**
	 * Get zip reader
	 * @param filePath     the file path
	 * @param charset      the charset text, example "ISO-8859-1", "UTF-8", "GBK", "GB2312"
	 * @param classLoader  the flag whether the inputStream is generated by classLoader
	 * @return             the instance of BufferedReader
	 */
	public static BufferedReader getZipReader(String filePath, String charset, boolean classLoader)
	{
		try
		{
			InputStream inputStream = FileUtil.getInputStream(filePath, classLoader);			
			InputStream zipInputStream = new GZIPInputStream(inputStream);
			return new BufferedReader(new InputStreamReader(zipInputStream, charset));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}