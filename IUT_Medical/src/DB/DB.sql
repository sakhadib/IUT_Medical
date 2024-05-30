DROP TABLE Bill;
DROP TABLE Referral;
DROP TABLE PresTest;
DROP TABLE PresMed;
DROP TABLE Visit;
DROP TABLE Test;
DROP TABLE Medicine;
DROP TABLE Student;
DROP TABLE Doctor;


CREATE TABLE Student (
                         ID VARCHAR2(10),
                         Name VARCHAR2(30),
                         Department VARCHAR2(10),
                         email VARCHAR2(255),
                         PRIMARY KEY (ID)
);

CREATE TABLE Doctor (
                        ID VARCHAR2(10),
                        Name VARCHAR2(100),
                        Specialization VARCHAR2(100),
                        email VARCHAR2(255),
                        PRIMARY KEY (ID)
);

CREATE TABLE Medicine (
                          ID NUMBER,
                          Name VARCHAR2(30),
                          Generic VARCHAR2(30),
                          Company VARCHAR2(50),
                          Quantity NUMBER,
                          PRIMARY KEY (ID)
);

CREATE TABLE Test (
                      ID NUMBER,
                      Name VARCHAR2(30),
                      Price VARCHAR2(30),
                      Availability NUMBER(1),
                      PRIMARY KEY (ID)
);

CREATE TABLE Visit (
                       ID NUMBER,
                       StudentID VARCHAR2(10),
                       DoctorID VARCHAR2(10),
                       VisitTime TIMESTAMP,
                       PRIMARY KEY (ID),
                       CONSTRAINT FK_Visit_DoctorID
                           FOREIGN KEY (DoctorID)
                               REFERENCES Doctor(ID),
                       CONSTRAINT FK_Visit_StudentID
                           FOREIGN KEY (StudentID)
                               REFERENCES Student(ID)
);

CREATE TABLE PresMed (
                         ID NUMBER,
                         VisitID NUMBER,
                         MedicineID NUMBER,
                         Quantity NUMBER,
                         PRIMARY KEY (ID),
                         CONSTRAINT FK_PresMed_VisitID
                             FOREIGN KEY (VisitID)
                                 REFERENCES Visit(ID),
                         CONSTRAINT FK_PresMed_MedicineID
                             FOREIGN KEY (MedicineID)
                                 REFERENCES Medicine(ID)
);

CREATE TABLE PresTest (
                          ID NUMBER,
                          VisitID NUMBER,
                          TestID NUMBER,
                          PRIMARY KEY (ID),
                          CONSTRAINT FK_PresTest_VisitID
                              FOREIGN KEY (VisitID)
                                  REFERENCES Visit(ID),
                          CONSTRAINT FK_PresTest_TestID
                              FOREIGN KEY (TestID)
                                  REFERENCES Test(ID)
);

CREATE TABLE Referral (
                          ID NUMBER,
                          VisitID NUMBER,
                          details VARCHAR2(255),
                          PRIMARY KEY (ID),
                          CONSTRAINT FK_Referral_VisitID
                              FOREIGN KEY (VisitID)
                                  REFERENCES Visit(ID)
);

CREATE TABLE Bill (
                      ID NUMBER,
                      RefID NUMBER,
                      Amount NUMBER,
                      PRIMARY KEY (ID),
                      CONSTRAINT FK_Bill_RefID
                          FOREIGN KEY (RefID)
                              REFERENCES Referral(ID)
);
