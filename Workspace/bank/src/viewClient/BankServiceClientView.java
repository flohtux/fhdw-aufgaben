package viewClient;

import view.*;
import view.objects.ViewRoot;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.tree.DefaultTreeSelectionModel;


@SuppressWarnings("serial")
public class BankServiceClientView extends JPanel implements ExceptionAndEventHandler{

	ConnectionMaster connection;
	ExceptionAndEventHandler parent;
	
	private JSplitPane mainSplitPane = null;
	private JPanel treePanel = null;
	private JTreeRefresh navigationTree = null;
	private JScrollPane navigationScrollPane = null;
	private JPanel detailsPanel = null;

	private BankServiceView service;

	/**
	 * This is the default constructor
	 */
	public BankServiceClientView(ExceptionAndEventHandler parent, BankServiceView service) {
		super();
		this.parent = parent;
		this.service = service;
		initialize();
	}
	@SuppressWarnings("unused")
	private BankServiceView getService(){
		return this.service;
	}
	private void initialize() {
        this.setLayout(new BorderLayout());
        this.add(getMainSplitPane(), BorderLayout.CENTER);
        javax.swing.JToolBar mainToolBar = getMainToolBar();
        if (!WithStaticOperations && mainToolBar.getComponentCount() > 0) this.add(mainToolBar, BorderLayout.NORTH);
	}
	private javax.swing.JToolBar mainToolBar = null;
	private javax.swing.JToolBar getMainToolBar() {
		if (this.mainToolBar == null){
			this.mainToolBar = new javax.swing.JToolBar();
			for (javax.swing.JButton current : this.getToolButtonsForStaticOperations()) this.mainToolBar.add(current);
		}
		return this.mainToolBar;
	}
	private JSplitPane getMainSplitPane() {
		if (mainSplitPane == null) {
			mainSplitPane = new JSplitPane();
			mainSplitPane.setDividerLocation(600);
			mainSplitPane.setRightComponent(getDetailsPanel());
			mainSplitPane.setLeftComponent(getNavigationSplitPane());
		}
		return mainSplitPane;
	}
	private JSplitPane navigationSplitPane = null;
	private JSplitPane getNavigationSplitPane(){
		if (this.navigationSplitPane == null){
			this.navigationSplitPane = new JSplitPane();
			navigationSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			navigationSplitPane.setLeftComponent(getNavigationPanel());
			navigationSplitPane.setRightComponent(getErrorPanel());
			navigationSplitPane.setDividerSize(0);
		}
		return this.navigationSplitPane;
	}
	private JPanel errorPanel = null;
	private JPanel getErrorPanel(){
		if (this.errorPanel == null){
			this.errorPanel = new JPanel();
			errorPanel.setBorder(new javax.swing.border.TitledBorder(Wizard.ErrorTitle));
			errorPanel.setLayout(new BorderLayout());
			errorPanel.add(getErrorScrollPane(),BorderLayout.CENTER);
			errorPanel.setVisible(false);
		}
		return this.errorPanel;
	}
	private JScrollPane errorScrollPane = null;
	private JScrollPane getErrorScrollPane(){
		if (this.errorScrollPane == null){
			this.errorScrollPane = new JScrollPane();
			this.errorScrollPane.setViewportView(getErrorJTree());
		}
		return this.errorScrollPane;
	}
	private JTreeRefresh errorJTree = null;
	private JTreeRefresh getErrorJTree(){
		if (this.errorJTree == null){
			this.errorJTree = new JTreeRefresh();
			DefaultTreeSelectionModel selectionModel = new DefaultTreeSelectionModel();
			selectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
			this.errorJTree.setSelectionModel(selectionModel);
			this.errorJTree.addMouseListener(new java.awt.event.MouseAdapter() {   
				public void mouseReleased(MouseEvent e) {    
					tryShowContextMenu(e,errorJTree,false);
				}
				public void mousePressed(MouseEvent e) {
					tryShowContextMenu(e,errorJTree,false);
				}
			});
		}
		return this.errorJTree;
	}
	private void setErrors(TreeModel errors){
		this.getErrorPanel().setVisible(true);
		this.getErrorJTree().setModel(null);
		this.getErrorJTree().setModel(errors);
		this.getNavigationSplitPane().setDividerLocation(550.0/700.0);
		this.getNavigationSplitPane().setDividerSize(5);
	}
	private void setNoErrors(){
		this.getErrorPanel().setVisible(false);
		this.getNavigationSplitPane().setDividerSize(0);
	}
	private JPanel getNavigationPanel() {
		if (treePanel == null) {
			treePanel = new JPanel();
			treePanel.setBorder(new javax.swing.border.TitledBorder(Wizard.NaviationTitle));
			treePanel.setLayout(new BorderLayout());
			treePanel.add(getNavigationScrollPane(), BorderLayout.CENTER);
		}
		return treePanel;
	}
	private JPanel getDetailsPanel() {
		if (detailsPanel == null) {
			detailsPanel = new JPanel();
			detailsPanel.setBorder(new javax.swing.border.TitledBorder(Wizard.DetailsTitle));
			detailsPanel.setLayout(new BorderLayout());
			this.setDetailsTable(null);
		}
		return detailsPanel;
	}
	private JTreeRefresh getNavigationTree() {
		if (navigationTree == null) {
			navigationTree = new JTreeRefresh();
			DefaultTreeSelectionModel selectionModel = new DefaultTreeSelectionModel();
			selectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
			navigationTree.setSelectionModel(selectionModel);
			navigationTree
					.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
						public void valueChanged(javax.swing.event.TreeSelectionEvent e) {
							Anything selected = (Anything) getNavigationTree().getSelectedObject();
							setDetailsTable(selected);
						}
					});
			navigationTree.addMouseListener(new java.awt.event.MouseAdapter() {   
				public void mouseReleased(MouseEvent e) {    
					tryShowContextMenu(e,navigationTree,WithStaticOperations);
				}
				public void mousePressed(MouseEvent e) {
					tryShowContextMenu(e,navigationTree,WithStaticOperations);
				}
			});
		}
		return navigationTree;
	}
	private DetailPanel currentDetails = null;
	protected void setDetailsTable(Anything object) {
		this.getDetailsPanel().setVisible(false);
		if (currentDetails != null) this.getDetailsPanel().remove(currentDetails);
		if (object == null && this.getConnection() != null) object = this.getConnection().getBankServiceView();
		if (object == null){
			this.currentDetails = getNoDetailsPanel();
		}else{
			try {
				this.currentDetails = this.getDetailView(object);
			} catch (ModelException e) {
				this.handleException(e);
				this.currentDetails = null;
			}
			if(this.currentDetails == null) this.currentDetails = getStandardDetailsTable(object);
		}
		this.getDetailsPanel().add(currentDetails,BorderLayout.CENTER);
		this.getDetailsPanel().setVisible(true);
	}

	private DetailPanel getDetailView(final Anything anything) throws ModelException {
		class PanelDecider extends view.visitor.AnythingStandardVisitor {

			private DetailPanel result;
			
			public DetailPanel getResult() {
				return this.result;
			}
			protected void standardHandling(Anything Anything) throws ModelException {
				this.result = null;
			}
			
			@Override
			public void handleMoney(MoneyView money) throws ModelException {
				CustomMoneyDetailPanel panel = new CustomMoneyDetailPanel(BankServiceClientView.this, money);
			}
			//TODO Overwrite all handle methods for the types for which you intend to provide a special panel!
		}
		PanelDecider decider = new PanelDecider();
		anything.accept(decider);
		return decider.getResult();
	}
	private NoDetailPanel noDetailPanel = null;
	public DetailPanel getNoDetailsPanel() {
		if(noDetailPanel == null) noDetailPanel = new NoDetailPanel(this);
		return noDetailPanel;
	}
	protected void tryShowContextMenu(MouseEvent e, JTreeRefresh tree, boolean withStaticOperations) {
		if(e.isPopupTrigger()){
			ViewRoot selected = tree.getSelectedObject();
			JPopupMenu popup = this.getContextMenu(selected, withStaticOperations);
			if(popup.getComponentCount() != 0)popup.show(tree, e.getX(), e.getY());
		}
	}
	private JScrollPane getNavigationScrollPane() {
		if (navigationScrollPane == null) {
			navigationScrollPane = new JScrollPane();
			navigationScrollPane.setViewportView(getNavigationTree());
		}
		return navigationScrollPane;
	}

	private DetailPanel getStandardDetailsTable(Anything object) {
		try {
			return DefaultDetailPanel.getStandardDetailPanel(object,this);
		} catch (ModelException e) {
			this.handleException(e);
			return new NoDetailPanel(this);
		}
	}

	public void setConnection(ConnectionMaster connection){
		this.connection = connection;
	}
	public BankServiceConnection getConnection(){
        	return (BankServiceConnection)this.connection;
	}
	/** Is called by the refresher thread if the server object has changed
	**/
	public void handleRefresh(){
		java.awt.EventQueue.invokeLater(new Runnable(){
			public void run(){
				try {
					getNavigationTree().refresh();
					java.util.Vector<?> errors = getConnection().getBankServiceView().getErrors();
					if (errors.size() >0 )setErrors(new ListRoot(errors));
					else setNoErrors();
				} catch (ModelException e) {
					handleException(e);
				}			
			}
		});
		//TODO adjust implementation: handleRefresh()!
	}
	/** Is called only once after the connection has been established
	**/
	public void initializeConnection(){
		java.awt.EventQueue.invokeLater(new Runnable(){
			public void run(){
				getNavigationTree().setModel((TreeModel) getConnection().getBankServiceView());			
				getNavigationTree().setSelectionPath(new javax.swing.tree.TreePath(getNavigationTree().getModel().getRoot()));
			}
		});
		//TODO adjust implementation: initializeConnection
	}
	public void handleException(ModelException exception) {
		this.parent.handleException(exception);
	}
	public void handleOKMessage(String message) {
		this.parent.handleOKMessage(message);
	}
	public void handleUserException(UserException exception) {
		this.parent.handleUserException(exception);	
	}	
	
	/* Menu and wizard section start */

	static boolean WithStaticOperations = false;


    private java.util.Vector<javax.swing.JButton> getToolButtonsForStaticOperations() {
        java.util.Vector<javax.swing.JButton> result = new java.util.Vector<javax.swing.JButton>();
        javax.swing.JButton currentButton = null;
        currentButton = new javax.swing.JButton("Gebühren ändern ... ");
        currentButton.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e) {
                BankServiceChangeTransactionFeeTransactionFeeSUBTYPENameFractionCurrencySUBTYPENameFractionCurrencySUBTYPENameFractionMssgWizard wizard = new BankServiceChangeTransactionFeeTransactionFeeSUBTYPENameFractionCurrencySUBTYPENameFractionCurrencySUBTYPENameFractionMssgWizard("Gebühren ändern");
                wizard.pack();
                wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                wizard.pack();
                wizard.setLocationRelativeTo(getNavigationPanel());
                wizard.setVisible(true);
            }
            
        });result.add(currentButton);
        currentButton = new javax.swing.JButton("Konto finden ... ");
        currentButton.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e) {
                BankServiceFindAccountIntegerMssgWizard wizard = new BankServiceFindAccountIntegerMssgWizard("Konto finden");
                wizard.pack();
                wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                wizard.pack();
                wizard.setLocationRelativeTo(getNavigationPanel());
                wizard.setVisible(true);
            }
            
        });result.add(currentButton);
        currentButton = new javax.swing.JButton("Neues Konto ... ");
        currentButton.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e) {
                BankServiceCreateAccountCurrencySUBTYPENameMssgWizard wizard = new BankServiceCreateAccountCurrencySUBTYPENameMssgWizard("Neues Konto");
                wizard.pack();
                wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                wizard.pack();
                wizard.setLocationRelativeTo(getNavigationPanel());
                wizard.setVisible(true);
            }
            
        });result.add(currentButton);
        currentButton = new javax.swing.JButton("Passwort ändern ... ");
        currentButton.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e) {
                BankServiceChangePasswordStringStringMssgWizard wizard = new BankServiceChangePasswordStringStringMssgWizard("Passwort ändern");
                wizard.pack();
                wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                wizard.pack();
                wizard.setLocationRelativeTo(getNavigationPanel());
                wizard.setVisible(true);
            }
            
        });result.add(currentButton);
        return result;
    }
    private JPopupMenu getContextMenu(final ViewRoot selected, final boolean withStaticOperations) {
        JPopupMenu result = new JPopupMenu();
        javax.swing.JMenuItem item = null;
        item = new javax.swing.JMenuItem();
        item.setText("(S) Gebühren ändern ... ");
        item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                BankServiceChangeTransactionFeeTransactionFeeSUBTYPENameFractionCurrencySUBTYPENameFractionCurrencySUBTYPENameFractionMssgWizard wizard = new BankServiceChangeTransactionFeeTransactionFeeSUBTYPENameFractionCurrencySUBTYPENameFractionCurrencySUBTYPENameFractionMssgWizard("Gebühren ändern");
                wizard.pack();
                wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                wizard.pack();
                wizard.setLocationRelativeTo(getNavigationPanel());
                wizard.setVisible(true);
            }
            
        });
        if (withStaticOperations) result.add(item);
        item = new javax.swing.JMenuItem();
        item.setText("(S) Konto finden ... ");
        item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                BankServiceFindAccountIntegerMssgWizard wizard = new BankServiceFindAccountIntegerMssgWizard("Konto finden");
                wizard.pack();
                wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                wizard.pack();
                wizard.setLocationRelativeTo(getNavigationPanel());
                wizard.setVisible(true);
            }
            
        });
        if (withStaticOperations) result.add(item);
        item = new javax.swing.JMenuItem();
        item.setText("(S) Neues Konto ... ");
        item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                BankServiceCreateAccountCurrencySUBTYPENameMssgWizard wizard = new BankServiceCreateAccountCurrencySUBTYPENameMssgWizard("Neues Konto");
                wizard.pack();
                wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                wizard.pack();
                wizard.setLocationRelativeTo(getNavigationPanel());
                wizard.setVisible(true);
            }
            
        });
        if (withStaticOperations) result.add(item);
        item = new javax.swing.JMenuItem();
        item.setText("(S) Passwort ändern ... ");
        item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                BankServiceChangePasswordStringStringMssgWizard wizard = new BankServiceChangePasswordStringStringMssgWizard("Passwort ändern");
                wizard.pack();
                wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                wizard.pack();
                wizard.setLocationRelativeTo(getNavigationPanel());
                wizard.setVisible(true);
            }
            
        });
        if (withStaticOperations) result.add(item);
        if (selected != null){
            if (selected instanceof AccountView){
                item = new javax.swing.JMenuItem();
                item.setText("Konto schließen");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        if (javax.swing.JOptionPane.showConfirmDialog(getNavigationPanel(), "Konto schließen" + Wizard.ConfirmQuestionMark, "Bestätigen", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null) == javax.swing.JOptionPane.YES_OPTION){
                            try {
                                getConnection().closeAccount((AccountView)selected);
                                getConnection().setEagerRefresh();
                            }catch(ModelException me){
                                handleException(me);
                            }catch (CloseAccountNoPossibleException userException){
                                ReturnValueView view = new ReturnValueView(userException.getMessage(), new java.awt.Dimension(getNavigationScrollPane().getWidth()*8/9,getNavigationScrollPane().getHeight()*8/9));
                                view.setLocationRelativeTo(getNavigationPanel());
                                view.setVisible(true);
                                view.repaint();
                                getConnection().setEagerRefresh();
                            }
                        }
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("Konto übertragen ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        BankServiceCloseAccountAccountAccountMssgWizard wizard = new BankServiceCloseAccountAccountAccountMssgWizard("Konto übertragen");
                        wizard.setFirstArgument((AccountView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("Obergrenze festlegen ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        BankServiceChangeMaxLimitAccountFractionMssgWizard wizard = new BankServiceChangeMaxLimitAccountFractionMssgWizard("Obergrenze festlegen");
                        wizard.setFirstArgument((AccountView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("Untergrenze festlegen ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        BankServiceChangeMinLimitAccountFractionMssgWizard wizard = new BankServiceChangeMinLimitAccountFractionMssgWizard("Untergrenze festlegen");
                        wizard.setFirstArgument((AccountView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
            }
            
        }
        
        this.addNotGeneratedItems(result,selected);
        return result;
    }
    
	class BankServiceChangeMaxLimitAccountFractionMssgWizard extends Wizard {

		protected BankServiceChangeMaxLimitAccountFractionMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "BankServiceChangeMaxLimitAccountFractionMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().changeMaxLimit(firstArgument, ((FractionSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new FractionSelectionPanel("Obergrenze", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private AccountView firstArgument; 
	
		public void setFirstArgument(AccountView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class BankServiceChangeMinLimitAccountFractionMssgWizard extends Wizard {

		protected BankServiceChangeMinLimitAccountFractionMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "BankServiceChangeMinLimitAccountFractionMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().changeMinLimit(firstArgument, ((FractionSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new FractionSelectionPanel("Untergrenze", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private AccountView firstArgument; 
	
		public void setFirstArgument(AccountView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class BankServiceChangePasswordStringStringMssgWizard extends Wizard {

		protected BankServiceChangePasswordStringStringMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "BankServiceChangePasswordStringStringMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				String result = getConnection().changePassword(((PasswordSelectionPanel)getParametersPanel().getComponent(0)).getResult(),
									((PasswordSelectionPanel)getParametersPanel().getComponent(1)).getResult());
				ReturnValueView view = new ReturnValueView(result, false, new java.awt.Dimension(getNavigationScrollPane().getWidth()*8/9,getNavigationScrollPane().getHeight()*8/9));
				view.setLocationRelativeTo(getNavigationScrollPane());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();
				view.setVisible(true);
				view.repaint();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			catch(PasswordException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new PasswordSelectionPanel("newPassword1", this));
			getParametersPanel().add(new PasswordSelectionPanel("newPassword2", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
	}

	class BankServiceChangeTransactionFeeTransactionFeeSUBTYPENameFractionCurrencySUBTYPENameFractionCurrencySUBTYPENameFractionMssgWizard extends Wizard {

		protected BankServiceChangeTransactionFeeTransactionFeeSUBTYPENameFractionCurrencySUBTYPENameFractionCurrencySUBTYPENameFractionMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "BankServiceChangeTransactionFeeTransactionFeeSUBTYPENameFractionCurrencySUBTYPENameFractionCurrencySUBTYPENameFractionMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().changeTransactionFee(((StringSelectionPanel)getParametersPanel().getComponent(0)).getResult(),
									((FractionSelectionPanel)getParametersPanel().getComponent(1)).getResult(),
									((StringSelectionPanel)getParametersPanel().getComponent(2)).getResult(),
									((FractionSelectionPanel)getParametersPanel().getComponent(3)).getResult(),
									((StringSelectionPanel)getParametersPanel().getComponent(4)).getResult(),
									((FractionSelectionPanel)getParametersPanel().getComponent(5)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new RegExprSelectionPanel("Gebührentyp", this, common.RegularExpressionManager.transactionFeeSUBTYPEName.getRegExpr()));
			getParametersPanel().add(new FractionSelectionPanel("fixe Gebühren", this));
			getParametersPanel().add(new RegExprSelectionPanel("fixCurrency", this, common.RegularExpressionManager.currencySUBTYPEName.getRegExpr()));
			getParametersPanel().add(new FractionSelectionPanel("Grenze", this));
			getParametersPanel().add(new RegExprSelectionPanel("limitCurrency", this, common.RegularExpressionManager.currencySUBTYPEName.getRegExpr()));
			getParametersPanel().add(new FractionSelectionPanel("variable Gebühren", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
	}

	class BankServiceCloseAccountAccountAccountMssgWizard extends Wizard {

		protected BankServiceCloseAccountAccountAccountMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "BankServiceCloseAccountAccountAccountMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().closeAccount(firstArgument, (AccountView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			catch(NoPermissionToExecuteDebitTransferException e) {
				getStatusBar().setText(e.getMessage());
			}
			catch(InvalidBankNumberException e) {
				getStatusBar().setText(e.getMessage());
			}
			catch(LimitViolatedException e) {
				getStatusBar().setText(e.getMessage());
			}
			catch(InvalidAccountNumberException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new ObjectSelectionPanel("transAcc", "view.AccountView", (ViewRoot) getConnection().getBankServiceView(), this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private AccountView firstArgument; 
	
		public void setFirstArgument(AccountView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class BankServiceCreateAccountCurrencySUBTYPENameMssgWizard extends Wizard {

		protected BankServiceCreateAccountCurrencySUBTYPENameMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "BankServiceCreateAccountCurrencySUBTYPENameMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createAccount(((StringSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new RegExprSelectionPanel("Währung", this, common.RegularExpressionManager.currencySUBTYPEName.getRegExpr()));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
	}

	class BankServiceFindAccountIntegerMssgWizard extends Wizard {

		protected BankServiceFindAccountIntegerMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "BankServiceFindAccountIntegerMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().findAccount(((IntegerSelectionPanel)getParametersPanel().getComponent(0)).getResult().longValue());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			catch(UserException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new IntegerSelectionPanel("accountNumber", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
	}

	/* Menu and wizard section end */
	
	private void addNotGeneratedItems(JPopupMenu result, ViewRoot selected) {
		// TODO Add items if you have not generated service calls!!!
	}
	
}