
package view.visitor;

import view.*;

public abstract class ComponentStandardVisitor implements ComponentVisitor {
    
    public void handleProduct(ProductView product) throws ModelException{
        this.standardHandling(product);
    }
    public void handleMaterial(MaterialView material) throws ModelException{
        this.standardHandling(material);
    }
    protected abstract void standardHandling(ComponentView component) throws ModelException;
}
