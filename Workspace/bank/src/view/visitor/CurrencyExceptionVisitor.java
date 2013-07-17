
package view.visitor;
import view.UserException;
import view.*;

public interface CurrencyExceptionVisitor<E extends UserException> {
    
    public void handleEuro(EuroView euro) throws ModelException, E;
    public void handleDollar(DollarView dollar) throws ModelException, E;
    
}
