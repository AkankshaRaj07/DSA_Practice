# Write your MySQL query statement below
select p.product_id, p.new_price as price
from Products p
Join (
    select product_id, 
    MAX(change_date) as latest_date
    from products
    where change_date <= '2019-08-16'
    group by product_id
) t
on p.product_id = t.product_id
and p.change_date = t.latest_date
UNION

SELECT DISTINCT product_id, 10 AS price
FROM Products
WHERE product_id NOT IN (
    SELECT product_id
    FROM Products
    WHERE change_date <= '2019-08-16'
);