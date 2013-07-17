package model.meta;

public interface CachedMssgs {
    void accept(CachedMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface CachedDOWNMssgs extends StateDOWNMssgs, CachedMssgs{}
interface CachedUPMssgs extends Mssgs, CachedMssgs{}
