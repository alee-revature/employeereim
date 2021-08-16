-- ticket.ticket definition

-- Drop table

-- DROP TABLE ticket.ticket;

CREATE TABLE ticket.ticket (
	ticket_id int4 NOT NULL DEFAULT nextval('ticket.newtable_ticket_id_seq'::regclass),
	"type" varchar(30) NOT NULL,
	amount numeric(6) NOT NULL,
	description varchar NULL,
	file varchar NULL,
	"date" timestamp NOT NULL,
	status varchar NOT NULL,
	CONSTRAINT ticket_pk PRIMARY KEY (ticket_id)
);

-- ticket.employees definition

-- Drop table

-- DROP TABLE ticket.employees;

CREATE TABLE ticket.employees (
	employee_id serial NOT NULL,
	username varchar NOT NULL,
	"password" varchar NOT NULL,
	ticket_id serial NOT NULL,
	CONSTRAINT employees_pk PRIMARY KEY (employee_id),
	CONSTRAINT employees_un UNIQUE (ticket_id)
);


-- ticket.employees foreign keys

ALTER TABLE ticket.employees ADD CONSTRAINT employees_fk FOREIGN KEY (ticket_id) REFERENCES ticket.ticket(ticket_id);