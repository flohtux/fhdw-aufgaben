
package model;

import model.meta.DebitTransferNotExecutedAddDebitTransferTransactionMssg;
import model.meta.DebitTransferNotExecutedMssgsVisitor;
import model.meta.DebitTransferNotExecutedRemoveDebitTransferTransactionMssg;
import model.meta.DebitTransferSuccessfulAddDebitTransferTransactionMssg;
import model.meta.DebitTransferSuccessfulMssgsVisitor;
import model.meta.DebitTransferSuccessfulRemoveDebitTransferTransactionMssg;
import model.meta.DebitTransferTemplateAddDebitTransferTransactionMssg;
import model.meta.DebitTransferTemplateMssgsVisitor;
import model.meta.DebitTransferTemplateRemoveDebitTransferTransactionMssg;
import model.meta.DebitTransferTransactionSwitchPARAMETER;
import model.meta.LimitTypeSwitchPARAMETER;
import model.meta.RuleSwitchPARAMETER;
import model.meta.StringFACTORY;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.DebitTransferStateVisitor;
import model.visitor.InvokerExceptionVisitor;
import model.visitor.InvokerReturnExceptionVisitor;
import model.visitor.InvokerReturnVisitor;
import model.visitor.InvokerVisitor;
import model.visitor.RemoteExceptionVisitor;
import model.visitor.RemoteReturnExceptionVisitor;
import model.visitor.RemoteReturnVisitor;
import model.visitor.RemoteVisitor;
import model.visitor.ServiceExceptionVisitor;
import model.visitor.ServiceReturnExceptionVisitor;
import model.visitor.ServiceReturnVisitor;
import model.visitor.ServiceVisitor;
import model.visitor.SubjInterfaceExceptionVisitor;
import model.visitor.SubjInterfaceReturnExceptionVisitor;
import model.visitor.SubjInterfaceReturnVisitor;
import model.visitor.SubjInterfaceVisitor;
import persistence.AbstractPersistentRoot;
import persistence.AccountServiceProxi;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.DebitTransferSearchList;
import persistence.DebitTransferTransactionSearchList;
import persistence.Invoker;
import persistence.ObsInterface;
import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentAccountService;
import persistence.PersistentAccountServiceBankFees;
import persistence.PersistentAccountServiceNotExecuted;
import persistence.PersistentAccountServiceSuccessful;
import persistence.PersistentAccountServiceTemplate;
import persistence.PersistentBank;
import persistence.PersistentBankFees;
import persistence.PersistentBooleanValue;
import persistence.PersistentCompensatedState;
import persistence.PersistentCompensationRequest;
import persistence.PersistentCompensationRequestListe;
import persistence.PersistentCompensationRequestedState;
import persistence.PersistentDebit;
import persistence.PersistentDebitGrant;
import persistence.PersistentDebitGrantListe;
import persistence.PersistentDebitTransfer;
import persistence.PersistentDebitTransferNotExecuted;
import persistence.PersistentDebitTransferSuccessful;
import persistence.PersistentDebitTransferTemplate;
import persistence.PersistentDebitTransferTransaction;
import persistence.PersistentEventWrapper;
import persistence.PersistentExecutedState;
import persistence.PersistentIncomingAccountRule;
import persistence.PersistentLimit;
import persistence.PersistentLimitType;
import persistence.PersistentMoneyRule;
import persistence.PersistentNotExecutableState;
import persistence.PersistentNotExecutedState;
import persistence.PersistentNotSuccessfulState;
import persistence.PersistentProxi;
import persistence.PersistentRule;
import persistence.PersistentService;
import persistence.PersistentSubjectRule;
import persistence.PersistentSuccessfulState;
import persistence.PersistentTemplateState;
import persistence.PersistentTransaction;
import persistence.PersistentTransfer;
import persistence.PersistentTrigger;
import persistence.PersistentUseTemplateCommand;
import persistence.SubjInterface;
import persistence.TDObserver;


/* Additional import section end */

public class AccountService extends model.Service implements PersistentAccountService{
    
    
    public static PersistentAccountService createAccountService(PersistentAccount account,PersistentBankFees bankFees) throws PersistenceException{
        return createAccountService(account,bankFees,false);
    }
    
    public static PersistentAccountService createAccountService(PersistentAccount account,PersistentBankFees bankFees,boolean delayed$Persistence) throws PersistenceException {
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
        final$$Fields.put("bankFees", bankFees);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        if(result.getThis().getAccount() == null)throw new PersistenceException("Field account in type AccountService has not been initialized!",0);
        if(result.getThis().getEventhandle() == null)throw new PersistenceException("Field eventhandle in type AccountService has not been initialized!",0);
        if(result.getThis().getBankFees() == null)throw new PersistenceException("Field bankFees in type AccountService has not been initialized!",0);
        return result;
    }
    
    public static PersistentAccountService createAccountService(PersistentAccount account,PersistentBankFees bankFees,boolean delayed$Persistence,PersistentAccountService This) throws PersistenceException {
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
        final$$Fields.put("bankFees", bankFees);
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
            AbstractPersistentRoot eventhandle = (AbstractPersistentRoot)this.getEventhandle();
            if (eventhandle != null) {
                result.put("eventhandle", eventhandle.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    eventhandle.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && eventhandle.hasEssentialFields())eventhandle.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot successful = (AbstractPersistentRoot)this.getSuccessful();
            if (successful != null) {
                result.put("successful", successful.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    successful.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && successful.hasEssentialFields())successful.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot notExecuted = (AbstractPersistentRoot)this.getNotExecuted();
            if (notExecuted != null) {
                result.put("notExecuted", notExecuted.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    notExecuted.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && notExecuted.hasEssentialFields())notExecuted.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot template = (AbstractPersistentRoot)this.getTemplate();
            if (template != null) {
                result.put("template", template.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    template.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && template.hasEssentialFields())template.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot bankFees = (AbstractPersistentRoot)this.getBankFees();
            if (bankFees != null) {
                result.put("bankFees", bankFees.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    bankFees.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && bankFees.hasEssentialFields())bankFees.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
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
                                    this.eventhandle, 
                                    this.successful, 
                                    this.notExecuted, 
                                    this.template, 
                                    this.bankFees, 
                                    this.getId());
        result.errors = this.errors.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAccount account;
    protected PersistentEventWrapper eventhandle;
    protected PersistentAccountServiceSuccessful successful;
    protected PersistentAccountServiceNotExecuted notExecuted;
    protected PersistentAccountServiceTemplate template;
    protected PersistentAccountServiceBankFees bankFees;
    
    public AccountService(SubjInterface subService,PersistentService This,PersistentAccount account,PersistentEventWrapper eventhandle,PersistentAccountServiceSuccessful successful,PersistentAccountServiceNotExecuted notExecuted,PersistentAccountServiceTemplate template,PersistentAccountServiceBankFees bankFees,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((SubjInterface)subService,(PersistentService)This,id);
        this.account = account;
        this.eventhandle = eventhandle;
        this.successful = successful;
        this.notExecuted = notExecuted;
        this.template = template;
        this.bankFees = bankFees;        
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
        if(this.getEventhandle() != null){
            this.getEventhandle().store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceFacade.eventhandleSet(this.getId(), getEventhandle());
        }
        if(this.successful != null){
            this.successful.store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceFacade.successfulSet(this.getId(), successful);
        }
        if(this.notExecuted != null){
            this.notExecuted.store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceFacade.notExecutedSet(this.getId(), notExecuted);
        }
        if(this.template != null){
            this.template.store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceFacade.templateSet(this.getId(), template);
        }
        if(this.bankFees != null){
            this.bankFees.store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceFacade.bankFeesSet(this.getId(), bankFees);
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
    public PersistentEventWrapper getEventhandle() throws PersistenceException {
        return this.eventhandle;
    }
    public void setEventhandle(PersistentEventWrapper newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.eventhandle)) return;
        if(getThis().getEventhandle() != null)throw new PersistenceException("Final field eventhandle in type AccountService has been set already!",0);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.eventhandle = (PersistentEventWrapper)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceFacade.eventhandleSet(this.getId(), newValue);
        }
    }
    protected void setSuccessful(PersistentAccountServiceSuccessful newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.successful)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.successful = (PersistentAccountServiceSuccessful)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceFacade.successfulSet(this.getId(), newValue);
        }
    }
    protected void setNotExecuted(PersistentAccountServiceNotExecuted newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.notExecuted)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.notExecuted = (PersistentAccountServiceNotExecuted)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceFacade.notExecutedSet(this.getId(), newValue);
        }
    }
    protected void setTemplate(PersistentAccountServiceTemplate newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.template)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.template = (PersistentAccountServiceTemplate)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceFacade.templateSet(this.getId(), newValue);
        }
    }
    protected void setBankFees(PersistentAccountServiceBankFees newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.bankFees)) return;
        if(getThis().getBankFees() != null)throw new PersistenceException("Final field bankFees in type AccountService has been set already!",0);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.bankFees = (PersistentAccountServiceBankFees)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceFacade.bankFeesSet(this.getId(), newValue);
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
        if (this.getSuccessful() != null) return 1;
        if (this.getNotExecuted() != null) return 1;
        if (this.getTemplate() != null) return 1;
        if (this.getBankFees() != null) return 1;
        if (this.getAccount() != null && this.getAccount().getTheObject().getLeafInfo() != 0) return 1;
        return 0;
    }
    
    
    public PersistentCompensationRequestListe a_Path_In_AnswerAcceptWithTrigger() 
				throws model.UserException, PersistenceException{
        	return getThis().getAccount().
                getAllCompensation().
                getPendingCompensationRequests();
    }
    public PersistentCompensationRequestListe a_Path_In_AnswerAccept() 
				throws model.UserException, PersistenceException{
        	return getThis().getAccount().
                getAllCompensation().
                getPendingCompensationRequests();
    }
    public PersistentCompensationRequestListe a_Path_In_AnswerDecline() 
				throws model.UserException, PersistenceException{
        	return getThis().getAccount().
                getAllCompensation().
                getPendingCompensationRequests();
    }
    public DebitTransferTransactionSearchList debitTransfer_Path_In_AddToTransactionTemplate() 
				throws model.UserException, PersistenceException{
        	return new DebitTransferTransactionSearchList(getThis().getTemplate().
                getTemplates().getList());
    }
    public DebitTransferTransactionSearchList debitTransfer_Path_In_AddToTransaction() 
				throws model.UserException, PersistenceException{
        	return new DebitTransferTransactionSearchList(getThis().getNotExecuted().
                getNotExecuteds().getList());
    }
    public DebitTransferSearchList debitTransfer_Path_In_RemoveFromTransaction(final PersistentTransaction transaction) 
				throws model.UserException, PersistenceException{
        	return new DebitTransferSearchList(transaction.
                getDebitTransfer().
                getDebitTransfers().getList());
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
    public DebitTransferTransactionSearchList dtr_Path_In_RequestCompensation() 
				throws model.UserException, PersistenceException{
        	return new DebitTransferTransactionSearchList(getThis().getSuccessful().
                getSuccessfuls().getList());
    }
    public PersistentBankFees getBankFees() 
				throws PersistenceException{
        if (this.bankFees== null) return null;
		return this.bankFees.getObservee();
    }
    public PersistentDebitTransferNotExecuted getNotExecuted() 
				throws PersistenceException{
        if (this.notExecuted== null) return null;
		return this.notExecuted.getObservee();
    }
    public PersistentDebitTransferSuccessful getSuccessful() 
				throws PersistenceException{
        if (this.successful== null) return null;
		return this.successful.getObservee();
    }
    public PersistentDebitTransferTemplate getTemplate() 
				throws PersistenceException{
        if (this.template== null) return null;
		return this.template.getObservee();
    }
    public PersistentDebitGrantListe grant_Path_In_Remove() 
				throws model.UserException, PersistenceException{
        	return getThis().getAccount().
                getGrantedDebitGrant();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentAccountService)This);
		if(this.equals(This)){
			this.setAccount((PersistentAccount)final$$Fields.get("account"));
			this.setBankFees((PersistentBankFees)final$$Fields.get("bankFees"));
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
    public void setBankFees(final PersistentBankFees bankFees) 
				throws PersistenceException{
        if (this.bankFees == null) {
			this.setBankFees(model.AccountServiceBankFees.createAccountServiceBankFees(this.isDelayed$Persistence()));
			this.bankFees.setObserver(getThis());
		}else{
			if (!this.getThis().getBankFees().equals(bankFees))throw new PersistenceException("Final field bankFees in type AccountService has been set already!",0);
		}
		this.bankFees.setObservee(bankFees);
    }
    public void setNotExecuted(final PersistentDebitTransferNotExecuted notExecuted) 
				throws PersistenceException{
        if (this.notExecuted == null) {
			this.setNotExecuted(model.AccountServiceNotExecuted.createAccountServiceNotExecuted(this.isDelayed$Persistence()));
			this.notExecuted.setObserver(getThis());
		}
		this.notExecuted.setObservee(notExecuted);
    }
    public void setSuccessful(final PersistentDebitTransferSuccessful successful) 
				throws PersistenceException{
        if (this.successful == null) {
			this.setSuccessful(model.AccountServiceSuccessful.createAccountServiceSuccessful(this.isDelayed$Persistence()));
			this.successful.setObserver(getThis());
		}
		this.successful.setObservee(successful);
    }
    public void setTemplate(final PersistentDebitTransferTemplate template) 
				throws PersistenceException{
        if (this.template == null) {
			this.setTemplate(model.AccountServiceTemplate.createAccountServiceTemplate(this.isDelayed$Persistence()));
			this.template.setObserver(getThis());
		}
		this.template.setObservee(template);
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
    public void useTemplate(final PersistentDebitTransferTransaction debitTransferTransaction, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentUseTemplateCommand command = model.meta.UseTemplateCommand.createUseTemplateCommand(now, now);
		command.setDebitTransferTransaction(debitTransferTransaction);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void addToTransactionTemplate(final PersistentTransaction transaction, final DebitTransferSearchList debitTransfer) 
				throws PersistenceException{
    	getThis().getAccount().addToTransactionTemplate(transaction, debitTransfer);
        getThis().signalChanged(true);
    }
    public void addToTransactionTrigger(final PersistentTransaction transaction, final String type) 
				throws PersistenceException{
        getThis().getAccount().addToTransactionTrigger(transaction, type);
        getThis().signalChanged(true);
    }
    public void addToTransaction(final PersistentTransaction transaction, final DebitTransferSearchList debitTransfer) 
				throws PersistenceException{
	    getThis().getAccount().addToTransaction(transaction, debitTransfer);
        getThis().signalChanged(true);
    }
    public void answerAcceptWithTrigger(final PersistentCompensationRequest a) 
				throws model.NoPermissionToAnswerRequestOfForeignAccountException, PersistenceException{
        getThis().getAccount().answerAcceptWithTrigger(a);
        getThis().signalChanged(true);        
    }
    public void answerAccept(final PersistentCompensationRequest a) 
				throws model.NoPermissionToAnswerRequestOfForeignAccountException, PersistenceException{
        getThis().getAccount().answerAccept(a);
        getThis().signalChanged(true);
        
    }
    public void answerDecline(final PersistentCompensationRequest a) 
				throws model.NoPermissionToAnswerRequestOfForeignAccountException, PersistenceException{
        getThis().getAccount().answerDecline(a);
        getThis().signalChanged(true);
        
    }
    public void bankFees_update(final model.meta.BankFeesMssgs event) 
				throws PersistenceException{
    	getThis().signalChanged(true);
        
    }
    public void changeCurrency(final PersistentDebitTransfer trans, final String currency) 
				throws PersistenceException{
        getThis().getAccount().changeCurrency(trans, StringFACTORY.createObjectBySubTypeNameForCurrency(currency),getThis());
        getThis().signalChanged(true);
        
    }
    public void changeIncomingAccountRuleAccountNumber(final PersistentIncomingAccountRule rule, final long newAccNum) 
				throws PersistenceException{
        rule.changeAccountNumber(newAccNum);
        getThis().signalChanged(true);
    }
    public void changeIncomingAccountRuleBankNumber(final PersistentIncomingAccountRule rule, final long newBankNum) 
				throws PersistenceException{
        rule.changeBankNumber(newBankNum);
        getThis().signalChanged(true);
        
    }
    public void changeMoneyRuleMax(final PersistentMoneyRule rule, final common.Fraction maxValue) 
				throws PersistenceException{
    	rule.changeMax(maxValue);
    	getThis().signalChanged(true);
    }
    public void changeMoneyRuleMin(final PersistentMoneyRule rule, final common.Fraction minValue) 
				throws PersistenceException{
    	rule.changeMin(minValue);
    	getThis().signalChanged(true);
    }
    public void changeMoney(final PersistentDebitTransfer trans, final common.Fraction newAmount) 
				throws PersistenceException{
        getThis().getAccount().changeMoney(trans, newAmount,getThis());
        getThis().signalChanged(true);
    }
    public void changeReceiverAccount(final PersistentDebitTransfer trans, final long receiverAccNumber) 
				throws PersistenceException{
    	getThis().getAccount().changeReceiverAccount(trans, receiverAccNumber,getThis());
        getThis().signalChanged(true);
    }
    public void changeReceiverBank(final PersistentDebitTransfer trans, final long receiverBankNumber) 
				throws PersistenceException{
        getThis().getAccount().changeReceiverBank(trans, receiverBankNumber,getThis());
        getThis().signalChanged(true);
    }
    public void changeSubjectRuleSubject(final PersistentSubjectRule rule, final String newSubject) 
				throws PersistenceException{
        rule.changeSubject(newSubject);
        getThis().signalChanged(true);
    }
    public void changeSubject(final PersistentDebitTransfer trans, final String subject) 
				throws PersistenceException{
       getThis().getAccount().changeSubject(trans, subject, getThis());
       getThis().signalChanged(true);
    }
    public PersistentBooleanValue checkMoneyRuleMax(final PersistentMoneyRule rule, final common.Fraction maxValue) 
				throws PersistenceException{
        return rule.checkMax(maxValue);
    }
    public PersistentBooleanValue checkMoneyRuleMin(final PersistentMoneyRule rule, final common.Fraction minValue) 
				throws PersistenceException{
    	return rule.checkMin(minValue);
    }
    public void connected(final String user) 
				throws PersistenceException{
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
    }
    public void createDebitGrant(final long receiverAccNumber, final long receiverBankNumber, final String limitType, final common.Fraction amount, final String cur) 
				throws model.GrantAlreadyGivenException, model.InvalidBankNumberException, model.InvalidAccountNumberException, PersistenceException{
    	PersistentBank b = getThis().getAccount().getBank().getAdministrator().searchBankByBankNumber(receiverBankNumber);
    	PersistentAccount a = b.searchAccountByAccNumber(receiverAccNumber);
    	
    	PersistentLimitType limit = StringFACTORY.createObjectBySubTypeNameForLimitType(limitType, new LimitTypeSwitchPARAMETER() {
			public PersistentLimit handleLimit() throws PersistenceException {
				return Limit.createLimit(Money.createMoney(Amount.createAmount(amount), StringFACTORY.createObjectBySubTypeNameForCurrency(cur)));
			}
		});
    	
    	getThis().getAccount().createDebitGrant(a, limit,getThis());
    	getThis().signalChanged(true);
    }
    public void createDebit() 
				throws PersistenceException{
        PersistentDebit debit = getThis().getAccount().createDebit();
        getThis().getNotExecuted().getNotExecuteds().add(debit);
        signalChanged(true);
    }
    public void createNewRule(final PersistentTrigger t, final String type) 
				throws model.DoubleRuleDefinitionException, PersistenceException{
    	PersistentRule newRule = StringFACTORY.createObjectBySubTypeNameForRule(type, new RuleSwitchPARAMETER() {
			@Override
			public PersistentSubjectRule handleSubjectRule() throws PersistenceException {
				return SubjectRule.createSubjectRule();
			}
			
			@Override
			public PersistentMoneyRule handleMoneyRule() throws PersistenceException {
				return MoneyRule.createMoneyRule(getThis().getAccount().getMoney().getCurrency());
			}
			
			@Override
			public PersistentIncomingAccountRule handleIncomingAccountRule() throws PersistenceException {
				return IncomingAccountRule.createIncomingAccountRule();
			}
		});
    	t.addRule(newRule);
    	getThis().signalChanged(true);
    }
    public void createTemplate(final String type) 
				throws PersistenceException{
    	PersistentDebitTransferTransaction template = getThis().getAccount().createTemplate(type);
    	getThis().getTemplate().getTemplates().add(template);
        getThis().signalChanged(true);
        
    }
    public void createTransaction() 
				throws PersistenceException{
        PersistentTransaction transaction = getThis().getAccount().createTransaction();
        getThis().getNotExecuted().getNotExecuteds().add(transaction);
        getThis().signalChanged(true);
    }
    public void createTransfer() 
				throws PersistenceException{
    	PersistentTransfer transfer = getThis().getAccount().createTransfer();
    	getThis().getNotExecuted().getNotExecuteds().add(transfer);
        getThis().signalChanged(true);
    }
    public void createTrigger(final String name, final String type) 
				throws PersistenceException{
    	PersistentDebitTransferTransaction newDTT = StringFACTORY.createObjectBySubTypeNameForDebitTransferTransaction(type, new DebitTransferTransactionSwitchPARAMETER() {
			
			@Override
			public PersistentTransfer handleTransfer() throws PersistenceException {
				return getThis().getAccount().createTransfer();
			}
			
			@Override
			public PersistentTransaction handleTransaction() throws PersistenceException {
				return getThis().getAccount().createTransaction();
			}
			
			@Override
			public PersistentDebit handleDebit() throws PersistenceException {
				return getThis().getAccount().createDebit();
			}
		});
        getThis().getAccount().createTrigger(name, newDTT);
        getThis().signalChanged(true);
    }
    public void disable(final PersistentTrigger t) 
				throws PersistenceException{
        t.disable();
        getThis().signalChanged(true);
        
    }
    public void disconnected() 
				throws PersistenceException{
    }
    public void enable(final PersistentTrigger t) 
				throws model.NoRuleDefinitionException, PersistenceException{
        t.enable();
        getThis().signalChanged(true);
    }
    public void executeTransfer(final PersistentDebitTransferTransaction debitTransfer) 
				throws model.NoPermissionToExecuteDebitTransferException, model.ExecuteException, PersistenceException{
    	getThis().getAccount().executeTransfer(debitTransfer);
    	getThis().signalChanged(true);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
    	getThis().setSuccessful(DebitTransferSuccessful.createDebitTransferSuccessful());
    	getThis().setNotExecuted(DebitTransferNotExecuted.createDebitTransferNotExecuted());
    	getThis().setTemplate(DebitTransferTemplate.createDebitTransferTemplate());
    	getThis().setEventhandle(EventWrapper.createEventWrapper());
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
    }
    public void notExecuted_update(final model.meta.DebitTransferNotExecutedMssgs event) 
				throws PersistenceException{
        event.accept(new DebitTransferNotExecutedMssgsVisitor() {
			@Override
			public void handleDebitTransferNotExecutedRemoveDebitTransferTransactionMssg(
					DebitTransferNotExecutedRemoveDebitTransferTransactionMssg event)
					throws PersistenceException {
				getThis().signalChanged(true);
			}
			@Override
			public void handleDebitTransferNotExecutedAddDebitTransferTransactionMssg(
					DebitTransferNotExecutedAddDebitTransferTransactionMssg event)
					throws PersistenceException {
				getThis().signalChanged(true);
			}
		});
    }
    public void removeFromTransaction(final PersistentTransaction transaction, final DebitTransferSearchList debitTransfer) 
				throws PersistenceException{
    	getThis().getAccount().removeFromTransaction(transaction, debitTransfer);
        getThis().signalChanged(true);
    }
    public void remove(final PersistentDebitGrant grant) 
				throws model.NoPermissionToRemoveDebitGrantException, PersistenceException{
    	getThis().getAccount().getReceivedDebitGrant().getD1().remove(grant.getPermittedAccount());
    	grant.getPermittedAccount().getAccount().getGrantedDebitGrant().remove(AccountPx.createAccountPx(getThis().getAccount()));
    	getThis().signalChanged(true);
    }
    public void requestCompensation(final PersistentDebitTransferTransaction dtr) 
				throws model.NoPermissionToAnswerRequestOfForeignAccountException, PersistenceException{
        getThis().getAccount().requestCompensation(dtr);
        getThis().signalChanged(true);
        
    }
    public void successful_update(final model.meta.DebitTransferSuccessfulMssgs event) 
				throws PersistenceException{
    	event.accept(new DebitTransferSuccessfulMssgsVisitor() {
			@Override
			public void handleDebitTransferSuccessfulAddDebitTransferTransactionMssg(
					DebitTransferSuccessfulAddDebitTransferTransactionMssg event)
					throws PersistenceException {
				getThis().signalChanged(true);
			}
			@Override
			public void handleDebitTransferSuccessfulRemoveDebitTransferTransactionMssg(
					DebitTransferSuccessfulRemoveDebitTransferTransactionMssg event)
					throws PersistenceException {
				getThis().signalChanged(true);
			}
		});
        
    }
    public void template_update(final model.meta.DebitTransferTemplateMssgs event) 
				throws PersistenceException{
        event.accept(new DebitTransferTemplateMssgsVisitor() {
			@Override
			public void handleDebitTransferTemplateRemoveDebitTransferTransactionMssg(
					DebitTransferTemplateRemoveDebitTransferTransactionMssg event)
					throws PersistenceException {
				getThis().signalChanged(true);
			}
			@Override
			public void handleDebitTransferTemplateAddDebitTransferTransactionMssg(
					DebitTransferTemplateAddDebitTransferTransactionMssg event)
					throws PersistenceException {
				getThis().signalChanged(true);
			}
		});
    }
    public void useTemplate(final PersistentDebitTransferTransaction debitTransferTransaction) 
				throws PersistenceException{
    	final PersistentDebitTransferTransaction debitTransferTransactionCopy = debitTransferTransaction.copy();
    	debitTransferTransactionCopy.getState().accept(new DebitTransferStateVisitor() {
			@Override
			public void handleTemplateState(PersistentTemplateState templateState)
					throws PersistenceException {
				debitTransferTransactionCopy.changeState(NotExecutedState.createNotExecutedState());
			}
			@Override
			public void handleSuccessfulState(PersistentSuccessfulState successfulState)
					throws PersistenceException {
			}
			
			@Override
			public void handleNotSuccessfulState(
					PersistentNotSuccessfulState notSuccessfulState)
					throws PersistenceException {
			}
			
			@Override
			public void handleNotExecutedState(
					PersistentNotExecutedState notExecutedState)
					throws PersistenceException {
				
			}
			
			@Override
			public void handleNotExecutableState(
					PersistentNotExecutableState notExecutableState)
					throws PersistenceException {
			}
			
			@Override
			public void handleExecutedState(PersistentExecutedState executedState)
					throws PersistenceException {
				
			}
			@Override
			public void handleCompensatedState(PersistentCompensatedState compensatedState) throws PersistenceException {
			}
			@Override
			public void handleCompensationRequestedState(
					PersistentCompensationRequestedState compensationRequestedState)
					throws PersistenceException {
			}
		});
    	getThis().getNotExecuted().getNotExecuteds().add(debitTransferTransactionCopy);
    	getThis().getAccount().getDebitTransferTransactions().add(debitTransferTransactionCopy);
    	getThis().signalChanged(true);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
