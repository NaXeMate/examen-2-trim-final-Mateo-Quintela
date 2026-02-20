-- 1. Inserción de Tripulantes (Persona) 
INSERT INTO persona (id, nombre, rango, licencia_estelar) VALUES 
(1, 'James T. Kirk', 'Capitán', 'NCC-1701-A'),
(2, 'Nyota Uhura', 'Oficial', 'NCC-1884-U'),
(3, 'Spock', 'Oficial', 'NCC-2234-S'),
(4, 'Pavel Chekov', 'Recluta', 'NCC-9001-C'),
(5, 'Hikaru Sulu', 'Capitán', 'NCC-0552-H');

-- 2. Inserción de Naves (Trabajo) 
INSERT INTO nave (id, nombre_nave, modelo, capacidad) VALUES 
(1, 'USS Enterprise', 'Constitution Class', 430),
(2, 'USS Voyager', 'Intrepid Class', 150),
(3, 'USS Defiant', 'Escort Vessel', 50),
(4, 'USS Discovery', 'Crossfield Class', 200),
(5, 'La Sirena', 'Freighter', 10);

-- 3. Inserción de Misiones (Vida_Laboral / Mision_Asignada) 
-- Combinación irregular: Kirk tiene 8, Uhura 6, Spock 7, Chekov 1 y Sulu 3.
INSERT INTO mision_asignada (tripulante_id, nave_id, fecha_estelar, estado, presupuesto) VALUES 
-- Misiones de Kirk (Veterano)
(1, 1, 2265.1, 'COMPLETADA', 50000.00),
(1, 1, 2266.4, 'COMPLETADA', 45000.00),
(1, 3, 2267.2, 'COMPLETADA', 12000.00),
(1, 1, 2268.8, 'COMPLETADA', 55000.00),
(1, 1, 2269.0, 'COMPLETADA', 60000.00),
(1, 2, 2270.5, 'COMPLETADA', 30000.00),
(1, 1, 2271.1, 'COMPLETADA', 48000.00),
(1, 1, 2272.4, 'ACTIVA', 75000.00),

-- Misiones de Uhura
(2, 1, 2265.1, 'COMPLETADA', 25000.00),
(2, 4, 2267.5, 'COMPLETADA', 15000.00),
(2, 4, 2268.2, 'COMPLETADA', 18000.00),
(2, 1, 2269.9, 'COMPLETADA', 22000.00),
(2, 1, 2271.0, 'COMPLETADA', 24000.00),
(2, 5, 2272.8, 'ACTIVA', 5000.00),

-- Misiones de Spock
(3, 1, 2265.1, 'COMPLETADA', 35000.00),
(3, 1, 2266.3, 'COMPLETADA', 32000.00),
(3, 1, 2267.8, 'COMPLETADA', 34000.00),
(3, 3, 2268.5, 'COMPLETADA', 10000.00),
(3, 1, 2270.2, 'COMPLETADA', 38000.00),
(3, 1, 2271.4, 'COMPLETADA', 40000.00),
(3, 2, 2272.9, 'ACTIVA', 15000.00),

-- Misiones de Pavel Chekov (Novato)
(4, 3, 2272.1, 'ACTIVA', 8000.00),

-- Misiones de Hikaru Sulu
(5, 5, 2268.1, 'COMPLETADA', 12000.00),
(5, 5, 2270.4, 'COMPLETADA', 14000.00),
(5, 1, 2272.5, 'ACTIVA', 45000.00);
