# Smart IUT Medical Center

## Abstract
The proposed project aims to develop a robust medical center database system using Java, JDBC, and Oracle 11g. This system will streamline patient record management, appointment scheduling, and medical care processes. Leveraging GitHub for collaboration, Overleaf for documentation, and Google Meet/Discord for communication, the project ensures efficient teamwork. Key features include inventory management, prescription management, medical history, and billing processes integration for enhanced healthcare operations. Ultimately, this project seeks to elevate patient care standards and improve healthcare efficiency.

## Team
**Voyager Team Members:**
- **Adib Sakhawat**
  - ID: 210042106
  - BSC in Software Engineering
  - Dept of Computer Science and Engineering
- **Tahsin Islam**
  - ID: 210042137
  - BSC in Software Engineering
  - Dept of Computer Science and Engineering
- **Takia Farhin**
  - ID: 210042117
  - BSC in Software Engineering
  - Dept of Computer Science and Engineering
## Short Info
**Project Name:** Smart IUT Medical Center  
**Purpose:** Develop a medical center database system to enhance healthcare efficiency at the IUT Medical Center.  
**Key Features:** Inventory management, prescription management, medical history, and billing integration..
# Requirement Analysis

## 1. User Roles:
   - **Admin**: Responsible for managing all aspects of the system.
   - **Doctor**: Can create, update, and delete visits, prescriptions, and tests.
   - **Student**: Can create, update, and delete their own records.
   
## 2. Functionalities:

### Admin:
   - **Manage Bills**:
     - Create, update, delete bills.
     - View bill details by student or doctor.
     - Populate bills with random data.
     
   - **Manage Doctors**:
     - Create, update, delete doctors.
     - Populate doctors with random data.
     
   - **Manage Medicines**:
     - Create, update, delete medicines.
     - Populate medicines with random data.
     
   - **Manage Prescriptions**:
     - Create, update, delete prescription medicines.
     - View prescription details by medicine, doctor, student, or visit.
     - Populate prescription medicines with random data.
     
   - **Manage Prescription Tests**:
     - Create, update, delete prescription tests.
     - View prescription test details by test, doctor, student, or visit.
     - Populate prescription tests with random data.
     
   - **Manage Referrals**:
     - Create, update, delete referrals.
     - View referral details by visit.
     - Populate referrals with random data.
     
   - **Manage Students**:
     - Create, update, delete students.
     - Export student records.
     - Populate students with random data.
     
   - **Manage Tests**:
     - Create, update, delete tests.
     - Populate tests with random data.
     
   - **Manage Visits**:
     - Create, update, delete visits.
     - View visit details by doctor or student.
     - Populate visits with random data.

### Doctor:
   - **Manage Visits**:
     - Create, update, delete visits for their own patients.
     - View visit details for their own patients.

   - **Manage Prescriptions**:
     - Create, update, delete prescriptions for their own patients.
     - View prescription details for their own patients.

   - **Manage Prescription Tests**:
     - Create, update, delete prescription tests for their own patients.
     - View prescription test details for their own patients.

### Student:
   - **Manage Own Details**:
     - Create, update, delete their own records.
     - Export their own record.
     
   - **View Visits**:
     - View visit details for their own visits.

## 3. Additional Considerations:
   - **Data Validation**: Ensure data integrity and validity throughout the system.
   - **Security**: Implement authentication and authorization mechanisms to ensure data privacy and access control.
   - **Error Handling**: Handle exceptions gracefully and provide meaningful error messages to users.
   - **User Interface**: Develop a user-friendly interface for easy interaction with the system.
   - **Scalability**: Design the system to handle a large volume of data and users efficiently.
   - **Documentation**: Maintain comprehensive documentation for easy maintenance and future enhancements.
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
