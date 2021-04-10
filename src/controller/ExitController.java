package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ExitPanel;

public class ExitController implements ActionListener
{
	
	private ExitPanel exitPanel;
	
	// CONSTRUCTOR 
	public ExitController(ExitPanel aExitPanel)
	{
		this.exitPanel = aExitPanel;
		this.exitPanel.getOkButton().addActionListener(this);
	
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == this.exitPanel.getOkButton())
		{
	        	System.exit(0);
		}
	}
}
