-- === USERS ===
INSERT INTO users (username, password, role, fullname, email, enabled)
VALUES
('admin', 'admin123', 'ADMIN', 'System Admin', 'admin@mobilefix.com', TRUE),
('laura', 'user123', 'USER', 'Laura Gómez', 'laura@example.com', TRUE),
('andrew', 'tech123', 'TECH', 'Andrew López', 'andrew@mobilefix.com', TRUE);

-- === DEVICES ===
INSERT INTO devices (brand, model, serial_number)
VALUES
('Samsung', 'Galaxy S21', 'SN001'),
('Apple', 'iPhone 13', 'SN002'),
('Xiaomi', 'Redmi Note 12', 'SN003');

-- === REPAIR ORDERS ===
INSERT INTO repair_orders (customer_id, device_id, issue_description, status, assigned_tech_id, created_at, updated_at, tech_notes)
VALUES
(2, 1, 'Pantalla rota por caída', 'PENDING', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL),
(2, 2, 'Batería no carga correctamente', 'IN_PROGRESS', 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Batería en revisión'),
(2, 3, 'No enciende después de actualización', 'READY', 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Actualización completada y testeada');
