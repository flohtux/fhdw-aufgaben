package viewClient;

import view.*;
import view.objects.ViewRoot;
import view.visitor.DebitTransferReturnVisitor;
import view.visitor.DebitTransferStateExceptionVisitor;
import view.visitor.DebitTransferStateReturnExceptionVisitor;
import view.visitor.DebitTransferStateReturnVisitor;
import view.visitor.DebitTransferTransactionReturnVisitor;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.tree.DefaultTreeSelectionModel;

import persistence.PersistenceException;
import persistence.PersistentBooleanValue;
import persistence.PersistentDebit;
import persistence.PersistentExecutedState;
import persistence.PersistentNotExecutableState;
import persistence.PersistentNotExecutedState;
import persistence.PersistentNotSuccessfulState;
import persistence.PersistentSuccessfulState;
import persistence.PersistentTemplateState;
import persistence.PersistentTransfer;
import rGType.CharacterValue;
import model.BooleanValue;
import model.Debit;
import model.FalseValue;
import model.TemplateState;
import model.Transfer;
import model.TrueValue;
import model.meta.StringFACTORY;
import model.visitor.DebitTransferStateVisitor;
import common.Fraction;
import expressions.RegularExpressionHandler;


@SuppressWarnings("serial")
public class AccountServiceClientView extends JPanel implements ExceptionAndEventHandler{

	ConnectionMaster connection;
	ExceptionAndEventHandler parent;
	
	private JSplitPane mainSplitPane = null;
	private JPanel treePanel = null;
	private JTreeRefresh navigationTree = null;
	private JScrollPane navigationScrollPane = null;
	private JPanel detailsPanel = null;

	private AccountServiceView service;

	/**
	 * This is the default constructor
	 */
	public AccountServiceClientView(ExceptionAndEventHandler parent, AccountServiceView service) {
		super();
		this.parent = parent;
		this.service = service;
		initialize();
	}
	@SuppressWarnings("unused")
	private AccountServiceView getService(){
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
		if (object == null && this.getConnection() != null) object = this.getConnection().getAccountServiceView();
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
			 public void handleDebit(final DebitView debit) throws ModelException{
				final CustomDebitDetailPanel panel = new CustomDebitDetailPanel(AccountServiceClientView.this, debit);
				debit.getState().accept(new view.visitor.DebitTransferStateStandardVisitor() {
					
						protected void standardHandling(DebitTransferStateView debitTransferState) throws ModelException {
							panel.registerUpdater(CustomDebitDetailPanel.DebitTransfer$$subject, new Updater() {
								public void update(String text) throws ModelException { AccountServiceClientView.this.getConnection().changeSubject(debit, text);}
								public String format(String text) { return text;	}
								public boolean check(String text) throws ModelException { return true;	}
							});
							panel.registerUpdater(CustomDebitDetailPanel.DebitTransfer$$receiverBankNumber, new Updater() {
								public void update(String text) throws ModelException {
									AccountServiceClientView.this.getConnection().changeReceiverBank(debit, Integer.parseInt(text)); }
								public String format(String text) { return text; }
								public boolean check(String text) throws ModelException {
							        try{
							        	Integer.parseInt(text);
							        } catch(NumberFormatException nfe) {
							        	return false;
							        }
							        return true;

								}
							});
							panel.registerUpdater(CustomDebitDetailPanel.DebitTransfer$$receiverAccountNumber, new Updater() {
								public void update(String text) throws ModelException { AccountServiceClientView.this.getConnection().changeReceiverAccount(debit, Integer.parseInt(text));	}
								public String format(String text) { return text; }
								public boolean check(String text) throws ModelException {
							        try{
							        	Integer.parseInt(text);
							        } catch(NumberFormatException nfe) {
							        	return false;
							        }
							        return true;
								}
							}); 
							panel.registerUpdater(CustomDebitDetailPanel.DebitTransfer$$money$$balance, new Updater() {
								public void update(String text) throws ModelException { AccountServiceClientView.this.getConnection().changeMoney(debit, Fraction.parseDec(text));}
								public String format(String text) {
									try{
							        	Fraction frac = Fraction.parseDec(text);
							        	return frac.formatDec(2);
							        } catch(NumberFormatException nfe) {
							        	return text;
							        }
								}
								public boolean check(String text) throws ModelException {
									return new RegularExpressionHandler(viewConstants.TransferConstants.BalanceRegex).check(new CharacterValue(text));
								}
							});
							panel.registerUpdater(CustomDebitDetailPanel.DebitTransfer$$money$$currency, new Updater() {
								public void update(String text) throws ModelException { AccountServiceClientView.this.getConnection().changeCurrency(debit, text); }
								public String format(String text) { return text; }
								public boolean check(String text) throws ModelException {
									try {
										StringFACTORY.createObjectBySubTypeNameForCurrency(text);
										return true;
									} catch (PersistenceException e) {
										return false;
									}
								}
							});
							result = panel;
						};
						
						@Override
						public void handleExecutedState(ExecutedStateView executedState) throws ModelException {
							// no edit possible
						}
						
						@Override
						public void handleSuccessfulState(SuccessfulStateView successfulState) throws ModelException {
							// no edit possible
						}
						
					});

			}
			
			@Override
			public void handleTransfer(final TransferView transfer)
					throws ModelException {
				final CustomTransferDetailPanel panel = new CustomTransferDetailPanel(AccountServiceClientView.this, transfer);
				transfer.getState().accept(new view.visitor.DebitTransferStateStandardVisitor() {
					
						protected void standardHandling(DebitTransferStateView debitTransferState) throws ModelException {
							panel.registerUpdater(CustomTransferDetailPanel.DebitTransfer$$subject, new Updater() {
								public void update(String text) throws ModelException { AccountServiceClientView.this.getConnection().changeSubject(transfer, text);}
								public String format(String text) { return text;	}
								public boolean check(String text) throws ModelException { return true;	}
							});
							panel.registerUpdater(CustomTransferDetailPanel.DebitTransfer$$receiverBankNumber, new Updater() {
								public void update(String text) throws ModelException {
									AccountServiceClientView.this.getConnection().changeReceiverBank(transfer, Integer.parseInt(text)); }
								public String format(String text) { return text; }
								public boolean check(String text) throws ModelException {
							        try{
							        	Integer.parseInt(text);
							        } catch(NumberFormatException nfe) {
							        	return false;
							        }
							        return true;
								}
							});
							panel.registerUpdater(CustomTransferDetailPanel.DebitTransfer$$receiverAccountNumber, new Updater() {
								public void update(String text) throws ModelException { AccountServiceClientView.this.getConnection().changeReceiverAccount(transfer, Integer.parseInt(text));	}
								public String format(String text) { return text; }
								public boolean check(String text) throws ModelException {
							        try{
							        	Integer.parseInt(text);
							        } catch(NumberFormatException nfe) {
							        	return false;
							        }
							        return true;
								}
							}); 
							panel.registerUpdater(CustomTransferDetailPanel.DebitTransfer$$money$$balance, new Updater() {
								public void update(String text) throws ModelException { AccountServiceClientView.this.getConnection().changeMoney(transfer, Fraction.parseDec(text));}
								public String format(String text) {
									try{
							        	Fraction frac = Fraction.parseDec(text);
							        	return frac.formatDec(2);
							        } catch(NumberFormatException nfe) {
							        	return text;
							        }
								}
								public boolean check(String text) throws ModelException {
									return new RegularExpressionHandler(viewConstants.TransferConstants.BalanceRegex).check(new CharacterValue(text));
								}
							});
							panel.registerUpdater(CustomTransferDetailPanel.DebitTransfer$$money$$currency, new Updater() {
								public void update(String text) throws ModelException { AccountServiceClientView.this.getConnection().changeCurrency(transfer, text); }
								public String format(String text) { return text; }
								public boolean check(String text) throws ModelException {
									try {
										StringFACTORY.createObjectBySubTypeNameForCurrency(text);
										return true;
									} catch (PersistenceException e) {
										return false;
									}
								}
							});
							result = panel;
						};
						
						public void handleNotExecutableState(NotExecutableStateView notExecutableState) throws ModelException {
							// no edit possible
						}
						public void handleSuccessfulState(SuccessfulStateView successfulState) throws ModelException {
							// no edit possible
						}
					});
				
					
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
	public AccountServiceConnection getConnection(){
        	return (AccountServiceConnection)this.connection;
	}
	/** Is called by the refresher thread if the server object has changed
	**/
	public void handleRefresh(){
		java.awt.EventQueue.invokeLater(new Runnable(){
			public void run(){
				try {
					getNavigationTree().refresh();
					java.util.Vector<?> errors = getConnection().getAccountServiceView().getErrors();
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
				getNavigationTree().setModel((TreeModel) getConnection().getAccountServiceView());			
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
        currentButton = new javax.swing.JButton("Neue Lastschrift");
        currentButton.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (javax.swing.JOptionPane.showConfirmDialog(getNavigationPanel(), "Neue Lastschrift" + Wizard.ConfirmQuestionMark, "Bestätigen", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null) == javax.swing.JOptionPane.YES_OPTION){
                    try {
                        getConnection().createDebit();
                        getConnection().setEagerRefresh();
                    }catch(ModelException me){
                        handleException(me);
                    }
                }
            }
            
        });result.add(currentButton);
        currentButton = new javax.swing.JButton("Neue Transaktion");
        currentButton.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (javax.swing.JOptionPane.showConfirmDialog(getNavigationPanel(), "Neue Transaktion" + Wizard.ConfirmQuestionMark, "Bestätigen", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null) == javax.swing.JOptionPane.YES_OPTION){
                    try {
                        getConnection().createTransaction();
                        getConnection().setEagerRefresh();
                    }catch(ModelException me){
                        handleException(me);
                    }
                }
            }
            
        });result.add(currentButton);
        currentButton = new javax.swing.JButton("Neue Vorlage ... ");
        currentButton.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e) {
                AccountServiceCreateTemplateDebitTransferTransactionSUBTYPENameMssgWizard wizard = new AccountServiceCreateTemplateDebitTransferTransactionSUBTYPENameMssgWizard("Neue Vorlage");
                wizard.pack();
                wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                wizard.pack();
                wizard.setLocationRelativeTo(getNavigationPanel());
                wizard.setVisible(true);
            }
            
        });result.add(currentButton);
        currentButton = new javax.swing.JButton("Neue Überweisung");
        currentButton.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (javax.swing.JOptionPane.showConfirmDialog(getNavigationPanel(), "Neue Überweisung" + Wizard.ConfirmQuestionMark, "Bestätigen", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null) == javax.swing.JOptionPane.YES_OPTION){
                    try {
                        getConnection().createTransfer();
                        getConnection().setEagerRefresh();
                    }catch(ModelException me){
                        handleException(me);
                    }
                }
            }
            
        });result.add(currentButton);
        currentButton = new javax.swing.JButton("Passwort ändern ... ");
        currentButton.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e) {
                AccountServiceChangePasswordStringStringMssgWizard wizard = new AccountServiceChangePasswordStringStringMssgWizard("Passwort ändern");
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
        item.setText("(S) Neue Lastschrift");
        item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (javax.swing.JOptionPane.showConfirmDialog(getNavigationPanel(), "Neue Lastschrift" + Wizard.ConfirmQuestionMark, "Bestätigen", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null) == javax.swing.JOptionPane.YES_OPTION){
                    try {
                        getConnection().createDebit();
                        getConnection().setEagerRefresh();
                    }catch(ModelException me){
                        handleException(me);
                    }
                }
            }
            
        });
        if (withStaticOperations) result.add(item);
        item = new javax.swing.JMenuItem();
        item.setText("(S) Neue Transaktion");
        item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (javax.swing.JOptionPane.showConfirmDialog(getNavigationPanel(), "Neue Transaktion" + Wizard.ConfirmQuestionMark, "Bestätigen", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null) == javax.swing.JOptionPane.YES_OPTION){
                    try {
                        getConnection().createTransaction();
                        getConnection().setEagerRefresh();
                    }catch(ModelException me){
                        handleException(me);
                    }
                }
            }
            
        });
        if (withStaticOperations) result.add(item);
        item = new javax.swing.JMenuItem();
        item.setText("(S) Neue Vorlage ... ");
        item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                AccountServiceCreateTemplateDebitTransferTransactionSUBTYPENameMssgWizard wizard = new AccountServiceCreateTemplateDebitTransferTransactionSUBTYPENameMssgWizard("Neue Vorlage");
                wizard.pack();
                wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                wizard.pack();
                wizard.setLocationRelativeTo(getNavigationPanel());
                wizard.setVisible(true);
            }
            
        });
        if (withStaticOperations) result.add(item);
        item = new javax.swing.JMenuItem();
        item.setText("(S) Neue Überweisung");
        item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (javax.swing.JOptionPane.showConfirmDialog(getNavigationPanel(), "Neue Überweisung" + Wizard.ConfirmQuestionMark, "Bestätigen", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null) == javax.swing.JOptionPane.YES_OPTION){
                    try {
                        getConnection().createTransfer();
                        getConnection().setEagerRefresh();
                    }catch(ModelException me){
                        handleException(me);
                    }
                }
            }
            
        });
        if (withStaticOperations) result.add(item);
        item = new javax.swing.JMenuItem();
        item.setText("(S) Passwort ändern ... ");
        item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                AccountServiceChangePasswordStringStringMssgWizard wizard = new AccountServiceChangePasswordStringStringMssgWizard("Passwort ändern");
                wizard.pack();
                wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                wizard.pack();
                wizard.setLocationRelativeTo(getNavigationPanel());
                wizard.setVisible(true);
            }
            
        });
        if (withStaticOperations) result.add(item);
        if (selected != null){
            if (selected instanceof TransactionView){
                item = new javax.swing.JMenuItem();
                item.setText("addToTransaction ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        AccountServiceAddToTransactionTransactionDebitTransferMssgWizard wizard = new AccountServiceAddToTransactionTransactionDebitTransferMssgWizard("addToTransaction");
                        wizard.setFirstArgument((TransactionView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof DebitTransferTransactionView){
                if (this.filterUseTemplate((DebitTransferTransactionView) selected)) {
                    item = new javax.swing.JMenuItem();
                    item.setText("Vorlage verwenden");
                    item.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            if (javax.swing.JOptionPane.showConfirmDialog(getNavigationPanel(), "Vorlage verwenden" + Wizard.ConfirmQuestionMark, "Bestätigen", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null) == javax.swing.JOptionPane.YES_OPTION){
                                try {
                                    getConnection().useTemplate((DebitTransferTransactionView)selected);
                                    getConnection().setEagerRefresh();
                                }catch(ModelException me){
                                    handleException(me);
                                }
                            }
                        }
                        
                    });
                    result.add(item);
                }
                if (this.filterExecuteTransfer((DebitTransferTransactionView) selected)) {
                    item = new javax.swing.JMenuItem();
                    item.setText("Überweisung abschicken");
                    item.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            if (javax.swing.JOptionPane.showConfirmDialog(getNavigationPanel(), "Überweisung abschicken" + Wizard.ConfirmQuestionMark, "Bestätigen", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null) == javax.swing.JOptionPane.YES_OPTION){
                                try {
                                    getConnection().executeTransfer((DebitTransferTransactionView)selected);
                                    getConnection().setEagerRefresh();
                                }catch(ModelException me){
                                    handleException(me);
                                }catch (NoPermissionToExecuteDebitTransferException userException){
                                    ReturnValueView view = new ReturnValueView(userException.getMessage(), new java.awt.Dimension(getNavigationScrollPane().getWidth()*8/9,getNavigationScrollPane().getHeight()*8/9));
                                    view.setLocationRelativeTo(getNavigationPanel());
                                    view.setVisible(true);
                                    view.repaint();
                                    getConnection().setEagerRefresh();
                                }catch (ExecuteException userException){
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
                }
            }
            if (selected instanceof DebitGrantListeView){
                item = new javax.swing.JMenuItem();
                item.setText("Neue Erlaubnis erteilen ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        AccountServiceCreateDebitGrantDebitGrantListeIntegerIntegerLimitTypeSUBTYPENameFractionCurrencySUBTYPENameMssgWizard wizard = new AccountServiceCreateDebitGrantDebitGrantListeIntegerIntegerLimitTypeSUBTYPENameFractionCurrencySUBTYPENameMssgWizard("Neue Erlaubnis erteilen");
                        wizard.setFirstArgument((DebitGrantListeView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof DebitTransferView){
                item = new javax.swing.JMenuItem();
                item.setText("Betreff ändern ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        AccountServiceChangeSubjectDebitTransferStringMssgWizard wizard = new AccountServiceChangeSubjectDebitTransferStringMssgWizard("Betreff ändern");
                        wizard.setFirstArgument((DebitTransferView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("Empfänger Bank ändern ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        AccountServiceChangeReceiverBankDebitTransferIntegerMssgWizard wizard = new AccountServiceChangeReceiverBankDebitTransferIntegerMssgWizard("Empfänger Bank ändern");
                        wizard.setFirstArgument((DebitTransferView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("Empfänger Konto ändern ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        AccountServiceChangeReceiverAccountDebitTransferIntegerMssgWizard wizard = new AccountServiceChangeReceiverAccountDebitTransferIntegerMssgWizard("Empfänger Konto ändern");
                        wizard.setFirstArgument((DebitTransferView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("Währung ändern ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        AccountServiceChangeCurrencyDebitTransferCurrencySUBTYPENameMssgWizard wizard = new AccountServiceChangeCurrencyDebitTransferCurrencySUBTYPENameMssgWizard("Währung ändern");
                        wizard.setFirstArgument((DebitTransferView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("Überweisungsbetrag ändern ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        AccountServiceChangeMoneyDebitTransferFractionMssgWizard wizard = new AccountServiceChangeMoneyDebitTransferFractionMssgWizard("Überweisungsbetrag ändern");
                        wizard.setFirstArgument((DebitTransferView)selected);
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
    
	class AccountServiceAddToTransactionTransactionDebitTransferMssgWizard extends Wizard {

		protected AccountServiceAddToTransactionTransactionDebitTransferMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "AccountServiceAddToTransactionTransactionDebitTransferMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().addToTransaction(firstArgument, (DebitTransferView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult());
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
			getParametersPanel().add(new ObjectSelectionPanel("debitTransfer", "view.DebitTransferView", (ViewRoot) getConnection().getAccountServiceView(), this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private TransactionView firstArgument; 
	
		public void setFirstArgument(TransactionView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class AccountServiceChangeCurrencyDebitTransferCurrencySUBTYPENameMssgWizard extends Wizard {

		protected AccountServiceChangeCurrencyDebitTransferCurrencySUBTYPENameMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "AccountServiceChangeCurrencyDebitTransferCurrencySUBTYPENameMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().changeCurrency(firstArgument, ((StringSelectionPanel)getParametersPanel().getComponent(0)).getResult());
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
			getParametersPanel().add(new RegExprSelectionPanel("currency", this, common.RegularExpressionManager.currencySUBTYPEName.getRegExpr()));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private DebitTransferView firstArgument; 
	
		public void setFirstArgument(DebitTransferView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class AccountServiceChangeMoneyDebitTransferFractionMssgWizard extends Wizard {

		protected AccountServiceChangeMoneyDebitTransferFractionMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "AccountServiceChangeMoneyDebitTransferFractionMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().changeMoney(firstArgument, ((FractionSelectionPanel)getParametersPanel().getComponent(0)).getResult());
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
			getParametersPanel().add(new FractionSelectionPanel("newAmount", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private DebitTransferView firstArgument; 
	
		public void setFirstArgument(DebitTransferView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class AccountServiceChangePasswordStringStringMssgWizard extends Wizard {

		protected AccountServiceChangePasswordStringStringMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "AccountServiceChangePasswordStringStringMssgWizard.help";
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

	class AccountServiceChangeReceiverAccountDebitTransferIntegerMssgWizard extends Wizard {

		protected AccountServiceChangeReceiverAccountDebitTransferIntegerMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "AccountServiceChangeReceiverAccountDebitTransferIntegerMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().changeReceiverAccount(firstArgument, ((IntegerSelectionPanel)getParametersPanel().getComponent(0)).getResult().longValue());
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
			getParametersPanel().add(new IntegerSelectionPanel("receiverAccNumber", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private DebitTransferView firstArgument; 
	
		public void setFirstArgument(DebitTransferView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class AccountServiceChangeReceiverBankDebitTransferIntegerMssgWizard extends Wizard {

		protected AccountServiceChangeReceiverBankDebitTransferIntegerMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "AccountServiceChangeReceiverBankDebitTransferIntegerMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().changeReceiverBank(firstArgument, ((IntegerSelectionPanel)getParametersPanel().getComponent(0)).getResult().longValue());
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
			getParametersPanel().add(new IntegerSelectionPanel("receiverBankNumber", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private DebitTransferView firstArgument; 
	
		public void setFirstArgument(DebitTransferView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				SelectionPanel selectionPanel = (SelectionPanel)getParametersPanel().getComponent(0);
				selectionPanel.preset(firstArgument.getReceiverBankNumber());
				if (!selectionPanel.check()) selectionPanel.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class AccountServiceChangeSubjectDebitTransferStringMssgWizard extends Wizard {

		protected AccountServiceChangeSubjectDebitTransferStringMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "AccountServiceChangeSubjectDebitTransferStringMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().changeSubject(firstArgument, ((StringSelectionPanel)getParametersPanel().getComponent(0)).getResult());
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
			getParametersPanel().add(new StringSelectionPanel("subject", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private DebitTransferView firstArgument; 
	
		public void setFirstArgument(DebitTransferView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				SelectionPanel selectionPanel = (SelectionPanel)getParametersPanel().getComponent(0);
				selectionPanel.preset(firstArgument.getSubject());
				if (!selectionPanel.check()) selectionPanel.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class AccountServiceCreateDebitGrantDebitGrantListeIntegerIntegerLimitTypeSUBTYPENameFractionCurrencySUBTYPENameMssgWizard extends Wizard {

		protected AccountServiceCreateDebitGrantDebitGrantListeIntegerIntegerLimitTypeSUBTYPENameFractionCurrencySUBTYPENameMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "AccountServiceCreateDebitGrantDebitGrantListeIntegerIntegerLimitTypeSUBTYPENameFractionCurrencySUBTYPENameMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createDebitGrant(firstArgument, ((IntegerSelectionPanel)getParametersPanel().getComponent(0)).getResult().longValue(),
									((IntegerSelectionPanel)getParametersPanel().getComponent(1)).getResult().longValue(),
									((StringSelectionPanel)getParametersPanel().getComponent(2)).getResult(),
									((FractionSelectionPanel)getParametersPanel().getComponent(3)).getResult(),
									((StringSelectionPanel)getParametersPanel().getComponent(4)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			catch(InvalidBankNumberException e) {
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
			getParametersPanel().add(new IntegerSelectionPanel("receiverBankNumber", this));
			getParametersPanel().add(new IntegerSelectionPanel("receiverAccNumber", this));
			getParametersPanel().add(new RegExprSelectionPanel("limitType", this, common.RegularExpressionManager.limitTypeSUBTYPEName.getRegExpr()));
			getParametersPanel().add(new FractionSelectionPanel("amount", this));
			getParametersPanel().add(new RegExprSelectionPanel("cur", this, common.RegularExpressionManager.currencySUBTYPEName.getRegExpr()));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private DebitGrantListeView firstArgument; 
	
		public void setFirstArgument(DebitGrantListeView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class AccountServiceCreateTemplateDebitTransferTransactionSUBTYPENameMssgWizard extends Wizard {

		protected AccountServiceCreateTemplateDebitTransferTransactionSUBTYPENameMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "AccountServiceCreateTemplateDebitTransferTransactionSUBTYPENameMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createTemplate(((StringSelectionPanel)getParametersPanel().getComponent(0)).getResult());
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
			getParametersPanel().add(new RegExprSelectionPanel("type", this, common.RegularExpressionManager.debitTransferTransactionSUBTYPEName.getRegExpr()));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
	}

	/* Menu and wizard section end */
	
	private void addNotGeneratedItems(JPopupMenu result, ViewRoot selected) {
		// TODO Add items if you have not generated service calls!!!
	}
	
	@SuppressWarnings("serial")
	class CustomTransferDetailPanel extends TransferDefaultDetailPanel {

		protected static final String DebitTransfer$$money$$balance = "DebitTransfer$$money$$balance";
		protected static final String DebitTransfer$$money$$currency = "DebitTransfer$$money$$currency";
		
		protected CustomTransferDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
			super(exceptionHandler, anything);
		}
		
		
		@Override
		protected void addFields() {
			super.addFields();
	        try{
	            BaseTypePanel panel = new RegularExpressionPanel(this, "Betrag", this.getAnything().getMoney().getAmount().getBalance().formatDec(2), new RegularExpressionHandler(viewConstants.TransferConstants.BalanceRegex));
	            this.getScrollablePane().add(panel);
	            this.panels.put(DebitTransfer$$money$$balance, panel);
	        }catch(view.ModelException e){
	            this.getExceptionAndEventhandler().handleException(e);
	        }
	        try{
	            BaseTypePanel panel = new StringPanel(this, "Währung", this.getAnything().getMoney().getCurrency().toString());
	            this.getScrollablePane().add(panel);
	            this.panels.put(DebitTransfer$$money$$currency, panel);
	        }catch(view.ModelException e){
	            this.getExceptionAndEventhandler().handleException(e);
	        }
		}
	}
	
	@SuppressWarnings("serial")
	class CustomDebitDetailPanel extends DebitDefaultDetailPanel {

		protected static final String DebitTransfer$$money$$balance = "DebitTransfer$$money$$balance";
		protected static final String DebitTransfer$$money$$currency = "DebitTransfer$$money$$currency";
		
		protected CustomDebitDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
			super(exceptionHandler, anything);
		}
		
		
		@Override
		protected void addFields() {
			super.addFields();
	        try{
	            BaseTypePanel panel = new FractionPanel(this, "Betrag", this.getAnything().getMoney().getAmount().getBalance());
	            this.getScrollablePane().add(panel);
	            this.panels.put(DebitTransfer$$money$$balance, panel);
	        }catch(view.ModelException e){
	            this.getExceptionAndEventhandler().handleException(e);
	        }
	        try{
	            BaseTypePanel panel = new StringPanel(this, "Währung", this.getAnything().getMoney().getCurrency().toString());
	            this.getScrollablePane().add(panel);
	            this.panels.put(DebitTransfer$$money$$currency, panel);
	        }catch(view.ModelException e){
	            this.getExceptionAndEventhandler().handleException(e);
	        }
		}
	}
	
	private boolean filterExecuteTransfer(DebitTransferTransactionView selected) {
		boolean result = false;
		try {
			result = selected.getState().accept(new DebitTransferStateReturnVisitor<Boolean>() {
				@Override
				public Boolean handleExecutedState(
						ExecutedStateView executedState) throws ModelException {
					return false;
				}

				@Override
				public Boolean handleNotSuccessfulState(
						NotSuccessfulStateView notSuccessfulState)
						throws ModelException {
					return true;
				}

				@Override
				public Boolean handleSuccessfulState(
						SuccessfulStateView successfulState)
						throws ModelException {
					return false;
				}

				@Override
				public Boolean handleNotExecutedState(
						NotExecutedStateView notExecutedState)
						throws ModelException {
					return true;
				}

				@Override
				public Boolean handleTemplateState(
						TemplateStateView templateState) throws ModelException {
					return false;
				}

				@Override
				public Boolean handleNotExecutableState(
						NotExecutableStateView notExecutableState)
						throws ModelException {
					return false;
				}
			});
		} catch (ModelException e) {
			this.handleException(e);
			e.printStackTrace();
		}
		return result;
	}
	private boolean filterUseTemplate(DebitTransferTransactionView selected) {
		boolean result = false;
		try {
			result = selected.getState().accept(new DebitTransferStateReturnVisitor<Boolean>() {

				@Override
				public Boolean handleExecutedState(ExecutedStateView executedState)
						throws ModelException {
					return false;
				}
				@Override
				public Boolean handleNotSuccessfulState(
						NotSuccessfulStateView notSuccessfulState)
						throws ModelException {
					return false;
				}
				@Override
				public Boolean handleSuccessfulState(
						SuccessfulStateView successfulState) throws ModelException {
					return false;
				}
				@Override
				public Boolean handleNotExecutedState(
						NotExecutedStateView notExecutedState)
						throws ModelException {
					return false;
				}
				@Override
				public Boolean handleTemplateState(TemplateStateView templateState)
						throws ModelException {
					return true;
				}
				@Override
				public Boolean handleNotExecutableState(
						NotExecutableStateView notExecutableState)
						throws ModelException {
					return false;
				}
			});
		} catch (ModelException e) {
			this.handleException(e);
			e.printStackTrace();
		}
		return result;
	}
	
	
}
