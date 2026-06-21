# Write your MySQL query statement below
select query_name,
             round(avg(rating/position),2) as quality,
             round(SUM(rating < 3) * 100.0 / COUNT(*),2) as poor_query_percentage
from Queries
group by query_name;