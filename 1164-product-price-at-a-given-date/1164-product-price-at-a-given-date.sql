/* Write your T-SQL query statement below */
with prod_price as (
    select *, rank() over(partition by product_id order by change_date desc) as rank
    from Products
    where change_date <= '2019-08-16'
),
all_prod as (
    select product_id
    from Products
    group by product_id
)
select a.product_id, isnull(b.new_price, 10) as price
from all_prod as a
left join prod_price as b
    on a.product_id = b.product_id and b.rank = 1