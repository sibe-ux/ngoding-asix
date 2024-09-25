-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 06 Apr 2022 pada 10.50
-- Versi server: 10.4.24-MariaDB
-- Versi PHP: 7.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `movie`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `anime`
--

CREATE TABLE `anime` (
  `id` int(100) NOT NULL,
  `title` varchar(30) NOT NULL,
  `desk` text NOT NULL,
  `genre` text NOT NULL,
  `rating` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `anime`
--

INSERT INTO `anime` (`id`, `title`, `desk`, `genre`, `rating`) VALUES
(1, 'big hero 6', 'Robotics prodigy Hiro lives in the city of San Fransokyo. Next to his older brother, Tadashi, Hiro\'s closest companion is Baymax ...', 'sci-fi fantasy', 4),
(2, 'coco', 'Coco is a 2017 American computer-animated fantasy film by Pixar Animation Studios. Based on an\r\noriginal idea ...', 'kids drama', 2),
(3, 'kungfu panda 2', 'Kung Fu Panda 2 is a 2011 American computer-animated action comedy\r\nfilm produced by DreamWorks Animation ...', 'kids action', 4),
(4, 'kimi no nawa', 'Mitsuha Miyamizu, a high school girl, yearns to live the life of a boy in the bustling city of Tokyo ...', 'school drama romance', 4),
(5, 'cars 2', 'Lightning McQueen and Mater, along with Luigi, Guido, Fillmore and Sarge, travel to Japan and Europe ...', 'drama action', 3),
(6, 'up', 'As a boy, Carl Fredricksen wanted to explore South America and find the forbidden Paradise Falls. About 64 years later he gets to begin his journey ...', 'advanture kids', 5),
(7, 'jujutsu kaisen 0', 'Yuta Okkotsu is haunted by the spirit of his childhood friend Rika, who died in a tragic traffic accident. Her spirit no longer appears as the sweet girl ...', 'fantasy action school', 5),
(8, 'kimetsu no yaiba', 'Set after the events of the first season, Tanjiro, Zenitsu, Inosuke, and Nezuko board the Infinity Train to assist the Flame Hashira Kyojuro Rengoku ...', 'action fantasy demons', 5),
(9, 'finding nemo', 'A clown fish named Marlin lives in the Great Barrier Reef and loses his son, Nemo, after he ventures into the open sea, despite his father\'s ...', 'advanture drama', 3),
(10, 'ratatouille', 'A rat named Remy dreams of becoming a great French chef despite his family\'s wishes and the obvious problem of being a rat in a decidedly rodent ...', 'romance', 4),
(11, 'wreck it ralph', 'Going off to a bar-game called Tapper, Ralph is unsure what to do, when he encounters a soldier from a new first-person shooter named \"Hero\'s Duty.\" ...', 'fantasy kids action', 2),
(12, 'toy story 4', 'Woody and the rest of the toys are back for an all-new adventure in Toy Story 4, welcoming new friends to\r\nBonnie\'s room ...', 'advanture action', 3),
(13, 'sword art online', 'High school student Asuna struggles to survive with a young swordsman after its revealed that she is trapped inside the game of Sword Art Online ...', 'action fantasy romance', 4),
(14, 'tenki no ko', 'Hodaka quickly finds himself in over his head in Tokyo when he’s unable to find a job. He takes showers at cheaply-priced manga cafes ...', 'romance sci-fi drama', 2),
(15, 'sen to chihiro', 'Chihiro, a ten-year-old girl, sulks in the back seat of her parents car. The family is on its way to a new home, and Chihiro doesnt want to move ...', 'demons kids', 2);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `anime`
--
ALTER TABLE `anime`
  ADD UNIQUE KEY `id` (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `anime`
--
ALTER TABLE `anime`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
