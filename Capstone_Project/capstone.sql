create database Capstone;
use Capstone;
create table Account
(
acnumber varchar(6) not null,
custid varchar(6),
bid varchar(6),
opening_balance int ,
aod date,
atype varchar(10),
astatus varchar(10),
CONSTRAINT account_acnumber_pk PRIMARY KEY(acnumber),
  	CONSTRAINT account_custid_fk FOREIGN KEY(custid) REFERENCES Customer(custid),
  	CONSTRAINT account_bid_fk FOREIGN KEY(bid) REFERENCES Branch(bid)

);

create table Branch
(
bid varchar(6) not null,
bname varchar(30),
bcity varchar(30),
CONSTRAINT branch_bid_pk PRIMARY KEY(bid)
);

create table Customer
(
custid varchar(6),
fname varchar(30),
mname varchar(30),
ltname varchar(30),
city varchar(15),
mobileno varchar(10),
occupation varchar(10),
dob date ,
CONSTRAINT customer_custid_pk PRIMARY KEY(custid)

);

create table Loan
(
custid varchar(6) not null,
bid varchar(6) not null,
loan_amount int ,
CONSTRAINT loan_customer_custid_bid_pk PRIMARY KEY(custid,bid),
	CONSTRAINT loan_custid_fk FOREIGN KEY(custid) REFERENCES  Customer(custid),
	CONSTRAINT loan_bid_fk FOREIGN KEY(bid) REFERENCES  Branch(bid)

);

create table Trandetails
(
tnumber varchar(6) not null,
acnumber varchar(6),
dot date ,
medium_of_transation varchar(20),
transaction_type varchar(20),
transaction_amount int ,
 
CONSTRAINT trandetails_tnumber_pk PRIMARY KEY(tnumber),
 CONSTRAINT trandetails_acnumber_fk FOREIGN KEY(acnumber) REFERENCES Account(acnumber)

);
