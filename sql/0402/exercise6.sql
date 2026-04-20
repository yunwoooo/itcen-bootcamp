use edudb;
-- 모든 실습문제는 EMP와 DEPT 테이블의 데이터 보존과 문제마다 처리 결과의 일관성을 위해 
-- 각각 명령을 수행하고 SELECT 명령으로 변경된 것을 확인한 다음 
-- 반드시 ROLLBACK 명령을 수행하여 취소한다.

-- [ 테스트 순서 : 문제(1번~8번)마다 꼭!! ]
-- 변경전 확인(SELECT)
-- 문제에서 요구되는 DML 문 수행
-- 변경후 확인(SELECT)
-- rollback

-- 1. EMP 테이블에서 직원번호가 7499번인 직원의 급여를 5000달러로 변경한다.
start transaction;
SET autocommit = 0;

select * from emp;
Update emp
	SET SAL = 5000
    WHERE EMPNO = 7499;
select * from emp;
rollback;

-- 2. EMP테이블에서 부서번호가 20번인 직원들의 급여를 현재 급여에서 10% 인상한 금액으로 변경한다.
select * from emp;
Update emp
	SET SAL = SAL * 1.1
    where DEPTNO = 20;
select * from emp;
rollback;

-- 3. EMP 테이블에 아래와 같은 데이터를 삽입한다.(고민좀 해보자 ㅎ)
-- 직원번호: 9900, 직원이름: JACKSON, 직무: SALESMAN, 부서번호: 10, 급여 : 900, 커미션 : 100, 입사일 : 1983-02-05, 팀장 : KING
select * from emp;
insert emp (EMPNO, ENAME, JOB, DEPTNO, SAL, COMM, HIREDATE, MGR)
values (9900, 'JACKSON', 'SALESMAN', 10, 900, 100, '1983-02-05', 
	(select EMPNO
    from (select EMPNO
		from emp
		where ENAME = 'KING') as temp));
select * from emp;
rollback;

-- 4. 직원번호가 7698번인 직원의 부서번호를 7369번 직원의 
-- 부서번호로 변경한다.
select * from emp;
update emp
	SET DEPTNO = 
    (select DEPTNO
    from (select DEPTNO
		from emp
        where EMPNO = 7369) as temp)
    where EMPNO = 7698;
select * from emp;
rollback;

-- 5. 20번 부서의 직원들을 모두 삭제한다.
select * from emp;
delete from emp
where DEPTNO = 20;
select * from emp;
rollback;

-- 6. 급여가 1000 이하인 직원들을 삭제한다.
select * from emp;
delete from emp
where SAL <= 1000;
select * from emp;
rollback;

-- 7. 직원번호가 7900 인 직원의 급여를 현재 급여에서 5% 증가시키고
--    부서번호를 40으로 변경한다.
select * from emp;
Update emp
	SET SAL = SAL * 1.05, DEPTNO = 40
    where EMPNO = 7900;
select * from emp;
rollback;

-- 8. 현재를 기준으로 입사한지 45년 이상인 직원들에 대하여 
--          급여를 2배로 변경하고 커미션도 3000으로 변경한다.
select * from emp;
Update emp
	SET SAL = SAL * 2, COMM = 3000
    where year(now()) - year(HIREDATE) >= 45;
select * from emp;
rollback;

-- 9 테이블 생성
-- 테이블명 : book
--    컬럼 :  도서명, 가격, 도서분류
--              id - 식별값, Auto Increment 적용 - int
--              title -  40자까지 저장할 수 있게 varchar 타입 사용 - varchar(40)
--              price - 숫자를 저장할 수 있는 숫자타입 - int
--              kind - 영문기준 3자까지 저장할 수 있게 char 타입 사용 - char(3)
--                (참고로 kind 에는 데이터 삽입시에 kind 에는 다음 값들을 저장하게 될 거임)
--                b01 - 프로그래밍 언어, b02 - 웹 프로그래밍, b03 - 빅데이터
-- 		  b04 - 데이터베이스, b05 - 인--프라

-- mysql> desc book;
--  +-------+-------------+------+-----+---------+-----------------+
-- | Field   | Type          | Null   | Key | Default  | Extra              |
-- +-------+-------------+------+-----+---------+-----------------+
-- | id       | int             | NO   | PRI  | NULL     | auto_increment |
-- | title    | varchar(40) | YES  |       | NULL     |                       |
-- | price   | int             | YES  |       | NULL     |                       |
-- | kind    | char(3)       | YES  |       | NULL     |                       |
-- +-------+-------------+------+-----+---------+-----------------+

create table book
( id INT auto_increment not null primary key
 , title VARCHAR(40)
 , price INT
 , kind CHAR(3)
 );
desc book;

-- 10. 테이블에 데이터 저장  

-- 데이터-1 : 도서명 - 자바의 정석, 가격 - 36000, 도서분류 - b01
-- 데이터-2 : 도서명 - 모던 자바스크립트 핵심 가이드, 가격 - 19800, 도서분류 - b02
-- 데이터-3 : 도서명 -  그림과 실습으로 배우는 도커, 가격 - 28000, 도서분류 - b05
-- 데이터-4 : 도서명 - MySQL로 배우는 데이터베이스 개론과 실습, 가격 - 27000, 도서분류 - b04 
-- 데이터-5 : 도서명 - 이것이 스프링부트다, 가격 - 36000, 도서분류 - b02
INSERT INTO book(title, price, kind) VALUES('자바의 정석', 36000, 'b01');  
INSERT INTO book(title, price, kind) VALUES('모던 자바스크립트 핵심 가이드', 19800, 'b02');  
INSERT INTO book(title, price, kind) VALUES('그림과 실습으로 배우는 도커', 28000, 'b05');  
INSERT INTO book(title, price, kind) VALUES('MySQL로 배우는 데이터베이스 개론과 실습', 27000, 'b04');  
INSERT INTO book(title, price, kind) VALUES('이것이 스프링부트다', 36000, 'b02');  

-- 11. 테이블 내용을 확인하는 SQL 명령 작성
select * from book;
