package view;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public abstract class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JToolBar toolBar = null;
	private JLabel lkabel = null;
	private JTextField counterTextField = null;
	private JButton upButton = null;
	private JButton downButton = null;
	private JToolBar registerToolBar = null;
	private JButton registerButton = null;
	private JButton deregisterButton = null;

	public View() {
		super();
		initialize();
	}

	private void initialize() {
		this.setSize(360, 96);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("View");
		this.switchRegistered(false);
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getToolBar(), BorderLayout.NORTH);
			jContentPane.add(getRegisterToolBar(), BorderLayout.SOUTH);
		}
		return jContentPane;
	}

	private JToolBar getToolBar() {
		if (toolBar == null) {
			lkabel = new JLabel();
			lkabel.setText(" Aktueller Stand: ");
			toolBar = new JToolBar();
			toolBar.add(lkabel);
			toolBar.add(getCounterTextField());
			toolBar.add(getUpButton());
			toolBar.add(getDownButton());
		}
		return toolBar;
	}

	protected JTextField getCounterTextField() {
		if (counterTextField == null) {
			counterTextField = new JTextField();
			counterTextField.setEditable(false);
		}
		return counterTextField;
	}

	private JButton getUpButton() {
		if (upButton == null) {
			upButton = new JButton();
			upButton.setText("Rauf");
			upButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					up_action();
				}
			});
		}
		return upButton;
	}

	protected void up_action() {
		this.up();
	}

	protected abstract void up();
	protected abstract void down();

	private JButton getDownButton() {
		if (downButton == null) {
			downButton = new JButton();
			downButton.setText("Runter");
			downButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					down_action();
				}
			});
		}
		return downButton;
	}

	protected void down_action() {
		this.down();
	}

	private JToolBar getRegisterToolBar() {
		if (registerToolBar == null) {
			registerToolBar = new JToolBar();
			registerToolBar.add(getRegisterButton());
			registerToolBar.add(getDeregisterButton());
		}
		return registerToolBar;
	}

	private JButton getRegisterButton() {
		if (registerButton == null) {
			registerButton = new JButton();
			registerButton.setText("Registrieren");
			registerButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					register_action();
				}
			});
		}
		return registerButton;
	}

	protected void register_action() {
		this.switchRegistered(true);
		this.register();
	}

	protected abstract void register();
	protected abstract void deregister();

	private void switchRegistered(boolean registered) {
		this.getRegisterButton().setEnabled(!registered);
		this.getDeregisterButton().setEnabled(registered);
		this.getUpButton().setEnabled(registered);
		this.getDownButton().setEnabled(registered);
		this.getCounterTextField().setEnabled(registered);
	}

	private JButton getDeregisterButton() {
		if (deregisterButton == null) {
			deregisterButton = new JButton();
			deregisterButton.setText("Deregistrieren");
			deregisterButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					deregister_action();
				}
			});
		}
		return deregisterButton;
	}

	protected void deregister_action() {
		this.switchRegistered(false);
		this.deregister();
	}

	protected void refreshView(int value) {
		this.getCounterTextField().setText(new Integer(value).toString());
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
