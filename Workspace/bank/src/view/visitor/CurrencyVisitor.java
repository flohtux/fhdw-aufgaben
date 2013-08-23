
package view.visitor;

import view.*;

public interface CurrencyVisitor {
    
    public void handleDollar(DollarView dollar) throws ModelException;
    public void handleFranken(FrankenView franken) throws ModelException;
    public void handleEuro(EuroView euro) throws ModelException;
    public void handleYen(YenView yen) throws ModelException;
    public void handlePfund(PfundView pfund) throws ModelException;
    
}
