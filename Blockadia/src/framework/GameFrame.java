package framework;

import interfaces.IGamePanel;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 * The Blockadia frame. Contains all stuff. Make sure you in the GameMain.java call 
 * {@link #setVisible(boolean)} and
 * {@link #setDefaultCloseOperation(int)}.
 * 
 * @author alex.yang
 **/

@SuppressWarnings("serial")
public class GameFrame  extends JFrame {
	
	private GameMenuBar menu;			// Top Menu bar
	private GameInfoBar infoBar;	// Button info bar
	private GameSidePanel side;		// Side panel controls
	private GameModel model;			// Backend (black screen part)
	private GameController controller;	// Main thread

	public GameFrame(final GameModel argModel, final IGamePanel argPanel) {
		super("Blockadia"); 											// Window Name
		setLayout(new BorderLayout());
		
		model = argModel;

		menu = new GameMenuBar();//TODO: rework on the GameMenuBar constructor
		setJMenuBar(menu);												// Top Menu bar
		infoBar = new GameInfoBar();							// Button info/status bar
		add(infoBar,"South"); 										// Position of bar
		
		controller = new GameController(model,argPanel); 
		side = new GameSidePanel(model,controller); // Side panel
		add((Component) argPanel, "Center");			// Game area
		add(new JScrollPane(side),"East"); 				// Position of side panel
		pack();

		//controller.playTest(0);
		//controller.start();
	}

}
