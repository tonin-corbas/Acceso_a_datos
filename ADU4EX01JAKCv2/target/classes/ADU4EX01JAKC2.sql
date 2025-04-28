CREATE TABLE Cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(255),
    Email VARCHAR(255)
);

CREATE TABLE Pedido (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT,
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente)
);

CREATE TABLE Producto (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido INT,
    Nombre VARCHAR(255),
    Precio INT,
    FOREIGN KEY (id_pedido) REFERENCES Pedido(id_pedido)
);