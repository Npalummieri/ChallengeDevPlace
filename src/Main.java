import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.lang.Math;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        /**Punto 1
        if(esPrimo())
        {
            System.out.println("El numero ES primo!");
        }else
        {
            System.out.println("El numero NO es primo!");
        }
         */
        /**Punto 2
        if(checkMemoria())
        {
            System.out.println("Ejercita la memoria!");
        }else
        {
            System.out.println("Felicitaciones cargaste bien la contraseña!");
        }
         */
        /**Punto 3  Me parecio más practico hacerlo con clases y objetos que con una struct
        Empleado empleado=new Empleado();
        empleado.cargaEmpleado();
        empleado.toString();
        System.out.println(empleado.calculoSalario());
         */
        /**Punto 4
        adivina();
         */

        /**Punto 5

        ArrayList enteros=new ArrayList();
        valoresNumeros(enteros);
        System.out.print(enteros);
        int mayor=(int)Collections.max(enteros);/** Se puede modularizar haciendo una funcion entera que vaya buscando el menor/mayor en un for como en C por ejemplo pero asi es mas sencillo*/
        /**
        int menor= (int) Collections.min(enteros);
        int suma=sumaTodo(enteros);
        int sumaFiltro;
        System.out.print("\nMayor :  "+mayor+"    || Menor : %d : "+menor+"");
        System.out.print("\nSuma :"+suma);

        System.out.print("\nIngrese valor unico a sumar :");
        int valor=scan.nextInt();
        sumaFiltro=sumaFiltrada(enteros,valor);
        System.out.print("\nSuma filtrada :"+sumaFiltro);
        */

        /**Punto POO
        System.out.print("Ingrese contraseña :");
        String pass = scan.next();
        Password contra = new Password(8,pass);

        System.out.print(contra.esFuerte(contra.getContrasenia()));
         */
        Password contraRandom=new Password(8,"");
        String randomPW;
        randomPW=contraRandom.generarPassValida();
        contraRandom.setContrasenia(randomPW);

    }

    /**Punto 1 */
    static public boolean esPrimo()
    {


        boolean primo = true;
        int i;
        System.out.println("Ingrese numero : ");
        int ingresado = scan.nextInt();
        for (i = 2; i < ingresado; i++)
        {
            if (ingresado % i == 0)
            {
                primo = false;
            }
        }
        return primo;
    }
    /**Punto 2 */
        static public boolean checkMemoria ()
        {
            String contra=new String();
            String contrasenia=new String();

            System.out.println("Ingrese su contraseña :");
            contrasenia= scan.next();


            int i = 0;
            boolean flag = false;
            while (i < 3)/** Aca tengo que usar equals y no == por el hecho de que me compare las cadenas literal y no su instancia**/
            {
                System.out.println("Cargue su contraseña nuevamente :");
                contra = scan.next();
                if (!contrasenia.equals(contra))
                {
                    flag = true;
                }
                i++;
                System.out.println(flag);
            }
            System.out.println("Presiona cualquier tecla para salir...");
            scan.nextLine();
            return flag;
        }

    /**Punto 4 */
        static public void adivina()
        {
            int random= (int) (Math.floor(Math.random() * (1000- 0 + 1)) + 0);
            System.out.print("RANDOM : "+random);
            int adivinado;
            System.out.print("\nIngrese valor : ");
            adivinado=scan.nextInt();
            while(adivinado != random)
            {
                if(adivinado > random)
                {
                    System.out.print("Su numero es mayor! ");
                }else
                {
                    System.out.print("Su numero es menor! ");
                }
                System.out.print("\nIngrese valor : ");
                adivinado=scan.nextInt();
            }
            System.out.print("Felicitaciones,adivino! ");
        }
    /**Punto 5 */
        static public ArrayList valoresNumeros(ArrayList numeros)
        {
            int agregar=0;

            while(agregar != -1)
            {
                System.out.print("Ingrese un numero a cargar ,si desea salir ingrese -1:");
                agregar=scan.nextInt();
                numeros.add(agregar);
            }
            numeros.remove(numeros.size()-1);/**Remuevo el -1 de la ultima posicion ya que lo utilizo justo arriba como metodo de salida y se me agrega al ArrayList*/


        return numeros;

        }
        static public int sumaTodo(ArrayList numeros)
        {
            int i;
            int suma=0;
            for(i=0; i<numeros.size() ; i++)
            {
                suma = suma + (int)numeros.get(i);
            }
            return suma;
        }

    static public int sumaFiltrada(ArrayList numeros,int valor)
    {
        int i;
        int suma=0;

        for(i=0; i<numeros.size() ; i++)
        {
            if(valor == (int)numeros.get(i))
            suma = suma + (int)numeros.get(i);
        }
        return suma;
    }


        }






