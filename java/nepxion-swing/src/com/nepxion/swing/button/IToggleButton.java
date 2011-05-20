package com.nepxion.swing.button;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

public interface IToggleButton
{
	/**
	 * Return true if the button is grouped.
	 * If true, the toggle button will be added to a ButtonGroup automatically.
	 * @return Return true if the button is grouped
	 */
	public boolean isGrouped();
	
	/**
	 * Sets the boolean value of isGrouped.
	 * @param isGrouped the boolean value of isGrouped
	 */
	public void setGrouped(boolean isGrouped);
}