import java.lang.reflect.Array;
import java.util.Arrays;

public class Password {
        private int longitud;
        private String contrasenia;

        public Password()
        {

        }

    public Password(int longitud, String contrasenia)
    {
        this.longitud = longitud;
        this.contrasenia = contrasenia;
    }

    public int getLongitud()
    {
        return longitud;
    }

    public void setLongitud(int longitud)
    {
        this.longitud = longitud;
    }

    public String getContrasenia()
    {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia)
    {
        this.contrasenia = contrasenia;
    }

    public static boolean esFuerte(String pw)
    {
        int i;
        int mayus=0;
        int minus=0;
        int nums=0;
        boolean flag;
        for(i=0;i<pw.length();i++)
        {
           if(Character.isUpperCase(pw.charAt(i))) /**Chequea si el caracter devuelto por chatAt es una mayuscula si lo es se suma 1 */
            {
                mayus++;
            }
            if(Character.isLowerCase(pw.charAt(i)))
            {
                minus++;
            }
            if(Character.isDigit(pw.charAt(i)))
            {
                nums++;
            }
        }
        if(nums > 3 && mayus > 2 && minus > 1) /** Condicion que finalmente comprueba lo solicitado en la consigna*/
        {
            flag=true;
        }else
            flag = false;

        return flag;
    }

    public static String generarPassword(int longitud)
    {
         String nums = "012345678901234567890123456789"; /**No se si es pura casualidad pero al duplicar la cadena de nums
                                                        hay una mayor probabilidad que en la generacion aleatoria salga mas rápido con la condicion deseada**/

         String mayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

         String minus = mayus.toLowerCase();

         String psw=nums+mayus+minus;

         String pswd = "";

        for (int i = 0; i < longitud; i++)
        {
            pswd+=(psw.charAt((int)(Math.random() * psw.length())));
        }
        System.out.print("  PSWD : "+pswd);

        return pswd;
    }
    public static String generarPassValida()/**Ya es tarde pero por error de interpetación asumi que cuando generemos la contraseña iba a ser siempre 8 y no la longitud pasada por nosotros*/
    {                                       /**De todas formas lo modifique y aunque no lo aplique necesariamente al constructor,con llamar a la funcion 'generarpass' le pasamos la longitud deseada por parametro*/
        boolean flag=false;
        String generado= new String();
            while(flag ==false)
            {
                generado = generarPassword();
                if(esFuerte(generado) == true)
                {
                    flag=true;
                    System.out.print("GENERADO 'valido' :"+generado);
                }
            }
            return generado;/**De esta forma estamos generando un pass con 3 mayus,4 numeros y 1 minuscula*/
    }
}
