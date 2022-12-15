CREATE TABLE Bank(
 idBank int PRIMARY KEY,
    bankName TEXT
);
CREATE TABLE ATM(
	idAtm int PRIMARY KEY,
    bankID int,
    FOREIGN KEY (bankID) REFERENCES Bank(idBank)
);
CREATE TABLE Customer(
	customerID int PRIMARY KEY,
    name text,
    address text,
    birthDate Date
);
CREATE TABLE Account(
	accountNum int PRIMARY Key,
    balance double, 
    ownerID int,
    managedBy int,
    FOREIGN KEY (ownerID) REFERENCES Customer(customeerID),
    FOREIGN KEY (managedBy) REFERENCES Bank(idBank)
);
CREATE TABLE DebitCard(
	cardNum bigint PRIMARY KEY,
    expirationDate Date,
    cvc int,
    pin int(4),
    accountNum bigint,
    FOREIGN KEY (accountNum) REFERENCES Account(accountNum)
);
CREATE TABLE ATM_Transaction(
	transactionID int PRIMARY KEY,
    transactionDate DateTime,
    type text,
    amount double,
    sourceAcc bigint,
    destinationAcc bigint,
    FOREIGN KEY (sourceAcc) REFERENCES Account(accountNum),
    FOREIGN KEY (destinationAcc) REFERENCES Account(accountNum)
)

INSERT INTO `bank` (`idBank`, `bankName`) VALUES ('4402627', 'Banque Marocaine du Commerce Extérieur'),
                                                 ('7609611', 'Banque Populaire'),
                                                 ('6144223', 'Société Générale'),
                                                 ('8627267', 'Crédit du Maroc'),
                                                 ('5127384', 'Banque Marocaine du Commerce et de l’Industrie'),
                                                 ('8171204', 'Attijariwafa Bank');

INSERT INTO `account`(`accountNum`, `balance`, `ownerID`, `managedBy`) VALUES   (2542654259657329,8153949.97,377286,4402627),                                                
                                                                                (5747790651801502,6632724.79,400413,7609611),                                                
                                                                                (3328650094393971,9066615.56,404835,6144223),                                                
                                                                                (9493026305172610,3307101.59,417021,8627267),                                                
                                                                                (1832799844741109,5383485.12,427994,5127384),                                                
                                                                                (2044755597292756,7115520.50,433032,8171204),                                                
                                                                                (4045147489546212,3900607.18,440369,4402627),                                                
                                                                                (2785873315579420,7430558.30,442830,7609611),                                                
                                                                                (3107695380974069,2377314.14,448129,6144223),                                                
                                                                                (4557095237107118,6939915.66,488091,8627267),                                                
                                                                                (1844505522813216,0444506.87,377286,5127384),                                                
                                                                                (9001520081838626,4059793.43,400413,8171204),                                                
                                                                                (6949630498307470,8189163.32,404835,4402627),                                                
                                                                                (5542340861361240,8719014.97,417021,7609611),                                                
                                                                                (5721793500521634,4954881.69,427994,6144223),                                                
                                                                                (5543127173409368,2054561.72,433032,8627267),                                                
                                                                                (9519577969970345,5076377.00,440369,5127384),                                                
                                                                                (8634324822668517,6481326.17,442830,8171204),                                                
                                                                                (5289462565643452,7453566.56,448129,4402627),                                                
                                                                                (1934976691434905,3044165.23,488091,6144223);

INSERT INTO `atm` (`idAtm`, `bankID`) VALUES     ('371074367','4402627'),
                                                 ('220043411','7609611'),
                                                 ('369685821','6144223'),
                                                 ('101290396','8627267'),
                                                 ('113745628','5127384'),
                                                 ('595971068','8171204'),
                                                 ('249861076','4402627'),
                                                 ('370422311','7609611'),
                                                 ('385937465','6144223'),
                                                 ('415386598','8627267'),
                                                 ('352698385','5127384'),
                                                 ('211391656','8171204'),
                                                 ('402588764','4402627'),
                                                 ('195456624','7609611'),
                                                 ('748101089','6144223'),
                                                 ('431103273','8627267'),
                                                 ('357269384','5127384'),
                                                 ('351332085','8171204');

INSERT INTO `Customer` VALUES (377286,'Lauren Schiller','47318 Hauck Knoll Apt. 831\nRodriguezland, KS 92092-5784','1985-01-09'),
                              (400413,'Assunta Paucek','824 Nannie Key\nDylanfurt, AL 38229','1998-05-27'),
                              (404835,'Maverick Kassulke','5674 Steuber Parkway\nWolffmouth, DC 13516','1992-03-02'),
                              (417021,'Marilou Homenick','9684 Gutkowski Mews\nHudsontown, HI 04810','1993-11-12'),
                              (427994,'Aditya Strosin','65233 Brandyn Villages\nEarnesthaven, OH 03023-6917','1999-12-11'),
                              (433032,'Nestor Skiles','2726 Wuckert Point Apt. 200\nSouth Holdenmouth, AK 32467','1979-05-15'),
                              (440369,'Alysa Schinner','13336 Rickey Isle\nEast Jalonstad, RI 78209-6138','1996-09-22'),
                              (442830,'Cedrick Beier IV','76849 Durgan Estate\nVerliemouth, VT 35265-8758','1984-01-28'),
                              (448129,'Elouise Hermiston','34053 Marlen Lights Apt. 036\nWest Trevorberg, RI 23086','1981-12-03'),
                              (488091,'Merl Towne','5621 Eileen Glen\nWest Cary, LA 57617-6809','1979-12-04');


INSERT INTO `debitcard`(`cardNum`, `expirationDate`, `cvc`,`pin`, `accountNum`) VALUES  (4997544040407235,'2025/09/01',441,1269,2542654259657329),
                                                                                        (4138166082479234,'2023/11/01',213,4962,5747790651801502),
                                                                                        (4269086179396628,'2023/11/01',821,9636,3328650094393971),
                                                                                        (4326410603357770,'2023/12/01',899,2833,9493026305172610),
                                                                                        (4668029198774210,'2025/02/01',867,9627,1832799844741109),
                                                                                        (4425556893431058,'2026/12/01',790,9658,2044755597292756),
                                                                                        (4897997790471299,'2026/05/01',659,1583,4045147489546212),
                                                                                        (4066574294865852,'2026/12/01',709,1050,2785873315579420),
                                                                                        (4178947391782128,'2025/08/01',108,1971,3107695380974069),
                                                                                        (4116572934579212,'2025/09/01',011,4270,4557095237107118),
                                                                                        (4148855036189830,'2023/10/01',576,2829,1844505522813216),
                                                                                        (4894659105668717,'2025/06/01',739,8734,9001520081838626),
                                                                                        (4446602620750016,'2025/06/01',163,5684,6949630498307470),
                                                                                        (4497325885997433,'2026/11/01',692,6872,5542340861361240),
                                                                                        (4722261517986869,'2024/03/01',765,2004,5721793500521634),
                                                                                        (4967335258368934,'2025/12/01',847,7882,5543127173409368),
                                                                                        (4380401351422495,'2024/08/01',844,1964,9519577969970345),
                                                                                        (4463261976888430,'2023/04/01',472,2243,8634324822668517),
                                                                                        (4684343833676870,'2023/12/01',214,2626,5289462565643452),
                                                                                        (4677914429463116,'2023/10/01',074,4828,1934976691434905);












