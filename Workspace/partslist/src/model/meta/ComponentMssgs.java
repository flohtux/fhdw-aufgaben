package model.meta;

public interface ComponentMssgs {
    void accept(ComponentMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ComponentDOWNMssgs extends Mssgs, ComponentMssgs{}
interface ComponentUPMssgs extends ProductUPMssgs, MaterialUPMssgs, ComponentMssgs{}
