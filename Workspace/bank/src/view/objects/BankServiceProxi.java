package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class BankServiceProxi extends ServiceProxi implements BankServiceView{
    
    public BankServiceProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public BankServiceView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> errors_string = (java.util.Vector<String>)resultTable.get("errors");
        java.util.Vector<ErrorDisplayView> errors = ViewProxi.getProxiVector(errors_string, connectionKey);
        ViewProxi bank = null;
        String bank$String = (String)resultTable.get("bank");
        if (bank$String != null) {
            common.ProxiInformation bank$Info = common.RPCConstantsAndServices.createProxiInformation(bank$String);
            bank = view.objects.ViewProxi.createProxi(bank$Info,connectionKey);
            bank.setToString(bank$Info.getToString());
        }
        BankServiceView result$$ = new BankService(errors,(BankView)bank, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
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
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getBank() == null ? true : this.getBank().getTheObject().isLeaf());
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getBank() != null && this.getBank().equals(child)) return result;
        if(this.getBank() != null) result = result + 1;
        return -1;
    }
    
    public BankView getBank()throws ModelException{
        return ((BankService)this.getTheObject()).getBank();
    }
    public void setBank(BankView newValue) throws ModelException {
        ((BankService)this.getTheObject()).setBank(newValue);
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
    }public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
