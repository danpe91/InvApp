SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `invapp` DEFAULT CHARACTER SET latin1 ;
USE `invapp` ;

-- -----------------------------------------------------
-- procedure ReadInventory
-- -----------------------------------------------------

USE `butchery`;
DROP procedure IF EXISTS `butchery`.`ReadInventory`;

DELIMITER $$
USE `butchery`$$
CREATE PROCEDURE `butchery`.`ReadInventory`()
BEGIN
    SELECT * FROM products;
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure Readsales
-- -----------------------------------------------------

USE `butchery`;
DROP procedure IF EXISTS `butchery`.`Readsales`;

DELIMITER $$
USE `butchery`$$
CREATE PROCEDURE `butchery`.`Readsales`()
BEGIN
    SELECT * FROM sales;
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure Insertsale
-- -----------------------------------------------------

USE `butchery`;
DROP procedure IF EXISTS `butchery`.`Insertsale`;

DELIMITER $$
USE `butchery`$$


CREATE PROCEDURE `butchery`.`Insertsale`(IN p_code VARCHAR(10),
                                          IN p_salenumber INT,
                                          IN p_quantity DOUBLE,
                                          IN p_total DOUBLE,
                                          IN p_date DATETIME)
BEGIN
    INSERT INTO sales(code, salenumber, quantity, total, date)
            VALUES(p_code, p_salenumber, p_quantity, p_total, p_date);
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure GetNewsaleNumber
-- -----------------------------------------------------

USE `butchery`;
DROP procedure IF EXISTS `butchery`.`GetNewsaleNumber`;

DELIMITER $$
USE `butchery`$$




CREATE PROCEDURE `butchery`.`GetNewsaleNumber` ()
BEGIN
    SELECT MAX(salenumber) as salenumber
    FROM sales;
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure GetDataByName
-- -----------------------------------------------------

USE `butchery`;
DROP procedure IF EXISTS `butchery`.`GetDataByName`;

DELIMITER $$
USE `butchery`$$




CREATE PROCEDURE `butchery`.`GetDataByName`(IN p_accesoryname VARCHAR(50))
BEGIN
    SELECT * FROM products
    WHERE accesoryname = p_accesoryname ;
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure GetDataByNameAndSize
-- -----------------------------------------------------

USE `butchery`;
DROP procedure IF EXISTS `butchery`.`GetDataByNameAndSize`;

DELIMITER $$
USE `butchery`$$




CREATE PROCEDURE `butchery`.`GetDataByNameAndSize`(IN p_accesoryname VARCHAR(50),
                                                    IN p_size VARCHAR(20))
BEGIN
    SELECT * FROM products
    WHERE accesoryname = p_accesoryname
    AND size = p_size;
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure UpdateProduct
-- -----------------------------------------------------

USE `butchery`;
DROP procedure IF EXISTS `butchery`.`UpdateProduct`;

DELIMITER $$
USE `butchery`$$




CREATE PROCEDURE `butchery`.`UpdateProduct`(IN p_code VARCHAR(10),
                        IN p_product VARCHAR(100),
                        IN p_unitprice DOUBLE,
                        IN p_saletype TINYINT)
BEGIN
    UPDATE products
        SET product = p_product,
            unitprice = p_unitprice,
            saletype = p_saletype
        WHERE code = p_code;
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure InsertProduct
-- -----------------------------------------------------

USE `butchery`;
DROP procedure IF EXISTS `butchery`.`InsertProduct`;

DELIMITER $$
USE `butchery`$$




CREATE PROCEDURE `butchery`.`InsertProduct`(IN p_code VARCHAR(10),
                        IN p_product VARCHAR(100),
                        IN p_unitprice DOUBLE,
                        IN p_saletype TINYINT)
BEGIN
    INSERT INTO products(code, product, unitprice, saletype)
                VALUES(p_code, p_product, p_unitprice, p_saletype);
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure ReadCodes
-- -----------------------------------------------------

USE `butchery`;
DROP procedure IF EXISTS `butchery`.`ReadCodes`;

DELIMITER $$
USE `butchery`$$


CREATE PROCEDURE `butchery`.`ReadCodes`()
BEGIN
    SELECT code FROM products;
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure ReadProductByCode
-- -----------------------------------------------------

USE `butchery`;
DROP procedure IF EXISTS `butchery`.`ReadProductByCode`;

DELIMITER $$
USE `butchery`$$


CREATE PROCEDURE `butchery`.`ReadProductByCode`(IN p_code VARCHAR(10))
BEGIN
    SELECT * FROM products
    WHERE code = p_code;
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure GetDailyReport
-- -----------------------------------------------------

USE `butchery`;
DROP procedure IF EXISTS `butchery`.`GetDailyReport`;

DELIMITER $$
USE `butchery`$$
CREATE PROCEDURE `butchery`.`GetDailyReport` (IN p_day INT,
                                                IN p_month INT,
                                                IN p_year INT)
BEGIN
    SELECT * FROM sales
    INNER JOIN products USING(code)
    WHERE DAY(date) = p_day
    AND MONTH(date) = p_month
    AND YEAR(date) = p_year
    ORDER BY salenumber;
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure GetMonthlyReport
-- -----------------------------------------------------

USE `butchery`;
DROP procedure IF EXISTS `butchery`.`GetMonthlyReport`;

DELIMITER $$
USE `butchery`$$




CREATE PROCEDURE `butchery`.`GetMonthlyReport` (IN p_month INT,
                                                IN p_year INT)
BEGIN
    SELECT * FROM sales
    INNER JOIN products USING(code)
    WHERE MONTH(date) = p_month
    AND YEAR(date) = p_year
    ORDER BY salenumber;
END
$$

DELIMITER ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
