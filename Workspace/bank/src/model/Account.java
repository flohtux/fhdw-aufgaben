
package model;

import persistence.*;
import model.meta.DebitGrantListeCreateDebitGrantAccountPxLimitTypeMssg;
import model.meta.DebitGrantListeMssgsVisitor;
import model.visitor.*;


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
            result.put("debitTransferTransactions", this.getDebitTransferTransactions().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
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
                             this.grantedDebitGrant, 
                             this.receivedDebitGrant, 
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
    protected Account_DebitTransferTransactionsProxi debitTransferTransactions;
    protected PersistentAccountGrantedDebitGrant grantedDebitGrant;
    protected PersistentAccountReceivedDebitGrant receivedDebitGrant;
    protected SubjInterface subService;
    protected PersistentAccount This;
    
    public Account(long accountNumber,PersistentMoney money,PersistentLimitAccount limit,PersistentAccountGrantedDebitGrant grantedDebitGrant,PersistentAccountReceivedDebitGrant receivedDebitGrant,SubjInterface subService,PersistentAccount This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.accountNumber = accountNumber;
        this.money = money;
        this.limit = limit;
        this.debitTransferTransactions = new Account_DebitTransferTransactionsProxi(this);
        this.grantedDebitGrant = grantedDebitGrant;
        this.receivedDebitGrant = receivedDebitGrant;
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
        this.getDebitTransferTransactions().store();
        if(this.grantedDebitGrant != null){
            this.grantedDebitGrant.store();
            ConnectionHandler.getTheConnectionHandler().theAccountFacade.grantedDebitGrantSet(this.getId(), grantedDebitGrant);
        }
        if(this.receivedDebitGrant != null){
            this.receivedDebitGrant.store();
            ConnectionHandler.getTheConnectionHandler().theAccountFacade.receivedDebitGrantSet(this.getId(), receivedDebitGrant);
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
    public Account_DebitTransferTransactionsProxi getDebitTransferTransactions() throws PersistenceException {
        return this.debitTransferTransactions;
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
        return 0;
    }
    
    
    public void createDebitGrant(final PersistentAccount receiver, final PersistentLimitType limit) 
				throws PersistenceException{
        model.meta.AccountCreateDebitGrantAccountLimitTypeMssg event = new model.meta.AccountCreateDebitGrantAccountLimitTypeMssg(receiver, limit, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
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
    
    public void changeCurrency(final PersistentDebitTransfer trans, final PersistentCurrency currency) 
				throws PersistenceException{
        trans.getMoney().setCurrency(currency);
        
    }
    public void changeMoney(final PersistentDebitTransfer trans, final common.Fraction newAmount) 
				throws PersistenceException{
        trans.getMoney().getAmount().setBalance(newAmount);
    }
    public void changeReceiverAccount(final PersistentDebitTransfer trans, final long receiverAccountNumber) 
				throws PersistenceException{

    	trans.setReceiverAccountNumber(receiverAccountNumber);
    }
    public void changeReceiverBank(final PersistentDebitTransfer trans, final long receiverBankNumber) 
				throws PersistenceException{
    	System.out.println("manual change receiverbank");
    	trans.setReceiverBankNumber(receiverBankNumber);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
    }
    public void createDebitGrantImplementation(final PersistentAccount receiver, final PersistentLimitType limit) 
				throws PersistenceException{
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
    public PersistentTransfer createTemplate() 
				throws PersistenceException{
       PersistentTransfer template = Transfer.createTransfer();
       template.setState(TemplateState.getTheTemplateState());
       getThis().getDebitTransferTransactions().add(template);
       return template;
    }
    public PersistentTransfer createTransfer() 
				throws PersistenceException{
		PersistentTransfer transfer = Transfer.createTransfer();
		transfer.setSender(getThis());
		getThis().getDebitTransferTransactions().add(transfer);
		return transfer;
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
		});
    }
    public void initializeOnCreation() 
				throws PersistenceException{
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
		});
}
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
