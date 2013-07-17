
package view.visitor;

import view.*;

public abstract class CurrencyStandardVisitor implements CurrencyVisitor {
    
    public void handleDollar(DollarView dollar) throws ModelException{
        this.standardHandling(dollar);
    }
    public void handleEuro(EuroView euro) throws ModelException{
        this.standardHandling(euro);
    }
    protected abstract void standardHandling(CurrencyView currency) throws ModelException;
}
