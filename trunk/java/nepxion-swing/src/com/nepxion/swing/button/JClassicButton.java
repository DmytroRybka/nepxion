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

import java.awt.Insets;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.UIManager;

import com.nepxion.swing.lookandfeel.LookAndFeelManager;

public class JClassicButton
	extends JButton
{
	public JClassicButton()
	{
		super();
		
		initComponents();
	}
	
	public JClassicButton(Action action)
	{
		super(action);
		
		initComponents();
	}
	
	public JClassicButton(String text)
	{
		super(text);
		
		initComponents();
	}
	
	public JClassicButton(Icon icon)
	{
		super(icon);
		
		initComponents();
	}
	
	public JClassicButton(Icon icon, String toolTipText)
	{
		super(icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JClassicButton(String text, String toolTipText)
	{
		super(text);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JClassicButton(String text, Icon icon)
	{
		super(text, icon);
		
		initComponents();
	}
	
	public JClassicButton(String text, Icon icon, String toolTipText)
	{
		super(text, icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	private void initComponents()
	{
		setFocusPainted(false);
		
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			setMargin(new Insets(0, 0, 0, 0));
			
		}
		else
		{
			setMargin(new Insets(3, 9, 3, 9));
		}
	}
}