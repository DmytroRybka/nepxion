package com.nepxion.demo.control.advanced;

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
import com.nepxion.demo.component.ip.DemoIPPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoIPTogglePanel
	extends DemoTogglePanel
{
	public DemoIPTogglePanel()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		
		toggleTabbedPane.addTab("根据IP地址搜索地理位置", IconFactory.getSwingIcon("component/advanced_16.png"), new DemoToggleTemplate(new DemoIPPanel()), "根据经纬度查询地理位置");
		toggleTabbedPane.addTab("根据地理位置搜索IP地址", IconFactory.getSwingIcon("component/advanced_16.png"), new DemoToggleTemplate(new DemoIPPanel()), "根据经纬度查询地理位置");
	}
	
	public String getToggleName()
	{
		return "IP";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/advanced_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/advanced_32.png");
	}
	
	public String getToggleDescription()
	{
		return "IP";
	}
}