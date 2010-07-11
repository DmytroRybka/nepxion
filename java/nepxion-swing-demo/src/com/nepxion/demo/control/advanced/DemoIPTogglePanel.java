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
		
		toggleTabbedPane.addTab("����IP��ַ��������λ��", IconFactory.getSwingIcon("component/advanced_16.png"), new DemoToggleTemplate(new DemoIPPanel()), "���ݾ�γ�Ȳ�ѯ����λ��");
		toggleTabbedPane.addTab("���ݵ���λ������IP��ַ", IconFactory.getSwingIcon("component/advanced_16.png"), new DemoToggleTemplate(new DemoIPPanel()), "���ݾ�γ�Ȳ�ѯ����λ��");
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