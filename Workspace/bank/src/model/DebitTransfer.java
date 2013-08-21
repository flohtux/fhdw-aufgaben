
package model;

import java.sql.Timestamp;
import java.util.Date;

import model.visitor.DebitTransferStateExceptionVisitor;
import persistence.*;


/* Additional import section end */

public abstract class DebitTransfer extends model.DebitTransferTransaction implements PersistentDebitTransfer{
    
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("receiverAccountNumber", new Long(this.getReceiverAccountNumber()).toString());
            result.put("receiverBankNumber", new Long(this.getReceiverBankNumber()).toString());
            AbstractPersistentRoot sender = (AbstractPersistentRoot)this.getSender();
            if (sender != null) {
                result.put("sender", sender.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    sender.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && sender.hasEssentialFields())sender.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot money = (AbstractPersistentRoot)this.getMoney();
            if (money != null) {
                result.put("money", money.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    money.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && money.hasEssentialFields())money.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("subject", this.getSubject());
            AbstractPersistentRoot state = (AbstractPersistentRoot)this.getState();
            if (state != null) {
                result.put("state", state.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    state.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && state.hasEssentialFields())state.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
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
    protected PersistentAccount sender;
    protected PersistentMoney money;
    protected String subject;
    protected PersistentDebitTransferState state;
    protected PersistentStornoState stornoState;
    
    public DebitTransfer(java.sql.Timestamp timestamp,SubjInterface subService,PersistentDebitTransferTransaction This,long receiverAccountNumber,long receiverBankNumber,PersistentAccount sender,PersistentMoney money,String subject,PersistentDebitTransferState state,PersistentStornoState stornoState,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((java.sql.Timestamp)timestamp,(SubjInterface)subService,(PersistentDebitTransferTransaction)This,id);
        this.receiverAccountNumber = receiverAccountNumber;
        this.receiverBankNumber = receiverBankNumber;
        this.sender = sender;
        this.money = money;
        this.subject = subject;
        this.state = state;
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
        if(this.getSender() != null){
            this.getSender().store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferFacade.senderSet(this.getId(), getSender());
        }
        if(this.getMoney() != null){
            this.getMoney().store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferFacade.moneySet(this.getId(), getMoney());
        }
        if(this.getState() != null){
            this.getState().store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferFacade.stateSet(this.getId(), getState());
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
    public PersistentAccount getSender() throws PersistenceException {
        return this.sender;
    }
    public void setSender(PersistentAccount newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.sender)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.sender = (PersistentAccount)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferFacade.senderSet(this.getId(), newValue);
        }
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
    public String getSubject() throws PersistenceException {
        return this.subject;
    }
    public void setSubject(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theDebitTransferFacade.subjectSet(this.getId(), newValue);
        this.subject = newValue;
    }
    public PersistentDebitTransferState getState() throws PersistenceException {
        return this.state;
    }
    public void setState(PersistentDebitTransferState newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.state)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.state = (PersistentDebitTransferState)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferFacade.stateSet(this.getId(), newValue);
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

    /* End of protected part that is not overridden by persistence generator */
    
}
