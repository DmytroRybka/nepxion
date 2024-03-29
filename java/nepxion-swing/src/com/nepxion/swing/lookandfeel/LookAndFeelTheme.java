package com.nepxion.swing.lookandfeel;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import com.jidesoft.plaf.LookAndFeelFactory;

public class LookAndFeelTheme
	extends LookAndFeelFactory
{
	/**
	 * Sets the theme.
	 * @param theme the theme value
	 */
	public static void setTheme(int theme)
	{
		installJideExtension(theme);
	}
}