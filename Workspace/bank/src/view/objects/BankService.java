
package view.objects;

import view.BankServiceView;
import view.BankView;
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
import viewClient.BankServiceConnection;
import viewClient.ConnectionIndex;
import viewClient.ConnectionMaster;
import viewClient.ExceptionAndEventHandler;


/* Additional import section end */

public class BankService extends view.objects.Service implements BankServiceView{
    
    protected BankView bank;
    
    public BankService(java.util.Vector<ErrorDisplayView> errors,BankView bank,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(errors,id, classId);
        this.bank = bank;        
    }
    
    static public long getTypeId() {
        return -119;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public BankView getBank()throws ModelException{
        return this.bank;
    }
    public void setBank(BankView newValue) throws ModelException {
        this.bank = newValue;
    }
    
    public void accept(ServiceVisitor visitor) throws ModelException {
        visitor.handleBankService(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleBankService(this);
    }
    public <E extends UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleBankService(this);
    }
    public <R, E extends UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleBankService(this);
    }
    public void accept(RemoteVisitor visitor) throws ModelException {
        visitor.handleBankService(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleBankService(this);
    }
    public <E extends UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleBankService(this);
    }
    public <R, E extends UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleBankService(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleBankService(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleBankService(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleBankService(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleBankService(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> errors = this.getErrors();
        if (errors != null) {
            ViewObject.resolveVectorProxies(errors, resultTable);
        }
        BankView bank = this.getBank();
        if (bank != null) {
            ((ViewProxi)bank).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(bank.getClassId(), bank.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(this.getBank() != null && index < this.getBank().getTheObject().getChildCount())
            return this.getBank().getTheObject().getChild(index);
        if(this.getBank() != null) index = index - this.getBank().getTheObject().getChildCount();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getBank() == null ? 0 : this.getBank().getTheObject().getChildCount());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getBank() == null ? true : this.getBank().getTheObject().isLeaf());
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getBank() != null && this.getBank().equals(child)) return result;
        if(this.getBank() != null) result = result + 1;
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
    public BankServiceConnection connectBankService(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException{
        BankServiceConnection result;
		try {
			result = (BankServiceConnection) new BankServiceConnection(master.getUrlString(), master.getHandler(), master.getReporter()).fork(master, this);
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
