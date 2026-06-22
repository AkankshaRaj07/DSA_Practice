# Write your MySQL query statement below
SELECT DISTINCT activity_date as day, count(DISTINCT user_id)
AS active_users
from Activity
group by activity_date
having day between '2019-06-28' and '2019-07-28'