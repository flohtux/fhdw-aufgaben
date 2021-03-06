package persistence;

import java.util.HashMap;

abstract class ICProxiFactory {
	  abstract PersistentInCacheProxi create(long objectId);
}

public abstract class PersistentInCacheProxi extends PersistentRoot {

	  private static ICProxiFactory [] iCProxiFactories;
		
	  private static ICProxiFactory [] getTheICProxiFactories(){
		if (iCProxiFactories == null){
			iCProxiFactories = new ICProxiFactory[186];
        iCProxiFactories[104] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AccountReceivedDebitGrantICProxi(objectId);
            }
        };
        iCProxiFactories[153] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CompensationICProxi(objectId);
            }
        };
        iCProxiFactories[1] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new SubjICProxi(objectId);
            }
        };
        iCProxiFactories[2] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ChangeNameCommandICProxi(objectId);
            }
        };
        iCProxiFactories[110] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new DebitTransferListeICProxi(objectId);
            }
        };
        iCProxiFactories[78] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CurrencyManagerICProxi(objectId);
            }
        };
        iCProxiFactories[9] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ExecutedStateICProxi(objectId);
            }
        };
        iCProxiFactories[67] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new TrueValueICProxi(objectId);
            }
        };
        iCProxiFactories[11] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new PercentICProxi(objectId);
            }
        };
        iCProxiFactories[172] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ExchangeRateWrapperICProxi(objectId);
            }
        };
        iCProxiFactories[74] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new SuccessfulStateICProxi(objectId);
            }
        };
        iCProxiFactories[154] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ExecuteCompensationCommandICProxi(objectId);
            }
        };
        iCProxiFactories[145] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new NoTriggerICProxi(objectId);
            }
        };
        iCProxiFactories[161] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new BankOwnAccountPxICProxi(objectId);
            }
        };
        iCProxiFactories[19] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ProcentualFeeICProxi(objectId);
            }
        };
        iCProxiFactories[152] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ChangeSubjectCommandICProxi(objectId);
            }
        };
        iCProxiFactories[20] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ServerICProxi(objectId);
            }
        };
        iCProxiFactories[107] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new DebitTransferTemplateICProxi(objectId);
            }
        };
        iCProxiFactories[97] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateDebitGrantCommandICProxi(objectId);
            }
        };
        iCProxiFactories[162] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new WaitingStateICProxi(objectId);
            }
        };
        iCProxiFactories[129] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new SubjectRuleICProxi(objectId);
            }
        };
        iCProxiFactories[133] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new TriggerListeICProxi(objectId);
            }
        };
        iCProxiFactories[182] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CompensationRequestedStateICProxi(objectId);
            }
        };
        iCProxiFactories[177] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new WaitingCompensationStateICProxi(objectId);
            }
        };
        iCProxiFactories[136] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new DisabledStateICProxi(objectId);
            }
        };
        iCProxiFactories[112] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ExecuteCommandICProxi(objectId);
            }
        };
        iCProxiFactories[181] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CompensatedStateICProxi(objectId);
            }
        };
        iCProxiFactories[178] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new SuccessfulCompensationStateICProxi(objectId);
            }
        };
        iCProxiFactories[25] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new DollarICProxi(objectId);
            }
        };
        iCProxiFactories[119] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AccountServiceSuccessfulICProxi(objectId);
            }
        };
        iCProxiFactories[27] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new LimitICProxi(objectId);
            }
        };
        iCProxiFactories[116] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ChangeReceiverAccountCommandICProxi(objectId);
            }
        };
        iCProxiFactories[28] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new MixedFeeICProxi(objectId);
            }
        };
        iCProxiFactories[155] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CompensationRequestICProxi(objectId);
            }
        };
        iCProxiFactories[170] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AccountAllCompensationICProxi(objectId);
            }
        };
        iCProxiFactories[102] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AccountPxICProxi(objectId);
            }
        };
        iCProxiFactories[175] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new NoDebitTransferICProxi(objectId);
            }
        };
        iCProxiFactories[82] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AdministratorCurrencyManagerICProxi(objectId);
            }
        };
        iCProxiFactories[108] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new UseTemplateCommandICProxi(objectId);
            }
        };
        iCProxiFactories[34] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ErrorDisplayICProxi(objectId);
            }
        };
        iCProxiFactories[36] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new EuroICProxi(objectId);
            }
        };
        iCProxiFactories[38] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CommandCoordinatorICProxi(objectId);
            }
        };
        iCProxiFactories[125] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AccountDebitTransferTransactionsICProxi(objectId);
            }
        };
        iCProxiFactories[117] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ChangeMoneyCommandICProxi(objectId);
            }
        };
        iCProxiFactories[131] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new MoneyRuleICProxi(objectId);
            }
        };
        iCProxiFactories[47] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new MoneyICProxi(objectId);
            }
        };
        iCProxiFactories[168] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AllCompensationListeOutgoingCompensationsICProxi(objectId);
            }
        };
        iCProxiFactories[120] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AccountServiceNotExecutedICProxi(objectId);
            }
        };
        iCProxiFactories[81] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new PfundICProxi(objectId);
            }
        };
        iCProxiFactories[90] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new DebitGrantICProxi(objectId);
            }
        };
        iCProxiFactories[51] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new BankCreatorICProxi(objectId);
            }
        };
        iCProxiFactories[164] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AcceptedStateICProxi(objectId);
            }
        };
        iCProxiFactories[65] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new FalseValueICProxi(objectId);
            }
        };
        iCProxiFactories[160] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AllCompensationListeICProxi(objectId);
            }
        };
        iCProxiFactories[105] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AccountGrantedDebitGrantICProxi(objectId);
            }
        };
        iCProxiFactories[6] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateAccountCommandICProxi(objectId);
            }
        };
        iCProxiFactories[7] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new FixTransactionFeeICProxi(objectId);
            }
        };
        iCProxiFactories[8] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new InternalFeeICProxi(objectId);
            }
        };
        iCProxiFactories[127] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new DebitTransferDoubleStateICProxi(objectId);
            }
        };
        iCProxiFactories[10] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CommonDateICProxi(objectId);
            }
        };
        iCProxiFactories[114] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ChangeReceiverBankCommandICProxi(objectId);
            }
        };
        iCProxiFactories[41] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new NotSuccessfulStateICProxi(objectId);
            }
        };
        iCProxiFactories[121] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AccountServiceTemplateICProxi(objectId);
            }
        };
        iCProxiFactories[128] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new IncomingAccountRuleICProxi(objectId);
            }
        };
        iCProxiFactories[14] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AmountICProxi(objectId);
            }
        };
        iCProxiFactories[15] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new NoLimitICProxi(objectId);
            }
        };
        iCProxiFactories[16] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AdministratorICProxi(objectId);
            }
        };
        iCProxiFactories[17] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateBankCommandICProxi(objectId);
            }
        };
        iCProxiFactories[18] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new BankServiceICProxi(objectId);
            }
        };
        iCProxiFactories[21] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new TransferICProxi(objectId);
            }
        };
        iCProxiFactories[140] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new BankPxICProxi(objectId);
            }
        };
        iCProxiFactories[156] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CompensationPendingRequestsICProxi(objectId);
            }
        };
        iCProxiFactories[24] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AdministratorBanksICProxi(objectId);
            }
        };
        iCProxiFactories[26] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new LimitAccountICProxi(objectId);
            }
        };
        iCProxiFactories[79] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new FrankenICProxi(objectId);
            }
        };
        iCProxiFactories[137] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new EnabledStateICProxi(objectId);
            }
        };
        iCProxiFactories[76] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new DebitICProxi(objectId);
            }
        };
        iCProxiFactories[167] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CompensationDeclinedCommandICProxi(objectId);
            }
        };
        iCProxiFactories[134] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AccountTriggerListeICProxi(objectId);
            }
        };
        iCProxiFactories[101] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new DebitGrantListeICProxi(objectId);
            }
        };
        iCProxiFactories[29] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AccountServiceICProxi(objectId);
            }
        };
        iCProxiFactories[32] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AccountICProxi(objectId);
            }
        };
        iCProxiFactories[109] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new NotExecutedStateICProxi(objectId);
            }
        };
        iCProxiFactories[130] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new TriggerICProxi(objectId);
            }
        };
        iCProxiFactories[37] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new TemplateStateICProxi(objectId);
            }
        };
        iCProxiFactories[80] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new YenICProxi(objectId);
            }
        };
        iCProxiFactories[99] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new DebitTransferNotExecutedICProxi(objectId);
            }
        };
        iCProxiFactories[118] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ChangeCurrencyCommandICProxi(objectId);
            }
        };
        iCProxiFactories[43] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new NotExecutableStateICProxi(objectId);
            }
        };
        iCProxiFactories[158] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CompensationListeICProxi(objectId);
            }
        };
        iCProxiFactories[169] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AllCompensationListePendingCompensationRequestsICProxi(objectId);
            }
        };
        iCProxiFactories[44] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CommandExecuterICProxi(objectId);
            }
        };
        iCProxiFactories[45] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new TransactionICProxi(objectId);
            }
        };
        iCProxiFactories[48] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new BankICProxi(objectId);
            }
        };
        iCProxiFactories[180] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new DeclinedCompensationStateICProxi(objectId);
            }
        };
        iCProxiFactories[96] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new DebitTransferSuccessfulICProxi(objectId);
            }
        };
        iCProxiFactories[126] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new EventWrapperICProxi(objectId);
            }
        };
        iCProxiFactories[143] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new BankFeesICProxi(objectId);
            }
        };
        iCProxiFactories[165] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new DeclinedStateICProxi(objectId);
            }
        };
        iCProxiFactories[185] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new DebitGrantListePxICProxi(objectId);
            }
        };
        iCProxiFactories[144] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AccountServiceBankFeesICProxi(objectId);
            }
        };
        iCProxiFactories[159] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CompensationRequestListeICProxi(objectId);
            }
        };
		}
		return iCProxiFactories;
	  }

	public static PersistentInCacheProxi createInCacheProxi(long objectId, long classId) throws PersistenceException {
	    int index = (int) classId;
		if (index < 0) index = index * -1;
	    index = index - 101;
	    if (index > getTheICProxiFactories().length) throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
	    ICProxiFactory factory = getTheICProxiFactories()[index];
	    if (factory == null)  throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
	    PersistentInCacheProxi result =  factory.create(objectId);
	    return result;
	}

	protected PersistentObject object;
  	public int userCount;
	
	protected PersistentInCacheProxi(long id) {
		super(id);
		this.userCount = 0;
	}

	public PersistentInCacheProxi(PersistentObject object) {
		this(object.getId());
	}
	
	public boolean isDelayed$Persistence() throws PersistenceException {
		return this.getTheObject().isDelayed$Persistence();
	}

	public void setDelayed$Persistence(boolean b) throws PersistenceException {
		this.getTheObject().setDelayed$Persistence(b);
	}
	public void store() throws PersistenceException{
		this.getTheObject().store();
	}

	public void setId(long id) {
		super.setId(id);
		try {
			this.getTheObject().setId(id);
		} catch (PersistenceException e) {
			throw new PersistenceError(e);
		}
	}
	public HashMap<String,Object> toHashtable(int depth, int essentialLevel, boolean forGUI, TDObserver tdObserver) throws PersistenceException {
		PersistentRoot object = this.getTheObject();
		if (object == null) return null;
		return object.toHashtable(depth, essentialLevel, forGUI, tdObserver);
	}
	public HashMap<String, Object> toHashtable(HashMap<String, Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
		PersistentRoot object = this.getTheObject();
		if (object == null) return null;
		return object.toHashtable(allResults, depth, essentialLevel, forGUI, leaf, tdObserver);
	}

	protected abstract PersistentObject getRemote() throws PersistenceException;

	public synchronized PersistentRoot getTheObject() throws PersistenceException {
		if (this.object == null) this.object = getRemote();
		return this.object;
	}		
	protected synchronized void setObject(PersistentObject object) throws PersistenceException {
		this.object = object;
	}
	protected synchronized void clear() throws PersistenceException {
		this.object = null;
	}
	public int getIconInfo() throws PersistenceException {
		return this.getTheObject().getIconInfo();
	}
	public int getLeafInfo() throws PersistenceException {
		return this.getTheObject().getLeafInfo();
	}
	public String toString() {
		try {
			return this.getTheObject().toString();
		} catch (PersistenceException pe) {
			throw new PersistenceError(pe);
		}
	}
	public String toString(boolean inner)throws PersistenceException{
		try {
			return this.getTheObject().toString(inner);
		} catch (PersistenceException pe) {
			throw new PersistenceError(pe);
		}		
	}

	public synchronized void incrementUserCount() {
		this.userCount++;
	}

	public synchronized void decrementUserCount() {
		this.userCount--;
		if (this.isRemovable())Cache.getTheCache().remove(this);
	}

	protected boolean isRemovable() {
		return this.userCount == 0 ;
	}
	public synchronized void tryBreak() {
		try {
			if (!this.isDelayed$Persistence())this.object = null;
		} catch (PersistenceException e) {
			return;
		}
	}

	public boolean hasEssentialFields() throws PersistenceException{
		return this.getTheObject().hasEssentialFields();
	}
	public void delete$Me() throws PersistenceException {
		this.getTheObject().delete$Me();
	}
	
    
}
