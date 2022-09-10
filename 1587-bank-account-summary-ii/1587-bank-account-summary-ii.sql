/* Write your T-SQL query statement below */
select a.name, sum(b.amount) as 'balance'
from Transactions b
inner join Users a
on a.account = b.account
group by a.name
having sum(b.amount) > 10000;