
package view.visitor;
import view.UserException;
import view.*;

public interface ComponentExceptionVisitor<E extends UserException> {
    
    public void handleProduct(ProductView product) throws ModelException, E;
    public void handleMaterial(MaterialView material) throws ModelException, E;
    
}
