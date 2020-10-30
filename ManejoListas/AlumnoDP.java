import java.util.StringTokenizer;
import java.util.Date;

public class AlumnoDP
{
    // Atributos: Varaibles de Instancia o de Clase
    private String matricula, nombre,carrera;
    private float parcial1 , parcial2,parcial3,promedio;
    
    
    private AlumnoDP next; 


    // Constructores
    public AlumnoDP()
    {
        matricula  = "";
        nombre = "";
        carrera   = "";
        parcial1  = 0;
       	parcial2 = 0;
		parcial3 = 0;
		promedio=0;
    }
    
    public AlumnoDP(String datos)
    {
        StringTokenizer st = new StringTokenizer(datos,"_");
        
        matricula  = st.nextToken();
        nombre = st.nextToken();
        carrera   = st.nextToken();
        parcial1  = Float.parseFloat(st.nextToken());
        parcial2  = Float.parseFloat(st.nextToken());
        parcial3  = Float.parseFloat(st.nextToken());
        promedio  = Float.parseFloat(st.nextToken());
       
	
    }
    
    // Metodos: Accesors (geter's) y Mutators (seter's)
    // Accesors
    public String getMatricula()
    {
        return this.matricula;
    }
    
    public String getNombre()
    {
        return this.nombre;
    }
    
    public String getCarrera()
    {
        return this.carrera;
    }
    
    public float getParcial1()
    {
        return this.parcial1;
    }
      public float getParcial2()
    {
        return this.parcial2;
    }
    
      public float getParcial3()
    {
        return this.parcial3;
    }
      public float getPromedio()
    {
        return this.promedio;
    }
    
      public AlumnoDP getNext()
    {
        return this.next;
    }
    
    // Mutators
    public void setMatricula(String num)
    {
        this.matricula = num;
    }
    
    public void setNombre(String name)
    {
        this.nombre = name;
    }
     public void setCarrera(String car)
    {
        this.carrera = car;
    }
    public void setParcial1(float p1)
    {
        this.parcial1 = p1;
    }
       public void setParcial2(float p2)
    {
        this.parcial2 = p2;
    }
       public void setParcial3(float p3)
    {
        this.parcial3 = p3;
    }
       public void setPromedio(float prom)
    {
        this.promedio = prom;
    }
 
 
    public void setNext(AlumnoDP nodo){
    	this.next = nodo;
    }


    public String toString()
    {
        return this.matricula+"_"+this.nombre+"_"+this.carrera+"_"+this.parcial1+"_"+this.parcial2+"_"+this.parcial3+"_"+this.promedio;
    }
}












