DROP DATABASE IF EXISTS projectePHPRuben;
CREATE DATABASE projectePHPRuben;
USE projectePHPRuben;
CREATE TABLE producte (
    id INT AUTO_INCREMENT PRIMARY KEY,             -- ID autoincremental
    nom VARCHAR(255) NOT NULL,                     -- Nom del producte
    descripcio TEXT,                               -- Descripció del producte
    preu DECIMAL(10, 2) NOT NULL,                  -- Preu del producte
    imatge VARCHAR(255) DEFAULT 'producteDefecte.png', -- Imatge del producte (per defecte 'producteDefecte.png')
    magrada INT DEFAULT 0,                         -- Nombre de M'agrada (inicialment a 0)
    data_afegit TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Data d'afegiment del producte
    quantitat INT DEFAULT 30                       -- Quantitat de producte en estoc (inicialment a 30)
);
INSERT INTO producte (nom, descripcio, preu, imatge) VALUES
('Carla', 'Bresquilla varietat Carla amb un sorprenent gust dolç, àcid i estival.', 2.00, 'carla.png'),
('Faves', 'Faves perfectes tant per al consum indepenent com per a paella.', 3.00, 'faves.png'),
('Tomaca Pera', 'Tomaca sense acidesa perfecta per a preparar una base de tomaca dolça o fer una cassola.', 2.00, 'tomata.png'),
('Carxofes', 'La reina de les hortalisses. És una flor.', 5.00, 'carxofes.png'),
('Ciruelos', 'Compte! Tenen molta fibra i són extremadament gustosos i refrescants.', 4.00, 'ciruelos.png'),
('Freses', 'A qui no li agrada un toc cítric i àcid, a qui no li va a agradar?', 5.00, 'freses.png'),
('Cireres', 'Són com les freses però més petites i amb palo, i estàn igual o més bones', 5.00, 'cireres.png'),
('Big Top', 'Estàn les nectarines i després està la Big Top, la millor', 3.00, 'nectarines.png'),
('Early Top', 'Com la de antes, però això, Early', 2.00, 'nectarines.png'),
('Taronges', 'Què bó, un suquet... Però ràpid que sen van les vitamines', 2.00, 'taronges.png'),
('Mandarines', 'Versió portable de les taronges, les pots pelar sense esforç', 2.00, 'mandarines.png'),
('Taronges de la sang', 'Versió dark de les taronges, pareixen de Dracula', 2.00, 'tarongesSang.png'),
('Caqui', 'No sé mai com se escriu, va en qu o en k?', 2.00, 'caki.png'),
('Xatos', 'És com una bresquilla, però amb forma de ovni i més dolça sense acidesa', 2.00, 'xatos.png'),
('Meló de tot el any', 'És la fruta predilecta del estiu, refrescant i dolç', 2.00, 'melo.png'),
('Melo dAlger', 'És com una el anterior, però no té res a veure, també està bó i és per al mateix', 2.00, 'sandia.png'),
('Carabassa', 'De la familia de les cucurbitàcies, molt bona per a postre i per a cag-', 2.00, 'calabaza.png'),
('Pepino', 'De la familia de les cucurbitàcies també, molt bó per a les amanides i per a altres usos', 2.00, 'pepino.png'),
('Pimentó', 'Té diversos noms, bajoqueta farcida, primentó, pimentó.... però el volem igual en la nostra dieta', 2.00, 'calabaza.png'),
('Nectarines', 'Justament com les bresquilles, però amb pell llisa, perquè a ningú li agrada trobar-se pels a la boca quan es menja quelcom...', 3.00, 'nectarines.png');

CREATE TABLE comanda (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuari VARCHAR(255) NOT NULL,
    productes VARCHAR(1000) NOT NULL,
    data TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO comanda (usuari, productes, data) VALUES
('admin@dam.com', '1:1:2;6:1:5','2025-06-04 13:47:59');