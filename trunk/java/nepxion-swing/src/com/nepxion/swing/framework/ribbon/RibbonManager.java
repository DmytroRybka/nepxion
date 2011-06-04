package com.nepxion.swing.framework.ribbon;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import com.nepxion.swing.style.framework.IStyle;
import com.nepxion.swing.style.framework.JRibbonStyle;

public class RibbonManager
{
	private static IStyle style;
	
	public static IStyle createStyle()
	{
		if (style == null)
		{	
			style = new JRibbonStyle();
		}
		
		return style;
	}
}