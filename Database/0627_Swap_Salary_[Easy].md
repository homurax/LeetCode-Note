627. Swap Salary

Given a table `salary`, such as the one below, that has m=male and f=female values. Swap all f and m values (i.e., change all f values to m and vice versa) with a **single update statement** and no intermediate temp table.

Note that you must write a single update statement, **DO NOT** write any select statement for this problem.

 

**Example:**

```
| id | name | sex | salary |
|----|------|-----|--------|
| 1  | A    | m   | 2500   |
| 2  | B    | f   | 1500   |
| 3  | C    | m   | 5500   |
| 4  | D    | f   | 500    |
```

After running your **update**

```
| id | name | sex | salary |
|----|------|-----|--------|
| 1  | A    | f   | 2500   |
| 2  | B    | m   | 1500   |
| 3  | C    | f   | 5500   |
| 4  | D    | m   | 500    |
```

------------------------------------------------------------------------------------------------

```sql
select id, name, if(sex = 'm', 'f','m') sex, salary from salary;
select id, name, (case sex when 'f' then 'm' else 'f' end) sex, salary from salary;
select id, name, CHAR(ASCII('f') ^ ASCII('m') ^ ASCII(sex)) sex, salary from salary;
```



Note: 

第三种解法的思路挺有意思的，原理为异或运算。
A ^ A = 0
0 ^ B = B


