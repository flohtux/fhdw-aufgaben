package model.meta;

public interface PercentMssgs {
    void accept(PercentMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface PercentDOWNMssgs extends Mssgs, PercentMssgs{}
interface PercentUPMssgs extends Mssgs, PercentMssgs{}
