183. Customers Who Never Order

Suppose that a website contains two tables, the `Customers` table and the `Orders` table. Write a SQL query to find all customers who never order anything.

Table: `Customers`.

```
+----+-------+
| Id | Name  |
+----+-------+
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
+----+-------+
```

Table: `Orders`.

```
+----+------------+
| Id | CustomerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+
```

Using the above tables as example, return the following:

```
+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+
```

------------------------------------------------------------------------------------------------

```sql
select Name as Customers
from Customers
where id not in (select distinct CustomerId from Orders);

select Customers.Name Customers
from Customers left join Orders on Customers.id = Orders.CustomerId 
where Orders.id is null;

select Name as Customers
from Customers
where not exists (select * from Orders where CustomerId = Customers.id);
```



Note: 

in, not in 需要注意效率问题，具体情况具体分析。简单SQL中not in和not exists可能会被优化为相同的执行路径。