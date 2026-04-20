use edudb;
-- QUESTION
-- [ course1 테이블과 course2 테이블을 가지고 문제 해결 - 1번, 2번 ]

-- 1. course1 을 수강하는 학생들과 course2 를 수강하는 학생들의 이름,  
--    나이를 출력하는데 나이가 적은 순으로 출력하시오.
--    단, 두 코스를 모두 수강하는 학생들의 정보는 한 번만 출력한다.
-- name    age  
-- ------------
-- 희동이     6 
-- 짱구       7 
-- 둘리      10 
-- 또치      11 
-- 듀크      11 
-- 도우너    12 
-- 토토로    13 
select name, age
from course1 
union
select name, age
from course2
order by age;

-- 2. course1 을 수강하는 학생들과 course2 를 수강하는 학생들의 이름, 전화 번호 그리고 
--    나이를 출력하는데 나이가 많은 순으로 출력하시오.
--    단, 두 코스를 모두 수강하는 학생들의 정보를 중복해서 출력한다. 

-- name   phone        age 
-- --------------------------
-- 토토로 010-555-5555   13 
-- 도우너 010-333-3333   12 
-- 또치   010-222-2222   11 
-- 듀크   010-777-7777   11
-- 또치   010-222-2222   11 
-- 둘리   010-111-1111   10 
-- 둘리   010-111-1111   10 
-- 짱구   010-666-6666    7 
-- 희동이 010-444-4444    6 
select *
from course1 
union all
select *
from course2
order by age desc;


-- 3. 직무별 그리고 입사년도별 직원들 수를 출력하는데 직무별 직원수(소합계)와 전체 직원수(전체 합계)도 
--    함께 출력한다.

-- 직무      	입사년도 	직원수
-- -----------------------------------------
-- ANALYST       	1981      1
-- ANALYST       	1982      1
-- ANALYST       	NULL      2
-- CLERK         	1980      1
-- CLERK         	1981      1
-- CLERK         	1982      1
-- CLERK         	1983      1
-- CLERK         	NULL      4
-- MANAGER       	1981      3
-- MANAGER       	NULL      3
-- PRESIDENT     	1981      1
-- PRESIDENT     	NULL      1
-- SALESMAN      	1981      4
-- SALESMAN      	NULL      4
-- NULL         	 NULL     14
select ifnull(JOB, 'NULL') '직무', ifnull(year(HIREDATE), 'NULL') '입사년도', count(EMPNO) '직원수'
from emp
group by JOB, year(HIREDATE)
with rollup;

-- [ emp 테이블 외에도 필요에 따라 dept, locations, salgrade 테이블을 가지고 문제 해결(JOIN) ]
-- 먼저 dept, locations, salgrade 테이블의 내용을 확인한다.
-- 4. RESEARCH 부서에서 근무하는 직원의 이름, 직무, 부서이름을 출력하시오.
-- 이름         직무         	부서이름          
-- -------- --------- ------------------
-- SMITH CLERK   RESEARCH 
-- JONES MANAGER RESEARCH 
-- SCOTT ANALYST RESEARCH 
-- FORD  ANALYST RESEARCH 
select ENAME '이름', JOB '직무', DNAME '부서이름'
from emp
join dept
using (DEPTNO)
where DNAME = 'RESEARCH';

-- 5. 이름에 'A'가 들어가는 직원들의 이름과 부서이름을 출력하시오.
-- 이름        부서이름          
-- ------    --------------
-- ALLEN  SALES      
-- WARD   SALES      
-- MARTIN SALES     
-- BLAKE  SALES      
-- CLARK  ACCOUNTING 
-- JAMES  SALES
select ENAME '이름', DNAME '부서이름'
from emp
join dept
using (DEPTNO)
where ENAME like '%A%';

-- 6. 직원이름과 그 직원이 속한 부서의 부서명, 그리고 급여를 
-- 출력하는데 급여가 3000이상인 직원을 출력하시오. 
-- 직원이름      부서명               급여
-- -------- -------------- --------------
-- SCOTT   	   RESEARCH	3,000원
-- KING	   ACCOUNTING	5,000원
-- FORD	   RESEARCH	3,000원
select ENAME '직원이름', DNAME '부서명', concat(format(SAL, 0), '원') '급여'
from emp
join dept
using (DEPTNO)
where SAL >= 3000;

-- 7. 커미션이 책정된 직원들의 직원번호, 이름, 연봉, 연봉커미션,
-- 급여등급을 출력하되, 각각의 컬럼명을 '직원번호', '직원이름',
-- '연봉','실급여', '급여등급'으로 하여 출력하시오. 
-- 또한 실급여가 적은 순으로 출력하시오.
--  직원번호 직원이름      연봉           실급여       급여등급
-- -------- ---------- ---------- --------------- ----------
--  7521 WARD             15000         15200          2
--  7654 MARTIN          15000         15300          2
--  7844 TURNER          18000         18000          3
--  7499	ALLEN	19200         19500	   3
--  7566 JONES    	       35700         35730         4 
--  7839 KING              60000         63500         5
select EMPNO '직원번호', ENAME '직원이름', SAL * 12 '연봉', SAL * 12 + COMM '실급여', GRADE '급여등급'
from emp
join salgrade
on SAL >= LOSAL && HISAL >= SAL
where COMM is not null
order by SAL * 12 + COMM;

-- 8. 부서번호가 10번인 직원들의 부서번호, 부서이름, 직원이름,
-- 급여, 급여등급을 출력하시오. 
--   부서번호 부서이름           직원이름      급여           급여등급
-- -------- -------------- ---------- -------------- -------------
--      10 ACCOUNTING     CLARK            2450          4
--      10 ACCOUNTING     KING              5000          5
--      10 ACCOUNTING     MILLER           1300          2 
select e.DEPTNO '부서번호', DNAME '부서이름', ENAME '직원이름', SAL '급여', GRADE '급여등급'
from emp e
join salgrade
on SAL >= LOSAL && HISAL >= SAL
join dept d
on d.DEPTNO = e.DEPTNO
where e.DEPTNO = '10';

-- 9. 직무가 'SALESMAN'인 직원들의 직무와 그 직원이름, 그리고
-- 그 직원이 속한 부서 이름을 출력하시오. 
-- 직무          직원이름       부서이름          
-- ------- ---------- --------------
-- SALESMAN  TURNER     SALES         
-- SALESMAN  MARTIN     SALES         
-- SALESMAN  WARD       SALES         
-- SALESMAN  ALLEN       SALES 
select JOB '직무', ENAME '직원이름', DNAME '부서이름'
from emp e
join dept d
on d.DEPTNO = e.DEPTNO
where JOB = 'SALESMAN';

-- 10. 부서번호가 10번, 20번인 직원들의 부서번호, 부서이름, 
-- 직원이름, 급여, 급여등급을 출력하시오. 그리고 그 출력된 
-- 결과물을 부서번호가 낮은 순으로, 급여가 많은 순으로 정렬하시오. (7개 행)
--   부서번호 부서이름              직원이름               급여       급여등급
-- -------- -------------- ---------- ---------- ------------ ----------
--    10 ACCOUNTING         KING                   5000          5
--    10 ACCOUNTING         CLARK                 2450          4
--    10 ACCOUNTING         MILLER                 1300          2
--    20 RESEARCH             SCOTT            	3000           4
--    20  RESEARCH    	     FORD       	        3000           4 
--    20  RESEARCH   	    JONES     	        2975           4 
--    20  RESEARCH    	    SMITH      	         800            1 
select e.DEPTNO '부서번호', DNAME '부서이름', ENAME '직원이름', SAL '급여', GRADE '급여등급'
from emp e
join dept d
on e.DEPTNO = d.DEPTNO
join salgrade
on SAL >= LOSAL && HISAL >= SAL
where e.DEPTNO = 10 or e.DEPTNO = 20
order by e.DEPTNO, SAL desc;

-- 11. 사원들의 이름, 부서번호, 부서이름을 출력하시오. 
-- 단, 직원이 없는 부서도 출력하며 이경우 이름을 '없음'이라고 출력한다.     
-- 부서번호별로 정렬한다.
-- 이름               부서번호 부서이름          
-- -------- ---------- --------------
-- CLARK         10  ACCOUNTING 
-- KING          10  ACCOUNTING 
-- MILLER        10  ACCOUNTING 
-- SMITH         20  RESEARCH   
-- JONES         20  RESEARCH   
-- SCOTT         20  RESEARCH   
-- FORD          20  RESEARCH   
-- ALLEN         30  SALES      
-- WARD          30  SALES      
-- MARTIN        30  SALES      
-- BLAKE         30  SALES      
-- TURNER        30  SALES      
-- JAMES         30  SALES      
-- 없음          40  OPERATIONS 
-- 없음          50  INSA       
select ifnull(ENAME, '없음') '이름', d.DEPTNO '부서번호', DNAME '부서이름'
from emp e
right join dept d
on e.DEPTNO = d.DEPTNO
order by d.DEPTNO;

-- 12. 직원들의 이름, 부서번호, 부서이름을 출력하시오. 
-- 단, 아직 부서 배치를 못받은 직원도  출력하며 이경우 부서번호와 부서명은  null 로
-- 출력한다.  또한 직원들의 이름순으로 정렬한다. 
-- 이름               부서번호     부서이름          
-- -------- ---------- ------------------------
-- ADAMS       NULL          	NULL       
-- ALLEN        30             	SALES      
-- BLAKE         30            	SALES  
-- CLARK         10  	ACCOUNTING 
--  FORD          20  	RESEARCH   
-- JAMES         30  	SALES      
-- JONES         20  	RESEARCH   
-- KING          10  	ACCOUNTING 
-- MARTIN        30  	SALES      
-- MILLER        10  	ACCOUNTING 
-- SCOTT         20  	RESEARCH   
-- SMITH         20  	RESEARCH   
-- TURNER        30  	SALES      
-- WARD          30  	SALES                              
select ENAME '이름', ifnull(d.DEPTNO, 'NULL') '부서번호', ifnull(DNAME, 'NULL') '부서이름'
from emp e
left join dept d
on e.DEPTNO = d.DEPTNO
order by ENAME;

-- 13. 커미션이 정해진 모든 직원의 이름, 커미션, 부서이름, 도시명을 출력하시오.

-- 직원명 		커미션 	부서명     	도시명  
-- ---------------------------------------------------------------------
-- KING     		3500 	ACCOUNTING 	SEOUL   
-- JONES      	30 	RESEARCH   	DALLAS  
-- ALLEN     	300 	SALES      	CHICAGO 
-- WARD     	200 	SALES      	CHICAGO 
-- MARTIN   	300 	SALES      	CHICAGO 
-- TURNER      	0 	SALES      	CHICAGO 
select ENAME '직원명', COMM '커미션', DNAME '부서명', CITY '도시명'
from emp e
join dept d
on e.DEPTNO = d.DEPTNO
join locations l
on d.LOC_CODE = l.LOC_CODE
where COMM is not null;

-- 14. DALLAS에서 근무하는 사원의 이름,  급여, 등급을 출력하시오.
-- 이름         급여             등급          
-- -------- --------- --------------
-- SMITH      800             1      
-- JONES      2975           4   
-- SCOTT     3000	           4
-- FORD       3000           4     
select ENAME '직원이름', SAL '급여', GRADE '등급'
from emp e
join dept d
on e.DEPTNO = d.DEPTNO
join salgrade
on SAL >= LOSAL && HISAL >= SAL
join locations l
on d.LOC_CODE = l.LOC_CODE
where CITY = 'DALLAS';

-- 15. 사원들의 이름, 부서번호, 부서명을 출력하시오. 
-- 단, 직원이 없는 부서도 출력하며 이경우 직원 이름을 '누구?'라고
-- 출력한다. 아직 부서 배치를 못받은 직원도  출력하며 부서 번호와 부서 이름을
-- '어디?' 이라고 출력한다.     (16행)
-- 부서명을 기준으로 정렬한다.
-- 직원명   부서번호   부서명    
-- --------------------------------
-- CLARK  10      ACCOUNTING
-- KING   10       ACCOUNTING
-- MILLER 10       ACCOUNTING
-- 누구?  50        INSA      
-- 누구?  40        OPERATIONS
-- SMITH  20       RESEARCH  
-- JONES  20       RESEARCH  
-- SCOTT  20       RESEARCH  
-- FORD   20       RESEARCH  
-- ALLEN  30       SALES     
-- WARD   30       SALES     
-- MARTIN 30       SALES     
-- BLAKE  30       SALES     
-- TURNER 30       SALES     
-- JAMES  30       SALES     
-- ADAMS  어디?    어디?     
select ifnull(ENAME, '누구?') '직원명', ifnull(d.DEPTNO, '어디?') '부서번호', ifnull(DNAME, '어디?') '부서명'
from emp e
left join dept d
on e.DEPTNO = d.DEPTNO
union
select ifnull(ENAME, '누구?') '직원명', ifnull(d.DEPTNO, '어디?') '부서번호', ifnull(DNAME, '어디?') '부서명'
from dept d
left join emp e
on e.DEPTNO = d.DEPTNO
order by 3;

-- 16. 'CHICAGO' 에서 근무하는 직원들의 이름, 입사일, 급여를 출력한다.
--      (서브쿼리로 해결한다.)

-- ename   hiredate    sal  
--------------------------------
-- ALLEN   1981-02-20  1600 
-- WARD    1981-02-22  1250 
-- MARTIN  1981-09-28  1250 
-- BLAKE   1981-04-01  2850 
-- TURNER  1981-09-08  1500 
-- JAMES   1981-10-03   950 
select ename, hiredate, sal
from emp
where DEPTNO in (
	select DEPTNO 
    from dept
    where LOC_CODE in (
		select LOC_CODE
        from locations
        where CITY = 'CHICAGO'));

-- 17. 'CHICAGO' 에서 근무하는 직원들의 이름, 입사일, 부서명을 출력한다.
--      (조인로 해결한다.)

-- ename   hiredate    dname 
-------------------------------------
-- ALLEN   1981-02-20  SALES 
-- WARD    1981-02-22  SALES 
-- MARTIN  1981-09-28  SALES 
-- BLAKE   1981-04-01  SALES 
-- TURNER  1981-09-08  SALES 
-- JAMES   1981-10-03  SALES 
select ename, hiredate, dname
from emp e
join dept d
on e.DEPTNO = d.DEPTNO
join locations l
on d.LOC_CODE = l.LOC_CODE
where CITY = 'CHICAGO';


-- 18. 'DALLAS' 에서 근무하는 직원들의 이름, 연봉, 부서명을 연봉이 큰 순으로 출력하는데
--      연봉의 계산은 (급여+커미션)*12  을 적용하는데 커미션이 정해지지않은 직원은 0으로 계산한다.
     
-- 이름   연봉   부서명   
------------------------
-- JONES  36060  RESEARCH 
-- SCOTT  36000  RESEARCH 
-- FORD   36000  RESEARCH 
-- SMITH   9600  RESEARCH 
select ENAME '이름', (SAL + ifnull(COMM, 0)) * 12 '연봉', DNAME '부서명'
from emp e
join dept d
on e.DEPTNO = d.DEPTNO
join locations l
on d.LOC_CODE = l.LOC_CODE
where CITY = 'DALLAS'
order by (SAL + ifnull(COMM, 0)) * 12 desc;

-- 19 도시명 'SEOUL' 에서 근무중인 직원들의 인원을 출력하시오.
-- 인원수 
--------
--  3명    

select concat(count(*), '명') '인원수'
from emp e
join dept d
on e.DEPTNO = d.DEPTNO
join locations l
on d.LOC_CODE = l.LOC_CODE
where CITY = 'SEOUL'