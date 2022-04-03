#include <stdio.h>
#include <stdlib.h>
#include "string.h"
//PUNTO 1
int esPrimo(int a)///Se aplico practicamente el mismo razonamiento que para Python
{
    int flag=1;
    int i;
    for(i=2;i<a;i++)
    {
        if(a % i == 0)
        {
            flag=0;
        }
    }
    return flag;
}
//PUNTO 2
int checkContrasenia()
{
    char contrasenia[12];
    char contra[12];
    int rta[2];
    printf("Ingrese contrasena : "); ///Carga la contraseña por primera vez y se guarda en 'contrasenia'
    ///el gets tiraba error
    scanf("%s",&contrasenia);
    int i=0; ///Contador de los intentos
    int j=0; ///Contador para revisar las rtas
    int flag=0;
    strcpy(contra,contrasenia);

    while(i<3)
    {

        printf("Cargue nuevamente su contraseniaa ! Intento --> %d : ",i+1);
        scanf("%s",&contra);///se almacenan los intentos en la variable
        rta[i]=strcmp(contra,contrasenia);///strcmp devuelvo 0 si la cadena de caracteres es igual sino es que son distintas


        i++;
    }
    for(j=0;j<3;j++)
    {

        if(rta[j]!=0) ///Aplico la lógica mencionada arriba si en alguna posicion del arreglo el valor es distinto de 0,es porque le erró
        {
            flag=1;///Variable que controla si hubo algun error (si hubo cambia a 1)
        }

    }
    return flag;///Retorno lo que finalmente me dice si hubo error o no
}
//PUNTO 3
typedef struct{
    int valorHora;
    char nombre[30];
    int antiguedad;
    int cantHoras;
}empleado;

empleado cargaEmpleado() ///funcion simple de carga de una estructura y la retornamos
{
    empleado emp;
    printf("\nIngrese cobro por hora del empleado : ");
    scanf("%d",&emp.valorHora);
    printf("\nIngrese nombre del empleado : ");
    fflush(stdin);
    gets(emp.nombre);
    printf("\n Antiguedad del empleado : ");
    scanf("%d",&emp.antiguedad);
    printf("\n Cantidad de horas trabajadas en el mes : ");
    scanf("%d",&emp.cantHoras);

    return emp;
}
int calculoSalario(empleado emp)
{
    int salarioBase=emp.cantHoras*emp.valorHora;///Calcula el salario para cualquier empleado
    if(emp.antiguedad > 10) ///Si tiene mas de 10 años realiza la operación solicitada
    {
        salarioBase+=(emp.antiguedad*30);
    }
    return salarioBase;
}
//PUNTO 4
void aleatorio()
{
    srand (time(NULL));
    int rng = rand() % 1000+1; ////Va de 0 a 1000
    //printf("\nRNG : %d",rng); Variable para revisar exactamente que numero es
    int adivinar=-1;///Para que entre a la primer vuelta

    while(adivinar != rng)
    {
        printf("\nIngrese numero a adivinar : ");
        scanf("%d",&adivinar);
        if(adivinar == rng) ///Triple condicion pero siempre revisamos primero que sea correcto
        {
            printf("Correcto es el numero!");
        }
        if(adivinar>rng)
        {
            printf("\nEl numero ingresado es mayor ");
        }
        else if(adivinar !=rng)
        {
            printf("\nEl numero ingresado es menor ");
        }

    }

}
//PUNTO 5 (((Se me hizo mas comodo trabajarlo directamente con un array)))
int cargaNumeros(int a[],int dimension)
{
    int i=0;
    char control='s';
    while(i<dimension && control =='s') ///Funcion de carga normal hasta que el user ingrese una tecla distinta a 's'
    {
        printf("\nCargue numero : ");
        fflush(stdin);
        scanf("%d",&a[i]);

        printf("\n ¿Desea cargar otro? 's' para continuar :");
        fflush(stdin);
        scanf("%c",&control);
        i++;
    }
    return i;
}

int mayor(int a[],int validos)
{
    int may=0;
    int i;

    for(i=0;i<validos;i++)
    {
        if(a[i]>may)
        {
            may=a[i];
        }
    }
    return may;
}

int menor(int a[], int validos, int posInic) ///Si bien pude hacer algo muy similar a la funcion mayor,es una alternativa donde se trabaja con las posiciones
{
    int posMenor = posInic;
    int i;

    for(i=posInic+1; i<validos; i++)
    {
        if(a[posMenor] > a[i])
        {
            posMenor = i;
        }
    }
    return posMenor;
}

int sumaArreglo(int a[],int validos)
{
    int i;
    int suma=0;
    for(i=0;i<validos;i++)
    {
        suma = suma + a[i]; ///Suma con un acumulador
    }
    return suma;

}

int sumaArregloValor(int a[],int validos,int valor)
{
    int i;
    int suma=0;
    for(i=0;i<validos;i++)
    {
        if(valor==a[i])
        {
            suma = suma + a[i];
        }
    }
    return suma;
}
int main()
{
    ///////////Punto 1
    /*
    int valor=0;
    printf("Ingrese numero para ver si es primo : ");
    scanf("%d",&valor);
    int primo=esPrimo(valor);

    if(primo == 0)
    {
        printf("No es un numero primo");
    }else
        printf("Si es numero primo");
        */
    ///////////Punto 2

    int valor=checkContrasenia();
    if(valor==0)
    {
        printf("Felicitaciones recordas tu contraseña\n");
    }else
        printf("Tenes que ejercitar la memoria\n");
    system("pause"); ///Cumple la funcion de que el usuario toque alguna tecla para salir,tambien se puede usar getch()

    ///////////Punto 3
    /*
    empleado emp;
    emp=cargaEmpleado();
    int salarioFinal=calculoSalario(emp);
    printf("\n Salario $%d",salarioFinal);
    */
    ///////////Punto 4
    /*aleatorio();*/
    ///////////Punto 5
    /*
    int validos;
    int arregloEnteros[100];
    int men;
    int may;
    int suma;
    int sumaValor;
    validos=cargaNumeros(arregloEnteros,100);
    printf("\nValidos %d",validos);

    suma=sumaArreglo(arregloEnteros,validos);
    printf("\nSuma : %d",suma);

    men=menor(arregloEnteros,validos,0);///La posicion inicial 0
    printf("\nMenor %d",arregloEnteros[men]);

    may=mayor(arregloEnteros,validos);
    printf("\nMayor %d",may);

    int valorUnico;
    printf("\nIngrese valor unico a sumar : ");
    fflush(stdin);
    scanf("%d",&valorUnico);
    sumaValor=sumaArregloValor(arregloEnteros,validos,valorUnico);
    printf("\nValor unico sumado : %d",sumaValor);
    */

}
