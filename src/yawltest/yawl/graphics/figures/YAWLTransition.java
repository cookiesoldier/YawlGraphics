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
		
		graphics.drawLine(new Point(centerX-offSetX,shapeRect.getTopLeft().y), 
				new Point(centerX-offSetX,shapeRect.getBottomLeft().y));
		
		switch (joinType.getText().getValue()) {
		case 0:
			// AND
			int[] cornerPoints = {shapeRect.getTopLeft().x(),shapeRect.getTopLeft().y(),
					centerX-offSetX,centerY,
					shapeRect.getBottomLeft().x(),shapeRect.getBottomLeft().y()};
			graphics.drawPolygon(cornerPoints);
			break;
		case 1:
			// OR

			break;
		case 2:
			// XOR
			break;

		default:
			break;
		}

		
		graphics.drawLine(new Point(centerX+offSetX,shapeRect.getTopLeft().y), 	new Point(centerX+offSetX,shapeRect.getBottomLeft().y));
		switch (splitType.getText().getValue()) {
		case 0:
			// AND
			int[] cornerPoints = {shapeRect.getTopRight().x(),shapeRect.getTopRight().y(),
					centerX+offSetX,centerY,
					shapeRect.getBottomRight().x(),shapeRect.getBottomRight().y()};
			graphics.drawPolygon(cornerPoints);
			break;
		case 1:
			// OR

			break;
		case 2:
			// XOR

			break;
		default:
			break;
		}
		
		graphics.popState();
	}

}
