use mysql;
use faiz;
CREATE TABLE Suppliers (
    sid    INT PRIMARY KEY,
    sname  VARCHAR(50),
    city   VARCHAR(50)
);


CREATE TABLE Parts (
    pid    INT PRIMARY KEY,
    pname  VARCHAR(50),
    color  VARCHAR(20)
);
desc Parts;
CREATE TABLE Catalog (
    sid   INT,
    pid   INT,
    cost  INT,
    PRIMARY KEY (sid, pid),
    FOREIGN KEY (sid) REFERENCES Suppliers(sid),
    FOREIGN KEY (pid) REFERENCES Parts(pid)
);

INSERT INTO Suppliers VALUES
(10001, 'Acme Widget', 'Bangalore'),
(10002, 'Johns', 'Kolkata'),
(10003, 'Vimal', 'Mumbai'),
(10004, 'Reliance', 'Delhi');

INSERT INTO Parts VALUES
(20001, 'Book', 'Red'),
(20002, 'Pen', 'Red'),
(20003, 'Pencil', 'Green'),
(20004, 'Mobile', 'Green'),
(20005, 'Charger', 'Black');

INSERT INTO Catalog VALUES
(10001, 20001, 10),
(10001, 20002, 10),
(10001, 20003, 30),
(10001, 20004, 10),
(10001, 20005, 10),
(10002, 20001, 10),
(10002, 20002, 20),
(10003, 20003, 30),
(10004, 20003, 40);

SELECT DISTINCT p.pname
FROM Parts p
JOIN Catalog c ON p.pid = c.pid;

SELECT s.sname
FROM Suppliers s
WHERE NOT EXISTS (
    SELECT * FROM Parts p
    WHERE NOT EXISTS (
        SELECT * FROM Catalog c
        WHERE c.sid = s.sid AND c.pid = p.pid
    )
);
SELECT s.sname
FROM Suppliers s
WHERE NOT EXISTS (
    SELECT pid FROM Parts p
    WHERE p.color = 'Red'
    AND NOT EXISTS (
        SELECT * FROM Catalog c
        WHERE c.sid = s.sid AND c.pid = p.pid
    )
);

SELECT p.pname
FROM Parts p
JOIN Catalog c1 ON p.pid = c1.pid
JOIN Suppliers s ON s.sid = c1.sid
WHERE s.sname = 'Acme Widget'
AND NOT EXISTS (
    SELECT * FROM Catalog c2
    JOIN Suppliers s2 ON c2.sid = s2.sid
    WHERE c2.pid = p.pid 
    AND s2.sname <> 'Acme Widget'
);


SELECT p.pname, s.sname
FROM Parts p
JOIN Catalog c ON p.pid = c.pid
JOIN Suppliers s ON s.sid = c.sid
WHERE c.cost = (
    SELECT MAX(cost)
    FROM Catalog c2
    WHERE c2.pid = p.pid
);

SELECT DISTINCT c.sid
FROM Catalog c
JOIN (
    SELECT pid, AVG(cost) AS avg_cost
    FROM Catalog
    GROUP BY pid
) avgc ON c.pid = avgc.pid
WHERE c.cost > avgc.avg_cost;

