
package view.objects;

import view.AdministratorView;
import view.BankPxView;
import view.CurrencyManagerView;
import view.ErrorDisplayView;
import view.ModelException;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;
import view.visitor.RemoteExceptionVisitor;
import view.visitor.RemoteReturnExceptionVisitor;
import view.visitor.RemoteReturnVisitor;
import view.visitor.RemoteVisitor;
import view.visitor.ServiceExceptionVisitor;
import view.visitor.ServiceReturnExceptionVisitor;
import view.visitor.ServiceReturnVisitor;
import view.visitor.ServiceVisitor;
import viewClient.AdministratorConnection;
import viewClient.ConnectionIndex;
import viewClient.ConnectionMaster;
import viewClient.ExceptionAndEventHandler;


/* Additional import section end */

public class Administrator extends view.objects.Service implements AdministratorView{
    
    protected CurrencyManagerView currencyManager;
    protected java.util.Vector<BankPxView> banks;
    
    public Administrator(java.util.Vector<ErrorDisplayView> errors,CurrencyManagerView currencyManager,java.util.Vector<BankPxView> banks,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(errors,id, classId);
        this.currencyManager = currencyManager;
        this.banks = banks;        
    }
    
    static public long getTypeId() {
        return -117;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public CurrencyManagerView getCurrencyManager()throws ModelException{
        return this.currencyManager;
    }
    public void setCurrencyManager(CurrencyManagerView newValue) throws ModelException {
        this.currencyManager = newValue;
    }
    public java.util.Vector<BankPxView> getBanks()throws ModelException{
        return this.banks;
    }
    public void setBanks(java.util.Vector<BankPxView> newValue) throws ModelException {
        this.banks = newValue;
    }
    
    public void accept(ServiceVisitor visitor) throws ModelException {
        visitor.handleAdministrator(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAdministrator(this);
    }
    public <E extends UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAdministrator(this);
    }
    public <R, E extends UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAdministrator(this);
    }
    public void accept(RemoteVisitor visitor) throws ModelException {
        visitor.handleAdministrator(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAdministrator(this);
    }
    public <E extends UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAdministrator(this);
    }
    public <R, E extends UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAdministrator(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleAdministrator(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAdministrator(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAdministrator(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAdministrator(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> errors = this.getErrors();
        if (errors != null) {
            ViewObject.resolveVectorProxies(errors, resultTable);
        }
        CurrencyManagerView currencyManager = this.getCurrencyManager();
        if (currencyManager != null) {
            ((ViewProxi)currencyManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(currencyManager.getClassId(), currencyManager.getId())));
        }
        java.util.Vector<?> banks = this.getBanks();
        if (banks != null) {
            ViewObject.resolveVectorProxies(banks, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getCurrencyManager() != null) return new CurrencyManagerAdministratorWrapper(this, originalIndex, (ViewRoot)this.getCurrencyManager());
        if(this.getCurrencyManager() != null) index = index - 1;
        if(index < this.getBanks().size()) return new BanksAdministratorWrapper(this, originalIndex, (ViewRoot)this.getBanks().get(index));
        index = index - this.getBanks().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getCurrencyManager() == null ? 0 : 1)
            + (this.getBanks().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getCurrencyManager() == null ? true : false)
            && (this.getBanks().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getCurrencyManager() != null && this.getCurrencyManager().equals(child)) return result;
        if(this.getCurrencyManager() != null) result = result + 1;
        java.util.Iterator<?> getBanksIterator = this.getBanks().iterator();
        while(getBanksIterator.hasNext()){
            if(getBanksIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    public int getRowCount(){
        return 0 ;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
            } else {
            }
            throw new ModelException("Table index out of bounds!", -1);
        } catch (ModelException e){
            return e.getMessage();
        }
    }
    
    public boolean isRowEditable(int index){
        return true;
    }
    public void setValueAt(String newValue, int rowIndex) throws Exception {
        
    }
    public AdministratorConnection connectAdministrator(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException{
        AdministratorConnection result;
		try {
			result = (AdministratorConnection) new AdministratorConnection(master.getUrlString(), master.getHandler(), master.getReporter()).fork(master, this);
		} catch (java.net.MalformedURLException e) {
			throw new ModelException(e.getMessage(),0);
		}
		result.setHandler(handler);
		ConnectionIndex.getTheConnectionIndex().setConnection(handler,result);
		handler.setConnection(result);
		handler.initializeConnection();
		return result;
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
