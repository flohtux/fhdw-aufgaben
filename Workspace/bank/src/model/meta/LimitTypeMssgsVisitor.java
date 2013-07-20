package model.meta;

public interface LimitTypeMssgsVisitor extends LimitTypeDOWNMssgsVisitor, LimitTypeUPMssgsVisitor {}


interface LimitTypeDOWNMssgsVisitor extends NoLimitDOWNMssgsVisitor, LimitDOWNMssgsVisitor {

    
}


interface LimitTypeUPMssgsVisitor  {

    
}
