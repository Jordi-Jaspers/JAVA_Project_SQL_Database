-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Gegenereerd op: 26 mei 2018 om 20:31
-- Serverversie: 10.1.32-MariaDB
-- PHP-versie: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bachelor`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `bachelorproef`
--

CREATE TABLE `bachelorproef` (
  `id` int(11) NOT NULL,
  `titel` varchar(40) NOT NULL,
  `beschrijving` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `bachelorproef`
--

INSERT INTO `bachelorproef` (`id`, `titel`, `beschrijving`) VALUES
(1, 'Artificial intellegence', 'Kunstmatige intelligentie (KI) of artificiële intelligentie (AI) is de wetenschap die zich bezighoudt met het creëren van een artefact dat een vorm van intelligentie vertoont.'),
(2, 'Machine Learning', 'Automatisch leren of Machinaal leren is een breed onderzoeksveld binnen kunstmatige intelligentie, dat zich bezighoudt met de ontwikkeling van algoritmes en technieken waarmee computers kunnen leren.'),
(3, 'Bladgroei', 'Analyse van patroonvorming in wiskundige modellen voor bladgroei'),
(4, 'Fasecontrast tomografie', 'Onder tomografie wordt verstaan het op non-invasieve wijze maken van een tweedimensionale afbeelding die een doorsnede weergeeft van een driedimensionaal object. Dat object kan een menselijk lichaam, een dier, een plant of een dood voorwerp zijn. '),
(5, 'Software Development Life-cycle(SDLC)', 'DOJ SDLC (Department of Justice Systems Development Life Cycle) is een methode van het ministerie van justitie van de Verenigde Staten voor het ontwikkelen van informatiesystemen. Deze methode bevat procedures en richtlijnen voor het opzetten van projecten, conceptontwikkeling, planning, requirements analyse, ontwerp, ontwikkeling, integratie, implementatie en onderhoud van informatiesystemen binnen het Ministerie van Justitie. ');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `studenten`
--

CREATE TABLE `studenten` (
  `id` int(11) NOT NULL,
  `naam` varchar(40) NOT NULL,
  `Groep` varchar(3) NOT NULL,
  `bachelorproef` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `studenten`
--

INSERT INTO `studenten` (`id`, `naam`, `Groep`, `bachelorproef`) VALUES
(2, 'Simon Aerts', 'A1', 'Artificial intellegence'),
(3, 'Senne Colson', 'A1', 'Artificial intellegence'),
(4, 'Johan Kruis', 'B5', 'Bladgroei'),
(5, 'Tom Fierens', 'C2', 'Bladgroei'),
(7, 'Jordi Jaspers', 'A1', 'Artificial intellegence'),
(8, 'Jan DeBoer', 'C2', 'Artificial intellegence'),
(9, 'Lucas AltijdHonger', 'C2', 'Fasecontrast tomografie'),
(11, 'Benedict Hoog', 'B5', 'Machine Learning'),
(12, 'Kendrick Lamar', 'B5', 'Machine Learning'),
(13, 'Dirk Snel', 'D9', 'Fasecontrast tomografie'),
(14, 'Bart Langzaam', 'D9', 'Software Development Life-cycle(SDLC)'),
(15, 'Kurt Slim', 'D9', 'Software Development Life-cycle(SDLC)');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `studentenkeuze`
--

CREATE TABLE `studentenkeuze` (
  `id` int(11) NOT NULL,
  `Student1` varchar(40) NOT NULL,
  `Student2` varchar(40) NOT NULL,
  `Student3` varchar(40) NOT NULL,
  `Groep` varchar(2) NOT NULL,
  `Bachelorproef` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `studentenkeuze`
--

INSERT INTO `studentenkeuze` (`id`, `Student1`, `Student2`, `Student3`, `Groep`, `Bachelorproef`) VALUES
(1, 'Simon Aerts', 'Senne Colson', 'Jordi Jaspers', 'A1', 'Artificial intellegence'),
(2, 'Tom Fierens', 'Jan DeBoer', 'Lucas AltijdHonger', 'C2', 'Bladgroei'),
(3, 'Johan Kruis', 'Benedict Hoog', 'Kendrick Lamar', 'B5', 'Bladgroei'),
(4, 'Dirk Snel', 'Bart Langzaam', 'Kurt Slim', 'D9', 'Software Development Life-cycle(SDLC)');

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `bachelorproef`
--
ALTER TABLE `bachelorproef`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `studenten`
--
ALTER TABLE `studenten`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `studentenkeuze`
--
ALTER TABLE `studentenkeuze`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `bachelorproef`
--
ALTER TABLE `bachelorproef`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT voor een tabel `studenten`
--
ALTER TABLE `studenten`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT voor een tabel `studentenkeuze`
--
ALTER TABLE `studentenkeuze`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
