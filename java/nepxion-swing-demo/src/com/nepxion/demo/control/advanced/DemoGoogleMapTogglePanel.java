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
import com.nepxion.demo.component.gis.google.DemoCoordinatePanel;
import com.nepxion.demo.component.gis.google.DemoCellPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoGoogleMapTogglePanel
	extends DemoTogglePanel
{
	public DemoGoogleMapTogglePanel()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("ģ����ѯ����λ��", IconFactory.getSwingIcon("component/advanced_16.png"), new DemoToggleTemplate(new DemoCoordinatePanel()), "ģ����ѯ����λ��");
		toggleTabbedPane.addTab("���ݾ�γ�Ȳ�ѯ����λ��", IconFactory.getSwingIcon("component/advanced_16.png"), new DemoToggleTemplate(new DemoCoordinatePanel()), "���ݾ�γ�Ȳ�ѯ����λ��");				
		toggleTabbedPane.addTab("�����ƶ���Ϣ��ѯ����λ��", IconFactory.getSwingIcon("component/advanced_16.png"), new DemoToggleTemplate(new DemoCellPanel()), "�����ƶ���Ϣ��ѯ����λ��");
	}
	
	public String getToggleName()
	{
		return "Google Map";
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
		return "Google Map";
	}
}