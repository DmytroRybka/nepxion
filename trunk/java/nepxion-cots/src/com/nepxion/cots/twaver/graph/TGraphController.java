package com.nepxion.cots.twaver.graph;

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

import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;

import com.nepxion.cots.twaver.element.TGroupType;
import com.nepxion.cots.twaver.icon.TIconFactory;
import com.nepxion.swing.action.JSecurityAction;

public class TGraphController
{
	public static JSecurityAction getSelectAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("ѡ��", TIconFactory.getContextIcon("select.png"), "ѡ��")
		{
			public void execute(ActionEvent e)
			{
				AbstractButton button = (AbstractButton) e.getSource();
				if (button.isSelected())
				{
					TGraphManager.select(graph);
				}
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getPanAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("�϶�", TIconFactory.getContextIcon("pan.png"), "�϶�")
		{
			public void execute(ActionEvent e)
			{
				AbstractButton button = (AbstractButton) e.getSource();
				if (button.isSelected())
				{
					TGraphManager.pan(graph);
				}
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getLazyMoveAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("�ӳ��϶�", TIconFactory.getContextIcon("lazy_move.png"), "�ӳ��϶�")
		{
			public void execute(ActionEvent e)
			{
				AbstractButton button = (AbstractButton) e.getSource();
				if (button.isSelected())
				{
					TGraphManager.layzMove(graph);
				}
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getZoomInAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("�Ŵ�", TIconFactory.getContextIcon("zoom_in.png"), "�Ŵ� Ctrl +")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.zoomIn(graph);
			}
		};
		TGraphKeyboardRegister.registerZoomIn(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getZoomOutAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("��С", TIconFactory.getContextIcon("zoom_out.png"), "��С Ctrl -")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.zoomOut(graph);
			}
		};
		TGraphKeyboardRegister.registerZoomOut(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getZoomInRectangleAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("��������Ŵ�", TIconFactory.getContextIcon("zoom_in_rectangle.png"), "��������Ŵ�")
		{
			public void execute(ActionEvent e)
			{
				AbstractButton button = (AbstractButton) e.getSource();
				if (button.isSelected())
				{
					TGraphManager.zoomInRectangle(graph);
				}
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getZoomResetAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("ԭʼ��С", TIconFactory.getContextIcon("zoom_reset.png"), "ԭʼ��С Ctrl-O")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.zoomReset(graph);
			}
		};
		TGraphKeyboardRegister.registerZoomReset(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getZoomToOverviewAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("��Ӧ��Ļ", "��Ӧ��Ļ")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.zoomToOverview(graph);
			}
		};
		TGraphKeyboardRegister.registerZoomToOverview(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getZoomBackAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("���ź���", "���ź���")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.zoomBack(graph);
			}
		};
		TGraphKeyboardRegister.registerZoomBack(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getMagnifierAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("�Ŵ�", TIconFactory.getContextIcon("magnifier.png"), "�Ŵ�")
		{
			public void execute(ActionEvent e)
			{
				AbstractButton button = (AbstractButton) e.getSource();
				if (button.isSelected())
				{
					TGraphManager.magnifier(graph);
				}
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getScaleAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("����ͱ���", TIconFactory.getContextIcon("scale.png"), "����ͱ���")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.scale(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getFullScreenAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("ȫ���л�", TIconFactory.getContextIcon("fullscreen.png"), "ȫ���л� F10")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.fullScreen(graph);
				if (e.getSource() instanceof AbstractButton)
				{
					AbstractButton button = (AbstractButton) e.getSource();
					button.getModel().setRollover(false);
				}
			}
		};
		TGraphKeyboardRegister.registerFullScreen(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getOverviewAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("ӥ�۴���", TIconFactory.getContextIcon("overview.png"), "ӥ�۴���")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.overview(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getAddAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("�½�", TIconFactory.getContextIcon("new.png"), "�½�ͼԪ Ctrl+N")
		{
			public void execute(ActionEvent e)
			{
				graph.getAdapter().addElement();
			}
		};
		TGraphKeyboardRegister.registerNew(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getDeleteAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("ɾ��", TIconFactory.getContextIcon("delete.png"), "ɾ��ͼԪ Delete")
		{
			public void execute(ActionEvent e)
			{
				graph.getAdapter().deleteElement();
			}
		};
		TGraphKeyboardRegister.registerDelete(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getClearAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("���", TIconFactory.getContextIcon("clear.png"), "���ͼԪ")
		{
			public void execute(ActionEvent e)
			{
				graph.getAdapter().clear();
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getRefreshAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("ˢ��", TIconFactory.getContextIcon("refresh.png"), "ˢ�� F5")
		{
			public void execute(ActionEvent e)
			{
				graph.getAdapter().refresh();
			}
		};
		TGraphKeyboardRegister.registerRefresh(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getRenameAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("������", TIconFactory.getContextIcon("rename.png"), "������ͼԪ")
		{
			public void execute(ActionEvent e)
			{
				graph.getAdapter().renameElement();
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getSaveAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("����", TIconFactory.getContextIcon("save.png"), "���� Ctrl+S")
		{
			public void execute(ActionEvent e)
			{
				graph.getAdapter().save();
			}
		};
		TGraphKeyboardRegister.registerSave(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getPropertyAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("����", TIconFactory.getContextIcon("config.png"), "����")
		{
			public void execute(ActionEvent e)
			{
				graph.getAdapter().modifyElement();
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getCopyAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("����", TIconFactory.getContextIcon("copy.png"), "����ͼԪ Ctrl+C")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.copy(graph);
			}
		};
		TGraphKeyboardRegister.registerCopy(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getPasteAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("ճ��", TIconFactory.getContextIcon("paste.png"), "ճ��ͼԪ Ctrl+V")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.paste(graph);
			}
		};
		TGraphKeyboardRegister.registerPaste(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getSelectAllAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("ȫѡ", TIconFactory.getContextIcon("select_all.png"), "ȫѡͼԪ Ctrl+A")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.selectAll(graph);
			}
		};
		TGraphKeyboardRegister.registerSelectAll(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getUndoAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("����", TIconFactory.getContextIcon("undo.png"), "���� Ctrl+Z")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.undo(graph);
			}
		};
		TGraphKeyboardRegister.registerUndo(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getRedoAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("����", TIconFactory.getContextIcon("redo.png"), "���� Ctrl+Y")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.redo(graph);
			}
		};
		TGraphKeyboardRegister.registerRedo(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getLabelConfigAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("��ǩ����", TIconFactory.getContextIcon("label.png"), "��ǩ����")
		{
			public void execute(ActionEvent e)
			{
				graph.getAdapter().labelConfig();
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getGroupTypeConfigAction(final TGraph graph, final TGroupType groupType)
	{
		JSecurityAction action = new JSecurityAction(groupType.toString(), "��" + groupType + "��ʾ")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.setGroupType(graph, groupType);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getGroupExpandAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("��ȫ��չ��", "��ȫ��չ��")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.setGroupExpand(graph, true);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getGroupCollapseAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("��ȫ������", "��ȫ������")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.setGroupExpand(graph, false);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getLockAllAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("����ȫ���ڵ�", "����ȫ���ڵ�")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.setMovable(graph, false);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getUnLockAllAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("����ȫ���ڵ�", "����ȫ���ڵ�")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.setMovable(graph, true);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getLockSelectionAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("����ѡ�нڵ�", "����ѡ�нڵ�")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.lockSelection(graph, false);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getUnLockSelectionAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("����ѡ�нڵ�", "����ѡ�нڵ�")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.lockSelection(graph, true);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getHideChildrenAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("��ʾ�������ӽڵ�", TIconFactory.getContextIcon("hide.png"), "��ʾ�������ӽڵ�")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.hideChildren(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getLayoutAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("����������", TIconFactory.getContextIcon("layout.png"), "����������")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.layout(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getAlignLeftAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("��߶���", TIconFactory.getContextIcon("align_left.png"), "��߶���")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.alignLeft(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getAlignVerticalCenterAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("�����������", TIconFactory.getContextIcon("align_vertical_center.png"), "�����������")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.alignVerticalCenter(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getAlignRightAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("�ұ߶���", TIconFactory.getContextIcon("align_right.png"), "�ұ߶���")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.alignRight(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getAlignTopAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("��������", TIconFactory.getContextIcon("align_top.png"), "��������")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.alignTop(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getAlignHorizontalCenterAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("�����������", TIconFactory.getContextIcon("align_horizontal_center.png"), "�����������")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.alignHorizontalCenter(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getAlignBottoJSecurityAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("�ײ�����", TIconFactory.getContextIcon("align_bottom.png"), "�ײ�����")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.alignBottom(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getPileToLeftAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("��߶���", TIconFactory.getContextIcon("pile_to_left.png"), "��߶���")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.pileToLeft(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getPileToRightAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("�ұ߶���", TIconFactory.getContextIcon("pile_to_right.png"), "�ұ߶���")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.pileToRight(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getPileToTopAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("��������", TIconFactory.getContextIcon("pile_to_top.png"), "��������")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.pileToTop(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getPileToBottoJSecurityAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("�ײ�����", TIconFactory.getContextIcon("pile_to_bottom.png"), "�ײ�����")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.pileToBottom(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getSameWidthAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("�ȿ�", TIconFactory.getContextIcon("same_width.png"), "�ȿ�")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.sameWidth(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getSameHeightAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("�ȸ�", TIconFactory.getContextIcon("same_height.png"), "�ȸ�")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.sameHeight(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getSameHorizontalSpaceAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("����Ⱦ�", TIconFactory.getContextIcon("same_horizontal_space.png"), "����Ⱦ�")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.sameHorizontalSpace(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getSameVerticalSpaceAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("����Ⱦ�", TIconFactory.getContextIcon("same_vertical_space.png"), "����Ⱦ�")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.sameVerticalSpace(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getMoveToUpAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("����һ��", TIconFactory.getContextIcon("move_to_up.png"), "����һ��")
		{
			public void execute(ActionEvent e)
			{
				
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getMoveToDownAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("����һ��", TIconFactory.getContextIcon("move_to_down.png"), "����һ��")
		{
			public void execute(ActionEvent e)
			{
				
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getMoveToTopAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("�������", TIconFactory.getContextIcon("move_to_top.png"), "�������")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.moveToTop(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getMoveToBottoJSecurityAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("������ײ�", TIconFactory.getContextIcon("move_to_bottom.png"), "������ײ�")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.moveToBottom(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getImportAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("����", TIconFactory.getContextIcon("import.png"), "����XML�ļ� Ctrl+M")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.importXML(graph);
			}
		};
		TGraphKeyboardRegister.registerImport(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getExportXMLAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("�����ļ�", TIconFactory.getContextIcon("xml.png"), "���������ļ�")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.exportXML(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getExportExcelAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("����ļ�", TIconFactory.getContextIcon("excel.png"), "��������ļ�")
		{
			public void execute(ActionEvent e)
			{
				
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getExportSVGAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("ʸ���ļ�", TIconFactory.getContextIcon("svg.png"), "ʸ���ļ�")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.exportSVG(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getExportImageAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("ͼƬ�ļ�", TIconFactory.getContextIcon("image.png"), "����ͼƬ�ļ�")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.exportImage(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getStatAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("ͳ��", TIconFactory.getContextIcon("stat.png"), "ͳ��")
		{
			public void execute(ActionEvent e)
			{
				graph.getAdapter().stat();
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getPrintAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("��ӡ", TIconFactory.getContextIcon("print.png"), "��ӡ")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.print(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getShowControlBarAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("��ʾ�������", TIconFactory.getSwingIcon("toggle_size.png"), "��ʾ�������")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.toggleControlBar(graph, true);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getHideControlBarAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("���ز������", TIconFactory.getSwingIcon("close_item.png"), "���ز������")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.toggleControlBar(graph, false);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getToggleControlBarAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("���", TIconFactory.getContextIcon("pane.png"), "��ʾ�����ز������")
		{
			public void execute(ActionEvent e)
			{
				if (graph.getControlBarInternalFrame().isVisible())
				{
					TGraphManager.toggleControlBar(graph, false);
				}
				else
				{
					TGraphManager.toggleControlBar(graph, true);
				}
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getToggleControlBarAction(final TInternalFrame controlBarInternalFrame, final int selectedIndex)
	{
		final TGraphControlBar controlBar = (TGraphControlBar) controlBarInternalFrame.getContent();
		String title = controlBar.getTitleAt(selectedIndex);
		
		JSecurityAction action = new JSecurityAction(title, "�л���" + title)
		{
			public void execute(ActionEvent e)
			{
				if (!controlBarInternalFrame.isVisible())
				{
					controlBarInternalFrame.tween(true);
				}
				
				controlBar.setSelectedIndex(selectedIndex);
			}
		};
		
		return action;
	}
}