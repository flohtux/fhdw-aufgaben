package model.meta;

public interface MateriallistValueMssgs {
    void accept(MateriallistValueMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MateriallistValueDOWNMssgs extends Mssgs, MateriallistValueMssgs{}
interface MateriallistValueUPMssgs extends Mssgs, MateriallistValueMssgs{}
