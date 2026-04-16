-- QUESTION
use edudb;
-- 1. 'KING'  과 같은 해에 입사한 직원들의 모든 정보를 출력한다.
--       (단, 'KING'의 정보는 제외한다.)
select * from emp 
where year(HIREDATE) = (
	select year(HIREDATE) 
    from emp 
    where ENAME = 'KING'
) and ENAME != 'KING';
-- 2. 'KING'  과 같은 해에 입사하고 같은 부서에서 일하는 직원들의 모든 정보를 출력한다.
--       (단, 'KING'의 정보도 포함하여 출력한다.)
select * from emp 
where year(HIREDATE) = (
	select year(HIREDATE) 
    from emp 
    where ENAME = 'KING'
) and DEPTNO = (
	select DEPTNO 
    from emp 
    where ENAME = 'KING'
);

-- 3. 'BLAKE'와 같은 부서에 있는 직원들의 이름과 입사일을 뽑는데 'BLAKE'는 빼고 출력하는 SQL  명령을 작성하시오.
select ENAME, HIREDATE 
from emp 
where DEPTNO = (
	select DEPTNO 
    from emp 
    where ENAME = 'BLAKE'
) and ENAME != 'BLAKE';

-- 4. 이름에 'T'를 포함하고 있는 직원들과 같은 부서에서 근무하고
--   있는 직원의 직원번호와 이름을 출력하는 SQL 명령을 작성하시오.(출력 순서 무관)
select EMPNO, ENAME from emp 
where DEPTNO in (
	select DEPTNO 
	from emp 
	where ENAME like '%T%'
);

-- 5. 평균급여보다 많은 급여를 받는 직원들의 직원번호, 이름, 월급을
-- 출력하되, 월급이 높은 사람 순으로 출력한다.
select EMPNO, ENAME, concat(format(SAL, 0), '원') 'SAL' from emp 
where SAL > (
	select avg(SAL) 
	from emp
) order by SAL desc;

-- 6 급여가 평균급여보다 많고,이름에 S자가 들어가는 직원과 동일한
--  부서에서 근무하는 모든 직원의 직원번호,이름 및 급여를 출력하는 SQL 명령을 작성하시오.(출력 순서 무관)
select EMPNO, ENAME, SAL from emp 
where SAL > (
	select avg(SAL) 
	from emp
) and DEPTNO in (
	select DEPTNO 
	from emp
    where ENAME like '%s%'
);

-- 7. 30번 부서에 있는 직원들 중에서 가장 많은 월급을 받는 직원보다
--   많은 월급을 받는 직원들의 이름, 부서번호, 월급을 출력하는 SQL 명령을 작성하시오.
--   (단, ALL 또는 ANY 연산자를 사용할 것)
select ENAME '이름', DEPTNO '부서번호', SAL '월급' from emp 
where SAL > ALL(
	select SAL
	from emp
    where DEPTNO = '30'
);

-- 8. SALES 부서에서 일하는 직원들의 부서번호, 이름, 직업을 출력하는 SQL 명령을 작성하시오.
select concat(DEPTNO, '번 부서') '부서 정보', ENAME '직원명', JOB '직무' from emp 
where DEPTNO in (
	select DEPTNO
	from emp
    where DEPTNO = '30'
);

-- 9. 'KING'에게 보고하는 모든 직원의 이름과 입사날짜를 출력하는 SQL 명령을 작성하시오. 
--     (KING에게 보고하는 직원이란 mgr이 KING의 사번인 직원을 의미함) 
select ENAME '직원명', HIREDATE '입사날짜' from emp 
where MGR in (
	select EMPNO
	from emp
    where ENAME = 'KING'
);

-- 10. 2월에 입사한 직원들이 받는 최대 급여보다 많은 급여를 받는 직원들의 모든 정보를 출력한다.
--     (문제해결시 집계함수를 사용하지 않고 해결한다.)  
select * from emp 
where SAL >ALL (
	select SAL
	from emp
    where month(HIREDATE) = '2'
);

-- 11. 2월에 입사한 직원들이 받는 최소 급여보다 많은 급여를 받는 직원들중에서 직무가 ANALYST 인
--      직원들의 모든 정보를 출력한다.
--     (문제해결시 집계함수를 사용하지 않고 해결하며 2월 입사 직원은 제외한다.)  
select * from emp 
where SAL > ANY (
	select SAL
	from emp
    where month(HIREDATE) = '2'
) and JOB = 'ANALYST' 
and month(HIREDATE) != '2';

-- 12. 급여가 3000이상인 직원들과 같은 부서에서 근무하며 커미션이 정해져 있는 
-- 직원들의 정보를 출력하는 SQL 명령을 작성하시오.
select * from emp 
where DEPTNO in (
	select DEPTNO
	from emp
    where SAL >= '3000'
) and COMM is not null;
