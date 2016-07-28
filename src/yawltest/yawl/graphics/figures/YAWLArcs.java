package yawltest.yawl.graphics.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.swt.SWT;
import org.pnml.tools.epnk.gmf.extensions.graphics.figures.ArcFigure;
import mbse.tutorial.yawl.Arc;
import mbse.tutorial.yawl.ArcType;


public class YAWLArcs extends ArcFigure {

	public YAWLArcs(Arc arc) {
		super(arc);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void update(){
		ArcType type = ((Arc) this.arc).getType();
		
		switch(type.getText().getValue()){
		//Regular
		case 0:
			this.setLineStyle(SWT.LINE_SOLID);
			break;
		//Reset Arc
		case 1:
			this.setLineStyle(SWT.LINE_DASH);
			break;
		default:
			
			
		}
	}

}
