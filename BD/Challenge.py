from dataclasses import dataclass
import mysql.connector

#Nos da la conexion a la base de datos
cnn= mysql.connector.connect(host="localhost",user="root",passwd="Nico41470427",database="bdchallenge")
#Creamos el cursor para despues poder usarlo con el registro 
cursor= cnn.cursor()


"""Todo lo siguiente esta comentado,basicamente es la creacion de tabla con sus cargas las cuales no pude resolver como la consigna lo solicitaba"""
#sqlVar=""" CREATE TABLE empleados (id INT AUTO_INCREMENT PRIMARY KEY,munip_id INTEGER NOT NULL,FOREIGN KEY (munip_id) REFERENCES municipalidad (id) ,nombre VARCHAR(255),telefono INT,
#email VARCHAR(255),puesto VARCHAR(255),salario INT,antiguedad INT)"""

#sqlVar2="""CREATE TABLE Municipalidad (id INT AUTO_INCREMENT PRIMARY KEY,municipalidad VARCHAR(255),
#provincia VARCHAR(255),ciudad VARCHAR(255))"""


#cursor.execute("""INSERT INTO municipalidad (municipalidad,provincia,ciudad) 
#VALUES  ('Municipialidad Bs as','Buenos Aires','La Plata') """)
#cursor.execute("""INSERT INTO municipalidad (municipalidad,provincia,ciudad) 
#VALUES  ('Municipialidad Gral Pueyrredon','Buenos Aires','Mar del Plata') """)
#cursor.execute("""INSERT INTO municipalidad (municipalidad,provincia,ciudad) 
#VALUES  ('Municipialidad Catamarca','Catamarca','S.F del Valle de Catamarca') """)
#cursor.execute("""INSERT INTO municipalidad (municipalidad,provincia,ciudad) 
#VALUES  ('Municipalidad Santa Cruz','Santa Cruz','Rio Gallegos') """)


cursor.execute("""INSERT INTO empleados (munip_id,nombre,telefono,email,puesto,salario,antiguedad) 
VALUES  (12,'Jorge Lopez',223598765,'JorgeLopez@gmail.com','Limpieza',80000,16) """)  

cursor.execute("""INSERT INTO empleados (munip_id,nombre,telefono,email,puesto,salario,antiguedad) 
VALUES  (9,'Fernanda Fernandez',223567123,'FernandoFernandez@gmail.com','Administracion',60000,12) """)

cursor.execute("""INSERT INTO empleados (munip_id,nombre,telefono,email,puesto,salario,antiguedad) 
VALUES  (10,'Gustavo Gutierrez',22345678,'GustavoGutierrez@outlook.com','Asistente',110000,4) """)

cursor.execute("""INSERT INTO empleados (munip_id,nombre,telefono,email,puesto,salario,antiguedad) 
VALUES  (11,'Gonzalo Gonzalez',223532431,'GonzaloGonzalez@yahoo.com','Seguridad Vial',150000,3) """)

cursor.execute("""INSERT INTO empleados (munip_id,nombre,telefono,email,puesto,salario,antiguedad) 
VALUES  (12,'Romeo Romero',223623534,'RomeoRomero@live.com','Concejal',200000,2) """)

cursor.execute("""INSERT INTO empleados (munip_id,nombre,telefono,email,puesto,salario,antiguedad) 
VALUES  (9,'Martina Martinez',223612334,'MartinMartinez@gmail.com','Secretaria',140000,14) """)
    
#Filtro para obtener al empleado que cumpla con los requisitos y el acceso a la otra tabla por medio de la clave foranea para mostrar la info de ambas
sql="""SELECT * FROM empleados e INNER JOIN municipalidad m ON e.munip_id = m.id 
WHERE  antiguedad<15 AND antiguedad>10 AND salario > 70000"""
cursor.execute(sql)

empleados=cursor.fetchall()#Tomo los datos filtrados de las tablas y lo almaceno en la variable

for emp in empleados:#Me muestra un doble registro del empleado que cumple los requisitos donde incrementa lo que seria el ID por el numero de ID como si fuese un acumulador,no encontré solución
    print(emp)





