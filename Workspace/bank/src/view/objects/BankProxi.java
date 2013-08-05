package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class BankProxi extends ViewProxi implements BankView{
    
    public BankProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public BankView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        long bankNumber = new Long((String)resultTable.get("bankNumber")).longValue();
        String name = (String)resultTable.get("name");
        ViewProxi fee = null;
        String fee$String = (String)resultTable.get("fee");
        if (fee$String != null) {
            common.ProxiInformation fee$Info = common.RPCConstantsAndServices.createProxiInformation(fee$String);
            fee = view.objects.ViewProxi.createProxi(fee$Info,connectionKey);
            fee.setToString(fee$Info.getToString());
        }
        ViewProxi internalFee = null;
        String internalFee$String = (String)resultTable.get("internalFee");
        if (internalFee$String != null) {
            common.ProxiInformation internalFee$Info = common.RPCConstantsAndServices.createProxiInformation(internalFee$String);
            internalFee = view.objects.ViewProxi.createProxi(internalFee$Info,connectionKey);
            internalFee.setToString(internalFee$Info.getToString());
        }
        ViewProxi ownAccount = null;
        String ownAccount$String = (String)resultTable.get("ownAccount");
        if (ownAccount$String != null) {
            common.ProxiInformation ownAccount$Info = common.RPCConstantsAndServices.createProxiInformation(ownAccount$String);
            ownAccount = view.objects.ViewProxi.createProxi(ownAccount$Info,connectionKey);
            ownAccount.setToString(ownAccount$Info.getToString());
        }
        ViewProxi administrator = null;
        String administrator$String = (String)resultTable.get("administrator");
        if (administrator$String != null) {
            common.ProxiInformation administrator$Info = common.RPCConstantsAndServices.createProxiInformation(administrator$String);
            administrator = view.objects.ViewProxi.createProxi(administrator$Info,connectionKey);
            administrator.setToString(administrator$Info.getToString());
        }
        java.util.Vector<String> currentAccounts_string = (java.util.Vector<String>)resultTable.get("currentAccounts");
        java.util.Vector<AccountView> currentAccounts = ViewProxi.getProxiVector(currentAccounts_string, connectionKey);
        BankView result$$ = new Bank((long)bankNumber,(String)name,(TransactionFeeView)fee,(InternalFeeView)internalFee,(AccountView)ownAccount,(AdministratorView)administrator,currentAccounts, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getFee() != null) return new FeeBankWrapper(this, originalIndex, (ViewRoot)this.getFee());
        if(this.getFee() != null) index = index - 1;
        if(index == 0 && this.getInternalFee() != null) return new InternalFeeBankWrapper(this, originalIndex, (ViewRoot)this.getInternalFee());
        if(this.getInternalFee() != null) index = index - 1;
        if(index == 0 && this.getOwnAccount() != null) return new OwnAccountBankWrapper(this, originalIndex, (ViewRoot)this.getOwnAccount());
        if(this.getOwnAccount() != null) index = index - 1;
        if(index < this.getCurrentAccounts().size()) return new CurrentAccountsBankWrapper(this, originalIndex, (ViewRoot)this.getCurrentAccounts().get(index));
        index = index - this.getCurrentAccounts().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getFee() == null ? 0 : 1)
            + (this.getInternalFee() == null ? 0 : 1)
            + (this.getOwnAccount() == null ? 0 : 1)
            + (this.getCurrentAccounts().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getFee() == null ? true : false)
            && (this.getInternalFee() == null ? true : false)
            && (this.getOwnAccount() == null ? true : false)
            && (this.getCurrentAccounts().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getFee() != null && this.getFee().equals(child)) return result;
        if(this.getFee() != null) result = result + 1;
        if(this.getInternalFee() != null && this.getInternalFee().equals(child)) return result;
        if(this.getInternalFee() != null) result = result + 1;
        if(this.getOwnAccount() != null && this.getOwnAccount().equals(child)) return result;
        if(this.getOwnAccount() != null) result = result + 1;
        java.util.Iterator<?> getCurrentAccountsIterator = this.getCurrentAccounts().iterator();
        while(getCurrentAccountsIterator.hasNext()){
            if(getCurrentAccountsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public long getBankNumber()throws ModelException{
        return ((Bank)this.getTheObject()).getBankNumber();
    }
    public void setBankNumber(long newValue) throws ModelException {
        ((Bank)this.getTheObject()).setBankNumber(newValue);
    }
    public String getName()throws ModelException{
        return ((Bank)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws ModelException {
        ((Bank)this.getTheObject()).setName(newValue);
    }
    public TransactionFeeView getFee()throws ModelException{
        return ((Bank)this.getTheObject()).getFee();
    }
    public void setFee(TransactionFeeView newValue) throws ModelException {
        ((Bank)this.getTheObject()).setFee(newValue);
    }
    public InternalFeeView getInternalFee()throws ModelException{
        return ((Bank)this.getTheObject()).getInternalFee();
    }
    public void setInternalFee(InternalFeeView newValue) throws ModelException {
        ((Bank)this.getTheObject()).setInternalFee(newValue);
    }
    public AccountView getOwnAccount()throws ModelException{
        return ((Bank)this.getTheObject()).getOwnAccount();
    }
    public void setOwnAccount(AccountView newValue) throws ModelException {
        ((Bank)this.getTheObject()).setOwnAccount(newValue);
    }
    public AdministratorView getAdministrator()throws ModelException{
        return ((Bank)this.getTheObject()).getAdministrator();
    }
    public void setAdministrator(AdministratorView newValue) throws ModelException {
        ((Bank)this.getTheObject()).setAdministrator(newValue);
    }
    public java.util.Vector<AccountView> getCurrentAccounts()throws ModelException{
        return ((Bank)this.getTheObject()).getCurrentAccounts();
    }
    public void setCurrentAccounts(java.util.Vector<AccountView> newValue) throws ModelException {
        ((Bank)this.getTheObject()).setCurrentAccounts(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleBank(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleBank(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleBank(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleBank(this);
    }
    
    public boolean hasTransientFields(){
        return true;
    }
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
