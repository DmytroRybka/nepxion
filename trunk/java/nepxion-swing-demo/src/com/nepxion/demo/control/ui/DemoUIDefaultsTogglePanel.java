package com.nepxion.demo.control.ui;

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
import com.nepxion.demo.component.uidefaults.DemoUIDefaultsPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoUIDefaultsTogglePanel
	extends DemoTogglePanel
{
	public DemoUIDefaultsTogglePanel()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("UI Defaults", IconFactory.getSwingIcon("component/ui_16.png"), new DemoToggleTemplate(new DemoUIDefaultsPanel()), "UI Defaults");				
	}
	
	public String getToggleName()
	{
		return "UI Defaults";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/ui_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/ui_32.png");
	}
	
	public String getToggleDescription()
	{
		return "UI Defaults Explorer";
	}
}