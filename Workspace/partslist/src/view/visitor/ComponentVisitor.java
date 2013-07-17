
package view.visitor;

import view.*;

public interface ComponentVisitor {
    
    public void handleProduct(ProductView product) throws ModelException;
    public void handleMaterial(MaterialView material) throws ModelException;
    
}
