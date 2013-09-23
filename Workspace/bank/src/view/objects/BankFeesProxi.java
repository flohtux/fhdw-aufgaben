package view.objects;

import view.BankFeesView;
import view.InternalFeeView;
import view.ModelException;
import view.TransactionFeeView;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;
import viewClient.ExceptionAndEventHandler;

public class BankFeesProxi extends ViewProxi implements BankFeesView{
    
    public BankFeesProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public BankFeesView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
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
        BankFeesView result$$ = new BankFees((TransactionFeeView)fee,(InternalFeeView)internalFee, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getFee() != null) return new FeeBankFeesWrapper(this, originalIndex, (ViewRoot)this.getFee());
        if(this.getFee() != null) index = index - 1;
        if(index == 0 && this.getInternalFee() != null) return new InternalFeeBankFeesWrapper(this, originalIndex, (ViewRoot)this.getInternalFee());
        if(this.getInternalFee() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getFee() == null ? 0 : 1)
            + (this.getInternalFee() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getFee() == null ? true : false)
            && (this.getInternalFee() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getFee() != null && this.getFee().equals(child)) return result;
        if(this.getFee() != null) result = result + 1;
        if(this.getInternalFee() != null && this.getInternalFee().equals(child)) return result;
        if(this.getInternalFee() != null) result = result + 1;
        return -1;
    }
    
    public TransactionFeeView getFee()throws ModelException{
        return ((BankFees)this.getTheObject()).getFee();
    }
    public void setFee(TransactionFeeView newValue) throws ModelException {
        ((BankFees)this.getTheObject()).setFee(newValue);
    }
    public InternalFeeView getInternalFee()throws ModelException{
        return ((BankFees)this.getTheObject()).getInternalFee();
    }
    public void setInternalFee(InternalFeeView newValue) throws ModelException {
        ((BankFees)this.getTheObject()).setInternalFee(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleBankFees(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleBankFees(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleBankFees(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleBankFees(this);
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
