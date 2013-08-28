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
        ViewProxi money2 = null;
        String money2$String = (String)resultTable.get("money2");
        if (money2$String != null) {
            common.ProxiInformation money2$Info = common.RPCConstantsAndServices.createProxiInformation(money2$String);
            money2 = view.objects.ViewProxi.createProxi(money2$Info,connectionKey);
            money2.setToString(money2$Info.getToString());
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
        ViewProxi grantedDebitGrant = null;
        String grantedDebitGrant$String = (String)resultTable.get("grantedDebitGrant");
        if (grantedDebitGrant$String != null) {
            common.ProxiInformation grantedDebitGrant$Info = common.RPCConstantsAndServices.createProxiInformation(grantedDebitGrant$String);
            grantedDebitGrant = view.objects.ViewProxi.createProxi(grantedDebitGrant$Info,connectionKey);
            grantedDebitGrant.setToString(grantedDebitGrant$Info.getToString());
        }
        ViewProxi receivedDebitGrant = null;
        String receivedDebitGrant$String = (String)resultTable.get("receivedDebitGrant");
        if (receivedDebitGrant$String != null) {
            common.ProxiInformation receivedDebitGrant$Info = common.RPCConstantsAndServices.createProxiInformation(receivedDebitGrant$String);
            receivedDebitGrant = view.objects.ViewProxi.createProxi(receivedDebitGrant$Info,connectionKey);
            receivedDebitGrant.setToString(receivedDebitGrant$Info.getToString());
        }
        AccountView result$$ = new Account((long)accountNumber,(MoneyView)money,(MoneyView)money2,(LimitAccountView)limit,debitTransferTransactions,(DebitGrantListeView)grantedDebitGrant,(DebitGrantListeView)receivedDebitGrant, this.getId(), this.getClassId());
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
        if(index == 0 && this.getMoney2() != null) return new Money2AccountWrapper(this, originalIndex, (ViewRoot)this.getMoney2());
        if(this.getMoney2() != null) index = index - 1;
        if(index == 0 && this.getLimit() != null) return new LimitAccountWrapper(this, originalIndex, (ViewRoot)this.getLimit());
        if(this.getLimit() != null) index = index - 1;
        if(index == 0 && this.getGrantedDebitGrant() != null) return new GrantedDebitGrantAccountWrapper(this, originalIndex, (ViewRoot)this.getGrantedDebitGrant());
        if(this.getGrantedDebitGrant() != null) index = index - 1;
        if(index == 0 && this.getReceivedDebitGrant() != null) return new ReceivedDebitGrantAccountWrapper(this, originalIndex, (ViewRoot)this.getReceivedDebitGrant());
        if(this.getReceivedDebitGrant() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMoney() == null ? 0 : 1)
            + (this.getMoney2() == null ? 0 : 1)
            + (this.getLimit() == null ? 0 : 1)
            + (this.getGrantedDebitGrant() == null ? 0 : 1)
            + (this.getReceivedDebitGrant() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getMoney() == null ? true : false)
            && (this.getMoney2() == null ? true : false)
            && (this.getLimit() == null ? true : false)
            && (this.getGrantedDebitGrant() == null ? true : false)
            && (this.getReceivedDebitGrant() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getMoney() != null && this.getMoney().equals(child)) return result;
        if(this.getMoney() != null) result = result + 1;
        if(this.getMoney2() != null && this.getMoney2().equals(child)) return result;
        if(this.getMoney2() != null) result = result + 1;
        if(this.getLimit() != null && this.getLimit().equals(child)) return result;
        if(this.getLimit() != null) result = result + 1;
        if(this.getGrantedDebitGrant() != null && this.getGrantedDebitGrant().equals(child)) return result;
        if(this.getGrantedDebitGrant() != null) result = result + 1;
        if(this.getReceivedDebitGrant() != null && this.getReceivedDebitGrant().equals(child)) return result;
        if(this.getReceivedDebitGrant() != null) result = result + 1;
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
    public MoneyView getMoney2()throws ModelException{
        return ((Account)this.getTheObject()).getMoney2();
    }
    public void setMoney2(MoneyView newValue) throws ModelException {
        ((Account)this.getTheObject()).setMoney2(newValue);
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
    public DebitGrantListeView getGrantedDebitGrant()throws ModelException{
        return ((Account)this.getTheObject()).getGrantedDebitGrant();
    }
    public void setGrantedDebitGrant(DebitGrantListeView newValue) throws ModelException {
        ((Account)this.getTheObject()).setGrantedDebitGrant(newValue);
    }
    public DebitGrantListeView getReceivedDebitGrant()throws ModelException{
        return ((Account)this.getTheObject()).getReceivedDebitGrant();
    }
    public void setReceivedDebitGrant(DebitGrantListeView newValue) throws ModelException {
        ((Account)this.getTheObject()).setReceivedDebitGrant(newValue);
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
