package com.nepxion.swing.chart.pie;

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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.PieDataset;

public class PieChartPlot3D
	extends PiePlot3D implements IPieChartPlot
{
	private PieChartPlotAdapter adapter;
	
	private Map sectionOutlineStrokeMap = new HashMap();
	private Map sectionOutlinePaintMap = new HashMap();
	
	public PieChartPlot3D()
	{
		super();
		
		adapter = new PieChartPlotAdapter();
		
		updateSelectionData();
	}
	
	public PieChartPlot3D(PieDataset dataset)
	{
		super(dataset);
		
		adapter = new PieChartPlotAdapter();
		
		updateSelectionData();
	}
	
	public void updateSelectionData()
	{
		sectionOutlineStrokeMap.clear();
		sectionOutlinePaintMap.clear();
		
		for (Iterator iterator = getDataset().getKeys().iterator(); iterator.hasNext();)
		{
			Comparable key = (Comparable) iterator.next();
			
			Stroke stroke = super.getSectionOutlineStroke(key);
			
			if (stroke == null)
			{
				stroke = DEFAULT_OUTLINE_STROKE;
			}
			sectionOutlineStrokeMap.put(key, stroke);
			
			Paint paint = super.getSectionOutlinePaint(key);
			
			if (paint == null)
			{
				paint = DEFAULT_OUTLINE_PAINT;
			}
			sectionOutlinePaintMap.put(key, paint);
		}
	}
	
	public void updateSelectionUI()
	{
		for (Iterator iterator = getDataset().getKeys().iterator(); iterator.hasNext();)
		{
			Comparable key = (Comparable) iterator.next();
			
			Stroke stroke = adapter.getSectionOutlineStroke(key);
			if (stroke == null)
			{
				stroke = (Stroke) sectionOutlineStrokeMap.get(key);
			}
			
			super.setSectionOutlineStroke(key, stroke);
			
			Paint paint = adapter.getSectionOutlinePaint(key);
			if (paint == null)
			{
				paint = (Paint) sectionOutlinePaintMap.get(key);
			}
			
			super.setSectionOutlinePaint(key, paint);
		}
	}
	
	public void dispatchMouseOver(Comparable key)
	{
		adapter.dispatchMouseOver(key);
		
		updateSelectionUI();
	}
	
	public void dispatchMouseDown(Comparable key)
	{
		adapter.dispatchMouseDown(key);
		
		updateSelectionUI();
	}
	
	public void setSectionOutlineStroke(Comparable key, Stroke stroke)
	{
		super.setSectionOutlineStroke(key, stroke);
		
		sectionOutlineStrokeMap.put(key, stroke);
	}
	
	public void setSectionOutlinePaint(Comparable key, Paint paint)
	{
		super.setSectionOutlinePaint(key, paint);
		
		sectionOutlinePaintMap.put(key, paint);
	}
	
	public Comparable getSelectionKey()
	{
		return adapter.getSelectionKey();
	}
	
	public PieChartPlotAdapter getAdapter()
	{
		return adapter;
	}
}