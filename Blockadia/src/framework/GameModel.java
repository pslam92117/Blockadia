package framework;

import javax.swing.DefaultComboBoxModel;

import org.jbox2d.common.Vec2;

import components.BlockShape;

/**
 * Model of the Blockadia game
 * 
 * @author alex.yang
 * */
public class GameModel {

	private final DefaultComboBoxModel<ListItem> components = new DefaultComboBoxModel<ListItem>();
	private final Vec2 mouse = new Vec2();
	
	private Config config;
	private double panelWidth;
	private double calculatedFPS;
	
	public GameModel(){	
	}
	
	public Config getCurrGameConfig(){
		return this.config;
	}
	
	public void setCurrGameConfig(final Config config){
		this.config = config;
	}
	
	public Vec2 getMouse(){
		return this.mouse;
	}
	
	public void setMouse(final Vec2 mouse){
		this.mouse.set(mouse);
	}
	
	public double getPanelWidth(){
		return this.panelWidth;
	}
	
	public void setPanelWidth(final double panelWidth){
		this.panelWidth = panelWidth;
	}
	
	public double getCalculatedFPS(){
		return this.calculatedFPS;
	}
	
	public void setCalculatedFPS(final double FPS){
		this.calculatedFPS = FPS;
	}
	
	public DefaultComboBoxModel<ListItem> getComboModel(){
		return this.components;
	}
	public class ListItem{
		public String category;
		public BlockShape component;
		
		public ListItem(final String category){
			this.category = category;
		}
		
		public ListItem(final BlockShape component){
			this.component = component;
		}
		
    public boolean isCategory() {
      return category != null;
    }
    
    @Override
    public String toString() {
      return isCategory() ? category : component.getShapeName();
    }
	}
}
