package com.nepxion.swing.searcher.mobile.locating;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.event.ActionEvent;

import com.nepxion.swing.action.JSecurityAction;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.thread.dialog.JThreadDialog;
import com.nepxion.util.searcher.mobile.locating.LocatingMobileEntity;
import com.nepxion.util.searcher.mobile.locating.LocatingMobileSearcher;

public class LocatingMobileController
{
	public static JSecurityAction getSearchAction(final JLocatingMobilePanel panel)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("query"), IconFactory.getSwingIcon("stereo_search.png"), SwingLocale.getString("mobile_to_address"))
		{
			public void execute(ActionEvent e)
			{
				JThreadDialog dialog = new JThreadDialog(HandleManager.getFrame(panel), SwingLocale.getString("mobile_to_address"), SwingLocale.getString("query_and_wait"))
				{
					protected void loadForeground(Object data)
						throws Exception
					{
						LocatingMobileEntity entity = (LocatingMobileEntity) data;
						if (entity == null)
						{
							JBasicOptionPane.showMessageDialog(HandleManager.getFrame(panel), SwingLocale.getString("no_records"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
							return;
						}
						
						LocatingMobileTableModel tableModel = (LocatingMobileTableModel) panel.getMobileTable().getDataModel();
						tableModel.addRow(entity);
					}
					
					protected Object loadBackground()
						throws Exception
					{
						String mobile = panel.getMobile();
						if (mobile.equals(""))
						{
							throw new IllegalArgumentException(SwingLocale.getString("mobile_not_null"));
						}
						
						if (mobile.length() != 11)
						{
							throw new IllegalArgumentException(SwingLocale.getString("mobile_length_11"));
						}
						
						LocatingMobileSearcher searcher = new LocatingMobileSearcher();
						LocatingMobileEntity entity = searcher.search(mobile);
						return entity;
					}
				};
				dialog.execute();
			}
		};
		return action;
	}
	
	public static JSecurityAction getClearAction(final JLocatingMobileTable table)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("clear"), IconFactory.getSwingIcon("stereo/delete_16.png"), SwingLocale.getString("clear_query_result"))
		{
			public void execute(ActionEvent e)
			{
				int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame(table), SwingLocale.getString("confirm_to_clear_query_result"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
				if (selectedValue != JBasicOptionPane.YES_OPTION)
				{
					return;
				}
				LocatingMobileTableModel tableModel = (LocatingMobileTableModel) table.getDataModel();
				tableModel.clearRows();
			}
		};
		return action;
	}
}