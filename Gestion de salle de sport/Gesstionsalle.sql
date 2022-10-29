-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:8889
-- Généré le : mer. 15 juin 2022 à 23:39
-- Version du serveur :  5.7.34
-- Version de PHP : 7.4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `Gesstionsalle`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `nom` varchar(20) NOT NULL,
  `Prenom` varchar(20) NOT NULL,
  `nce` varchar(20) NOT NULL,
  `sport` varchar(20) NOT NULL,
  `dateD` varchar(20) NOT NULL,
  `dateF` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`nom`, `Prenom`, `nce`, `sport`, `dateD`, `dateF`) VALUES
('bilel', 'benyouusef', '123450', 'gym', '13/5/5', '2/2/2'),
('wael', 'kmel', '123455', 'gym', '12/3/5', '2/5/5');

-- --------------------------------------------------------

--
-- Structure de la table `coache`
--

CREATE TABLE `coache` (
  `nom` varchar(10) NOT NULL,
  `prenom` varchar(10) NOT NULL,
  `nce` varchar(9) NOT NULL,
  `sport` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `coache`
--

INSERT INTO `coache` (`nom`, `prenom`, `nce`, `sport`) VALUES
('mouhamed', 'benmohamed', '123456', 'gym');

-- --------------------------------------------------------

--
-- Structure de la table `Personne`
--

CREATE TABLE `Personne` (
  `nom` varchar(50) NOT NULL,
  `prénom` varchar(30) NOT NULL,
  `datedenaissance` varchar(25) NOT NULL,
  `tél` int(8) NOT NULL,
  `code` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `sport`
--

CREATE TABLE `sport` (
  `nomS` varchar(10) NOT NULL,
  `codeS` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `sport`
--

INSERT INTO `sport` (`nomS`, `codeS`) VALUES
('box', 'b'),
('gym', 'g'),
('jido', 'j'),
('yoga', 'y'),
('zomba', 'z');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` varchar(10) NOT NULL,
  `mdp` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `mdp`) VALUES
('admin', 'admin');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`nce`);

--
-- Index pour la table `coache`
--
ALTER TABLE `coache`
  ADD PRIMARY KEY (`nce`);

--
-- Index pour la table `Personne`
--
ALTER TABLE `Personne`
  ADD PRIMARY KEY (`code`);

--
-- Index pour la table `sport`
--
ALTER TABLE `sport`
  ADD PRIMARY KEY (`codeS`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `Personne`
--
ALTER TABLE `Personne`
  MODIFY `code` int(4) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
