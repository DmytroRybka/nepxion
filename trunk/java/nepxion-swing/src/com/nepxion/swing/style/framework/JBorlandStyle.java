package com.nepxion.swing.style.framework;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Color;

public class JBorlandStyle
	extends JLiteStyle
{
	/**
	 * The identity value.
	 */
	public static final String ID = JBorlandStyle.class.getName();
	
	/**
	 * Constructs with the default.
	 */
	public JBorlandStyle()
	{
		setSelectionGradientColor(new Color(192, 192, 192));
	}
}