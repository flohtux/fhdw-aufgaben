
package model;

import model.meta.DebitGrantListeCreateDebitGrantAccountPxLimitTypeMssg;
import model.meta.DebitGrantListeMssgsVisitor;
import model.meta.DebitGrantListeRemoveAccountPxMssg;
import model.meta.DebitTransferChangeCurrencyCurrencyMssg;
import model.meta.DebitTransferChangeMoneyFractionMssg;
import model.meta.DebitTransferChangeReceiverAccountIntegerMssg;
import model.meta.DebitTransferChangeReceiverBankIntegerMssg;
import model.meta.DebitTransferTransactionChangeStateDebitTransferStateMssg;
import model.meta.DebitTransferTransactionExecuteMssg;
import model.meta.DebitTransferTransactionMssgs;
import model.meta.DebitTransferTransactionMssgsVisitor;
import model.meta.DebitTransferTransactionSwitchPARAMETER;
import model.meta.StringFACTORY;
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
import persistence.AccountProxi;
import persistence.AccountSearchList;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.DebitTransferSearchList;
import persistence.Invoker;
import persistence.ObsInterface;
import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentAccountDebitTransferTransactions;
import persistence.PersistentAccountGrantedDebitGrant;
import persistence.PersistentAccountPx;
import persistence.PersistentAccountReceivedDebitGrant;
import persistence.PersistentAccountService;
import persistence.PersistentAccountTriggerListe;
import persistence.PersistentBank;
import persistence.PersistentChangeCurrencyCommand;
import persistence.PersistentChangeMoneyCommand;
import persistence.PersistentChangeReceiverAccountCommand;
import persistence.PersistentChangeReceiverBankCommand;
import persistence.PersistentCreateDebitGrantCommand;
import persistence.PersistentCurrency;
import persistence.PersistentDebit;
import persistence.PersistentDebitGrantListe;
import persistence.PersistentDebitTransfer;
import persistence.PersistentDebitTransferTransaction;
import persistence.PersistentLimitAccount;
import persistence.PersistentLimitType;
import persistence.PersistentMoney;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentRule;
import persistence.PersistentTransaction;
import persistence.PersistentTransfer;
import persistence.PersistentTrigger;
import persistence.PersistentTriggerListe;
import persistence.Predcate;
import persistence.Procdure;
import persistence.ProcdureException;
import persistence.SubjInterface;
import persistence.TDObserver;


/* Additional import section end */

public class Account extends PersistentObject implements PersistentAccount{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentAccount getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAccountFacade.getClass(objectId);
        return (PersistentAccount)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentAccount createAccount(long accountNumber,PersistentMoney money) throws PersistenceException{
        return createAccount(accountNumber,money,false);
    }
    
    public static PersistentAccount createAccount(long accountNumber,PersistentMoney money,boolean delayed$Persistence) throws PersistenceException {
        PersistentAccount result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountFacade
                .newDelayedAccount(accountNumber);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountFacade
                .newAccount(accountNumber,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("accountNumber", accountNumber);
        final$$Fields.put("money", money);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentAccount createAccount(long accountNumber,PersistentMoney money,boolean delayed$Persistence,PersistentAccount This) throws PersistenceException {
        PersistentAccount result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountFacade
                .newDelayedAccount(accountNumber);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountFacade
                .newAccount(accountNumber,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("accountNumber", accountNumber);
        final$$Fields.put("money", money);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("accountNumber", new Long(this.getAccountNumber()).toString());
            AbstractPersistentRoot money = (AbstractPersistentRoot)this.getMoney();
            if (money != null) {
                result.put("money", money.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    money.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && money.hasEssentialFields())money.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot limit = (AbstractPersistentRoot)this.getLimit();
            if (limit != null) {
                result.put("limit", limit.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    limit.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && limit.hasEssentialFields())limit.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("debitTransferTransactions", this.getDebitTransferTransactions().getObservee().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            AbstractPersistentRoot grantedDebitGrant = (AbstractPersistentRoot)this.getGrantedDebitGrant();
            if (grantedDebitGrant != null) {
                result.put("grantedDebitGrant", grantedDebitGrant.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    grantedDebitGrant.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && grantedDebitGrant.hasEssentialFields())grantedDebitGrant.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot receivedDebitGrant = (AbstractPersistentRoot)this.getReceivedDebitGrant();
            if (receivedDebitGrant != null) {
                result.put("receivedDebitGrant", receivedDebitGrant.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    receivedDebitGrant.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && receivedDebitGrant.hasEssentialFields())receivedDebitGrant.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot triggerListe = (AbstractPersistentRoot)this.getTriggerListe();
            if (triggerListe != null) {
                result.put("triggerListe", triggerListe.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    triggerListe.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && triggerListe.hasEssentialFields())triggerListe.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public static AccountSearchList getAccountByAccountNumber(long accountNumber) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theAccountFacade
            .getAccountByAccountNumber(accountNumber);
    }
    
    public Account provideCopy() throws PersistenceException{
        Account result = this;
        result = new Account(this.accountNumber, 
                             this.money, 
                             this.limit, 
                             this.debitTransferTransactions, 
                             this.grantedDebitGrant, 
                             this.receivedDebitGrant, 
                             this.triggerListe, 
                             this.subService, 
                             this.This, 
                             this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected long accountNumber;
    protected PersistentMoney money;
    protected PersistentLimitAccount limit;
    protected PersistentAccountDebitTransferTransactions debitTransferTransactions;
    protected PersistentAccountGrantedDebitGrant grantedDebitGrant;
    protected PersistentAccountReceivedDebitGrant receivedDebitGrant;
    protected PersistentAccountTriggerListe triggerListe;
    protected SubjInterface subService;
    protected PersistentAccount This;
    
    public Account(long accountNumber,PersistentMoney money,PersistentLimitAccount limit,PersistentAccountDebitTransferTransactions debitTransferTransactions,PersistentAccountGrantedDebitGrant grantedDebitGrant,PersistentAccountReceivedDebitGrant receivedDebitGrant,PersistentAccountTriggerListe triggerListe,SubjInterface subService,PersistentAccount This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.accountNumber = accountNumber;
        this.money = money;
        this.limit = limit;
        this.debitTransferTransactions = debitTransferTransactions;
        this.grantedDebitGrant = grantedDebitGrant;
        this.receivedDebitGrant = receivedDebitGrant;
        this.triggerListe = triggerListe;
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 133;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 133) ConnectionHandler.getTheConnectionHandler().theAccountFacade
            .newAccount(accountNumber,this.getId());
        super.store();
        if(this.getMoney() != null){
            this.getMoney().store();
            ConnectionHandler.getTheConnectionHandler().theAccountFacade.moneySet(this.getId(), getMoney());
        }
        if(this.getLimit() != null){
            this.getLimit().store();
            ConnectionHandler.getTheConnectionHandler().theAccountFacade.limitSet(this.getId(), getLimit());
        }
        if(this.debitTransferTransactions != null){
            this.debitTransferTransactions.store();
            ConnectionHandler.getTheConnectionHandler().theAccountFacade.debitTransferTransactionsSet(this.getId(), debitTransferTransactions);
        }
        if(this.grantedDebitGrant != null){
            this.grantedDebitGrant.store();
            ConnectionHandler.getTheConnectionHandler().theAccountFacade.grantedDebitGrantSet(this.getId(), grantedDebitGrant);
        }
        if(this.receivedDebitGrant != null){
            this.receivedDebitGrant.store();
            ConnectionHandler.getTheConnectionHandler().theAccountFacade.receivedDebitGrantSet(this.getId(), receivedDebitGrant);
        }
        if(this.triggerListe != null){
            this.triggerListe.store();
            ConnectionHandler.getTheConnectionHandler().theAccountFacade.triggerListeSet(this.getId(), triggerListe);
        }
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theAccountFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theAccountFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public long getAccountNumber() throws PersistenceException {
        return this.accountNumber;
    }
    public void setAccountNumber(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theAccountFacade.accountNumberSet(this.getId(), newValue);
        this.accountNumber = newValue;
    }
    public PersistentMoney getMoney() throws PersistenceException {
        return this.money;
    }
    public void setMoney(PersistentMoney newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.money)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.money = (PersistentMoney)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountFacade.moneySet(this.getId(), newValue);
        }
    }
    public PersistentLimitAccount getLimit() throws PersistenceException {
        return this.limit;
    }
    public void setLimit(PersistentLimitAccount newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.limit)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.limit = (PersistentLimitAccount)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountFacade.limitSet(this.getId(), newValue);
        }
    }
    protected void setDebitTransferTransactions(PersistentAccountDebitTransferTransactions newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.debitTransferTransactions)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.debitTransferTransactions = (PersistentAccountDebitTransferTransactions)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountFacade.debitTransferTransactionsSet(this.getId(), newValue);
        }
    }
    protected void setGrantedDebitGrant(PersistentAccountGrantedDebitGrant newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.grantedDebitGrant)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.grantedDebitGrant = (PersistentAccountGrantedDebitGrant)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountFacade.grantedDebitGrantSet(this.getId(), newValue);
        }
    }
    protected void setReceivedDebitGrant(PersistentAccountReceivedDebitGrant newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.receivedDebitGrant)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.receivedDebitGrant = (PersistentAccountReceivedDebitGrant)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountFacade.receivedDebitGrantSet(this.getId(), newValue);
        }
    }
    protected void setTriggerListe(PersistentAccountTriggerListe newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.triggerListe)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.triggerListe = (PersistentAccountTriggerListe)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountFacade.triggerListeSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theAccountFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentAccount newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAccount)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentAccount getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAccount result = new AccountProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAccount)this.This;
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccount(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccount(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccount(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccount(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccount(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccount(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccount(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccount(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getMoney() != null) return 1;
        if (this.getLimit() != null) return 1;
        if (this.getGrantedDebitGrant() != null) return 1;
        if (this.getReceivedDebitGrant() != null) return 1;
        if (this.getTriggerListe() != null) return 1;
        return 0;
    }
    
    
    public void changeCurrency(final PersistentDebitTransfer trans, final PersistentCurrency currency, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentChangeCurrencyCommand command = model.meta.ChangeCurrencyCommand.createChangeCurrencyCommand(now, now);
		command.setTrans(trans);
		command.setCurrency(currency);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void changeMoney(final PersistentDebitTransfer trans, final common.Fraction newAmount, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentChangeMoneyCommand command = model.meta.ChangeMoneyCommand.createChangeMoneyCommand(newAmount, now, now);
		command.setTrans(trans);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void changeReceiverAccount(final PersistentDebitTransfer trans, final long receiverAccountNumber, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentChangeReceiverAccountCommand command = model.meta.ChangeReceiverAccountCommand.createChangeReceiverAccountCommand(receiverAccountNumber, now, now);
		command.setTrans(trans);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void changeReceiverBank(final PersistentDebitTransfer trans, final long receiverBankNumber, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentChangeReceiverBankCommand command = model.meta.ChangeReceiverBankCommand.createChangeReceiverBankCommand(receiverBankNumber, now, now);
		command.setTrans(trans);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createDebitGrant(final PersistentAccount receiver, final PersistentLimitType limit) 
				throws model.GrantAlreadyGivenException, PersistenceException{
        model.meta.AccountCreateDebitGrantAccountLimitTypeMssg event = new model.meta.AccountCreateDebitGrantAccountLimitTypeMssg(receiver, limit, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
    }
    public void createDebitGrant(final PersistentAccount receiver, final PersistentLimitType limit, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateDebitGrantCommand command = model.meta.CreateDebitGrantCommand.createCreateDebitGrantCommand(now, now);
		command.setReceiver(receiver);
		command.setLimit(limit);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
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
    public PersistentAccountService getAccountService() 
				throws PersistenceException{
        PersistentAccountService result = null;
		try {
			if (result == null) result = (PersistentAccountService)ConnectionHandler.getTheConnectionHandler().theAccountServiceFacade
							.inverseGetAccount(this.getId(), this.getClassId()).iterator().next();
		} catch (java.util.NoSuchElementException nsee){}
		return result;
    }
    public PersistentBank getBank() 
				throws PersistenceException{
        PersistentBank result = null;
		try {
			if (result == null) result = (PersistentBank)ConnectionHandler.getTheConnectionHandler().theBankFacade
							.inverseGetAccounts(this.getId(), this.getClassId()).iterator().next();
		} catch (java.util.NoSuchElementException nsee){}
		return result;
    }
    public PersistentAccountDebitTransferTransactions getDebitTransferTransactions() 
				throws PersistenceException{
        if (this.debitTransferTransactions == null) {
			this.setDebitTransferTransactions(model.AccountDebitTransferTransactions.createAccountDebitTransferTransactions(this.isDelayed$Persistence()));
			this.debitTransferTransactions.setObserver(this);
		}
		return this.debitTransferTransactions;
    }
    public PersistentDebitGrantListe getGrantedDebitGrant() 
				throws PersistenceException{
        if (this.grantedDebitGrant== null) return null;
		return this.grantedDebitGrant.getObservee();
    }
    public PersistentDebitGrantListe getReceivedDebitGrant() 
				throws PersistenceException{
        if (this.receivedDebitGrant== null) return null;
		return this.receivedDebitGrant.getObservee();
    }
    public PersistentTriggerListe getTriggerListe() 
				throws PersistenceException{
        if (this.triggerListe== null) return null;
		return this.triggerListe.getObservee();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentAccount)This);
		if(this.equals(This)){
			this.setAccountNumber((Long)final$$Fields.get("accountNumber"));
			this.setMoney((PersistentMoney)final$$Fields.get("money"));
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
    public void remove(final PersistentAccountPx acc, final PersistentDebitGrantListe list) 
				throws PersistenceException{
        model.meta.AccountRemoveAccountPxDebitGrantListeMssg event = new model.meta.AccountRemoveAccountPxDebitGrantListeMssg(acc, list, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
    }
    public void setGrantedDebitGrant(final PersistentDebitGrantListe grantedDebitGrant) 
				throws PersistenceException{
        if (this.grantedDebitGrant == null) {
			this.setGrantedDebitGrant(model.AccountGrantedDebitGrant.createAccountGrantedDebitGrant(this.isDelayed$Persistence()));
			this.grantedDebitGrant.setObserver(getThis());
		}
		this.grantedDebitGrant.setObservee(grantedDebitGrant);
    }
    public void setReceivedDebitGrant(final PersistentDebitGrantListe receivedDebitGrant) 
				throws PersistenceException{
        if (this.receivedDebitGrant == null) {
			this.setReceivedDebitGrant(model.AccountReceivedDebitGrant.createAccountReceivedDebitGrant(this.isDelayed$Persistence()));
			this.receivedDebitGrant.setObserver(getThis());
		}
		this.receivedDebitGrant.setObservee(receivedDebitGrant);
    }
    public void setTriggerListe(final PersistentTriggerListe triggerListe) 
				throws PersistenceException{
        if (this.triggerListe == null) {
			this.setTriggerListe(model.AccountTriggerListe.createAccountTriggerListe(this.isDelayed$Persistence()));
			this.triggerListe.setObserver(getThis());
		}
		this.triggerListe.setObservee(triggerListe);
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
    
    public void addToTransactionTemplate(final PersistentTransaction transaction, final DebitTransferSearchList debitTransfer) 
				throws PersistenceException{
    	 transaction.addToTransaction(debitTransfer);
         getThis().getDebitTransferTransactions().removeFirstSuccess(new Predcate<PersistentDebitTransferTransaction>() {
 			@Override
 			public boolean test(final PersistentDebitTransferTransaction argument)
 					throws PersistenceException {
 				PersistentDebitTransfer result = debitTransfer.findFirst(new Predcate<PersistentDebitTransfer>() {
 					@Override
 					public boolean test(PersistentDebitTransfer argument2)
 							throws PersistenceException {
 						return argument.equals(argument2);
 					}
 				});
 				if(result == null) {
 					return false;
 				}
 				return true;
 			}
 		});
    }
    public void addToTransaction(final PersistentTransaction transaction, final DebitTransferSearchList debitTransfer) 
				throws PersistenceException{
    	transaction.addToTransaction(debitTransfer);
    	 getThis().getDebitTransferTransactions().removeFirstSuccess(new Predcate<PersistentDebitTransferTransaction>() {
 			@Override
 			public boolean test(final PersistentDebitTransferTransaction argument)
 					throws PersistenceException {
 				PersistentDebitTransfer result = debitTransfer.findFirst(new Predcate<PersistentDebitTransfer>() {
 					@Override
 					public boolean test(PersistentDebitTransfer argument2)
 							throws PersistenceException {
 						return argument.equals(argument2);
 					}
 				});
 				if(result == null) {
 					return false;
 				}
 				return true;
 			}
 		});
    }
    public void changeCurrency(final PersistentDebitTransfer trans, final PersistentCurrency currency) 
				throws PersistenceException{
        trans.changeCurrency(currency);
    }
    public void changeMoney(final PersistentDebitTransfer trans, final common.Fraction newAmount) 
				throws PersistenceException{
        trans.changeMoney(newAmount);
    }
    public void changeReceiverAccount(final PersistentDebitTransfer trans, final long receiverAccountNumber) 
				throws PersistenceException{
    	trans.changeReceiverAccount(receiverAccountNumber);
    }
    public void changeReceiverBank(final PersistentDebitTransfer trans, final long receiverBankNumber) 
				throws PersistenceException{
    	trans.changeReceiverBank(receiverBankNumber);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
    }
    public void createDebitGrantImplementation(final PersistentAccount receiver, final PersistentLimitType limit) 
				throws model.GrantAlreadyGivenException, PersistenceException{
    	PersistentAccountPx receiverAccPx = AccountPx.createAccountPx(receiver);
        getThis().getReceivedDebitGrant().createDebitGrant(receiverAccPx, limit);
        System.out.println("create"+getThis().getGrantedDebitGrant().getDebitGrants());
        
        PersistentAccountPx thisAccPx = AccountPx.createAccountPx(getThis());
        receiver.getGrantedDebitGrant().createDebitGrant(thisAccPx, limit);
        System.out.println("create"+receiver.getReceivedDebitGrant().getDebitGrants());
        
        
    }
    public PersistentDebit createDebit() 
				throws PersistenceException{
    	PersistentDebit a = Debit.createDebit();
    	a.setSender(getThis());
        getThis().getDebitTransferTransactions().add(a);
    	return a;
    }
    public PersistentDebitTransferTransaction createTemplate(final String type) 
				throws PersistenceException{
    	PersistentDebitTransferTransaction result = StringFACTORY.createObjectBySubTypeNameForDebitTransferTransaction(type, new DebitTransferTransactionSwitchPARAMETER() {
			public PersistentTransfer handleTransfer() throws PersistenceException {
		    	PersistentTransfer template = Transfer.createTransfer();
		    	template.setSender(getThis());
		    	template.changeState(TemplateState.createTemplateState());
		    	getThis().getDebitTransferTransactions().add(template);
		    	return template;
			}
			public PersistentTransaction handleTransaction() throws PersistenceException {
		    	PersistentTransaction template = Transaction.createTransaction();
		    	template.setSender(getThis());
		    	template.changeState(TemplateState.createTemplateState());
		    	getThis().getDebitTransferTransactions().add(template);
		    	return template;
			}
			public PersistentDebit handleDebit() throws PersistenceException {
		    	PersistentDebit template = Debit.createDebit();
		    	template.setSender(getThis());
		    	template.changeState(TemplateState.createTemplateState());
		    	getThis().getDebitTransferTransactions().add(template);
		    	return template;
			}
		});
    	return result;
    }
    public PersistentTransaction createTransaction() 
				throws PersistenceException{
        PersistentTransaction transaction = Transaction.createTransaction();
        transaction.setSender(getThis());
        getThis().getDebitTransferTransactions().add(transaction);
        return transaction;
    }
    public PersistentTransfer createTransfer() 
				throws PersistenceException{
		PersistentTransfer transfer = Transfer.createTransfer();
		transfer.setSender(getThis());
		getThis().getDebitTransferTransactions().add(transfer);
		return transfer;
    }
    public PersistentTrigger createTrigger(final String name, final PersistentDebitTransferTransaction dtt) 
				throws PersistenceException{
    	PersistentTrigger trigger = Trigger.createTrigger(name);
    	dtt.changeState(NotExecutableState.createNotExecutableState());
    	trigger.setAction(dtt);
    	getThis().getTriggerListe().add(trigger);
    	return trigger;
    }
    public void debitTransferTransactions_update(final model.meta.DebitTransferTransactionMssgs event) 
				throws PersistenceException{
    	System.out.println("react!"+getThis()+event);
        getThis().getAccountService().getEventhandle().reactOnEvent(event);
        
        this.checkTrigger(event);
    }
    public void grantedDebitGrant_update(final model.meta.DebitGrantListeMssgs event) 
				throws PersistenceException{
        event.accept(new DebitGrantListeMssgsVisitor() {
			@Override
			public void handleDebitGrantListeCreateDebitGrantAccountPxLimitTypeMssg(
					DebitGrantListeCreateDebitGrantAccountPxLimitTypeMssg event)
					throws PersistenceException {
				getThis().getAccountService().signalChanged(true);
			}

			@Override
			public void handleDebitGrantListeRemoveAccountPxMssg(
					DebitGrantListeRemoveAccountPxMssg event)
					throws PersistenceException {
				getThis().getAccountService().signalChanged(true);
			}
		});
    }
    public void initializeOnCreation() 
				throws PersistenceException{
    	getThis().setTriggerListe(TriggerListe.createTriggerListe());
    	getThis().getMoney().getCurrency();
    	PersistentLimitAccount limits = LimitAccount.createLimitAccount();
    	limits.setMinLimit(NoLimit.getTheNoLimit());
    	limits.setMaxLimit(NoLimit.getTheNoLimit());
    	getThis().setLimit(limits);
    	getThis().setGrantedDebitGrant(DebitGrantListe.createDebitGrantListe());
    	getThis().setReceivedDebitGrant(DebitGrantListe.createDebitGrantListe());
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
    }
    public void receivedDebitGrant_update(final model.meta.DebitGrantListeMssgs event) 
				throws PersistenceException{
    	event.accept(new DebitGrantListeMssgsVisitor() {
			@Override
			public void handleDebitGrantListeCreateDebitGrantAccountPxLimitTypeMssg(
					DebitGrantListeCreateDebitGrantAccountPxLimitTypeMssg event)
					throws PersistenceException {
					getThis().getAccountService().signalChanged(true);
			}

			@Override
			public void handleDebitGrantListeRemoveAccountPxMssg(
					DebitGrantListeRemoveAccountPxMssg event)
					throws PersistenceException {
				getThis().getAccountService().signalChanged(true);
			}
		});
}
    public void removeImplementation(final PersistentAccountPx acc, final PersistentDebitGrantListe list) 
				throws PersistenceException{
        list.remove(acc);
    }
    public void triggerListe_update(final model.meta.TriggerListeMssgs event) 
				throws PersistenceException{
        //TODO: implement method: triggerListe_update
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    private void checkTrigger(DebitTransferTransactionMssgs event) throws PersistenceException {
		event.accept(new DebitTransferTransactionMssgsVisitor() {
			public void handleDebitTransferChangeReceiverBankIntegerMssg(DebitTransferChangeReceiverBankIntegerMssg event) throws PersistenceException {}
			public void handleDebitTransferChangeReceiverAccountIntegerMssg(DebitTransferChangeReceiverAccountIntegerMssg event) throws PersistenceException {}
			public void handleDebitTransferChangeMoneyFractionMssg(DebitTransferChangeMoneyFractionMssg event) throws PersistenceException {}
			public void handleDebitTransferChangeCurrencyCurrencyMssg(DebitTransferChangeCurrencyCurrencyMssg event) throws PersistenceException {}
			public void handleDebitTransferTransactionChangeStateDebitTransferStateMssg(DebitTransferTransactionChangeStateDebitTransferStateMssg event) throws PersistenceException {}
			
			public void handleDebitTransferTransactionExecuteMssg(DebitTransferTransactionExecuteMssg event) throws PersistenceException {
				try {
					final PersistentDebitTransferTransaction t = event.getResult();
					t.accept(new DebitTransferTransactionVisitor() {
						public void handleTransfer(PersistentTransfer transfer) throws PersistenceException {
							Account.this.executeTrigger(transfer);
						}
						public void handleDebit(PersistentDebit debit) throws PersistenceException {
							Account.this.executeTrigger(debit);
						}
						public void handleTransaction(PersistentTransaction transaction) throws PersistenceException {}
					});
					
					
				} catch (ExecuteException e) {
					// Execute will be rolled back - no trigger!
				}
				
				
			}

			
		});
		
	}

	private void executeTrigger(final PersistentDebitTransfer t) throws PersistenceException {
		System.out.println("exec"+t);
		System.out.println("triggerlist" + getThis().getTriggerListe().getTriggers().getLength());
		getThis().getTriggerListe().getTriggers().applyToAll(new Procdure<PersistentTrigger>() {
			public void doItTo(PersistentTrigger argument) throws PersistenceException {
				try {
					argument.getRules().applyToAllException(new ProcdureException<PersistentRule, RuleNotMatchedException>() {
						public void doItTo(PersistentRule argument) throws PersistenceException, RuleNotMatchedException {
//							TODO Trigger matcht auf jede Rule!!
//							if (!(argument.check(t).isTrue())) {
//								throw new RuleNotMatchedException();
//							}
							System.out.println("matched");
							
						}
					});
				} catch (RuleNotMatchedException e) {
					// trigger action will not be executed
					return;
				}
				System.out.println("execute independent");
				argument.getAction().execute(getThis().getAccountService());
			}});
		
	}
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
