
package model;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.SubjInterfaceExceptionVisitor;
import model.visitor.SubjInterfaceReturnExceptionVisitor;
import model.visitor.SubjInterfaceReturnVisitor;
import model.visitor.SubjInterfaceVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.CompensationRequestProxi;
import persistence.ConnectionHandler;
import persistence.ObsInterface;
import persistence.PersistenceException;
import persistence.PersistentCompensationRequest;
import persistence.PersistentDebitTransferTransaction;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.SubjInterface;
import persistence.TDObserver;


/* Additional import section end */

public class CompensationRequest extends PersistentObject implements PersistentCompensationRequest{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentCompensationRequest getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theCompensationRequestFacade.getClass(objectId);
        return (PersistentCompensationRequest)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentCompensationRequest createCompensationRequest() throws PersistenceException{
        return createCompensationRequest(false);
    }
    
    public static PersistentCompensationRequest createCompensationRequest(boolean delayed$Persistence) throws PersistenceException {
        PersistentCompensationRequest result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCompensationRequestFacade
                .newDelayedCompensationRequest();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCompensationRequestFacade
                .newCompensationRequest(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentCompensationRequest createCompensationRequest(boolean delayed$Persistence,PersistentCompensationRequest This) throws PersistenceException {
        PersistentCompensationRequest result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCompensationRequestFacade
                .newDelayedCompensationRequest();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCompensationRequestFacade
                .newCompensationRequest(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot debitTransferTransaction = (AbstractPersistentRoot)this.getDebitTransferTransaction();
            if (debitTransferTransaction != null) {
                result.put("debitTransferTransaction", debitTransferTransaction.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    debitTransferTransaction.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && debitTransferTransaction.hasEssentialFields())debitTransferTransaction.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public CompensationRequest provideCopy() throws PersistenceException{
        CompensationRequest result = this;
        result = new CompensationRequest(this.debitTransferTransaction, 
                                         this.subService, 
                                         this.This, 
                                         this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentDebitTransferTransaction debitTransferTransaction;
    protected SubjInterface subService;
    protected PersistentCompensationRequest This;
    
    public CompensationRequest(PersistentDebitTransferTransaction debitTransferTransaction,SubjInterface subService,PersistentCompensationRequest This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.debitTransferTransaction = debitTransferTransaction;
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 256;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 256) ConnectionHandler.getTheConnectionHandler().theCompensationRequestFacade
            .newCompensationRequest(this.getId());
        super.store();
        if(this.getDebitTransferTransaction() != null){
            this.getDebitTransferTransaction().store();
            ConnectionHandler.getTheConnectionHandler().theCompensationRequestFacade.debitTransferTransactionSet(this.getId(), getDebitTransferTransaction());
        }
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theCompensationRequestFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theCompensationRequestFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentDebitTransferTransaction getDebitTransferTransaction() throws PersistenceException {
        return this.debitTransferTransaction;
    }
    public void setDebitTransferTransaction(PersistentDebitTransferTransaction newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.debitTransferTransaction)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.debitTransferTransaction = (PersistentDebitTransferTransaction)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCompensationRequestFacade.debitTransferTransactionSet(this.getId(), newValue);
        }
    }
    public SubjInterface getSubService() throws PersistenceException {
        return this.subService;
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.subService)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.subService = (SubjInterface)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCompensationRequestFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentCompensationRequest newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentCompensationRequest)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCompensationRequestFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentCompensationRequest getThis() throws PersistenceException {
        if(this.This == null){
            PersistentCompensationRequest result = new CompensationRequestProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentCompensationRequest)this.This;
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleCompensationRequest(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensationRequest(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensationRequest(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensationRequest(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCompensationRequest(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensationRequest(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensationRequest(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensationRequest(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getDebitTransferTransaction() != null) return 1;
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
        this.setThis((PersistentCompensationRequest)This);
		if(this.equals(This)){
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
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}