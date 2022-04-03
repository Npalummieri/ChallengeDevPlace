from operator import index, indexOf
import random

#Punto 3
def empleado_salario(valorHora):
    nombre=input("Ingrese nombre del empleado : ")
    antiguedad=int(input("Ingrese antiguedad del empleado : "))
    horas_trabajadas=int(input("Ingrese total de horas trabajadas al mes : "))

    salario=horas_trabajadas*valorHora
    if(antiguedad > 10):
        salario += (valorHora*antiguedad)


    return f"Empleado : {nombre} con {antiguedad} años de antiguedad,deberá cobrar {salario}"
#Punto 4
def adivinanza():
    rta=random.randint(0,1000)
    adivinar=-1

    while(adivinar != rta):
        adivinar=int(input("Que numero es ? "))
        if(adivinar != rta):
            if(adivinar > rta):
                 print("Es mas chico que lo ingresado")
            else:
                print("Es mayor al ingresado!")
        if(adivinar == rta):
                print("Felicitaciones el numero es correeto")    
#Punto 5
def datos_valores():
    numeros=[]
    numero=0
    while(numero != -1):
        numero=(int(input("\nIngrese un numero : ")))
        numeros.append(numero)
    
    numeros.remove(-1) #Tambien se podria llegar a eliminar con len -1 eliminando el elemento de la ultima posicion

    print(numeros)

    maximo=int(max(numeros))
    print(f"MAXIMO : {maximo}")

    minimo=int(min(numeros))
    print(f"\nMINIMO : {minimo}")

    suma_total=0
    for suma in numeros:
        
        suma_total =suma_total + suma
        
    print(f"SUMA TOTAL :{suma_total}") 
    
    valor=int(input("Ingrese valor a filtrar sumado : "))
    suma_valor_total=0
    for suma in numeros:
        if suma == valor:
            suma_valor_total +=  suma
        
    print(f"Suma del valor filtrado {valor} da como resultado {suma_valor_total}") 

"""Punto 3
valor_hora=int(input("Ingrese valor por hora de su empleado : "))
print(empleado_salario(valor_hora))
"""
"""Punto 4
adivinanza()
"""

"""Punto 5 
datos_valores()
"""