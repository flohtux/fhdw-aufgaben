package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class DebitTransferDoubleStateProxi extends ViewProxi implements DebitTransferDoubleStateView{
    
    public DebitTransferDoubleStateProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public DebitTransferDoubleStateView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi debitTransferStateOld = null;
        String debitTransferStateOld$String = (String)resultTable.get("debitTransferStateOld");
        if (debitTransferStateOld$String != null) {
            common.ProxiInformation debitTransferStateOld$Info = common.RPCConstantsAndServices.createProxiInformation(debitTransferStateOld$String);
            debitTransferStateOld = view.objects.ViewProxi.createProxi(debitTransferStateOld$Info,connectionKey);
            debitTransferStateOld.setToString(debitTransferStateOld$Info.getToString());
        }
        ViewProxi debitTransferStateNew = null;
        String debitTransferStateNew$String = (String)resultTable.get("debitTransferStateNew");
        if (debitTransferStateNew$String != null) {
            common.ProxiInformation debitTransferStateNew$Info = common.RPCConstantsAndServices.createProxiInformation(debitTransferStateNew$String);
            debitTransferStateNew = view.objects.ViewProxi.createProxi(debitTransferStateNew$Info,connectionKey);
            debitTransferStateNew.setToString(debitTransferStateNew$Info.getToString());
        }
        DebitTransferDoubleStateView result$$ = new DebitTransferDoubleState((DebitTransferStateView)debitTransferStateOld,(DebitTransferStateView)debitTransferStateNew, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getDebitTransferStateOld() != null) return new DebitTransferStateOldDebitTransferDoubleStateWrapper(this, originalIndex, (ViewRoot)this.getDebitTransferStateOld());
        if(this.getDebitTransferStateOld() != null) index = index - 1;
        if(index == 0 && this.getDebitTransferStateNew() != null) return new DebitTransferStateNewDebitTransferDoubleStateWrapper(this, originalIndex, (ViewRoot)this.getDebitTransferStateNew());
        if(this.getDebitTransferStateNew() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getDebitTransferStateOld() == null ? 0 : 1)
            + (this.getDebitTransferStateNew() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getDebitTransferStateOld() == null ? true : false)
            && (this.getDebitTransferStateNew() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getDebitTransferStateOld() != null && this.getDebitTransferStateOld().equals(child)) return result;
        if(this.getDebitTransferStateOld() != null) result = result + 1;
        if(this.getDebitTransferStateNew() != null && this.getDebitTransferStateNew().equals(child)) return result;
        if(this.getDebitTransferStateNew() != null) result = result + 1;
        return -1;
    }
    
    public DebitTransferStateView getDebitTransferStateOld()throws ModelException{
        return ((DebitTransferDoubleState)this.getTheObject()).getDebitTransferStateOld();
    }
    public void setDebitTransferStateOld(DebitTransferStateView newValue) throws ModelException {
        ((DebitTransferDoubleState)this.getTheObject()).setDebitTransferStateOld(newValue);
    }
    public DebitTransferStateView getDebitTransferStateNew()throws ModelException{
        return ((DebitTransferDoubleState)this.getTheObject()).getDebitTransferStateNew();
    }
    public void setDebitTransferStateNew(DebitTransferStateView newValue) throws ModelException {
        ((DebitTransferDoubleState)this.getTheObject()).setDebitTransferStateNew(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleDebitTransferDoubleState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitTransferDoubleState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitTransferDoubleState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitTransferDoubleState(this);
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
