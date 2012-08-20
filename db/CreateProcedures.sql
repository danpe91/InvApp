SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `invapp` ;
CREATE SCHEMA IF NOT EXISTS `invapp` DEFAULT CHARACTER SET latin1 ;
USE `invapp` ;

-- -----------------------------------------------------
-- procedure ReadInventory
-- -----------------------------------------------------

USE `invapp`;
DROP procedure IF EXISTS `invapp`.`ReadInventory`;

DELIMITER $$
USE `invapp`$$
CREATE PROCEDURE `invapp`.`ReadInventory`()
BEGIN
    SELECT * FROM products;
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure ReadSells
-- -----------------------------------------------------

USE `invapp`;
DROP procedure IF EXISTS `invapp`.`ReadSells`;

DELIMITER $$
USE `invapp`$$
CREATE PROCEDURE `invapp`.`ReadSells`()
BEGIN
    SELECT * FROM sells;
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure InsertSell
-- -----------------------------------------------------

USE `invapp`;
DROP procedure IF EXISTS `invapp`.`InsertSell`;

DELIMITER $$
USE `invapp`$$


CREATE PROCEDURE `invapp`.`InsertSell`(IN p_idproduct INT,
                                          IN p_sellnumber INT,
                                          IN p_quantity INT,
                                          IN p_total DOUBLE,
                                          IN p_date DATETIME)
BEGIN
    UPDATE products
        SET stock = stock - p_quantity,
            sold = sold + p_quantity
        WHERE idproduct = p_idproduct;

    INSERT INTO sells(idproduct, sellnumber, quantity, total, date)
            VALUES(p_idproduct, p_sellnumber, p_quantity, p_total, p_date);
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure GetNewSellNumber
-- -----------------------------------------------------

USE `invapp`;
DROP procedure IF EXISTS `invapp`.`GetNewSellNumber`;

DELIMITER $$
USE `invapp`$$




CREATE PROCEDURE `invapp`.`GetNewSellNumber` ()
BEGIN
    SELECT MAX(sellnumber) as sellnumber
    FROM sells;
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure ReadProducts
-- -----------------------------------------------------

USE `invapp`;
DROP procedure IF EXISTS `invapp`.`ReadProducts`;

DELIMITER $$
USE `invapp`$$


CREATE PROCEDURE `invapp`.`ReadProducts`()
BEGIN
    SELECT * FROM products
    GROUP BY accesoryname;
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure GetDataByName
-- -----------------------------------------------------

USE `invapp`;
DROP procedure IF EXISTS `invapp`.`GetDataByName`;

DELIMITER $$
USE `invapp`$$




CREATE PROCEDURE `invapp`.`GetDataByName`(IN p_accesoryname VARCHAR(50))
BEGIN
    SELECT * FROM products
    WHERE accesoryname = p_accesoryname ;
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure GetDataByNameAndSize
-- -----------------------------------------------------

USE `invapp`;
DROP procedure IF EXISTS `invapp`.`GetDataByNameAndSize`;

DELIMITER $$
USE `invapp`$$




CREATE PROCEDURE `invapp`.`GetDataByNameAndSize`(IN p_accesoryname VARCHAR(50),
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

USE `invapp`;
DROP procedure IF EXISTS `invapp`.`UpdateProduct`;

DELIMITER $$
USE `invapp`$$




CREATE PROCEDURE `invapp`.`UpdateProduct`(IN p_idproduct INT,
                        IN p_accesoryname VARCHAR(50),
                        IN p_stock INT,
                        IN p_unitprice DOUBLE,
                        IN p_size VARCHAR(20),
                        IN p_code VARCHAR(50),
                        IN p_brand VARCHAR(50),
                        IN p_model VARCHAR(50),
                        IN p_color VARCHAR(50))
BEGIN
    UPDATE products
        SET accesoryname = p_accesoryname,
            stock = p_stock,
            unitprice = p_unitprice,
            size = p_size,
            code = p_code,
            brand = p_brand,
            model = p_model,
            color = p_color
        WHERE idproduct = p_idproduct;
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure InsertProduct
-- -----------------------------------------------------

USE `invapp`;
DROP procedure IF EXISTS `invapp`.`InsertProduct`;

DELIMITER $$
USE `invapp`$$




CREATE PROCEDURE `invapp`.`InsertProduct`(IN p_accesoryname VARCHAR(50),
                        IN p_stock INT,
                        IN p_unitprice DOUBLE,
                        IN p_size VARCHAR(20),
                        IN p_code VARCHAR(50),
                        IN p_brand VARCHAR(50),
                        IN p_model VARCHAR(50),
                        IN p_color VARCHAR(50))
BEGIN
    INSERT INTO products(accesoryname, stock, sold, unitprice, size, code, brand, model, color)
                VALUES(p_accesoryname, p_stock, 0, p_unitprice, p_size, p_code, p_brand, p_model, p_color);
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure ReadCodes
-- -----------------------------------------------------

USE `invapp`;
DROP procedure IF EXISTS `invapp`.`ReadCodes`;

DELIMITER $$
USE `invapp`$$


CREATE PROCEDURE `invapp`.`ReadCodes`()
BEGIN
    SELECT code FROM products;
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure ReadProductByCode
-- -----------------------------------------------------

USE `invapp`;
DROP procedure IF EXISTS `invapp`.`ReadProductByCode`;

DELIMITER $$
USE `invapp`$$


CREATE PROCEDURE `invapp`.`ReadProductByCode`(IN p_code VARCHAR(50))
BEGIN
    SELECT * FROM products
    WHERE code = p_code;
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure GetDailyReport
-- -----------------------------------------------------

USE `invapp`;
DROP procedure IF EXISTS `invapp`.`GetDailyReport`;

DELIMITER $$
USE `invapp`$$
CREATE PROCEDURE `invapp`.`GetDailyReport` (IN p_day INT,
                                                IN p_month INT,
                                                IN p_year INT)
BEGIN
    SELECT * FROM sells
    INNER JOIN products USING(idproduct)
    WHERE DAY(date) = p_day
    AND MONTH(date) = p_month
    AND YEAR(date) = p_year
    ORDER BY sellnumber;
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure GetMonthlyReport
-- -----------------------------------------------------

USE `invapp`;
DROP procedure IF EXISTS `invapp`.`GetMonthlyReport`;

DELIMITER $$
USE `invapp`$$




CREATE PROCEDURE `invapp`.`GetMonthlyReport` (IN p_month INT,
                                                IN p_year INT)
BEGIN
    SELECT * FROM sells
    INNER JOIN products USING(idproduct)
    WHERE MONTH(date) = p_month
    AND YEAR(date) = p_year
    ORDER BY sellnumber;
END
$$

DELIMITER ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
