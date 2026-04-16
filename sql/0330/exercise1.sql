-- QUESTION
use edudb;
-- 1. edudb에 존재하는 모든 테이블의 리스트를 출력하는 명령을 작성하시오.
show tables;
-- 2. emp 테이블과 dept 테이블의 구조(컬럼정보)를 출력하는 명령을 작성하시오.
desc emp;
desc dept;
-- 3. 사원(emp)테이블에서 모든 데이터를 출력하는 명령을 작성하시오.
select * from emp;
-- 4. 사원테이블에서 사원번호, 사원이름, 급여를 출력하는 명령을 작성하시오.
select EMPNO, ENAME, SAL from emp;
-- 5. 사원테이블에서 직무열만 뽑는데 중복된 데이터가 없게 출력하는 명령을 작성하시오.
select distinct JOB from emp;
-- 6. 사원테이블에서 사원이름과 급여를 출력하는데 각각의 컬럼명을
-- "이 름","월 급"으로 바꿔서 출력하는 명령을 작성하시오. 단, ALIAS에 공백 추가
select ENAME "이 름", SAL "월 급" from emp;
-- 7. 사원테이블에서 사원이름, 급여를 뽑고, 급여과 커미션을  더한 값을
-- 출력하는데 컬럼명을 '실급여'이라고 해서 출력하는 명령을 작성하시오.
-- 단, 커미션이 정해지지 않은 사람제외
select ENAME, SAL, SAL + COMM "실급여" from emp where COMM is not null;
-- 8. 사원테이블에서 'FORD'이라는 사원의 사원번호, 이름, 급여를 출력하는 명령을 작성하시오.
select EMPNO, ENAME, SAL from emp where ENAME = 'ford';
-- 9. 사원테이블에서 직무가 'SALESMAN'인 사원의 사원번호, 이름, 직무를
-- 출력하는 명령을 작성하시오.
select EMPNO, ENAME, JOB from emp where JOB = 'salesman';
-- 10. 사원테이블에서 사원번호가 7499, 7521, 7654인 사원의 사원번호, 이름
-- 급여를 출력하는 명령을 작성하시오.(두 개의 SQL 명령 작성(비교+논리 연산자, in 연산자)
select EMPNO, ENAME, SAL from emp where EMPNO = 7499 or EMPNO = 7521 or EMPNO = 7654;
-- 11. 사원테이블에서 급여이 1500에서 3000사이인 사원의 사원번호, 이름,
-- 급여를 출력하는 명령을 작성하시오.(두 개의 SQL 명령 작성(비교+논리 연산자, between~and 연산자)
select EMPNO, ENAME, SAL from emp where 1500 <= SAL and SAL <= 3000;
select EMPNO, ENAME, SAL from emp where SAL between 1500 and 3000;
-- 12. 사원 테이블에서 매니저가 없는 직원의 이름을 출력하는 명령을 작성하시오.
select ENAME from emp where MGR is null;
-- 13. 사원테이블에서 급여가 많은 순으로 모든 정보를 출력하는 명령을 작성하시오.
select * from emp order by SAL desc;
-- 14. 사원테이블에서 직원의 이름과 입사일을 출력하는데 최근에 입사한 순으로 출력하는 명령을 작성하시오.
select ENAME, HIREDATE from emp order by HIREDATE desc;
-- 15. 사원 테이블에서 30번 부서에 근무하는 직원들의 이름과 입사년월일을 출력하는데
-- 입사한지 오래된 순으로 출력하는 명령을 작성하시오.
select ENAME, HIREDATE from emp where DEPTNO = 30 order by HIREDATE;
-- 16. 이름에 'A' 가 들어간 직원들의 이름과 입사년월일을  출력하는 명령을 작성하시오.
select ENAME, HIREDATE from emp where ENAME like '%A%';
-- 17. 이름이 'S' 로 끝나는 직원들의 이름과 직무를  출력하는 명령을 작성하시오.
select ENAME, JOB from emp where ENAME like '%S';
-- 18. 직원들의 직무와 부서번호만 출력하는데 중복행은 한 행만 출력하는 명령을 작성하시오. 
select distinct JOB, DEPTNO from emp;
-- 19. 급여를 제일 많이 받는 직원 정보를 출력하는 명령을 작성하시오.
select * from emp order by SAL desc LIMIT 1;
-- 20. 급여를 제일 적게 받는 직원의 이름을 출력하는 명령을 작성하시오.
select ename from emp order by SAL LIMIT 1;
