package model.meta;

public interface AllCompensationListeMssgs {
    void accept(AllCompensationListeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AllCompensationListeDOWNMssgs extends Mssgs, AllCompensationListeMssgs{}
interface AllCompensationListeUPMssgs extends Mssgs, AllCompensationListeMssgs{}
