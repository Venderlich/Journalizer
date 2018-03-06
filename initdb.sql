CREATE TABLE Utilisateur(
    Login VARCHAR,
    Mdp VARCHAR
);

CREATE TABLE TypeDeCour(
    ID INTEGER  PRIMARY KEY,
    LabelTDC VARCHAR,
    Rapport REAL
);

CREATE TABLE ParametrageObjectif(
    VariableObjectif REAL
);

CREATE TABLE ParametrageHorraire(
    VolumeHorraire REAL
);

CREATE TABLE Matiere(
    ID INTEGER PRIMARY KEY,
    LabelMatiere VARCHAR
);

CREATE TABLE Filiere(
    ID INTEGER PRIMARY KEY,
    LabelFiliere VARCHAR
);

CREATE TABLE Seance(
    ID INTEGER PRIMARY KEY,
    Commentaire VARCHAR,
    dateSeance DATE,
    Temps INTEGER,
    IDFiliere INTEGER,
    IDTypeDeCour INTEGER,
    IDMatiere INTEGER,
    FOREIGN KEY(IDFiliere) REFERENCES Filiere(ID),
    FOREIGN KEY(IDTypeDeCour) REFERENCES TypeDeCour(ID),
    FOREIGN KEY(IDMatiere) REFERENCES Matiere(ID)
);