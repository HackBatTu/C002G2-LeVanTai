use case_study;
-- task 2
select * from employee
where name_employee like 'H%' or name_employee like  'T%' or name_employee like  'K%' and  length(name_employee) < 15;
-- task 3
select * from customer
where year(curdate())-year(date_customer)>18 and year(curdate())-year(date_customer)<50
and (address like '%Đà Nẵng' or address like '%Quảng Trị');
-- task 4
SELECT customer.id_customer,customer.name_customer,count(promotion.id_customer) as so_lan_dat_phong FROM promotion
JOIN customer ON promotion.id_customer=customer.id_customer
left join customer_type on customer_type.id_customer_type = customer.id_customer_type
where customer_type.name_customer_type = 'Diamond'
group by id_customer
order by count(promotion.id_customer);
-- task 5
select customer.id_customer,customer.name_customer,customer_type.name_customer_type,promotion.id_promotion,service.name_service,promotion.date_check_in,promotion.date_check_out,
promotion.money_checkin + (service.cost_service * promotion_chi_tiet.number_promotion) as tong_tien from customer
left join customer_type on customer.id_customer_type = customer_type.id_customer_type
left join promotion on customer.id_customer = promotion.id_customer
left join service on promotion.id_service = service.id_service
left join promotion_chi_tiet on promotion.id_promotion = promotion_chi_tiet.id_promotion
left join service_di_kem on promotion_chi_tiet.id_service_di_kem = service_di_kem.id_service_di_kem
order by customer.id_customer;
-- task 6
select service.id_service,service.name_service,service.area_service,service.cost_service,type_service.name_type_service from service
inner join type_service on type_service.id_type_service = service.id_type_service
inner join promotion on promotion.id_service = service.id_service
where not month(promotion.date_check_in) = 3 
and not month(promotion.date_check_in) = 2 
and not month(promotion.date_check_in) = 1
group by id_service;
-- task 7
select service.id_service,service.name_service,service.area_service,service.max_person,service.cost_service,type_service.name_type_service from service
join type_service on type_service.id_type_service = service.id_type_service
left join promotion on promotion.id_service = service.id_service
where year(promotion.date_check_in) = 2020 and not year(promotion.date_check_in) =2021
group by id_service;