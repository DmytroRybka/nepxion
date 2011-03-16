package com.nepxion.demo.component.searcher.mobile.locating;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.searcher.mobile.locating.JLocatingMobilePanel;

public class DemoLocatingMobilePanel
	extends JPanel
{
	public DemoLocatingMobilePanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new LocatingMobilePanel());
	}
	
	public class LocatingMobilePanel
		extends JPanel
	{
		public LocatingMobilePanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitleBorder("�ֻ������ز�ѯ"));
			
			JLocatingMobilePanel mobilePanel = new JLocatingMobilePanel();			
			add(mobilePanel);
		}
	}
}