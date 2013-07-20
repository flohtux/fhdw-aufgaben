
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class BankService extends model.Service implements PersistentBankService{
    
    
    public static PersistentBankService createBankService(PersistentBank bank) throws PersistenceException{
        return createBankService(bank,false);
    }
    
    public static PersistentBankService createBankService(PersistentBank bank,boolean delayed$Persistence) throws PersistenceException {
        PersistentBankService result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theBankServiceFacade
                .newDelayedBankService();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theBankServiceFacade
                .newBankService(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("bank", bank);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        if(result.getThis().getBank() == null)throw new PersistenceException("Field bank in type BankService has not been initialized!",0);
        return result;
    }
    
    public static PersistentBankService createBankService(PersistentBank bank,boolean delayed$Persistence,PersistentBankService This) throws PersistenceException {
        PersistentBankService result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theBankServiceFacade
                .newDelayedBankService();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theBankServiceFacade
                .newBankService(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("bank", bank);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot bank = (AbstractPersistentRoot)this.getBank();
            if (bank != null) {
                result.put("bank", bank.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    bank.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && bank.hasEssentialFields())bank.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public BankService provideCopy() throws PersistenceException{
        BankService result = this;
        result = new BankService(this.subService, 
                                 this.This, 
                                 this.bank, 
                                 this.getId());
        result.errors = this.errors.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentBank bank;
    
    public BankService(SubjInterface subService,PersistentService This,PersistentBank bank,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((SubjInterface)subService,(PersistentService)This,id);
        this.bank = bank;        
    }
    
    static public long getTypeId() {
        return -119;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == -119) ConnectionHandler.getTheConnectionHandler().theBankServiceFacade
            .newBankService(this.getId());
        super.store();
        if(this.getBank() != null){
            this.getBank().store();
            ConnectionHandler.getTheConnectionHandler().theBankServiceFacade.bankSet(this.getId(), getBank());
        }
        
    }
    
    public PersistentBank getBank() throws PersistenceException {
        return this.bank;
    }
    public void setBank(PersistentBank newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.bank)) return;
        if(getThis().getBank() != null)throw new PersistenceException("Final field bank in type BankService has been set already!",0);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.bank = (PersistentBank)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theBankServiceFacade.bankSet(this.getId(), newValue);
        }
    }
    public PersistentBankService getThis() throws PersistenceException {
        if(this.This == null){
            PersistentBankService result = new BankServiceProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentBankService)this.This;
    }
    
    public void accept(ServiceVisitor visitor) throws PersistenceException {
        visitor.handleBankService(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBankService(this);
    }
    public <E extends UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBankService(this);
    }
    public <R, E extends UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBankService(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleBankService(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBankService(this);
    }
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBankService(this);
    }
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBankService(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleBankService(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBankService(this);
    }
    public <E extends UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBankService(this);
    }
    public <R, E extends UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBankService(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleBankService(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBankService(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBankService(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBankService(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleBankService(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBankService(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBankService(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBankService(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getBank() != null && this.getBank().getTheObject().getLeafInfo() != 0) return 1;
        return 0;
    }
    
    
    public synchronized void deregister(final ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentBankService)This);
		if(this.equals(This)){
			this.setBank((PersistentBank)final$$Fields.get("bank"));
		}
    }
    public synchronized void register(final ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.register(observee);
    }
    public synchronized void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.updateObservers(event);
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void closeAccount(final PersistentAccount acc) 
				throws PersistenceException{
        //TODO: implement method: closeAccount
        
    }
    public void closeAccount(final PersistentAccount acc, final PersistentAccount transAcc) 
				throws PersistenceException{
        //TODO: implement method: closeAccount
        
    }
    public void connected(final String user) 
				throws PersistenceException{
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
    }
    public void createAccount(final String currencyType) 
				throws PersistenceException{
        //TODO: implement method: createAccount
        
    }
    public void disconnected() 
				throws PersistenceException{
    }
    public void initializeOnCreation() 
				throws PersistenceException{
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
