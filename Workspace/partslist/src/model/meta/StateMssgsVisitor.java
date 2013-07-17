package model.meta;

public interface StateMssgsVisitor extends StateDOWNMssgsVisitor, StateUPMssgsVisitor {}


interface StateDOWNMssgsVisitor extends NotCachedDOWNMssgsVisitor, CachedDOWNMssgsVisitor {

    
}


interface StateUPMssgsVisitor  {

    
}
