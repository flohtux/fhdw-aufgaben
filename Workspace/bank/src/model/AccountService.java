
package model;

import persistence.*;
import model.meta.DebitTransferMssgsVisitor;
import model.meta.DebitTransferTransactionExecuteMssg;
import model.meta.StringFACTORY;
import model.visitor.*;


/* Additional import section end */

public class AccountService extends model.Service implements PersistentAccountService{
    
    
    public static PersistentAccountService createAccountService(PersistentAccount account) throws PersistenceException{
        return createAccountService(account,false);
    }
    
    public static PersistentAccountService createAccountService(PersistentAccount account,boolean delayed$Persistence) throws PersistenceException {
        PersistentAccountService result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountServiceFacade
                .newDelayedAccountService();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountServiceFacade
                .newAccountService(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("account", account);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        if(result.getThis().getAccount() == null)throw new PersistenceException("Field account in type AccountService has not been initialized!",0);
        return result;
    }
    
    public static PersistentAccountService createAccountService(PersistentAccount account,boolean delayed$Persistence,PersistentAccountService This) throws PersistenceException {
        PersistentAccountService result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountServiceFacade
                .newDelayedAccountService();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountServiceFacade
                .newAccountService(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("account", account);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot account = (AbstractPersistentRoot)this.getAccount();
            if (account != null) {
                result.put("account", account.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    account.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && account.hasEssentialFields())account.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("successfullStates", this.getSuccessfullStates().getObservee().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            result.put("notSuccessfullStates", this.getNotSuccessfullStates().getObservee().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public AccountService provideCopy() throws PersistenceException{
        AccountService result = this;
        result = new AccountService(this.subService, 
                                    this.This, 
                                    this.account, 
                                    this.successfullStates, 
                                    this.notSuccessfullStates, 
                                    this.getId());
        result.errors = this.errors.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAccount account;
    protected PersistentAccountServiceSuccessfullStates successfullStates;
    protected PersistentAccountServiceNotSuccessfullStates notSuccessfullStates;
    
    public AccountService(SubjInterface subService,PersistentService This,PersistentAccount account,PersistentAccountServiceSuccessfullStates successfullStates,PersistentAccountServiceNotSuccessfullStates notSuccessfullStates,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((SubjInterface)subService,(PersistentService)This,id);
        this.account = account;
        this.successfullStates = successfullStates;
        this.notSuccessfullStates = notSuccessfullStates;        
    }
    
    static public long getTypeId() {
        return -130;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == -130) ConnectionHandler.getTheConnectionHandler().theAccountServiceFacade
            .newAccountService(this.getId());
        super.store();
        if(this.getAccount() != null){
            this.getAccount().store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceFacade.accountSet(this.getId(), getAccount());
        }
        if(this.successfullStates != null){
            this.successfullStates.store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceFacade.successfullStatesSet(this.getId(), successfullStates);
        }
        if(this.notSuccessfullStates != null){
            this.notSuccessfullStates.store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceFacade.notSuccessfullStatesSet(this.getId(), notSuccessfullStates);
        }
        
    }
    
    public PersistentAccount getAccount() throws PersistenceException {
        return this.account;
    }
    public void setAccount(PersistentAccount newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.account)) return;
        if(getThis().getAccount() != null)throw new PersistenceException("Final field account in type AccountService has been set already!",0);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.account = (PersistentAccount)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceFacade.accountSet(this.getId(), newValue);
        }
    }
    protected void setSuccessfullStates(PersistentAccountServiceSuccessfullStates newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.successfullStates)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.successfullStates = (PersistentAccountServiceSuccessfullStates)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceFacade.successfullStatesSet(this.getId(), newValue);
        }
    }
    protected void setNotSuccessfullStates(PersistentAccountServiceNotSuccessfullStates newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.notSuccessfullStates)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.notSuccessfullStates = (PersistentAccountServiceNotSuccessfullStates)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceFacade.notSuccessfullStatesSet(this.getId(), newValue);
        }
    }
    public PersistentAccountService getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAccountService result = new AccountServiceProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAccountService)this.This;
    }
    
    public void accept(ServiceVisitor visitor) throws PersistenceException {
        visitor.handleAccountService(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountService(this);
    }
    public <E extends UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountService(this);
    }
    public <R, E extends UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountService(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleAccountService(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountService(this);
    }
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountService(this);
    }
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountService(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleAccountService(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountService(this);
    }
    public <E extends UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountService(this);
    }
    public <R, E extends UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountService(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccountService(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountService(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountService(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountService(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountService(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountService(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountService(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountService(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getSuccessfullStates().getObservee().getLength() > 0) return 1;
        if (this.getNotSuccessfullStates().getObservee().getLength() > 0) return 1;
        if (this.getAccount() != null && this.getAccount().getTheObject().getLeafInfo() != 0) return 1;
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
    public void executeTransfer(final PersistentDebitTransfer debitTransfer) 
				throws model.NoPermissionToExecuteDebitTransferException, model.InvalidBankNumberException, model.LimitViolatedException, model.InvalidAccountNumberException, PersistenceException{
        model.meta.AccountServiceExecuteTransferDebitTransferMssg event = new model.meta.AccountServiceExecuteTransferDebitTransferMssg(debitTransfer, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
    }
    public void executeTransfer(final PersistentDebitTransfer debitTransfer, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentExecuteTransferCommand command = model.meta.ExecuteTransferCommand.createExecuteTransferCommand(now, now);
		command.setDebitTransfer(debitTransfer);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public PersistentAccountServiceNotSuccessfullStates getNotSuccessfullStates() 
				throws PersistenceException{
        if (this.notSuccessfullStates == null) {
			this.setNotSuccessfullStates(model.AccountServiceNotSuccessfullStates.createAccountServiceNotSuccessfullStates(this.isDelayed$Persistence()));
			this.notSuccessfullStates.setObserver(this);
		}
		return this.notSuccessfullStates;
    }
    public PersistentAccountServiceSuccessfullStates getSuccessfullStates() 
				throws PersistenceException{
        if (this.successfullStates == null) {
			this.setSuccessfullStates(model.AccountServiceSuccessfullStates.createAccountServiceSuccessfullStates(this.isDelayed$Persistence()));
			this.successfullStates.setObserver(this);
		}
		return this.successfullStates;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentAccountService)This);
		if(this.equals(This)){
			this.setAccount((PersistentAccount)final$$Fields.get("account"));
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
    
    public void changeCurrency(final PersistentTransfer trans, final String currency) 
				throws PersistenceException{
        getThis().getAccount().changeCurrency(trans, StringFACTORY.createObjectBySubTypeNameForCurrency(currency));
        getThis().signalChanged(true);
        
    }
    public void changeMoney(final PersistentTransfer trans, final common.Fraction newAmount) 
				throws PersistenceException{
        getThis().getAccount().changeMoney(trans, newAmount);
        getThis().signalChanged(true);
    }
    public void changeReceiverAccount(final PersistentTransfer trans, final long receiverAccNumber) 
				throws PersistenceException{
    	getThis().getAccount().changeReceiverAccount(trans, receiverAccNumber);
        getThis().signalChanged(true);
    }
    public void changeReceiverBank(final PersistentTransfer trans, final long receiverBankNumber) 
				throws PersistenceException{
        getThis().getAccount().changeReceiverBank(trans, receiverBankNumber);
        getThis().signalChanged(true);
    }
    public void changeSubject(final PersistentTransfer trans, final String subject) 
				throws PersistenceException{
       trans.setSubject(subject);
       getThis().signalChanged(true);
    }
    public void connected(final String user) 
				throws PersistenceException{
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
    }
    public void createDebitGrant(final PersistentAccount receiver, final PersistentLimitType limit) 
				throws PersistenceException{
        //TODO: implement method: createDebitGrant
        
    }
    public void createDebit() 
				throws PersistenceException{
        PersistentDebit debit = getThis().getAccount().createDebit();
        getThis().getAccount().getDebitTransferTransactions().add(debit);
        signalChanged(true);
    }
    public void createTransfer() 
				throws PersistenceException{
        PersistentTransfer transfer = getThis().getAccount().createTransfer();
        getThis().getNotSuccessfullStates().add(transfer);
        getThis().signalChanged(true);
    }
    public void disconnected() 
				throws PersistenceException{
    }
    public void executeTransferImplementation(final PersistentDebitTransfer debitTransfer) 
				throws model.NoPermissionToExecuteDebitTransferException, model.InvalidBankNumberException, model.LimitViolatedException, model.InvalidAccountNumberException, PersistenceException{
    	debitTransfer.execute(getThis());
    }
    public void initializeOnCreation() 
				throws PersistenceException{
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
    }
    public void notSuccessfullStates_update(final model.meta.DebitTransferMssgs event) 
				throws PersistenceException{
        //TODO: implement method: notSuccessfullStates_update
        
    }
    public void successfullStates_update(final model.meta.DebitTransferMssgs event) 
				throws PersistenceException{
        //TODO: implement method: successfullStates_update
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
