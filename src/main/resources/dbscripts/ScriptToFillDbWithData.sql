-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: mdmg
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
SET NAMES utf8;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Dumping data for table `answers`
--

LOCK TABLES `answers` WRITE;
/*!40000 ALTER TABLE `answers`
    DISABLE KEYS */;
INSERT INTO `answers`
VALUES (1, 1, 'Hockey', 'Хоккей', 'no'),
       (2, 1, 'Golf', 'Гольф', 'no'),
       (3, 1, 'Polo', 'Поло', 'no'),
       (4, 1, 'Billiards ', 'Бильярд', 'yes'),
       (5, 2, 'Mississippi and Missouri.', 'Миссисипи и Миссури.', 'yes');
/*!40000 ALTER TABLE `answers`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `question_types`
--

LOCK TABLES `question_types` WRITE;
/*!40000 ALTER TABLE `question_types`
    DISABLE KEYS */;
INSERT INTO `question_types`
VALUES (1, 'single'),
       (2, 'multi');
/*!40000 ALTER TABLE `question_types`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions`
    DISABLE KEYS */;
INSERT INTO `questions`
VALUES (1, 2, 'In which of these games players don\'t use a brassy/bandy?', 'В какую из этих игр играют не клюшкой?',
        'It is a straight stick', 'Это ровная палка'),
       (2, 1,
        'They are closely related to each other. You would think that one of them - Ippi - married, and the other - Uri - unmarried. Call them.',
        'Они тесно связаны друг с другом. Можно подумать, что одна из них - Ипи - замужняя, а другая - Ури - незамужняя. Назовите их.',
        'It is a river', 'Это река');
/*!40000 ALTER TABLE `questions`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles`
    DISABLE KEYS */;
INSERT INTO `roles`
VALUES (1, 'admin'),
       (2, 'user'),
       (3, 'judge');
/*!40000 ALTER TABLE `roles`
    ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users`
    DISABLE KEYS */;
INSERT INTO `users`
VALUES (1, 'admin1@gmail.com', '6ca96199605f82f949731d890e987191', 'Admin1', 'AdminLast', 1),
       (2, 'user1@gmail.com', 'd35d3ba516a1827bd24ffec29ed1a438', 'User1', 'UserLast1', 2),
       (3, 'user2@yandex.ru', '5d43b145b2fcd8340acec2136a5f08fe', 'Юзер2', 'Юзеренко', 2),
       (4, 'judge1@gmail.com', '2c71032341ac3a0fdcfacb1b7997ae82', 'John', 'Doe', 3),
       (5, 'nataliya.trach@gmail.com', '044c2a1259365c868c07b50034fd2369', 'Nataliya', 'Trach', 2),
       (6, 'sasha.rainin@gmail.com', 'c53a3f84a12f90c521aff57d0b808e7c', 'Sasha', 'Rainin', 2),
       (7, 'kola.granovsky@gmail.com', '8d4f2aa45eec1dbf460e47d01fb0769a', 'Kola', 'Granovsky', 2),
       (8, 'andrey.vovk@gmail.com', '1608b99c9ccdde37458db81cbd1b5af5', 'Andrey', 'Vovk', 2),
       (9, 'jack.kistion@gmail.com', '8eb9e4be58e6b5df4d40208c8a2e0c24', 'Jack', 'Kistion', 2),
       (10, 'bob.stets@gmail.com', '2d2fa334b8daf7f90882e25cbb0c10b0', 'Bob', 'Stets', 2),
       (11, 'jim.lozhkin@gmail.com', 'aecc349fbcc50b8ed9633dfb2bc46e0b', 'Jim', 'Lozhkin', 2),
       (12, 'ira.petrenko@gmail.com', 'db41caf11a5b3ce1019bbfb034766de6', 'Ира', 'Петренко', 2),
       (13, 'luda.svyrydendo@gmail.com', '3c68a6ef05e794f59439780109d33a68', 'Luda', 'Svyrydenko', 2),
       (14, 'natasha.vlasova@gmail.com', '2534cd14fb84fe8bc7e7700d9fd4a5a5', 'Natasha', 'Vlasova', 2),
       (15, 'max.hryniv@gmail.com', '12aa5a007204bc9cc81b3de342b0689f', 'Max', 'Hryniv', 2),
       (16, 'alex.smith@gmail.com', '70fb949d21c2940a166362b540b0a965', 'Alex', 'Smith', 2),
       (17, 'jon.black@gmail.com', '1beb3e13fdd7f6fdbf762ad447f1b7f6', 'Jon', 'Black', 2),
       (18, 'jon.white@gmail.com', '5df06a51104a508f3b54c17b9bbd6dc2', 'Jon', 'White', 2),
       (19, 'petro.petrenko@gmail.com', 'ef91acb7d02ef268e9db6474c7e7bc76', 'Петро', 'Петренко', 2),
       (20, 'george.king@gmail.com', '1ffe63c25ac97c00b7078e73b638dfeb', 'George', 'King', 2),
       (21, 'stefan.korniev@gmail.com', '24acdc3a607a7a5a46e50f83b52efae7', 'Stefan', 'Korniev', 2),
       (22, 'jon.smith@gmail.com', '63dfdf2434d5186f684aa575e1dcbb62', 'Jon', 'Smith', 2);
/*!40000 ALTER TABLE `users`
    ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;


