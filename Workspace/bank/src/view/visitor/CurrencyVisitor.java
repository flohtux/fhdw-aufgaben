
package view.visitor;

import view.*;

public interface CurrencyVisitor {
    
    public void handleEuro(EuroView euro) throws ModelException;
    public void handleDollar(DollarView dollar) throws ModelException;
    
}
