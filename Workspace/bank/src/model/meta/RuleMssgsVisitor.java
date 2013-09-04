package model.meta;

public interface RuleMssgsVisitor extends RuleDOWNMssgsVisitor, RuleUPMssgsVisitor {}


interface RuleDOWNMssgsVisitor extends IncomingAccountRuleDOWNMssgsVisitor, SubjectRuleDOWNMssgsVisitor, MoneyRuleDOWNMssgsVisitor {

    
}


interface RuleUPMssgsVisitor  {

    
}
