use case_study;

-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
-- task 2
select * from employee
where name_employee like 'H%' or name_employee like  'T%' or name_employee like  'K%' and  char_length(name_employee) < 15;

-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
-- task 3
select * from customer
where year(curdate())-year(date_customer)>18 and year(curdate())-year(date_customer)<50
and (address like '%Đà Nẵng' or address like '%Quảng Trị');

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
-- task 4
SELECT customer.id_customer,customer.name_customer,count(contract.id_customer) as so_lan_dat_phong FROM contract
JOIN customer ON contract.id_customer=customer.id_customer
left join customer_type on customer_type.id_customer_type = customer.id_customer_type
where customer_type.name_customer_type = 'Diamond'
group by id_customer
order by count(contract.id_customer);

-- 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, 
-- tong_tien (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet)
-- cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
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

-- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu 
-- của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
-- task 6
select service.id_service,service.name_service,service.area_service,service.cost_service,type_service.name_type_service from service
inner join contract on contract.id_service = service.id_service
inner join type_service on type_service.id_type_service = service.id_type_service
where service.id_service not in 
(select contract.id_service from contract where (month(contract.date_check_in) between '1' and '3') and year(contract.date_check_in)= '2021')
group by id_service;

-- 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu
--  của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
-- task 7
select service.id_service,service.name_service,service.area_service,service.max_person,service.cost_service,type_service.name_type_service from service
join type_service on type_service.id_type_service = service.id_type_service
left join contract on contract.id_service = service.id_service
where year(contract.date_check_in) ='2020' and contract.id_service 
not in (select contract.id_service from contract where year(contract.date_check_in) ='2021')
group by id_service;

-- 8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
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

-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
-- task 9
select month(contract.date_check_in),count(contract.id_customer) as so_lan_dat_phong from contract
where year(contract.date_check_in) = '2021'
group by month(contract.date_check_in)
order by month(contract.date_check_in);

-- 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
-- task 10 
select contract.id_contract,contract.date_check_in,contract.date_check_out,contract.money_check_in,
sum(ifnull(details_contract.number_contract,0)) as number from contract
left join details_contract on  contract.id_contract = details_contract.id_contract 
group by id_contract;

-- 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
-- task 11
select accompani_service.id_accompani_service,accompani_service.name_accompani_service from accompani_service
left join details_contract on details_contract.id_accompani_service = accompani_service.id_accompani_service
left join contract on contract.id_contract = details_contract.id_contract
left join customer on customer.id_customer = contract.id_customer
left join customer_type on customer_type.id_customer_type = customer.id_customer_type
where customer_type.name_customer_type = 'Diamond' and ( address like '%Vinh' or address like '%Quảng Ngãi');

-- 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc
--  của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.
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

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
-- task 13
select accompani_service.id_accompani_service,accompani_service.name_accompani_service ,
max(ifnull(details_contract.number_contract,0)) as number_accompani_service from accompani_service
left join details_contract on details_contract.id_accompani_service = accompani_service.id_accompani_service
group by id_accompani_service;

- -- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.
--  Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).
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

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi
--  mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.
-- task 15
select employee.id_employee,employee.name_employee,levels.name_levels,part.name_part,employee.phone,employee.address from employee
left join levels on employee.id_levels = levels.id_levels
left join part  on employee.id_part = part.id_part
left join contract on contract.id_employee = employee.id_employee
where year(contract.date_check_in) between '2020' and '2021' 
group by employee.id_employee
having count(employee.id_employee) >=3;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
-- task 16
set sql_safe_updates = 0;
update employee
set employee.`status` = 1
where employee.id_employee not in 
(select distinct contract.id_employee from contract
where year(contract.date_check_in) between '2019' and '2021' );
set sql_safe_updates = 1;

-- 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
-- task 17 
set sql_safe_updates = 0;
update customer_type
set customer_type.name_customer_type = 'Diamond'
where customer_type.id_customer_type in
(select * from (select customer_type.id_customer_type from customer
left join customer_type on customer.id_customer_type = customer_type.id_customer_type
left join contract on customer.id_customer = contract.id_customer
left join service on contract.id_service = service.id_service
left join details_contract on contract.id_contract = details_contract.id_contract
left join accompani_service on details_contract.id_accompani_service= accompani_service.id_accompani_service
where year(contract.date_check_in) = 2021 and customer_type.name_customer_type = 'Platinium' and 
(service.cost_service + ifnull(details_contract.number_contract * accompani_service.prince,0) >10000000)
group by id_customer_type
 )abc);
set sql_safe_updates = 1;

-- 18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
-- task 18
set sql_safe_updates = 0;
update customer
set customer.`status` = 1 
where customer.id_customer in ( 
select distinct contract.id_customer from contract
where year(contract.date_check_in) < '2021'
);
set sql_safe_updates = 1;


-- 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
-- task 19
set sql_safe_updates = 0;
update accompani_service
set prince = prince * 2
where accompani_service.id_accompani_service = ( select * from (
select accompani_service.id_accompani_service from accompani_service
join details_contract on details_contract.id_accompani_service = accompani_service.id_accompani_service
join contract on details_contract.id_contract = contract.id_contract
where year(contract.date_check_in) = 2020 
group by id_accompani_service
having sum(details_contract.number_contract) >= 10)abc);
set sql_safe_updates = 1;

-- 20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, 
-- thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
-- task 20 
select employee.id_employee,employee.name_employee,employee.email,employee.phone,employee.date_employee,employee.address from employee
union
select customer.id_customer,customer.name_customer,customer.email,customer.phone,customer.date_customer,customer.address from customer