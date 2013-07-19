
package model;

import persistence.*;
import serverConstants.ServerConstants;
import model.visitor.*;


/* Additional import section end */

public class Bank extends PersistentObject implements PersistentBank{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentBank getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theBankFacade.getClass(objectId);
        return (PersistentBank)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentBank createBank(String name) throws PersistenceException{
        return createBank(name,false);
    }
    
    public static PersistentBank createBank(String name,boolean delayed$Persistence) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentBank result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theBankFacade
                .newDelayedBank(0,name,0);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theBankFacade
                .newBank(0,name,0,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentBank createBank(String name,boolean delayed$Persistence,PersistentBank This) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentBank result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theBankFacade
                .newDelayedBank(0,name,0);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theBankFacade
                .newBank(0,name,0,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("bankNumber", new Long(this.getBankNumber()).toString());
            result.put("name", this.getName());
            AbstractPersistentRoot fee = (AbstractPersistentRoot)this.getFee();
            if (fee != null) {
                result.put("fee", fee.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    fee.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && fee.hasEssentialFields())fee.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("currentAccounts", this.getCurrentAccounts().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public static BankSearchList getBankByBankNumber(long bankNumber) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theBankFacade
            .getBankByBankNumber(bankNumber);
    }
    
    public static BankSearchList getBankByName(String name) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theBankFacade
            .getBankByName(name);
    }
    
    public Bank provideCopy() throws PersistenceException{
        Bank result = this;
        result = new Bank(this.bankNumber, 
                          this.name, 
                          this.lastAccountNumber, 
                          this.fee, 
                          this.subService, 
                          this.This, 
                          this.getId());
        result.currentAccounts = this.currentAccounts.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected long bankNumber;
    protected String name;
    protected long lastAccountNumber;
    protected PersistentTransactionFee fee;
    protected Bank_AccountsProxi accounts;
    protected Bank_CurrentAccountsProxi currentAccounts;
    protected SubjInterface subService;
    protected PersistentBank This;
    
    public Bank(long bankNumber,String name,long lastAccountNumber,PersistentTransactionFee fee,SubjInterface subService,PersistentBank This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.bankNumber = bankNumber;
        this.name = name;
        this.lastAccountNumber = lastAccountNumber;
        this.fee = fee;
        this.accounts = new Bank_AccountsProxi(this);
        this.currentAccounts = new Bank_CurrentAccountsProxi(this);
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return -113;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == -113) ConnectionHandler.getTheConnectionHandler().theBankFacade
            .newBank(0,name,0,this.getId());
        super.store();
        if(this.getFee() != null){
            this.getFee().store();
            ConnectionHandler.getTheConnectionHandler().theBankFacade.feeSet(this.getId(), getFee());
        }
        this.getAccounts().store();
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theBankFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theBankFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public long getBankNumber() throws PersistenceException {
        return this.bankNumber;
    }
    public void setBankNumber(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theBankFacade.bankNumberSet(this.getId(), newValue);
        this.bankNumber = newValue;
    }
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theBankFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    public long getLastAccountNumber() throws PersistenceException {
        return this.lastAccountNumber;
    }
    public void setLastAccountNumber(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theBankFacade.lastAccountNumberSet(this.getId(), newValue);
        this.lastAccountNumber = newValue;
    }
    public PersistentTransactionFee getFee() throws PersistenceException {
        return this.fee;
    }
    public void setFee(PersistentTransactionFee newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.fee)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.fee = (PersistentTransactionFee)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theBankFacade.feeSet(this.getId(), newValue);
        }
    }
    public Bank_AccountsProxi getAccounts() throws PersistenceException {
        return this.accounts;
    }
    public Bank_CurrentAccountsProxi getCurrentAccounts() throws PersistenceException {
        return this.currentAccounts;
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
            ConnectionHandler.getTheConnectionHandler().theBankFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentBank newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentBank)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theBankFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentBank getThis() throws PersistenceException {
        if(this.This == null){
            PersistentBank result = new BankProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentBank)this.This;
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleBank(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBank(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBank(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBank(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleBank(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBank(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBank(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBank(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getFee() != null) return 1;
        if (this.getCurrentAccounts().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void changeName(final String name) 
				throws PersistenceException{
        model.meta.BankChangeNameStringMssg event = new model.meta.BankChangeNameStringMssg(name, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
    }
    public void changeName(final String name, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentChangeNameCommand command = model.meta.ChangeNameCommand.createChangeNameCommand(name, now, now);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createAccount(final String currencyType, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateAccountCommand command = model.meta.CreateAccountCommand.createCreateAccountCommand(currencyType, now, now);
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
    public PersistentBankService getBankServices() 
				throws PersistenceException{
        PersistentBankService result = null;
		try {
			if (result == null) result = (PersistentBankService)ConnectionHandler.getTheConnectionHandler().theBankServiceFacade
							.inverseGetBank(this.getId(), this.getClassId()).iterator().next();
		} catch (java.util.NoSuchElementException nsee){}
		return result;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentBank)This);
		if(this.equals(This)){
			this.setName((String)final$$Fields.get("name"));
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
    
    public void changeNameImplementation(final String name) 
				throws PersistenceException{
        getThis().setName(name);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
    }
    public void createAccount(final String currencyType) 
				throws PersistenceException{
        //TODO: implement method: createAccount
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
    	getThis().setLastAccountNumber(serverConstants.ServerConstants.FirstAccountNumber);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}