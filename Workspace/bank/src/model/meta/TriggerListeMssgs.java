package model.meta;

public interface TriggerListeMssgs {
    void accept(TriggerListeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface TriggerListeDOWNMssgs extends Mssgs, TriggerListeMssgs{}
interface TriggerListeUPMssgs extends Mssgs, TriggerListeMssgs{}
