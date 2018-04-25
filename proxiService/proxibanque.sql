--
-- Base de données :  `proxibanqueSI`
--
CREATE DATABASE IF NOT EXISTS `proxibanqueSI` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `proxibanqueSI`;
-- --------------------------------------------------------

--
-- Création de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `idClient` integer primary key auto_increment,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `rue` varchar(255) DEFAULT NULL,
  `codePostal` varchar(255) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `idConseiller` int(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Création de la table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE `compte` (
  `idCompte` integer primary key auto_increment,
  `numeroCompte` int(100) NOT NULL,
  `solde` decimal(15,2) DEFAULT NULL,
  `typeCompte` varchar(255) DEFAULT NULL,
  `idClient` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Création de la table `conseiller`
--

DROP TABLE IF EXISTS `conseiller`;
CREATE TABLE `conseiller` (
  `idConseiller` integer primary key auto_increment,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Création de la table `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `idLogin` integer primary key auto_increment,
  `login` varchar(255) DEFAULT NULL,
  `motDePasse` varchar(255) DEFAULT NULL,
  `idConseiller` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Remplissage des tables
--

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`idClient`, `nom`, `prenom`, `rue`, `codePostal`, `ville`, `email`, `telephone`, `idConseiller`) VALUES
(1, 'Gaillard', 'Pierre', '1 cours Lafayette', '69006', 'Lyon', 'pierre@gmail.com', '0647896532', 1),
(2, 'Barbier', 'Paul', '2 cours Lafayette', '69006', 'Lyon', 'paul@gmail.com', '0659874123', 1),
(3, 'Agostini', 'Jean', '20 cours Lafayette', '69006', 'Lyon', 'jean@gmail.com', '0698741236', 1),
(4, 'Franklin', 'Benjamin', '40 cours Lafayette', '69006', 'Lyon', 'Ben@gmail.com', '0698741696', 2);

--
-- Contenu de la table `compte`
--

INSERT INTO `compte` (`idCompte`, `numeroCompte`, `solde`, `typeCompte`, `idClient`) VALUES
(1, 10025, '-800.00', 'courant', 1),
(2, 10036, '1000.00', 'courant', 2),
(3, 10033, '5600.00', 'courant', 3),
(4, 20038, '69000.00', 'epargne', 1),
(5, 20069, '600.00', 'epargne', 3);

--
-- Contenu de la table `conseiller`
--

INSERT INTO `conseiller` (`idConseiller`, `nom`, `prenom`) VALUES
(1, 'Blabla', 'Bliblou'),
(2, 'Pool', 'Dead');

--
-- Contenu de la table `login`
--

INSERT INTO `login` (`idLogin`, `login`, `motDePasse`, `idConseiller`) VALUES
(1, 'bb123', '412563', 1),
(2, 'reza', '784512', 2);

-- --------------------------------------------------------

--
-- Index pour les tables exportées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
	ADD CONSTRAINT `fk_conseiller` foreign key (idConseiller) REFERENCES conseiller(idConseiller);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
ADD CONSTRAINT `fk_client` foreign key (idClient) REFERENCES client(idClient);

--
-- Index pour la table `login`
--
ALTER TABLE `login`
ADD CONSTRAINT `fk_conseiller_login` foreign key (idConseiller) REFERENCES conseiller(idConseiller);
