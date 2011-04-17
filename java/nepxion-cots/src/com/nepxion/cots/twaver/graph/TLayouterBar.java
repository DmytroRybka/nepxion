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

import com.nepxion.swing.outlookbar.JFlatOutlookBar;

public class TLayouterBar
	extends JFlatOutlookBar
{
	public TLayouterBar(TGraph graph)
	{
		TLayouter layouter = new TLayouter(graph);
		TLiteLayouter liteLayouter = new TLiteLayouter(graph);
		
		addTab("��������", null, makeScrollPane(layouter), "��������");
		addTab("��ǿ����", null, makeScrollPane(liteLayouter), "��ǿ����");
	}
}