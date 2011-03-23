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

import javax.swing.Icon;

public class RibbonManager
{
	public static JRibbonAction createRibbonAction(String text, Icon icon, String toolTipText, JRibbonContainer ribbonContainer, Class componentClass)
	{
		JRibbonAction action = new JRibbonAction(text, icon, toolTipText);
		action.setRibbonTitle(toolTipText);
		action.setRibbonToolTipText(toolTipText);
		action.setRibbonComponentClass(componentClass);
		action.setRibbonContainer(ribbonContainer);
		
		return action;
	}
}