
package view.visitor;
import view.UserException;
import view.*;

public interface ComponentReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleProduct(ProductView product) throws ModelException, E;
    public R handleMaterial(MaterialView material) throws ModelException, E;
    
}
