
    create table BOOK (
        BOOK_ID int8 not null,
        AUTHOR varchar(80) not null,
        TITLE varchar(80) not null,
        CREATED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null,
        MODIFIED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null,
        primary key (BOOK_ID)
    );

    create table EMPLOYEE (
        EMPNUM int8 not null,
        BIRTHDATE date not null,
        FIRSTNAME varchar(40) not null,
        GENDER varchar(255) not null,
        HIREDATE date not null,
        LASTNAME varchar(40) not null,
        primary key (EMPNUM)
    );

    create table PHONE (
        ID int8 not null,
        PHONENUM varchar(40) not null,
        EmployeeId int8 not null,
        primary key (ID)
    );

    alter table PHONE 
        add constraint FK489454E6B236B0D 
        foreign key (EmployeeId) 
        references EMPLOYEE;

    create sequence SEQ_BOOK_ID start 1 increment 50;

    create sequence SEQ_EMP_ID start 1 increment 5;

    create sequence SEQ_PHONE_ID start 1 increment 5;
