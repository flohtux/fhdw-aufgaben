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
		listProxiFactories = new ListProxiFactory[53];
        listProxiFactories[38] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MixedFeeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[28] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new SubjListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[25] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AccountServiceListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[39] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new NoLimitStateListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[13] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AccountListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[29] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ChangeNameCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[0] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ErrorDisplayListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[50] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new DebitNoteListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[35] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new EuroListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[34] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateAccountCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[41] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new FixTransactionFeeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[16] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CommandCoordinatorListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[42] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MinLimitStateListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[18] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CommonDateListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[51] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new TrancactionListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[44] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MaxLimitStateListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[45] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AmountListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[15] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CommandExecuterListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[46] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MoneyListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[11] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AdministratorListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[24] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateBankCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[12] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new BankListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[26] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new BankServiceListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[47] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ProcentualFeeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[1] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ServerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[30] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AdministratorBanksListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[22] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new BankCreatorListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[36] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new DollarListEntryProxi(objectId, entryId);
            }
        };
	}
	return listProxiFactories;
  }
  private static ProxiFactory [] getTheProxiFactories(){
	if (proxiFactories == null){
		proxiFactories = new ProxiFactory [53];
        proxiFactories[38] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MixedFeeProxi(objectId);
            }
        };
        proxiFactories[28] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new SubjProxi(objectId);
            }
        };
        proxiFactories[25] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AccountServiceProxi(objectId);
            }
        };
        proxiFactories[39] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new NoLimitStateProxi(objectId);
            }
        };
        proxiFactories[13] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AccountProxi(objectId);
            }
        };
        proxiFactories[29] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ChangeNameCommandProxi(objectId);
            }
        };
        proxiFactories[0] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ErrorDisplayProxi(objectId);
            }
        };
        proxiFactories[50] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new DebitNoteProxi(objectId);
            }
        };
        proxiFactories[35] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new EuroProxi(objectId);
            }
        };
        proxiFactories[34] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateAccountCommandProxi(objectId);
            }
        };
        proxiFactories[41] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new FixTransactionFeeProxi(objectId);
            }
        };
        proxiFactories[16] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CommandCoordinatorProxi(objectId);
            }
        };
        proxiFactories[42] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MinLimitStateProxi(objectId);
            }
        };
        proxiFactories[18] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CommonDateProxi(objectId);
            }
        };
        proxiFactories[51] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new TrancactionProxi(objectId);
            }
        };
        proxiFactories[44] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MaxLimitStateProxi(objectId);
            }
        };
        proxiFactories[45] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AmountProxi(objectId);
            }
        };
        proxiFactories[15] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CommandExecuterProxi(objectId);
            }
        };
        proxiFactories[46] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MoneyProxi(objectId);
            }
        };
        proxiFactories[11] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AdministratorProxi(objectId);
            }
        };
        proxiFactories[24] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateBankCommandProxi(objectId);
            }
        };
        proxiFactories[12] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new BankProxi(objectId);
            }
        };
        proxiFactories[26] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new BankServiceProxi(objectId);
            }
        };
        proxiFactories[47] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ProcentualFeeProxi(objectId);
            }
        };
        proxiFactories[1] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ServerProxi(objectId);
            }
        };
        proxiFactories[30] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AdministratorBanksProxi(objectId);
            }
        };
        proxiFactories[22] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new BankCreatorProxi(objectId);
            }
        };
        proxiFactories[36] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new DollarProxi(objectId);
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