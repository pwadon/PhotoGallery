
CREATE SCHEMA IF NOT EXISTS `photogallery`;

CREATE TABLE IF NOT EXISTS `photogallery`.`users` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `roles` VARCHAR(255) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE);



CREATE TABLE IF NOT EXISTS `photogallery`.`galleries` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `user_id` BIGINT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
  INDEX `galleries_users_id_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `galleries_users_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `photogallery`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE IF NOT EXISTS `photogallery`.`photos` (
                               `id` BIGINT NOT NULL AUTO_INCREMENT,
                               `name` VARCHAR(255) NOT NULL,
                               `file` LONGBLOB NOT NULL,
                               `type` VARCHAR(255) NULL,
                               `gallery_id` BIGINT NOT NULL,
                               PRIMARY KEY (`id`),
                               INDEX `photos_galleries_id_fk_idx` (`gallery_id` ASC) VISIBLE,
                               CONSTRAINT `photos_galleries_id_fk`
                                   FOREIGN KEY (`gallery_id`)
                                       REFERENCES `photogallery`.`galleries` (`id`)
                                       ON DELETE NO ACTION
                                       ON UPDATE NO ACTION);

