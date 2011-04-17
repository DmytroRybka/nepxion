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

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.cots.twaver.element.TIconFactory;
import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.checkbox.JBasicCheckBox;
import com.nepxion.swing.combobox.JBasicComboBox;
import com.nepxion.swing.layout.table.TableLayout;

public class TLiteLayouter
	extends JPanel
{
	private JLabel typeLabel;
	private JBasicComboBox typeComboBox;
	
	private JLabel animationLabel;
	private JBasicCheckBox animationCheckBox;
	
	private JBasicButton runButton;
	private JBasicButton stopButton;
	
	private TLiteLayoutExecuter liteLayoutExecuter;
	
	public TLiteLayouter(final TGraph graph)
	{
		liteLayoutExecuter = new TLiteLayoutExecuter(graph);
				
		typeLabel = new JLabel("��������");
		
		typeComboBox = new JBasicComboBox(new TLayoutType[] {TLayoutType.LITE_ORGANIC_LAYOUT_TYPE, TLayoutType.LITE_SMART_ORGANIC_LAYOUT_TYPE, TLayoutType.LITE_HIERARCHIC_LAYOUT_TYPE, TLayoutType.LITE_ORTHOGONAL_LAYOUT_TYPE, TLayoutType.LITE_CIRCULAR_LAYOUT_TYPE, TLayoutType.LITE_SINGLE_CYCLE_LAYOUT_TYPE, TLayoutType.LITE_TREE_LAYOUT_TYPE, /*TLayoutType.LITE_AR_TREE_LAYOUT_TYPE, TLayoutType.LITE_HV_TREE_LAYOUT_TYPE,*/ TLayoutType.LITE_BALLOON_TREE_LAYOUT_TYPE, TLayoutType.LITE_RANDOM_LAYOUT_TYPE});
		typeComboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				doLayout(stopButton.isEnabled());
			}
		}
		);
		
		double size1[][] = 
		{
			{0.35, 0.65},
			{22}
		};
		
		JPanel layoutModePanel = new JPanel();
		layoutModePanel.setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "���ò�������"));
		layoutModePanel.setLayout(new TableLayout(size1));
		layoutModePanel.add(typeLabel, "0, 0");
		layoutModePanel.add(typeComboBox, "1, 0");
		
		animationLabel = new JLabel("����Ч��");
		
		animationCheckBox = new JBasicCheckBox("���ö���Ч��", true);
		
		double size2[][] = 
		{
			{0.35, 0.65},
			{22}
		};
		
		JPanel layoutParamPanel = new JPanel();
		layoutParamPanel.setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "���ò��ֲ���"));
		layoutParamPanel.setLayout(new TableLayout(size2));
		layoutParamPanel.add(animationLabel, "0, 0");
		layoutParamPanel.add(animationCheckBox, "1, 0");
		
		runButton = new JBasicButton("����", TIconFactory.getContextIcon("run.png"), "���в���");
		runButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				doLayout(true);
				
				runButton.setEnabled(false);
				stopButton.setEnabled(true);
			}
		}
		);
		
		stopButton = new JBasicButton("ֹͣ", TIconFactory.getContextIcon("stop.png"), "ֹͣ����");
		stopButton.setEnabled(false);
		stopButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				runButton.setEnabled(true);
				stopButton.setEnabled(false);
			}
		}
		);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		buttonPanel.add(Box.createGlue());
		buttonPanel.add(runButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(Box.createGlue());
		
		ButtonManager.updateUI(buttonPanel, new Dimension(55, 25));
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		add(layoutModePanel);
		add(layoutParamPanel);
		add(buttonPanel);
		
		typeComboBox.setSelectedIndex(1);
	}
	
	private void doLayout(boolean enabled)
	{
		if (enabled)
		{
			TLayoutType layoutType = (TLayoutType) typeComboBox.getSelectedItem();
			doLayout(layoutType);
		}
	}
	
	private void doLayout(TLayoutType layoutType)
	{
		if (layoutType.equals(TLayoutType.LITE_ORGANIC_LAYOUT_TYPE))
		{
			liteLayoutExecuter.doOrganicLayout(animationCheckBox.isSelected());
		}
		else if (layoutType.equals(TLayoutType.LITE_SMART_ORGANIC_LAYOUT_TYPE))
		{
			liteLayoutExecuter.doSmartOrganicLayout(animationCheckBox.isSelected());
		}
		else if (layoutType.equals(TLayoutType.LITE_HIERARCHIC_LAYOUT_TYPE))
		{
			liteLayoutExecuter.doHierarchicLayout(animationCheckBox.isSelected());
		}
		else if (layoutType.equals(TLayoutType.LITE_ORTHOGONAL_LAYOUT_TYPE))
		{
			liteLayoutExecuter.doOrthogonalLayout(animationCheckBox.isSelected());
		}
		else if (layoutType.equals(TLayoutType.LITE_CIRCULAR_LAYOUT_TYPE))
		{
			liteLayoutExecuter.doCircularLayout(animationCheckBox.isSelected());
		}
		else if (layoutType.equals(TLayoutType.LITE_SINGLE_CYCLE_LAYOUT_TYPE))
		{
			liteLayoutExecuter.doSingleCycleLayout(animationCheckBox.isSelected());
		}
		else if (layoutType.equals(TLayoutType.LITE_TREE_LAYOUT_TYPE))
		{
			liteLayoutExecuter.doTreeLayout(animationCheckBox.isSelected());
		}
		else if (layoutType.equals(TLayoutType.LITE_AR_TREE_LAYOUT_TYPE))
		{
			liteLayoutExecuter.doARTreeLayout(animationCheckBox.isSelected());
		}
		else if (layoutType.equals(TLayoutType.LITE_HV_TREE_LAYOUT_TYPE))
		{
			liteLayoutExecuter.doHVTreeLayout(animationCheckBox.isSelected());
		}
		else if (layoutType.equals(TLayoutType.LITE_BALLOON_TREE_LAYOUT_TYPE))
		{
			liteLayoutExecuter.doBalloonTreeLayout(animationCheckBox.isSelected());
		}
		else if (layoutType.equals(TLayoutType.LITE_RANDOM_LAYOUT_TYPE))
		{
			liteLayoutExecuter.doRandomLayout(animationCheckBox.isSelected());
		}
	}
}