
package model;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.DebitTransferTransactionVisitor;
import model.visitor.SubjInterfaceExceptionVisitor;
import model.visitor.SubjInterfaceReturnExceptionVisitor;
import model.visitor.SubjInterfaceReturnVisitor;
import model.visitor.SubjInterfaceVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.CompensationProxi;
import persistence.Compensation_TransactionsToBeCompensatedProxi;
import persistence.ConnectionHandler;
import persistence.DebitTransferSearchList;
import persistence.Invoker;
import persistence.ObsInterface;
import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentBank;
import persistence.PersistentCompensation;
import persistence.PersistentCompensationPendingRequests;
import persistence.PersistentCompensationRequest;
import persistence.PersistentDebit;
import persistence.PersistentDebitTransferTransaction;
import persistence.PersistentExecuteCompensationCommand;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentTransaction;
import persistence.PersistentTransfer;
import persistence.SubjInterface;
import persistence.TDObserver;


/* Additional import section end */

public class Compensation extends PersistentObject implements PersistentCompensation{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentCompensation getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theCompensationFacade.getClass(objectId);
        return (PersistentCompensation)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentCompensation createCompensation(PersistentAccount requestingAccount) throws PersistenceException{
        return createCompensation(requestingAccount,false);
    }
    
    public static PersistentCompensation createCompensation(PersistentAccount requestingAccount,boolean delayed$Persistence) throws PersistenceException {
        PersistentCompensation result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCompensationFacade
                .newDelayedCompensation();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCompensationFacade
                .newCompensation(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("requestingAccount", requestingAccount);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentCompensation createCompensation(PersistentAccount requestingAccount,boolean delayed$Persistence,PersistentCompensation This) throws PersistenceException {
        PersistentCompensation result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCompensationFacade
                .newDelayedCompensation();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCompensationFacade
                .newCompensation(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("requestingAccount", requestingAccount);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("transactionsToBeCompensated", this.getTransactionsToBeCompensated().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            AbstractPersistentRoot requestingAccount = (AbstractPersistentRoot)this.getRequestingAccount();
            if (requestingAccount != null) {
                result.put("requestingAccount", requestingAccount.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    requestingAccount.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && requestingAccount.hasEssentialFields())requestingAccount.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("pendingRequests", this.getPendingRequests().getObservee().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Compensation provideCopy() throws PersistenceException{
        Compensation result = this;
        result = new Compensation(this.requestingAccount, 
                                  this.pendingRequests, 
                                  this.subService, 
                                  this.This, 
                                  this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected Compensation_TransactionsToBeCompensatedProxi transactionsToBeCompensated;
    protected PersistentAccount requestingAccount;
    protected PersistentCompensationPendingRequests pendingRequests;
    protected SubjInterface subService;
    protected PersistentCompensation This;
    
    public Compensation(PersistentAccount requestingAccount,PersistentCompensationPendingRequests pendingRequests,SubjInterface subService,PersistentCompensation This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.transactionsToBeCompensated = new Compensation_TransactionsToBeCompensatedProxi(this);
        this.requestingAccount = requestingAccount;
        this.pendingRequests = pendingRequests;
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 254;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 254) ConnectionHandler.getTheConnectionHandler().theCompensationFacade
            .newCompensation(this.getId());
        super.store();
        this.getTransactionsToBeCompensated().store();
        if(this.getRequestingAccount() != null){
            this.getRequestingAccount().store();
            ConnectionHandler.getTheConnectionHandler().theCompensationFacade.requestingAccountSet(this.getId(), getRequestingAccount());
        }
        if(this.pendingRequests != null){
            this.pendingRequests.store();
            ConnectionHandler.getTheConnectionHandler().theCompensationFacade.pendingRequestsSet(this.getId(), pendingRequests);
        }
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theCompensationFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theCompensationFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public Compensation_TransactionsToBeCompensatedProxi getTransactionsToBeCompensated() throws PersistenceException {
        return this.transactionsToBeCompensated;
    }
    public PersistentAccount getRequestingAccount() throws PersistenceException {
        return this.requestingAccount;
    }
    public void setRequestingAccount(PersistentAccount newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.requestingAccount)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.requestingAccount = (PersistentAccount)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCompensationFacade.requestingAccountSet(this.getId(), newValue);
        }
    }
    protected void setPendingRequests(PersistentCompensationPendingRequests newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.pendingRequests)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.pendingRequests = (PersistentCompensationPendingRequests)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCompensationFacade.pendingRequestsSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theCompensationFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentCompensation newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentCompensation)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCompensationFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentCompensation getThis() throws PersistenceException {
        if(this.This == null){
            PersistentCompensation result = new CompensationProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentCompensation)this.This;
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleCompensation(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensation(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensation(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensation(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCompensation(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensation(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensation(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensation(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getRequestingAccount() != null) return 1;
        if (this.getPendingRequests().getObservee().getLength() > 0) return 1;
        if (this.getTransactionsToBeCompensated().getLength() > 0) return 1;
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
    public void executeCompensation(final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentExecuteCompensationCommand command = model.meta.ExecuteCompensationCommand.createExecuteCompensationCommand(now, now);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public PersistentCompensationPendingRequests getPendingRequests() 
				throws PersistenceException{
        if (this.pendingRequests == null) {
			this.setPendingRequests(model.CompensationPendingRequests.createCompensationPendingRequests(this.isDelayed$Persistence()));
			this.pendingRequests.setObserver(this);
		}
		return this.pendingRequests;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentCompensation)This);
		if(this.equals(This)){
			this.setRequestingAccount((PersistentAccount)final$$Fields.get("requestingAccount"));
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
    public void executeCompensation() 
				throws PersistenceException{
        //TODO: implement method: executeCompensation
        
    }
    public void initializeDebitTransferTransaction(final PersistentDebitTransferTransaction dtt) 
				throws PersistenceException{
        //TODO: implement method: initializeDebitTransferTransaction
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void pendingRequests_update(final model.meta.CompensationRequestMssgs event) 
				throws PersistenceException{
        //TODO: implement method: pendingRequests_update
        
    }
    public void requestCompensationForDebitTransfers(final DebitTransferSearchList debitTransfers) 
				throws PersistenceException{
        
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
