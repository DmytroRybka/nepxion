package com.nepxion.demo;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.net.URL;

import javax.swing.SwingUtilities;

import com.nepxion.swing.context.DataContextManager;
import com.nepxion.swing.context.UIContextManager;
import com.nepxion.swing.framework.dockable.JFrameWorkApplet;

public class DemoApplet
	extends JFrameWorkApplet
{
	public void init()
	{
		super.init();		
		
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				DemoHierarchy hierarchy = new DemoHierarchy();
				setHierarchy(hierarchy);
			}
		}
		);		
	}
	
	public void initContext()
	{		
		URL codeBase = getCodeBase();
		
		DataContextManager.initialize(codeBase);
		UIContextManager.initialize(codeBase);	
		
		// DemoDataContext.initialize(codeBase);
		// DemoUIContext.initialize();	
	}
}