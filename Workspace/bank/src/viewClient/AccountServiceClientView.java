package viewClient;

import view.*;
import view.objects.ViewRoot;
import view.visitor.BooleanValueReturnVisitor;
import view.visitor.DebitTransferStateReturnVisitor;
import view.visitor.TriggerStateReturnVisitor;

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
import rGType.CharacterValue;
import model.meta.StringFACTORY;
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
							panel.registerUpdater(CustomDebitDetailPanel.DebitTransferTransaction$$subject, new Updater() {
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
							panel.registerUpdater(CustomTransferDetailPanel.DebitTransferTransaction$$subject, new Updater() {
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
						
						public void handleSuccessfulState(SuccessfulStateView successfulState) throws ModelException {
							// no edit possible
						}
					});
				
					
			}
			
			
			@Override
			public void handleMoneyRule(final MoneyRuleView moneyRule) throws ModelException {
				final CustomMoneyRuleDetailPanel panel = new CustomMoneyRuleDetailPanel(AccountServiceClientView.this, moneyRule);
				panel.registerUpdater(CustomMoneyRuleDetailPanel.MoneyRule$$minLimit, new DecimalFractionUpdater() {
					public void update(String text) throws ModelException {
							AccountServiceClientView.this.getConnection().changeMoneyRuleMin(moneyRule, Fraction.parseDec(text));
					}
					@Override
					public boolean check(String text) throws ModelException {
						return super.check(text) && AccountServiceClientView.this.getConnection().checkMoneyRuleMin(moneyRule, Fraction.parseDec(text)).accept(new BooleanValueReturnVisitor<Boolean>() {

							@Override
							public Boolean handleFalseValue(FalseValueView falseValue) throws ModelException {
								return false;
							}

							@Override
							public Boolean handleTrueValue(TrueValueView trueValue) throws ModelException {
								return true;
							}
						});
					}
					});
				panel.registerUpdater(CustomMoneyRuleDetailPanel.MoneyRule$$maxLimit, new DecimalFractionUpdater() {
					public void update(String text) throws ModelException {
							AccountServiceClientView.this.getConnection().changeMoneyRuleMax(moneyRule, Fraction.parseDec(text));
					}
					@Override
					public boolean check(String text) throws ModelException {
						return super.check(text)  && AccountServiceClientView.this.getConnection().checkMoneyRuleMax(moneyRule, Fraction.parseDec(text)).accept(new BooleanValueReturnVisitor<Boolean>() {

							@Override
							public Boolean handleFalseValue(FalseValueView falseValue) throws ModelException {
								return false;
							}

							@Override
							public Boolean handleTrueValue(TrueValueView trueValue) throws ModelException {
								return true;
							}
						});
					}
				});
				
				result = panel;
			}
			
			@Override
			public void handleIncomingAccountRule(final IncomingAccountRuleView incomingAccountRule) throws ModelException {
				final IncomingAccountRuleDefaultDetailPanel panel = new IncomingAccountRuleDefaultDetailPanel(AccountServiceClientView.this, incomingAccountRule);
				panel.registerUpdater(IncomingAccountRuleDefaultDetailPanel.IncomingAccountRule$$accountNumber, new UpdaterForInteger() {
					public void update(String text) throws ModelException {
						AccountServiceClientView.this.getConnection().changeIncomingAccountRuleAccountNumber(incomingAccountRule, Long.parseLong(text));
					}
				});
				panel.registerUpdater(IncomingAccountRuleDefaultDetailPanel.IncomingAccountRule$$bankNumber, new UpdaterForInteger() {
					public void update(String text) throws ModelException {
						AccountServiceClientView.this.getConnection().changeIncomingAccountRuleBankNumber(incomingAccountRule, Long.parseLong(text));
					}});
				result = panel;
			}
			
			@Override
			public void handleSubjectRule(final SubjectRuleView subjectRule) throws ModelException {
				final SubjectRuleDefaultDetailPanel panel = new SubjectRuleDefaultDetailPanel(AccountServiceClientView.this, subjectRule);
				panel.registerUpdater(SubjectRuleDefaultDetailPanel.SubjectRule$$subject, new UpdaterForString() {
					public void update(String text) throws ModelException {
						AccountServiceClientView.this.getConnection().changeSubjectRuleSubject(subjectRule, text);
					}});
				result = panel;
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
        currentButton = new javax.swing.JButton("Neue Folgebuchung ... ");
        currentButton.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e) {
                AccountServiceCreateTriggerStringDebitTransferTransactionSUBTYPENameMssgWizard wizard = new AccountServiceCreateTriggerStringDebitTransferTransactionSUBTYPENameMssgWizard("Neue Folgebuchung");
                wizard.pack();
                wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                wizard.pack();
                wizard.setLocationRelativeTo(getNavigationPanel());
                wizard.setVisible(true);
            }
            
        });result.add(currentButton);
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
        item.setText("(S) Neue Folgebuchung ... ");
        item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                AccountServiceCreateTriggerStringDebitTransferTransactionSUBTYPENameMssgWizard wizard = new AccountServiceCreateTriggerStringDebitTransferTransactionSUBTYPENameMssgWizard("Neue Folgebuchung");
                wizard.pack();
                wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                wizard.pack();
                wizard.setLocationRelativeTo(getNavigationPanel());
                wizard.setVisible(true);
            }
            
        });
        if (withStaticOperations) result.add(item);
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
                if (this.filterRemoveFromTransaction((TransactionView) selected)) {
                    item = new javax.swing.JMenuItem();
                    item.setText("Buchung aus Transaktion entfernen ... ");
                    item.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            AccountServiceRemoveFromTransactionTransactionDebitTransferLSTMssgWizard wizard = new AccountServiceRemoveFromTransactionTransactionDebitTransferLSTMssgWizard("Buchung aus Transaktion entfernen");
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
                if (this.filterAddToTransaction((TransactionView) selected)) {
                    item = new javax.swing.JMenuItem();
                    item.setText("Buchung zu Transaktion hinzufügen ... ");
                    item.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            AccountServiceAddToTransactionTransactionDebitTransferLSTMssgWizard wizard = new AccountServiceAddToTransactionTransactionDebitTransferLSTMssgWizard("Buchung zu Transaktion hinzufügen");
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
                if (this.filterAddToTransactionTemplate((TransactionView) selected)) {
                    item = new javax.swing.JMenuItem();
                    item.setText("Vorlagebuchung zu Transaktion hinzufügen ... ");
                    item.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            AccountServiceAddToTransactionTemplateTransactionDebitTransferLSTMssgWizard wizard = new AccountServiceAddToTransactionTemplateTransactionDebitTransferLSTMssgWizard("Vorlagebuchung zu Transaktion hinzufügen");
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
            if (selected instanceof DebitGrantView){
                item = new javax.swing.JMenuItem();
                item.setText("Erlaubnis entziehen");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        if (javax.swing.JOptionPane.showConfirmDialog(getNavigationPanel(), "Erlaubnis entziehen" + Wizard.ConfirmQuestionMark, "Bestätigen", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null) == javax.swing.JOptionPane.YES_OPTION){
                            try {
                                getConnection().remove((DebitGrantView)selected);
                                getConnection().setEagerRefresh();
                            }catch(ModelException me){
                                handleException(me);
                            }
                        }
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof TriggerView){
                if (this.filterEnable((TriggerView) selected)) {
                    item = new javax.swing.JMenuItem();
                    item.setText("Aktivieren");
                    item.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            if (javax.swing.JOptionPane.showConfirmDialog(getNavigationPanel(), "Aktivieren" + Wizard.ConfirmQuestionMark, "Bestätigen", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null) == javax.swing.JOptionPane.YES_OPTION){
                                try {
                                    getConnection().enable((TriggerView)selected);
                                    getConnection().setEagerRefresh();
                                }catch(ModelException me){
                                    handleException(me);
                                }catch (NoRuleDefinitionException userException){
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
                if (this.filterDisable((TriggerView) selected)) {
                    item = new javax.swing.JMenuItem();
                    item.setText("Deaktivieren");
                    item.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            if (javax.swing.JOptionPane.showConfirmDialog(getNavigationPanel(), "Deaktivieren" + Wizard.ConfirmQuestionMark, "Bestätigen", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null) == javax.swing.JOptionPane.YES_OPTION){
                                try {
                                    getConnection().disable((TriggerView)selected);
                                    getConnection().setEagerRefresh();
                                }catch(ModelException me){
                                    handleException(me);
                                }
                            }
                        }
                        
                    });
                    result.add(item);
                }
                item = new javax.swing.JMenuItem();
                item.setText("Neue Regel erstellen ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        AccountServiceCreateNewRuleTriggerRuleSUBTYPENameMssgWizard wizard = new AccountServiceCreateNewRuleTriggerRuleSUBTYPENameMssgWizard("Neue Regel erstellen");
                        wizard.setFirstArgument((TriggerView)selected);
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
    
	class AccountServiceAddToTransactionTemplateTransactionDebitTransferLSTMssgWizard extends Wizard {

		protected AccountServiceAddToTransactionTemplateTransactionDebitTransferLSTMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "AccountServiceAddToTransactionTemplateTransactionDebitTransferLSTMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().addToTransactionTemplate(firstArgument, (java.util.Vector<DebitTransferView>)((ObjectCollectionSelectionPanel)getParametersPanel().getComponent(0)).getResult());
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
			try{
				getParametersPanel().add(new ObjectCollectionSelectionPanel("debitTransfer", "view.DebitTransferView", new ListRoot(getConnection().debitTransfer_Path_In_AddToTransactionTemplate()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }		
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

	class AccountServiceAddToTransactionTransactionDebitTransferLSTMssgWizard extends Wizard {

		protected AccountServiceAddToTransactionTransactionDebitTransferLSTMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "AccountServiceAddToTransactionTransactionDebitTransferLSTMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().addToTransaction(firstArgument, (java.util.Vector<DebitTransferView>)((ObjectCollectionSelectionPanel)getParametersPanel().getComponent(0)).getResult());
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
			try{
				getParametersPanel().add(new ObjectCollectionSelectionPanel("debitTransfer", "view.DebitTransferView", new ListRoot(getConnection().debitTransfer_Path_In_AddToTransaction()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }		
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
			getParametersPanel().add(new PasswordSelectionPanel("neues Passwort", this));
			getParametersPanel().add(new PasswordSelectionPanel("neues Passwort wiederholen", this));		
		}	
		protected void handleDependencies(int i) {
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
			catch(GrantAlreadyGivenException e) {
				getStatusBar().setText(e.getMessage());
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
			getParametersPanel().add(new IntegerSelectionPanel("Empfänger BLZ", this));
			getParametersPanel().add(new IntegerSelectionPanel("Empfänger Kontonummer", this));
			getParametersPanel().add(new RegExprSelectionPanel("Limit", this, common.RegularExpressionManager.limitTypeSUBTYPEName.getRegExpr()));
			getParametersPanel().add(new FractionSelectionPanel("Betrag", this));
			getParametersPanel().add(new RegExprSelectionPanel("Währung", this, common.RegularExpressionManager.currencySUBTYPEName.getRegExpr()));		
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

	class AccountServiceCreateNewRuleTriggerRuleSUBTYPENameMssgWizard extends Wizard {

		protected AccountServiceCreateNewRuleTriggerRuleSUBTYPENameMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "AccountServiceCreateNewRuleTriggerRuleSUBTYPENameMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createNewRule(firstArgument, ((StringSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			catch(DoubleRuleDefinitionException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new RegExprSelectionPanel("Typ", this, common.RegularExpressionManager.ruleSUBTYPEName.getRegExpr()));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private TriggerView firstArgument; 
	
		public void setFirstArgument(TriggerView firstArgument){
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
			getParametersPanel().add(new RegExprSelectionPanel("Buchungstyp", this, common.RegularExpressionManager.debitTransferTransactionSUBTYPEName.getRegExpr()));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
	}

	class AccountServiceCreateTriggerStringDebitTransferTransactionSUBTYPENameMssgWizard extends Wizard {

		protected AccountServiceCreateTriggerStringDebitTransferTransactionSUBTYPENameMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "AccountServiceCreateTriggerStringDebitTransferTransactionSUBTYPENameMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createTrigger(((StringSelectionPanel)getParametersPanel().getComponent(0)).getResult(),
									((StringSelectionPanel)getParametersPanel().getComponent(1)).getResult());
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
			getParametersPanel().add(new StringSelectionPanel("Name", this));
			getParametersPanel().add(new RegExprSelectionPanel("Typ", this, common.RegularExpressionManager.debitTransferTransactionSUBTYPEName.getRegExpr()));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
	}

	class AccountServiceRemoveFromTransactionTransactionDebitTransferLSTMssgWizard extends Wizard {

		protected AccountServiceRemoveFromTransactionTransactionDebitTransferLSTMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "AccountServiceRemoveFromTransactionTransactionDebitTransferLSTMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().removeFromTransaction(firstArgument, (java.util.Vector<DebitTransferView>)((ObjectCollectionSelectionPanel)getParametersPanel().getComponent(0)).getResult());
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
			getParametersPanel().add(new ObjectCollectionSelectionPanel("debitTransfer", "view.DebitTransferView", null, this)
											{protected ViewRoot getBrowserRoot(){
												{try{
													return new ListRoot(getConnection().debitTransfer_Path_In_RemoveFromTransaction((TransactionView)this.navigationRoot));
												}catch(ModelException me){
													return (ViewRoot) this.navigationRoot;
												}catch(UserException ue){
													return (ViewRoot) this.navigationRoot;
											}}}});		
		}	
		protected void handleDependencies(int i) {
			if(i == 0){
				((ObjectCollectionSelectionPanel)getParametersPanel().getComponent(i)).setBrowserRoot((ViewRoot)firstArgument);
			}
		}
		
		
		private TransactionView firstArgument; 
	
		public void setFirstArgument(TransactionView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
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
	        	BaseTypePanel panel = new PositiveDecimalFractionPanel(this, "Betrag", this.getAnything().getMoney().getAmount().getBalance());
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
	        	BaseTypePanel panel = new PositiveDecimalFractionPanel(this, "Betrag", this.getAnything().getMoney().getAmount().getBalance());
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
	
	class CustomMoneyRuleDetailPanel extends MoneyRuleDefaultDetailPanel {

		protected CustomMoneyRuleDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
			super(exceptionHandler, anything);
		}
		
		@Override
		protected void addFields() {
			super.addFields();
			try {
				BaseTypePanel panel = new PositiveDecimalFractionPanel(CustomMoneyRuleDetailPanel.this, "Minimum", this.getAnything().getMinLimit().getBalance());
				this.getScrollablePane().add(panel);
				this.panels.put(MoneyRule$$minLimit, panel);
			} catch (view.ModelException e) {
				this.getExceptionAndEventhandler().handleException(e);
			}
			
			try {
				BaseTypePanel panel = new PositiveDecimalFractionPanel(CustomMoneyRuleDetailPanel.this, "Maximum", this.getAnything().getMaxLimit().getBalance());
				this.getScrollablePane().add(panel);
				this.panels.put(MoneyRule$$maxLimit, panel);
			} catch (view.ModelException e) {
				this.getExceptionAndEventhandler().handleException(e);
			}
		}
		
	}
	
	class PositiveDecimalFractionPanel extends RegularExpressionPanel {

		protected PositiveDecimalFractionPanel(DefaultDetailPanel master, String name, Fraction value) {
			super(master, name, value.formatDec(2), new RegularExpressionHandler(viewConstants.TransferConstants.BalanceRegex));
		}

		
	}
	
	abstract class DecimalFractionUpdater implements Updater {
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
	
	private boolean filterAddToTransaction(TransactionView selected) {
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
					return true;
				}

				@Override
				public Boolean handleTemplateState(TemplateStateView templateState)
						throws ModelException {
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
	
	private boolean filterAddToTransactionTemplate(TransactionView selected) {
		boolean result  = false;
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
	
    
	private boolean filterRemoveFromTransaction(TransactionView selected) {
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
					return true;
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
					return true;
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
	
	private boolean filterDisable(TriggerView selected) {
		boolean result = false;
		try {
			result = selected.getState().accept(new TriggerStateReturnVisitor<Boolean>() {
				@Override
				public Boolean handleDisabledState(DisabledStateView disabledState) throws ModelException {
					return false;
				}

				@Override
				public Boolean handleEnabledState(EnabledStateView enabledState) throws ModelException {
					return true;
				}
			});
		} catch (ModelException e) {
			this.handleException(e);
			e.printStackTrace();
		}
		return result;
	}
	
    
	private boolean filterEnable(TriggerView selected) {
		return !this.filterDisable(selected);
	}

}
