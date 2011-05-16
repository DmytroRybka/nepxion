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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;

import twaver.gis.gadget.StatusBar;

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
		
		final JLabel zoomLabel = new JLabel(TIconFactory.getContextIcon("zoom.png"));
		
		JLabel positionLabel = new JLabel(TIconFactory.getContextIcon("scale.png"));
		JStatusItem positionStatusItem = new JStatusItem(positionLabel);
		
		final JLabel longitudeLabel = new JLabel();
		JStatusItem longitudeStatusItem = new JStatusItem(longitudeLabel);
		
		final JLabel latitudeLabel = new JLabel();
		JStatusItem latitudeStatusItem = new JStatusItem(latitudeLabel);
		
		final JLabel distanceLabel = new JLabel(TIconFactory.getContextIcon("distance.png"));
		
		StatusBar statusBar = new StatusBar(gisGraph.getMap(), gisGraph.getCanvas());
		JLabel tZoomLabel = (JLabel) statusBar.getComponent(0);
		tZoomLabel.addPropertyChangeListener("text", new PropertyChangeListener()
		{
			public void propertyChange(PropertyChangeEvent e)
			{
				String zoom = (String) e.getNewValue();
				setZoom(zoomLabel, zoom);
			}			
		}
		);
		setZoom(zoomLabel, tZoomLabel.getText());
		
		JLabel tLongitudeLabel = (JLabel) statusBar.getComponent(2);
		tLongitudeLabel.addPropertyChangeListener("text", new PropertyChangeListener()
		{
			public void propertyChange(PropertyChangeEvent e)
			{
				String longitude = (String) e.getNewValue();
				setLongitude(longitudeLabel, longitude);
			}			
		}
		);
		setLongitude(longitudeLabel, tLongitudeLabel.getText());
		
		JLabel tLatitudeLabel = (JLabel) statusBar.getComponent(4);
		tLatitudeLabel.addPropertyChangeListener("text", new PropertyChangeListener()
		{
			public void propertyChange(PropertyChangeEvent e)
			{
				String latitude = (String) e.getNewValue();
				setLatitude(latitudeLabel, latitude);
			}			
		}
		);
		setLatitude(latitudeLabel, tLatitudeLabel.getText());
		
		JLabel tDistanceLabel = (JLabel) statusBar.getComponent(6);
		tDistanceLabel.addPropertyChangeListener("text", new PropertyChangeListener()
		{
			public void propertyChange(PropertyChangeEvent e)
			{
				String distance = (String) e.getNewValue();
				setDistance(distanceLabel, distance);
			}			
		}
		);
		setDistance(distanceLabel, tDistanceLabel.getText());
		
		addItem(80, new JStatusItem(zoomLabel), LEFT, JBasicSeparator.LOWERED_STYLE, true);
		addItem(20, positionStatusItem, LEFT, JBasicSeparator.LOWERED_STYLE, false);
		addItem(120, longitudeStatusItem, LEFT, JBasicSeparator.LOWERED_STYLE, false);
		addItem(120, latitudeStatusItem, LEFT, JBasicSeparator.LOWERED_STYLE, true);
		addItem(160, new JStatusItem(distanceLabel), LEFT, JBasicSeparator.LOWERED_STYLE, false);
	}
	
	private void setZoom(JLabel zoomLabel, String zoom)
	{
		zoom = zoom.substring(zoom.indexOf(":") + 1).trim();
		
		zoomLabel.setText("����:" + zoom);
		// zoomLabel.setText("zoom:" + zoom);
	}
	
	private void setLongitude(JLabel longitudeLabel, String longitude)
	{
		longitude = longitude.substring(longitude.indexOf(":") + 1).trim();
		
		longitudeLabel.setText("<html>����:" + longitude);
		// longitudeLabel.setText("<html>Lon:" + longitude);
	}
	
	private void setLatitude(JLabel latitudeLabel, String latitude)
	{
		latitude = latitude.substring(latitude.indexOf(":") + 1).trim();
		
		latitudeLabel.setText("<html>γ��:" + latitude);
		// latitudeLabel.setText("<html>Lat:" + latitude);
	}
	
	private void setDistance(JLabel distanceLabel, String distance)
	{
		distance = distance.substring(distance.indexOf(":") + 1).trim();
		
		distanceLabel.setText("����:" + distance);
		// distanceLabel.setText("Distance:" + distance);
	}
}