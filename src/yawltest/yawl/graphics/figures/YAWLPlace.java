package yawltest.yawl.graphics.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.pnml.tools.epnk.gmf.extensions.graphics.figures.PlaceFigure;

import mbse.tutorial.yawl.Place;
import mbse.tutorial.yawl.PlaceType;



public class YAWLPlace extends PlaceFigure {

	public YAWLPlace(Place place) {
		super(place);
		
	}
	
	@Override
	public void update(){
		this.repaint();
	}
	
	
	@Override
	protected void fillShape(Graphics graphics) {
		PlaceType type = ((Place) this.place).getType();
		//Find bounding rect of the shape we draw.
		Rectangle shapeRect = this.getClientArea();
		//Find center of the rect
		int width =shapeRect.width;
		int height = shapeRect.height;
		int centerX = shapeRect.x + width /2;
		int centerY = shapeRect.y + height /2;
		
		if(type == null){
			return;
		}
		graphics.pushState();
		
		switch (type.getText().getValue()) {
		case 0:
			//start --> triangle
			int[] cornerPoints = {centerX-width/3,centerY-height/3,centerX+width/2,centerY,centerX-width/3,centerY+height/3};
			graphics.drawPolygon(cornerPoints);
			
			break;
		case 1:
			//end - Square
			graphics.drawRectangle(centerX-width/4, centerY-height/4, width/2, height/2);
			
			
			break;
		case 2:
			//Normal - nothing?
			
			break;
		default:
			//Draw regular place?
			
			break;
		}
		
		graphics.popState();
		
		
	}

}
