use edudb;
-- QUESTION

-- 1. 사원 테이블에서 사원이름을 소문자로 출력하고 컬럼명을 사원이름으로 설정하시오.
--              사원이름
--           ----------------
--                smith
--                  :
select lower(ENAME) "사원이름" from emp;
-- 2. 사원테이블에서 사원이름과 사원 이름의 두번째 글자부터 다섯번째까지, 앞에서 2개, 뒤에서 3개를
-- 출력하시오.
--                 사원이름    2-5문자   앞에서 2개     뒤에서 3개
--                  ---------------------------------------
--                  SMITH     MITH         SM               ITH

select ENAME "사원이름"
	, MID(ENAME, 2, 4) "2-5문자"
	, left(ENAME, 2) "앞에서 2개"
    , right(ENAME, 3) "뒤에서 3개" 
from emp;

-- 3. 사원테이블의 사원 이름의 문자 개수를 출력하시오. 컬럼명은 '사원명 문자갯수'
--                 사원명 문자갯수
--                  ----------------
--                       5
--                       :		
select char_length(ENAME) "사원명 문자 갯수" from emp;
-- 4. 사원테이블에서 사원 이름의 앞 글자 하나와 마지막 글자 하나만 출력하되 
-- 모두 소문자로 각각 출력하시오.
--                    사원명    결과
--                     -----------------
--                     SMITH   sh   
--                     ALLEN   an   
--                               :
select ename "사원명", lower(concat(left(ename, 1), right(ename, 1))) "결과" from emp;
-- 5. 3456.78을 반올림하여 소수점 아래 첫번째 자리 까지만 나타내시오.
select round(3456.78, 1);

-- 6. 월급에 50를 곱하고 백단위는 절삭하여 출력하는데 월급뒤에 '원'을 붙이고 
--    천단위마다 ','를 붙여서 출력한다.
-- 	계산 결과
--     ---------------
--      40,000원
--	80,000원
-- 	62,500원
--  	148,000원
select concat(format(truncate(sal * 50, -3), 0),"원") "계산 결과" from emp;

-- 7. 직원 이름과 커미션 설정 여부를 출력하는데 설정되었으면 커미션 값을
--    설정되지 않았으면 '미정'을 출력하시오.
-- 	 사원명	결과	
-- ---------------------------
--	SMITH	미정	
--	ALLEN	300
select ENAME "사원명", IFNULL(COMM, "미정") "결과" from emp;

-- 8. 직원 이름과 커미션 설정 여부를 출력하는데 설정되었으면 '설정됨'을 
--    설정되지 않았으면 '설정안됨'을 출력하시오.
--     사원명	결과	
-- ---------------------------
--	  SMITH	설정안됨	
--	  ALLEN	설정됨	
select ENAME "사원명", IF(COMM, "설정됨", "설정안됨") "결과" from emp;
    
-- 9. 직원 이름과 부서번호 그리고 부서번호에 따른 부서명을 출력하시오.
--    부서가 없는 직원은 '없당' 을 출력하시오.
--    (부서명 : 10 이면 'A 부서', 20 이면 'B 부서', 30 이면 'C 부서')
--    사원명	결과	
-- ---------------------------
--	 SMITH	B부서	
--	 ALLEN	C부서	
select ENAME "사원명", CASE DEPTNO
	WHEN 10 THEN "A부서"
	WHEN 20 THEN "B부서"
	WHEN 30 THEN "C부서"
	ELSE "없당" 
    END 결과
from emp;

-- 10. 사원테이블에서 이름의 첫글자가 A이고 마지막 글자가 N이 아닌 사원의
-- 이름을 출력하시오.
select ENAME "이름" from emp where left(ENAME, 1) = 'A' && right(ENAME, 1) != 'N';

-- 11. 직원의 이름,  급여, 연봉을 조회하는 질의를 작성하시오.
-- (단, 직원의 연봉은 200의 월 보너스를 포함하여 계산한다.)
--     이름              급여               연봉
-- -------------------------------------------------
-- 	SMITH             800                 12000
-- 	ALLEN            1600                21600
-- 	WARD             1250               17400
select ENAME "이름", SAL "급여", (SAL + 200) * 12 "연봉" from emp;

-- 12.  다음과 같이 급여가 0~1000이면 'A', 1001~2000이면 'B', 2001~3000이면 'C', 
--           3001~4000이면 'D', 4001이상이면 'E'를 '코드'라는 열에 출력한다.

--       이름        월급   코드 
--       -----------------------
--        SMITH    800      A    
-- 	ALLEN   1600      B    
-- 	WARD    1250     B  
--		:  
select ENAME "이름", SAL "월급", CASE
	WHEN SAL > 4000 THEN "E"
	WHEN SAL > 3000 THEN "D"
	WHEN SAL > 2000 THEN "C"
	WHEN SAL > 1000 THEN "B"
	ELSE "A" 
    END 코드
from emp;

-- 13. 이름의 두번째 문자가 “A”인 모든 직원의 이름을 조회하는 질의를 작성하시오.
--          (두 개의 SELECT 명령을 작성하는데 하나는 like 연산자를 다른 하나는 함수로 해결하시오)

--      ENAME
--     ----------
-- 	WARD 
-- 	MARTIN
-- 	JAMES

SELECT ENAME from emp where ENAME like '_A%';
SELECT ENAME from emp where substring(ENAME, 2, 1) = 'A';

-- 14. 직원의 이름, 급여, 커미션, 연봉을 조회하는 질의를 작성하시오.
-- (단, 직원의 연봉은 (급여+커미션)*12 로 계산하는데 커미션이 정해지지 않은 직원은 0으로 계산한다.)
--     이름       급여     커미션       연봉
-- -------------------------------------------------
--	 SMITH      800      NULL      9600 
--	 ALLEN     1600     300        22800 
--	 WARD      1250     200        17400
select ENAME "이름", SAL "급여", COMM "커미션", (SAL + IFNULL(COMM, 0)) * 12 "연봉" from emp;

-- 15. 오늘날짜와 오늘날짜에서 10일을 더한 날짜를 출력하는 SQL 명령을 작성하시오.
select CURRENT_DATE(), DATE_ADD(CURRENT_DATE(), INTERVAL 10 DAY);

-- 16. 현재 시간을 "....년 ..월 ..일 ..시 ..분" 으로 출력하는 SQL 명령을 작성하시오. 컬럼명은 "현재시간"으로 설정한다.
select date_format(NOW(), "%T년 %m월 %d일 %H시 %i분") "현재시간";

-- 17.   모든 직원의 이름과 현재까지의 입사기간을 월단위로 조회하는 SQL  명령을 작성하시오.
--   (이때, 입사기간에 해당하는 열별칭은 “MONTHS WORKED”로 하고,   
--  입사기간이 가장 큰 직원순(입사한지 오래된 순)으로 정렬한다.)
--  (결과는 테스트하는 날짜에 따라서 다름)
-- 출력 예)
-- ENAME         MONTHS WORKED
-- ------------------------------
-- SMITH             543 
-- ALLEN             541 
select ENAME, TIMESTAMPDIFF(MONTH, HIREDATE, NOW()) "MONTHS WORKED" 
from emp 
order by HIREDATE;

-- 18. 사원테이블에서 사원이름과 사원들의 오늘 날짜까지의 근무일수를 구하는 SQL 명령을 작성하시오.
--  (결과는 테스트하는 날짜에 따라서 다름...ㅎ)
-- 사원이름   근무일수
-- -----------------------
-- SMITH     16540일  
-- ALLEN     16475일  
select ENAME "사원이름", concat(TIMESTAMPDIFF(DAY, HIREDATE, NOW()), "일") "근무일수" from emp;

-- 19. 1981년도에 입사한 직원들의 이름, 직무 그리고 입사일을 입사한 순으로 출력하는 SQL  명령을 작성하시오.
select ENAME "이름", JOB "직무", HIREDATE "입사일" 
from emp 
where year(HIREDATE) = '1981' 
order by HIREDATE;

-- 20. 내 생일을 기준으로 요일을 출력하는 SQL 명령을 작성하시오.(요일을 숫자로)
select dayofweek('2003-03-25') "태어난 요일";

-- 21. 내 생일을 기준으로 요일을 출력하는 SQL 명령을 작성하시오.(요일을 요일명으로)
select case dayofweek('2003-03-25')
when '1' then '월요일'
when '2' then '화요일'
when '3' then '수요일'
when '4' then '목요일'
when '5' then '금요일'
when '6' then '토요일'
when '7' then '일요일'
end as "태어난 요일";

-- 22. 현재를 기준으로 내가 태어난지 몇 개월 되었는지 알 수 있는 SQL 명령을 작성하시오.
select TIMESTAMPDIFF(MONTH, '2003-03-25', NOW()) "개월";