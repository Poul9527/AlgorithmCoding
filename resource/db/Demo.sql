CREATE TABLE IF NOT EXISTS `student` (
                                               `id` int(10) NOT NULL AUTO_INCREMENT,
                                               `name` VARCHAR (32) NOT NULL,
											   `number` VARCHAR (150) NOT NULL UNIQUE,
                                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=3;
