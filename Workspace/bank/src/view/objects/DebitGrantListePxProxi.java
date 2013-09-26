package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class DebitGrantListePxProxi extends ViewProxi implements DebitGrantListePxView{
    
    public DebitGrantListePxProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public DebitGrantListePxView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi d1 = null;
        String d1$String = (String)resultTable.get("d1");
        if (d1$String != null) {
            common.ProxiInformation d1$Info = common.RPCConstantsAndServices.createProxiInformation(d1$String);
            d1 = view.objects.ViewProxi.createProxi(d1$Info,connectionKey);
            d1.setToString(d1$Info.getToString());
        }
        DebitGrantListePxView result$$ = new DebitGrantListePx((DebitGrantListeView)d1, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(this.getD1() != null && index < this.getD1().getTheObject().getChildCount())
            return this.getD1().getTheObject().getChild(index);
        if(this.getD1() != null) index = index - this.getD1().getTheObject().getChildCount();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getD1() == null ? 0 : this.getD1().getTheObject().getChildCount());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getD1() == null ? true : this.getD1().getTheObject().isLeaf());
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getD1() != null && this.getD1().equals(child)) return result;
        if(this.getD1() != null) result = result + 1;
        return -1;
    }
    
    public DebitGrantListeView getD1()throws ModelException{
        return ((DebitGrantListePx)this.getTheObject()).getD1();
    }
    public void setD1(DebitGrantListeView newValue) throws ModelException {
        ((DebitGrantListePx)this.getTheObject()).setD1(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleDebitGrantListePx(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitGrantListePx(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitGrantListePx(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitGrantListePx(this);
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
