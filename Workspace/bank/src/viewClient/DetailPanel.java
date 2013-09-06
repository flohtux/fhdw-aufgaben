package viewClient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Hashtable;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.TitledBorder;

import rGType.CharacterType;

import view.Anything;
import view.ModelException;
import expressions.RegularExpression;
import expressions.RegularExpressionHandler;

@SuppressWarnings("serial")
abstract public class DetailPanel extends JPanel {
		
	public static void setButtonToNeutral(JButton button) {
		button.setBackground(Wizard.Yellow);
		button.setForeground(Wizard.NeutralForeground);
		button.setText(Wizard.NeutralText);
		button.setIcon(Wizard.NeutralIcon);
		button.setEnabled(false);
	}
	public static void setButtonToOK(JButton button) {
		button.setBackground(Wizard.Green);
		button.setForeground(Wizard.OKForeground);
		button.setText(Wizard.OKText);
		button.setIcon(Wizard.OKIcon);
		button.setEnabled(true);
	}
	public static void setButtonToNotOk(JButton button) {
		button.setBackground(Wizard.Red);
		button.setForeground(Wizard.NotOKForeground);
		button.setText(Wizard.NotOKText);
		button.setIcon(Wizard.NotOKIcon);
		button.setEnabled(false);
	}
		
	protected Anything anything;
	private ExceptionAndEventHandler exceptionAndEventHandler;
	
	protected DetailPanel(ExceptionAndEventHandler exceptionHandler){
		super();
		this.exceptionAndEventHandler = exceptionHandler;
	}
	abstract public void setAnything(Anything anything);
	protected Anything getAnything(){
		return this.anything;
	}
	protected ExceptionAndEventHandler getExceptionAndEventhandler(){
		return this.exceptionAndEventHandler;
	}
}

@SuppressWarnings("serial")
abstract class BaseTypePanel extends JPanel {

	public String toString(java.util.Date value, boolean doWithMillies) {
		return  view.objects.ViewRoot.toString(value, doWithMillies);
	}

	static final int Neutral = 0;
	protected static final int OK = 1;
	static final int NotOK = 2;

	private DefaultDetailPanel master;
	
	protected BaseTypePanel(DefaultDetailPanel master, String name, String value){
		this.master = master;
		this.setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));
		this.add(this.getUpdateButton());
		this.add(new JLabel("  "));
		this.add(getLabel());
		getLabel().setText(name);
		this.add(new JLabel(" :  "));
		this.add(getValueTextField());
		this.setValue(value);
		this.setMaximumSize(new Dimension(Wizard.BaseTypePanelStandardWidth,Wizard.BaseTypePanelStandardHeight));
	}
	private JButton updateButton;
	private JButton getUpdateButton() {
		if (this.updateButton == null){
			this.updateButton = new JButton();
			this.updateButton.setText("    ");
			this.setStatus(Neutral);
			this.updateButton.setMargin(new Insets(0,0,0,0));
			this.updateButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if (isUpdatable())update();
				}
			});
		}
		return this.updateButton;
	}
	public String getValue(){
		return this.getValueTextField().getText();
	}
	
	protected void setOK(boolean ok){
		if (ok){
			this.setStatus(OK);
		}else{
			this.setStatus(NotOK);
		}
	}
	private int status = BaseTypePanel.Neutral;
	protected void setStatus(int status) {
		this.status = status;
		if (this.status == Neutral)DetailPanel.setButtonToNeutral(this.getUpdateButton());
		if (this.status == OK)DetailPanel.setButtonToOK(this.getUpdateButton());
		if (this.status == NotOK)DetailPanel.setButtonToNotOk(this.getUpdateButton());
		this.master.check(); 
	}
	protected void setValue(String value){
		this.getValueTextField().setText(value);
		this.getValueTextField().setCaretPosition(0);
	}
	private JTextField valueTextField;
	protected JTextField getValueTextField() {
		if (valueTextField == null){
			this.valueTextField = new JTextField();
			this.valueTextField.setHorizontalAlignment(JTextField.LEFT);
			this.valueTextField.setEditable(false);
			this.valueTextField.addKeyListener(new KeyListener(){
				public void keyPressed(KeyEvent e) {}
				public void keyReleased(KeyEvent e) {
					if (isUpdatable()) {
						try {
							setOK(updater.check(getValue()));
						} catch (view.ModelException me) {
							getValueTextField().setText(me.getMessage());
						}
					}
				}
				public void keyTyped(KeyEvent e) {}
			});
		}
		return this.valueTextField;
	}
	private JLabel nameLabel;
	private Updater updater;
	protected JLabel getLabel() {
		if (nameLabel ==  null){
			nameLabel = new JLabel();
		}
		return nameLabel;
	}
	protected DefaultDetailPanel getMaster(){
		return this.master;
	}
	protected void registerUpdater(Updater updater) {
		this.updater = updater;
		this.setUpdatable();
		this.getValueTextField().setText(updater.format(this.getValueTextField().getText()));
	}
	protected void setUpdatable() {
		this.getValueTextField().setEditable(true);
	}
	protected boolean isUpdatable(){
		return this.updater != null;
	}
	protected boolean isReadyForUpdate(){
		return this.isUpdatable()  && this.getUpdateButton().isEnabled();
	}
	public void updateIfReady() {
		if (this.isReadyForUpdate()) this.update();
	}
	private void update() {
		try {
			updater.update(this.getValue());
			setStatus(Neutral);
		} catch (view.ModelException ex) {
			getValueTextField().setText(ex.getMessage());
			setStatus(NotOK);
		}	
	}
	public int getStatus() {
		return this.status;
	}
}

@SuppressWarnings("serial")
class IntegerPanel extends BaseTypePanel {
	protected IntegerPanel(DefaultDetailPanel master, String name, long value) {
		super(master, name, new Long(value).toString());
	}
}
@SuppressWarnings("serial")
class FractionPanel extends BaseTypePanel {
	protected FractionPanel(DefaultDetailPanel master, String name, common.Fraction value) {
		super(master, name, value.toString());
	}
}

@SuppressWarnings("serial")
class StringPanel extends BaseTypePanel {
	protected StringPanel(DefaultDetailPanel master, String name, String value) {
		super(master, name, value);
	}
}
@SuppressWarnings("serial")
class RegularExpressionPanel extends BaseTypePanel {

	private RegularExpressionHandler handler;

	protected RegularExpressionPanel(DefaultDetailPanel master, String name, String value, RegularExpressionHandler handler) {
		super(master, name, value);
		this.handler = handler;
		this.getValueTextField().addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				if (getValueTextField().isEditable() && e.isAltDown()) getMaster().switchToRegExprView(RegularExpressionPanel.this);
			}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
	}
	protected boolean check() {
		return this.handler.check(new rGType.CharacterValue(this.getValue()));
	}
	public RegularExpression<Character,rGType.CharacterType> getExpression() {
		return handler.getRegExpr();
	}
}

@SuppressWarnings("serial")
class TextPanel extends BaseTypePanel {
	private String value;
	protected TextPanel(DefaultDetailPanel master, String name, String value) {
		super(master, name, value);
		this.value = value;
		this.getValueTextField().addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 || e.isAltDown()) getMaster().switchToTextView(TextPanel.this);
			}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		this.getValueTextField().setToolTipText(Wizard.TextFieldToolTipText);
	}
	public String getValue(){
		return this.value;
	}
	protected void setValue(String value){
		this.value = value;
		boolean tooLong = value.length() > Wizard.TextPreviewLength;
		this.getValueTextField().setText(value.substring(0, tooLong ? Wizard.TextPreviewLength : value.length()) + (tooLong ? ".....":""));
		this.getValueTextField().setCaretPosition(0);
	}
	protected void setUpdatable() {
		getValueTextField().setBackground(Color.WHITE);
	}

}
@SuppressWarnings("serial")
class DatePanel extends BaseTypePanel {
	protected DatePanel(DefaultDetailPanel master, String name, java.util.Date value) {
		super(master, name, "");
		this.getValueTextField().setText(this.toString(value, false));
	}
}
@SuppressWarnings("serial")
class TimestampPanel extends BaseTypePanel {
	protected TimestampPanel(DefaultDetailPanel master, String name, java.util.Date value) {
		super(master, name, "");
		this.getValueTextField().setText(this.toString(value, true));
	}
}
interface CompleteUpdater {
	void update() throws view.ModelException;
}

interface Updater {
	void update(String text) throws view.ModelException;
	String format(String text);
	boolean check(String text) throws view.ModelException;
}
abstract class StandardUpdater implements Updater {
	public String format(String text){
		return text;
	}	
}
abstract class UpdaterForInteger extends StandardUpdater {
	public boolean check(String text) throws view.ModelException{
		try {
			Long.parseLong(text);
			return true;
		}catch (NumberFormatException nfe){
			return false;
		}
	}
}
abstract class UpdaterForString extends StandardUpdater {
	public boolean check(String text) throws view.ModelException{
		return true;
	}
}
abstract class UpdaterForText extends StandardUpdater {
	public boolean check(String text) throws view.ModelException{
		return true;
	}
}
abstract class UpdaterForDate extends StandardUpdater {
	public boolean check(String text) throws view.ModelException{
		try {
			new java.text.SimpleDateFormat(view.objects.ViewRoot.DATEFORMAT).parse(text);
			return true;
		} catch (java.text.ParseException pe){
			return false;
		}
	}
}
abstract class UpdaterForTimeStamp extends StandardUpdater {
	public boolean check(String text) throws view.ModelException{
		try {
			new java.text.SimpleDateFormat(view.objects.ViewRoot.TIMESTAMPFORMAT).parse(text);
			return true;
		} catch (java.text.ParseException pe){
			return false;
		}
	}
}

@SuppressWarnings("serial")
abstract class DefaultDetailPanel extends DetailPanel {

	public static DetailPanel getStandardDetailPanel(Anything object, final ExceptionAndEventHandler handler) throws view.ModelException {
		DetailPanelFactory factory = new DetailPanelFactory(handler);
		object.accept(factory);
		return factory.result;
	}
	
	public void check() {
		boolean somethingUpdatable = false;
		this.setStatus(BaseTypePanel.Neutral);
		java.util.Iterator<BaseTypePanel> panelIterator = this.panels.values().iterator();
		while (panelIterator.hasNext()){
			BaseTypePanel current = panelIterator.next();
			if (current.getStatus() == BaseTypePanel.NotOK){
				this.setStatus(BaseTypePanel.NotOK);
				return;
			}
			if (current.getStatus() == BaseTypePanel.OK){
				somethingUpdatable = true;
			}
		}
		if (somethingUpdatable) this.setStatus(BaseTypePanel.OK);
	}

	Hashtable<String, BaseTypePanel> panels;
	private CompleteUpdater completeUpdater;

	protected DefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
		super(exceptionHandler);
		this.panels = new Hashtable<String, BaseTypePanel>();
		this.setLayout(new BorderLayout());
		this.add(this.getMainPane(),BorderLayout.CENTER);
		this.setAnything(anything);
	}
	
	protected void registerUpdater(String fieldName, Updater updater){
		BaseTypePanel panel = this.panels.get(fieldName);
		if (panel != null) panel.registerUpdater(updater);
	}
	protected void registerCompleteUpdater(CompleteUpdater completeUpdater){
		this.completeUpdater = completeUpdater;
	}
	abstract protected void addFields();
	
	public BaseTypePanel getPanel(String key){
		return this.panels.get(key);
	}
	public void switchBackFromTextView (boolean update){
		this.getMainPane().remove(this.getTextPane());
		this.getMainPane().add(this.getMainScrollPane(),BorderLayout.CENTER);
		if (update){
			this.currentTextPanel.setValue(this.getTextView().getText());
			this.currentTextPanel.setStatus(BaseTypePanel.OK);
		}
		this.getMainPane().invalidate();
		this.getMainScrollPane().invalidate();
		this.updateUI();
	}
	private TextPanel currentTextPanel = null;
	public void switchToTextView (TextPanel panel){
		this.currentTextPanel = panel;
		this.getMainPane().remove(this.getMainScrollPane());
		this.getMainPane().add(this.getTextPane(),BorderLayout.CENTER);
		this.getTextView().setText(panel.getValue());
		this.getTextView().setEditable(currentTextPanel.isUpdatable());
		this.getTextView().setCaretPosition(0);
		this.getTextPaneTitleBorder().setTitle(panel.getLabel().getText());
		this.getMainPane().invalidate();
		this.getTextScrollPane().invalidate();
		this.getTextView().invalidate();
		this.updateUI();
		this.getTextView().grabFocus();
	}
	private RegularExpressionPanel currentRegExpPanel = null;
	public void switchToRegExprView(RegularExpressionPanel panel) {
		this.currentRegExpPanel = panel;
		this.getMainPane().remove(this.getMainScrollPane());
		this.getMainPane().add(this.getRegExprComfortPanel(panel.getExpression(),panel.getLabel().getText(),panel.getValue()),BorderLayout.CENTER);
		this.getMainPane().invalidate();
		this.regExprComfortPanel.invalidate();
		this.updateUI();
		this.currentRegExpPanel.getValueTextField().grabFocus();
	}
	private JPanel regExprComfortPanel = null;
	private JPanel getRegExprComfortPanel(RegularExpression<Character,CharacterType> expression, String name,String value) {
		if (this.regExprComfortPanel == null){
			this.regExprComfortPanel = new JPanel();
			this.regExprComfortPanel.setLayout(new BorderLayout());
			this.regExprComfortPanel.add(this.getRegExprComfortToolBar(), BorderLayout.SOUTH);
		}else{
			this.regExprComfortPanel.remove(this.regExprPane);
		}
		this.regExprComfortPanel.updateUI();
		this.getRegExprPane(expression,name,value);
		this.regExprComfortPanel.add(regExprPane,BorderLayout.CENTER);
		return regExprComfortPanel;
	}
	private JToolBar regExprComfortToolBar = null;
	private JToolBar getRegExprComfortToolBar() {
		if (this.regExprComfortToolBar == null){
			this.regExprComfortToolBar = new JToolBar();
			this.regExprComfortToolBar.add(getRegExpOkButton());
			this.regExprComfortToolBar.add(getRegExpCancelButton());
		}
		return regExprComfortToolBar;
	}
	private JButton regExpOkButton = null;
	private JButton getRegExpOkButton() {
		if (this.regExpOkButton == null){
			this.regExpOkButton = new JButton();
			this.regExpOkButton.setText(Wizard.UpdateButtonText);
			this.regExpOkButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					switchBackFromRegExpView(true);
				}
			});
		}
		return regExpOkButton;
	}
	public void switchBackFromRegExpView (boolean update){
		this.getMainPane().remove(this.regExprComfortPanel);
		this.getMainPane().add(this.getMainScrollPane(),BorderLayout.CENTER);
		if (update){
			String value = this.regExprPane.getRegExprInput().getText();
			this.currentRegExpPanel.setValue(value);
			this.currentRegExpPanel.setOK(this.currentRegExpPanel.check());
		}
		this.getMainPane().invalidate();
		this.getMainScrollPane().invalidate();
		this.updateUI();
	}

	private JButton regExpCancelButton = null;
	private JButton getRegExpCancelButton() {
		if (this.regExpCancelButton == null){
			this.regExpCancelButton = new JButton();
			this.regExpCancelButton.setText(Wizard.CancelButtonText);
			this.regExpCancelButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					switchBackFromRegExpView(false);
				}
			});
		}
		return regExpCancelButton;
	}

	private view.RegExprPanel regExprPane = null;
	private view.RegExprPanel getRegExprPane(RegularExpression<Character,CharacterType> expression, String name, String value) {
		 this.regExprPane = new view.RegExprPanel(expression,name);
		 this.regExprPane.getRegExprInput().setText(value);
		 return regExprPane;
	}

	private JPanel mainPanel = null;
	private JPanel getMainPane() {
		if (mainPanel == null){
			this.mainPanel = new JPanel();
			this.mainPanel.setLayout(new BorderLayout());
			this.mainPanel.add(this.getMainScrollPane(),BorderLayout.CENTER);
		}
		return mainPanel;
	}
	private JPanel mainScrollPane;
	private JPanel getMainScrollPane(){
		if (this.mainScrollPane == null){
			this.mainScrollPane = new JPanel();
			this.mainScrollPane.setLayout(new BorderLayout());
			this.mainScrollPane.add(this.getDetailScrollPane(),BorderLayout.CENTER);
			this.mainScrollPane.add(this.getMajorToolBar(),BorderLayout.SOUTH);
		}
		return this.mainScrollPane;
	}
	private JToolBar majorToolBar;
	private JToolBar getMajorToolBar(){
		if (this.majorToolBar == null){
			this.majorToolBar = new JToolBar();
			this.majorToolBar.add(this.getUpdateAllButton());
		}
		return this.majorToolBar;
	}
	private JButton updateAllButton;
	private JButton getUpdateAllButton(){
		if (this.updateAllButton == null){
			this.updateAllButton = new JButton();
			this.updateAllButton.setText(Wizard.UpdateText);
			this.updateAllButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					updateAll();
				}
			});
			this.setStatus(BaseTypePanel.Neutral);
		}
		return this.updateAllButton;
	}
	protected void updateAll() {
		if (this.hasCompleteUpdater()){
			try {
				this.completeUpdater.update();
				this.resetDetails(true, "");
			} catch (ModelException e) {
				this.resetDetails(false, e.getMessage());
			}
		}
		java.util.Iterator<BaseTypePanel> panelIterator = this.panels.values().iterator();
		while (panelIterator.hasNext()){
			BaseTypePanel current = panelIterator.next();
			current.updateIfReady();	
		}
		this.check();
	}

	private void resetDetails(boolean withoutErrors, String message) {
		java.util.Iterator<BaseTypePanel> panelIterator = this.panels.values().iterator();
		while (panelIterator.hasNext()){
			BaseTypePanel current = panelIterator.next();
			if (current.isReadyForUpdate()){
				if(withoutErrors){
					current.setStatus(BaseTypePanel.Neutral);
				}else {
					current.setValue(message);
					current.setStatus(BaseTypePanel.NotOK);
				}
			}
		}
		this.check();
	}

	private boolean hasCompleteUpdater() {
		return this.completeUpdater != null;
	}

	private void setStatus(int status) {
		if (status == BaseTypePanel.Neutral)DetailPanel.setButtonToNeutral(this.getUpdateAllButton());
		if (status == BaseTypePanel.OK)DetailPanel.setButtonToOK(this.getUpdateAllButton());
		if (status == BaseTypePanel.NotOK)DetailPanel.setButtonToNotOk(this.getUpdateAllButton());
	}


	private JScrollPane detailScrollPane = null;
	private JScrollPane getDetailScrollPane() {
		if (detailScrollPane == null){
			this.detailScrollPane = new JScrollPane();
			this.detailScrollPane.setViewportView(this.getScrollablePane());
		}
		return detailScrollPane;
	}
	private JPanel textPane = null;
	private JPanel getTextPane(){
		if (this.textPane == null){
			this.textPane  = new JPanel();
			this.textPane.setLayout(new BorderLayout());
			this.textPane.setBorder(this.getTextPaneTitleBorder());
			this.textPane.add(this.getTextScrollPane(),BorderLayout.CENTER);
			this.textPane.add(this.getTextToolBar(),BorderLayout.SOUTH);
		}
		return this.textPane;
	}
	private TitledBorder textPaneTitle;
	private TitledBorder getTextPaneTitleBorder(){
		if ( this.textPaneTitle == null){
			this.textPaneTitle = new TitledBorder("");
		}
		return this.textPaneTitle;
	}
	private JToolBar textToolBar;
	private JToolBar getTextToolBar() {
		if (textToolBar == null){
			this.textToolBar = new JToolBar();
			this.textToolBar.add(this.getSwitchBackCancelButton());
			this.textToolBar.add(this.getSwitchBackUpdateButton());
		}
		return this.textToolBar;
	}
	private JButton switchBackUpdateButton;
	private JButton getSwitchBackUpdateButton() {
		if (this.switchBackUpdateButton == null){
			this.switchBackUpdateButton = new JButton();
			this.switchBackUpdateButton.setText(Wizard.UpdateButtonText);
			this.switchBackUpdateButton.setEnabled(false);
			this.switchBackUpdateButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					switchBackFromTextView(true);
				}
			});
		}
		return this.switchBackUpdateButton;
	}
	private JButton switchBackCancelButton;
	private JButton getSwitchBackCancelButton() {
		if (this.switchBackCancelButton == null){
			this.switchBackCancelButton = new JButton();
			this.switchBackCancelButton.setText(Wizard.CancelButtonText);
			this.switchBackCancelButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					switchBackFromTextView(false);
				}
			});
		}
		return this.switchBackCancelButton;
	}

	private JScrollPane textScrollPane;
	private JScrollPane getTextScrollPane() {
		if (this.textScrollPane == null){
			this.textScrollPane = new JScrollPane();
			this.textScrollPane.setViewportView(this.getTextView());
		}
		return this.textScrollPane;
	}

	private JTextArea textView = null;
	private JTextArea getTextView() {
		if (this.textView == null){
			this.textView = new JTextArea();
			this.textView.setLineWrap(true);
			this.textView.setWrapStyleWord(true);
			this.textView.addKeyListener(new KeyListener(){
				public void keyPressed(KeyEvent e) {}
				public void keyReleased(KeyEvent e) {
					getSwitchBackUpdateButton().setEnabled(getTextView().isEditable());
				}
				public void keyTyped(KeyEvent e) {}
			});
		}
		return this.textView;
	}
	private JPanel scrollablePane = null;
	protected JPanel getScrollablePane() {
		if (scrollablePane == null){
			scrollablePane = new JPanel();
			BoxLayout layout = new javax.swing.BoxLayout(
					scrollablePane, javax.swing.BoxLayout.Y_AXIS);
			scrollablePane.setLayout(layout);
		}
		return scrollablePane;
	}
	public void setAnything(Anything anything) {
		this.anything = anything;
		((view.objects.ViewProxi)anything).expand();
		this.addFields();
	}
}


class DetailPanelFactory implements view.visitor.AnythingVisitor {
	protected DefaultDetailPanel result = null;
	private ExceptionAndEventHandler handler;
	public DetailPanelFactory(ExceptionAndEventHandler handler) {
		this.handler = handler;
	}
    public void handleFalseValue(view.FalseValueView object){
        result = new FalseValueDefaultDetailPanel(handler, object);
    }
    public void handleNoRequestState(view.NoRequestStateView object){
        result = new NoRequestStateDefaultDetailPanel(handler, object);
    }
    public void handleCurrencyManager(view.CurrencyManagerView object){
        result = new CurrencyManagerDefaultDetailPanel(handler, object);
    }
    public void handleDebitTransferListe(view.DebitTransferListeView object){
        result = new DebitTransferListeDefaultDetailPanel(handler, object);
    }
    public void handleFixTransactionFee(view.FixTransactionFeeView object){
        result = new FixTransactionFeeDefaultDetailPanel(handler, object);
    }
    public void handleInternalFee(view.InternalFeeView object){
        result = new InternalFeeDefaultDetailPanel(handler, object);
    }
    public void handleDebitTransferDoubleState(view.DebitTransferDoubleStateView object){
        result = new DebitTransferDoubleStateDefaultDetailPanel(handler, object);
    }
    public void handleExecutedState(view.ExecutedStateView object){
        result = new ExecutedStateDefaultDetailPanel(handler, object);
    }
    public void handleTrueValue(view.TrueValueView object){
        result = new TrueValueDefaultDetailPanel(handler, object);
    }
    public void handlePercent(view.PercentView object){
        result = new PercentDefaultDetailPanel(handler, object);
    }
    public void handleNotSuccessfulState(view.NotSuccessfulStateView object){
        result = new NotSuccessfulStateDefaultDetailPanel(handler, object);
    }
    public void handleSuccessfulState(view.SuccessfulStateView object){
        result = new SuccessfulStateDefaultDetailPanel(handler, object);
    }
    public void handleIncomingAccountRule(view.IncomingAccountRuleView object){
        result = new IncomingAccountRuleDefaultDetailPanel(handler, object);
    }
    public void handleAmount(view.AmountView object){
        result = new AmountDefaultDetailPanel(handler, object);
    }
    public void handleNoLimit(view.NoLimitView object){
        result = new NoLimitDefaultDetailPanel(handler, object);
    }
    public void handleAdministrator(view.AdministratorView object){
        result = new AdministratorDefaultDetailPanel(handler, object);
    }
    public void handleBankService(view.BankServiceView object){
        result = new BankServiceDefaultDetailPanel(handler, object);
    }
    public void handleProcentualFee(view.ProcentualFeeView object){
        result = new ProcentualFeeDefaultDetailPanel(handler, object);
    }
    public void handleDebitTransferTemplate(view.DebitTransferTemplateView object){
        result = new DebitTransferTemplateDefaultDetailPanel(handler, object);
    }
    public void handleServer(view.ServerView object){
        result = new ServerDefaultDetailPanel(handler, object);
    }
    public void handleTransfer(view.TransferView object){
        result = new TransferDefaultDetailPanel(handler, object);
    }
    public void handleSubjectRule(view.SubjectRuleView object){
        result = new SubjectRuleDefaultDetailPanel(handler, object);
    }
    public void handleTriggerListe(view.TriggerListeView object){
        result = new TriggerListeDefaultDetailPanel(handler, object);
    }
    public void handleDisabledState(view.DisabledStateView object){
        result = new DisabledStateDefaultDetailPanel(handler, object);
    }
    public void handleDollar(view.DollarView object){
        result = new DollarDefaultDetailPanel(handler, object);
    }
    public void handleEnabledState(view.EnabledStateView object){
        result = new EnabledStateDefaultDetailPanel(handler, object);
    }
    public void handleFranken(view.FrankenView object){
        result = new FrankenDefaultDetailPanel(handler, object);
    }
    public void handleLimitAccount(view.LimitAccountView object){
        result = new LimitAccountDefaultDetailPanel(handler, object);
    }
    public void handleLimit(view.LimitView object){
        result = new LimitDefaultDetailPanel(handler, object);
    }
    public void handleDebit(view.DebitView object){
        result = new DebitDefaultDetailPanel(handler, object);
    }
    public void handleMixedFee(view.MixedFeeView object){
        result = new MixedFeeDefaultDetailPanel(handler, object);
    }
    public void handleDebitGrantListe(view.DebitGrantListeView object){
        result = new DebitGrantListeDefaultDetailPanel(handler, object);
    }
    public void handleRequestState(view.RequestStateView object){
        result = new RequestStateDefaultDetailPanel(handler, object);
    }
    public void handleAccountService(view.AccountServiceView object){
        result = new AccountServiceDefaultDetailPanel(handler, object);
    }
    public void handleAccountPx(view.AccountPxView object){
        result = new AccountPxDefaultDetailPanel(handler, object);
    }
    public void handleAccount(view.AccountView object){
        result = new AccountDefaultDetailPanel(handler, object);
    }
    public void handleNotExecutedState(view.NotExecutedStateView object){
        result = new NotExecutedStateDefaultDetailPanel(handler, object);
    }
    public void handleErrorDisplay(view.ErrorDisplayView object){
        result = new ErrorDisplayDefaultDetailPanel(handler, object);
    }
    public void handleEuro(view.EuroView object){
        result = new EuroDefaultDetailPanel(handler, object);
    }
    public void handleTrigger(view.TriggerView object){
        result = new TriggerDefaultDetailPanel(handler, object);
    }
    public void handleYen(view.YenView object){
        result = new YenDefaultDetailPanel(handler, object);
    }
    public void handleTemplateState(view.TemplateStateView object){
        result = new TemplateStateDefaultDetailPanel(handler, object);
    }
    public void handleDebitTransferNotExecuted(view.DebitTransferNotExecutedView object){
        result = new DebitTransferNotExecutedDefaultDetailPanel(handler, object);
    }
    public void handleNotExecutableState(view.NotExecutableStateView object){
        result = new NotExecutableStateDefaultDetailPanel(handler, object);
    }
    public void handleMoneyRule(view.MoneyRuleView object){
        result = new MoneyRuleDefaultDetailPanel(handler, object);
    }
    public void handleTransaction(view.TransactionView object){
        result = new TransactionDefaultDetailPanel(handler, object);
    }
    public void handleMoney(view.MoneyView object){
        result = new MoneyDefaultDetailPanel(handler, object);
    }
    public void handleBank(view.BankView object){
        result = new BankDefaultDetailPanel(handler, object);
    }
    public void handleDebitTransferSuccessful(view.DebitTransferSuccessfulView object){
        result = new DebitTransferSuccessfulDefaultDetailPanel(handler, object);
    }
    public void handleEventWrapper(view.EventWrapperView object){
        result = new EventWrapperDefaultDetailPanel(handler, object);
    }
    public void handlePfund(view.PfundView object){
        result = new PfundDefaultDetailPanel(handler, object);
    }
    public void handleNotSuccessfulStornoState(view.NotSuccessfulStornoStateView object){
        result = new NotSuccessfulStornoStateDefaultDetailPanel(handler, object);
    }
    public void handleSuccessfulStornoState(view.SuccessfulStornoStateView object){
        result = new SuccessfulStornoStateDefaultDetailPanel(handler, object);
    }
    public void handleDebitGrant(view.DebitGrantView object){
        result = new DebitGrantDefaultDetailPanel(handler, object);
    }
    public void handleBankCreator(view.BankCreatorView object){
        result = new BankCreatorDefaultDetailPanel(handler, object);
    }

}



@SuppressWarnings("serial")
class FalseValueDefaultDetailPanel extends DefaultDetailPanel{
    
    protected FalseValueDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.FalseValueView getAnything(){
        return (view.FalseValueView)this.anything;
    }
}

@SuppressWarnings("serial")
class NoRequestStateDefaultDetailPanel extends DefaultDetailPanel{
    
    protected NoRequestStateDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.NoRequestStateView getAnything(){
        return (view.NoRequestStateView)this.anything;
    }
}

@SuppressWarnings("serial")
class CurrencyManagerDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String CurrencyManager$$exchangeRates = "CurrencyManager$$exchangeRates";
    protected static final String CurrencyManager$$currencyStock = "CurrencyManager$$currencyStock";
    
    protected CurrencyManagerDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.CurrencyManagerView getAnything(){
        return (view.CurrencyManagerView)this.anything;
    }
}

@SuppressWarnings("serial")
class DebitTransferListeDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String DebitTransferListe$$debitTransfers = "DebitTransferListe$$debitTransfers";
    
    protected DebitTransferListeDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.DebitTransferListeView getAnything(){
        return (view.DebitTransferListeView)this.anything;
    }
}

@SuppressWarnings("serial")
class FixTransactionFeeDefaultDetailPanel extends DefaultDetailPanel{
    
    protected FixTransactionFeeDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.FixTransactionFeeView getAnything(){
        return (view.FixTransactionFeeView)this.anything;
    }
}

@SuppressWarnings("serial")
class InternalFeeDefaultDetailPanel extends DefaultDetailPanel{
    
    protected InternalFeeDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.InternalFeeView getAnything(){
        return (view.InternalFeeView)this.anything;
    }
}

@SuppressWarnings("serial")
class DebitTransferDoubleStateDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String DebitTransferDoubleState$$debitTransferStateOld = "DebitTransferDoubleState$$debitTransferStateOld";
    protected static final String DebitTransferDoubleState$$debitTransferStateNew = "DebitTransferDoubleState$$debitTransferStateNew";
    
    protected DebitTransferDoubleStateDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.DebitTransferDoubleStateView getAnything(){
        return (view.DebitTransferDoubleStateView)this.anything;
    }
}

@SuppressWarnings("serial")
class ExecutedStateDefaultDetailPanel extends DefaultDetailPanel{
    
    protected ExecutedStateDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.ExecutedStateView getAnything(){
        return (view.ExecutedStateView)this.anything;
    }
}

@SuppressWarnings("serial")
class TrueValueDefaultDetailPanel extends DefaultDetailPanel{
    
    protected TrueValueDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.TrueValueView getAnything(){
        return (view.TrueValueView)this.anything;
    }
}

@SuppressWarnings("serial")
class PercentDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String Percent$$value = "Percent$$value";
    
    protected PercentDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new FractionPanel(this, "value", this.getAnything().getValue());
            this.getScrollablePane().add(panel);
            this.panels.put(Percent$$value, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.PercentView getAnything(){
        return (view.PercentView)this.anything;
    }
}

@SuppressWarnings("serial")
class NotSuccessfulStateDefaultDetailPanel extends DefaultDetailPanel{
    
    protected NotSuccessfulStateDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.NotSuccessfulStateView getAnything(){
        return (view.NotSuccessfulStateView)this.anything;
    }
}

@SuppressWarnings("serial")
class SuccessfulStateDefaultDetailPanel extends DefaultDetailPanel{
    
    protected SuccessfulStateDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.SuccessfulStateView getAnything(){
        return (view.SuccessfulStateView)this.anything;
    }
}

@SuppressWarnings("serial")
class IncomingAccountRuleDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String IncomingAccountRule$$accountNumber = "IncomingAccountRule$$accountNumber";
    protected static final String IncomingAccountRule$$bankNumber = "IncomingAccountRule$$bankNumber";
    
    protected IncomingAccountRuleDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new IntegerPanel(this, "accountNumber", this.getAnything().getAccountNumber());
            this.getScrollablePane().add(panel);
            this.panels.put(IncomingAccountRule$$accountNumber, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        try{
            BaseTypePanel panel = new IntegerPanel(this, "bankNumber", this.getAnything().getBankNumber());
            this.getScrollablePane().add(panel);
            this.panels.put(IncomingAccountRule$$bankNumber, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.IncomingAccountRuleView getAnything(){
        return (view.IncomingAccountRuleView)this.anything;
    }
}

@SuppressWarnings("serial")
class AmountDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String Amount$$balance = "Amount$$balance";
    
    protected AmountDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new FractionPanel(this, "balance", this.getAnything().getBalance());
            this.getScrollablePane().add(panel);
            this.panels.put(Amount$$balance, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.AmountView getAnything(){
        return (view.AmountView)this.anything;
    }
}

@SuppressWarnings("serial")
class NoLimitDefaultDetailPanel extends DefaultDetailPanel{
    
    protected NoLimitDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.NoLimitView getAnything(){
        return (view.NoLimitView)this.anything;
    }
}

@SuppressWarnings("serial")
class AdministratorDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String Administrator$$currencyManager = "Administrator$$currencyManager";
    protected static final String Administrator$$banks = "Administrator$$banks";
    
    protected AdministratorDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.AdministratorView getAnything(){
        return (view.AdministratorView)this.anything;
    }
}

@SuppressWarnings("serial")
class BankServiceDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String BankService$$bank = "BankService$$bank";
    
    protected BankServiceDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.BankServiceView getAnything(){
        return (view.BankServiceView)this.anything;
    }
}

@SuppressWarnings("serial")
class ProcentualFeeDefaultDetailPanel extends DefaultDetailPanel{
    
    protected ProcentualFeeDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.ProcentualFeeView getAnything(){
        return (view.ProcentualFeeView)this.anything;
    }
}

@SuppressWarnings("serial")
class DebitTransferTemplateDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String DebitTransferTemplate$$templates = "DebitTransferTemplate$$templates";
    
    protected DebitTransferTemplateDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.DebitTransferTemplateView getAnything(){
        return (view.DebitTransferTemplateView)this.anything;
    }
}

@SuppressWarnings("serial")
class ServerDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String Server$$service = "Server$$service";
    protected static final String Server$$user = "Server$$user";
    
    protected ServerDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new StringPanel(this, "user", this.getAnything().getUser());
            this.getScrollablePane().add(panel);
            this.panels.put(Server$$user, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.ServerView getAnything(){
        return (view.ServerView)this.anything;
    }
}

@SuppressWarnings("serial")
class TransferDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String DebitTransferTransaction$$timestamp = "DebitTransferTransaction$$timestamp";
    protected static final String DebitTransferTransaction$$subject = "DebitTransferTransaction$$subject";
    protected static final String DebitTransferTransaction$$state = "DebitTransferTransaction$$state";
    protected static final String DebitTransfer$$receiverAccountNumber = "DebitTransfer$$receiverAccountNumber";
    protected static final String DebitTransfer$$receiverBankNumber = "DebitTransfer$$receiverBankNumber";
    
    protected TransferDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new TimestampPanel(this, "Zeitstempel", this.getAnything().getTimestamp());
            this.getScrollablePane().add(panel);
            this.panels.put(DebitTransferTransaction$$timestamp, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        try{
            BaseTypePanel panel = new StringPanel(this, "Betreff", this.getAnything().getSubject());
            this.getScrollablePane().add(panel);
            this.panels.put(DebitTransferTransaction$$subject, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        try{
            BaseTypePanel panel = new IntegerPanel(this, "Empfänger Konto", this.getAnything().getReceiverAccountNumber());
            this.getScrollablePane().add(panel);
            this.panels.put(DebitTransfer$$receiverAccountNumber, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        try{
            BaseTypePanel panel = new IntegerPanel(this, "Empfänger Bank", this.getAnything().getReceiverBankNumber());
            this.getScrollablePane().add(panel);
            this.panels.put(DebitTransfer$$receiverBankNumber, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.TransferView getAnything(){
        return (view.TransferView)this.anything;
    }
}

@SuppressWarnings("serial")
class SubjectRuleDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String SubjectRule$$subject = "SubjectRule$$subject";
    
    protected SubjectRuleDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new StringPanel(this, "subject", this.getAnything().getSubject());
            this.getScrollablePane().add(panel);
            this.panels.put(SubjectRule$$subject, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.SubjectRuleView getAnything(){
        return (view.SubjectRuleView)this.anything;
    }
}

@SuppressWarnings("serial")
class TriggerListeDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String TriggerListe$$triggers = "TriggerListe$$triggers";
    
    protected TriggerListeDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.TriggerListeView getAnything(){
        return (view.TriggerListeView)this.anything;
    }
}

@SuppressWarnings("serial")
class DisabledStateDefaultDetailPanel extends DefaultDetailPanel{
    
    protected DisabledStateDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.DisabledStateView getAnything(){
        return (view.DisabledStateView)this.anything;
    }
}

@SuppressWarnings("serial")
class DollarDefaultDetailPanel extends DefaultDetailPanel{
    
    protected DollarDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.DollarView getAnything(){
        return (view.DollarView)this.anything;
    }
}

@SuppressWarnings("serial")
class EnabledStateDefaultDetailPanel extends DefaultDetailPanel{
    
    protected EnabledStateDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.EnabledStateView getAnything(){
        return (view.EnabledStateView)this.anything;
    }
}

@SuppressWarnings("serial")
class FrankenDefaultDetailPanel extends DefaultDetailPanel{
    
    protected FrankenDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.FrankenView getAnything(){
        return (view.FrankenView)this.anything;
    }
}

@SuppressWarnings("serial")
class LimitAccountDefaultDetailPanel extends DefaultDetailPanel{
    
    protected LimitAccountDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.LimitAccountView getAnything(){
        return (view.LimitAccountView)this.anything;
    }
}

@SuppressWarnings("serial")
class LimitDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String Limit$$money = "Limit$$money";
    
    protected LimitDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.LimitView getAnything(){
        return (view.LimitView)this.anything;
    }
}

@SuppressWarnings("serial")
class DebitDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String DebitTransferTransaction$$timestamp = "DebitTransferTransaction$$timestamp";
    protected static final String DebitTransferTransaction$$subject = "DebitTransferTransaction$$subject";
    protected static final String DebitTransferTransaction$$state = "DebitTransferTransaction$$state";
    protected static final String DebitTransfer$$receiverAccountNumber = "DebitTransfer$$receiverAccountNumber";
    protected static final String DebitTransfer$$receiverBankNumber = "DebitTransfer$$receiverBankNumber";
    
    protected DebitDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new TimestampPanel(this, "Zeitstempel", this.getAnything().getTimestamp());
            this.getScrollablePane().add(panel);
            this.panels.put(DebitTransferTransaction$$timestamp, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        try{
            BaseTypePanel panel = new StringPanel(this, "Betreff", this.getAnything().getSubject());
            this.getScrollablePane().add(panel);
            this.panels.put(DebitTransferTransaction$$subject, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        try{
            BaseTypePanel panel = new IntegerPanel(this, "Empfänger Konto", this.getAnything().getReceiverAccountNumber());
            this.getScrollablePane().add(panel);
            this.panels.put(DebitTransfer$$receiverAccountNumber, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        try{
            BaseTypePanel panel = new IntegerPanel(this, "Empfänger Bank", this.getAnything().getReceiverBankNumber());
            this.getScrollablePane().add(panel);
            this.panels.put(DebitTransfer$$receiverBankNumber, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.DebitView getAnything(){
        return (view.DebitView)this.anything;
    }
}

@SuppressWarnings("serial")
class MixedFeeDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String MixedFee$$fix = "MixedFee$$fix";
    protected static final String MixedFee$$procentual = "MixedFee$$procentual";
    protected static final String MixedFee$$limit = "MixedFee$$limit";
    
    protected MixedFeeDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.MixedFeeView getAnything(){
        return (view.MixedFeeView)this.anything;
    }
}

@SuppressWarnings("serial")
class DebitGrantListeDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String DebitGrantListe$$debitGrants = "DebitGrantListe$$debitGrants";
    
    protected DebitGrantListeDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.DebitGrantListeView getAnything(){
        return (view.DebitGrantListeView)this.anything;
    }
}

@SuppressWarnings("serial")
class RequestStateDefaultDetailPanel extends DefaultDetailPanel{
    
    protected RequestStateDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.RequestStateView getAnything(){
        return (view.RequestStateView)this.anything;
    }
}

@SuppressWarnings("serial")
class AccountServiceDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String AccountService$$account = "AccountService$$account";
    protected static final String AccountService$$successful = "AccountService$$successful";
    protected static final String AccountService$$notExecuted = "AccountService$$notExecuted";
    protected static final String AccountService$$template = "AccountService$$template";
    
    protected AccountServiceDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.AccountServiceView getAnything(){
        return (view.AccountServiceView)this.anything;
    }
}

@SuppressWarnings("serial")
class AccountPxDefaultDetailPanel extends DefaultDetailPanel{
    
    protected AccountPxDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.AccountPxView getAnything(){
        return (view.AccountPxView)this.anything;
    }
}

@SuppressWarnings("serial")
class AccountDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String Account$$accountNumber = "Account$$accountNumber";
    protected static final String Account$$money = "Account$$money";
    protected static final String Account$$limit = "Account$$limit";
    protected static final String Account$$grantedDebitGrant = "Account$$grantedDebitGrant";
    protected static final String Account$$receivedDebitGrant = "Account$$receivedDebitGrant";
    protected static final String Account$$triggerListe = "Account$$triggerListe";
    
    protected AccountDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new IntegerPanel(this, "Kontonummer", this.getAnything().getAccountNumber());
            this.getScrollablePane().add(panel);
            this.panels.put(Account$$accountNumber, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.AccountView getAnything(){
        return (view.AccountView)this.anything;
    }
}

@SuppressWarnings("serial")
class NotExecutedStateDefaultDetailPanel extends DefaultDetailPanel{
    
    protected NotExecutedStateDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.NotExecutedStateView getAnything(){
        return (view.NotExecutedStateView)this.anything;
    }
}

@SuppressWarnings("serial")
class ErrorDisplayDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String ErrorDisplay$$message = "ErrorDisplay$$message";
    
    protected ErrorDisplayDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new StringPanel(this, "message", this.getAnything().getMessage());
            this.getScrollablePane().add(panel);
            this.panels.put(ErrorDisplay$$message, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.ErrorDisplayView getAnything(){
        return (view.ErrorDisplayView)this.anything;
    }
}

@SuppressWarnings("serial")
class EuroDefaultDetailPanel extends DefaultDetailPanel{
    
    protected EuroDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.EuroView getAnything(){
        return (view.EuroView)this.anything;
    }
}

@SuppressWarnings("serial")
class TriggerDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String Trigger$$name = "Trigger$$name";
    protected static final String Trigger$$state = "Trigger$$state";
    protected static final String Trigger$$action = "Trigger$$action";
    protected static final String Trigger$$rules = "Trigger$$rules";
    
    protected TriggerDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new StringPanel(this, "name", this.getAnything().getName());
            this.getScrollablePane().add(panel);
            this.panels.put(Trigger$$name, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.TriggerView getAnything(){
        return (view.TriggerView)this.anything;
    }
}

@SuppressWarnings("serial")
class YenDefaultDetailPanel extends DefaultDetailPanel{
    
    protected YenDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.YenView getAnything(){
        return (view.YenView)this.anything;
    }
}

@SuppressWarnings("serial")
class TemplateStateDefaultDetailPanel extends DefaultDetailPanel{
    
    protected TemplateStateDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.TemplateStateView getAnything(){
        return (view.TemplateStateView)this.anything;
    }
}

@SuppressWarnings("serial")
class DebitTransferNotExecutedDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String DebitTransferNotExecuted$$notExecuteds = "DebitTransferNotExecuted$$notExecuteds";
    
    protected DebitTransferNotExecutedDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.DebitTransferNotExecutedView getAnything(){
        return (view.DebitTransferNotExecutedView)this.anything;
    }
}

@SuppressWarnings("serial")
class NotExecutableStateDefaultDetailPanel extends DefaultDetailPanel{
    
    protected NotExecutableStateDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.NotExecutableStateView getAnything(){
        return (view.NotExecutableStateView)this.anything;
    }
}

@SuppressWarnings("serial")
class MoneyRuleDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String MoneyRule$$limitAccount = "MoneyRule$$limitAccount";
    
    protected MoneyRuleDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.MoneyRuleView getAnything(){
        return (view.MoneyRuleView)this.anything;
    }
}

@SuppressWarnings("serial")
class TransactionDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String DebitTransferTransaction$$timestamp = "DebitTransferTransaction$$timestamp";
    protected static final String DebitTransferTransaction$$subject = "DebitTransferTransaction$$subject";
    protected static final String DebitTransferTransaction$$state = "DebitTransferTransaction$$state";
    protected static final String Transaction$$debitTransfer = "Transaction$$debitTransfer";
    
    protected TransactionDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new TimestampPanel(this, "Zeitstempel", this.getAnything().getTimestamp());
            this.getScrollablePane().add(panel);
            this.panels.put(DebitTransferTransaction$$timestamp, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        try{
            BaseTypePanel panel = new StringPanel(this, "Betreff", this.getAnything().getSubject());
            this.getScrollablePane().add(panel);
            this.panels.put(DebitTransferTransaction$$subject, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.TransactionView getAnything(){
        return (view.TransactionView)this.anything;
    }
}

@SuppressWarnings("serial")
class MoneyDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String Money$$amount = "Money$$amount";
    protected static final String Money$$currency = "Money$$currency";
    
    protected MoneyDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.MoneyView getAnything(){
        return (view.MoneyView)this.anything;
    }
}

@SuppressWarnings("serial")
class BankDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String Bank$$bankNumber = "Bank$$bankNumber";
    protected static final String Bank$$name = "Bank$$name";
    protected static final String Bank$$fee = "Bank$$fee";
    protected static final String Bank$$internalFee = "Bank$$internalFee";
    protected static final String Bank$$ownAccount = "Bank$$ownAccount";
    protected static final String Bank$$currentAccounts = "Bank$$currentAccounts";
    
    protected BankDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new IntegerPanel(this, "BLZ", this.getAnything().getBankNumber());
            this.getScrollablePane().add(panel);
            this.panels.put(Bank$$bankNumber, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        try{
            BaseTypePanel panel = new StringPanel(this, "Name", this.getAnything().getName());
            this.getScrollablePane().add(panel);
            this.panels.put(Bank$$name, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.BankView getAnything(){
        return (view.BankView)this.anything;
    }
}

@SuppressWarnings("serial")
class DebitTransferSuccessfulDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String DebitTransferSuccessful$$successfuls = "DebitTransferSuccessful$$successfuls";
    
    protected DebitTransferSuccessfulDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.DebitTransferSuccessfulView getAnything(){
        return (view.DebitTransferSuccessfulView)this.anything;
    }
}

@SuppressWarnings("serial")
class EventWrapperDefaultDetailPanel extends DefaultDetailPanel{
    
    protected EventWrapperDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.EventWrapperView getAnything(){
        return (view.EventWrapperView)this.anything;
    }
}

@SuppressWarnings("serial")
class PfundDefaultDetailPanel extends DefaultDetailPanel{
    
    protected PfundDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.PfundView getAnything(){
        return (view.PfundView)this.anything;
    }
}

@SuppressWarnings("serial")
class NotSuccessfulStornoStateDefaultDetailPanel extends DefaultDetailPanel{
    
    protected NotSuccessfulStornoStateDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.NotSuccessfulStornoStateView getAnything(){
        return (view.NotSuccessfulStornoStateView)this.anything;
    }
}

@SuppressWarnings("serial")
class SuccessfulStornoStateDefaultDetailPanel extends DefaultDetailPanel{
    
    protected SuccessfulStornoStateDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.SuccessfulStornoStateView getAnything(){
        return (view.SuccessfulStornoStateView)this.anything;
    }
}

@SuppressWarnings("serial")
class DebitGrantDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String DebitGrant$$permittedAccount = "DebitGrant$$permittedAccount";
    protected static final String DebitGrant$$limits = "DebitGrant$$limits";
    
    protected DebitGrantDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.DebitGrantView getAnything(){
        return (view.DebitGrantView)this.anything;
    }
}

@SuppressWarnings("serial")
class BankCreatorDefaultDetailPanel extends DefaultDetailPanel{
    
    protected BankCreatorDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.BankCreatorView getAnything(){
        return (view.BankCreatorView)this.anything;
    }
}
