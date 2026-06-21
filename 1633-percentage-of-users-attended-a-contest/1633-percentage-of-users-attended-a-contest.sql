# Write your MySQL query statement below
select r.contest_id, round(count(*) *100.0/
(select count(*) from users),2) as percentage
from register r
join users u
on r.user_id = u.user_id
group by r.contest_id order by percentage desc, contest_id asc;