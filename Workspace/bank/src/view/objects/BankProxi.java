package view.objects;

import view.AccountView;
import view.BankFeesView;
import view.BankOwnAccountPxView;
import view.BankView;
import view.ModelException;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;
import viewClient.ExceptionAndEventHandler;

public class BankProxi extends ViewProxi implements BankView{
    
    public BankProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public BankView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        long bankNumber = new Long((String)resultTable.get("bankNumber")).longValue();
        String name = (String)resultTable.get("name");
        ViewProxi bankFees = null;
        String bankFees$String = (String)resultTable.get("bankFees");
        if (bankFees$String != null) {
            common.ProxiInformation bankFees$Info = common.RPCConstantsAndServices.createProxiInformation(bankFees$String);
            bankFees = view.objects.ViewProxi.createProxi(bankFees$Info,connectionKey);
            bankFees.setToString(bankFees$Info.getToString());
        }
        ViewProxi ownAccount = null;
        String ownAccount$String = (String)resultTable.get("ownAccount");
        if (ownAccount$String != null) {
            common.ProxiInformation ownAccount$Info = common.RPCConstantsAndServices.createProxiInformation(ownAccount$String);
            ownAccount = view.objects.ViewProxi.createProxi(ownAccount$Info,connectionKey);
            ownAccount.setToString(ownAccount$Info.getToString());
        }
        java.util.Vector<String> currentAccounts_string = (java.util.Vector<String>)resultTable.get("currentAccounts");
        java.util.Vector<AccountView> currentAccounts = ViewProxi.getProxiVector(currentAccounts_string, connectionKey);
        BankView result$$ = new Bank((long)bankNumber,(String)name,(BankFeesView)bankFees,(BankOwnAccountPxView)ownAccount,currentAccounts, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(this.getBankFees() != null && index < this.getBankFees().getTheObject().getChildCount())
            return this.getBankFees().getTheObject().getChild(index);
        if(this.getBankFees() != null) index = index - this.getBankFees().getTheObject().getChildCount();
        if(index == 0 && this.getOwnAccount() != null) return new OwnAccountBankWrapper(this, originalIndex, (ViewRoot)this.getOwnAccount());
        if(this.getOwnAccount() != null) index = index - 1;
        if(index < this.getCurrentAccounts().size()) return new CurrentAccountsBankWrapper(this, originalIndex, (ViewRoot)this.getCurrentAccounts().get(index));
        index = index - this.getCurrentAccounts().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getBankFees() == null ? 0 : this.getBankFees().getTheObject().getChildCount())
            + (this.getOwnAccount() == null ? 0 : 1)
            + (this.getCurrentAccounts().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getBankFees() == null ? true : this.getBankFees().getTheObject().isLeaf())
            && (this.getOwnAccount() == null ? true : false)
            && (this.getCurrentAccounts().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getBankFees() != null && this.getBankFees().equals(child)) return result;
        if(this.getBankFees() != null) result = result + 1;
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
    public BankFeesView getBankFees()throws ModelException{
        return ((Bank)this.getTheObject()).getBankFees();
    }
    public void setBankFees(BankFeesView newValue) throws ModelException {
        ((Bank)this.getTheObject()).setBankFees(newValue);
    }
    public BankOwnAccountPxView getOwnAccount()throws ModelException{
        return ((Bank)this.getTheObject()).getOwnAccount();
    }
    public void setOwnAccount(BankOwnAccountPxView newValue) throws ModelException {
        ((Bank)this.getTheObject()).setOwnAccount(newValue);
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
