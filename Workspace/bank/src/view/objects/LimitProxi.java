package view.objects;

import view.LimitView;
import view.ModelException;
import view.MoneyView;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;
import view.visitor.LimitTypeExceptionVisitor;
import view.visitor.LimitTypeReturnExceptionVisitor;
import view.visitor.LimitTypeReturnVisitor;
import view.visitor.LimitTypeVisitor;
import viewClient.ExceptionAndEventHandler;

public class LimitProxi extends LimitTypeProxi implements LimitView{
    
    public LimitProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public LimitView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi money = null;
        String money$String = (String)resultTable.get("money");
        if (money$String != null) {
            common.ProxiInformation money$Info = common.RPCConstantsAndServices.createProxiInformation(money$String);
            money = view.objects.ViewProxi.createProxi(money$Info,connectionKey);
            money.setToString(money$Info.getToString());
        }
        LimitView result$$ = new Limit((MoneyView)money, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(this.getMoney() != null && index < this.getMoney().getTheObject().getChildCount())
            return this.getMoney().getTheObject().getChild(index);
        if(this.getMoney() != null) index = index - this.getMoney().getTheObject().getChildCount();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMoney() == null ? 0 : this.getMoney().getTheObject().getChildCount());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getMoney() == null ? true : this.getMoney().getTheObject().isLeaf());
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getMoney() != null && this.getMoney().equals(child)) return result;
        if(this.getMoney() != null) result = result + 1;
        return -1;
    }
    
    public MoneyView getMoney()throws ModelException{
        return ((Limit)this.getTheObject()).getMoney();
    }
    public void setMoney(MoneyView newValue) throws ModelException {
        ((Limit)this.getTheObject()).setMoney(newValue);
    }
    
    public void accept(LimitTypeVisitor visitor) throws ModelException {
        visitor.handleLimit(this);
    }
    public <R> R accept(LimitTypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleLimit(this);
    }
    public <E extends UserException>  void accept(LimitTypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleLimit(this);
    }
    public <R, E extends UserException> R accept(LimitTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleLimit(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleLimit(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleLimit(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleLimit(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleLimit(this);
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
