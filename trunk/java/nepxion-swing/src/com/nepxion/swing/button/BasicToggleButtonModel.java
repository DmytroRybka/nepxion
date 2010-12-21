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

import javax.swing.JToggleButton;

public class BasicToggleButtonModel
	extends JToggleButton.ToggleButtonModel	implements IButtonModel
{
	private boolean isMenuDropDown;
	private boolean isActionButtonPressed;
	
	public BasicToggleButtonModel()
	{
		super();
	}
	
	public boolean isMenuDropDown()
	{
		return isMenuDropDown;
	}
	
	public void setMenuDropDown(boolean isMenuDropDown)
	{
		this.isMenuDropDown = isMenuDropDown;
	}
	
	public boolean isActionButtonPressed()
	{
		return isActionButtonPressed;
	}
	
	public void setActionButtonPressed(boolean isActionButtonPressed)
	{
		this.isActionButtonPressed = isActionButtonPressed;
	}
}