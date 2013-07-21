
package model;

import persistence.*;


/* Additional import section end */

public abstract class DebitNoteTransfer extends model.DebitNoteTransferTransaction implements PersistentDebitNoteTransfer{
    
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot sender = (AbstractPersistentRoot)this.getSender();
            if (sender != null) {
                result.put("sender", sender.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    sender.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && sender.hasEssentialFields())sender.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot receiver = (AbstractPersistentRoot)this.getReceiver();
            if (receiver != null) {
                result.put("receiver", receiver.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    receiver.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && receiver.hasEssentialFields())receiver.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
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
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public abstract DebitNoteTransfer provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAccount sender;
    protected PersistentAccount receiver;
    protected PersistentMoney money;
    
    public DebitNoteTransfer(SubjInterface subService,PersistentDebitNoteTransferTransaction This,PersistentAccount sender,PersistentAccount receiver,PersistentMoney money,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((SubjInterface)subService,(PersistentDebitNoteTransferTransaction)This,id);
        this.sender = sender;
        this.receiver = receiver;
        this.money = money;        
    }
    
    static public long getTypeId() {
        return 141;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        if(this.getSender() != null){
            this.getSender().store();
            ConnectionHandler.getTheConnectionHandler().theDebitNoteTransferFacade.senderSet(this.getId(), getSender());
        }
        if(this.getReceiver() != null){
            this.getReceiver().store();
            ConnectionHandler.getTheConnectionHandler().theDebitNoteTransferFacade.receiverSet(this.getId(), getReceiver());
        }
        if(this.getMoney() != null){
            this.getMoney().store();
            ConnectionHandler.getTheConnectionHandler().theDebitNoteTransferFacade.moneySet(this.getId(), getMoney());
        }
        
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
            ConnectionHandler.getTheConnectionHandler().theDebitNoteTransferFacade.senderSet(this.getId(), newValue);
        }
    }
    public PersistentAccount getReceiver() throws PersistenceException {
        return this.receiver;
    }
    public void setReceiver(PersistentAccount newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.receiver)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.receiver = (PersistentAccount)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitNoteTransferFacade.receiverSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theDebitNoteTransferFacade.moneySet(this.getId(), newValue);
        }
    }
    public abstract PersistentDebitNoteTransfer getThis() throws PersistenceException ;
    
    
    
    public void initialize(Anything This, java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentDebitNoteTransfer)This);
		if(this.equals(This)){
			this.setMoney((PersistentMoney)final$$Fields.get("money"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(Anything copy) 
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
