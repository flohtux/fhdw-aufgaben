package model.meta;

public interface CompensationMssgs {
    void accept(CompensationMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface CompensationDOWNMssgs extends Mssgs, CompensationMssgs{}
interface CompensationUPMssgs extends Mssgs, CompensationMssgs{}
