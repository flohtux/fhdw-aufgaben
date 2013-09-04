
package model;

import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentCurrency;
import persistence.PersistentDebitTransfer;
import persistence.PersistentDebitTransferState;
import persistence.PersistentDebitTransferTransaction;
import persistence.PersistentMoney;
import persistence.PersistentProxi;
import persistence.PersistentStornoState;
import persistence.SubjInterface;
import persistence.TDObserver;

import common.Fraction;


/* Additional import section end */

public abstract class DebitTransfer extends model.DebitTransferTransaction implements PersistentDebitTransfer{
    
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("receiverAccountNumber", new Long(this.getReceiverAccountNumber()).toString());
            result.put("receiverBankNumber", new Long(this.getReceiverBankNumber()).toString());
            AbstractPersistentRoot money = (AbstractPersistentRoot)this.getMoney();
            if (money != null) {
                result.put("money", money.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    money.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && money.hasEssentialFields())money.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot stornoState = (AbstractPersistentRoot)this.getStornoState();
            if (stornoState != null) {
                result.put("stornoState", stornoState.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    stornoState.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && stornoState.hasEssentialFields())stornoState.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public abstract DebitTransfer provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected long receiverAccountNumber;
    protected long receiverBankNumber;
    protected PersistentMoney money;
    protected PersistentStornoState stornoState;
    
    public DebitTransfer(java.sql.Timestamp timestamp,String subject,PersistentAccount sender,PersistentDebitTransferState state,SubjInterface subService,PersistentDebitTransferTransaction This,long receiverAccountNumber,long receiverBankNumber,PersistentMoney money,PersistentStornoState stornoState,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((java.sql.Timestamp)timestamp,(String)subject,(PersistentAccount)sender,(PersistentDebitTransferState)state,(SubjInterface)subService,(PersistentDebitTransferTransaction)This,id);
        this.receiverAccountNumber = receiverAccountNumber;
        this.receiverBankNumber = receiverBankNumber;
        this.money = money;
        this.stornoState = stornoState;        
    }
    
    static public long getTypeId() {
        return 176;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        if(this.getMoney() != null){
            this.getMoney().store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferFacade.moneySet(this.getId(), getMoney());
        }
        if(this.getStornoState() != null){
            this.getStornoState().store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferFacade.stornoStateSet(this.getId(), getStornoState());
        }
        
    }
    
    public long getReceiverAccountNumber() throws PersistenceException {
        return this.receiverAccountNumber;
    }
    public void setReceiverAccountNumber(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theDebitTransferFacade.receiverAccountNumberSet(this.getId(), newValue);
        this.receiverAccountNumber = newValue;
    }
    public long getReceiverBankNumber() throws PersistenceException {
        return this.receiverBankNumber;
    }
    public void setReceiverBankNumber(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theDebitTransferFacade.receiverBankNumberSet(this.getId(), newValue);
        this.receiverBankNumber = newValue;
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
            ConnectionHandler.getTheConnectionHandler().theDebitTransferFacade.moneySet(this.getId(), newValue);
        }
    }
    public PersistentStornoState getStornoState() throws PersistenceException {
        return this.stornoState;
    }
    public void setStornoState(PersistentStornoState newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.stornoState)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.stornoState = (PersistentStornoState)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferFacade.stornoStateSet(this.getId(), newValue);
        }
    }
    public abstract PersistentDebitTransfer getThis() throws PersistenceException ;
    
    
    
    public void changeCurrency(final PersistentCurrency currency) 
				throws PersistenceException{
        model.meta.DebitTransferChangeCurrencyCurrencyMssg event = new model.meta.DebitTransferChangeCurrencyCurrencyMssg(currency, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
    }
    public void changeMoney(final common.Fraction newAmount) 
				throws PersistenceException{
        model.meta.DebitTransferChangeMoneyFractionMssg event = new model.meta.DebitTransferChangeMoneyFractionMssg(newAmount, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
    }
    public void changeReceiverAccount(final long receiverAccountNumber) 
				throws PersistenceException{
        model.meta.DebitTransferChangeReceiverAccountIntegerMssg event = new model.meta.DebitTransferChangeReceiverAccountIntegerMssg(receiverAccountNumber, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
    }
    public void changeReceiverBank(final long receiverBankNumber) 
				throws PersistenceException{
        model.meta.DebitTransferChangeReceiverBankIntegerMssg event = new model.meta.DebitTransferChangeReceiverBankIntegerMssg(receiverBankNumber, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentDebitTransfer)This);
		if(this.equals(This)){
		}
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
    
    public void changeCurrencyImplementation(final PersistentCurrency currency) 
				throws PersistenceException{
		getThis().getMoney().setCurrency(currency);
	}
    public void changeReceiverAccountImplementation(final long receiverAccountNumber) 
				throws PersistenceException{
		getThis().setReceiverAccountNumber(receiverAccountNumber);
	}
    public void changeReceiverBankImplementation(final long receiverBankNumber) 
				throws PersistenceException{
		getThis().setReceiverBankNumber(receiverBankNumber);
	}
    public void changeMoneyImplementation(Fraction newAmount) throws PersistenceException {
    	getThis().getMoney().getAmount().setBalance(newAmount);
}
    /* End of protected part that is not overridden by persistence generator */
    
}
