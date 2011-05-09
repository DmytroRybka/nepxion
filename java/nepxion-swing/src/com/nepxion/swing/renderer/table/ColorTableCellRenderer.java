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

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import com.nepxion.swing.border.LineBorder;

public class ColorTableCellRenderer
	extends DefaultTableCellRenderer
{
	public ColorTableCellRenderer()
	{
		setOpaque(true);
		setBorder(new LineBorder(Color.black));
	}
	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
	{
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		Color color = (Color) value;
		setBackground(color);
		
		return this;
	}
}