package com.nepxion.swing.renderer.table;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Component;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class TableComboBoxCellRenderer
	extends JComboBox implements TableCellRenderer
{
	public TableComboBoxCellRenderer(ComboBoxModel model)
	{
		super(model);
	}
	
	public TableComboBoxCellRenderer(Object items[])
	{
		super(items);
	}
	
	public TableComboBoxCellRenderer(Vector items)
	{
		super(items);
	}
	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
	{
		setSelectedItem(value);
		return this;
	}
}