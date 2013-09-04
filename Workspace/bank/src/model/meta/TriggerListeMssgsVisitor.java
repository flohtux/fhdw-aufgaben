package model.meta;

public interface TriggerListeMssgsVisitor extends TriggerListeDOWNMssgsVisitor, TriggerListeUPMssgsVisitor {}


interface TriggerListeDOWNMssgsVisitor  {

    public void handleTriggerListeAddTriggerMssg(TriggerListeAddTriggerMssg event) throws persistence.PersistenceException;
    public void handleTriggerListeRemoveTriggerMssg(TriggerListeRemoveTriggerMssg event) throws persistence.PersistenceException;
    
}


interface TriggerListeUPMssgsVisitor  {

    public void handleTriggerListeAddTriggerMssg(TriggerListeAddTriggerMssg event) throws persistence.PersistenceException;
    public void handleTriggerListeRemoveTriggerMssg(TriggerListeRemoveTriggerMssg event) throws persistence.PersistenceException;
    
}
