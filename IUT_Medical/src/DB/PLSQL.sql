-- Create sequence for Bill table ID
CREATE SEQUENCE bill_id_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- Create trigger for Bill table ID
CREATE OR REPLACE TRIGGER bill_id_trigger
BEFORE INSERT ON Bill
FOR EACH ROW
BEGIN
    SELECT bill_id_seq.nextval INTO :new.ID FROM dual;
END;
/


-- Create sequence for Referral table ID
CREATE SEQUENCE referral_id_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- Create trigger for Referral table ID
CREATE OR REPLACE TRIGGER referral_id_trigger
BEFORE INSERT ON Referral
FOR EACH ROW
BEGIN
    SELECT referral_id_seq.nextval INTO :new.ID FROM dual;
END;
/


-- Create sequence for PresTest table ID
CREATE SEQUENCE prestest_id_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- Create trigger for PresTest table ID
CREATE OR REPLACE TRIGGER prestest_id_trigger
BEFORE INSERT ON PresTest
FOR EACH ROW
BEGIN
    SELECT prestest_id_seq.nextval INTO :new.ID FROM dual;
END;
/


-- Create sequence for PresMed table ID
CREATE SEQUENCE presmed_id_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- Create trigger for PresMed table ID
CREATE OR REPLACE TRIGGER presmed_id_trigger
BEFORE INSERT ON PresMed
FOR EACH ROW
BEGIN
    SELECT presmed_id_seq.nextval INTO :new.ID FROM dual;
END;
/


-- Create sequence for Visit table ID
CREATE SEQUENCE visit_id_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- Create trigger for Visit table ID
CREATE OR REPLACE TRIGGER visit_id_trigger
BEFORE INSERT ON Visit
FOR EACH ROW
BEGIN
    SELECT visit_id_seq.nextval INTO :new.ID FROM dual;
END;
/


-- Create sequence for Test table ID
CREATE SEQUENCE test_id_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- Create trigger for Test table ID
CREATE OR REPLACE TRIGGER test_id_trigger
BEFORE INSERT ON Test
FOR EACH ROW
BEGIN
    SELECT test_id_seq.nextval INTO :new.ID FROM dual;
END;
/


-- Create sequence for Medicine table ID
CREATE SEQUENCE medicine_id_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- Create trigger for Medicine table ID
CREATE OR REPLACE TRIGGER medicine_id_trigger
BEFORE INSERT ON Medicine
FOR EACH ROW
BEGIN
    SELECT medicine_id_seq.nextval INTO :new.ID FROM dual;
END;
/


-- Query all trigger names
-- SELECT TRIGGER_NAME
-- FROM USER_TRIGGERS;