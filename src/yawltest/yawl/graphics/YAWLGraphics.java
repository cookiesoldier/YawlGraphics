package yawltest.yawl.graphics;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.pnml.tools.epnk.gmf.extensions.graphics.GraphicalExtension;
import org.pnml.tools.epnk.gmf.extensions.graphics.IArcFigure;
import org.pnml.tools.epnk.gmf.extensions.graphics.IUpdateableFigure;
import org.pnml.tools.epnk.pnmlcoremodel.Place;
import org.pnml.tools.epnk.pnmlcoremodel.Transition;

import mbse.tutorial.yawl.Arc;


import mbse.tutorial.yawl.YawlPackage;
import yawltest.yawl.graphics.figures.YAWLArcs;
import yawltest.yawl.graphics.figures.YAWLPlace;
import yawltest.yawl.graphics.figures.YAWLTransition;

public class YAWLGraphics extends GraphicalExtension {
	
	
	@Override
	public List<EClass> getExtendedNetTypes() {
		List<EClass> eclass = new ArrayList<EClass>();
		eclass.add(YawlPackage.eINSTANCE.getYAWLNet());
		return eclass;
	}
	@Override
	public List<EClass> getExtendedNetObjects(EClass netType) {
		List<EClass> eclass = new ArrayList<EClass>();
		if(netType.equals(YawlPackage.eINSTANCE.getYAWLNet())){
			eclass.add(YawlPackage.eINSTANCE.getArc());
			eclass.add(YawlPackage.eINSTANCE.getPlace());
			eclass.add(YawlPackage.eINSTANCE.getTransition());
		}
		return eclass;
		
	}
	
	@Override
	public IArcFigure createArcFigure(org.pnml.tools.epnk.pnmlcoremodel.Arc arc){
		
		if(arc instanceof Arc){
			return new YAWLArcs((mbse.tutorial.yawl.Arc) arc);
			
		}
		return null;
		
	}
	@Override
	public IUpdateableFigure createPlaceFigure(org.pnml.tools.epnk.pnmlcoremodel.Place place) {
		
		if(place instanceof Place){
			return new YAWLPlace((mbse.tutorial.yawl.Place) place);
		}
		return null;
		
	}
	
	@Override
	public IUpdateableFigure createTransitionFigure(org.pnml.tools.epnk.pnmlcoremodel.Transition transition) {
		if(transition instanceof Transition){
			return new YAWLTransition((mbse.tutorial.yawl.Transition) transition);
		}
		return null;
		
	}

}
