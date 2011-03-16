package com.nepxion.swing.table.layoutable;

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

import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class TableCellRendererLayout
{
	// ����Ӧ�ߴ�����
	// 1. �����õ�Ԫ��Ŀ���ʱ����Ƚϱ���Ԫ�������CellRenderer�ͱ���ͷ��Ԫ�������Ŀ��ȣ�ȡ���ֵ�����õ�Ԫ��Ŀ���
	// 2. �����õ�Ԫ��ĸ߶�ʱ��ȡ����Ԫ�������CellRenderer�ĸ߶ȣ����õ�Ԫ��ĸ߶�
	public static final int PREFERRED = -1;
	
	// �����гߴ�����
	public static final int IGNORE = -2;
	
	private JTable table;
	
	public TableCellRendererLayout(JTable table)
	{
		this.table = table;
	}
	
	public void doLayout()
	{
		doLayout((int[]) null);
	}
	
	public void doLayout(int[] gaps)
	{
		doLayout(null, null, gaps);
	}
	
	public void doLayout(int[][] sizes)
	{
		doLayout(sizes, (int[][]) null);
	}
	
	public void doLayout(int[][] sizes, int[][] range)
	{
		doLayout(sizes, range, null);
	}
	
	public void doLayout(int[][] range, int[] gaps)
	{
		doLayout(null, range, gaps);
	}	
	
	/*
	 * 1.������int[][] size 
	 *   ˵������һ�����������������ȵ�������ڶ����������������߶ȵ����
	 *   ������{{50, NONE, PREFERRED}, {PREFERRED, 50, NONE}}
	 *         ��ʾ��0�п���Ϊ50����1�в����п������ã��ɱ��������䣩����2������Ӧ��������
	 *         ��ʾ��0������Ӧ�߶����ã���1�и߶�Ϊ50����2�в����и߶����ã��ɱ��������䣩
	 *         
	 *   ������int[] range
	 *   ˵������һ�����������������ȵ������С���䣬�ڶ�����������������ȵ������С���䡣�����ֻ���������������õ����
	 *   ������{{50, 100}, {10, 50}}
	 *         ��ʾ������Ӧ����ʱ�򣬱���Ԫ�������СΪ50�� ���Ϊ100���粻�趨��������Сֵ������-1�����棬{-1, 100}����ʾ���Ϊ100����С������
	 *         ��ʾ������Ӧ����ʱ�򣬱���Ԫ����СΪ10�� ���Ϊ50���粻�趨��������Сֵ������-1�����棬{-1, 100}����ʾ���Ϊ100����С������
	 *   ������{10, -5}
	 *         ��ʾ���б����мӿ�10������ֵ�����б����м���5������ֵ
	 *                                      
	 *   ������int[] gaps
	 *   ˵������һ��ֵΪ������ֵ������Ϊ�ӿ�������ֵ������Ϊ����������ֵ 
	 *   ������{10, -5}
	 *         ��ʾ���б����мӿ�10������ֵ�����б����м���5������ֵ
	 * 2.��ʾ��
	 *   ���������ȷ����ȳ��ֵ��еĿ��ȣ����������3�У��������һ�еĿ���Ϊ100��������Ч�ģ���Ϊ�����Ѿ�Ϊǰ2�з�����Ĭ�ϵĿ��ȣ����һ��ֻ��ִ������Ӧ�Ŀ���                
	 */
	public void doLayout(int[][] sizes, int[][] range, int[] gaps)
	{
		int[] columnWidths = null;
		int[] rowHeights = null;
		if (sizes != null)
		{
			columnWidths = sizes[0];
			rowHeights = sizes[1];
		}
		
		int[] columnRangeWidths = null;
		int[] rowRangeHeights = null;
		if (range != null)
		{
			columnRangeWidths = range[0];
			rowRangeHeights = range[1];
		}
		
		int columnMinimumWidth = 0;
		int columnMaximumWidth = 0;
		if (columnRangeWidths != null)
		{
			columnMinimumWidth = columnRangeWidths[0];
			columnMaximumWidth = columnRangeWidths[1];
		}
		
		int rowMinimumHeight = 0;
		int rowMaximumHeight = 0;
		if (rowRangeHeights != null)
		{
			rowMinimumHeight = rowRangeHeights[0];
			rowMaximumHeight = rowRangeHeights[1];
		}
		
		int columnGap = 0;
		int rowGap = 0;
		if (gaps != null)
		{
			columnGap = gaps[0];
			rowGap = gaps[1];
		}
		
		int columnCount = table.getColumnCount();
		for (int columnIndex = 0; columnIndex < columnCount; columnIndex++)
		{
			int columnWidth = IGNORE;
			if (columnWidths == null)
			{
				columnWidth = PREFERRED;
			}
			else
			{
				if (columnIndex < columnWidths.length)
				{
					columnWidth = columnWidths[columnIndex];
				}
				else
				{
					break;
				}
			}
			doLayoutColumnWidth(columnIndex, columnWidth, columnMinimumWidth, columnMaximumWidth, columnGap);
		}
		
		int rowCount = table.getRowCount();
		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++)
		{
			int rowHeight = IGNORE;
			if (rowHeights == null)
			{
				rowHeight = PREFERRED;
			}
			else
			{
				if (rowIndex < rowHeights.length)
				{
					rowHeight = rowHeights[rowIndex];
				}
				else
				{
					break;
				}
			}
			doLayoutRowHeight(rowIndex, rowHeight, rowMinimumHeight, rowMaximumHeight, rowGap);
		}
	}
	
	public void doLayoutColumnWidth(int columnIndex, int columnWidth, int columnMinimumWidth, int columnMaximumWidth, int columnGap)
	{
		JTableHeader header = table.getTableHeader();
		TableColumn column = table.getColumnModel().getColumn(columnIndex);
		header.setResizingColumn(column);
		
		if (columnWidth > 0)
		{
			column.setWidth(columnWidth + columnGap);
		}
		if (columnWidth == -1)
		{
			int rowCount = table.getRowCount();
			
			Component headerCellRenderer = header.getDefaultRenderer().getTableCellRendererComponent(table, column.getIdentifier(), false, false, 0, columnIndex);
			int width = (int) headerCellRenderer.getPreferredSize().getWidth();
			
			for (int rowIndex = 0; rowIndex < rowCount; rowIndex++)
			{
				Component cellRenderer = table.getCellRenderer(rowIndex, columnIndex).getTableCellRendererComponent(table, table.getValueAt(rowIndex, columnIndex), false, false, rowIndex, columnIndex);
				
				int cellRendererWidth = (int) cellRenderer.getPreferredSize().getWidth();
				width = Math.max(cellRendererWidth, width);
			}
			
			if (columnMinimumWidth > 0 && columnMinimumWidth > width)
			{
				width = columnMinimumWidth;
			}
			else if (columnMaximumWidth > 0 && columnMaximumWidth < width)
			{
				width = columnMaximumWidth;
			}
			
			column.setWidth(width + columnGap);
		}
	}
	
	public void doLayoutRowHeight(int rowIndex, int rowHeight, int rowMinimumHeight, int rowMaximumHeight, int rowGap)
	{
		if (rowHeight > 0)
		{
			table.setRowHeight(rowIndex, rowHeight + rowGap);
		}
		if (rowHeight == -1)
		{
			int columnCount = table.getColumnCount();
			int height = 0;
			
			for (int columnIndex = 0; columnIndex < columnCount; columnIndex++)
			{
				Component cellRenderer = table.getCellRenderer(rowIndex, columnIndex).getTableCellRendererComponent(table, table.getValueAt(rowIndex, columnIndex), false, false, rowIndex, columnIndex);
				int cellRendererHeight = (int) cellRenderer.getPreferredSize().getHeight();
				if (height < cellRendererHeight)
				{
					height = cellRendererHeight;
				}
			}
			
			if (rowMinimumHeight > 0 && rowMinimumHeight > height)
			{
				height = rowMinimumHeight;
			}
			else if (rowMaximumHeight > 0 && rowMaximumHeight < height)
			{
				height = rowMaximumHeight;
			}
			
			if (height + rowGap > 0)
			{	
				table.setRowHeight(rowIndex, height + rowGap);
			}
		}
	}
}