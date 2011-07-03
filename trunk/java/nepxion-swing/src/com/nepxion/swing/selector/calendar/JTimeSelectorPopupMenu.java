package com.nepxion.swing.selector.calendar;

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
import java.awt.Dimension;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.panel.option.JOptionPanel;
import com.nepxion.swing.selector.dropdown.IDropDownPopupMenu;
import com.nepxion.swing.selector.dropdown.JDropDownDraggablePopupMenu;
import com.nepxion.swing.selector.dropdown.JDropDownPane;

public abstract class JTimeSelectorPopupMenu
	extends JDropDownDraggablePopupMenu implements ITimeSelectorComponent
{
	/**
	 * The instance of JTimeSelector.
	 */
	private JTimeSelector timeSelector;
	
	/**
	 * The layout panel.
	 */
	private JPanel layoutPanel;
	
	/**
	 * Constructs with the specified initial time selector and button.
	 * @param timeSelector the instance of JTimeSelector
	 * @param button the instance of AbstractButton
	 */
	public JTimeSelectorPopupMenu(JTimeSelector timeSelector, AbstractButton button)
	{		
		this.timeSelector = timeSelector;		
		this.timeSelector.setPreferredSize(new Dimension(180, timeSelector.getPreferredSize().height));
		
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(timeSelector, BorderLayout.NORTH);
		
		JOptionPanel optionPanel = new JOptionPanel();
		optionPanel.setIcon(IconFactory.getSwingIcon("component/calendar_48.png"));
		optionPanel.setContent(layoutPanel);
		
		DropDownPane dropDownPane = new DropDownPane(this, optionPanel);
		dropDownPane.getOptionButtonPanel().setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		registerOwner(button);
		registerRenderer(button);
		registerButton(button);
		
		setPopupMenuWidth(timeSelector.getPreferredSize().width + 85);
		setPopupMenuHeight(timeSelector.getPreferredSize().height + 95);
		setResizable(false);
	}
	
	/**
	 * Gets the time selector.
	 * @return the instance of JTimeSelector
	 */
	public JTimeSelector getTimeSelector()
	{
		return timeSelector;
	}
	
	/**
	 * Sets the time selector.
	 * @param timeSelector the instance of JTimeSelector
	 */
	public void setTimeSelector(JTimeSelector timeSelector)
	{
		this.timeSelector = timeSelector;
		this.timeSelector.setPreferredSize(new Dimension(180, this.timeSelector.getPreferredSize().height));
		
		layoutPanel.removeAll();
		layoutPanel.add(timeSelector);
	}
	
	public class DropDownPane
		extends JDropDownPane
	{
		/**
		 * Constructs with the specified initial popup menu and content pane.
		 * @param popupMenu the instance of IDropDownPopupMenu
		 * @param contentPane the instance of Component
		 */
		public DropDownPane(IDropDownPopupMenu popupMenu, Component contentPane)
		{
			super(popupMenu, contentPane);
		}
		
		/**
		 * Returns true if it is confirmed.
		 * @return true if it is confirmed
		 */
		public boolean confirm()
		{
			return JTimeSelectorPopupMenu.this.confirm();
		}
		
		/**
		 * Returns true if it is cancelled.
		 * @return true if it is cancelled
		 */
		public boolean cancel()
		{
			return JTimeSelectorPopupMenu.this.cancel();
		}
	}
	
	/**
	 * Returns true if it is confirmed.
	 * @return true if it is confirmed
	 */
	public abstract boolean confirm();
	
	/**
	 * Returns true if it is cancelled.
	 * @return true if it is cancelled
	 */
	public abstract boolean cancel();
}