
package view.visitor;

import view.*;

public interface ComponentReturnVisitor<R> {
    
    public R handleProduct(ProductView product) throws ModelException;
    public R handleMaterial(MaterialView material) throws ModelException;
    
}
