
package model;

import model.meta.StringFACTORY;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.DebitTransferExceptionVisitor;
import model.visitor.SubjInterfaceExceptionVisitor;
import model.visitor.SubjInterfaceReturnExceptionVisitor;
import model.visitor.SubjInterfaceReturnVisitor;
import model.visitor.SubjInterfaceVisitor;
import model.visitor.TransactionFeeReturnExceptionVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.BankProxi;
import persistence.BankSearchList;
import persistence.Bank_AccountsProxi;
import persistence.Bank_CurrentAccountsProxi;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.ObsInterface;
import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentAccountService;
import persistence.PersistentAdministrator;
import persistence.PersistentBank;
import persistence.PersistentBankFees;
import persistence.PersistentBankOwnAccountPx;
import persistence.PersistentBankService;
import persistence.PersistentChangeNameCommand;
import persistence.PersistentCreateAccountCommand;
import persistence.PersistentCurrency;
import persistence.PersistentDebit;
import persistence.PersistentDebitGrant;
import persistence.PersistentDebitTransfer;
import persistence.PersistentFixTransactionFee;
import persistence.PersistentInternalFee;
import persistence.PersistentMixedFee;
import persistence.PersistentMoney;
import persistence.PersistentObject;
import persistence.PersistentPercent;
import persistence.PersistentProcentualFee;
import persistence.PersistentProxi;
import persistence.PersistentServer;
import persistence.PersistentTransactionFee;
import persistence.PersistentTransfer;
import persistence.Predcate;
import persistence.SubjInterface;
import persistence.TDObserver;

import common.Fraction;


/* Additional import section end */

public class Bank extends PersistentObject implements PersistentBank{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentBank getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theBankFacade.getClass(objectId);
        return (PersistentBank)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentBank createBank(String name,PersistentBankOwnAccountPx ownAccount,PersistentAdministrator administrator) throws PersistenceException{
        return createBank(name,ownAccount,administrator,false);
    }
    
    public static PersistentBank createBank(String name,PersistentBankOwnAccountPx ownAccount,PersistentAdministrator administrator,boolean delayed$Persistence) throws PersistenceException {
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
        final$$Fields.put("ownAccount", ownAccount);
        final$$Fields.put("administrator", administrator);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        if(result.getThis().getBankFees() == null)throw new PersistenceException("Field bankFees in type Bank has not been initialized!",0);
        return result;
    }
    
    public static PersistentBank createBank(String name,PersistentBankOwnAccountPx ownAccount,PersistentAdministrator administrator,boolean delayed$Persistence,PersistentBank This) throws PersistenceException {
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
        final$$Fields.put("ownAccount", ownAccount);
        final$$Fields.put("administrator", administrator);
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
            AbstractPersistentRoot bankFees = (AbstractPersistentRoot)this.getBankFees();
            if (bankFees != null) {
                result.put("bankFees", bankFees.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    bankFees.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && bankFees.hasEssentialFields())bankFees.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot ownAccount = (AbstractPersistentRoot)this.getOwnAccount();
            if (ownAccount != null) {
                result.put("ownAccount", ownAccount.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    ownAccount.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && ownAccount.hasEssentialFields())ownAccount.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
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
                          this.bankFees, 
                          this.ownAccount, 
                          this.administrator, 
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
    protected PersistentBankFees bankFees;
    protected PersistentBankOwnAccountPx ownAccount;
    protected Bank_AccountsProxi accounts;
    protected PersistentAdministrator administrator;
    protected Bank_CurrentAccountsProxi currentAccounts;
    protected SubjInterface subService;
    protected PersistentBank This;
    
    public Bank(long bankNumber,String name,long lastAccountNumber,PersistentBankFees bankFees,PersistentBankOwnAccountPx ownAccount,PersistentAdministrator administrator,SubjInterface subService,PersistentBank This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.bankNumber = bankNumber;
        this.name = name;
        this.lastAccountNumber = lastAccountNumber;
        this.bankFees = bankFees;
        this.ownAccount = ownAccount;
        this.accounts = new Bank_AccountsProxi(this);
        this.administrator = administrator;
        this.currentAccounts = new Bank_CurrentAccountsProxi(this);
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return -149;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == -149) ConnectionHandler.getTheConnectionHandler().theBankFacade
            .newBank(0,name,0,this.getId());
        super.store();
        if(this.getBankFees() != null){
            this.getBankFees().store();
            ConnectionHandler.getTheConnectionHandler().theBankFacade.bankFeesSet(this.getId(), getBankFees());
        }
        if(this.getOwnAccount() != null){
            this.getOwnAccount().store();
            ConnectionHandler.getTheConnectionHandler().theBankFacade.ownAccountSet(this.getId(), getOwnAccount());
        }
        this.getAccounts().store();
        if(this.getAdministrator() != null){
            this.getAdministrator().store();
            ConnectionHandler.getTheConnectionHandler().theBankFacade.administratorSet(this.getId(), getAdministrator());
        }
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
    public PersistentBankFees getBankFees() throws PersistenceException {
        return this.bankFees;
    }
    public void setBankFees(PersistentBankFees newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.bankFees)) return;
        if(getThis().getBankFees() != null)throw new PersistenceException("Final field bankFees in type Bank has been set already!",0);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.bankFees = (PersistentBankFees)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theBankFacade.bankFeesSet(this.getId(), newValue);
        }
    }
    public PersistentBankOwnAccountPx getOwnAccount() throws PersistenceException {
        return this.ownAccount;
    }
    public void setOwnAccount(PersistentBankOwnAccountPx newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.ownAccount)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.ownAccount = (PersistentBankOwnAccountPx)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theBankFacade.ownAccountSet(this.getId(), newValue);
        }
    }
    public Bank_AccountsProxi getAccounts() throws PersistenceException {
        return this.accounts;
    }
    public PersistentAdministrator getAdministrator() throws PersistenceException {
        return this.administrator;
    }
    public void setAdministrator(PersistentAdministrator newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.administrator)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.administrator = (PersistentAdministrator)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theBankFacade.administratorSet(this.getId(), newValue);
        }
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
        if (this.getOwnAccount() != null) return 1;
        if (this.getBankFees() != null && this.getBankFees().getTheObject().getLeafInfo() != 0) return 1;
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
			this.setOwnAccount((PersistentBankOwnAccountPx)final$$Fields.get("ownAccount"));
			this.setAdministrator((PersistentAdministrator)final$$Fields.get("administrator"));
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
    
    public void addToCurrentAccounts(final PersistentAccount a) 
				throws PersistenceException{
        PersistentAccount contained = getThis().getCurrentAccounts().findFirst(new Predcate<PersistentAccount>() {
			public boolean test(PersistentAccount argument) throws PersistenceException {
				return argument.equals(a);
			}
		});
        if (contained == null) {
        	getThis().getCurrentAccounts().add(a);
        }
    }
    public void changeInternalFee(final common.Fraction procentual) 
				throws model.NoValidPercentValueException, PersistenceException{
    	PersistentPercent percent = Percent.createPercent(new Fraction(100, 1));
    	percent.changeValue(procentual);
    	final PersistentInternalFee newFee = InternalFee.createInternalFee(percent);
    	getThis().getBankFees().changeInternalFee(newFee);
    }
    public void changeNameImplementation(final String name) 
				throws PersistenceException{
        getThis().setName(name);
    }
    public void changeTransactionFeeToFix(final PersistentMoney fix) 
				throws model.NoValidFeeValueException, PersistenceException{
    	if(Fraction.Null.greater(fix.getAmount().getBalance())) {
    		throw new NoValidFeeValueException();
    	}
    	final PersistentFixTransactionFee newFee = FixTransactionFee.createFixTransactionFee(fix);
        getThis().getBankFees().changeTransactionFee(newFee);
    }
    public void changeTransactionFeeToMixed(final PersistentMoney fix, final common.Fraction procentual, final PersistentMoney limit) 
				throws model.NoValidPercentValueException, model.NoValidFeeValueException, PersistenceException{
    	PersistentPercent percent = Percent.createPercent(new Fraction(100, 1));
    	percent.changeValue(procentual);
    	if(Fraction.Null.greater(fix.getAmount().getBalance()) || Fraction.Null.greater(limit.getAmount().getBalance())) {
    		throw new NoValidFeeValueException();
    	}
    	final PersistentMixedFee newFee = MixedFee.createMixedFee(FixTransactionFee.createFixTransactionFee(fix), ProcentualFee.createProcentualFee(percent), limit);
        getThis().getBankFees().changeTransactionFee(newFee);
    }
    public void changeTransactionFeeToProcentual(final common.Fraction procentual) 
				throws model.NoValidPercentValueException, PersistenceException{
    	PersistentPercent percent = Percent.createPercent(new Fraction(100, 1));
    	percent.changeValue(procentual);
    	final PersistentProcentualFee newFee = ProcentualFee.createProcentualFee(percent); 
        getThis().getBankFees().changeTransactionFee(newFee);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
    }
    public void createAccount(final String currencyType) 
				throws PersistenceException{
    	//TODO PREREQUISITES: HashMap: how to put things into HashMaps!
    	getThis().setLastAccountNumber(getThis().getLastAccountNumber() + 1);
        long nextAccountNumber = getThis().getLastAccountNumber();
        PersistentCurrency currency = StringFACTORY.createObjectBySubTypeNameForCurrency(currencyType);
        PersistentMoney money = Money.createMoney(Amount.createAmount(Fraction.parse("0/1")), currency);
        PersistentAccount newAccount = Account.createAccount(nextAccountNumber,money);
        getThis().getAccounts().put(nextAccountNumber, newAccount); // must be performed prior to createAccountName(9!
        getThis().getCurrentAccounts().add(newAccount);
        PersistentAccountService accountService = AccountService.createAccountService(newAccount, getThis().getBankFees());
        PersistentServer accountServer = Server.createServer(serverConstants.ServerConstants.StandardAccountPassword, 
        													 serverConstants.ServerConstants.createAccountName(newAccount), 
        													 0, 
        													 serverConstants.DateConstants.Now);
        accountServer.setService(accountService);
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
    	getThis().setLastAccountNumber(serverConstants.ServerConstants.FirstAccountNumber);
    	PersistentTransactionFee tfee = FixTransactionFee.createFixTransactionFee(Money.createMoney(Amount.createAmount(Fraction.Null), 
    			getThis().getOwnAccount().getAccount().getMoney().getCurrency()));
    	PersistentInternalFee ifee = InternalFee.createInternalFee(Percent.createPercent(Fraction.One));
    	getThis().setBankFees(BankFees.createBankFees(tfee, ifee));
    	
    	getThis().getAdministrator().getBanks().add(BankPx.createBankPx(getThis()));
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
    }
    public void receiveTransfer(final PersistentDebitTransfer debitTransfer) 
				throws model.DebitException, model.InvalidAccountNumberException, PersistenceException{
        final PersistentAccount acc = getThis().searchAccountByAccNumber(debitTransfer.getReceiverAccountNumber());
    	debitTransfer.accept(new DebitTransferExceptionVisitor<DebitException>() {
			public void handleTransfer(PersistentTransfer transfer) throws PersistenceException, DebitException {}
			public void handleDebit(final PersistentDebit debit) throws PersistenceException, DebitException {
				PersistentDebitGrant grant = acc.getReceivedDebitGrant().getDebitGrants().findFirst(new Predcate<PersistentDebitGrant>() {
					public boolean test(PersistentDebitGrant argument) throws PersistenceException {
						return argument.getPermittedAccount().getAccount().equals(debitTransfer.getSender());
					}
				});
				if (grant == null) {
					throw new DebitNotGrantedException();
				} else {
					grant.getLimits().checkMaxLimit(debit.getMoney());
				}
			}
		});
    	acc.getLimit().checkLimit(debitTransfer.fetchRealMoney());
    	debitTransfer.changeState(SuccessfulState.createSuccessfulState());
    	acc.setMoney(acc.getMoney().add(debitTransfer.fetchRealMoney()));
    	acc.getDebitTransferTransactions().add(debitTransfer);
    }
    public PersistentAccount searchAccountByAccNumber(final long accNum) 
				throws model.InvalidAccountNumberException, PersistenceException{
    	PersistentAccount a = getThis().getAccounts().getValues().findFirst(new Predcate<PersistentAccount>() {
			public boolean test(PersistentAccount argument) throws PersistenceException {
				return argument.getAccountNumber() == accNum;
			}
		});
    	if (a == null) {
    		throw new InvalidAccountNumberException(accNum);
    	} else {
    		return a;
    	}
    }
    public void sendTransfer(final PersistentDebitTransfer debitTransfer) 
				throws model.ExecuteException, PersistenceException{
    	try {
        	PersistentBank result = getThis().getAdministrator().searchBankByBankNumber(debitTransfer.getReceiverBankNumber());
    		final PersistentMoney fee = this.calculateFee(debitTransfer.getMoney(), getThis(), debitTransfer.getReceiverBankNumber());
    		final PersistentMoney newAccountMoney = debitTransfer.getSender().getMoney().subtract(fee.add(debitTransfer.fetchRealMoney())); 
    		debitTransfer.getSender().getLimit().checkLimit(newAccountMoney);
    		debitTransfer.getSender().setMoney(newAccountMoney);
    		getThis().getOwnAccount().getAccount().setMoney(getThis().getOwnAccount().getAccount().getMoney().add(fee));
			result.receiveTransfer(debitTransfer);
    	} catch (ExecuteException e) {
    		debitTransfer.changeState(NotExecutedState.createNotExecutedState());
    		throw e;
    	}
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /**
     * Calculate the Fee of <money>.
     * @param m 
     * @param l 
     * @return
     * @throws PersistenceException 
     * @throws LimitViolatedException 
     */
    private PersistentMoney calculateFee(final PersistentMoney money, PersistentBank senderBank, long receiverBankNumber) throws PersistenceException, LimitViolatedException {
    	PersistentMoney fee =  getThis().getBankFees().getFee().accept(new TransactionFeeReturnExceptionVisitor<PersistentMoney, LimitViolatedException>() {
			@Override
			public PersistentMoney handleMixedFee(PersistentMixedFee mixedFee)
					throws PersistenceException, LimitViolatedException {
				PersistentMoney result = Money.createMoney(Amount.createAmount(new Fraction(0, 1)), money.getCurrency());
				result = result.add(mixedFee.getFix().getValue());
				PersistentMoney procentualPart = money.subtract(mixedFee.getLimit());
				if (procentualPart.getAmount().getBalance().isPositive()) {
					result = result.add(procentualPart.multiply(mixedFee.getProcentual().getPercent().getValue()));
				}
				return result;
			}
			@Override
			public PersistentMoney handleFixTransactionFee(
					PersistentFixTransactionFee fixTransactionFee)
					throws PersistenceException, LimitViolatedException {
				return fixTransactionFee.getValue();
			}

			@Override
			public PersistentMoney handleProcentualFee(
					PersistentProcentualFee procentualFee)
					throws PersistenceException, LimitViolatedException {
				return Money.createMoney(Amount.createAmount(money.getAmount().getBalance().multiply(
						procentualFee.getPercent().getValue())), money.getCurrency()); 
			}
		});
    	if (senderBank.getBankNumber() == receiverBankNumber) {
    		fee = fee.subtract(fee.multiply(senderBank.getBankFees().getInternalFee().getPercent().getValue()))	;
    	}
    	return fee;
    }
    
    /* End of protected part that is not overridden by persistence generator */
    
}
