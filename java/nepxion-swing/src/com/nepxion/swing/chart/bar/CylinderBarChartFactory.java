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

import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.urls.StandardCategoryURLGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;
import org.jfree.ui.TextAnchor;

public class CylinderBarChartFactory
	extends RectangleBarChartFactory
{
	public static CategoryPlot createCategoryPlot3D(CategoryDataset categoryDataset, PlotOrientation orientation, String categoryAxisLabel, String valueAxisLabel, String toolTipText, String legendToolTipText, boolean isCategoryLabelRotated)
	{
		CategoryPlot categoryPlot = createCategoryPlot3D(categoryDataset, orientation, categoryAxisLabel, valueAxisLabel, true, true, false);
		
		setCategoryPlotPreference(categoryPlot, orientation, toolTipText, legendToolTipText, isCategoryLabelRotated, 0.75F);
		
		return categoryPlot;
	}
	
	public static CategoryPlot createCategoryPlot3D(CategoryDataset categoryDataset, PlotOrientation orientation, String categoryAxisLabel, String valueAxisLabel, boolean labels, boolean tooltips, boolean urls)
	{
		if (orientation == null)
		{
			throw new IllegalArgumentException("Null 'orientation' argument.");
		}
		CategoryAxis categoryAxis = new CategoryAxis3D(categoryAxisLabel);
		ValueAxis valueAxis = new NumberAxis3D(valueAxisLabel);
		
		CylinderRenderer3D cylinderBarRenderer3D = new CylinderRenderer3D();
		if (orientation == PlotOrientation.HORIZONTAL)
		{
			cylinderBarRenderer3D.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE3, TextAnchor.CENTER));
			cylinderBarRenderer3D.setBaseNegativeItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE9, TextAnchor.CENTER_LEFT));
			cylinderBarRenderer3D.setItemLabelAnchorOffset(20D);
		}
		else if (orientation == PlotOrientation.VERTICAL)
		{
			cylinderBarRenderer3D.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER));
			cylinderBarRenderer3D.setBaseNegativeItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_CENTER));
			cylinderBarRenderer3D.setItemLabelAnchorOffset(5D);
		}
		
		if (labels)
		{
			cylinderBarRenderer3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		}
		if (tooltips)
		{
			cylinderBarRenderer3D.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
		}
		if (urls)
		{
			cylinderBarRenderer3D.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
		}
		cylinderBarRenderer3D.setGradientPaintTransformer(new StandardGradientPaintTransformer(orientation == PlotOrientation.VERTICAL ? GradientPaintTransformType.CENTER_HORIZONTAL : GradientPaintTransformType.CENTER_VERTICAL));
		
		CategoryPlot categoryPlot = new CategoryPlot(categoryDataset, categoryAxis, valueAxis, cylinderBarRenderer3D);
		categoryPlot.setOrientation(orientation);
		
		return categoryPlot;
	}
}