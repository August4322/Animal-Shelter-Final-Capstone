select * from users;

delete from users
where username = 'tester1';

select * from volunteers;

update volunteers
set application_status_id = 1
where username = 'tester1'