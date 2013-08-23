package persistence;

import java.util.HashMap;

abstract class ProxiFactory {
	  abstract PersistentProxi create(long objectId);
}
abstract class ListProxiFactory {
	  abstract PersistentListEntryProxi create(long objectId, long entryId);
}

public abstract class PersistentProxi extends PersistentRoot {

  private static ProxiFactory [] proxiFactories;
  private static ListProxiFactory [] listProxiFactories;
	
  private static ListProxiFactory [] getTheListProxiFactories(){
	if (listProxiFactories == null){
		listProxiFactories = new ListProxiFactory[108];
        listProxiFactories[104] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AccountReceivedDebitGrantListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[1] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new SubjListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[65] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new FalseValueListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[105] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AccountGrantedDebitGrantListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[2] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ChangeNameCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[3] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new NoRequestStateListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[78] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CurrencyManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[6] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateAccountCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[7] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new FixTransactionFeeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[8] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new InternalFeeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[9] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ExecutedStateListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[10] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CommonDateListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[67] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new TrueValueListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[11] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new PercentListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[41] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new NotSuccessfulStateListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[74] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new SuccessfulStateListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[14] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AmountListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[15] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new NoLimitListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[16] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AdministratorListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[17] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateBankCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[18] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new BankServiceListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[19] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ProcentualFeeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[20] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ServerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[107] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new DebitTransferTemplateListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[21] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new TransferListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[97] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateDebitGrantCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[85] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ExecuteCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[24] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AdministratorBanksListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[25] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new DollarListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[79] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new FrankenListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[26] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new LimitAccountListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[27] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new LimitListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[76] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new DebitListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[28] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MixedFeeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[101] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new DebitGrantListeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[29] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AccountServiceListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[30] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new RequestStateListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[102] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AccountPxListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[32] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AccountListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[82] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AdministratorCurrencyManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[34] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ErrorDisplayListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[36] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new EuroListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[80] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new YenListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[37] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new TemplateStateListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[99] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new DebitTransferNotExecutedListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[38] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CommandCoordinatorListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[42] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new NotExecutetStateListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[43] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new NotExecutableStateListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[44] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CommandExecuterListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[45] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new TransactionListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[47] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MoneyListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[48] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new BankListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[96] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new DebitTransferSuccessfulListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[81] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new PfundListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[33] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new NotSuccessfulStornoStateListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[22] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new SuccessfulStornoStateListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[90] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new DebitGrantListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[83] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ExecuteTransferCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[51] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new BankCreatorListEntryProxi(objectId, entryId);
            }
        };
	}
	return listProxiFactories;
  }
  private static ProxiFactory [] getTheProxiFactories(){
	if (proxiFactories == null){
		proxiFactories = new ProxiFactory [108];
        proxiFactories[104] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AccountReceivedDebitGrantProxi(objectId);
            }
        };
        proxiFactories[1] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new SubjProxi(objectId);
            }
        };
        proxiFactories[65] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new FalseValueProxi(objectId);
            }
        };
        proxiFactories[105] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AccountGrantedDebitGrantProxi(objectId);
            }
        };
        proxiFactories[2] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ChangeNameCommandProxi(objectId);
            }
        };
        proxiFactories[3] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new NoRequestStateProxi(objectId);
            }
        };
        proxiFactories[78] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CurrencyManagerProxi(objectId);
            }
        };
        proxiFactories[6] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateAccountCommandProxi(objectId);
            }
        };
        proxiFactories[7] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new FixTransactionFeeProxi(objectId);
            }
        };
        proxiFactories[8] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new InternalFeeProxi(objectId);
            }
        };
        proxiFactories[9] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ExecutedStateProxi(objectId);
            }
        };
        proxiFactories[10] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CommonDateProxi(objectId);
            }
        };
        proxiFactories[67] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new TrueValueProxi(objectId);
            }
        };
        proxiFactories[11] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new PercentProxi(objectId);
            }
        };
        proxiFactories[41] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new NotSuccessfulStateProxi(objectId);
            }
        };
        proxiFactories[74] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new SuccessfulStateProxi(objectId);
            }
        };
        proxiFactories[14] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AmountProxi(objectId);
            }
        };
        proxiFactories[15] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new NoLimitProxi(objectId);
            }
        };
        proxiFactories[16] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AdministratorProxi(objectId);
            }
        };
        proxiFactories[17] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateBankCommandProxi(objectId);
            }
        };
        proxiFactories[18] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new BankServiceProxi(objectId);
            }
        };
        proxiFactories[19] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ProcentualFeeProxi(objectId);
            }
        };
        proxiFactories[20] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ServerProxi(objectId);
            }
        };
        proxiFactories[107] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new DebitTransferTemplateProxi(objectId);
            }
        };
        proxiFactories[21] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new TransferProxi(objectId);
            }
        };
        proxiFactories[97] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateDebitGrantCommandProxi(objectId);
            }
        };
        proxiFactories[85] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ExecuteCommandProxi(objectId);
            }
        };
        proxiFactories[24] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AdministratorBanksProxi(objectId);
            }
        };
        proxiFactories[25] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new DollarProxi(objectId);
            }
        };
        proxiFactories[79] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new FrankenProxi(objectId);
            }
        };
        proxiFactories[26] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new LimitAccountProxi(objectId);
            }
        };
        proxiFactories[27] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new LimitProxi(objectId);
            }
        };
        proxiFactories[76] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new DebitProxi(objectId);
            }
        };
        proxiFactories[28] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MixedFeeProxi(objectId);
            }
        };
        proxiFactories[101] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new DebitGrantListeProxi(objectId);
            }
        };
        proxiFactories[29] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AccountServiceProxi(objectId);
            }
        };
        proxiFactories[30] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new RequestStateProxi(objectId);
            }
        };
        proxiFactories[102] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AccountPxProxi(objectId);
            }
        };
        proxiFactories[32] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AccountProxi(objectId);
            }
        };
        proxiFactories[82] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AdministratorCurrencyManagerProxi(objectId);
            }
        };
        proxiFactories[34] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ErrorDisplayProxi(objectId);
            }
        };
        proxiFactories[36] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new EuroProxi(objectId);
            }
        };
        proxiFactories[80] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new YenProxi(objectId);
            }
        };
        proxiFactories[37] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new TemplateStateProxi(objectId);
            }
        };
        proxiFactories[99] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new DebitTransferNotExecutedProxi(objectId);
            }
        };
        proxiFactories[38] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CommandCoordinatorProxi(objectId);
            }
        };
        proxiFactories[42] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new NotExecutetStateProxi(objectId);
            }
        };
        proxiFactories[43] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new NotExecutableStateProxi(objectId);
            }
        };
        proxiFactories[44] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CommandExecuterProxi(objectId);
            }
        };
        proxiFactories[45] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new TransactionProxi(objectId);
            }
        };
        proxiFactories[47] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MoneyProxi(objectId);
            }
        };
        proxiFactories[48] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new BankProxi(objectId);
            }
        };
        proxiFactories[96] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new DebitTransferSuccessfulProxi(objectId);
            }
        };
        proxiFactories[81] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new PfundProxi(objectId);
            }
        };
        proxiFactories[33] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new NotSuccessfulStornoStateProxi(objectId);
            }
        };
        proxiFactories[22] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new SuccessfulStornoStateProxi(objectId);
            }
        };
        proxiFactories[90] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new DebitGrantProxi(objectId);
            }
        };
        proxiFactories[83] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ExecuteTransferCommandProxi(objectId);
            }
        };
        proxiFactories[51] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new BankCreatorProxi(objectId);
            }
        };
	}
	return proxiFactories;
  }

  public static PersistentProxi createProxi(common.ProxiInformation proxi) throws PersistenceException{
	  if (proxi.isDecorator()){
		  Decoratees resultDecoratee = (Decoratees) createProxi(proxi.getDecorateeObjectId(), proxi.getDecorateeClassId());
		  PersistentProxi resultDecorator = (PersistentProxi) resultDecoratee.createDecorator();
		  resultDecorator.setId(proxi.getObjectId());
		  return resultDecorator;
	  } else {
		  return createProxi(proxi.getObjectId(), proxi.getClassId());
	  }
  }

  public static PersistentProxi createProxi(long objectId, long classId) throws PersistenceException {
    int index = (int) classId;
    if (classId == common.RPCConstantsAndServices.NullClassID) return null; 
	if (index < 0) index = index * -1;
    index = index - 101;
    if (index > getTheProxiFactories().length) throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    ProxiFactory factory = getTheProxiFactories()[index];
    if (factory == null)  throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    PersistentProxi result =  factory.create(objectId);
    result.getTheObject();
    return result;
  }
  public static PersistentListEntryProxi createListEntryProxi(long objectId, long classId, long entryId) throws PersistenceException {
    int index = (int) classId;
	if (index < 0) index = index * -1;
    index = index - 101;
    if (index > getTheListProxiFactories().length) throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    ListProxiFactory factory = getTheListProxiFactories()[index];
    if (factory == null)  throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    PersistentListEntryProxi result =  factory.create(objectId,entryId);
    result.getTheObject();
    return result;
  }

	private PersistentInCacheProxi object;

	protected PersistentProxi(long id) {
		super(id);
		this.object = null;
	}

	protected PersistentProxi(PersistentInCacheProxi object) {
		//TODO Check if used anywhere!?
		super(object.getId());
		this.object = object;
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

	protected void setObject(PersistentRoot object) {
		if (this.object == null)
			this.object = (PersistentInCacheProxi)object;
	}

	public HashMap<String,Object> toHashtable(int depth, int essentialLevel, boolean forGUI, TDObserver tdObserver) throws PersistenceException {
		PersistentRoot iCRroxi = this.getTheObject();
		if (iCRroxi == null) return null;
		return iCRroxi.toHashtable(depth, essentialLevel, forGUI, tdObserver);
	}
	public HashMap<String, Object> toHashtable(HashMap<String, Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
		PersistentRoot iCRroxi = this.getTheObject();
		if (iCRroxi == null) return null;
		return iCRroxi.toHashtable(allResults, depth, essentialLevel, forGUI, leaf, tdObserver);
	}

	public PersistentRoot getTheObject() throws PersistenceException {
		if (this.object == null) {
			this.object = Cache.getTheCache().get(this);
			this.object.incrementUserCount();
		}
		return this.object;
	}
	public boolean hasEssentialFields() throws PersistenceException{
		return this.getTheObject().hasEssentialFields();
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
	public void delete$Me() throws PersistenceException {
		this.getTheObject().delete$Me();
	}
	
    	
	
	public void finalize(){
		if (this.object != null)this.object.decrementUserCount();
	}
}
