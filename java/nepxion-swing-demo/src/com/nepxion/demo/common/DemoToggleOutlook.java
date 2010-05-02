package com.nepxion.demo.common;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.AbstractButton;
import javax.swing.SwingConstants;

import com.nepxion.swing.outlookbar.JFlatOutlook;

public abstract class DemoToggleOutlook
	extends JFlatOutlook implements SwingConstants
{
	public DemoToggleOutlook()
	{
	}
	
	public void addButton(AbstractButton button)
	{
		super.addButton(button);
		DemoButtonGroup.getInstance().add(button);
	}
}
