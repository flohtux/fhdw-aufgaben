package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class AccountProxi extends ViewProxi implements AccountView{
    
    public AccountProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public AccountView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        long accountNumber = new Long((String)resultTable.get("accountNumber")).longValue();
        ViewProxi money = null;
        String money$String = (String)resultTable.get("money");
        if (money$String != null) {
            common.ProxiInformation money$Info = common.RPCConstantsAndServices.createProxiInformation(money$String);
            money = view.objects.ViewProxi.createProxi(money$Info,connectionKey);
            money.setToString(money$Info.getToString());
        }
        ViewProxi firstLimit = null;
        String firstLimit$String = (String)resultTable.get("firstLimit");
        if (firstLimit$String != null) {
            common.ProxiInformation firstLimit$Info = common.RPCConstantsAndServices.createProxiInformation(firstLimit$String);
            firstLimit = view.objects.ViewProxi.createProxi(firstLimit$Info,connectionKey);
            firstLimit.setToString(firstLimit$Info.getToString());
        }
        ViewProxi secondLimit = null;
        String secondLimit$String = (String)resultTable.get("secondLimit");
        if (secondLimit$String != null) {
            common.ProxiInformation secondLimit$Info = common.RPCConstantsAndServices.createProxiInformation(secondLimit$String);
            secondLimit = view.objects.ViewProxi.createProxi(secondLimit$Info,connectionKey);
            secondLimit.setToString(secondLimit$Info.getToString());
        }
        AccountView result$$ = new Account((long)accountNumber,(MoneyView)money,(AccountLimitStateView)firstLimit,(AccountLimitStateView)secondLimit, this.getId(), this.getClassId());
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
        if(index == 0 && this.getFirstLimit() != null) return new FirstLimitAccountWrapper(this, originalIndex, (ViewRoot)this.getFirstLimit());
        if(this.getFirstLimit() != null) index = index - 1;
        if(index == 0 && this.getSecondLimit() != null) return new SecondLimitAccountWrapper(this, originalIndex, (ViewRoot)this.getSecondLimit());
        if(this.getSecondLimit() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMoney() == null ? 0 : 1)
            + (this.getFirstLimit() == null ? 0 : 1)
            + (this.getSecondLimit() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getMoney() == null ? true : false)
            && (this.getFirstLimit() == null ? true : false)
            && (this.getSecondLimit() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getMoney() != null && this.getMoney().equals(child)) return result;
        if(this.getMoney() != null) result = result + 1;
        if(this.getFirstLimit() != null && this.getFirstLimit().equals(child)) return result;
        if(this.getFirstLimit() != null) result = result + 1;
        if(this.getSecondLimit() != null && this.getSecondLimit().equals(child)) return result;
        if(this.getSecondLimit() != null) result = result + 1;
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
    public AccountLimitStateView getFirstLimit()throws ModelException{
        return ((Account)this.getTheObject()).getFirstLimit();
    }
    public void setFirstLimit(AccountLimitStateView newValue) throws ModelException {
        ((Account)this.getTheObject()).setFirstLimit(newValue);
    }
    public AccountLimitStateView getSecondLimit()throws ModelException{
        return ((Account)this.getTheObject()).getSecondLimit();
    }
    public void setSecondLimit(AccountLimitStateView newValue) throws ModelException {
        ((Account)this.getTheObject()).setSecondLimit(newValue);
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
