create table Cls(
    id number primary key,
    name varchar2(2000) not null,
    concrete number not null
);

create table DeletedObjects(
    id number,
    instanceOf number not null,
    constraint FDeletedObjectsInstanceOf foreign key (instanceOf) references Cls(id)
);
create unique index DltdObjInx on DeletedObjects (id, instanceOf);

create sequence SSpecialization nocache;

create table Specialization (
    id number primary key,
    ancestor number,
    constraint FSpecializationAncestor foreign key (ancestor) references Cls(id),
    descendant number,
    constraint FSpecializationDescendant foreign key (descendant) references Cls(id)
);

create table Association (
    id number,
    owner number,
    name varchar2(2000),
    constraint FAssociationOwner foreign key (owner) references Cls(id),
    target number,
    constraint FAssociationTarget foreign key (target) references Cls(id),
    complexity number
);

create table Association3 (
    id number,
    owner number,
    name varchar2(2000),
    constraint FAssociation3Owner foreign key (owner) references Cls(id),
    indxx number,
    constraint FAssociation3Indxx foreign key (indxx) references Cls(id),
    target number,
    constraint FAssociation3Target foreign key (target) references Cls(id)
);

create sequence SCrtCmpnntCMD nocache;

create table CrtCmpnntCMD(
    id number primary key,
    Cls number not null,
    CrtCmpnntCMDNm varchar2(2000),
    CrtCmpnntCMDCmpnntTp varchar2(2000),
    CrtCmpnntCMDInvoker number,
    CrtCmpnntCMDInvokerCls number,
    constraint FCrtCmpnntCMDInvoker foreign key (CrtCmpnntCMDInvokerCls) references Cls (id),
    CrtCmpnntCMDCReceiver number,
    CrtCmpnntCMDCReceiverCls number,
    constraint FCrtCmpnntCMDCReceiver foreign key (CrtCmpnntCMDCReceiverCls) references Cls (id),
    CrtCmpnntCMDCResult number,
    CrtCmpnntCMDCResultCls number,
    constraint FCrtCmpnntCMDCResult foreign key (CrtCmpnntCMDCResultCls) references Cls (id),
    CrtCmpnntCMDMyCmmnDt number,
    CrtCmpnntCMDMyCmmnDtCls number,
    constraint FCrtCmpnntCMDMyCmmnDt foreign key (CrtCmpnntCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCmmndExctr nocache;

create table CmmndExctr(
    id number primary key,
    Cls number not null    
);

create sequence SPrtsLstMngr nocache;

create table PrtsLstMngr(
    id number primary key,
    Cls number not null,
    PrtsLstMngrThis number,
    PrtsLstMngrThisCls number,
    constraint FPrtsLstMngrThis foreign key (PrtsLstMngrThisCls) references Cls (id)    
);

create sequence SQPrt nocache;

create table QPrt(
    id number primary key,
    Cls number not null,
    QPrtAmnt number,
    QPrtCmpnnt number,
    QPrtCmpnntCls number,
    constraint FQPrtCmpnnt foreign key (QPrtCmpnntCls) references Cls (id),
    QPrtThis number,
    QPrtThisCls number,
    constraint FQPrtThis foreign key (QPrtThisCls) references Cls (id)    
);
create index ICmpnntQPrt on QPrt (QPrtCmpnnt, QPrtCmpnntCls);


create sequence SSrvr nocache;

create table Srvr(
    id number primary key,
    Cls number not null,
    SrvrThis number,
    SrvrThisCls number,
    constraint FSrvrThis foreign key (SrvrThisCls) references Cls (id),
    SrvrPassword varchar2(2000),
    SrvrUser varchar2(2000),
    SrvrHackCount number,
    SrvrHackDelay Timestamp    
);
create index IUserSrvr on Srvr (SrvrUser);


create sequence SAddCmpnntCMD nocache;

create table AddCmpnntCMD(
    id number primary key,
    Cls number not null,
    AddCmpnntCMDPrdct number,
    AddCmpnntCMDPrdctCls number,
    constraint FAddCmpnntCMDPrdct foreign key (AddCmpnntCMDPrdctCls) references Cls (id),
    AddCmpnntCMDNwPrt number,
    AddCmpnntCMDNwPrtCls number,
    constraint FAddCmpnntCMDNwPrt foreign key (AddCmpnntCMDNwPrtCls) references Cls (id),
    AddCmpnntCMDAmnt number,
    AddCmpnntCMDInvoker number,
    AddCmpnntCMDInvokerCls number,
    constraint FAddCmpnntCMDInvoker foreign key (AddCmpnntCMDInvokerCls) references Cls (id),
    AddCmpnntCMDCReceiver number,
    AddCmpnntCMDCReceiverCls number,
    constraint FAddCmpnntCMDCReceiver foreign key (AddCmpnntCMDCReceiverCls) references Cls (id),
    AddCmpnntCMDMyCmmnDt number,
    AddCmpnntCMDMyCmmnDtCls number,
    constraint FAddCmpnntCMDMyCmmnDt foreign key (AddCmpnntCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SMtrllst nocache;

create table Mtrllst(
    id number primary key,
    Cls number not null,
    MtrllstThis number,
    MtrllstThisCls number,
    constraint FMtrllstThis foreign key (MtrllstThisCls) references Cls (id)    
);

create sequence SStt nocache;

create table Stt(
    id number primary key,
    Cls number not null,
    SttThis number,
    SttThisCls number,
    constraint FSttThis foreign key (SttThisCls) references Cls (id),
    CchdCchdLst number,
    CchdCchdLstCls number,
    constraint FCchdCchdLst foreign key (CchdCchdLstCls) references Cls (id)    
);

create sequence SCmmndCrdntr nocache;

create table CmmndCrdntr(
    id number primary key,
    Cls number not null    
);

create sequence SCmmnDt nocache;

create table CmmnDt(
    id number primary key,
    Cls number not null,
    CmmnDtCrtdt Date,
    CmmnDtCmmtdt Date    
);

create sequence SMtrllstVl nocache;

create table MtrllstVl(
    id number primary key,
    Cls number not null,
    MtrllstVlMtrl number,
    MtrllstVlMtrlCls number,
    constraint FMtrllstVlMtrl foreign key (MtrllstVlMtrlCls) references Cls (id),
    MtrllstVlAmnt number,
    MtrllstVlThis number,
    MtrllstVlThisCls number,
    constraint FMtrllstVlThis foreign key (MtrllstVlThisCls) references Cls (id)    
);

create sequence SCmpnnt nocache;

create table Cmpnnt(
    id number primary key,
    Cls number not null,
    CmpnntNm varchar2(2000),
    CmpnntCrrntStt number,
    CmpnntCrrntSttCls number,
    constraint FCmpnntCrrntStt foreign key (CmpnntCrrntSttCls) references Cls (id),
    CmpnntThis number,
    CmpnntThisCls number,
    constraint FCmpnntThis foreign key (CmpnntThisCls) references Cls (id)    
);
create index INmCmpnnt on Cmpnnt (CmpnntNm);
create index ICrrntSttCmpnnt on Cmpnnt (CmpnntCrrntStt, CmpnntCrrntSttCls);


create sequence SCmmndExctrCommands nocache;

create table CmmndExctrCommands(
    id number primary key,
    frm number not null,
    commands number not null,
    Cls number not null,
    constraint FCmmndExctrCommandsCls foreign key(Cls) references Cls(id),
    constraint FCmmndExctrCommandsfrm foreign key(frm) references CmmndExctr(id)
);
create index IFrmCmmndExctrCommands on CmmndExctrCommands(frm);

create sequence SPrdctPrts nocache;

create table PrdctPrts(
    id number primary key,
    frm number not null,
    prts number not null,
    Cls number not null,
    constraint FPrdctPrtsCls foreign key(Cls) references Cls(id),
    constraint FPrdctPrtsfrm foreign key(frm) references Cmpnnt(id)
);
create index IFrmPrdctPrts on PrdctPrts(frm);


create index IPrtsPrdctPrts on PrdctPrts(prts);
create sequence SSrvrCmpnnts nocache;

create table SrvrCmpnnts(
    id number primary key,
    frm number not null,
    cmpnnts number not null,
    Cls number not null,
    constraint FSrvrCmpnntsCls foreign key(Cls) references Cls(id),
    constraint FSrvrCmpnntsfrm foreign key(frm) references Srvr(id)
);
create index IFrmSrvrCmpnnts on SrvrCmpnnts(frm);

create sequence SMtrllstVls nocache;

create table MtrllstVls(
    id number primary key,
    frm number not null,
    vls number not null,
    Cls number not null,
    constraint FMtrllstVlsCls foreign key(Cls) references Cls(id),
    constraint FMtrllstVlsfrm foreign key(frm) references Mtrllst(id)
);
create index IFrmMtrllstVls on MtrllstVls(frm);

create sequence SCmmndCrdntrExctr nocache;

create table CmmndCrdntrExctr(
    id number primary key,
    frm number not null,
    exctr number not null,
    Cls number not null,
    constraint FCmmndCrdntrExctrCls foreign key(Cls) references Cls(id),
    constraint FCmmndCrdntrExctrfrm foreign key(frm) references CmmndCrdntr(id)
);
create index IFrmCmmndCrdntrExctr on CmmndCrdntrExctr(frm);

