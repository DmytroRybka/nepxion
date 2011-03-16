package com.nepxion.demo.control.bar;

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

import com.nepxion.demo.common.DemoTogglePanel;
import com.nepxion.demo.common.DemoToggleTemplate;
import com.nepxion.demo.component.buttonbar.DemoButtonBarPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoButtonBarTogglePanel
	extends DemoTogglePanel
{
	public DemoButtonBarTogglePanel()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("ButtonBar", IconFactory.getSwingIcon("component/tool_bar_16.png"), new DemoToggleTemplate(new DemoButtonBarPanel()), "ButtonBar");
	}
	
	public String getToggleName()
	{
		return "ButtonBar";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/tool_bar_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/tool_bar_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style ButtonBar";
	}
}