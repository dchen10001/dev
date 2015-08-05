
    create table BOOK (
        BOOK_ID int8 not null,
        AUTHOR varchar(80) not null,
        TITLE varchar(80) not null,
        CREATED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null,
        MODIFIED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null,
        primary key (BOOK_ID)
    );

    create sequence SEQ_BOOK_ID start 1 increment 50;
