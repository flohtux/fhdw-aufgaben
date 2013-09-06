package model.meta;

public interface EventWrapperMssgs {
    void accept(EventWrapperMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface EventWrapperDOWNMssgs extends Mssgs, EventWrapperMssgs{}
interface EventWrapperUPMssgs extends Mssgs, EventWrapperMssgs{}
