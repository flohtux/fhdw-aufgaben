package model.meta;

public interface TrueValueMssgs {
    void accept(TrueValueMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface TrueValueDOWNMssgs extends BooleanValueDOWNMssgs, TrueValueMssgs{}
interface TrueValueUPMssgs extends Mssgs, TrueValueMssgs{}
