SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `new_database` ;
CREATE SCHEMA IF NOT EXISTS `new_database` DEFAULT CHARACTER SET latin1 ;
USE `new_database` ;

-- -----------------------------------------------------
-- Table `new_database`.`products`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `new_database`.`products` ;

CREATE  TABLE IF NOT EXISTS `new_database`.`products` (
  `code` VARCHAR(10) NOT NULL ,
  `product` VARCHAR(100) NOT NULL ,
  `unitprice` DOUBLE NOT NULL ,
  `stock` INTEGER NOT NULL ,
  `sold` INTEGER NOT NULL ,
  PRIMARY KEY (`code`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `new_database`.`sales`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `new_database`.`sales` ;

CREATE  TABLE IF NOT EXISTS `new_database`.`sales` (
  `idsale` INT NOT NULL AUTO_INCREMENT ,
  `code` VARCHAR(10) NOT NULL ,
  `salenumber` INT NOT NULL ,
  `quantity` INTEGER NOT NULL ,
  `total` DOUBLE NOT NULL ,
  `date` DATETIME NOT NULL ,
  PRIMARY KEY (`idsale`) ,
  INDEX `FK_sales_Products` (`code` ASC) ,
  CONSTRAINT `FK_sales_Products`
    FOREIGN KEY (`code` )
    REFERENCES `new_database`.`products` (`code` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- procedure ReadInventory
-- -----------------------------------------------------

USE `new_database`;
DROP procedure IF EXISTS `new_database`.`ReadInventory`;

DELIMITER $$
USE `new_database`$$
CREATE PROCEDURE `new_database`.`ReadInventory`()
BEGIN
    SELECT * FROM products;
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure Readsales
-- -----------------------------------------------------

USE `new_database`;
DROP procedure IF EXISTS `new_database`.`Readsales`;

DELIMITER $$
USE `new_database`$$
CREATE PROCEDURE `new_database`.`Readsales`()
BEGIN
    SELECT * FROM sales;
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure Insertsale
-- -----------------------------------------------------

USE `new_database`;
DROP procedure IF EXISTS `new_database`.`Insertsale`;

DELIMITER $$
USE `new_database`$$


CREATE PROCEDURE `new_database`.`Insertsale`(IN p_code VARCHAR(10),
                                          IN p_salenumber INT,
                                          IN p_quantity INTEGER,
                                          IN p_total DOUBLE,
                                          IN p_date DATETIME)
BEGIN

	UPDATE products
        SET stock = stock - p_quantity,
            sold = sold + p_quantity
        WHERE code = p_code;

    INSERT INTO sales(code, salenumber, quantity, total, date)
            VALUES(p_code, p_salenumber, p_quantity, p_total, p_date);
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure GetNewsaleNumber
-- -----------------------------------------------------

USE `new_database`;
DROP procedure IF EXISTS `new_database`.`GetNewsaleNumber`;

DELIMITER $$
USE `new_database`$$




CREATE PROCEDURE `new_database`.`GetNewsaleNumber` ()
BEGIN
    SELECT MAX(salenumber) as salenumber
    FROM sales;
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure GetDataByName
-- -----------------------------------------------------

USE `new_database`;
DROP procedure IF EXISTS `new_database`.`GetDataByName`;

DELIMITER $$
USE `new_database`$$




CREATE PROCEDURE `new_database`.`GetDataByName`(IN p_accesoryname VARCHAR(50))
BEGIN
    SELECT * FROM products
    WHERE accesoryname = p_accesoryname ;
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure GetDataByNameAndSize
-- -----------------------------------------------------

USE `new_database`;
DROP procedure IF EXISTS `new_database`.`GetDataByNameAndSize`;

DELIMITER $$
USE `new_database`$$




CREATE PROCEDURE `new_database`.`GetDataByNameAndSize`(IN p_accesoryname VARCHAR(50),
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

USE `new_database`;
DROP procedure IF EXISTS `new_database`.`UpdateProduct`;

DELIMITER $$
USE `new_database`$$




CREATE PROCEDURE `new_database`.`UpdateProduct`(IN p_code VARCHAR(10),
                        IN p_product VARCHAR(100),
                        IN p_unitprice DOUBLE,
						IN p_stock INTEGER)
BEGIN
    UPDATE products
        SET product = p_product,
            unitprice = p_unitprice,
			stock = p_stock
        WHERE code = p_code;
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure InsertProduct
-- -----------------------------------------------------

USE `new_database`;
DROP procedure IF EXISTS `new_database`.`InsertProduct`;

DELIMITER $$
USE `new_database`$$




CREATE PROCEDURE `new_database`.`InsertProduct`(IN p_code VARCHAR(10),
                        IN p_product VARCHAR(100),
                        IN p_unitprice DOUBLE,
						IN p_stock INTEGER)
BEGIN
    INSERT INTO products(code, product, unitprice, stock, sold)
                VALUES(p_code, p_product, p_unitprice, p_stock, 0);
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure ReadCodes
-- -----------------------------------------------------

USE `new_database`;
DROP procedure IF EXISTS `new_database`.`ReadCodes`;

DELIMITER $$
USE `new_database`$$


CREATE PROCEDURE `new_database`.`ReadCodes`()
BEGIN
    SELECT code FROM products;
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure ReadProductByCode
-- -----------------------------------------------------

USE `new_database`;
DROP procedure IF EXISTS `new_database`.`ReadProductByCode`;

DELIMITER $$
USE `new_database`$$


CREATE PROCEDURE `new_database`.`ReadProductByCode`(IN p_code VARCHAR(10))
BEGIN
    SELECT * FROM products
    WHERE code = p_code;
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure GetDailyReport
-- -----------------------------------------------------

USE `new_database`;
DROP procedure IF EXISTS `new_database`.`GetDailyReport`;

DELIMITER $$
USE `new_database`$$
CREATE PROCEDURE `new_database`.`GetDailyReport` (IN p_day INT,
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

USE `new_database`;
DROP procedure IF EXISTS `new_database`.`GetMonthlyReport`;

DELIMITER $$
USE `new_database`$$




CREATE PROCEDURE `new_database`.`GetMonthlyReport` (IN p_month INT,
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
