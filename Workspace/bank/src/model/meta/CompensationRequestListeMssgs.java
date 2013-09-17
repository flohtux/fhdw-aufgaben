package model.meta;

public interface CompensationRequestListeMssgs {
    void accept(CompensationRequestListeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface CompensationRequestListeDOWNMssgs extends Mssgs, CompensationRequestListeMssgs{}
interface CompensationRequestListeUPMssgs extends Mssgs, CompensationRequestListeMssgs{}
