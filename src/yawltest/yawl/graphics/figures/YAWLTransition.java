package yawltest.yawl.graphics.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.pnml.tools.epnk.gmf.extensions.graphics.figures.TransitionFigure;

import mbse.tutorial.yawl.ControlType;
import mbse.tutorial.yawl.Transition;

public class YAWLTransition extends TransitionFigure {

	public YAWLTransition(Transition transition) {
		super(transition);
		// TODO Auto-generated constructor stub
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

		switch (joinType.getText().getValue()) {
		case 0:
			// AND
			int[] cornerPoints = {shapeRect.getTopLeft().x(),shapeRect.getTopLeft().y(),
					centerX,centerY,
					shapeRect.getBottomLeft().x(),shapeRect.getBottomLeft().y()};
			graphics.drawPolygon(cornerPoints);
			graphics.drawRectangle(centerX-width/4, centerY-height/4, width/2, height/2);
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

		switch (splitType.getText().getValue()) {
		case 0:
			// AND
			int[] cornerPoints = {shapeRect.getTopLeft().x(),shapeRect.getTopLeft().y(),
					centerX,centerY,
					shapeRect.getTopRight().x(),shapeRect.getTopRight().y()};
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
