package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class DebitTransferPayedFeesProxi extends ViewProxi implements DebitTransferPayedFeesView{
    
    public DebitTransferPayedFeesProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public DebitTransferPayedFeesView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi payedFees = null;
        String payedFees$String = (String)resultTable.get("payedFees");
        if (payedFees$String != null) {
            common.ProxiInformation payedFees$Info = common.RPCConstantsAndServices.createProxiInformation(payedFees$String);
            payedFees = view.objects.ViewProxi.createProxi(payedFees$Info,connectionKey);
            payedFees.setToString(payedFees$Info.getToString());
        }
        ViewProxi payingAccount = null;
        String payingAccount$String = (String)resultTable.get("payingAccount");
        if (payingAccount$String != null) {
            common.ProxiInformation payingAccount$Info = common.RPCConstantsAndServices.createProxiInformation(payingAccount$String);
            payingAccount = view.objects.ViewProxi.createProxi(payingAccount$Info,connectionKey);
            payingAccount.setToString(payingAccount$Info.getToString());
        }
        DebitTransferPayedFeesView result$$ = new DebitTransferPayedFees((MoneyView)payedFees,(AccountView)payingAccount, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 ;
    }
    public boolean isLeaf() throws ModelException {
        return true;
    }
    public int getIndexOfChild(Object child) throws ModelException {
        
        return -1;
    }
    
    public MoneyView getPayedFees()throws ModelException{
        return ((DebitTransferPayedFees)this.getTheObject()).getPayedFees();
    }
    public void setPayedFees(MoneyView newValue) throws ModelException {
        ((DebitTransferPayedFees)this.getTheObject()).setPayedFees(newValue);
    }
    public AccountView getPayingAccount()throws ModelException{
        return ((DebitTransferPayedFees)this.getTheObject()).getPayingAccount();
    }
    public void setPayingAccount(AccountView newValue) throws ModelException {
        ((DebitTransferPayedFees)this.getTheObject()).setPayingAccount(newValue);
    }
    
    public void accept(DebitTransferPayedFeesVisitor visitor) throws ModelException {
        visitor.handleDebitTransferPayedFees(this);
    }
    public <R> R accept(DebitTransferPayedFeesReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitTransferPayedFees(this);
    }
    public <E extends UserException>  void accept(DebitTransferPayedFeesExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitTransferPayedFees(this);
    }
    public <R, E extends UserException> R accept(DebitTransferPayedFeesReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitTransferPayedFees(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleDebitTransferPayedFees(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitTransferPayedFees(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitTransferPayedFees(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitTransferPayedFees(this);
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
