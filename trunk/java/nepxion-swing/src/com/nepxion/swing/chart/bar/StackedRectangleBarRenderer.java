package com.nepxion.swing.chart.bar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Paint;
import java.awt.Stroke;

import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.renderer.category.StackedBarRenderer;

public class StackedRectangleBarRenderer
	extends StackedBarRenderer implements IBarRenderer
{	
	private BarRendererAdapter adapter;
	
	public StackedRectangleBarRenderer()
	{
		super();
		
		adapter = new BarRendererAdapter();
	}
	
	public void dispatchMouseOver(int row, int column)
	{	
		adapter.dispatchMouseOver(row, column);
		
		notifyListeners(new RendererChangeEvent(this));
	}
	
	public void dispatchMouseDown(int row, int column)
	{		
		adapter.dispatchMouseDown(row, column);
		
		notifyListeners(new RendererChangeEvent(this));
	}
	
	public Stroke getItemOutlineStroke(int row, int column)
	{
		Stroke stroke = adapter.getItemOutlineStroke(row, column);		
		if (stroke != null)
		{	
			return stroke;
		}
		
		return super.getItemOutlineStroke(row, column);
	}
	
	public Paint getItemOutlinePaint(int row, int column)
	{
		Paint paint = adapter.getItemOutlinePaint(row, column);		
		if (paint != null)
		{	
			return paint;
		}
		
		return super.getItemOutlinePaint(row, column);
	}
	
	public int getSelectionRow()
	{
		return adapter.getSelectionRow();
	}
	
	public int getSelectionColumn()
	{
		return adapter.getSelectionColumn();
	}
	
	public BarRendererAdapter getAdapter()
	{
		return adapter;
	}
}