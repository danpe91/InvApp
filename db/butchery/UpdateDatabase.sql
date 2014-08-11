-- --------------------------------------------------------------------------
-- This script is intended to add stock column in products
-- and update the procedures to support stock
-- --------------------------------------------------------------------------

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

USE `butchery` ;

-- -----------------------------------------------------
-- Table `butchery`.`products`
-- -----------------------------------------------------
ALTER  TABLE `butchery`.`products`
  ADD `stock` INTEGER DEFAULT 0;


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
	UPDATE products
        SET stock = stock - p_quantity
        WHERE code = p_code;

    INSERT INTO sales(code, salenumber, quantity, total, date)
            VALUES(p_code, p_salenumber, p_quantity, p_total, p_date);
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
                        IN p_saletype TINYINT,
						IN p_stock INTEGER)
BEGIN
    UPDATE products
        SET product = p_product,
            unitprice = p_unitprice,
            saletype = p_saletype,
			stock = p_stock
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
                        IN p_saletype TINYINT,
						IN p_stock INTEGER)
BEGIN
    INSERT INTO products(code, product, unitprice, saletype, stock)
                VALUES(p_code, p_product, p_unitprice, p_saletype, p_stock);
END
$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
