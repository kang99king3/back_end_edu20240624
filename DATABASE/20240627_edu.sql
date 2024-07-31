-- 2024-07-31
-- testsqldb
INSERT INTO table1
VALUES (NULL,'test3',SYSDATE());

INSERT INTO table2
VALUES (NULL,'test1',4);

-- sqldb 데이터베이스
SELECT * 
FROM buytbl;

SELECT *
FROM usertbl;

SELECT * 
FROM usertbl
WHERE NAME='김경호';

SELECT userID, NAME , birthyear, height
FROM usertbl
WHERE birthyear >= 1970 AND height >= 182 ;

SELECT userID, NAME , birthyear, height
FROM usertbl
WHERE birthyear >= 1970 OR height >= 182 ;

-- <, >, <=, >=, <>, !=

SELECT *
FROM usertbl
where height BETWEEN 180 AND 183;

SELECT *
FROM usertbl
WHERE addr IN('경남','전남','경북');

SELECT *
FROM usertbl
WHERE NAME LIKE '_종신';

-- 실습1
-- Q1) 사원 테이블(EMP)의 모든 데이터를 출력하자.
	SELECT * 
	FROM emp;
-- Q2) 사원 테이블에서 사원의 이름(ENAME), 사원의 번호(EMPNO), 월급(SAL)을 출력하자.
   SELECT ename, empno, sal 
   FROM emp ;
   
-- Q3) 사원 테이블에서 사원의 이름과 연봉을 출력하자.
   SELECT ename, sal*12 AS 'sal year'
   FROM emp;
-- Q4) 사원의 이름, 입사일(HIREDATE), 부서번호(DEPTNO)를 출력하자.
   SELECT ename, hiredate, deptno
   FROM emp;
-- Q5) 사원의 이름과, 사원을 관리하고있는 관리자(MGR)를 출력하자.
   SELECT ename, mgr
   FROM emp;
-- Q6) 부서 테이블(DEPT)의 모든 데이터를 출력하자.
    SELECT *
   FROM dept;
-- Q7) 부서 테이블의 구조를 보자
   DESC dept;
   SHOW TABLES;
   
-- Q8) 사원 테이블에서 사원의 이름, 월급, 커미션(COMM)을 출력하자.
	SELECT ename, sal, comm
	FROM emp;
-- Q9) 사원 테이블의 모든 데이터를 "OO님이 0000-00-00에 입사를 하고 OO의 월급을 받습니다." 형식인 하나의 컬럼으로 출력하자.
	SELECT CONCAT(ename,'님이',hiredate,'에 입사를 하고 ',sal,'의 월급을 받습니다.') 
	       AS '급여지급현황'
	FROM emp;

