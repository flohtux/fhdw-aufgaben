package model.meta;

public interface CompensationListeMssgs {
    void accept(CompensationListeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface CompensationListeDOWNMssgs extends Mssgs, CompensationListeMssgs{}
interface CompensationListeUPMssgs extends Mssgs, CompensationListeMssgs{}
