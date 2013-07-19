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

create sequence SSrvc nocache;

create table Srvc(
    id number primary key,
    Cls number not null,
    SrvcSbSrvc number,
    SrvcSbSrvcCls number,
    constraint FSrvcSbSrvc foreign key (SrvcSbSrvcCls) references Cls (id),
    SrvcThis number,
    SrvcThisCls number,
    constraint FSrvcThis foreign key (SrvcThisCls) references Cls (id),
    AccntSrvcAccnt number,
    AccntSrvcAccntCls number,
    constraint FAccntSrvcAccnt foreign key (AccntSrvcAccntCls) references Cls (id),
    AdmnstrtrBnks number,
    AdmnstrtrBnksCls number,
    constraint FAdmnstrtrBnks foreign key (AdmnstrtrBnksCls) references Cls (id),
    BnkSrvcBnk number,
    BnkSrvcBnkCls number,
    constraint FBnkSrvcBnk foreign key (BnkSrvcBnkCls) references Cls (id)
);
create index IAccntAccntSrvc on Srvc (AccntSrvcAccnt, AccntSrvcAccntCls);
create index IBnkBnkSrvc on Srvc (BnkSrvcBnk, BnkSrvcBnkCls);


create sequence SSubj nocache;

create table Subj(
    id number primary key,
    Cls number not null,
    SubjThis number,
    SubjThisCls number,
    constraint FSubjThis foreign key (SubjThisCls) references Cls (id)
);

create sequence STrnsctnF nocache;

create table TrnsctnF(
    id number primary key,
    Cls number not null,
    TrnsctnFSbSrvc number,
    TrnsctnFSbSrvcCls number,
    constraint FTrnsctnFSbSrvc foreign key (TrnsctnFSbSrvcCls) references Cls (id),
    TrnsctnFThis number,
    TrnsctnFThisCls number,
    constraint FTrnsctnFThis foreign key (TrnsctnFThisCls) references Cls (id),
    MxdFFx number,
    MxdFFxCls number,
    constraint FMxdFFx foreign key (MxdFFxCls) references Cls (id),
    MxdFPrcntl number,
    MxdFPrcntlCls number,
    constraint FMxdFPrcntl foreign key (MxdFPrcntlCls) references Cls (id),
    MxdFLmt number
);

create sequence SAccnt nocache;

create table Accnt(
    id number primary key,
    Cls number not null,
    AccntAccntNmbr number,
    AccntMn number,
    AccntMnCls number,
    constraint FAccntMn foreign key (AccntMnCls) references Cls (id),
    AccntFrstLmt number,
    AccntFrstLmtCls number,
    constraint FAccntFrstLmt foreign key (AccntFrstLmtCls) references Cls (id),
    AccntScndLmt number,
    AccntScndLmtCls number,
    constraint FAccntScndLmt foreign key (AccntScndLmtCls) references Cls (id),
    AccntSbSrvc number,
    AccntSbSrvcCls number,
    constraint FAccntSbSrvc foreign key (AccntSbSrvcCls) references Cls (id),
    AccntThis number,
    AccntThisCls number,
    constraint FAccntThis foreign key (AccntThisCls) references Cls (id)
);

create sequence SChngNmCMD nocache;

create table ChngNmCMD(
    id number primary key,
    Cls number not null,
    ChngNmCMDNm varchar2(2000),
    ChngNmCMDInvoker number,
    ChngNmCMDInvokerCls number,
    constraint FChngNmCMDInvoker foreign key (ChngNmCMDInvokerCls) references Cls (id),
    ChngNmCMDCReceiver number,
    ChngNmCMDCReceiverCls number,
    constraint FChngNmCMDCReceiver foreign key (ChngNmCMDCReceiverCls) references Cls (id),
    ChngNmCMDMyCmmnDt number,
    ChngNmCMDMyCmmnDtCls number,
    constraint FChngNmCMDMyCmmnDt foreign key (ChngNmCMDMyCmmnDtCls) references Cls (id)
);

create sequence SCrtAccntCMD nocache;

create table CrtAccntCMD(
    id number primary key,
    Cls number not null,
    CrtAccntCMDCrrncTp varchar2(2000),
    CrtAccntCMDInvoker number,
    CrtAccntCMDInvokerCls number,
    constraint FCrtAccntCMDInvoker foreign key (CrtAccntCMDInvokerCls) references Cls (id),
    CrtAccntCMDCReceiver number,
    CrtAccntCMDCReceiverCls number,
    constraint FCrtAccntCMDCReceiver foreign key (CrtAccntCMDCReceiverCls) references Cls (id),
    CrtAccntCMDMyCmmnDt number,
    CrtAccntCMDMyCmmnDtCls number,
    constraint FCrtAccntCMDMyCmmnDt foreign key (CrtAccntCMDMyCmmnDtCls) references Cls (id)
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

create sequence SAccntLmtStt nocache;

create table AccntLmtStt(
    id number primary key,
    Cls number not null,
    AccntLmtSttSbSrvc number,
    AccntLmtSttSbSrvcCls number,
    constraint FAccntLmtSttSbSrvc foreign key (AccntLmtSttSbSrvcCls) references Cls (id),
    AccntLmtSttThis number,
    AccntLmtSttThisCls number,
    constraint FAccntLmtSttThis foreign key (AccntLmtSttThisCls) references Cls (id),
    LmtSttBlnc number,
    LmtSttBlncCls number,
    constraint FLmtSttBlnc foreign key (LmtSttBlncCls) references Cls (id)
);

create sequence SCrrnc nocache;

create table Crrnc(
    id number primary key,
    Cls number not null,
    CrrncSbSrvc number,
    CrrncSbSrvcCls number,
    constraint FCrrncSbSrvc foreign key (CrrncSbSrvcCls) references Cls (id),
    CrrncThis number,
    CrrncThisCls number,
    constraint FCrrncThis foreign key (CrrncThisCls) references Cls (id)
);

create sequence SAmnt nocache;

create table Amnt(
    id number primary key,
    Cls number not null,
    AmntBlnc varchar2(2000),
    AmntSbSrvc number,
    AmntSbSrvcCls number,
    constraint FAmntSbSrvc foreign key (AmntSbSrvcCls) references Cls (id),
    AmntThis number,
    AmntThisCls number,
    constraint FAmntThis foreign key (AmntThisCls) references Cls (id)
);

create sequence SCmmndExctr nocache;

create table CmmndExctr(
    id number primary key,
    Cls number not null
);

create sequence SMn nocache;

create table Mn(
    id number primary key,
    Cls number not null,
    MnBlnc number,
    MnBlncCls number,
    constraint FMnBlnc foreign key (MnBlncCls) references Cls (id),
    MnCrrnc number,
    MnCrrncCls number,
    constraint FMnCrrnc foreign key (MnCrrncCls) references Cls (id),
    MnSbSrvc number,
    MnSbSrvcCls number,
    constraint FMnSbSrvc foreign key (MnSbSrvcCls) references Cls (id),
    MnThis number,
    MnThisCls number,
    constraint FMnThis foreign key (MnThisCls) references Cls (id)
);

create sequence SCrtBnkCMD nocache;

create table CrtBnkCMD(
    id number primary key,
    Cls number not null,
    CrtBnkCMDNm varchar2(2000),
    CrtBnkCMDInvoker number,
    CrtBnkCMDInvokerCls number,
    constraint FCrtBnkCMDInvoker foreign key (CrtBnkCMDInvokerCls) references Cls (id),
    CrtBnkCMDCReceiver number,
    CrtBnkCMDCReceiverCls number,
    constraint FCrtBnkCMDCReceiver foreign key (CrtBnkCMDCReceiverCls) references Cls (id),
    CrtBnkCMDCResult number,
    CrtBnkCMDCResultCls number,
    constraint FCrtBnkCMDCResult foreign key (CrtBnkCMDCResultCls) references Cls (id),
    CrtBnkCMDMyCmmnDt number,
    CrtBnkCMDMyCmmnDtCls number,
    constraint FCrtBnkCMDMyCmmnDt foreign key (CrtBnkCMDMyCmmnDtCls) references Cls (id)
);

create sequence SBnk nocache;

create table Bnk(
    id number primary key,
    Cls number not null,
    BnkBnkNmbr number,
    BnkNm varchar2(2000),
    BnkLstAccNo number,
    BnkFee number,
    BnkFeeCls number,
    constraint FBnkFee foreign key (BnkFeeCls) references Cls (id),
    BnkSbSrvc number,
    BnkSbSrvcCls number,
    constraint FBnkSbSrvc foreign key (BnkSbSrvcCls) references Cls (id),
    BnkThis number,
    BnkThisCls number,
    constraint FBnkThis foreign key (BnkThisCls) references Cls (id)
);
create index IBnkNmbrBnk on Bnk (BnkBnkNmbr);
create index INmBnk on Bnk (BnkNm);


create sequence SDebitTrans nocache;

create table DebitTrans(
    id number primary key,
    Cls number not null,
    DebitTransBnkNmbr number,
    DebitTransAccntNmbr number,
    DebitTransMn number,
    DebitTransMnCls number,
    constraint FDebitTransMn foreign key (DebitTransMnCls) references Cls (id),
    DebitTransSbSrvc number,
    DebitTransSbSrvcCls number,
    constraint FDebitTransSbSrvc foreign key (DebitTransSbSrvcCls) references Cls (id),
    DebitTransThis number,
    DebitTransThisCls number,
    constraint FDebitTransThis foreign key (DebitTransThisCls) references Cls (id)
);

create sequence SSrvr nocache;

create table Srvr(
    id number primary key,
    Cls number not null,
    SrvrSrvc number,
    SrvrSrvcCls number,
    constraint FSrvrSrvc foreign key (SrvrSrvcCls) references Cls (id),
    SrvrSbSrvc number,
    SrvrSbSrvcCls number,
    constraint FSrvrSbSrvc foreign key (SrvrSbSrvcCls) references Cls (id),
    SrvrThis number,
    SrvrThisCls number,
    constraint FSrvrThis foreign key (SrvrThisCls) references Cls (id),
    SrvrPassword varchar2(2000),
    SrvrUser varchar2(2000),
    SrvrHackCount number,
    SrvrHackDelay Timestamp
);
create index ISrvcSrvr on Srvr (SrvrSrvc, SrvrSrvcCls);
create index IUserSrvr on Srvr (SrvrUser);


create sequence SAdmnstrtrBnks nocache;

create table AdmnstrtrBnks(
    id number primary key,
    Cls number not null,
    AdmnstrtrBnksMstr number,
    AdmnstrtrBnksMstrCls number,
    constraint FAdmnstrtrBnksMstr foreign key (AdmnstrtrBnksMstrCls) references Cls (id),
    AdmnstrtrBnksThis number,
    AdmnstrtrBnksThisCls number,
    constraint FAdmnstrtrBnksThis foreign key (AdmnstrtrBnksThisCls) references Cls (id)
);

create sequence SBnkCrtr nocache;

create table BnkCrtr(
    id number primary key,
    Cls number not null,
    BnkCrtrLstBnkNmbr number,
    BnkCrtrSbSrvc number,
    BnkCrtrSbSrvcCls number,
    constraint FBnkCrtrSbSrvc foreign key (BnkCrtrSbSrvcCls) references Cls (id),
    BnkCrtrThis number,
    BnkCrtrThisCls number,
    constraint FBnkCrtrThis foreign key (BnkCrtrThisCls) references Cls (id)
);

create sequence SSubjObs nocache;

create table SubjObs(
    id number primary key,
    frm number not null,
    obs number not null,
    Cls number not null,
    constraint FSubjObsCls foreign key(Cls) references Cls(id),
    constraint FSubjObsfrm foreign key(frm) references Subj(id)
);
create index IFrmSubjObs on SubjObs(frm);

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

create sequence SBnkAccnts nocache;

create table BnkAccnts(
    id number primary key,
    frm number not null,
    BnkAccntsindxx number not null,
    accnts number not null,
    Cls number not null,
    constraint FBnkAccntsCls foreign key(Cls) references Cls(id),
    constraint FBnkAccntsfrm foreign key(frm) references Bnk(id)
);
create index IFrmBnkAccnts on BnkAccnts(frm);
create index IIndxxBnkAccnts on BnkAccnts(BnkAccntsindxx);


create index IAccntsBnkAccnts on BnkAccnts(accnts);
create sequence SAdmnstrtrBnksObs nocache;

create table AdmnstrtrBnksObs(
    id number primary key,
    frm number not null,
    obs number not null,
    Cls number not null,
    constraint FAdmnstrtrBnksObsCls foreign key(Cls) references Cls(id),
    constraint FAdmnstrtrBnksObsfrm foreign key(frm) references AdmnstrtrBnks(id)
);
create index IFrmAdmnstrtrBnksObs on AdmnstrtrBnksObs(frm);