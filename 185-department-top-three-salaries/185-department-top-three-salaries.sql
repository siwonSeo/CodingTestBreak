select
 aa.Department
,aa.Employee
,aa.Salary
from (
select 
DENSE_RANK() OVER(PARTITION BY b.name order by a.salary desc) as salRank
,b.name as Department
,a.salary as Salary
,a.name as Employee
from
Employee a, Department b
where a.departmentId = b.id
) aa
where aa.salRank < 4