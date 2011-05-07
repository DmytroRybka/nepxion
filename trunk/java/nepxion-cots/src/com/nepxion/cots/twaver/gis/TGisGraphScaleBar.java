package com.nepxion.cots.twaver.gis;

/**
 * <p>Title: Nepxion Cots For TWaver</p>
 * <p>Description: Nepxion Cots Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * <p>Announcement: It depends on the commercial software of TWaver, the repository only references the trial version.</p>
 * <p>If you want to use Nepxion Cots, please contact with Serva Corporation to buy the genuine version.</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.text.NumberFormat;

import javax.swing.JLabel;

import twaver.ZoomListener;

import com.nepxion.cots.twaver.icon.TIconFactory;
import com.nepxion.swing.separator.JBasicSeparator;
import com.nepxion.swing.statusbar.JStatusBar;
import com.nepxion.swing.statusbar.JStatusItem;

public class TGisGraphScaleBar
	extends JStatusBar
{
	public TGisGraphScaleBar(final TGisGraph gisGraph)
	{
		setSeparatorHeight(13);
		
		final JLabel scaleLabel = new JLabel(TIconFactory.getContextIcon("scale.png"));
		scaleLabel.setText("0,0");
		
		final JLabel zoomLabel = new JLabel(TIconFactory.getContextIcon("zoom.png"));
		addItem(100, new JStatusItem(scaleLabel), LEFT, JBasicSeparator.LOWERED_STYLE);
		addItem(50, new JStatusItem(zoomLabel), RIGHT, JBasicSeparator.LOWERED_STYLE);
		
		gisGraph.getCanvas().addMouseListener(new MouseAdapter()
		{
			public void mouseExited(MouseEvent e)
			{
				update(scaleLabel, zoomLabel, gisGraph, null);
			}
		}
		);
		
		gisGraph.getCanvas().addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseDragged(MouseEvent e)
			{
				update(scaleLabel, zoomLabel, gisGraph, e.getPoint());
			}
			
			public void mouseMoved(MouseEvent e)
			{
				update(scaleLabel, zoomLabel, gisGraph, e.getPoint());
			}
		}
		);
		
		gisGraph.getCanvas().addMouseWheelListener(new MouseWheelListener()
		{
			public void mouseWheelMoved(MouseWheelEvent e)
			{
				update(scaleLabel, zoomLabel, gisGraph, e.getPoint());
			}
		}
		);
		
		gisGraph.getZoomer().addZoomListener(new ZoomListener()
		{
			public void zoomChanged(double oldZoom, double newZoom)
			{
				update(scaleLabel, zoomLabel, gisGraph, null);
			}
		}
		);
		
		update(scaleLabel, zoomLabel, gisGraph, null);
	}
	
	private void update(JLabel scaleLabel, JLabel zoomLabel, TGisGraph gisGraph, Point point)
	{
		double zoom = gisGraph.getZoom();
		if (point != null)
		{
			int x = (int) (point.getX() / zoom);
			int y = (int) (point.getY() / zoom);
			
			scaleLabel.setText(x + "," + y);
		}
		
		NumberFormat format = NumberFormat.getInstance();
		format.setMaximumFractionDigits(2);
		zoomLabel.setText(format.format(zoom));
	}
}