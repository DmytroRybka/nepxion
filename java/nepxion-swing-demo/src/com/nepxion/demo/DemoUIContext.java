package com.nepxion.demo;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import com.nepxion.demo.component.splash.DemoCaptionSplashDialog;
import com.nepxion.swing.chart.ChartContext;
import com.nepxion.swing.icon.IconContext;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.popupmenu.PopupMenuContext;
import com.nepxion.swing.style.framework.JPlasticStyle;
import com.nepxion.swing.style.framework.StyleContext;
import com.nepxion.swing.topic.TopicContext;

public class DemoUIContext
{		
	public static void initialize()
	{			
		//ע���ܷ��Ĭ����LookAndFeel����
		//StyleContext.registerStyle(JLiteStyle.ID);
		//StyleContext.registerStyle(JWindowsStyle.ID);
		//StyleContext.registerStyle(JEclipseStyle.ID);	
		StyleContext.registerStyle(JPlasticStyle.ID);		
		//StyleContext.registerStyle(JFervencyStyle.ID);
		//StyleContext.registerStyle(JNimbusStyle.ID);
		
		//ע���Ƿ�����װ����������΢Ӱ����ʾ���ܡ�Ĭ��ΪThemeDecorated������FrameDecorated��DialogDecorated�ر�
		//StyleContext.registerThemeDecorated(true);
		StyleContext.registerFrameDecorated(true);
		StyleContext.registerDialogDecorated(true);
		//StyleContext.registerTabbedPaneDecorated(false);
		
		//ע���������
		//FontContext.registerFont("Dialog", Font.PLAIN, 12);
		//FontContext.registerChartTitleFont("SimHei", Font.PLAIN, 18);
		//FontContext.registerChartSubTitleFont("Dialog", Font.PLAIN, 12);
		//FontContext.registerChartLabelFont("Dialog", Font.PLAIN, 12);
		//FontContext.registerChartTickLabelFont("SansSerif", Font.PLAIN, 10);
		
		//ע��JFreeChart����PDF�Ĳ���
		ChartContext.registerChartPDFAuthor("Haojun Ren");
		ChartContext.registerChartPDFSubject("Nepxion");
		
		//ע�ᰴť���Ĭ����LookAndFeel����
		//ButtonContext.registerUI(FlatButtonUI.ID, JFlatButtonStyle.ID);
		//ButtonContext.registerUI(LiteButtonUI.ID, JAlloyLiteButtonStyle.ID);
		//ButtonContext.registerUI(LiteButtonUI.ID, JAcidLiteButtonStyle.ID);
		//ButtonContext.registerUI(LiteButtonUI.ID, JBedouinLiteButtonStyle.ID);
		//ButtonContext.registerUI(LiteButtonUI.ID, JGlassLiteButtonStyle.ID);
		//ButtonContext.registerUI(LiteButtonUI.ID, JEclipseLiteButtonStyle.ID);
		//ButtonContext.registerUI(LiteButtonUI.ID, JNimbusLiteButtonStyle.ID);
		//ButtonContext.registerUI(LiteButtonUI.ID, JBorlandLiteButtonStyle.ID);
		//ButtonContext.registerUI(LiteButtonUI.ID, JBlueLiteButtonStyle.ID);
		//ButtonContext.registerUI(LiteButtonUI.ID, JYellowLiteButtonStyle.ID);
		
		//ע�ᰴť��Inset
		//ButtonContext.registerInset(5, 5);
		
		//ע��˵��Ĵ�ֱ���⣬Ĭ��ΪNepxion
		PopupMenuContext.registerTitle("Nepxion");
		
		//ע�����Ѱַ��ͼ��·����Ĭ��Ϊ��
		IconContext.registerIconFolder("com/nepxion/demo/component/icon/image/");
		
		//ע���������Ĺ���ҳ��
		TopicContext.registerTopicComponent(new DemoCaptionSplashDialog());		
		
		//ע�����Ч��
		//LookAndFeelManager.setSystemLookAndFeel();
		//LookAndFeelManager.setDefaultMetalLookAndFeel();
		//LookAndFeelManager.setMetalLookAndFeel();
		//LookAndFeelManager.setWindowsLookAndFeel();
		//LookAndFeelManager.setMotifLookAndFeel();
		//LookAndFeelManager.setGTKLookAndFeel();
		//LookAndFeelManager.setNimbusLookAndFeel();
		LookAndFeelManager.setAlloyLookAndFeel();
		//LookAndFeelManager.setAcidLookAndFeel();
		//LookAndFeelManager.setBedouinLookAndFeel();
		//LookAndFeelManager.setGlassLookAndFeel();
		//LookAndFeelManager.setBorlandLookAndFeel();
		//LookAndFeelManager.setJGoodiesWindowsLookAndFeel();
		//LookAndFeelManager.setPlasticLookAndFeel();
		//LookAndFeelManager.setPlasticXPLookAndFeel();
		//LookAndFeelManager.setPlastic3DLookAndFeel();
		//LookAndFeelManager.setXPLookAndFeel();
		//LookAndFeelManager.setTinyLookAndFeel();		
	}
}