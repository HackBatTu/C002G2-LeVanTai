use case_study;

-- task 2
select * from employee
where name_employee like 'H%' or name_employee like  'T%' or name_employee like  'K%' and  char_length(name_employee) < 15;

-- task 3
select * from customer
where year(curdate())-year(date_customer)>18 and year(curdate())-year(date_customer)<50
and (address like '%Đà Nẵng' or address like '%Quảng Trị');

-- task 4
SELECT customer.id_customer,customer.name_customer,count(contract.id_customer) as so_lan_dat_phong FROM contract
JOIN customer ON contract.id_customer=customer.id_customer
left join customer_type on customer_type.id_customer_type = customer.id_customer_type
where customer_type.name_customer_type = 'Diamond'
group by id_customer
order by count(contract.id_customer);

-- task 5
select customer.id_customer,customer.name_customer,customer_type.name_customer_type,contract.id_contract,service.name_service,contract.date_check_in,contract.date_check_out,
(service.cost_service + ifnull(details_contract.number_contract * accompani_service.prince,0)) as total_money from customer
left join customer_type on customer.id_customer_type=customer_type.id_customer_type
left join contract on customer.id_customer=contract.id_customer
left join service on contract.id_service=service.id_service
left join details_contract on contract.id_contract=details_contract.id_contract
left join accompani_service on details_contract.id_accompani_service= accompani_service.id_accompani_service
group by id_contract,id_customer
order by id_customer;

-- task 6
select service.id_service,service.name_service,service.area_service,service.cost_service,type_service.name_type_service from service
inner join contract on contract.id_service = service.id_service
inner join type_service on type_service.id_type_service = service.id_type_service
where service.id_service not in 
(select contract.id_service from contract where (month(contract.date_check_in) between '1' and '3') and year(contract.date_check_in)= '2021')
group by id_service;

-- task 7
select service.id_service,service.name_service,service.area_service,service.max_person,service.cost_service,type_service.name_type_service from service
join type_service on type_service.id_type_service = service.id_type_service
left join contract on contract.id_service = service.id_service
where year(contract.date_check_in) ='2020' and contract.id_service 
not in (select contract.id_service from contract where year(contract.date_check_in) ='2021')
group by id_service;

-- task 8
-- cách 1 
select name_customer from customer
group by name_customer;
-- cách 2
select name_customer from customer
union
select name_customer from customer;
-- cách 3 
select distinct name_customer from customer;

-- task 9
select month(contract.date_check_in),count(contract.id_customer) as so_lan_dat_phong from contract
where year(contract.date_check_in) = '2021'
group by month(contract.date_check_in)
order by month(contract.date_check_in);

-- task 10 
select contract.id_contract,contract.date_check_in,contract.date_check_out,contract.money_check_in,
sum(ifnull(details_contract.number_contract,0)) as number from contract
left join details_contract on  contract.id_contract = details_contract.id_contract 
group by id_contract;

-- task 11
select accompani_service.id_accompani_service,accompani_service.name_accompani_service from accompani_service
left join details_contract on details_contract.id_accompani_service = accompani_service.id_accompani_service
left join contract on contract.id_contract = details_contract.id_contract
left join customer on customer.id_customer = contract.id_customer
left join customer_type on customer_type.id_customer_type = customer.id_customer_type
where customer_type.name_customer_type = 'Diamond' and ( address like '%Vinh' or address like '%Quảng Ngãi');

-- task 12
select contract.id_contract,employee.name_employee,customer.name_customer,customer.phone,service.id_service,service.name_service,
sum(ifnull(details_contract.number_contract,0)) as number_accompani_service,contract.money_check_in from contract
left join details_contract on contract.id_contract = details_contract.id_contract
left join employee on contract.id_employee = employee.id_employee
left join customer on contract.id_customer = customer.id_customer
left join service on contract.id_service =service.id_service
where ((contract.date_check_in between '2020-10-01' and '2020-12-30') and contract.id_contract not in 
(select contract.id_contract from contract where contract.date_check_in between '2021-01-01' and '2020-06-30'))
group by id_contract;

-- task 13
select accompani_service.id_accompani_service,accompani_service.name_accompani_service ,max(ifnull(details_contract.number_contract,0)) as number_accompani_service from accompani_service
left join details_contract on details_contract.id_accompani_service = accompani_service.id_accompani_service
group by id_accompani_service;

-- task 14 
select contract.id_contract,type_service.name_type_service,accompani_service.name_accompani_service,
count(accompani_service.id_accompani_service) as so_lan_su_dung from type_service
left join service on type_service.id_type_service = service.id_type_service
left join contract on service.id_service = contract.id_service
left join details_contract on contract.id_contract = details_contract.id_contract
left join accompani_service on details_contract.id_accompani_service = accompani_service.id_accompani_service
group by accompani_service.name_accompani_service
having so_lan_su_dung = 1
order by id_contract;

-- task 15
select employee.id_employee,employee.name_employee,levels.name_levels,part.name_part,employee.phone,employee.address from employee
left join levels on employee.id_levels = levels.id_levels
left join part  on employee.id_part = part.id_part
left join contract on contract.id_employee = employee.id_employee
where year(contract.date_check_in) between '2020' and '2021'
group by employee.id_employee
having count(employee.id_employee) >=3;


