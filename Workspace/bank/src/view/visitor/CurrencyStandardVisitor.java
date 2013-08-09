
package view.visitor;

import view.*;

public abstract class CurrencyStandardVisitor implements CurrencyVisitor {
    
    public void handleDollar(DollarView dollar) throws ModelException{
        this.standardHandling(dollar);
    }
    public void handleFranken(FrankenView franken) throws ModelException{
        this.standardHandling(franken);
    }
    public void handlePfund(PfundView pfund) throws ModelException{
        this.standardHandling(pfund);
    }
    public void handleEuro(EuroView euro) throws ModelException{
        this.standardHandling(euro);
    }
    public void handleYen(YenView yen) throws ModelException{
        this.standardHandling(yen);
    }
    protected abstract void standardHandling(CurrencyView currency) throws ModelException;
}
