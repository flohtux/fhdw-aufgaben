package model.meta;

public interface FeeWrapperMssgs {
    void accept(FeeWrapperMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface FeeWrapperDOWNMssgs extends Mssgs, FeeWrapperMssgs{}
interface FeeWrapperUPMssgs extends Mssgs, FeeWrapperMssgs{}
