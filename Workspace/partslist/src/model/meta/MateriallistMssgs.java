package model.meta;

public interface MateriallistMssgs {
    void accept(MateriallistMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MateriallistDOWNMssgs extends Mssgs, MateriallistMssgs{}
interface MateriallistUPMssgs extends Mssgs, MateriallistMssgs{}
