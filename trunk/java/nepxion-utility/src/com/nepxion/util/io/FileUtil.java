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

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.nepxion.util.encoder.EncoderContext;

public class FileUtil
{	
	/**
	 * Reads the file content of string by a file path.
	 * @param filePath the file path
	 * @param classLoader the boolean value whether the inputStream is generated by the classLoader or not
	 * @return the file content of string
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public static String readString(String filePath, boolean classLoader)
		throws IOException, FileNotFoundException, UnsupportedEncodingException 
	{
		return readString(filePath, EncoderContext.getIOCharset(), classLoader);
	}
	
	/**
	 * Reads the file content of string by a file path and charset.
	 * @param filePath the file path
	 * @param charset the charset value
	 * @param classLoader the boolean value whether the inputStream is generated by the classLoader or not
	 * @return the file content of string
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public static String readString(String filePath, String charset, boolean classLoader)
		throws IOException, FileNotFoundException, UnsupportedEncodingException 
	{
		InputStream inputStream = getInputStream(filePath, classLoader);
		
		return IOUtil.getString(inputStream, charset);
	}
	
	/**
	 * Reads the byte array for an inputStream with the given length.
	 * @param inputStream the instance of InputStream
	 * @param length the length
	 * @return the byte array
	 * @throws IOException
	 */
	public static byte[] readBytes(InputStream inputStream, int length)
		throws IOException
	{		
		InputStream bufferedInputStream = new BufferedInputStream(inputStream);
		
		byte[] bytes = new byte[length];
		int bytesRead = 0;
		int offset = 0;
		while (offset < length)
		{
			bytesRead = bufferedInputStream.read(bytes, offset, bytes.length - offset);
			if (bytesRead == -1)
			{	
				break;
			}
			offset += bytesRead;
		}
		
		bufferedInputStream.close();
		
		if (offset != length)
		{
			throw new IOException("Only " + offset + " bytes read, " + length + " bytes expected");
		}
		
		return bytes;
	}
	
	/**
	 * Reads the remote byte array by an url.
	 * @param httpURL the instance of URL
	 * @return the byte array for the inputStream
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public static byte[] readRemoteBytes(String httpURL)
		throws IOException, MalformedURLException
	{
		URL url = new URL(httpURL);
		URLConnection urlConnection = url.openConnection();
		
		int contentLength = urlConnection.getContentLength();	
		if (contentLength == -1)
		{
			throw new IOException("Invalid bytes size");
		}
		
		InputStream inputStream = urlConnection.getInputStream();
		
		return readBytes(inputStream, contentLength);
	}
	
	/**
	 * Reads the length of the remote byte array by an url.
	 * @param httpURL the instance of URL
	 * @return the byte array for the inputStream
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public static int readRemoteBytesLength(String httpURL)
		throws IOException, MalformedURLException
	{
		URL url = new URL(httpURL);
		URLConnection urlConnection = url.openConnection();
		
		int contentLength = urlConnection.getContentLength();	
		if (contentLength == -1)
		{
			throw new IOException("Invalid bytes size");
		}
		
		return contentLength;
	}
	
	/**
	 * Writes the text to an outputStream by a file path.
	 * @param text the text value
	 * @param filePath the file path
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void writeString(String text, String filePath)
		throws IOException, FileNotFoundException
	{
		byte[] bytes = text.trim().getBytes();
		writeBytes(bytes, filePath);
	}
	
	/**
	 * Writes the byte array to an outputStream by a file path.
	 * @param bytes the byte array
	 * @param filePath the file path
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void writeBytes(byte[] bytes, String filePath)
		throws IOException, FileNotFoundException
	{
		OutputStream outputStream = new FileOutputStream(filePath);
		outputStream.write(bytes);
		outputStream.flush();
		outputStream.close();
	}
		
	/**
	 * Gets the inputStream by a file path.
	 * @param filePath the file path
	 * @param classLoader the boolean value whether the inputStream is generated by the classLoader or not
	 * @return the instance of InputStream
	 * @throws FileNotFoundException
	 */
	public static InputStream getInputStream(String filePath, boolean classLoader)
		throws FileNotFoundException
	{
		InputStream inputStream = null;
		if (classLoader)
		{
			inputStream = FileUtil.class.getClassLoader().getResourceAsStream(filePath);
		}
		else
		{

			inputStream = new FileInputStream(filePath);
		}
		
		return inputStream;
	}
	
	/**
	 * Gets the inputStream by a codebase and file path.
	 * @param codeBase the instance of URL
	 * @param filePath the file path
	 * @return the instance of InputStream
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public static InputStream getInputStream(URL codeBase, String filePath)
		throws IOException, MalformedURLException
	{
		URL url = new URL(codeBase + filePath);			
		InputStream inputStream = url.openStream();
		
		return inputStream;
	}
	
	/**
	 * Gets the inputStream by a codebase and file path.
	 * @param codeBase the instance of URL
	 * @param filePath the file path
	 * @param classLoader the boolean value whether the inputStream is generated by the classLoader or not
	 * @return the instance of InputStream
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws MalformedURLException
	 */
	public static InputStream getInputStream(URL codeBase, String filePath, boolean classLoader)
		throws IOException, FileNotFoundException, MalformedURLException
	{
		InputStream inputStream = null;
		if (codeBase != null)
		{	
			inputStream = getInputStream(codeBase, filePath);
		}
		else
		{
			inputStream = getInputStream(filePath, classLoader);
		}
		
		return inputStream;
	}
	
	/**
	 * Downloads the file by an url.
	 * @param httpURL the instance of URL
	 * @param filePath the file path
	 * @return the instance of File
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static File download(String httpURL, String filePath)
		throws IOException, FileNotFoundException
	{
		File file = new File(filePath);
		
		if (file != null && file.exists())
		{	
			if (readRemoteBytesLength(httpURL) == getFileSize(file))
			{
				return file;
			}	
			else
			{
				file.delete();
			}
		}
		
		byte[] bytes = readRemoteBytes(httpURL);
		writeBytes(bytes, filePath);
		
		return file;
	}	
	
	/**
	 * Gets the user directory of JVM.
	 * @return the user directory
	 */
	public static String getUserDirectory()
	{
		return System.getProperty("user.dir");
	}
	
	/**
	 * Gets the temp directory of JVM.
	 * @return  the temp directory
	 */
	public static String getTempDirectory()
	{
		return System.getProperty("java.io.tmpdir");
	}	
	
	/**
	 * Gets the size of the file context.
	 * @param file the instance of File
	 * @return the size of the file context
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static long getFileSize(File file)
		throws IOException, FileNotFoundException
	{
		InputStream inputStream = new FileInputStream(file);
			
		return inputStream.available();
	}
	
	/**
	 * Gets the project path of Eclipse by a class and project folder name.
	 * @param clazz the instance of Class
	 * @param projectFolderName the project folder name
	 * @return the project path of Eclipse
	 */
	public static String getProjectPath(Class clazz, String projectFolderName)
	{		
		String path = clazz.getClassLoader().getResource("").getPath();
		path = path.substring(1);
		path = path.substring(0, path.indexOf(projectFolderName) + projectFolderName.length());
		
		return path;
	}	
	
	/**
	 * Gets the source path of Eclipse by a class and project folder name.
	 * The resource folder name is "src".
	 * @param clazz the instance of Class
	 * @param projectFolderName the project folder name
	 * @return the source path of Eclipse
	 */
	public static String getResourcePath(Class clazz, String projectFolderName)
	{
		return getResourcePath(clazz, projectFolderName, "src");
	}
	
	/**
	 * Gets the source path of Eclipse by a class, project folder name and resource folder name.
	 * @param clazz the instance of Class
	 * @param projectFolderName the project folder name
	 * @param resourceFolderName the source folder name
	 * @return the source path of Eclipse
	 */
	public static String getResourcePath(Class clazz, String projectFolderName, String resourceFolderName)
	{
		String classPath = clazz.getName();
		classPath = classPath.replace('.', '/') + ".java";
		
		String resourcePath = clazz.getClassLoader().getResource("").getPath();
		resourcePath = resourcePath.substring(1);
		resourcePath = resourcePath.substring(0, resourcePath.indexOf(projectFolderName) + projectFolderName.length());
		resourcePath = resourcePath + "/" + resourceFolderName + "/";
		
		String codePath = resourcePath + classPath;
		
		return codePath;
	}
}