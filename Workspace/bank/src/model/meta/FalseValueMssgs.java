package model.meta;

public interface FalseValueMssgs {
    void accept(FalseValueMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface FalseValueDOWNMssgs extends BooleanValueDOWNMssgs, FalseValueMssgs{}
interface FalseValueUPMssgs extends Mssgs, FalseValueMssgs{}
