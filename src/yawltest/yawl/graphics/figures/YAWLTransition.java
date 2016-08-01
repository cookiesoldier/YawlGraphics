package yawltest.yawl.graphics.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.pnml.tools.epnk.gmf.extensions.graphics.figures.TransitionFigure;

import mbse.tutorial.yawl.ControlType;
import mbse.tutorial.yawl.Transition;

public class YAWLTransition extends TransitionFigure {

	public YAWLTransition(Transition transition) {
		super(transition);
	}

	@Override
	public void update() {
		this.repaint();
	}

	@Override
	protected void fillShape(Graphics graphics) {
		super.fillShape(graphics);
		
		ControlType splitType = ((Transition) this.transition).getSplit();
		ControlType joinType = ((Transition) this.transition).getJoin();

		graphics.pushState();

		// Find bounding rect of the shape we draw.
		Rectangle shapeRect = this.getClientArea();
		// Find center of the rect
		int width = shapeRect.width;
		int height = shapeRect.height;
		int centerX = shapeRect.x + width / 2;
		int centerY = shapeRect.y + height / 2;
		
		graphics.setLineWidth(1);
		int offSetX = width/5;
		
		graphics.drawLine(new Point(centerX-offSetX/2,shapeRect.getTopLeft().y), 
				new Point(centerX-offSetX/2,shapeRect.getBottomLeft().y));
		
		if(joinType == null){
			return;
		}
		
		switch (joinType.getText().getValue()) {
	
		case 0:
			// AND
			int[] cornerPoints = {shapeRect.getTopLeft().x(),shapeRect.getTopLeft().y(),
					centerX-offSetX/2,centerY,
					shapeRect.getBottomLeft().x(),shapeRect.getBottomLeft().y()};
			graphics.drawPolygon(cornerPoints);
			break;
		case 1:
			// OR
			int[] cornerPoints1 = {shapeRect.getTopLeft().x(), centerY,
					shapeRect.x+offSetX, shapeRect.getTopLeft().y(),
					centerX-offSetX/2, centerY,
					shapeRect.x+offSetX, shapeRect.getBottomLeft().y()};
			graphics.drawPolygon(cornerPoints1);
			break;
		case 2:
			// XOR
			int[] cornerPoints2 = {centerX-offSetX/2,shapeRect.getTopLeft().y(),
					shapeRect.getTopLeft().x(),centerY,
					centerX-offSetX/2,shapeRect.getBottomLeft().y()};
			graphics.drawPolygon(cornerPoints2);
			break;

		default:
			break;
		}
		
		if(splitType == null){
			return;
		}
		graphics.drawLine(new Point(centerX+offSetX/2,shapeRect.getTopLeft().y), 	new Point(centerX+offSetX/2,shapeRect.getBottomLeft().y));
		switch (splitType.getText().getValue()) {
		case 0:
			// AND
			int[] cornerPoints = {shapeRect.getTopRight().x(),shapeRect.getTopRight().y(),
					centerX+offSetX/2,centerY,
					shapeRect.getBottomRight().x(),shapeRect.getBottomRight().y()};
			graphics.drawPolygon(cornerPoints);
			break;
		case 1:
			//OR
			int[] cornerPoints1 = {shapeRect.getTopRight().x(), centerY,
					shapeRect.x+width-offSetX, shapeRect.getTopRight().y(),
					centerX+offSetX/2, centerY,
					shapeRect.x+width-offSetX, shapeRect.getBottomRight().y()};
			graphics.drawPolygon(cornerPoints1);
			break;
		case 2:
			// XOR
			int[] cornerPoints2 = {centerX+offSetX/2,shapeRect.getTopRight().y(),
					shapeRect.getBottomRight().x,centerY,
					centerX+offSetX/2,shapeRect.getBottomRight().y()};
			graphics.drawPolygon(cornerPoints2);
			break;
		default:
			break;
		}
		
		graphics.popState();
	}

}
