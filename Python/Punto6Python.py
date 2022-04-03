


from ast import Pass
from hashlib import new
import random
import string

class Password:

    
    def __init__(self,contrasenia):
        self.contrasenia=contrasenia
        self.longitud=len(contrasenia)

    def __init__(self,contrasenia):
        self.contrasenia=contrasenia
        self.longitud=8

    def __str__(self):
        cadena=self.contrasenia;+self.longitud
        return cadena
    
    #def get_contrasenia(self):
     #   return self.contrasenia
    
    def set_contrasenia(self,contrasenia):
        self.contrasenia=contrasenia
    
    def get_longitud(self):
        return self.longitud

    def set_longitud(self,longitud):
        self.longitud=longitud

    
    def es_fuerte(self,pw): #Es mas o menos la misma logica que en JAVA la diferencia es  la utilizacion del for each y que uso return en el if else
                        #Intente hacerlo con Regex(no lo conocia) para que quede incluso en menos lineas pero nunca llegaba a cumplir todas las condiciones de la consigna 
        digitos=0
        minus=0
        mayus=0
        
        val = True
        
        if len(pw) < 8: 
            print('Debe tener minimo 8 caracteres') 
            val = False
            
        if len(pw) > 20: 
            print('Debe tener maximo 20 caracteres') 
            val = False
        for char in pw:
            if(char.isdigit()): 
                digitos=digitos+1
                

            if(char.isupper()): 
                mayus=mayus+1
                
            
            if(char.islower()): 
                minus=minus+1
                
        
        if(digitos > 3 and mayus > 2 and minus > 1):
            return True
        else:
            return False

    def generar_password(self):
        password="xxxxxxxx" #Cargo la cadena con mas de 8 caracteres para evitar el msje de la funcion anterior 
        while(self.es_fuerte(password) != True): #Genera varias contraseñas aleatorias hasta cumplir con los requisitos (no suelen ser muchos bucles)
            password = ''.join(random.choice(string.ascii_uppercase + string.digits + string.ascii_lowercase) for x in range(16))
            #print(f"PASSWORD : {password}") Con esto revisaba si cargaba bien el password aleatorio
        return password
    



