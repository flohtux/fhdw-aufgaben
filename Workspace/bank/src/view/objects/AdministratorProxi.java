package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class AdministratorProxi extends ServiceProxi implements AdministratorView{
    
    public AdministratorProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public AdministratorView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> errors_string = (java.util.Vector<String>)resultTable.get("errors");
        java.util.Vector<ErrorDisplayView> errors = ViewProxi.getProxiVector(errors_string, connectionKey);
        ViewProxi currencyManager = null;
        String currencyManager$String = (String)resultTable.get("currencyManager");
        if (currencyManager$String != null) {
            common.ProxiInformation currencyManager$Info = common.RPCConstantsAndServices.createProxiInformation(currencyManager$String);
            currencyManager = view.objects.ViewProxi.createProxi(currencyManager$Info,connectionKey);
            currencyManager.setToString(currencyManager$Info.getToString());
        }
        java.util.Vector<String> banks_string = (java.util.Vector<String>)resultTable.get("banks");
        java.util.Vector<BankView> banks = ViewProxi.getProxiVector(banks_string, connectionKey);
        AdministratorView result$$ = new Administrator(errors,(CurrencyManagerView)currencyManager,banks, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
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
        if (this.object == null) return this.getLeafInfo() == 0;
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
    
    public CurrencyManagerView getCurrencyManager()throws ModelException{
        return ((Administrator)this.getTheObject()).getCurrencyManager();
    }
    public void setCurrencyManager(CurrencyManagerView newValue) throws ModelException {
        ((Administrator)this.getTheObject()).setCurrencyManager(newValue);
    }
    public java.util.Vector<BankView> getBanks()throws ModelException{
        return ((Administrator)this.getTheObject()).getBanks();
    }
    public void setBanks(java.util.Vector<BankView> newValue) throws ModelException {
        ((Administrator)this.getTheObject()).setBanks(newValue);
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
