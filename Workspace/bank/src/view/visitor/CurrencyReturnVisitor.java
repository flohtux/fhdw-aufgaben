
package view.visitor;

import view.*;

public interface CurrencyReturnVisitor<R> {
    
    public R handleDollar(DollarView dollar) throws ModelException;
    public R handleFranken(FrankenView franken) throws ModelException;
    public R handleEuro(EuroView euro) throws ModelException;
    public R handleYen(YenView yen) throws ModelException;
    public R handlePfund(PfundView pfund) throws ModelException;
    
}
