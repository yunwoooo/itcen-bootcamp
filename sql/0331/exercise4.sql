use edudb;
-- QUESTION

-- 1. 모든 직원들 급여의 평균을 구한다. (소수점 이하 둘째자리까지만 나타내고 셋째자리 부터는 절삭한다)
--	전직원 급여 평균
--           -------------
--           2073.21
select truncate(avg(SAL), 2) '전직원 급여 평균' from emp;

-- 2. 모든 직원들이 받는 커미션의 합을 구한다.
--	커미션 합
--     -----------
--	 4330
select sum(ifnull(COMM, 0)) '커미션 합' from emp;

-- 3. 모든 직원들의 수를 구한다.
--	직원수
--   -----------
--	 14명
select concat(count(*), '명') '직원수' from emp;

-- 4. 다음과 같이 커미션이 정해진 직원수와 부서가 정해진 직원수를 출력한다.
--	커미션이 정해진 직원수 	부서가 정해진 직원수
--	-----------------------------------------------
--	 6명                    		 13명
select concat(count(COMM), '명') '커미션이 정해진 직원수', concat(count(DEPTNO), '명') '부서가 정해진 직원수' from emp;

-- 5. 각 직무별로 급여합을 출력하되 급여합이 낮은 순으로 출력한다.
--	직무명	       총급여
--	----------------------------
-- 	CLERK             4150 
-- 	PRESIDENT       5000 
-- 	SALESMAN       5600 
-- 	ANALYST         6000 
-- 	MANAGER        8275 
select JOB '직무명', sum(SAL) '총급여' from emp group by JOB order by sum(SAL);

-- 6. 각 부서에서 근무하는 직원들의 인원 명수를 알고싶다. 다음 형식으로 출력하는 SQL
--    을 작성한다 .(순서무관)
--	부서정보	직원수
--	----------------------------
--	미정           1명
-- 	10번 부서    3명
--	20번 부서    4명
--	30번 부서    6명
select IF(DEPTNO, concat(DEPTNO, '번 부서'),'미정') '부서정보', concat(count(ENPNO), '명') '직원수' from emp group by DEPTNO;

-- 7. 년도별로 몇명이 입사했는지 알고싶다. 다음 형식으로 출력하는 SQL
--    을 작성한다 . (많이 입사한 순으로 출력)
--	입사년도 	   입사직원수
--	----------------------------
--	1981년	   10명
--	1982년	   2명
--	1980년	   1명
--	1983년	   1명
select concat(year(HIREDATE), '년') '입사년도', concat(count(ENPNO), '명') '입사직원수' 
from emp 
group by year(HIREDATE) 
order by count(ENPNO) desc;

-- 8. 직무별 급여 총액을 출력하되, 직무가 'MANAGER'인 직원들은 제외한다. 
--   그리고 급여총액이 5000보다 큰 직급과 총급여만 출력한다.
--	직급명		         총액
--	----------------------------
--	SALESMAN          	5,600
--	 ANAYST	  	6,000
select JOB '직급명', format(sum(SAL), 0) '총액' 
from emp 
where JOB != 'MANAGER' 
group by JOB 
having sum(SAL) > 5000;

-- 9. 30번 부서의 직무별 년봉의 평균을 검색한다.
-- 연봉계산은 급여커미션(null이면 0으로 계산)이며 
-- 출력 양식은 소수점 이하 두 자리(반올림)까지 통일된 양식으로 출력한다.
--              직무       			평균급여
--              -------------------------------------
--              SALESMAN         		1600.00
--	  	MANAGER			2850.00
--	  	CLERK			950.00
select JOB '직무', round(avg(SAL + ifnull(COMM, 0)), 2) '평균급여' 
from emp 
where DEPTNO = '30' 
group by JOB;

-- 10. 월별 입사인원을 다음 형식으로 출력하는 SQL 을 작성한다 . 
--     입사월별로 오름차순이며 입사인원이 2명 이상인 경우에만 출력한다.
--	입사월	  인원
--	------- -------
--	1	  2명
--	2 	  2명
--	4	  2명
--	9	  2명
--	10	  3명
select month(HIREDATE) '입사월', concat(count(ENAME), '명') '인원' 
from emp 
group by month(HIREDATE) 
having count(ENPNO) >= 2 
order by '입사월';

-- 11. 직무별 급여의 합을 출력하는데 급여합이 5000을 초과하는 직무에 대해서만 출력한다.

--  직무              급여의 합 
-- --------------------------
-- SALESMAN      5600 
-- MANAGER       8275 
-- ANALYST        6000 
select JOB '직무', sum(SAL) '급여의 합' 
from emp 
group by JOB 
having sum(SAL) > 5000;

-- 12. 1981년도에 입사한 직원들에 대해 직무별 급여합을 출력하는데 직무별 급여합이 3000을 초과하는 
--     경우에 대해서 직무별 급여합이 높은순으로 출력한다.

--   직무          급여합
--  -------------------------------------
-- MANAGER      8275 
-- SALESMAN     5600 
-- PRESIDENT    5000 
select JOB '직무', sum(SAL) '급여합' 
from emp 
where year(HIREDATE) = '1981' 
group by JOB 
having sum(SAL) > 3000 
order by sum(SAL) desc;

