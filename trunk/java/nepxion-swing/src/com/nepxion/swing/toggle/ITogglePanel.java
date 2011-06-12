package com.nepxion.swing.toggle;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.Icon;

public interface ITogglePanel
{
	/**
	 * Gets the toggle name.
	 * @return the toggle name string
	 */
	public String getToggleName();
	
	/**
	 * Sets the toggle name.
	 * @param toggleName the toggle name string
	 */
	public void setToggleName(String toggleName);
	
	/**
	 * Gets the toggle icon.
	 * @return the instance of Icon
	 */
	public Icon getToggleIcon();
	
	/**
	 * Sets the toggle icon.
	 * @param toggleIcon
	 */
	public void setToggleIcon(Icon toggleIcon);
	
	/**
	 * Gets the toggle banner icon.
	 * @return the instance of Icon
	 */
	public Icon getToggleBannerIcon();
	
	/**
	 * Sets the toggle banner icon.
	 * @param toggleBannerIcon the instance of Icon
	 */
	public void setToggleBannerIcon(Icon toggleBannerIcon);
	
	/**
	 * Gets the toggle description.
	 * @return the toggle description string
	 */
	public String getToggleDescription();
	
	/**
	 * Sets the toggle description.
	 * @param toggleDescription the toggle description string
	 */
	public void setToggleDescription(String toggleDescription);
	
	/**
	 * Returns true if enabled.
	 * @return true if enabled
	 */
	public boolean isEnabled();
	
	/**
	 * Sets the enabled.
	 * @param enabled the boolean value of enabled
	 */
	public void setEnabled(boolean enabled);
}