-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 09, 2016 at 08:16 PM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `salesystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE IF NOT EXISTS `book` (
`B_ID` int(6) NOT NULL,
  `bname` varchar(50) NOT NULL,
  `cost` decimal(13,2) NOT NULL,
  `yearofpublication` int(4) NOT NULL,
  `publicationHouse` varchar(50) NOT NULL,
  `author` varchar(50) NOT NULL,
  `numofpages` int(6) NOT NULL,
  `isbn` int(10) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`B_ID`, `bname`, `cost`, `yearofpublication`, `publicationHouse`, `author`, `numofpages`, `isbn`) VALUES
(1, 'java', '20.00', 2010, 'CNWL', 'mathews', 1000, 3345),
(2, 'Business Studies', '30.00', 2005, 'Dynamic Learning', 'Ian Marcouse', 600, 55633),
(3, 'SQL', '30.00', 2013, 'Dummies', 'Richard Blues', 456, 634536),
(6, 'Introduction to HTML', '25.00', 2010, 'Candenhead', 'Lemey', 500, 34235),
(7, 'UML Design', '25.00', 2012, 'Dummies', 'Mantee', 675, 22334);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
`Cat_id` int(6) NOT NULL,
  `Cat_Name` varchar(20) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`Cat_id`, `Cat_Name`) VALUES
(3, 'Books'),
(4, 'Software');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
`cid` int(6) NOT NULL,
  `fname` varchar(30) NOT NULL,
  `sname` varchar(40) NOT NULL,
  `dob` date NOT NULL,
  `address` varchar(60) NOT NULL,
  `postcode` varchar(15) NOT NULL,
  `phone` varchar(12) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cid`, `fname`, `sname`, `dob`, `address`, `postcode`, `phone`) VALUES
(1, 'Pablito', 'Sampaio', '2001-09-26', '6 tregenna court', 'HA0 2EH', '07402134297'),
(2, 'Patricia', 'Tome', '1975-08-08', '6 Tregenna Court, Wembley', 'HA0 2EH', '07535026579'),
(3, 'Renan', 'Gado', '1993-03-25', '43 Eskdale Close, Wembley', 'HA9 8XB', '07402813913'),
(4, 'Parthif', 'Patel', '1993-01-02', '109 Harrow Road, Harlesden', 'NW10 4TS', '07986856941'),
(5, 'victor', 'Do Gado', '1994-02-25', '32 High Street, Wembley', 'HA0 2JN', '07576903256'),
(6, 'Mohammed', 'Catubig', '1993-05-20', '755 Kilburn Road,Kilburn', 'NW9 7HQ', '07434578912'),
(7, 'Hunor', 'Balint', '1993-09-23', 'Greenford Road, Greenford', 'HA9 8XT', '07854543675'),
(8, 'Nikesh', 'Patel', '1993-02-23', 'High Street, Willesden', 'HA0 3Ha', '07854356781'),
(9, 'sddsasdsad', 'dasds', '1990-06-06', 'wewew', 'ewqewqe', '343434324'),
(10, 'renan', 'gado', '2001-02-12', 'test', 'test', '933434522221');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE IF NOT EXISTS `orders` (
`o_id` int(6) NOT NULL,
  `cid` int(6) NOT NULL,
  `orderdate` date NOT NULL,
  `ordertime` time NOT NULL,
  `price` decimal(13,2) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`o_id`, `cid`, `orderdate`, `ordertime`, `price`) VALUES
(1, 1, '2015-02-04', '22:26:18', '696.78'),
(2, 3, '2015-02-04', '22:29:56', '1526.58'),
(3, 1, '2015-02-05', '09:28:27', '60.00'),
(4, 3, '2015-02-05', '09:32:59', '731.95'),
(5, 2, '2015-02-05', '10:56:03', '175.00'),
(6, 8, '2015-02-09', '15:46:15', '100.19'),
(7, 2, '2015-02-10', '20:46:47', '2440.00'),
(8, 1, '2015-03-08', '22:44:16', '694.99'),
(9, 7, '2015-03-08', '22:47:25', '810.60'),
(10, 6, '2015-04-30', '15:19:51', '68.99'),
(11, 3, '2016-02-15', '23:08:33', '105.00'),
(12, 10, '2016-03-01', '23:32:54', '103.99'),
(13, 4, '2016-03-02', '14:10:59', '775.00');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
`P_id` int(6) NOT NULL,
  `Cat_id` int(6) DEFAULT NULL,
  `Pname` varchar(50) NOT NULL,
  `cost` decimal(13,2) NOT NULL,
  `yearofpublication` int(4) NOT NULL,
  `publicationHouse` varchar(50) NOT NULL,
  `author` varchar(50) DEFAULT NULL,
  `numofpages` int(6) DEFAULT NULL,
  `isbn` int(10) DEFAULT NULL,
  `processor` varchar(30) DEFAULT NULL,
  `ram` varchar(20) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`P_id`, `Cat_id`, `Pname`, `cost`, `yearofpublication`, `publicationHouse`, `author`, `numofpages`, `isbn`, `processor`, `ram`) VALUES
(1, 3, 'Impulse Manual', '18.99', 2014, 'Impulse', 'Marcus Oliver', 100, 21434, NULL, NULL),
(2, 4, 'Norton Anti-Virus', '59.99', 2014, 'Norton', NULL, NULL, NULL, '32Bit', '2GB'),
(3, 3, 'Java', '20.00', 2010, 'CNWL', 'Mathews', 1000, 244345, NULL, NULL),
(4, 3, 'Business Studies', '30.00', 2005, 'Dynamic Learning', 'Ian Marcouse', 600, 23424, NULL, NULL),
(5, 3, 'Advanced SQL', '40.60', 2013, 'Dummies', 'Richard Blues', 564, 64463, NULL, NULL),
(6, 3, 'Introduction to HTML', '45.00', 2012, 'Head First', 'Lemey', 500, 35563, NULL, NULL),
(7, 3, 'UML Design', '45.00', 2013, 'Dummies', 'Mantee', 765, 535322, NULL, NULL),
(8, 4, 'Visio', '455.99', 2013, 'Microsoft', NULL, NULL, NULL, '32Bit', '2GB'),
(9, 4, 'PhotoShop', '560.00', 2014, 'Adobe', NULL, NULL, NULL, '64Bit', '4GB'),
(10, 4, 'Windows 8', '100.00', 2013, 'Microsoft', NULL, NULL, NULL, '32Bit', '2GB'),
(11, 4, 'Ableton Live 9', '600.00', 2014, 'Music', NULL, NULL, NULL, '64Bit', '8GB'),
(12, 4, 'Office', '59.99', 2013, 'Microsoft', NULL, NULL, NULL, '32Bit', '2GB');

-- --------------------------------------------------------

--
-- Table structure for table `product_order`
--

CREATE TABLE IF NOT EXISTS `product_order` (
`po_id` int(6) NOT NULL,
  `o_id` int(6) NOT NULL,
  `P_id` int(6) NOT NULL,
  `quantity` int(3) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=52 ;

--
-- Dumping data for table `product_order`
--

INSERT INTO `product_order` (`po_id`, `o_id`, `P_id`, `quantity`) VALUES
(1, 1, 1, 1),
(2, 1, 8, 1),
(3, 1, 10, 1),
(4, 1, 5, 3),
(5, 2, 3, 3),
(6, 2, 4, 1),
(7, 2, 6, 2),
(8, 2, 2, 1),
(9, 2, 10, 1),
(10, 2, 11, 1),
(11, 2, 8, 1),
(12, 2, 7, 1),
(13, 2, 6, 1),
(14, 2, 5, 1),
(15, 3, 4, 1),
(16, 3, 4, 1),
(17, 4, 8, 1),
(18, 4, 10, 2),
(19, 4, 1, 4),
(20, 5, 3, 2),
(21, 5, 6, 3),
(22, 6, 1, 1),
(23, 6, 5, 1),
(24, 6, 5, 1),
(25, 7, 3, 1),
(26, 7, 6, 4),
(27, 7, 9, 4),
(28, 8, 4, 1),
(29, 8, 6, 1),
(30, 8, 9, 1),
(31, 8, 2, 1),
(32, 9, 3, 1),
(33, 9, 6, 4),
(34, 9, 3, 4),
(35, 9, 10, 4),
(36, 9, 7, 1),
(37, 9, 6, 1),
(38, 9, 5, 1),
(39, 10, 1, 1),
(40, 10, 3, 1),
(41, 10, 4, 1),
(42, 11, 6, 1),
(43, 11, 4, 1),
(44, 11, 4, 1),
(45, 12, 3, 1),
(46, 12, 6, 1),
(47, 12, 1, 1),
(48, 12, 3, 1),
(49, 13, 3, 2),
(50, 13, 4, 2),
(51, 13, 6, 15);

-- --------------------------------------------------------

--
-- Table structure for table `software`
--

CREATE TABLE IF NOT EXISTS `software` (
`S_ID` int(6) NOT NULL,
  `sname` varchar(50) NOT NULL,
  `cost` decimal(13,2) NOT NULL,
  `yearofpublication` int(4) NOT NULL,
  `publicationHouse` varchar(50) NOT NULL,
  `Processor` varchar(50) NOT NULL,
  `ram` varchar(50) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `software`
--

INSERT INTO `software` (`S_ID`, `sname`, `cost`, `yearofpublication`, `publicationHouse`, `Processor`, `ram`) VALUES
(1, 'visio', '500.00', 2013, 'microsoft', 'intel core I3', '2GB'),
(2, 'Photoshop', '700.00', 2014, 'Adobe', 'Intel Core I7', '4GB'),
(3, 'Windows 8', '500.00', 2014, 'Microsoft', '32 bits ', '2GB'),
(4, 'Ableton Live 9', '650.00', 2013, 'Music', '64bit I5 ', '4GB'),
(5, 'Office 2013', '59.99', 2013, 'Microsoft', '32 bit I3 Intel', '2GB'),
(6, 'Dream Weaver', '599.00', 2013, 'Adobe', '64 bit I5 Intel', '4GB');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
 ADD PRIMARY KEY (`B_ID`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
 ADD PRIMARY KEY (`Cat_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
 ADD PRIMARY KEY (`cid`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
 ADD PRIMARY KEY (`o_id`), ADD KEY `fkcustomer` (`cid`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
 ADD PRIMARY KEY (`P_id`), ADD KEY `fkbrasta` (`Cat_id`);

--
-- Indexes for table `product_order`
--
ALTER TABLE `product_order`
 ADD PRIMARY KEY (`po_id`), ADD KEY `fkorder` (`o_id`), ADD KEY `fkproducts` (`P_id`);

--
-- Indexes for table `software`
--
ALTER TABLE `software`
 ADD PRIMARY KEY (`S_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
MODIFY `B_ID` int(6) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
MODIFY `Cat_id` int(6) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
MODIFY `cid` int(6) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
MODIFY `o_id` int(6) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
MODIFY `P_id` int(6) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `product_order`
--
ALTER TABLE `product_order`
MODIFY `po_id` int(6) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=52;
--
-- AUTO_INCREMENT for table `software`
--
ALTER TABLE `software`
MODIFY `S_ID` int(6) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
ADD CONSTRAINT `fkcustomer` FOREIGN KEY (`cid`) REFERENCES `customer` (`cid`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
ADD CONSTRAINT `fkbrasta` FOREIGN KEY (`Cat_id`) REFERENCES `category` (`Cat_id`);

--
-- Constraints for table `product_order`
--
ALTER TABLE `product_order`
ADD CONSTRAINT `fkorder` FOREIGN KEY (`o_id`) REFERENCES `orders` (`o_id`),
ADD CONSTRAINT `fkproducts` FOREIGN KEY (`P_id`) REFERENCES `product` (`P_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
