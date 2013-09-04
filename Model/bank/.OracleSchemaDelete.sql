drop sequence SSpecialization;
create sequence SSpecialization nocache;

drop table Specialization cascade constraints;
create table Specialization (
    id number primary key,
    ancestor number,
    constraint FSpecializationAncestor foreign key (ancestor) references Cls(id),
    descendant number,
    constraint FSpecializationDescendant foreign key (descendant) references Cls(id)
);

alter table DebiTrfTran  drop (DebiTrfTranSbjct) cascade constraints;
delete from Association where id = 10309;
