601. Human Traffic of Stadium

X city built a new stadium, each day many people visit it and the stats are saved as these columns: **id**, **visit_****date**, **people**

Please write a query to display the records which have 3 or more consecutive rows and the amount of people more than 100(inclusive).

For example, the table `stadium`

```
+------+------------+-----------+
| id   | visit_date | people    |
+------+------------+-----------+
| 1    | 2017-01-01 | 10        |
| 2    | 2017-01-02 | 109       |
| 3    | 2017-01-03 | 150       |
| 4    | 2017-01-04 | 99        |
| 5    | 2017-01-05 | 145       |
| 6    | 2017-01-06 | 1455      |
| 7    | 2017-01-07 | 199       |
| 8    | 2017-01-08 | 188       |
+------+------------+-----------+
```

For the sample data above, the output is:

```
+------+------------+-----------+
| id   | visit_date | people    |
+------+------------+-----------+
| 5    | 2017-01-05 | 145       |
| 6    | 2017-01-06 | 1455      |
| 7    | 2017-01-07 | 199       |
| 8    | 2017-01-08 | 188       |
+------+------------+-----------+
```

**Note:**
Each day only have one row record, and the dates are increasing with id increasing.

------------------------------------------------------------------------------------------------

```sql
select distinct s1.*
from stadium s1, stadium s2, stadium s3 
where s1.people >= 100 and s2.people >= 100 and s3.people >= 100  
and ( 
    (s1.id - s2.id =1 AND s2.id - s3.id =1 )  
    OR (s2.id - s1.id = 1 AND s1.id - s3.id =1)
    OR (s3.id - s2.id = 1 AND s2.id - s1.id = 1)  
)
order by s1.id;

select distinct s0.* 
from stadium as s0, (
    select case
            when people >= 100 then @count := @count + 1
            else @count := 0
        end as total, id
    from stadium, (select @count := 0) as temp
) as s1 
where 
s1.total >=3 and 
s0.id <= s1.id and 
s0.id >= s1.id - s1.total + 1;
```

