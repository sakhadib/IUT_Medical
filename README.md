# Smart IUT Medical Center

IUT Medical Center is developed aiming a robust medical center database system using Java, JDBC, and Oracle 11g. This system streamlines patient record management, appointment scheduling, and medical care processes. Ultimately, this project seeks to elevate patient care standards and improve healthcare efficiency.

## Team
**Voyager Team Members:**
 1. **Adib Sakhawat**<br/>
 ID: 210042106<br/>
 BSC in Software Engineering<br/>
 Dept of Computer Science and Engineering<br/>
 
 2.  **Tahsin Islam**<br/>
 ID: 210042137<br/>
 BSC in Software Engineering<br/>
 Dept of Computer Science and Engineering<br/>
 
 3. **Takia Farhin**<br/>
 ID: 210042117<br/>
 BSC in Software Engineering<br/>
 Dept of Computer Science and Engineering<br/>
  
## Key Features
Key features of this project are:
 1. Inventory Management
 2. Prescription Management
 3. Managing Medical History
 4. Billing Integration
 
# Requirement Analysis
### 1. Student Management: 
- The system should be able to maintain a list of students, including their **ID**, **name**, **department**, and **email**.
- Students should be uniquely identified by their **student ID**.

### 2. Doctor Management:
- The system should facilitate the management of doctors ,storing their **ID**, **name**, **specialization**, and **email**.
- Doctors should be identifiable by their respective **IDs**.

### 3. Visit Recording:
- It should enable the recording of student visits to the medical center, capturing the **visit ID**, **student ID**, **doctor ID**, **visit date and time**.
- Each visit should be identifiable by their respective **IDs**.

### 4. Prescription Management:
- It should support the creation and management of prescriptions, including comments from the attending doctor, prescription ID, and associated visit ID.
- Each prescription should be linked to an attendance record. 6. 

### 5. Medicine Inventory:
- The system should maintain an inventory of medicines available at the medical center, including details such as medicine ID, name, generic name, and producer.
- – Medicine entries should be uniquely identified by their IDs. 

### 6. Test Availability:
- It should provide information on available medical tests, storing details such as test ID, name, and fee. 
- Tests should be uniquely identified by their IDs. 8. Prescribed 

### 7. Referral Management:
- It should handle referrals made to external healthcare providers, storing details such as referral ID, comments, and associated visit ID.
- Referrals should be linked to specific visits. 

### 8. Billing System: 
- The system should manage the billing process for services rendered, including bills generated for referred prescriptions.
- Billing records should include the referral ID and amount paid.

# Database Design :

### Tables:

1. **Doctor**:
   - DoctorID (Primary Key)
   - Name
   - Email
   - Specialty

2. **Student**:
   - StudentID (Primary Key)
   - Name
   - Email
   - Department

3. **Test**:
   - TestID (Primary Key)
   - Name
   - Price
   - Available

4. **Visit**:
   - VisitID (Primary Key)
   - StudentID (Foreign Key to Student)
   - DoctorID (Foreign Key to Doctor)
   - Date

5. **PrescriptionMedicine**:
   - PrescriptionMedicineID (Primary Key)
   - VisitID (Foreign Key to Visit)
   - MedicineID (Foreign Key to Medicine)
   - Quantity

6. **PrescriptionTest**:
   - PrescriptionTestID (Primary Key)
   - VisitID (Foreign Key to Visit)
   - TestID (Foreign Key to Test)

7. **Referral**:
   - ReferralID (Primary Key)
   - VisitID (Foreign Key to Visit)
   - Details

8. **Medicine**:
   - MedicineID (Primary Key)
   - Name
   - Generic
   - Company
   - Quantity

### Relationships:

- One doctor can have many visits.
- One student can have many visits.
- One visit can have one doctor and one student.
- One visit can have multiple prescription medicines and prescription tests.
- One prescription medicine belongs to one visit and one medicine.
- One prescription test belongs to one visit and one test.
- One visit can have one referral.
- One referral belongs to one visit.
- Each medicine can be prescribed multiple times.
- Each test can be prescribed multiple times.



## Tools and Technology
1. **Database Management System (DBMS):**
   - Oracle 11g is used for robust data storage, retrieval, and management.
2. **Programming Language and Framework:**
   - Java with JDBC for seamless interaction with the Oracle 11g database.
3. **Version Control and Collaboration:**
   - GitHub for code sharing, branching, and merging to facilitate collaboration.
4. **Documentation:**
   - Overleaf for collaborative editing and real-time compilation of LaTeX documents.
5. **Communication and Meetings:**
   - Google Meet for scheduled meetings and presentations.
   - Discord for real-time chat, quick updates, and ad-hoc discussions.
6. **Presentation Software:**
   - Microsoft PowerPoint for creating visually engaging presentations.
