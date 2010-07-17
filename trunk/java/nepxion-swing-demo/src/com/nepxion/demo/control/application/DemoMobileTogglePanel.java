package com.nepxion.demo.control.application;

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
import com.nepxion.demo.component.searcher.mobile.locating.DemoLocatingMobilePanel;
import com.nepxion.demo.component.searcher.mobile.netease.DemoNeteaseMobilePanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoMobileTogglePanel
	extends DemoTogglePanel
{
	public DemoMobileTogglePanel()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("�ֻ������ز�ѯ  - �ֻ�֮�ҽӿ�", IconFactory.getSwingIcon("component/application_16.png"), new DemoToggleTemplate(new DemoLocatingMobilePanel()), "�ֻ������ز�ѯ - �ֻ�֮�ҽӿ�");
		toggleTabbedPane.addTab("�ֻ������ز�ѯ  - ���׽ӿ�", IconFactory.getSwingIcon("component/application_16.png"), new DemoToggleTemplate(new DemoNeteaseMobilePanel()), "�ֻ������ز�ѯ  - ���׽ӿ�");
	}
	
	public String getToggleName()
	{
		return "Mobile";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/application_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/application_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Mobile - �ֻ�֮�ҽӿڣ����׽ӿ�Ӧ��";
	}
}