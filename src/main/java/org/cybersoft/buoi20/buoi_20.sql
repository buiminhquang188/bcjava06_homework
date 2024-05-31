# Câu 1
SELECT p.ProductName, s.SupplierName, p.Price
FROM Products p
         JOIN Suppliers s ON s.SupplierID = p.SupplierID
WHERE p.Price > 15.00;

# Câu 2
SELECT c.CustomerName, c.Country
FROM Customers c
         JOIN Orders o ON o.CustomerID = c.CustomerID
         JOIN OrderDetails od ON od.OrderID = o.OrderID
WHERE c.Country = 'Mexico';

# Câu 3
SELECT c.CustomerID, c.Country, COUNT(1) AS total_orders_from_country
FROM Customers c
         JOIN Orders o ON o.CustomerID = c.CustomerID
         JOIN OrderDetails od ON od.OrderID = o.OrderID
GROUP BY c.CustomerID;

# Câu 4
SELECT s.SupplierID, s.SupplierName, COUNT(1) AS total_products
FROM Suppliers s
         JOIN Products p ON p.SupplierID = s.SupplierID
GROUP BY s.SupplierID;

# Câu 5
SELECT p.ProductID, p.ProductName, p.Price
FROM Products p
WHERE price > (SELECT p11.Price
               FROM Products p11
               WHERE p11.ProductName = 'Ikura');

# Câu 6
SELECT SUM(od.Quantity) AS total_quantity_sold
FROM Orders o
         JOIN OrderDetails od ON od.OrderID = o.OrderID
WHERE MONTH(o.OrderDate) = 5
  AND YEAR(o.OrderDate) = 2024;

# Câu 7
SELECT *
FROM Customers c
         LEFT JOIN Orders o ON o.CustomerID = c.CustomerID
WHERE o.OrderID IS NULL;

# Câu 8
SELECT od.OrderID, SUM(od.Quantity * p.Price) AS total_price
FROM OrderDetails od
         JOIN Products p ON p.ProductID = od.ProductID
         JOIN Orders o ON o.OrderID = od.OrderID
GROUP BY od.OrderID
HAVING total_price > 200.00;

# Câu 9
SELECT od11.OrderID, p11.ProductID, p11.ProductName, AVG(od11.Quantity) AS average_product_per_order
FROM OrderDetails od11
         JOIN Products p11 ON p11.ProductID = od11.ProductID
GROUP BY p11.ProductID, od11.OrderID;

# Câu 10
SELECT c.*, SUM(p.Price * od.Quantity) AS total_price
FROM Customers c
         JOIN Orders o ON o.CustomerID = c.CustomerID
         JOIN OrderDetails od ON od.OrderID = o.OrderID
         JOIN Products p ON p.ProductID = od.ProductID
GROUP BY c.CustomerID
HAVING total_price = (SELECT MAX(c11.total_price) AS max_price
                      FROM (SELECT c12.*, SUM(p12.Price * od12.Quantity) AS total_price
                            FROM Customers c12
                                     JOIN Orders o12 ON o12.CustomerID = c12.CustomerID
                                     JOIN OrderDetails od12 ON od12.OrderID = o12.OrderID
                                     JOIN Products p12 ON p12.ProductID = od12.ProductID
                            GROUP BY c12.CustomerID
                            ORDER BY c12.CustomerID) AS c11);

# Câu 11
SELECT o.OrderID, SUM(od.Quantity * p.Price) AS total_price
FROM Orders o
         JOIN OrderDetails od ON o.OrderID = od.OrderID
         JOIN Products p ON p.ProductID = od.ProductID
GROUP BY o.OrderID
ORDER BY total_price DESC
LIMIT 10;

# Câu 12
SELECT c.CustomerID, c.CustomerName, p.ProductName, average_price
FROM Customers c
         JOIN Orders o ON o.CustomerID = c.CustomerID
         JOIN OrderDetails od ON od.OrderID = o.OrderID
         JOIN Products p ON p.ProductID = od.ProductID
         JOIN (SELECT p11.ProductID, AVG(od11.Quantity * p11.Price) AS average_price
               FROM OrderDetails od11
                        JOIN Products p11 ON p11.ProductID = od11.ProductID
               GROUP BY p11.ProductID) AS od1 ON p.ProductID = od1.ProductID
ORDER BY c.CustomerID;

# Câu 13
SELECT o.OrderID, p.ProductID, p.ProductName, average_price
FROM Orders o
         JOIN OrderDetails od ON od.OrderID = o.OrderID
         JOIN Products p ON p.ProductID = od.ProductID
         JOIN (SELECT p11.ProductID, AVG(od11.Quantity * p11.Price) AS average_price
               FROM OrderDetails od11
                        JOIN Products p11 ON p11.ProductID = od11.ProductID
               GROUP BY p11.ProductID) AS od1 ON p.ProductID = od1.ProductID
WHERE average_price = (SELECT MAX(od12.average_price)
                       FROM (SELECT AVG(od111.Quantity * p111.Price) AS average_price
                             FROM OrderDetails od111
                                      JOIN Products p111 ON p111.ProductID = od111.ProductID
                             GROUP BY p111.ProductID) AS od12);


SELECT MAX(od1.average_price)
FROM (SELECT AVG(od11.Quantity * p11.Price) AS average_price
      FROM OrderDetails od11
               JOIN Products p11 ON p11.ProductID = od11.ProductID
      GROUP BY p11.ProductID) AS od1;

# Câu 14: Liệt kê các sản phẩm chưa bao giờ được đặt hàng bởi khách hàng đến từ "USA"
SELECT p.ProductID, p.ProductName
FROM Customers c
         JOIN Orders o ON o.CustomerID = c.CustomerID
         JOIN OrderDetails od ON od.OrderID = o.OrderID
         JOIN Products p ON p.ProductID != od.ProductID
WHERE c.Country = 'UK';

# Câu 15
SELECT s.SupplierID, s.SupplierName, SUM(od.Quantity) AS total_quantity
FROM Suppliers s
         JOIN Products p ON p.SupplierID = s.SupplierID
         JOIN OrderDetails od ON od.ProductID = p.ProductID
GROUP BY s.SupplierID
HAVING total_quantity = (SELECT MAX(s11.total_quantity)
                         FROM Suppliers s1
                                  JOIN (SELECT s111.SupplierID, s111.SupplierName, SUM(od111.Quantity) AS total_quantity
                                        FROM Suppliers s111
                                                 JOIN Products p111 ON p111.SupplierID = s111.SupplierID
                                                 JOIN OrderDetails od111 ON od111.ProductID = p111.ProductID
                                        GROUP BY s111.SupplierID) AS s11 ON s1.SupplierID = s.SupplierID);


