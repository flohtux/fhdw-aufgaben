package model.meta;

public interface PartsListManagerMssgs {
    void accept(PartsListManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface PartsListManagerDOWNMssgs extends Mssgs, PartsListManagerMssgs{}
interface PartsListManagerUPMssgs extends Mssgs, PartsListManagerMssgs{}
