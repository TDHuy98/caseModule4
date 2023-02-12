CREATE SCHEMA `shopmobile_product_productcategory_category` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE shopmobile_product_productcategory_category;

  CREATE TABLE `shopmobile_product_productcategory_category`.`product` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NOT NULL,
  `product_name` VARCHAR(75) NOT NULL,
  `product_type` SMALLINT(6) NOT NULL DEFAULT 0,
  `price` FLOAT NOT NULL DEFAULT 0,
  `quantity` SMALLINT(6) NOT NULL DEFAULT 0,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_product_user` (`user_id` ASC),
  CONSTRAINT `fk_product_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `shopmobile_product_productcategory_category`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE `shopmobile_product_productcategory_category`.`category` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `parent_id` BIGINT NULL DEFAULT NULL,
  `title` VARCHAR(75) NOT NULL,
  PRIMARY KEY (`id`));

ALTER TABLE `shopmobile_product_productcategory_category`.`category` 
ADD INDEX `idx_category_parent` (`parent_id` ASC);
ALTER TABLE `shopmobile_product_productcategory_category`.`category` 
ADD CONSTRAINT `fk_category_parent`
  FOREIGN KEY (`parent_id`)
  REFERENCES `shopmobile_product_productcategory_category`.`category` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  
  CREATE TABLE `shopmobile_product_productcategory_category`.`product_category` (
  `product_id` BIGINT NOT NULL,
  `category_id` BIGINT NOT NULL,
  PRIMARY KEY (`product_id`, `category_id`),
  INDEX `idx_pc_category` (`category_id` ASC),
  INDEX `idx_pc_product` (`product_id` ASC),
  CONSTRAINT `fk_pc_product`
    FOREIGN KEY (`product_id`)
    REFERENCES `shopmobile_product_productcategory_category`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pc_category`
    FOREIGN KEY (`category_id`)
    REFERENCES `shopmobile_product_productcategory_category`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);