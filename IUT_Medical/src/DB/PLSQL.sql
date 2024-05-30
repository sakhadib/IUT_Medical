drop sequence bill_id_seq;
drop sequence referral_id_seq;
drop sequence prestest_id_seq;
drop sequence presmed_id_seq;
drop sequence visit_id_seq;
drop sequence test_id_seq;
drop sequence medicine_id_seq;



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
--
--
-- -- Query all trigger names
-- -- SELECT TRIGGER_NAME
-- -- FROM USER_TRIGGERS;


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

drop SEQUENCE seq_cse;
drop SEQUENCE seq_eee;
drop SEQUENCE seq_cee;
drop SEQUENCE seq_mpe;
drop SEQUENCE seq_btm;



CREATE SEQUENCE seq_cse START WITH 1 INCREMENT BY 1 MAXVALUE 200 CYCLE NOCACHE;
CREATE SEQUENCE seq_eee START WITH 1 INCREMENT BY 1 MAXVALUE 200 CYCLE NOCACHE;
CREATE SEQUENCE seq_cee START WITH 1 INCREMENT BY 1 MAXVALUE 200 CYCLE NOCACHE;
CREATE SEQUENCE seq_mpe START WITH 1 INCREMENT BY 1 MAXVALUE 200 CYCLE NOCACHE;
CREATE SEQUENCE seq_btm START WITH 1 INCREMENT BY 1 MAXVALUE 200 CYCLE NOCACHE;



CREATE OR REPLACE TRIGGER trg_generate_student_id
BEFORE INSERT ON Student
FOR EACH ROW
DECLARE
v_year VARCHAR2(2);
  v_dept_code VARCHAR2(1);
  v_seq_num VARCHAR2(2);
  v_id VARCHAR2(10);
BEGIN
  -- Extract the last two digits of the current year
  v_year := TO_CHAR(SYSDATE, 'YY');

  -- Determine the department code based on the Department column
CASE :NEW.Department
    WHEN 'CSE' THEN
      v_dept_code := '4';
SELECT LPAD(seq_cse.NEXTVAL, 2, '0') INTO v_seq_num FROM dual;
WHEN 'EEE' THEN
      v_dept_code := '2';
SELECT LPAD(seq_eee.NEXTVAL, 2, '0') INTO v_seq_num FROM dual;
WHEN 'CEE' THEN
      v_dept_code := '5';
SELECT LPAD(seq_cee.NEXTVAL, 2, '0') INTO v_seq_num FROM dual;
WHEN 'MPE' THEN
      v_dept_code := '1';
SELECT LPAD(seq_mpe.NEXTVAL, 2, '0') INTO v_seq_num FROM dual;
WHEN 'BTM' THEN
      v_dept_code := '6';
SELECT LPAD(seq_btm.NEXTVAL, 2, '0') INTO v_seq_num FROM dual;
ELSE
      RAISE_APPLICATION_ERROR(-20001, 'Invalid Department');
END CASE;

  -- Construct the ID
  v_id := v_year || '00' || v_dept_code || '11' || v_seq_num;

  -- Assign the ID to the :NEW.ID field
  :NEW.ID := v_id;
END;
/



Drop sequence doctor_id_seq;
CREATE SEQUENCE doctor_id_seq START WITH 1 INCREMENT BY 1 MAXVALUE 99 CYCLE NOCACHE;

CREATE OR REPLACE TRIGGER doctor_id_trigger
BEFORE INSERT ON Doctor
FOR EACH ROW
BEGIN
  :NEW.ID := 'DOC-' || TO_CHAR(SYSDATE, 'YY') || LPAD(doctor_id_seq.NEXTVAL, 2, '0');
END;
/


CREATE OR REPLACE FUNCTION get_visit_count(student_id VARCHAR2)
RETURN NUMBER IS
    visit_count NUMBER := 0;
BEGIN
    SELECT COUNT(*)
    INTO visit_count
    FROM Visit
    WHERE StudentID = student_id;

    RETURN visit_count;
END;
/


CREATE OR REPLACE FUNCTION get_total_bills_by_month(month_number NUMBER)
RETURN NUMBER IS
  total_amount NUMBER := 0;
BEGIN
SELECT SUM(amount)
INTO total_amount
FROM Bill b
         JOIN Referral r ON b.RefID = r.ID
         JOIN Visit v ON r.VisitID = v.ID
WHERE MONTH(visit_time) = month_number;

RETURN total_amount;
END;
/

CREATE OR REPLACE FUNCTION get_student_total_bill(student_id VARCHAR2)
RETURN NUMBER IS
  total_amount NUMBER := 0;
BEGIN
SELECT SUM(b.amount)
INTO total_amount
FROM Bill b
         JOIN Referral r ON b.RefID = r.ID
         JOIN Visit v ON r.VisitID = v.ID
WHERE v.StudentID = student_id;

RETURN total_amount;
END;
/









