package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class AccountProxi extends ViewProxi implements AccountView{
    
    public AccountProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public AccountView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        long accountNumber = new Long((String)resultTable.get("accountNumber")).longValue();
        ViewProxi money = null;
        String money$String = (String)resultTable.get("money");
        if (money$String != null) {
            common.ProxiInformation money$Info = common.RPCConstantsAndServices.createProxiInformation(money$String);
            money = view.objects.ViewProxi.createProxi(money$Info,connectionKey);
            money.setToString(money$Info.getToString());
        }
        ViewProxi limit = null;
        String limit$String = (String)resultTable.get("limit");
        if (limit$String != null) {
            common.ProxiInformation limit$Info = common.RPCConstantsAndServices.createProxiInformation(limit$String);
            limit = view.objects.ViewProxi.createProxi(limit$Info,connectionKey);
            limit.setToString(limit$Info.getToString());
        }
        java.util.Vector<String> debitTransferTransactions_string = (java.util.Vector<String>)resultTable.get("debitTransferTransactions");
        java.util.Vector<DebitTransferTransactionView> debitTransferTransactions = ViewProxi.getProxiVector(debitTransferTransactions_string, connectionKey);
        java.util.Vector<String> grantedDebitGrants_string = (java.util.Vector<String>)resultTable.get("grantedDebitGrants");
        java.util.Vector<DebitGrantView> grantedDebitGrants = ViewProxi.getProxiVector(grantedDebitGrants_string, connectionKey);
        java.util.Vector<String> receivedDebitGrants_string = (java.util.Vector<String>)resultTable.get("receivedDebitGrants");
        java.util.Vector<DebitGrantView> receivedDebitGrants = ViewProxi.getProxiVector(receivedDebitGrants_string, connectionKey);
        AccountView result$$ = new Account((long)accountNumber,(MoneyView)money,(LimitAccountView)limit,debitTransferTransactions,grantedDebitGrants,receivedDebitGrants, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getMoney() != null) return new MoneyAccountWrapper(this, originalIndex, (ViewRoot)this.getMoney());
        if(this.getMoney() != null) index = index - 1;
        if(index == 0 && this.getLimit() != null) return new LimitAccountWrapper(this, originalIndex, (ViewRoot)this.getLimit());
        if(this.getLimit() != null) index = index - 1;
        if(index < this.getDebitTransferTransactions().size()) return new DebitTransferTransactionsAccountWrapper(this, originalIndex, (ViewRoot)this.getDebitTransferTransactions().get(index));
        index = index - this.getDebitTransferTransactions().size();
        if(index < this.getGrantedDebitGrants().size()) return new GrantedDebitGrantsAccountWrapper(this, originalIndex, (ViewRoot)this.getGrantedDebitGrants().get(index));
        index = index - this.getGrantedDebitGrants().size();
        if(index < this.getReceivedDebitGrants().size()) return new ReceivedDebitGrantsAccountWrapper(this, originalIndex, (ViewRoot)this.getReceivedDebitGrants().get(index));
        index = index - this.getReceivedDebitGrants().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMoney() == null ? 0 : 1)
            + (this.getLimit() == null ? 0 : 1)
            + (this.getDebitTransferTransactions().size())
            + (this.getGrantedDebitGrants().size())
            + (this.getReceivedDebitGrants().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getMoney() == null ? true : false)
            && (this.getLimit() == null ? true : false)
            && (this.getDebitTransferTransactions().size() == 0)
            && (this.getGrantedDebitGrants().size() == 0)
            && (this.getReceivedDebitGrants().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getMoney() != null && this.getMoney().equals(child)) return result;
        if(this.getMoney() != null) result = result + 1;
        if(this.getLimit() != null && this.getLimit().equals(child)) return result;
        if(this.getLimit() != null) result = result + 1;
        java.util.Iterator<?> getDebitTransferTransactionsIterator = this.getDebitTransferTransactions().iterator();
        while(getDebitTransferTransactionsIterator.hasNext()){
            if(getDebitTransferTransactionsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        java.util.Iterator<?> getGrantedDebitGrantsIterator = this.getGrantedDebitGrants().iterator();
        while(getGrantedDebitGrantsIterator.hasNext()){
            if(getGrantedDebitGrantsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        java.util.Iterator<?> getReceivedDebitGrantsIterator = this.getReceivedDebitGrants().iterator();
        while(getReceivedDebitGrantsIterator.hasNext()){
            if(getReceivedDebitGrantsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public long getAccountNumber()throws ModelException{
        return ((Account)this.getTheObject()).getAccountNumber();
    }
    public void setAccountNumber(long newValue) throws ModelException {
        ((Account)this.getTheObject()).setAccountNumber(newValue);
    }
    public MoneyView getMoney()throws ModelException{
        return ((Account)this.getTheObject()).getMoney();
    }
    public void setMoney(MoneyView newValue) throws ModelException {
        ((Account)this.getTheObject()).setMoney(newValue);
    }
    public LimitAccountView getLimit()throws ModelException{
        return ((Account)this.getTheObject()).getLimit();
    }
    public void setLimit(LimitAccountView newValue) throws ModelException {
        ((Account)this.getTheObject()).setLimit(newValue);
    }
    public java.util.Vector<DebitTransferTransactionView> getDebitTransferTransactions()throws ModelException{
        return ((Account)this.getTheObject()).getDebitTransferTransactions();
    }
    public void setDebitTransferTransactions(java.util.Vector<DebitTransferTransactionView> newValue) throws ModelException {
        ((Account)this.getTheObject()).setDebitTransferTransactions(newValue);
    }
    public java.util.Vector<DebitGrantView> getGrantedDebitGrants()throws ModelException{
        return ((Account)this.getTheObject()).getGrantedDebitGrants();
    }
    public void setGrantedDebitGrants(java.util.Vector<DebitGrantView> newValue) throws ModelException {
        ((Account)this.getTheObject()).setGrantedDebitGrants(newValue);
    }
    public java.util.Vector<DebitGrantView> getReceivedDebitGrants()throws ModelException{
        return ((Account)this.getTheObject()).getReceivedDebitGrants();
    }
    public void setReceivedDebitGrants(java.util.Vector<DebitGrantView> newValue) throws ModelException {
        ((Account)this.getTheObject()).setReceivedDebitGrants(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleAccount(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAccount(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAccount(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAccount(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
