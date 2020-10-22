 create table BOOK_TBL (
        id bigint(20) NOT NULL AUTO_INCREMENT,
        book_name varchar(255) NOT NULL,
        author varchar(255) NOT NULL,
        description varchar(255) NOT NULL,
        primary key (id),
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;