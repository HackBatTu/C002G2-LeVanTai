use quan_li_ban_hang;
insert into customer
value (1,'minh quan',10),
(2,'ngoc oanh',20),(3,'hong ha',50);
insert into orders
value (1,1,'2006-03-21',null),
(2,2,'2006-03-23',null),
(3,1,'2006-03-16',null);
insert into product
value (1,'May Giat',3),(2,'Tu Lanh',5),(3,'Dieu Hoa',7),(4,'Quat',1),(5,'Bep Dien',2);
insert into order_detail
value (1,1,3),(1,3,7),(1,4,2),(2,1,1),(3,1,8),(2,5,4),(2,3,3);

select orders.order_id,orders.date_order,orders.order_total_price from orders;

select customer.customer_name,product.product_name from orders
left join customer on customer.customer_id = orders.customer_id
left join order_detail on order_detail.order_id = orders.order_id
left join product on  product.product_id = order_detail.product_id;

select customer.customer_name from customer
left join orders on customer.customer_id = orders.customer_id
where customer.customer_id = 3;

select orders.order_id,orders.date_order,sum(order_detail.order_qty*product.product_prince) as gia_ban from orders
inner join order_detail on order_detail.order_id = orders.order_id
inner join product on  product.product_id = order_detail.product_id
group by order_id;