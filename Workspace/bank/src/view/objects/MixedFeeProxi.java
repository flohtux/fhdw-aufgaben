package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class MixedFeeProxi extends TransactionFeeProxi implements MixedFeeView{
    
    public MixedFeeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public MixedFeeView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi fix = null;
        String fix$String = (String)resultTable.get("fix");
        if (fix$String != null) {
            common.ProxiInformation fix$Info = common.RPCConstantsAndServices.createProxiInformation(fix$String);
            fix = view.objects.ViewProxi.createProxi(fix$Info,connectionKey);
            fix.setToString(fix$Info.getToString());
        }
        ViewProxi procentual = null;
        String procentual$String = (String)resultTable.get("procentual");
        if (procentual$String != null) {
            common.ProxiInformation procentual$Info = common.RPCConstantsAndServices.createProxiInformation(procentual$String);
            procentual = view.objects.ViewProxi.createProxi(procentual$Info,connectionKey);
            procentual.setToString(procentual$Info.getToString());
        }
        ViewProxi limit = null;
        String limit$String = (String)resultTable.get("limit");
        if (limit$String != null) {
            common.ProxiInformation limit$Info = common.RPCConstantsAndServices.createProxiInformation(limit$String);
            limit = view.objects.ViewProxi.createProxi(limit$Info,connectionKey);
            limit.setToString(limit$Info.getToString());
        }
        MixedFeeView result$$ = new MixedFee((FixTransactionFeeView)fix,(ProcentualFeeView)procentual,(MoneyView)limit, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getFix() != null) return new FixMixedFeeWrapper(this, originalIndex, (ViewRoot)this.getFix());
        if(this.getFix() != null) index = index - 1;
        if(index == 0 && this.getProcentual() != null) return new ProcentualMixedFeeWrapper(this, originalIndex, (ViewRoot)this.getProcentual());
        if(this.getProcentual() != null) index = index - 1;
        if(index == 0 && this.getLimit() != null) return new LimitMixedFeeWrapper(this, originalIndex, (ViewRoot)this.getLimit());
        if(this.getLimit() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getFix() == null ? 0 : 1)
            + (this.getProcentual() == null ? 0 : 1)
            + (this.getLimit() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getFix() == null ? true : false)
            && (this.getProcentual() == null ? true : false)
            && (this.getLimit() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getFix() != null && this.getFix().equals(child)) return result;
        if(this.getFix() != null) result = result + 1;
        if(this.getProcentual() != null && this.getProcentual().equals(child)) return result;
        if(this.getProcentual() != null) result = result + 1;
        if(this.getLimit() != null && this.getLimit().equals(child)) return result;
        if(this.getLimit() != null) result = result + 1;
        return -1;
    }
    
    public FixTransactionFeeView getFix()throws ModelException{
        return ((MixedFee)this.getTheObject()).getFix();
    }
    public void setFix(FixTransactionFeeView newValue) throws ModelException {
        ((MixedFee)this.getTheObject()).setFix(newValue);
    }
    public ProcentualFeeView getProcentual()throws ModelException{
        return ((MixedFee)this.getTheObject()).getProcentual();
    }
    public void setProcentual(ProcentualFeeView newValue) throws ModelException {
        ((MixedFee)this.getTheObject()).setProcentual(newValue);
    }
    public MoneyView getLimit()throws ModelException{
        return ((MixedFee)this.getTheObject()).getLimit();
    }
    public void setLimit(MoneyView newValue) throws ModelException {
        ((MixedFee)this.getTheObject()).setLimit(newValue);
    }
    
    public void accept(TransactionFeeVisitor visitor) throws ModelException {
        visitor.handleMixedFee(this);
    }
    public <R> R accept(TransactionFeeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMixedFee(this);
    }
    public <E extends UserException>  void accept(TransactionFeeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMixedFee(this);
    }
    public <R, E extends UserException> R accept(TransactionFeeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMixedFee(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMixedFee(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMixedFee(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMixedFee(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMixedFee(this);
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
