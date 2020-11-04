create table ers_user_roles (
	ers_user_role_id SERIAL PRIMARY KEY,
	user_role text
);

insert into employee_re.ers_user_roles (user_role)
values ('manager');

create table employee_re.ers_users (
	ers_users_id SERIAL PRIMARY KEY,
	ers_username text,
	ers_password text,
	user_first_name text,
	user_last_name text,
	user_email text,
	user_role_id integer references employee_re.ers_user_roles (ers_user_role_id)
);

insert into employee_re.ers_users (ers_username,ers_password,user_first_name,user_last_name,user_email,user_role_id)
values ('employee2', 'password2', 'John', 'Doe', 'doe@gmail.com', 1);

create table employee_re.ers_reimburserment_status (
	reimb_status_id SERIAL PRIMARY KEY,
	reimb_status text
);

insert into employee_re.ers_reimburserment_status (reimb_status)
values ('denied');

create table employee_re.ers_reimburserment_type(
	reimb_type_id SERIAL PRIMARY KEY,
	reimb_type text
);

insert into employee_re.ers_reimburserment_type (reimb_type)
values ('other');

create table employee_re.ers_reimbursement (
	reimb_id SERIAL PRIMARY KEY,
	reimb_amount text,
	reimb_submitted timestamp,
	reimb_resolved timestamp,
	reimb_description text,
	reimb_receipt bytea,
	reimb_author integer references employee_re.ers_users (ers_users_id),
	reimb_status_id integer references employee_re.ers_reimburserment_status (reimb_status_id),
	reimb_type_id integer references employee_re.ers_reimburserment_type (reimb_type_id)
);

insert into employee_re.ers_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, 
reimb_receipt, reimb_author, reimb_status_id, reimb_type_id) values
(1000, current_timestamp, null, 'supplies', null, 1, 1, 1);

create view employee_re.reimbursementview2 as select employee_re.ers_reimbursement.reimb_id, 
employee_re.ers_reimbursement.reimb_amount,
employee_re.ers_reimbursement.reimb_submitted, employee_re.ers_reimbursement.reimb_resolved, 
employee_re.ers_reimbursement.reimb_description, 
employee_re.ers_reimbursement.reimb_receipt, employee_re.ers_users.ers_username,
employee_re.ers_users.user_first_name,
employee_re.ers_users.user_last_name,
employee_re.ers_users.ers_users_id,
employee_re.ers_reimburserment_status.reimb_status_id,
employee_re.ers_reimburserment_status.reimb_status,
employee_re.ers_reimburserment_type.reimb_type,
employee_re.ers_reimburserment_type.reimb_type_id
from employee_re.ers_reimbursement join employee_re.ers_reimburserment_status on 
employee_re.ers_reimbursement.reimb_status_id = employee_re.ers_reimburserment_status.reimb_status_id
join employee_re.ers_reimburserment_type on 
employee_re.ers_reimbursement.reimb_type_id = employee_re.ers_reimburserment_type.reimb_type_id
join employee_re.ers_users on 
employee_re.ers_reimbursement.reimb_author = employee_re.ers_users.ers_users_id;


select * from employee_re.reimbursementview2 where ers_users_id=1;





