626. Exchange Seats

Mary is a teacher in a middle school and she has a table `seat` storing students' names and their corresponding seat ids.

The column **id**

 

Mary wants to change seats for the adjacent students.

 

Can you write a SQL query to output the result for Mary?

 

```
+---------+---------+
|    id   | student |
+---------+---------+
|    1    | Abbot   |
|    2    | Doris   |
|    3    | Emerson |
|    4    | Green   |
|    5    | Jeames  |
+---------+---------+
```

For the sample input, the output is:

 

```
+---------+---------+
|    id   | student |
+---------+---------+
|    1    | Doris   |
|    2    | Abbot   |
|    3    | Green   |
|    4    | Emerson |
|    5    | Jeames  |
+---------+---------+
```

**Note:**
If the number of students is odd, there is no need to change the last one's seat.

------------------------------------------------------------------------------------------------

```sql
select (case
      when mod(id,2) !=0 and id!=counts then id+1
      when mod(id,2) !=0 and id =counts then id
      else id-1 end)as id, 
      student
from seat, (select count(*) as counts from seat) as seat_counts
order by id;

select
    s1.id, COALESCE(s2.student, s1.student) student
from
    seat s1
        LEFT JOIN
    seat s2 ON ((s1.id + 1) ^ 1) - 1 = s2.id
order by s1.id;
```

