
package view.visitor;
import view.UserException;
import view.*;

public interface CurrencyReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleEuro(EuroView euro) throws ModelException, E;
    public R handleDollar(DollarView dollar) throws ModelException, E;
    
}
