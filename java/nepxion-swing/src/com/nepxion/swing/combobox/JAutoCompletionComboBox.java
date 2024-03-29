package com.nepxion.swing.combobox;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicComboPopup;

import com.jidesoft.swing.AutoCompletionComboBox;
import com.nepxion.swing.dimension.DimensionManager;

public class JAutoCompletionComboBox
	extends AutoCompletionComboBox
{
	/**
	 * The popup menu width value.
	 */
	private int popupMenuWidth = 0;
	
	/**
	 * The boolean value of isPopupMenuShownUp.
	 */
	private boolean isPopupMenuShownUp = false;
	
	/**
	 * Constructs with the specified initial combo box model.
	 * @param aModel the instance of ComboBoxModel
	 */
	public JAutoCompletionComboBox(ComboBoxModel aModel)
	{
		super(aModel);
	}
	
	/**
	 * Constructs with the specified initial items.
	 * @param items the object array
	 */
	public JAutoCompletionComboBox(final Object items[])
	{
		super(items);
	}
	
	/**
	 * Constructs with the specified initial items.
	 * @param items the instance of Vector
	 */
	public JAutoCompletionComboBox(Vector items)
	{
		super(items);
	}
	
	/**
	 * Constructs with the default.
	 */
	public JAutoCompletionComboBox()
	{
		super();
	}
	
	/**
	 * Initializes the components.
	 */
	protected void initComponents()
	{
		super.initComponents();
		
		ComboBoxManager.setPreferenceStyle(this);
	}
	
	/**
	 * Sets editable.
	 * @param editable the boolean value of editable
	 */
	public void setEditable(boolean editable)
	{
		super.setEditable(editable);
		
		setFocusable(true);
	}
	
	/**
	 * Gets the popup menu width.
	 * @return the popup menu width value
	 */
	public int getPopupMenuWidth()
	{
		return popupMenuWidth;
	}
	
	/**
	 * Sets the popup menu width.
	 * @param popupMenuWidth the popup menu width value
	 */
	public void setPopupMenuWidth(int popupMenuWidth)
	{
		this.popupMenuWidth = popupMenuWidth;
	}
	
	/**
	 * Returns true if the popup menu is shown up.
	 * @return true if the popup menu is shown up
	 */
	public boolean isPopupMenuShownUp()
	{
		return isPopupMenuShownUp;
	}
	
	/**
	 * Sets the popup menu shown up.
	 * @param isPopupMenuShownUp the boolean value of isPopupMenuShownUp
	 */
	public void setPopupMenuShownUp(boolean isPopupMenuShownUp)
	{
		this.isPopupMenuShownUp = isPopupMenuShownUp;
	}
	
	/**
	 * Invoked before the popup menu becomes visible.
	 */
	public void firePopupMenuWillBecomeVisible()
	{
		if (popupMenuWidth > 0 || isPopupMenuShownUp)
		{
			BasicComboPopup comboPopup = (BasicComboPopup) getUI().getAccessibleChild(this, 0);
			JScrollPane scrollPane = (JScrollPane) comboPopup.getComponent(0);
			if (popupMenuWidth > 0)
			{
				Dimension popupSize = new Dimension(popupMenuWidth, comboPopup.getPreferredSize().height);
				DimensionManager.setDimension(scrollPane, popupSize);
			}
			
			if (isPopupMenuShownUp)
			{
				int height = comboPopup.getHeight();
				if (height == 0)
				{
					height = comboPopup.getPreferredSize().height;
				}
				comboPopup.setLocation(getLocationOnScreen().x, getLocationOnScreen().y - height);
			}
		}
		
		super.firePopupMenuWillBecomeVisible();
	}
}