package com.nepxion.swing.style.button.lite;

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

public class JGlassLiteButtonStyle
	extends AbstractLiteButtonStyle
{
	public static final String ID = JGlassLiteButtonStyle.class.getName();
	
	public JGlassLiteButtonStyle()
	{
		rolloverBackground = new Color(178, 216, 255, 120);
		rolloverBorderColor = new Color(42, 128, 217, 225);
		
		selectionBackground = new Color(178, 216, 255);
		selectionBorderColor = new Color(42, 128, 217);
		
		checkColor = new Color(75, 151, 204);
		focusColor = new Color(122, 192, 255);
	}
}