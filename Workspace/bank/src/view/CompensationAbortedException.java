
package view;


import view.objects.ViewProxi;
import view.visitor.UserExceptionExceptionVisitor;
import view.visitor.UserExceptionReturnExceptionVisitor;
import view.visitor.UserExceptionReturnVisitor;
import view.visitor.UserExceptionVisitor;
import viewClient.ExceptionAndEventHandler;


/* Additional import section end */

@SuppressWarnings("serial")
public class CompensationAbortedException extends view.UserException{
    
    public static CompensationAbortedException fromHashtableToCompensationAbortedException(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String message = (String)resultTable.get("?Message?");
        ViewProxi compensation = null;
        String compensation$String = (String)resultTable.get("compensation");
        if (compensation$String != null) {
            common.ProxiInformation compensation$Info = common.RPCConstantsAndServices.createProxiInformation(compensation$String);
            compensation = view.objects.ViewProxi.createProxi(compensation$Info,connectionKey);
            compensation.setToString(compensation$Info.getToString());
        }
        return new CompensationAbortedException(message, (CompensationView)compensation);
    }
    protected CompensationView compensation;
    
    public CompensationAbortedException(String message, CompensationView compensation) {
        /* Shall not be used. Objects are created on the server only */
        super(message);
        this.compensation = compensation;        
    }
    
    public CompensationView getCompensation()throws ModelException{
        return this.compensation;
    }
    
    public void accept(UserExceptionVisitor visitor) throws ModelException {
        visitor.handleCompensationAbortedException(this);
    }
    public <R> R accept(UserExceptionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCompensationAbortedException(this);
    }
    public <E extends UserException>  void accept(UserExceptionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCompensationAbortedException(this);
    }
    public <R, E extends UserException> R accept(UserExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCompensationAbortedException(this);
    }
    
    
}
