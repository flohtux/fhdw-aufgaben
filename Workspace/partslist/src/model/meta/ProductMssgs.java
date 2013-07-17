package model.meta;

public interface ProductMssgs {
    void accept(ProductMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ProductDOWNMssgs extends ComponentDOWNMssgs, ProductMssgs{}
interface ProductUPMssgs extends Mssgs, ProductMssgs{}
