# AngularEaters
team1- javabootcamp2017


# Setup
git clone https://github.com/akilaarthy/AngularEaters.git
Then cd to AngularEaters/CapEat
Then npm i --force
Then npm start


# Check in 
please create a branch and then check in 
git branch

git remote --v 

git checkout -b branch name 
git add . 
git commit -m "mesaage "

git push yourremote branch name (never used master)

Then go to github and issue the Pull request


# AWS EC2 - 1st one with Jenkins 
http://ec2-54-173-215-135.compute-1.amazonaws.com:8080 

# AWS EC2 - 2nd one with Tomcat
ec2-34-205-125-150.compute-1.amazonaws.com

http://ec2-34-205-125-150.compute-1.amazonaws.com:8080/Caponeeat/


# log in into AWS
ssh -i "mykey.pem" ec2-user@ec2-54-173-215-135.compute-1.amazonaws.com



# Jenkins
http://ec2-54-173-215-135.compute-1.amazonaws.com:8080/job/capEATjob/


#Endpoint to connect postgress
capeat.cn0466qhz7wl.us-east-1.rds.amazonaws.com

DBUsername capEAT

pwd - test1234

#Create Table Queries

CREATE TABLE "capEAT".indianfood
(
    indianfoodproductid integer NOT NULL,
    orderid serial NOT NULL,
    productname character varying(30) NOT NULL,
    description character varying(100),
    price money NOT NULL,
    PRIMARY KEY (productid)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE "capEAT".indianfood
    OWNER to "capEAT";

CREATE TABLE "capEAT".bewell
(
    bewellproductid integer NOT NULL,
    orderid serial NOT NULL,
    productname character varying(30) NOT NULL,
    price money NOT NULL,
    description character varying(100),
    PRIMARY KEY (productid)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE "capEAT".bewell
    OWNER to "capEAT";




CREATE TABLE "capEAT".employee
(
    id serial NOT NULL,
    eid character varying NOT NULL,
    password character varying NOT NULL,
    PRIMARY KEY (eid)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE "capEAT".employee
    OWNER to "capEAT";



CREATE TABLE "capEAT".employeedetails
(
    serial serial NOT NULL,
    eid character varying NOT NULL,
    firstname text NOT NULL,
    lastname text NOT NULL,
    email character varying(30) NOT NULL,
    location character varying(30) NOT NULL,
    PRIMARY KEY (serial)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE "capEAT".employeedetails
    OWNER to "capEAT";



CREATE TABLE "capEAT".orders
(
    orderid serial NOT NULL,
    productid integer NOT NULL;
    ccid serial NOT NULL,
    eid character varying NOT NULL,
    itemname character varying(30) NOT NULL,
    itemdescription character varying(100) NOT NULL,
    spicelevel integer,
    quantity integer NOT NULL,
    instructions character varying(150),
    paymentid integer NOT NULL,
    PRIMARY KEY (orderid)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE "capEAT".orders
    OWNER to "capEAT";



CREATE TABLE "capEAT".creditcard
(
    ccid serial NOT NULL,
    cardtype character varying(30) NOT NULL,
    cardnumber numeric(16) NOT NULL,
    cvv numeric(4) NOT NULL,
    expdate date NOT NULL,
    eid character varying NOT NULL,
    opt boolean NOT NULL,
    caponecard boolean NOT NULL,
    PRIMARY KEY (ccid)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE "capEAT".creditcard
    OWNER to "capEAT";




CREATE TABLE "capEAT".payments
(
    paymentid serial NOT NULL,
    orderid serial NOT NULL,
    amount money NOT NULL,
    donation money,
    ccid serial NOT NULL,
    PRIMARY KEY (paymentid)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE "capEAT".payments
    OWNER to "capEAT";

#Set Foreign Key Queries

ALTER TABLE "capEAT".creditcard
    ADD FOREIGN KEY (eid)
    REFERENCES "capEAT".employee (eid) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE "capEAT".bewell
    ADD FOREIGN KEY (orderid)
    REFERENCES "capEAT".orders (orderid) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE "capEAT".indianfood
    ADD FOREIGN KEY (orderid)
    REFERENCES "capEAT".orders (orderid) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE "capEAT".orders
    ADD FOREIGN KEY (productid)
    REFERENCES "capEAT".bewell (bewellproductid) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE "capEAT".orders
    ADD FOREIGN KEY (productid)
    REFERENCES "capEAT".indianfood (indianfoodproductid) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE "capEAT".employeedetails
    ADD CONSTRAINT eid FOREIGN KEY (eid)
    REFERENCES "capEAT".employee (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE "capEAT".orders
    ADD CONSTRAINT eid FOREIGN KEY (eid)
    REFERENCES "capEAT".employee (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE "capEAT".orders
    ADD CONSTRAINT ccid FOREIGN KEY (ccid)
    REFERENCES "capEAT".creditcard (ccid) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE "capEAT".payments
    ADD CONSTRAINT ccid FOREIGN KEY (ccid)
    REFERENCES "capEAT".creditcard (ccid) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE "capEAT".payments
    ADD FOREIGN KEY (orderid)
    REFERENCES "capEAT".orders (orderid) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

#Insert Query

INSERT INTO employee(password, eid, id)
VALUES
 ('test1234', 'ABCD123', 1);

INSERT INTO employeedetails(serial, firstname, lastname, email, location, eid)
VALUES
 (1, 'Joyce', 'Byers', 'j.byers@capone.com', 'WC4', 'ABCD123');

 INSERT INTO creditcard(ccid, cardtype, cardnumber, cvv, opt, caponecard, eid, expdate)
VALUES
 (1, 'MasterCard', 5123454321234567, 708, true, true, 'ABCD123', '04/20');

 INSERT INTO orders(orderid, itemname, itemdescription, spicelevel, quantity, instructions, paymentid, eid, ccid, productid)
VALUES
 (1, 'Cheese Pizza', 'Cheese Pizza with Mozzerella Cheese and Marinara Sauce', 0, 1, 'Substitue Mozzerella for Provolone Cheese', 1, 'ABCD123', 1 , 1);

  INSERT INTO payments(paymentid, orderid, amount, donation, eid, ccid)
VALUES
 (1, 1, '$5.00', '$1.00', 'ABCD123', 1);

INSERT INTO bewell(productid, orderid, productname, price)
VALUES
 (1, 1, 'Cheese Pizza', '$5.00');

 INSERT INTO indianfood(productid, orderid, productname, price)
VALUES
 (1, 1, 'Palak Paneer', '$6.00');
