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

public abstract class AbstractLiteButtonStyle
	implements ILiteButtonStyle
{
	/**
	 * The rollover background.
	 */
	protected Color rolloverBackground;
	
	/**
	 * The rollover border color.
	 */	
	protected Color rolloverBorderColor;
	
	/**
	 * The selection background.
	 */	
	protected Color selectionBackground;
	
	/**
	 * The selection border color.
	 */	
	protected Color selectionBorderColor;
	
	/**
	 * The check color.
	 */	
	protected Color checkColor;
	
	/**
	 * The focus color.
	 */	
	protected Color focusColor;
	
	/**
	 * Gets the rollover background.
	 * @return the instance of Color
	 */
	public Color getRolloverBackground()
	{
		return rolloverBackground;
	}
	
	/**
	 * Gets the rollover border color.
	 * @return the instance of Color
	 */
	public Color getRolloverBorderColor()
	{
		return rolloverBorderColor;
	}
	
	/**
	 * Gets the selection background.
	 * @return the instance of Color
	 */
	public Color getSelectionBackground()
	{
		return selectionBackground;
	}
	
	/**
	 * Gets the selection border color.
	 * @return the instance of Color
	 */
	public Color getSelectionBorderColor()
	{
		return selectionBorderColor;
	}
	
	/**
	 * Gets the check color.
	 * @return the instance of Color
	 */
	public Color getCheckColor()
	{
		return checkColor;
	}
	
	/**
	 * Gets the focus color.
	 * @return the instance of Color
	 */
	public Color getFocusColor()
	{
		return focusColor;
	}
}