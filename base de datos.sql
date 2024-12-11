-- Crear la base de datos
CREATE DATABASE Biblioteca;

-- Usar la base de datos
USE Biblioteca;

-- Crear la tabla Libros
CREATE TABLE Libros (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    genero VARCHAR(100),
    disponibilidad BOOLEAN DEFAULT TRUE,
    fecha_publicacion DATE
);

-- Crear la tabla Usuarios
CREATE TABLE Usuarios (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    DNI VARCHAR(20) UNIQUE NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(150) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    telefono VARCHAR(15),
    rol ENUM('Administrador', 'Usuario estándar') NOT NULL
);

-- Crear la tabla Prestamos
CREATE TABLE Prestamos (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    libro_id INT NOT NULL,
    usuario_id INT NOT NULL,
    fecha_prestamo DATE NOT NULL,
    fecha_devolucion DATE,
    multa_generada DECIMAL(10, 2) DEFAULT 0,
    FOREIGN KEY (libro_id) REFERENCES Libros(ID) ON DELETE CASCADE,
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(ID) ON DELETE CASCADE
);

-- Crear la tabla Reservas
CREATE TABLE Reservas (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    libro_id INT NOT NULL,
    usuario_id INT NOT NULL,
    fecha_reserva DATE NOT NULL,
    estado ENUM('Pendiente', 'Completada', 'Cancelada') NOT NULL,
    FOREIGN KEY (libro_id) REFERENCES Libros(ID) ON DELETE CASCADE,
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(ID) ON DELETE CASCADE
);
