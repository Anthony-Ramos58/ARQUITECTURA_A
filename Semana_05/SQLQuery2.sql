


CREATE DATABASE BaseDeDatosRamos;
GO

USE BaseDeDatosRamos;
GO

CREATE TABLE Persona (
    id INT PRIMARY KEY IDENTITY(1,1), 
    nombres VARCHAR(100) NOT NULL,
    correo VARCHAR(255),
    numero VARCHAR(20)
);
GO


USE BaseDeDatosRamos;
GO

INSERT INTO Persona 
VALUES ('Carlos Perez', 'carlos.perez@example.com', '123456789');

INSERT INTO Persona 
VALUES ('Maria Gonzalez', 'maria.gonzalez@example.com', '987654321');

INSERT INTO Persona 
VALUES ('Juan Ramirez', 'juan.ramirez@example.com', '654321987');
GO


USE BaseDeDatosRamos;
GO

SELECT * FROM Persona;
