import java.util.Scanner;

public class Empleado {
    private int valorHora;
    private String nombre;
    private int horasMes;
    private int antiguedad;

    public Empleado() /**Constructor vacio por si acaso*/
    {

    }

    public Empleado(int valorHora,String nombre,int horasMes,int antiguedad)
    {
        this.valorHora = valorHora;
        this.nombre = nombre;
        this.horasMes = horasMes;
        this.antiguedad = antiguedad;
    }

    public int getValorHora()
    {
        return valorHora;
    }

    public void setValorHora(int valorHora)
    {
        this.valorHora = valorHora;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getHorasMes()
    {
        return horasMes;
    }

    public void setHorasMes(int horasMes)
    {
        this.horasMes = horasMes;
    }

    public int getAntiguedad()
    {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad)
    {
        this.antiguedad = antiguedad;
    }

    @Override /**Con esto se muestra la informacion del objeto en un string*/
    public String toString() {
        return "Empleado{"+"valorHora=" +valorHora + ",nombre='" +nombre + "horasMes=" +horasMes + "antiguedad=" +antiguedad+ '}';
    }
    Scanner scan=new Scanner(System.in);
    public void cargaEmpleado()
    {
        System.out.println("Ingrese el valor por hora del empleado");
        setValorHora(scan.nextInt());

        System.out.println("Ingrese el nombre del empleado");
        setNombre(scan.next());

        System.out.println("Ingrese cantidad de horas al mes  del empleado");
        setHorasMes(scan.nextInt());

        System.out.println("Ingrese antiguedad del empleado");
        setAntiguedad(scan.nextInt());


    }
    public float calculoSalario()
    {
        float salario = getValorHora() * getHorasMes();
        if(antiguedad> 10)
        {
            salario=salario + (getAntiguedad() * 30);
        }
        return salario;
    }
}
