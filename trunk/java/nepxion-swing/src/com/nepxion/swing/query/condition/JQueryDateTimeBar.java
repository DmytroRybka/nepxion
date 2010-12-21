package com.nepxion.swing.query.condition;

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
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.dimension.DimensionManager;
import com.nepxion.swing.layout.table.TableLayout;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.IValidation;
import com.nepxion.swing.selector.calendar.JDateTimeSelector;
import com.nepxion.util.time.TimeUtil;

public class JQueryDateTimeBar
	extends JPanel implements SwingConstants, IValidation
{
	private JDateTimeSelector startDateTimeSelector;
	private JDateTimeSelector endDateTimeSelector;
	
	public JQueryDateTimeBar()
	{
		this(VERTICAL);
	}
	
	public JQueryDateTimeBar(int direction)
	{
        Date endDateTime = new Date();
        Date startDateTime = TimeUtil.calculateDate(endDateTime, Calendar.HOUR, -24);
        
        JLabel startDateTimeLabel = new JLabel(SwingLocale.getString("start_time"));
        
		startDateTimeSelector = new JDateTimeSelector();
		startDateTimeSelector.setDate(startDateTime);
		
		JLabel endDateTimeLabel = new JLabel(SwingLocale.getString("end_time"));
		
		endDateTimeSelector = new JDateTimeSelector();
		endDateTimeSelector.setDate(endDateTime);
		
		switch (direction)
		{
			case VERTICAL:
			{
				double size[][] = 
				{ 
					{60, TableLayout.FILL}, 
					{TableLayout.PREFERRED, TableLayout.PREFERRED}
				};
				
				TableLayout tableLayout = new TableLayout(size);
				tableLayout.setHGap(5);
				tableLayout.setVGap(5);
				setLayout(tableLayout);
				setBorder(BorderManager.createComplexTitleBorder(SwingLocale.getString("time_parameter"), 0, 2, 0, 2));
				
				add(startDateTimeLabel, "0, 0");
				add(startDateTimeSelector, "1, 0");
				
				add(endDateTimeLabel, "0, 1");
				add(endDateTimeSelector, "1, 1");
				break;
			}
			case HORIZONTAL:
			{
				DimensionManager.setDimension(startDateTimeSelector, new Dimension(194, startDateTimeSelector.getPreferredSize().height));
				DimensionManager.setDimension(endDateTimeSelector, new Dimension(194, endDateTimeSelector.getPreferredSize().height));
				
				setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
				setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 0));
				
				add(startDateTimeLabel);
				add(startDateTimeSelector);
				
				add(Box.createHorizontalStrut(5));
				
				add(endDateTimeLabel);
				add(endDateTimeSelector);
				break;
			}	
		}		
	}
	
	public JDateTimeSelector getStartDateTimeSelector()
	{
		return startDateTimeSelector;
	}
	
	public void setStartDateTimeSelector(JDateTimeSelector startDateTimeSelector)
	{
		this.startDateTimeSelector = startDateTimeSelector;
	}
	
	public JDateTimeSelector getEndDateTimeSelector()
	{
		return endDateTimeSelector;
	}
	
	public void setEndDateTimeSelector(JDateTimeSelector endDateTimeSelector)
	{
		this.endDateTimeSelector = endDateTimeSelector;
	}
	
	public String getTimeRange()
	{
		Date startDateTime = startDateTimeSelector.getDate();
		Date endDateTime = endDateTimeSelector.getDate();
		
		return TimeUtil.getDateTime(startDateTime) + " - " + TimeUtil.getDateTime(endDateTime);
	}
	
	public boolean verify()
	{
		Date startDateTime = startDateTimeSelector.getDate();
		Date endDateTime = endDateTimeSelector.getDate();
		
		return TimeUtil.isTimeBefore(TimeUtil.getDateTime(startDateTime), TimeUtil.getDateTime(endDateTime));
	}
}