package com.nepxion.swing.selector.button;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JPanel;

import com.nepxion.swing.button.JBasicMenuButton;
import com.nepxion.swing.panel.option.JOptionButtonPanel;
import com.nepxion.swing.popupmenu.JBasicPopupMenu;

public abstract class JBasicSelectorMenuButton
	extends JBasicMenuButton implements ISelectorMenuButton
{
	private JPanel container;
	private JOptionButtonPanel optionButtonPanel;
	
	public JBasicSelectorMenuButton()
	{
		super();
		
		initComponents();
	}
	
	public JBasicSelectorMenuButton(Action action)
	{
		super(action);
		
		initComponents();
	}
	
	public JBasicSelectorMenuButton(String text)
	{
		super(text);
		
		initComponents();
	}
	
	public JBasicSelectorMenuButton(Icon icon)
	{
		super(icon);
		
		initComponents();
	}
	
	public JBasicSelectorMenuButton(Icon icon, String toolTipText)
	{
		super(icon, toolTipText);
		
		initComponents();
	}
	
	public JBasicSelectorMenuButton(String text, String toolTipText)
	{
		super(text, toolTipText);
		
		initComponents();
	}
	
	public JBasicSelectorMenuButton(String text, Icon icon)
	{
		super(text, icon);
		
		initComponents();
	}
	
	public JBasicSelectorMenuButton(String text, Icon icon, String toolTipText)
	{
		super(text, icon, toolTipText);
		
		initComponents();
	}
	
	private void initComponents()
	{
		final JBasicPopupMenu popupMenu = new JBasicPopupMenu();
		setPopupMenu(popupMenu);
		
		optionButtonPanel = new JOptionButtonPanel(JOptionButtonPanel.YES_NO_OPTION)
		{
			public boolean confirm()
			{
				return JBasicSelectorMenuButton.this.doConfirm();
			}
			
			public boolean cancel()
			{
				return JBasicSelectorMenuButton.this.doCancel();
			}
		};
		
		container = new JPanel();
		container.setLayout(new BorderLayout());
		container.add(optionButtonPanel, BorderLayout.SOUTH);
		
		popupMenu.add(container);
	}
	
	public void setContentPane(Component component)
	{
		container.add(component, BorderLayout.CENTER);
	}
	
	public JOptionButtonPanel getOptionButtonPanel()
	{
		return optionButtonPanel;
	}
	
	public boolean doConfirm()
	{
		if (confirm())
		{
			popupMenu.setVisible(false);
		}
		
		return false;
	}
	
	public boolean doCancel()
	{
		if (cancel())
		{
			popupMenu.setVisible(false);
		}
		
		return false;
	}
}