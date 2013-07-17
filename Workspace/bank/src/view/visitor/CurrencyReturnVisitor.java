
package view.visitor;

import view.*;

public interface CurrencyReturnVisitor<R> {
    
    public R handleEuro(EuroView euro) throws ModelException;
    public R handleDollar(DollarView dollar) throws ModelException;
    
}
