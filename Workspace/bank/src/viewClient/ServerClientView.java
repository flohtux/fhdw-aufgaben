package viewClient;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;

import view.AccountServiceView;
import view.AdministratorView;
import view.Anything;
import view.BankServiceView;
import view.ModelException;
import view.ServerView;
import view.ServiceView;
import view.UserException;
import view.objects.ViewRoot;
import view.visitor.ServiceVisitor;


@SuppressWarnings("serial")
public class ServerClientView extends JPanel implements ExceptionAndEventHandler{

	ConnectionMaster connection;
	ExceptionAndEventHandler parent;
	
//	private JSplitPane mainSplitPane = null;
	private JPanel treePanel = null;
	private JTreeRefresh navigationTree = null;
	private JScrollPane navigationScrollPane = null;
	private JPanel detailsPanel = null;

	private ServerView service;

	/**
	 * This is the default constructor
	 */
	public ServerClientView(ExceptionAndEventHandler parent, ServerView service) {
		super();
		this.parent = parent;
		this.service = service;
		initialize();
	}
	@SuppressWarnings("unused")
	private ServerView getService(){
		return this.service;
	}
	private void initialize() {
        this.setLayout(new BorderLayout());
        //TODO !PREREQUISITES MultiService: drop: this.add(getMainSplitPane(), BorderLayout.CENTER);
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
//	private JSplitPane getMainSplitPane() {
//		if (mainSplitPane == null) {
//			mainSplitPane = new JSplitPane();
//			mainSplitPane.setDividerLocation(600);
//			mainSplitPane.setRightComponent(getDetailsPanel());
//			mainSplitPane.setLeftComponent(getNavigationSplitPane());
//		}
//		return mainSplitPane;
//	}
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
		if (object == null && this.getConnection() != null) object = this.getConnection().getServerView();
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
	public ServerConnection getConnection(){
        	return (ServerConnection)this.connection;
	}
	/** Is called by the refresher thread if the server object has changed
	**/
	public void handleRefresh(){
		java.awt.EventQueue.invokeLater(new Runnable(){
			public void run(){
				try {
					getNavigationTree().refresh();
					java.util.Vector<?> errors = getConnection().getServerView().getErrors();
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
		//TODO !PREREQUISITES: MultiService: Adjust to the right service
		try {
			ServiceView service = this.getConnection().getServerView().getService();
			if (service != null) {
				service.accept(new ServiceVisitor() {
					public void handleBankService(BankServiceView bank) throws ModelException {
						BankServiceClientView view = new BankServiceClientView(ServerClientView.this, bank);
						ServerClientView.this.add(view, BorderLayout.CENTER);
						bank.connectBankService(ServerClientView.this.getConnection(), view);
					}
					public void handleAdministrator(AdministratorView administrator) throws ModelException {
						AdministratorClientView view = new AdministratorClientView(ServerClientView.this, administrator);
						ServerClientView.this.add(view, BorderLayout.CENTER);
						administrator.connectAdministrator(ServerClientView.this.getConnection(), view);
					}					
					public void handleAccountService(AccountServiceView account) throws ModelException {
						AccountServiceClientView view = new AccountServiceClientView(ServerClientView.this, account);
						ServerClientView.this.add(view, BorderLayout.CENTER);
						account.connectAccountService(ServerClientView.this.getConnection(), view);
					}
				});
			} else {
				this.setVisible(false);
			}
		} catch (ModelException e) {
			this.handleException(e);
		}
		
		java.awt.EventQueue.invokeLater(new Runnable(){
			public void run(){
				getNavigationTree().setModel((TreeModel) getConnection().getServerView());			
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
        return result;
    }
    private JPopupMenu getContextMenu(final ViewRoot selected, final boolean withStaticOperations) {
        JPopupMenu result = new JPopupMenu();        
        this.addNotGeneratedItems(result,selected);
        return result;
    }
    
	/* Menu and wizard section end */
	
	private void addNotGeneratedItems(JPopupMenu result, ViewRoot selected) {
		// TODO Add items if you have not generated service calls!!!
	}
	
}