import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.UIManager;

import view.View;

import model.PartsList;


public class Starter {

	public static void main(String[] args) {
		try {
		  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {
		  e.printStackTrace();
		}
		final View view = View.create(PartsList.create());

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension viewSize = view.getSize();
		double leftMargin = (screenSize.getWidth() - viewSize.getWidth())/2;
		double topMargin = (screenSize.getHeight() - viewSize.getHeight())/2;
		view.setLocation((int)leftMargin,(int)topMargin);
		view.setVisible(true);
	}

}
