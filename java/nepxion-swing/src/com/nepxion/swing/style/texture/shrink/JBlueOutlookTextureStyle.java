package com.nepxion.swing.style.texture.shrink;

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

import com.nepxion.swing.style.texture.basic.JBlueTextureStyle;

public class JBlueOutlookTextureStyle
	extends JBasicOutlookTextureStyle
{
	/**
	 * The style path.
	 */
	public static final String STYLE_PATH = "skin/outlook/blue/";
	
	/**
	 * Constructs with the default.
	 */
	public JBlueOutlookTextureStyle()
	{
		super(JBlueTextureStyle.STYLE_PATH, STYLE_PATH);
		
		foreground = new Color(120, 120, 125);
		selectionForeground = new Color(21, 66, 139);
		
		borderColor = new Color(146, 151, 161);
		scrollBorderColor = new Color(233, 223, 207);
	}
}