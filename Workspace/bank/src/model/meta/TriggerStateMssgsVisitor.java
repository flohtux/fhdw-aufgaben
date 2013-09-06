package model.meta;

public interface TriggerStateMssgsVisitor extends TriggerStateDOWNMssgsVisitor, TriggerStateUPMssgsVisitor {}


interface TriggerStateDOWNMssgsVisitor extends DisabledStateDOWNMssgsVisitor, EnabledStateDOWNMssgsVisitor {

    
}


interface TriggerStateUPMssgsVisitor  {

    
}
