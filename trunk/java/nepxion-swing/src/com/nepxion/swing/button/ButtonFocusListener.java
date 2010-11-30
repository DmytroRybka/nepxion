package com.nepxion.swing.button;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.RootPaneContainer;

public class ButtonFocusListener
	extends FocusAdapter
{
	private RootPaneContainer container;
	private JComponent component;
	
	public ButtonFocusListener(RootPaneContainer container)
	{
		this.container = container;
	}
	
	public ButtonFocusListener(JComponent component)
	{
		this.component = component;
	}
	
	public void focusGained(FocusEvent e)
	{
		JButton button = (JButton) e.getSource();
		
		JRootPane rootPane = null;
		if (container != null)
		{
			rootPane = container.getRootPane();
		}
		else if (component != null)
		{
			rootPane = component.getRootPane();
		}
		
		if (rootPane != null)
		{
			rootPane.setDefaultButton(button);
		}
	}
}