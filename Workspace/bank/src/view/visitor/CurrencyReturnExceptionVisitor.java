
package view.visitor;
import view.UserException;
import view.*;

public interface CurrencyReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleEuro(EuroView euro) throws ModelException, E;
    public R handleYen(YenView yen) throws ModelException, E;
    public R handlePfund(PfundView pfund) throws ModelException, E;
    public R handleDollar(DollarView dollar) throws ModelException, E;
    public R handleFranken(FrankenView franken) throws ModelException, E;
    
}
